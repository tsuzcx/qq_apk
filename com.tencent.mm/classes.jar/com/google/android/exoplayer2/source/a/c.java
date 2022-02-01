package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.i.a;

public abstract class c
  implements t.c
{
  protected final g aWG;
  public final j bml;
  public final Format bmm;
  public final int bmn;
  public final Object bmo;
  public final long bmp;
  public final long bmq;
  public final int type;
  
  public c(g paramg, j paramj, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.aWG = ((g)a.checkNotNull(paramg));
    this.bml = ((j)a.checkNotNull(paramj));
    this.type = paramInt1;
    this.bmm = paramFormat;
    this.bmn = paramInt2;
    this.bmo = paramObject;
    this.bmp = paramLong1;
    this.bmq = paramLong2;
  }
  
  public abstract long ub();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.c
 * JD-Core Version:    0.7.0.1
 */