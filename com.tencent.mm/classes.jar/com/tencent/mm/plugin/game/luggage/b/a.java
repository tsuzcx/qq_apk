package com.tencent.mm.plugin.game.luggage.b;

import java.util.LinkedList;

public final class a
{
  private static LinkedList<Class<? extends com.tencent.luggage.e.a>> iRP;
  
  private static void O(Class<? extends com.tencent.luggage.e.a> paramClass)
  {
    iRP.add(paramClass);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.e.a>> aGk()
  {
    try
    {
      iRP = new LinkedList();
      O(b.class);
      O(c.class);
      O(d.class);
      O(e.class);
      O(f.class);
      O(h.class);
      O(i.class);
      O(j.class);
      O(k.class);
      O(n.class);
      O(l.class);
      O(m.class);
      O(g.class);
      LinkedList localLinkedList = iRP;
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.a
 * JD-Core Version:    0.7.0.1
 */