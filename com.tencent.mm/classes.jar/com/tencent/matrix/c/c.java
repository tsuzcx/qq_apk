package com.tencent.matrix.c;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private static final List<a> mListeners = new LinkedList();
  
  public static void a(a parama)
  {
    synchronized (mListeners)
    {
      mListeners.add(parama);
      return;
    }
  }
  
  public static void ayE()
  {
    synchronized (mListeners)
    {
      Iterator localIterator = mListeners.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).ayF();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ayF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c.c
 * JD-Core Version:    0.7.0.1
 */