package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j
{
  public final Format cHc;
  public final long cHg;
  public final int cMd;
  public final long cRM;
  public final long cRN;
  public final int cRO;
  public final long[] cRP;
  public final long[] cRQ;
  private final k[] cRR;
  public final int id;
  public final int type;
  
  public j(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, k[] paramArrayOfk, int paramInt4, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.cRM = paramLong1;
    this.cRN = paramLong2;
    this.cHg = paramLong3;
    this.cHc = paramFormat;
    this.cRO = paramInt3;
    this.cRR = paramArrayOfk;
    this.cMd = paramInt4;
    this.cRP = paramArrayOfLong1;
    this.cRQ = paramArrayOfLong2;
  }
  
  public final k hM(int paramInt)
  {
    if (this.cRR == null) {
      return null;
    }
    return this.cRR[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.j
 * JD-Core Version:    0.7.0.1
 */