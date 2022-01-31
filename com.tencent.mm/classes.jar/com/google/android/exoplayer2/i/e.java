package com.google.android.exoplayer2.i;

import java.util.Arrays;

public final class e
{
  private long[] aSn = new long[32];
  private int size;
  
  public e()
  {
    this((byte)0);
  }
  
  private e(byte paramByte) {}
  
  public final void add(long paramLong)
  {
    if (this.size == this.aSn.length) {
      this.aSn = Arrays.copyOf(this.aSn, this.size * 2);
    }
    long[] arrayOfLong = this.aSn;
    int i = this.size;
    this.size = (i + 1);
    arrayOfLong[i] = paramLong;
  }
  
  public final long[] toArray()
  {
    return Arrays.copyOf(this.aSn, this.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.i.e
 * JD-Core Version:    0.7.0.1
 */