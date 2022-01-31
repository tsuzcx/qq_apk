package com.google.android.exoplayer2.c.a;

final class c
  implements b.a
{
  private final long auP;
  private final long[] ayX;
  private final long[] azF;
  
  c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.ayX = paramArrayOfLong1;
    this.azF = paramArrayOfLong2;
    this.auP = paramLong;
  }
  
  public final long F(long paramLong)
  {
    return this.ayX[com.google.android.exoplayer2.i.t.a(this.azF, paramLong, true)];
  }
  
  public final boolean lS()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.c
 * JD-Core Version:    0.7.0.1
 */