package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.a;

public abstract class l
  extends c
{
  public final int bmT;
  
  public l(g paramg, j paramj, Format paramFormat, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2)
  {
    super(paramg, paramj, 1, paramFormat, paramInt1, paramObject, paramLong1, paramLong2);
    a.checkNotNull(paramFormat);
    this.bmT = paramInt2;
  }
  
  public int uc()
  {
    return this.bmT + 1;
  }
  
  public abstract boolean ud();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.l
 * JD-Core Version:    0.7.0.1
 */