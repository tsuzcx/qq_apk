package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
{
  final w.b avC;
  final w.a avD;
  w avJ;
  int repeatMode;
  
  public n()
  {
    AppMethodBeat.i(95258);
    this.avD = new w.a();
    this.avC = new w.b();
    AppMethodBeat.o(95258);
  }
  
  private boolean a(i.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(95266);
    int i = this.avJ.a(paramb.aPX, this.avD, false).awC;
    if ((!this.avJ.a(i, this.avC).axV) && (this.avJ.b(paramb.aPX, this.avD, this.avC, this.repeatMode)) && (paramBoolean))
    {
      AppMethodBeat.o(95266);
      return true;
    }
    AppMethodBeat.o(95266);
    return false;
  }
  
  private boolean b(i.b paramb, long paramLong)
  {
    AppMethodBeat.i(95265);
    int i = this.avJ.a(paramb.aPX, this.avD, false).ng();
    if (i == 0)
    {
      AppMethodBeat.o(95265);
      return true;
    }
    int j = i - 1;
    boolean bool = paramb.pi();
    if (this.avD.axM[j] != -9223372036854775808L)
    {
      if ((!bool) && (paramLong == -9223372036854775808L))
      {
        AppMethodBeat.o(95265);
        return true;
      }
      AppMethodBeat.o(95265);
      return false;
    }
    int k = this.avD.axN[j];
    if (k == -1)
    {
      AppMethodBeat.o(95265);
      return false;
    }
    if ((bool) && (paramb.aPY == j) && (paramb.aPZ == k - 1)) {}
    for (i = 1; (i != 0) || ((!bool) && (this.avD.axP[j] == k)); i = 0)
    {
      AppMethodBeat.o(95265);
      return true;
    }
    AppMethodBeat.o(95265);
    return false;
  }
  
  public final n.a a(n.a parama, int paramInt)
  {
    AppMethodBeat.i(95260);
    parama = a(parama, parama.axf.dM(paramInt));
    AppMethodBeat.o(95260);
    return parama;
  }
  
  final n.a a(n.a parama, i.b paramb)
  {
    AppMethodBeat.i(95261);
    long l3 = parama.awy;
    long l2 = parama.axg;
    boolean bool1 = b(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.avJ.a(paramb.aPX, this.avD, false);
    long l1;
    if (paramb.pi()) {
      l1 = this.avD.aU(paramb.aPY, paramb.aPZ);
    }
    for (;;)
    {
      parama = new n.a(paramb, l3, l2, parama.awz, l1, bool1, bool2, (byte)0);
      AppMethodBeat.o(95261);
      return parama;
      if (l2 == -9223372036854775808L) {
        l1 = this.avD.axh;
      } else {
        l1 = l2;
      }
    }
  }
  
  final n.a a(i.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95262);
    this.avJ.a(paramb.aPX, this.avD, false);
    if (paramb.pi())
    {
      if (!this.avD.aT(paramb.aPY, paramb.aPZ))
      {
        AppMethodBeat.o(95262);
        return null;
      }
      paramb = b(paramb.aPX, paramb.aPY, paramb.aPZ, paramLong1);
      AppMethodBeat.o(95262);
      return paramb;
    }
    int i = this.avD.y(paramLong2);
    if (i == -1) {}
    for (paramLong1 = -9223372036854775808L;; paramLong1 = this.avD.axM[i])
    {
      paramb = b(paramb.aPX, paramLong2, paramLong1);
      AppMethodBeat.o(95262);
      return paramb;
    }
  }
  
  final n.a b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(95263);
    Object localObject = new i.b(paramInt1, paramInt2, paramInt3);
    boolean bool1 = b((i.b)localObject, -9223372036854775808L);
    boolean bool2 = a((i.b)localObject, bool1);
    long l2 = this.avJ.a(((i.b)localObject).aPX, this.avD, false).aU(((i.b)localObject).aPY, ((i.b)localObject).aPZ);
    if (paramInt3 == this.avD.axP[paramInt2]) {}
    for (long l1 = this.avD.axR;; l1 = 0L)
    {
      localObject = new n.a((i.b)localObject, l1, -9223372036854775808L, paramLong, l2, bool1, bool2, (byte)0);
      AppMethodBeat.o(95263);
      return localObject;
    }
  }
  
  final n.a b(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95264);
    Object localObject = new i.b(paramInt);
    boolean bool1 = b((i.b)localObject, paramLong2);
    boolean bool2 = a((i.b)localObject, bool1);
    this.avJ.a(((i.b)localObject).aPX, this.avD, false);
    if (paramLong2 == -9223372036854775808L) {}
    for (long l = this.avD.axh;; l = paramLong2)
    {
      localObject = new n.a((i.b)localObject, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, (byte)0);
      AppMethodBeat.o(95264);
      return localObject;
    }
  }
  
  public final i.b g(int paramInt, long paramLong)
  {
    AppMethodBeat.i(95259);
    this.avJ.a(paramInt, this.avD, false);
    int i = this.avD.x(paramLong);
    if (i == -1)
    {
      localb = new i.b(paramInt);
      AppMethodBeat.o(95259);
      return localb;
    }
    i.b localb = new i.b(paramInt, i, this.avD.axP[i]);
    AppMethodBeat.o(95259);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.n
 * JD-Core Version:    0.7.0.1
 */