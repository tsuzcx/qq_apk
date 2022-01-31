package com.tencent.mm.plugin.game.model;

import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends h
{
  protected i(String paramString)
  {
    super(paramString);
  }
  
  public final void aZh()
  {
    LinkedList localLinkedList = q(optJSONArray("items"));
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      locald.cO(locald.kNX);
    }
    com.tencent.mm.plugin.game.f.d.Y(localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.i
 * JD-Core Version:    0.7.0.1
 */