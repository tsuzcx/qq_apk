package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.t.c;

public abstract class a
  implements t.c
{
  protected final g aRo;
  public final j bgL;
  public final Format bgM;
  public final int bgN;
  public final Object bgO;
  public final long bgP;
  public final long bgQ;
  public final int type;
  
  public a(g paramg, j paramj, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.aRo = ((g)com.google.android.exoplayer2.i.a.checkNotNull(paramg));
    this.bgL = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
    this.type = paramInt1;
    this.bgM = paramFormat;
    this.bgN = paramInt2;
    this.bgO = paramObject;
    this.bgP = paramLong1;
    this.bgQ = paramLong2;
  }
  
  public abstract long tL();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */