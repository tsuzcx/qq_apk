package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j
{
  public final Format aNg;
  public final long aNk;
  public final int aSh;
  public final long aXQ;
  public final long aXR;
  public final int aXS;
  public final long[] aXT;
  public final long[] aXU;
  private final k[] aXV;
  public final int id;
  public final int type;
  
  public j(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, k[] paramArrayOfk, int paramInt4, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.aXQ = paramLong1;
    this.aXR = paramLong2;
    this.aNk = paramLong3;
    this.aNg = paramFormat;
    this.aXS = paramInt3;
    this.aXV = paramArrayOfk;
    this.aSh = paramInt4;
    this.aXT = paramArrayOfLong1;
    this.aXU = paramArrayOfLong2;
  }
  
  public final k ew(int paramInt)
  {
    if (this.aXV == null) {
      return null;
    }
    return this.aXV[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.j
 * JD-Core Version:    0.7.0.1
 */