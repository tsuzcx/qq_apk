package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends w
{
  private static final Object bmG;
  private final long aUd;
  private final long aUe;
  private final boolean aUf;
  private final boolean aUg;
  private final long bmH;
  private final long bmI;
  private final long bmJ;
  private final long bmK;
  
  static
  {
    AppMethodBeat.i(92719);
    bmG = new Object();
    AppMethodBeat.o(92719);
  }
  
  public n(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aUd = paramLong1;
    this.aUe = paramLong2;
    this.bmH = paramLong3;
    this.bmI = paramLong4;
    this.bmJ = paramLong5;
    this.bmK = paramLong6;
    this.aUf = paramBoolean1;
    this.aUg = paramBoolean2;
  }
  
  private n(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this(-9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, 0L, 0L, paramBoolean, false);
  }
  
  public n(long paramLong, boolean paramBoolean)
  {
    this(paramLong, paramLong, paramBoolean);
    AppMethodBeat.i(92715);
    AppMethodBeat.o(92715);
  }
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(92717);
    a.bl(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bmG;; localObject = null)
    {
      long l1 = this.bmH;
      long l2 = -this.bmJ;
      parama.aTV = localObject;
      parama.aSB = localObject;
      parama.aSQ = 0;
      parama.aTs = l1;
      parama.aTW = l2;
      parama.aTX = null;
      parama.aTY = null;
      parama.aTZ = null;
      parama.aUa = null;
      parama.aUb = null;
      parama.aUc = -9223372036854775807L;
      AppMethodBeat.o(92717);
      return parama;
    }
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(92716);
    a.bl(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bmG;; localObject = null)
    {
      long l2 = this.bmK;
      long l1 = l2;
      if (this.aUg)
      {
        paramLong = l2 + paramLong;
        l1 = paramLong;
        if (paramLong > this.bmI) {
          l1 = -9223372036854775807L;
        }
      }
      paramLong = this.aUd;
      l2 = this.aUe;
      paramBoolean = this.aUf;
      boolean bool = this.aUg;
      long l3 = this.bmI;
      long l4 = this.bmJ;
      paramb.aTV = localObject;
      paramb.aUd = paramLong;
      paramb.aUe = l2;
      paramb.aUf = paramBoolean;
      paramb.aUg = bool;
      paramb.aUj = l1;
      paramb.aTs = l3;
      paramb.aUh = 0;
      paramb.aUi = 0;
      paramb.aUk = l4;
      AppMethodBeat.o(92716);
      return paramb;
    }
  }
  
  public final int ac(Object paramObject)
  {
    AppMethodBeat.i(92718);
    if (bmG.equals(paramObject))
    {
      AppMethodBeat.o(92718);
      return 0;
    }
    AppMethodBeat.o(92718);
    return -1;
  }
  
  public final int rZ()
  {
    return 1;
  }
  
  public final int sa()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.n
 * JD-Core Version:    0.7.0.1
 */