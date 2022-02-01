package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends w
{
  private static final Object bgE;
  private final long aNV;
  private final long aNW;
  private final boolean aNX;
  private final boolean aNY;
  private final long bgF;
  private final long bgG;
  private final long bgH;
  private final long bgI;
  
  static
  {
    AppMethodBeat.i(92719);
    bgE = new Object();
    AppMethodBeat.o(92719);
  }
  
  public p(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aNV = paramLong1;
    this.aNW = paramLong2;
    this.bgF = paramLong3;
    this.bgG = paramLong4;
    this.bgH = paramLong5;
    this.bgI = paramLong6;
    this.aNX = paramBoolean1;
    this.aNY = paramBoolean2;
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
  
  public final int W(Object paramObject)
  {
    AppMethodBeat.i(92718);
    if (bgE.equals(paramObject))
    {
      AppMethodBeat.o(92718);
      return 0;
    }
    AppMethodBeat.o(92718);
    return -1;
  }
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(92717);
    a.bp(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bgE;; localObject = null)
    {
      long l1 = this.bgF;
      long l2 = -this.bgH;
      parama.aNN = localObject;
      parama.aMt = localObject;
      parama.aMI = 0;
      parama.aNk = l1;
      parama.aNO = l2;
      parama.aNP = null;
      parama.aNQ = null;
      parama.aNR = null;
      parama.aNS = null;
      parama.aNT = null;
      parama.aNU = -9223372036854775807L;
      AppMethodBeat.o(92717);
      return parama;
    }
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(92716);
    a.bp(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bgE;; localObject = null)
    {
      long l2 = this.bgI;
      long l1 = l2;
      if (this.aNY)
      {
        paramLong = l2 + paramLong;
        l1 = paramLong;
        if (paramLong > this.bgG) {
          l1 = -9223372036854775807L;
        }
      }
      paramLong = this.aNV;
      l2 = this.aNW;
      paramBoolean = this.aNX;
      boolean bool = this.aNY;
      long l3 = this.bgG;
      long l4 = this.bgH;
      paramb.aNN = localObject;
      paramb.aNV = paramLong;
      paramb.aNW = l2;
      paramb.aNX = paramBoolean;
      paramb.aNY = bool;
      paramb.aOb = l1;
      paramb.aNk = l3;
      paramb.aNZ = 0;
      paramb.aOa = 0;
      paramb.aOc = l4;
      AppMethodBeat.o(92716);
      return paramb;
    }
  }
  
  public final int rv()
  {
    return 1;
  }
  
  public final int rw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.p
 * JD-Core Version:    0.7.0.1
 */