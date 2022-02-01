package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
{
  final w.b cFD;
  final w.a cFE;
  int cFH;
  w cFL;
  
  public n()
  {
    AppMethodBeat.i(92380);
    this.cFE = new w.a();
    this.cFD = new w.b();
    AppMethodBeat.o(92380);
  }
  
  private boolean a(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(92388);
    int i = this.cFL.a(paramb.cZS, this.cFE, false).cGF;
    if ((!this.cFL.a(i, this.cFD).cHU) && (this.cFL.b(paramb.cZS, this.cFE, this.cFD, this.cFH)) && (paramBoolean))
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
    int i = this.cFL.a(paramb.cZS, this.cFE, false).QY();
    if (i == 0)
    {
      AppMethodBeat.o(92387);
      return true;
    }
    int j = i - 1;
    boolean bool = paramb.isAd();
    if (this.cFE.cHL[j] != -9223372036854775808L)
    {
      if ((!bool) && (paramLong == -9223372036854775808L))
      {
        AppMethodBeat.o(92387);
        return true;
      }
      AppMethodBeat.o(92387);
      return false;
    }
    int k = this.cFE.cHM[j];
    if (k == -1)
    {
      AppMethodBeat.o(92387);
      return false;
    }
    if ((bool) && (paramb.cZT == j) && (paramb.cZU == k - 1)) {}
    for (i = 1; (i != 0) || ((!bool) && (this.cFE.cHO[j] == k)); i = 0)
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
    parama = a(parama, parama.cHe.ig(paramInt));
    AppMethodBeat.o(92382);
    return parama;
  }
  
  final a a(a parama, k.b paramb)
  {
    AppMethodBeat.i(92383);
    long l3 = parama.cGB;
    long l2 = parama.cHf;
    boolean bool1 = b(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.cFL.a(paramb.cZS, this.cFE, false);
    long l1;
    if (paramb.isAd()) {
      l1 = this.cFE.cc(paramb.cZT, paramb.cZU);
    }
    for (;;)
    {
      parama = new a(paramb, l3, l2, parama.cGC, l1, bool1, bool2, (byte)0);
      AppMethodBeat.o(92383);
      return parama;
      if (l2 == -9223372036854775808L) {
        l1 = this.cFE.cHg;
      } else {
        l1 = l2;
      }
    }
  }
  
  final a a(k.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92384);
    this.cFL.a(paramb.cZS, this.cFE, false);
    if (paramb.isAd())
    {
      if (!this.cFE.cb(paramb.cZT, paramb.cZU))
      {
        AppMethodBeat.o(92384);
        return null;
      }
      paramb = b(paramb.cZS, paramb.cZT, paramb.cZU, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
    int i = this.cFE.bW(paramLong2);
    if (i == -1) {}
    for (paramLong1 = -9223372036854775808L;; paramLong1 = this.cFE.cHL[i])
    {
      paramb = c(paramb.cZS, paramLong2, paramLong1);
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
    long l2 = this.cFL.a(((k.b)localObject).cZS, this.cFE, false).cc(((k.b)localObject).cZT, ((k.b)localObject).cZU);
    if (paramInt3 == this.cFE.cHO[paramInt2]) {}
    for (long l1 = this.cFE.cHQ;; l1 = 0L)
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
    this.cFL.a(((k.b)localObject).cZS, this.cFE, false);
    if (paramLong2 == -9223372036854775808L) {}
    for (long l = this.cFE.cHg;; l = paramLong2)
    {
      localObject = new a((k.b)localObject, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, (byte)0);
      AppMethodBeat.o(92386);
      return localObject;
    }
  }
  
  public final k.b g(int paramInt, long paramLong)
  {
    AppMethodBeat.i(92381);
    this.cFL.a(paramInt, this.cFE, false);
    int i = this.cFE.bV(paramLong);
    if (i == -1)
    {
      localb = new k.b(paramInt);
      AppMethodBeat.o(92381);
      return localb;
    }
    k.b localb = new k.b(paramInt, i, this.cFE.cHO[i]);
    AppMethodBeat.o(92381);
    return localb;
  }
  
  public static final class a
  {
    public final long cGB;
    public final long cGC;
    public final k.b cHe;
    public final long cHf;
    public final long cHg;
    public final boolean cHh;
    public final boolean cHi;
    
    a(k.b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.cHe = paramb;
      this.cGB = paramLong1;
      this.cHf = paramLong2;
      this.cGC = paramLong3;
      this.cHg = paramLong4;
      this.cHh = paramBoolean1;
      this.cHi = paramBoolean2;
    }
    
    public final a QT()
    {
      AppMethodBeat.i(92379);
      a locala = new a(this.cHe.ig(-1), this.cGB, this.cHf, this.cGC, this.cHg, this.cHh, this.cHi);
      AppMethodBeat.o(92379);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.n
 * JD-Core Version:    0.7.0.1
 */