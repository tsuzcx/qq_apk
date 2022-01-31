package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.i.t;

final class d
  implements b.a
{
  private final long auP;
  private final long azG;
  private final long[] azH;
  private final long azI;
  private final int azJ;
  private final long firstFramePosition;
  
  d(long paramLong1, long paramLong2, long paramLong3)
  {
    this(paramLong1, paramLong2, paramLong3, null, 0L, 0);
  }
  
  d(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, long paramLong4, int paramInt)
  {
    this.firstFramePosition = paramLong1;
    this.auP = paramLong2;
    this.azG = paramLong3;
    this.azH = paramArrayOfLong;
    this.azI = paramLong4;
    this.azJ = paramInt;
  }
  
  private long cS(int paramInt)
  {
    return this.auP * paramInt / 100L;
  }
  
  public final long F(long paramLong)
  {
    if ((!lS()) || (paramLong < this.firstFramePosition)) {
      return 0L;
    }
    double d = 256.0D * (paramLong - this.firstFramePosition) / this.azI;
    int i = t.a(this.azH, d, false) + 1;
    long l2 = cS(i);
    long l1;
    label77:
    long l3;
    if (i == 0)
    {
      paramLong = 0L;
      if (i != 99) {
        break label114;
      }
      l1 = 256L;
      l3 = cS(i + 1);
      if (l1 != paramLong) {
        break label126;
      }
    }
    label114:
    label126:
    for (paramLong = 0L;; paramLong = ((l3 - l2) * (d - paramLong) / (l1 - paramLong)))
    {
      return l2 + paramLong;
      paramLong = this.azH[(i - 1)];
      break;
      l1 = this.azH[i];
      break label77;
    }
  }
  
  public final boolean lS()
  {
    return this.azH != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.d
 * JD-Core Version:    0.7.0.1
 */