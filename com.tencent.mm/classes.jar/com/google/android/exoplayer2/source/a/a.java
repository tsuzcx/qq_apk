package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.t.c;

public abstract class a
  implements t.c
{
  protected final g cLk;
  public final j daF;
  public final Format daG;
  public final int daH;
  public final Object daI;
  public final long daJ;
  public final long daK;
  public final int type;
  
  public a(g paramg, j paramj, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.cLk = ((g)com.google.android.exoplayer2.i.a.checkNotNull(paramg));
    this.daF = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
    this.type = paramInt1;
    this.daG = paramFormat;
    this.daH = paramInt2;
    this.daI = paramObject;
    this.daJ = paramLong1;
    this.daK = paramLong2;
  }
  
  public abstract long To();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */