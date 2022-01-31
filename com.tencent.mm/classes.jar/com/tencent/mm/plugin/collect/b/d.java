package com.tencent.mm.plugin.collect.b;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum d
{
  public List<a> fKm = new LinkedList();
  
  private d() {}
  
  public final void a(t paramt)
  {
    Iterator localIterator = this.fKm.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.b(paramt);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(t paramt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.d
 * JD-Core Version:    0.7.0.1
 */