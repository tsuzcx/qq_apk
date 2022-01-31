package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;

@TargetApi(16)
public final class d
{
  final d.a aTU;
  final boolean aTV;
  final long aTW;
  final long aTX;
  long aTY;
  long aTZ;
  long aUa;
  boolean aUb;
  long aUc;
  long aUd;
  long aUe;
  
  public d()
  {
    this(-1.0D);
  }
  
  private d(double paramDouble)
  {
    if (paramDouble != -1.0D) {}
    for (boolean bool = true;; bool = false)
    {
      this.aTV = bool;
      if (!this.aTV) {
        break;
      }
      this.aTU = d.a.oy();
      this.aTW = ((1000000000.0D / paramDouble));
      this.aTX = (this.aTW * 80L / 100L);
      return;
    }
    this.aTU = null;
    this.aTW = -1L;
    this.aTX = -1L;
  }
  
  public d(Context paramContext) {}
  
  final boolean h(long paramLong1, long paramLong2)
  {
    long l = this.aUd;
    return Math.abs(paramLong2 - this.aUc - (paramLong1 - l)) > 20000000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d
 * JD-Core Version:    0.7.0.1
 */