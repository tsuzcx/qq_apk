package com.tencent.luggage.e;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  final LinkedList<Class<? extends a>> bij = new LinkedList();
  
  public final void x(List<Class<? extends a>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Class localClass = (Class)paramList.next();
      this.bij.add(localClass);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.e.d
 * JD-Core Version:    0.7.0.1
 */