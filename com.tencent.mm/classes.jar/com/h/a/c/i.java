package com.h.a.c;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class i
{
  private b ecq;
  protected int ecr;
  protected int ecs;
  
  public i(b paramb)
  {
    this.ecq = paramb;
    this.ecr = this.ecq.size();
    this.ecs = this.ecq.UG();
  }
  
  protected final void als()
  {
    int i = nextIndex();
    this.ecs = i;
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
    if (this.ecr != this.ecq.size()) {
      throw new ConcurrentModificationException();
    }
    this.ecq.aln();
    try
    {
      this.ecq.bj(this.ecs);
      this.ecq.alo();
      this.ecr -= 1;
      return;
    }
    finally
    {
      this.ecq.alo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.h.a.c.i
 * JD-Core Version:    0.7.0.1
 */