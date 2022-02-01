package com.d.a.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

abstract class c<V>
  extends i
  implements Iterator<V>
{
  private n bVu;
  
  public c(n paramn)
  {
    super(paramn);
    this.bVu = paramn;
  }
  
  protected abstract V gl(int paramInt);
  
  public V next()
  {
    Ag();
    return gl(this.bVI);
  }
  
  protected final int nextIndex()
  {
    if (this.bVH != this.bVu.size()) {
      throw new ConcurrentModificationException();
    }
    Object[] arrayOfObject = this.bVu.bVN;
    int j;
    for (int i = this.bVI;; i = j)
    {
      j = i - 1;
      if ((i <= 0) || ((arrayOfObject[j] != null) && (arrayOfObject[j] != n.bVP))) {
        return j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.c
 * JD-Core Version:    0.7.0.1
 */