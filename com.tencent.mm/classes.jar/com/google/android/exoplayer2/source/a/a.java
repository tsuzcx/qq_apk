package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.r.c;

public abstract class a
  implements r.c
{
  public final i aJa;
  public final Format aJb;
  public final int aJc;
  public final Object aJd;
  public final long aJe;
  public final long aJf;
  public final f ayZ;
  public final int type;
  
  public a(f paramf, i parami, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.ayZ = ((f)com.google.android.exoplayer2.i.a.E(paramf));
    this.aJa = ((i)com.google.android.exoplayer2.i.a.E(parami));
    this.type = paramInt1;
    this.aJb = paramFormat;
    this.aJc = paramInt2;
    this.aJd = paramObject;
    this.aJe = paramLong1;
    this.aJf = paramLong2;
  }
  
  public abstract long mQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */