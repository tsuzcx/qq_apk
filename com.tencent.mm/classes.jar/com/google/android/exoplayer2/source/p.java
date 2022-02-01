package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends w
{
  private static final Object dax;
  private final long cHR;
  private final long cHS;
  private final boolean cHT;
  private final boolean cHU;
  private final long daA;
  private final long daB;
  private final long daC;
  private final long daz;
  
  static
  {
    AppMethodBeat.i(92719);
    dax = new Object();
    AppMethodBeat.o(92719);
  }
  
  public p(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cHR = paramLong1;
    this.cHS = paramLong2;
    this.daz = paramLong3;
    this.daA = paramLong4;
    this.daB = paramLong5;
    this.daC = paramLong6;
    this.cHT = paramBoolean1;
    this.cHU = paramBoolean2;
  }
  
  private p(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this(-9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, 0L, 0L, paramBoolean, false);
  }
  
  public p(long paramLong, boolean paramBoolean)
  {
    this(paramLong, paramLong, paramBoolean);
    AppMethodBeat.i(92715);
    AppMethodBeat.o(92715);
  }
  
  public final int QW()
  {
    return 1;
  }
  
  public final int QX()
  {
    return 1;
  }
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(92717);
    a.ck(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = dax;; localObject = null)
    {
      long l1 = this.daz;
      long l2 = -this.daB;
      parama.cHJ = localObject;
      parama.cGq = localObject;
      parama.cGF = 0;
      parama.cHg = l1;
      parama.cHK = l2;
      parama.cHL = null;
      parama.cHM = null;
      parama.cHN = null;
      parama.cHO = null;
      parama.cHP = null;
      parama.cHQ = -9223372036854775807L;
      AppMethodBeat.o(92717);
      return parama;
    }
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(92716);
    a.ck(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = dax;; localObject = null)
    {
      long l2 = this.daC;
      long l1 = l2;
      if (this.cHU)
      {
        paramLong = l2 + paramLong;
        l1 = paramLong;
        if (paramLong > this.daA) {
          l1 = -9223372036854775807L;
        }
      }
      paramLong = this.cHR;
      l2 = this.cHS;
      paramBoolean = this.cHT;
      boolean bool = this.cHU;
      long l3 = this.daA;
      long l4 = this.daB;
      paramb.cHJ = localObject;
      paramb.cHR = paramLong;
      paramb.cHS = l2;
      paramb.cHT = paramBoolean;
      paramb.cHU = bool;
      paramb.cHX = l1;
      paramb.cHg = l3;
      paramb.cHV = 0;
      paramb.cHW = 0;
      paramb.cHY = l4;
      AppMethodBeat.o(92716);
      return paramb;
    }
  }
  
  public final int bf(Object paramObject)
  {
    AppMethodBeat.i(92718);
    if (dax.equals(paramObject))
    {
      AppMethodBeat.o(92718);
      return 0;
    }
    AppMethodBeat.o(92718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.p
 * JD-Core Version:    0.7.0.1
 */