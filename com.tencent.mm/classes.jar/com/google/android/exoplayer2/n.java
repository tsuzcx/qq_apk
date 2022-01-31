package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.f.b;

final class n
{
  final w.b atk = new w.b();
  final w.a atl = new w.a();
  w atr;
  int repeatMode;
  
  private boolean a(f.b paramb, boolean paramBoolean)
  {
    int i = this.atr.a(paramb.aIm, this.atl, false).auk;
    if (!this.atr.a(i, this.atk, 0L).avF)
    {
      if (this.atr.a(paramb.aIm, this.atl, this.atk, this.repeatMode) == -1) {}
      for (i = 1; (i != 0) && (paramBoolean); i = 0) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(f.b paramb, long paramLong)
  {
    int i = this.atr.a(paramb.aIm, this.atl, false).kX();
    if (i == 0) {}
    for (;;)
    {
      return true;
      int j = i - 1;
      boolean bool = paramb.mG();
      if (this.atl.avw[j] != -9223372036854775808L)
      {
        if ((bool) || (paramLong != -9223372036854775808L)) {
          return false;
        }
      }
      else
      {
        int k = this.atl.avx[j];
        if (k == -1) {
          return false;
        }
        if ((bool) && (paramb.aIn == j) && (paramb.aIo == k - 1)) {}
        for (i = 1; (i == 0) && ((bool) || (this.atl.avz[j] != k)); i = 0) {
          return false;
        }
      }
    }
  }
  
  public final n.a a(n.a parama, int paramInt)
  {
    return a(parama, parama.auN.dg(paramInt));
  }
  
  final n.a a(n.a parama, f.b paramb)
  {
    long l3 = parama.aug;
    long l2 = parama.auO;
    boolean bool1 = b(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.atr.a(paramb.aIm, this.atl, false);
    long l1;
    if (paramb.mG()) {
      l1 = this.atl.aE(paramb.aIn, paramb.aIo);
    }
    for (;;)
    {
      return new n.a(paramb, l3, l2, parama.auh, l1, bool1, bool2, (byte)0);
      if (l2 == -9223372036854775808L) {
        l1 = this.atl.auP;
      } else {
        l1 = l2;
      }
    }
  }
  
  final n.a a(f.b paramb, long paramLong1, long paramLong2)
  {
    this.atr.a(paramb.aIm, this.atl, false);
    if (paramb.mG())
    {
      if (!this.atl.aD(paramb.aIn, paramb.aIo)) {
        return null;
      }
      return b(paramb.aIm, paramb.aIn, paramb.aIo, paramLong1);
    }
    int i = this.atl.z(paramLong2);
    if (i == -1) {}
    for (paramLong1 = -9223372036854775808L;; paramLong1 = this.atl.avw[i]) {
      return b(paramb.aIm, paramLong2, paramLong1);
    }
  }
  
  final n.a b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    f.b localb = new f.b(paramInt1, paramInt2, paramInt3);
    boolean bool1 = b(localb, -9223372036854775808L);
    boolean bool2 = a(localb, bool1);
    long l2 = this.atr.a(localb.aIm, this.atl, false).aE(localb.aIn, localb.aIo);
    if (paramInt3 == this.atl.avz[paramInt2]) {}
    for (long l1 = this.atl.avB;; l1 = 0L) {
      return new n.a(localb, l1, -9223372036854775808L, paramLong, l2, bool1, bool2, (byte)0);
    }
  }
  
  final n.a b(int paramInt, long paramLong1, long paramLong2)
  {
    f.b localb = new f.b(paramInt);
    boolean bool1 = b(localb, paramLong2);
    boolean bool2 = a(localb, bool1);
    this.atr.a(localb.aIm, this.atl, false);
    if (paramLong2 == -9223372036854775808L) {}
    for (long l = this.atl.auP;; l = paramLong2) {
      return new n.a(localb, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, (byte)0);
    }
  }
  
  public final f.b e(int paramInt, long paramLong)
  {
    this.atr.a(paramInt, this.atl, false);
    int i = this.atl.y(paramLong);
    if (i == -1) {
      return new f.b(paramInt);
    }
    return new f.b(paramInt, i, this.atl.avz[i]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.n
 * JD-Core Version:    0.7.0.1
 */