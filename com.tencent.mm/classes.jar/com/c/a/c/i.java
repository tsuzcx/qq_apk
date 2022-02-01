package com.c.a.c;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class i
{
  private b cqv;
  protected int cqw;
  protected int cqx;
  
  public i(b paramb)
  {
    this.cqv = paramb;
    this.cqw = this.cqv.size();
    this.cqx = this.cqv.capacity();
  }
  
  protected final void Kw()
  {
    int i = nextIndex();
    this.cqx = i;
    if (i < 0) {
      throw new NoSuchElementException();
    }
  }
  
  public boolean hasNext()
  {
    return nextIndex() >= 0;
  }
  
  protected abstract int nextIndex();
  
  public void remove()
  {
    if (this.cqw != this.cqv.size()) {
      throw new ConcurrentModificationException();
    }
    this.cqv.Kr();
    try
    {
      this.cqv.removeAt(this.cqx);
      this.cqv.Ks();
      this.cqw -= 1;
      return;
    }
    finally
    {
      this.cqv.Ks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.c.i
 * JD-Core Version:    0.7.0.1
 */