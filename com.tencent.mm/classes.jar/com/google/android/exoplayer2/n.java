package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
{
  final w.b bch;
  final w.a bci;
  w bco;
  int repeatMode;
  
  public n()
  {
    AppMethodBeat.i(92380);
    this.bci = new w.a();
    this.bch = new w.b();
    AppMethodBeat.o(92380);
  }
  
  private boolean a(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(92388);
    int i = this.bco.a(paramb.bwx, this.bci, false).bdi;
    if ((!this.bco.a(i, this.bch).bex) && (this.bco.b(paramb.bwx, this.bci, this.bch, this.repeatMode)) && (paramBoolean))
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
    int i = this.bco.a(paramb.bwx, this.bci, false).tF();
    if (i == 0)
    {
      AppMethodBeat.o(92387);
      return true;
    }
    int j = i - 1;
    boolean bool = paramb.isAd();
    if (this.bci.beo[j] != -9223372036854775808L)
    {
      if ((!bool) && (paramLong == -9223372036854775808L))
      {
        AppMethodBeat.o(92387);
        return true;
      }
      AppMethodBeat.o(92387);
      return false;
    }
    int k = this.bci.bep[j];
    if (k == -1)
    {
      AppMethodBeat.o(92387);
      return false;
    }
    if ((bool) && (paramb.bwy == j) && (paramb.bwz == k - 1)) {}
    for (i = 1; (i != 0) || ((!bool) && (this.bci.ber[j] == k)); i = 0)
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
    parama = a(parama, parama.bdH.eA(paramInt));
    AppMethodBeat.o(92382);
    return parama;
  }
  
  final a a(a parama, k.b paramb)
  {
    AppMethodBeat.i(92383);
    long l3 = parama.bde;
    long l2 = parama.bdI;
    boolean bool1 = b(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.bco.a(paramb.bwx, this.bci, false);
    long l1;
    if (paramb.isAd()) {
      l1 = this.bci.bb(paramb.bwy, paramb.bwz);
    }
    for (;;)
    {
      parama = new a(paramb, l3, l2, parama.bdf, l1, bool1, bool2, (byte)0);
      AppMethodBeat.o(92383);
      return parama;
      if (l2 == -9223372036854775808L) {
        l1 = this.bci.bdJ;
      } else {
        l1 = l2;
      }
    }
  }
  
  final a a(k.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92384);
    this.bco.a(paramb.bwx, this.bci, false);
    if (paramb.isAd())
    {
      if (!this.bci.ba(paramb.bwy, paramb.bwz))
      {
        AppMethodBeat.o(92384);
        return null;
      }
      paramb = b(paramb.bwx, paramb.bwy, paramb.bwz, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
    int i = this.bci.F(paramLong2);
    if (i == -1) {}
    for (paramLong1 = -9223372036854775808L;; paramLong1 = this.bci.beo[i])
    {
      paramb = c(paramb.bwx, paramLong2, paramLong1);
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
    long l2 = this.bco.a(((k.b)localObject).bwx, this.bci, false).bb(((k.b)localObject).bwy, ((k.b)localObject).bwz);
    if (paramInt3 == this.bci.ber[paramInt2]) {}
    for (long l1 = this.bci.bet;; l1 = 0L)
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
    this.bco.a(((k.b)localObject).bwx, this.bci, false);
    if (paramLong2 == -9223372036854775808L) {}
    for (long l = this.bci.bdJ;; l = paramLong2)
    {
      localObject = new a((k.b)localObject, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, (byte)0);
      AppMethodBeat.o(92386);
      return localObject;
    }
  }
  
  public final k.b g(int paramInt, long paramLong)
  {
    AppMethodBeat.i(92381);
    this.bco.a(paramInt, this.bci, false);
    int i = this.bci.E(paramLong);
    if (i == -1)
    {
      localb = new k.b(paramInt);
      AppMethodBeat.o(92381);
      return localb;
    }
    k.b localb = new k.b(paramInt, i, this.bci.ber[i]);
    AppMethodBeat.o(92381);
    return localb;
  }
  
  public static final class a
  {
    public final k.b bdH;
    public final long bdI;
    public final long bdJ;
    public final boolean bdK;
    public final boolean bdL;
    public final long bde;
    public final long bdf;
    
    a(k.b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.bdH = paramb;
      this.bde = paramLong1;
      this.bdI = paramLong2;
      this.bdf = paramLong3;
      this.bdJ = paramLong4;
      this.bdK = paramBoolean1;
      this.bdL = paramBoolean2;
    }
    
    public final a tx()
    {
      AppMethodBeat.i(92379);
      a locala = new a(this.bdH.eA(-1), this.bde, this.bdI, this.bdf, this.bdJ, this.bdK, this.bdL);
      AppMethodBeat.o(92379);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.n
 * JD-Core Version:    0.7.0.1
 */