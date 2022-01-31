package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.source.m;

public final class h
{
  public final m aQI;
  public final f aQJ;
  public final Object aQK;
  public final com.google.android.exoplayer2.t[] aQL;
  
  public h(m paramm, f paramf, Object paramObject, com.google.android.exoplayer2.t[] paramArrayOft)
  {
    this.aQI = paramm;
    this.aQJ = paramf;
    this.aQK = paramObject;
    this.aQL = paramArrayOft;
  }
  
  public final boolean a(h paramh, int paramInt)
  {
    if (paramh == null) {}
    while ((!com.google.android.exoplayer2.i.t.e(this.aQJ.aQG[paramInt], paramh.aQJ.aQG[paramInt])) || (!com.google.android.exoplayer2.i.t.e(this.aQL[paramInt], paramh.aQL[paramInt]))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.h
 * JD-Core Version:    0.7.0.1
 */