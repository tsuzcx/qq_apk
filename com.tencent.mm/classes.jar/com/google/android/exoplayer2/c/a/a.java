package com.google.android.exoplayer2.c.a;

final class a
  implements b.a
{
  private final long auP;
  private final int bitrate;
  private final long firstFramePosition;
  
  public a(long paramLong1, int paramInt, long paramLong2)
  {
    this.firstFramePosition = paramLong1;
    this.bitrate = paramInt;
    if (paramLong2 == -1L) {}
    for (paramLong1 = -9223372036854775807L;; paramLong1 = F(paramLong2))
    {
      this.auP = paramLong1;
      return;
    }
  }
  
  public final long F(long paramLong)
  {
    return Math.max(0L, paramLong - this.firstFramePosition) * 1000000L * 8L / this.bitrate;
  }
  
  public final boolean lS()
  {
    return this.auP != -9223372036854775807L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.a
 * JD-Core Version:    0.7.0.1
 */