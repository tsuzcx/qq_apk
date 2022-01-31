package com.tencent.mm.plugin.game.commlib.c;

import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<b> gOl = new LinkedList();
  
  public static void a(b paramb)
  {
    gOl.add(paramb);
  }
  
  public static void aYt()
  {
    Iterator localIterator = gOl.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).aYu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.c.a
 * JD-Core Version:    0.7.0.1
 */