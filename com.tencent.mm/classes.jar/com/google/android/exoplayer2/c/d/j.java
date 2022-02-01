package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j
{
  public final Format aSv;
  public final long aSz;
  public final int aXz;
  public final long bdm;
  public final long bdn;
  public final int bdo;
  public final long[] bdp;
  public final long[] bdq;
  private final k[] bdr;
  public final int id;
  public final int type;
  
  public j(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, k[] paramArrayOfk, int paramInt4, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.bdm = paramLong1;
    this.bdn = paramLong2;
    this.aSz = paramLong3;
    this.aSv = paramFormat;
    this.bdo = paramInt3;
    this.bdr = paramArrayOfk;
    this.aXz = paramInt4;
    this.bdp = paramArrayOfLong1;
    this.bdq = paramArrayOfLong2;
  }
  
  public final k ek(int paramInt)
  {
    if (this.bdr == null) {
      return null;
    }
    return this.bdr[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.j
 * JD-Core Version:    0.7.0.1
 */