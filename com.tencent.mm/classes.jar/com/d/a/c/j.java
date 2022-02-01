package com.d.a.c;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class j
{
  private c clY;
  protected int clZ;
  protected int cma;
  
  public j(c paramc)
  {
    this.clY = paramc;
    this.clZ = this.clY.size();
    this.cma = this.clY.vh();
  }
  
  protected final void Lr()
  {
    int i = nextIndex();
    this.cma = i;
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
    if (this.clZ != this.clY.size()) {
      throw new ConcurrentModificationException();
    }
    this.clY.Lm();
    try
    {
      this.clY.aK(this.cma);
      this.clY.Ln();
      this.clZ -= 1;
      return;
    }
    finally
    {
      this.clY.Ln();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.j
 * JD-Core Version:    0.7.0.1
 */