package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends w
{
  private static final Object bxb;
  private final boolean beA;
  private final long bex;
  private final long bey;
  private final boolean bez;
  private final long bxc;
  private final long bxd;
  private final long bxe;
  private final long bxf;
  
  static
  {
    AppMethodBeat.i(92719);
    bxb = new Object();
    AppMethodBeat.o(92719);
  }
  
  public n(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bex = paramLong1;
    this.bey = paramLong2;
    this.bxc = paramLong3;
    this.bxd = paramLong4;
    this.bxe = paramLong5;
    this.bxf = paramLong6;
    this.bez = paramBoolean1;
    this.beA = paramBoolean2;
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
    a.bn(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bxb;; localObject = null)
    {
      long l1 = this.bxc;
      long l2 = -this.bxe;
      parama.bep = localObject;
      parama.bcW = localObject;
      parama.bdl = 0;
      parama.bdM = l1;
      parama.beq = l2;
      parama.ber = null;
      parama.bes = null;
      parama.bet = null;
      parama.beu = null;
      parama.bev = null;
      parama.bew = -9223372036854775807L;
      AppMethodBeat.o(92717);
      return parama;
    }
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(92716);
    a.bn(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = bxb;; localObject = null)
    {
      long l2 = this.bxf;
      long l1 = l2;
      if (this.beA)
      {
        paramLong = l2 + paramLong;
        l1 = paramLong;
        if (paramLong > this.bxd) {
          l1 = -9223372036854775807L;
        }
      }
      paramLong = this.bex;
      l2 = this.bey;
      paramBoolean = this.bez;
      boolean bool = this.beA;
      long l3 = this.bxd;
      long l4 = this.bxe;
      paramb.bep = localObject;
      paramb.bex = paramLong;
      paramb.bey = l2;
      paramb.bez = paramBoolean;
      paramb.beA = bool;
      paramb.beD = l1;
      paramb.bdM = l3;
      paramb.beB = 0;
      paramb.beC = 0;
      paramb.beE = l4;
      AppMethodBeat.o(92716);
      return paramb;
    }
  }
  
  public final int ae(Object paramObject)
  {
    AppMethodBeat.i(92718);
    if (bxb.equals(paramObject))
    {
      AppMethodBeat.o(92718);
      return 0;
    }
    AppMethodBeat.o(92718);
    return -1;
  }
  
  public final int ty()
  {
    return 1;
  }
  
  public final int tz()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.n
 * JD-Core Version:    0.7.0.1
 */