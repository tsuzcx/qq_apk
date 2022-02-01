package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
{
  final w.b aQU;
  final w.a aQV;
  w aRb;
  int repeatMode;
  
  public n()
  {
    AppMethodBeat.i(92380);
    this.aQV = new w.a();
    this.aQU = new w.b();
    AppMethodBeat.o(92380);
  }
  
  private boolean a(j.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(92388);
    int i = this.aRb.a(paramb.blw, this.aQV, false).aRV;
    if ((!this.aRb.a(i, this.aQU).aTo) && (this.aRb.b(paramb.blw, this.aQV, this.aQU, this.repeatMode)) && (paramBoolean))
    {
      AppMethodBeat.o(92388);
      return true;
    }
    AppMethodBeat.o(92388);
    return false;
  }
  
  private boolean b(j.b paramb, long paramLong)
  {
    AppMethodBeat.i(92387);
    int i = this.aRb.a(paramb.blw, this.aQV, false).rR();
    if (i == 0)
    {
      AppMethodBeat.o(92387);
      return true;
    }
    int j = i - 1;
    boolean bool = paramb.tQ();
    if (this.aQV.aTf[j] != -9223372036854775808L)
    {
      if ((!bool) && (paramLong == -9223372036854775808L))
      {
        AppMethodBeat.o(92387);
        return true;
      }
      AppMethodBeat.o(92387);
      return false;
    }
    int k = this.aQV.aTg[j];
    if (k == -1)
    {
      AppMethodBeat.o(92387);
      return false;
    }
    if ((bool) && (paramb.blx == j) && (paramb.bly == k - 1)) {}
    for (i = 1; (i != 0) || ((!bool) && (this.aQV.aTi[j] == k)); i = 0)
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
    parama = a(parama, parama.aSx.ex(paramInt));
    AppMethodBeat.o(92382);
    return parama;
  }
  
  final a a(a parama, j.b paramb)
  {
    AppMethodBeat.i(92383);
    long l3 = parama.aRR;
    long l2 = parama.aSy;
    boolean bool1 = b(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.aRb.a(paramb.blw, this.aQV, false);
    long l1;
    if (paramb.tQ()) {
      l1 = this.aQV.bf(paramb.blx, paramb.bly);
    }
    for (;;)
    {
      parama = new a(paramb, l3, l2, parama.aRS, l1, bool1, bool2, (byte)0);
      AppMethodBeat.o(92383);
      return parama;
      if (l2 == -9223372036854775808L) {
        l1 = this.aQV.aSz;
      } else {
        l1 = l2;
      }
    }
  }
  
  final a a(j.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92384);
    this.aRb.a(paramb.blw, this.aQV, false);
    if (paramb.tQ())
    {
      if (!this.aQV.be(paramb.blx, paramb.bly))
      {
        AppMethodBeat.o(92384);
        return null;
      }
      paramb = b(paramb.blw, paramb.blx, paramb.bly, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
    int i = this.aQV.D(paramLong2);
    if (i == -1) {}
    for (paramLong1 = -9223372036854775808L;; paramLong1 = this.aQV.aTf[i])
    {
      paramb = b(paramb.blw, paramLong2, paramLong1);
      AppMethodBeat.o(92384);
      return paramb;
    }
  }
  
  final a b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(92385);
    Object localObject = new j.b(paramInt1, paramInt2, paramInt3);
    boolean bool1 = b((j.b)localObject, -9223372036854775808L);
    boolean bool2 = a((j.b)localObject, bool1);
    long l2 = this.aRb.a(((j.b)localObject).blw, this.aQV, false).bf(((j.b)localObject).blx, ((j.b)localObject).bly);
    if (paramInt3 == this.aQV.aTi[paramInt2]) {}
    for (long l1 = this.aQV.aTk;; l1 = 0L)
    {
      localObject = new a((j.b)localObject, l1, -9223372036854775808L, paramLong, l2, bool1, bool2, (byte)0);
      AppMethodBeat.o(92385);
      return localObject;
    }
  }
  
  final a b(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92386);
    Object localObject = new j.b(paramInt);
    boolean bool1 = b((j.b)localObject, paramLong2);
    boolean bool2 = a((j.b)localObject, bool1);
    this.aRb.a(((j.b)localObject).blw, this.aQV, false);
    if (paramLong2 == -9223372036854775808L) {}
    for (long l = this.aQV.aSz;; l = paramLong2)
    {
      localObject = new a((j.b)localObject, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, (byte)0);
      AppMethodBeat.o(92386);
      return localObject;
    }
  }
  
  public final j.b g(int paramInt, long paramLong)
  {
    AppMethodBeat.i(92381);
    this.aRb.a(paramInt, this.aQV, false);
    int i = this.aQV.C(paramLong);
    if (i == -1)
    {
      localb = new j.b(paramInt);
      AppMethodBeat.o(92381);
      return localb;
    }
    j.b localb = new j.b(paramInt, i, this.aQV.aTi[i]);
    AppMethodBeat.o(92381);
    return localb;
  }
  
  public static final class a
  {
    public final long aRR;
    public final long aRS;
    public final boolean aSA;
    public final boolean aSB;
    public final j.b aSx;
    public final long aSy;
    public final long aSz;
    
    a(j.b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.aSx = paramb;
      this.aRR = paramLong1;
      this.aSy = paramLong2;
      this.aRS = paramLong3;
      this.aSz = paramLong4;
      this.aSA = paramBoolean1;
      this.aSB = paramBoolean2;
    }
    
    public final a rI()
    {
      AppMethodBeat.i(92379);
      a locala = new a(this.aSx.ex(-1), this.aRR, this.aSy, this.aRS, this.aSz, this.aSA, this.aSB);
      AppMethodBeat.o(92379);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.n
 * JD-Core Version:    0.7.0.1
 */