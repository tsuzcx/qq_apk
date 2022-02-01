package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
{
  final w.b aLG;
  final w.a aLH;
  int aLK;
  w aLO;
  
  public n()
  {
    AppMethodBeat.i(92380);
    this.aLH = new w.a();
    this.aLG = new w.b();
    AppMethodBeat.o(92380);
  }
  
  private boolean a(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(92388);
    int i = this.aLO.a(paramb.bfZ, this.aLH, false).aMI;
    if ((!this.aLO.a(i, this.aLG).aNY) && (this.aLO.b(paramb.bfZ, this.aLH, this.aLG, this.aLK)) && (paramBoolean))
    {
      AppMethodBeat.o(92388);
      return true;
    }
    AppMethodBeat.o(92388);
    return false;
  }
  
  private boolean b(k.b paramb, long paramLong)
  {
    AppMethodBeat.i(92387);
    int i = this.aLO.a(paramb.bfZ, this.aLH, false).rx();
    if (i == 0)
    {
      AppMethodBeat.o(92387);
      return true;
    }
    int j = i - 1;
    boolean bool = paramb.isAd();
    if (this.aLH.aNP[j] != -9223372036854775808L)
    {
      if ((!bool) && (paramLong == -9223372036854775808L))
      {
        AppMethodBeat.o(92387);
        return true;
      }
      AppMethodBeat.o(92387);
      return false;
    }
    int k = this.aLH.aNQ[j];
    if (k == -1)
    {
      AppMethodBeat.o(92387);
      return false;
    }
    if ((bool) && (paramb.bga == j) && (paramb.bgb == k - 1)) {}
    for (i = 1; (i != 0) || ((!bool) && (this.aLH.aNS[j] == k)); i = 0)
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
    parama = a(parama, parama.aNi.eQ(paramInt));
    AppMethodBeat.o(92382);
    return parama;
  }
  
  final a a(a parama, k.b paramb)
  {
    AppMethodBeat.i(92383);
    long l3 = parama.aME;
    long l2 = parama.aNj;
    boolean bool1 = b(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.aLO.a(paramb.bfZ, this.aLH, false);
    long l1;
    if (paramb.isAd()) {
      l1 = this.aLH.bh(paramb.bga, paramb.bgb);
    }
    for (;;)
    {
      parama = new a(paramb, l3, l2, parama.aMF, l1, bool1, bool2, (byte)0);
      AppMethodBeat.o(92383);
      return parama;
      if (l2 == -9223372036854775808L) {
        l1 = this.aLH.aNk;
      } else {
        l1 = l2;
      }
    }
  }
  
  final a a(k.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92384);
    this.aLO.a(paramb.bfZ, this.aLH, false);
    if (paramb.isAd())
    {
      if (!this.aLH.bg(paramb.bga, paramb.bgb))
      {
        AppMethodBeat.o(92384);
        return null;
      }
      paramb = b(paramb.bfZ, paramb.bga, paramb.bgb, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
    int i = this.aLH.I(paramLong2);
    if (i == -1) {}
    for (paramLong1 = -9223372036854775808L;; paramLong1 = this.aLH.aNP[i])
    {
      paramb = c(paramb.bfZ, paramLong2, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
  }
  
  final a b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(92385);
    Object localObject = new k.b(paramInt1, paramInt2, paramInt3);
    boolean bool1 = b((k.b)localObject, -9223372036854775808L);
    boolean bool2 = a((k.b)localObject, bool1);
    long l2 = this.aLO.a(((k.b)localObject).bfZ, this.aLH, false).bh(((k.b)localObject).bga, ((k.b)localObject).bgb);
    if (paramInt3 == this.aLH.aNS[paramInt2]) {}
    for (long l1 = this.aLH.aNU;; l1 = 0L)
    {
      localObject = new a((k.b)localObject, l1, -9223372036854775808L, paramLong, l2, bool1, bool2, (byte)0);
      AppMethodBeat.o(92385);
      return localObject;
    }
  }
  
  final a c(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92386);
    Object localObject = new k.b(paramInt);
    boolean bool1 = b((k.b)localObject, paramLong2);
    boolean bool2 = a((k.b)localObject, bool1);
    this.aLO.a(((k.b)localObject).bfZ, this.aLH, false);
    if (paramLong2 == -9223372036854775808L) {}
    for (long l = this.aLH.aNk;; l = paramLong2)
    {
      localObject = new a((k.b)localObject, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, (byte)0);
      AppMethodBeat.o(92386);
      return localObject;
    }
  }
  
  public final k.b g(int paramInt, long paramLong)
  {
    AppMethodBeat.i(92381);
    this.aLO.a(paramInt, this.aLH, false);
    int i = this.aLH.H(paramLong);
    if (i == -1)
    {
      localb = new k.b(paramInt);
      AppMethodBeat.o(92381);
      return localb;
    }
    k.b localb = new k.b(paramInt, i, this.aLH.aNS[i]);
    AppMethodBeat.o(92381);
    return localb;
  }
  
  public static final class a
  {
    public final long aME;
    public final long aMF;
    public final k.b aNi;
    public final long aNj;
    public final long aNk;
    public final boolean aNl;
    public final boolean aNm;
    
    a(k.b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.aNi = paramb;
      this.aME = paramLong1;
      this.aNj = paramLong2;
      this.aMF = paramLong3;
      this.aNk = paramLong4;
      this.aNl = paramBoolean1;
      this.aNm = paramBoolean2;
    }
    
    public final a rr()
    {
      AppMethodBeat.i(92379);
      a locala = new a(this.aNi.eQ(-1), this.aME, this.aNj, this.aMF, this.aNk, this.aNl, this.aNm);
      AppMethodBeat.o(92379);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.n
 * JD-Core Version:    0.7.0.1
 */