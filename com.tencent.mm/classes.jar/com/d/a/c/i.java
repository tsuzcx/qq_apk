package com.d.a.c;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class i
{
  private b bXY;
  protected int bXZ;
  protected int bYa;
  
  public i(b paramb)
  {
    this.bXY = paramb;
    this.bXZ = this.bXY.size();
    this.bYa = this.bXY.capacity();
  }
  
  protected final void At()
  {
    int i = nextIndex();
    this.bYa = i;
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
    if (this.bXZ != this.bXY.size()) {
      throw new ConcurrentModificationException();
    }
    this.bXY.Ao();
    try
    {
      this.bXY.removeAt(this.bYa);
      this.bXY.Ap();
      this.bXZ -= 1;
      return;
    }
    finally
    {
      this.bXY.Ap();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */