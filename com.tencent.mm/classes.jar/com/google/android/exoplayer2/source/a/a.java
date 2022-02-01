package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.t.c;

public abstract class a
  implements t.c
{
  protected final g aXs;
  public final j bmN;
  public final Format bmO;
  public final int bmP;
  public final Object bmQ;
  public final long bmR;
  public final long bmS;
  public final int type;
  
  public a(g paramg, j paramj, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.aXs = ((g)com.google.android.exoplayer2.i.a.checkNotNull(paramg));
    this.bmN = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
    this.type = paramInt1;
    this.bmO = paramFormat;
    this.bmP = paramInt2;
    this.bmQ = paramObject;
    this.bmR = paramLong1;
    this.bmS = paramLong2;
  }
  
  public abstract long uj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */