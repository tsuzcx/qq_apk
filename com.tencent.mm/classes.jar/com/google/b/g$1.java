package com.google.b;

import java.util.NoSuchElementException;

final class g$1
  extends g.a
{
  private final int limit = this.bPj.size();
  private int position = 0;
  
  g$1(g paramg) {}
  
  public final boolean hasNext()
  {
    return this.position < this.limit;
  }
  
  public final byte nextByte()
  {
    int i = this.position;
    if (i >= this.limit) {
      throw new NoSuchElementException();
    }
    this.position = (i + 1);
    return this.bPj.gv(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.g.1
 * JD-Core Version:    0.7.0.1
 */