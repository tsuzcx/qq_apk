package com.d.a.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

abstract class d<V>
  extends j
  implements Iterator<V>
{
  private o clN;
  
  public d(o paramo)
  {
    super(paramo);
    this.clN = paramo;
  }
  
  protected abstract V it(int paramInt);
  
  public V next()
  {
    Lr();
    return it(this.cma);
  }
  
  protected final int nextIndex()
  {
    if (this.clZ != this.clN.size()) {
      throw new ConcurrentModificationException();
    }
    Object[] arrayOfObject = this.clN.cmf;
    int j;
    for (int i = this.cma;; i = j)
    {
      j = i - 1;
      if ((i <= 0) || ((arrayOfObject[j] != null) && (arrayOfObject[j] != o.cmh))) {
        return j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.d
 * JD-Core Version:    0.7.0.1
 */