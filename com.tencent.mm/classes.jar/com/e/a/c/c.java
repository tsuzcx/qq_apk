package com.e.a.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

abstract class c<V>
  extends i
  implements Iterator<V>
{
  private n cfI;
  
  public c(n paramn)
  {
    super(paramn);
    this.cfI = paramn;
  }
  
  protected abstract V go(int paramInt);
  
  public V next()
  {
    BD();
    return go(this.cfW);
  }
  
  protected final int nextIndex()
  {
    if (this.cfV != this.cfI.size()) {
      throw new ConcurrentModificationException();
    }
    Object[] arrayOfObject = this.cfI.cgb;
    int j;
    for (int i = this.cfW;; i = j)
    {
      j = i - 1;
      if ((i <= 0) || ((arrayOfObject[j] != null) && (arrayOfObject[j] != n.cgd))) {
        return j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.c.c
 * JD-Core Version:    0.7.0.1
 */