package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends w
{
  private static final Object aQB;
  private final long aQC;
  private final long aQD;
  private final long aQE;
  private final long aQF;
  private final long axS;
  private final long axT;
  private final boolean axU;
  private final boolean axV;
  
  static
  {
    AppMethodBeat.i(95551);
    aQB = new Object();
    AppMethodBeat.o(95551);
  }
  
  public n(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.axS = paramLong1;
    this.axT = paramLong2;
    this.aQC = paramLong3;
    this.aQD = paramLong4;
    this.aQE = paramLong5;
    this.aQF = paramLong6;
    this.axU = paramBoolean1;
    this.axV = paramBoolean2;
  }
  
  private n(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this(-9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, 0L, 0L, paramBoolean, false);
  }
  
  public n(long paramLong, boolean paramBoolean)
  {
    this(paramLong, paramLong, paramBoolean);
    AppMethodBeat.i(95547);
    AppMethodBeat.o(95547);
  }
  
  public final int O(Object paramObject)
  {
    AppMethodBeat.i(95550);
    if (aQB.equals(paramObject))
    {
      AppMethodBeat.o(95550);
      return 0;
    }
    AppMethodBeat.o(95550);
    return -1;
  }
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(95549);
    a.ba(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = aQB;; localObject = null)
    {
      long l1 = this.aQC;
      long l2 = -this.aQE;
      parama.axK = localObject;
      parama.awo = localObject;
      parama.awC = 0;
      parama.axh = l1;
      parama.axL = l2;
      parama.axM = null;
      parama.axN = null;
      parama.axO = null;
      parama.axP = null;
      parama.axQ = null;
      parama.axR = -9223372036854775807L;
      AppMethodBeat.o(95549);
      return parama;
    }
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(95548);
    a.ba(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = aQB;; localObject = null)
    {
      long l2 = this.aQF;
      long l1 = l2;
      if (this.axV)
      {
        paramLong = l2 + paramLong;
        l1 = paramLong;
        if (paramLong > this.aQD) {
          l1 = -9223372036854775807L;
        }
      }
      paramLong = this.axS;
      l2 = this.axT;
      paramBoolean = this.axU;
      boolean bool = this.axV;
      long l3 = this.aQD;
      long l4 = this.aQE;
      paramb.axK = localObject;
      paramb.axS = paramLong;
      paramb.axT = l2;
      paramb.axU = paramBoolean;
      paramb.axV = bool;
      paramb.axY = l1;
      paramb.axh = l3;
      paramb.axW = 0;
      paramb.axX = 0;
      paramb.axZ = l4;
      AppMethodBeat.o(95548);
      return paramb;
    }
  }
  
  public final int ne()
  {
    return 1;
  }
  
  public final int nf()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.n
 * JD-Core Version:    0.7.0.1
 */