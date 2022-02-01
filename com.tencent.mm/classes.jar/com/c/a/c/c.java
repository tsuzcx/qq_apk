package com.c.a.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

abstract class c<V>
  extends i
  implements Iterator<V>
{
  private n cqk;
  
  public c(n paramn)
  {
    super(paramn);
    this.cqk = paramn;
  }
  
  protected abstract V hz(int paramInt);
  
  public V next()
  {
    Kw();
    return hz(this.cqx);
  }
  
  protected final int nextIndex()
  {
    if (this.cqw != this.cqk.size()) {
      throw new ConcurrentModificationException();
    }
    Object[] arrayOfObject = this.cqk.cqC;
    int j;
    for (int i = this.cqx;; i = j)
    {
      j = i - 1;
      if ((i <= 0) || ((arrayOfObject[j] != null) && (arrayOfObject[j] != n.cqE))) {
        return j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.c.c
 * JD-Core Version:    0.7.0.1
 */