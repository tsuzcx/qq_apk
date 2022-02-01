package com.d.a.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

abstract class c<V>
  extends i
  implements Iterator<V>
{
  private n bXM;
  
  public c(n paramn)
  {
    super(paramn);
    this.bXM = paramn;
  }
  
  protected abstract V gA(int paramInt);
  
  public V next()
  {
    At();
    return gA(this.bYa);
  }
  
  protected final int nextIndex()
  {
    if (this.bXZ != this.bXM.size()) {
      throw new ConcurrentModificationException();
    }
    Object[] arrayOfObject = this.bXM.bYf;
    int j;
    for (int i = this.bYa;; i = j)
    {
      j = i - 1;
      if ((i <= 0) || ((arrayOfObject[j] != null) && (arrayOfObject[j] != n.bYh))) {
        return j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.c
 * JD-Core Version:    0.7.0.1
 */