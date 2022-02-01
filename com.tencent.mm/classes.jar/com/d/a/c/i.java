package com.d.a.c;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class i
{
  private b bVG;
  protected int bVH;
  protected int bVI;
  
  public i(b paramb)
  {
    this.bVG = paramb;
    this.bVH = this.bVG.size();
    this.bVI = this.bVG.capacity();
  }
  
  protected final void Ag()
  {
    int i = nextIndex();
    this.bVI = i;
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
    if (this.bVH != this.bVG.size()) {
      throw new ConcurrentModificationException();
    }
    this.bVG.Ab();
    try
    {
      this.bVG.removeAt(this.bVI);
      this.bVG.Ac();
      this.bVH -= 1;
      return;
    }
    finally
    {
      this.bVG.Ac();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */