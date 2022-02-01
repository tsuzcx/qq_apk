package com.google.c.b.a;

import com.google.c.d.c;
import com.google.c.e;
import com.google.c.h;
import com.google.c.o;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l<T>
  extends r<T>
{
  private r<T> dET;
  private final o<T> dGC;
  private final h<T> dGD;
  private final com.google.c.c.a<T> dGE;
  private final s dGF;
  private final l<T>.a dGG;
  final e dGo;
  
  public l(o<T> paramo, h<T> paramh, e parame, com.google.c.c.a<T> parama)
  {
    AppMethodBeat.i(107986);
    this.dGG = new a((byte)0);
    this.dGC = paramo;
    this.dGD = paramh;
    this.dGo = parame;
    this.dGE = parama;
    this.dGF = null;
    AppMethodBeat.o(107986);
  }
  
  private r<T> YY()
  {
    AppMethodBeat.i(208896);
    r localr = this.dET;
    if (localr != null)
    {
      AppMethodBeat.o(208896);
      return localr;
    }
    localr = this.dGo.a(this.dGF, this.dGE);
    this.dET = localr;
    AppMethodBeat.o(208896);
    return localr;
  }
  
  public final T a(com.google.c.d.a parama)
  {
    AppMethodBeat.i(208898);
    if (this.dGD == null)
    {
      parama = YY().a(parama);
      AppMethodBeat.o(208898);
      return parama;
    }
    if ((com.google.c.b.k.c(parama) instanceof com.google.c.k))
    {
      AppMethodBeat.o(208898);
      return null;
    }
    parama = this.dGD.YN();
    AppMethodBeat.o(208898);
    return parama;
  }
  
  public final void a(c paramc, T paramT)
  {
    AppMethodBeat.i(107987);
    if (this.dGC == null)
    {
      YY().a(paramc, paramT);
      AppMethodBeat.o(107987);
      return;
    }
    if (paramT == null)
    {
      paramc.Zv();
      AppMethodBeat.o(107987);
      return;
    }
    com.google.c.b.k.a(this.dGC.YP(), paramc);
    AppMethodBeat.o(107987);
  }
  
  final class a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.l
 * JD-Core Version:    0.7.0.1
 */