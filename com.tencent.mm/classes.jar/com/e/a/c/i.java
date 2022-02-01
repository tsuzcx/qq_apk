package com.e.a.c;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class i
{
  private b cfU;
  protected int cfV;
  protected int cfW;
  
  public i(b paramb)
  {
    this.cfU = paramb;
    this.cfV = this.cfU.size();
    this.cfW = this.cfU.capacity();
  }
  
  protected final void BD()
  {
    int i = nextIndex();
    this.cfW = i;
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
    if (this.cfV != this.cfU.size()) {
      throw new ConcurrentModificationException();
    }
    this.cfU.By();
    try
    {
      this.cfU.removeAt(this.cfW);
      this.cfU.Bz();
      this.cfV -= 1;
      return;
    }
    finally
    {
      this.cfU.Bz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.c.i
 * JD-Core Version:    0.7.0.1
 */