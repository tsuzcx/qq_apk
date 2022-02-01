package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends w
{
  private static final Object bmb;
  private final long aTl;
  private final long aTm;
  private final boolean aTn;
  private final boolean aTo;
  private final long bmc;
  private final long bmd;
  private final long bme;
  private final long bmf;
  
  static
  {
    AppMethodBeat.i(92719);
    bmb = new Object();
    AppMethodBeat.o(92719);
  }
  
  public o(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aTl = paramLong1;
    this.aTm = paramLong2;
    this.bmc = paramLong3;
    this.bmd = paramLong4;
    this.bme = paramLong5;
    this.bmf = paramLong6;
    this.aTn = paramBoolean1;
    this.aTo = paramBoolean2;
  }
  
  public o(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(-9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramLong4, paramBoolean1, paramBoolean2);
  }
  
  public o(long paramLong, boolean paramBoolean)
  {
    this(paramLong, paramLong, 0L, 0L, paramBoolean, false);
    AppMethodBeat.i(92715);
    AppMethodBeat.o(92715);
  }
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(92717);
    a.bn(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bmb;; localObject = null)
    {
      parama = parama.a(localObject, localObject, this.bmc, -this.bme);
      AppMethodBeat.o(92717);
      return parama;
    }
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(92716);
    a.bn(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bmb;; localObject = null)
    {
      long l2 = this.bmf;
      long l1 = l2;
      if (this.aTo)
      {
        paramLong = l2 + paramLong;
        l1 = paramLong;
        if (paramLong > this.bmd) {
          l1 = -9223372036854775807L;
        }
      }
      paramb = paramb.a(localObject, this.aTl, this.aTm, this.aTn, this.aTo, l1, this.bmd, 0, this.bme);
      AppMethodBeat.o(92716);
      return paramb;
    }
  }
  
  public final int aa(Object paramObject)
  {
    AppMethodBeat.i(92718);
    if (bmb.equals(paramObject))
    {
      AppMethodBeat.o(92718);
      return 0;
    }
    AppMethodBeat.o(92718);
    return -1;
  }
  
  public final int rP()
  {
    return 1;
  }
  
  public final int rQ()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.o
 * JD-Core Version:    0.7.0.1
 */