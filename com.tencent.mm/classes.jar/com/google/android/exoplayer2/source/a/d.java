package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;

public abstract class d
  extends a
{
  public final int bxo;
  
  public d(g paramg, j paramj, Format paramFormat, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2)
  {
    super(paramg, paramj, 1, paramFormat, paramInt1, paramObject, paramLong1, paramLong2);
    com.google.android.exoplayer2.i.a.checkNotNull(paramFormat);
    this.bxo = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.d
 * JD-Core Version:    0.7.0.1
 */