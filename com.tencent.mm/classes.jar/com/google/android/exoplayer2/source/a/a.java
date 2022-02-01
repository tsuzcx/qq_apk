package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.t.c;

public abstract class a
  implements t.c
{
  protected final g bhK;
  public final j bxj;
  public final Format bxk;
  public final int bxl;
  public final Object bxm;
  public final long bxn;
  public final long bxo;
  public final int type;
  
  public a(g paramg, j paramj, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.bhK = ((g)com.google.android.exoplayer2.i.a.checkNotNull(paramg));
    this.bxj = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
    this.type = paramInt1;
    this.bxk = paramFormat;
    this.bxl = paramInt2;
    this.bxm = paramObject;
    this.bxn = paramLong1;
    this.bxo = paramLong2;
  }
  
  public abstract long vN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */