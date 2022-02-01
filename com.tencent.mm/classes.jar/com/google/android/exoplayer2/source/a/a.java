package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.t.c;

public abstract class a
  implements t.c
{
  protected final g bhN;
  public final j bxi;
  public final Format bxj;
  public final int bxk;
  public final Object bxl;
  public final long bxm;
  public final long bxn;
  public final int type;
  
  public a(g paramg, j paramj, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.bhN = ((g)com.google.android.exoplayer2.i.a.checkNotNull(paramg));
    this.bxi = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
    this.type = paramInt1;
    this.bxj = paramFormat;
    this.bxk = paramInt2;
    this.bxl = paramObject;
    this.bxm = paramLong1;
    this.bxn = paramLong2;
  }
  
  public abstract long vI();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */