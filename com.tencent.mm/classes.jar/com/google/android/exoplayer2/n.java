package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
{
  final w.b bck;
  final w.a bcl;
  w bcr;
  int repeatMode;
  
  public n()
  {
    AppMethodBeat.i(92380);
    this.bcl = new w.a();
    this.bck = new w.b();
    AppMethodBeat.o(92380);
  }
  
  private boolean a(i.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(92388);
    int i = this.bcr.a(paramb.bww, this.bcl, false).bdl;
    if ((!this.bcr.a(i, this.bck).beA) && (this.bcr.b(paramb.bww, this.bcl, this.bck, this.repeatMode)) && (paramBoolean))
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
    int i = this.bcr.a(paramb.bww, this.bcl, false).tA();
    if (i == 0)
    {
      AppMethodBeat.o(92387);
      return true;
    }
    int j = i - 1;
    boolean bool = paramb.vx();
    if (this.bcl.ber[j] != -9223372036854775808L)
    {
      if ((!bool) && (paramLong == -9223372036854775808L))
      {
        AppMethodBeat.o(92387);
        return true;
      }
      AppMethodBeat.o(92387);
      return false;
    }
    int k = this.bcl.bes[j];
    if (k == -1)
    {
      AppMethodBeat.o(92387);
      return false;
    }
    if ((bool) && (paramb.bwx == j) && (paramb.bwy == k - 1)) {}
    for (i = 1; (i != 0) || ((!bool) && (this.bcl.beu[j] == k)); i = 0)
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
    parama = a(parama, parama.bdK.eB(paramInt));
    AppMethodBeat.o(92382);
    return parama;
  }
  
  final a a(a parama, i.b paramb)
  {
    AppMethodBeat.i(92383);
    long l3 = parama.bdh;
    long l2 = parama.bdL;
    boolean bool1 = b(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.bcr.a(paramb.bww, this.bcl, false);
    long l1;
    if (paramb.vx()) {
      l1 = this.bcl.bh(paramb.bwx, paramb.bwy);
    }
    for (;;)
    {
      parama = new a(paramb, l3, l2, parama.bdi, l1, bool1, bool2, (byte)0);
      AppMethodBeat.o(92383);
      return parama;
      if (l2 == -9223372036854775808L) {
        l1 = this.bcl.bdM;
      } else {
        l1 = l2;
      }
    }
  }
  
  final a a(i.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92384);
    this.bcr.a(paramb.bww, this.bcl, false);
    if (paramb.vx())
    {
      if (!this.bcl.bg(paramb.bwx, paramb.bwy))
      {
        AppMethodBeat.o(92384);
        return null;
      }
      paramb = b(paramb.bww, paramb.bwx, paramb.bwy, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
    int i = this.bcl.F(paramLong2);
    if (i == -1) {}
    for (paramLong1 = -9223372036854775808L;; paramLong1 = this.bcl.ber[i])
    {
      paramb = b(paramb.bww, paramLong2, paramLong1);
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
    long l2 = this.bcr.a(((i.b)localObject).bww, this.bcl, false).bh(((i.b)localObject).bwx, ((i.b)localObject).bwy);
    if (paramInt3 == this.bcl.beu[paramInt2]) {}
    for (long l1 = this.bcl.bew;; l1 = 0L)
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
    this.bcr.a(((i.b)localObject).bww, this.bcl, false);
    if (paramLong2 == -9223372036854775808L) {}
    for (long l = this.bcl.bdM;; l = paramLong2)
    {
      localObject = new a((i.b)localObject, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, (byte)0);
      AppMethodBeat.o(92386);
      return localObject;
    }
  }
  
  public final i.b g(int paramInt, long paramLong)
  {
    AppMethodBeat.i(92381);
    this.bcr.a(paramInt, this.bcl, false);
    int i = this.bcl.E(paramLong);
    if (i == -1)
    {
      localb = new i.b(paramInt);
      AppMethodBeat.o(92381);
      return localb;
    }
    i.b localb = new i.b(paramInt, i, this.bcl.beu[i]);
    AppMethodBeat.o(92381);
    return localb;
  }
  
  public static final class a
  {
    public final i.b bdK;
    public final long bdL;
    public final long bdM;
    public final boolean bdN;
    public final boolean bdO;
    public final long bdh;
    public final long bdi;
    
    a(i.b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.bdK = paramb;
      this.bdh = paramLong1;
      this.bdL = paramLong2;
      this.bdi = paramLong3;
      this.bdM = paramLong4;
      this.bdN = paramBoolean1;
      this.bdO = paramBoolean2;
    }
    
    public final a ts()
    {
      AppMethodBeat.i(92379);
      a locala = new a(this.bdK.eB(-1), this.bdh, this.bdL, this.bdi, this.bdM, this.bdN, this.bdO);
      AppMethodBeat.o(92379);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.n
 * JD-Core Version:    0.7.0.1
 */