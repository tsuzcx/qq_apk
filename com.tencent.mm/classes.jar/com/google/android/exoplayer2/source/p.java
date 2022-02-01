package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends w
{
  private static final Object bxc;
  private final long beu;
  private final long bev;
  private final boolean bew;
  private final boolean bex;
  private final long bxd;
  private final long bxe;
  private final long bxf;
  private final long bxg;
  
  static
  {
    AppMethodBeat.i(92719);
    bxc = new Object();
    AppMethodBeat.o(92719);
  }
  
  public p(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.beu = paramLong1;
    this.bev = paramLong2;
    this.bxd = paramLong3;
    this.bxe = paramLong4;
    this.bxf = paramLong5;
    this.bxg = paramLong6;
    this.bew = paramBoolean1;
    this.bex = paramBoolean2;
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
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(92717);
    a.bh(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bxc;; localObject = null)
    {
      long l1 = this.bxd;
      long l2 = -this.bxf;
      parama.bem = localObject;
      parama.bcT = localObject;
      parama.bdi = 0;
      parama.bdJ = l1;
      parama.ben = l2;
      parama.beo = null;
      parama.bep = null;
      parama.beq = null;
      parama.ber = null;
      parama.bes = null;
      parama.bet = -9223372036854775807L;
      AppMethodBeat.o(92717);
      return parama;
    }
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(92716);
    a.bh(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bxc;; localObject = null)
    {
      long l2 = this.bxg;
      long l1 = l2;
      if (this.bex)
      {
        paramLong = l2 + paramLong;
        l1 = paramLong;
        if (paramLong > this.bxe) {
          l1 = -9223372036854775807L;
        }
      }
      paramLong = this.beu;
      l2 = this.bev;
      paramBoolean = this.bew;
      boolean bool = this.bex;
      long l3 = this.bxe;
      long l4 = this.bxf;
      paramb.bem = localObject;
      paramb.beu = paramLong;
      paramb.bev = l2;
      paramb.bew = paramBoolean;
      paramb.bex = bool;
      paramb.beA = l1;
      paramb.bdJ = l3;
      paramb.bey = 0;
      paramb.bez = 0;
      paramb.beB = l4;
      AppMethodBeat.o(92716);
      return paramb;
    }
  }
  
  public final int ae(Object paramObject)
  {
    AppMethodBeat.i(92718);
    if (bxc.equals(paramObject))
    {
      AppMethodBeat.o(92718);
      return 0;
    }
    AppMethodBeat.o(92718);
    return -1;
  }
  
  public final int tD()
  {
    return 1;
  }
  
  public final int tE()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.p
 * JD-Core Version:    0.7.0.1
 */