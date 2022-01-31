package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.Format;

public final class e
{
  public final int aBL;
  public final long aCA;
  public final int aCB;
  public final long[] aCC;
  public final long[] aCD;
  private final f[] aCE;
  public final long aCz;
  public final Format auL;
  public final long auP;
  public final int id;
  public final int type;
  
  public e(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, f[] paramArrayOff, int paramInt4, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.aCz = paramLong1;
    this.aCA = paramLong2;
    this.auP = paramLong3;
    this.auL = paramFormat;
    this.aCB = paramInt3;
    this.aCE = paramArrayOff;
    this.aBL = paramInt4;
    this.aCC = paramArrayOfLong1;
    this.aCD = paramArrayOfLong2;
  }
  
  public final f cY(int paramInt)
  {
    if (this.aCE == null) {
      return null;
    }
    return this.aCE[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.e
 * JD-Core Version:    0.7.0.1
 */