package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j
{
  public final Format aTo;
  public final long aTs;
  public final int aYl;
  public final long bdY;
  public final long bdZ;
  public final int bea;
  public final long[] beb;
  public final long[] bec;
  private final k[] bed;
  public final int id;
  public final int type;
  
  public j(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, k[] paramArrayOfk, int paramInt4, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.bdY = paramLong1;
    this.bdZ = paramLong2;
    this.aTs = paramLong3;
    this.aTo = paramFormat;
    this.bea = paramInt3;
    this.bed = paramArrayOfk;
    this.aYl = paramInt4;
    this.beb = paramArrayOfLong1;
    this.bec = paramArrayOfLong2;
  }
  
  public final k ek(int paramInt)
  {
    if (this.bed == null) {
      return null;
    }
    return this.bed[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.j
 * JD-Core Version:    0.7.0.1
 */