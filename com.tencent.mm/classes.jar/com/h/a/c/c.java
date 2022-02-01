package com.h.a.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

abstract class c<V>
  extends i
  implements Iterator<V>
{
  private n ecf;
  
  public c(n paramn)
  {
    super(paramn);
    this.ecf = paramn;
  }
  
  protected abstract V lX(int paramInt);
  
  public V next()
  {
    als();
    return lX(this.ecs);
  }
  
  protected final int nextIndex()
  {
    if (this.ecr != this.ecf.size()) {
      throw new ConcurrentModificationException();
    }
    Object[] arrayOfObject = this.ecf.ecx;
    int j;
    for (int i = this.ecs;; i = j)
    {
      j = i - 1;
      if ((i <= 0) || ((arrayOfObject[j] != null) && (arrayOfObject[j] != n.ecz))) {
        return j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.h.a.c.c
 * JD-Core Version:    0.7.0.1
 */