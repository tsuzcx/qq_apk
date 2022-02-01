package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.e;
import com.google.a.h;
import com.google.a.o;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l<T>
  extends r<T>
{
  private r<T> bLl;
  final e bMJ;
  private final o<T> bMX;
  private final h<T> bMY;
  private final com.google.a.c.a<T> bMZ;
  private final s bNa;
  private final l<T>.a bNb;
  
  public l(o<T> paramo, h<T> paramh, e parame, com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(107986);
    this.bNb = new a((byte)0);
    this.bMX = paramo;
    this.bMY = paramh;
    this.bMJ = parame;
    this.bMZ = parama;
    this.bNa = null;
    AppMethodBeat.o(107986);
  }
  
  private r<T> zn()
  {
    AppMethodBeat.i(222790);
    r localr = this.bLl;
    if (localr != null)
    {
      AppMethodBeat.o(222790);
      return localr;
    }
    localr = this.bMJ.a(this.bNa, this.bMZ);
    this.bLl = localr;
    AppMethodBeat.o(222790);
    return localr;
  }
  
  public final T a(com.google.a.d.a parama)
  {
    AppMethodBeat.i(222786);
    if (this.bMY == null)
    {
      parama = zn().a(parama);
      AppMethodBeat.o(222786);
      return parama;
    }
    if ((com.google.a.b.k.c(parama) instanceof com.google.a.k))
    {
      AppMethodBeat.o(222786);
      return null;
    }
    parama = this.bMY.zc();
    AppMethodBeat.o(222786);
    return parama;
  }
  
  public final void a(c paramc, T paramT)
  {
    AppMethodBeat.i(107987);
    if (this.bMX == null)
    {
      zn().a(paramc, paramT);
      AppMethodBeat.o(107987);
      return;
    }
    if (paramT == null)
    {
      paramc.zK();
      AppMethodBeat.o(107987);
      return;
    }
    com.google.a.b.k.a(this.bMX.ze(), paramc);
    AppMethodBeat.o(107987);
  }
  
  final class a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */