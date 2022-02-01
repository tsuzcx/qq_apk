package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j
{
  public final Format bdI;
  public final long bdM;
  public final int biG;
  public final long bot;
  public final long bou;
  public final int bov;
  public final long[] bow;
  public final long[] box;
  private final k[] boy;
  public final int id;
  public final int type;
  
  public j(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, k[] paramArrayOfk, int paramInt4, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.bot = paramLong1;
    this.bou = paramLong2;
    this.bdM = paramLong3;
    this.bdI = paramFormat;
    this.bov = paramInt3;
    this.boy = paramArrayOfk;
    this.biG = paramInt4;
    this.bow = paramArrayOfLong1;
    this.box = paramArrayOfLong2;
  }
  
  public final k eo(int paramInt)
  {
    if (this.boy == null) {
      return null;
    }
    return this.boy[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.j
 * JD-Core Version:    0.7.0.1
 */