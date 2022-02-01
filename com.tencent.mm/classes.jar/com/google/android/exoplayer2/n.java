package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
{
  final w.b aRP;
  final w.a aRQ;
  w aRW;
  int repeatMode;
  
  public n()
  {
    AppMethodBeat.i(92380);
    this.aRQ = new w.a();
    this.aRP = new w.b();
    AppMethodBeat.o(92380);
  }
  
  private boolean a(i.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(92388);
    int i = this.aRW.a(paramb.bmb, this.aRQ, false).aSQ;
    if ((!this.aRW.a(i, this.aRP).aUg) && (this.aRW.b(paramb.bmb, this.aRQ, this.aRP, this.repeatMode)) && (paramBoolean))
    {
      AppMethodBeat.o(92388);
      return true;
    }
    AppMethodBeat.o(92388);
    return false;
  }
  
  private boolean b(i.b paramb, long paramLong)
  {
    AppMethodBeat.i(92387);
    int i = this.aRW.a(paramb.bmb, this.aRQ, false).sb();
    if (i == 0)
    {
      AppMethodBeat.o(92387);
      return true;
    }
    int j = i - 1;
    boolean bool = paramb.tY();
    if (this.aRQ.aTX[j] != -9223372036854775808L)
    {
      if ((!bool) && (paramLong == -9223372036854775808L))
      {
        AppMethodBeat.o(92387);
        return true;
      }
      AppMethodBeat.o(92387);
      return false;
    }
    int k = this.aRQ.aTY[j];
    if (k == -1)
    {
      AppMethodBeat.o(92387);
      return false;
    }
    if ((bool) && (paramb.bmc == j) && (paramb.bmd == k - 1)) {}
    for (i = 1; (i != 0) || ((!bool) && (this.aRQ.aUa[j] == k)); i = 0)
    {
      AppMethodBeat.o(92387);
      return true;
    }
    AppMethodBeat.o(92387);
    return false;
  }
  
  public final a a(a parama, int paramInt)
  {
    AppMethodBeat.i(92382);
    parama = a(parama, parama.aTq.ex(paramInt));
    AppMethodBeat.o(92382);
    return parama;
  }
  
  final a a(a parama, i.b paramb)
  {
    AppMethodBeat.i(92383);
    long l3 = parama.aSM;
    long l2 = parama.aTr;
    boolean bool1 = b(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.aRW.a(paramb.bmb, this.aRQ, false);
    long l1;
    if (paramb.tY()) {
      l1 = this.aRQ.bf(paramb.bmc, paramb.bmd);
    }
    for (;;)
    {
      parama = new a(paramb, l3, l2, parama.aSN, l1, bool1, bool2, (byte)0);
      AppMethodBeat.o(92383);
      return parama;
      if (l2 == -9223372036854775808L) {
        l1 = this.aRQ.aTs;
      } else {
        l1 = l2;
      }
    }
  }
  
  final a a(i.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92384);
    this.aRW.a(paramb.bmb, this.aRQ, false);
    if (paramb.tY())
    {
      if (!this.aRQ.be(paramb.bmc, paramb.bmd))
      {
        AppMethodBeat.o(92384);
        return null;
      }
      paramb = b(paramb.bmb, paramb.bmc, paramb.bmd, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
    int i = this.aRQ.F(paramLong2);
    if (i == -1) {}
    for (paramLong1 = -9223372036854775808L;; paramLong1 = this.aRQ.aTX[i])
    {
      paramb = b(paramb.bmb, paramLong2, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
  }
  
  final a b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(92385);
    Object localObject = new i.b(paramInt1, paramInt2, paramInt3);
    boolean bool1 = b((i.b)localObject, -9223372036854775808L);
    boolean bool2 = a((i.b)localObject, bool1);
    long l2 = this.aRW.a(((i.b)localObject).bmb, this.aRQ, false).bf(((i.b)localObject).bmc, ((i.b)localObject).bmd);
    if (paramInt3 == this.aRQ.aUa[paramInt2]) {}
    for (long l1 = this.aRQ.aUc;; l1 = 0L)
    {
      localObject = new a((i.b)localObject, l1, -9223372036854775808L, paramLong, l2, bool1, bool2, (byte)0);
      AppMethodBeat.o(92385);
      return localObject;
    }
  }
  
  final a b(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92386);
    Object localObject = new i.b(paramInt);
    boolean bool1 = b((i.b)localObject, paramLong2);
    boolean bool2 = a((i.b)localObject, bool1);
    this.aRW.a(((i.b)localObject).bmb, this.aRQ, false);
    if (paramLong2 == -9223372036854775808L) {}
    for (long l = this.aRQ.aTs;; l = paramLong2)
    {
      localObject = new a((i.b)localObject, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, (byte)0);
      AppMethodBeat.o(92386);
      return localObject;
    }
  }
  
  public final i.b g(int paramInt, long paramLong)
  {
    AppMethodBeat.i(92381);
    this.aRW.a(paramInt, this.aRQ, false);
    int i = this.aRQ.E(paramLong);
    if (i == -1)
    {
      localb = new i.b(paramInt);
      AppMethodBeat.o(92381);
      return localb;
    }
    i.b localb = new i.b(paramInt, i, this.aRQ.aUa[i]);
    AppMethodBeat.o(92381);
    return localb;
  }
  
  public static final class a
  {
    public final long aSM;
    public final long aSN;
    public final i.b aTq;
    public final long aTr;
    public final long aTs;
    public final boolean aTt;
    public final boolean aTu;
    
    a(i.b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.aTq = paramb;
      this.aSM = paramLong1;
      this.aTr = paramLong2;
      this.aSN = paramLong3;
      this.aTs = paramLong4;
      this.aTt = paramBoolean1;
      this.aTu = paramBoolean2;
    }
    
    public final a rT()
    {
      AppMethodBeat.i(92379);
      a locala = new a(this.aTq.ex(-1), this.aSM, this.aTr, this.aSN, this.aTs, this.aTt, this.aTu);
      AppMethodBeat.o(92379);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.n
 * JD-Core Version:    0.7.0.1
 */