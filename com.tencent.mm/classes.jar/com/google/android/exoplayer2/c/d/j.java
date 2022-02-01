package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j
{
  public final Format bdF;
  public final long bdJ;
  public final int biD;
  public final long boo;
  public final long bop;
  public final int boq;
  public final long[] bor;
  public final long[] bos;
  private final k[] bot;
  public final int id;
  public final int type;
  
  public j(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, k[] paramArrayOfk, int paramInt4, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.boo = paramLong1;
    this.bop = paramLong2;
    this.bdJ = paramLong3;
    this.bdF = paramFormat;
    this.boq = paramInt3;
    this.bot = paramArrayOfk;
    this.biD = paramInt4;
    this.bor = paramArrayOfLong1;
    this.bos = paramArrayOfLong2;
  }
  
  public final k ei(int paramInt)
  {
    if (this.bot == null) {
      return null;
    }
    return this.bot[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.j
 * JD-Core Version:    0.7.0.1
 */