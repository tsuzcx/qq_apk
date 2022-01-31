package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j
{
  public final int aCh;
  public final long aHU;
  public final long aHV;
  public final int aHW;
  public final long[] aHX;
  public final long[] aHY;
  private final k[] aHZ;
  public final Format axd;
  public final long axh;
  public final int id;
  public final int type;
  
  public j(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, k[] paramArrayOfk, int paramInt4, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.aHU = paramLong1;
    this.aHV = paramLong2;
    this.axh = paramLong3;
    this.axd = paramFormat;
    this.aHW = paramInt3;
    this.aHZ = paramArrayOfk;
    this.aCh = paramInt4;
    this.aHX = paramArrayOfLong1;
    this.aHY = paramArrayOfLong2;
  }
  
  public final k dz(int paramInt)
  {
    if (this.aHZ == null) {
      return null;
    }
    return this.aHZ[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.j
 * JD-Core Version:    0.7.0.1
 */