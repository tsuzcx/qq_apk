package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.t.c;

public abstract class a
  implements t.c
{
  protected final g aBo;
  public final j aQI;
  public final Format aQJ;
  public final int aQK;
  public final Object aQL;
  public final long aQM;
  public final long aQN;
  public final int type;
  
  public a(g paramg, j paramj, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.aBo = ((g)com.google.android.exoplayer2.i.a.checkNotNull(paramg));
    this.aQI = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
    this.type = paramInt1;
    this.aQJ = paramFormat;
    this.aQK = paramInt2;
    this.aQL = paramObject;
    this.aQM = paramLong1;
    this.aQN = paramLong2;
  }
  
  public abstract long pt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */