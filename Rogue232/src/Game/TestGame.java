package Game;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class TestGame extends TestCase {

	public void testWorldConstructor() {
		// TODO: transferer dans TestWorld quand il existera
		World world = new World("maps/smallWorld.txt");
		ArrayList<char[]> data = new ArrayList<char[]>();
		char[] array = { '|', '-', '-', '-', '|' };
		char[] array2 = { '|', '.', '.', '.', '|' };
		char[] array3 = { '|', '.', '.', '+', '|' };
		char[] array4 = { '|', '.', '.', '.', '|' };
		char[] array5 = { '|', '-', '-', '-', '|' };
		char[][] a = { array, array2, array3, array4, array5 };
		for (char[] c : a) {
			data.add(c);
		}
		ArrayList<char[]> data2 = world.getData();
		for (int i = 0; i < data.size(); ++i) {
			assertTrue(Arrays.equals(data.get(i), data2.get(i)));
		}
	}

	public void testMove() {
		Game myGame = new Game("maps/smallWorld.txt");
		myGame.move(myGame.getHero().getPosition(), new Coord(-1, 0));

		myGame.move(myGame.getHero().getPosition(), new Coord(-1, 0));

		assertTrue(myGame.getHero().getPosition().equals(new Coord(1, 2)));
	}

	public void testOpen() {
		Game myGame = new Game("maps/smallWorld.txt");
		myGame.open(myGame.getHero().getPosition(), new Coord(1, 0));
		assertTrue((myGame.getWorld().getChar(new Coord(3, 2))) == '/');
	}

	public void testHp() {
		Game myGame = new Game("maps/smallWorld.txt");
		myGame.move(myGame.getHero().getPosition(), new Coord(0, -1));
		assertEquals(95, myGame.getHero().getHp());
	}

	public void testFight() {
		//v�rifier lorsque le personnage meurt si on sort du jeu = arr�t jeu
		Game myGame = new Game("maps/smallWorld.txt");
		Character hero = new Character(new Coord(3,3), '@', 100, 20, 0);
		Character monster1 = new Character(new Coord(2,3), 'a', 40, 40, 0);
		Character monster2 = new Character(new Coord(3,2), 'a', 40, 40, 0);
		Character monster3 = new Character(new Coord(3,4), 'a', 40, 20, 0);
		myGame.fight(hero, monster1);
		assertTrue(!(hero.isDead())); //isalive
		myGame.fight(hero, monster2);
		assertTrue(!(hero.isDead())); //isAlwaysAlive
		myGame.fight(hero, monster3);
		assertTrue(hero.isDead()); //isDead systemOut GameOver
	}

}
