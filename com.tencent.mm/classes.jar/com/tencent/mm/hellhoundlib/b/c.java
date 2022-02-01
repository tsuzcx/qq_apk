package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static ThreadLocal<a> jXx;
  
  static
  {
    AppMethodBeat.i(183796);
    jXx = new ThreadLocal();
    AppMethodBeat.o(183796);
  }
  
  public static a a(int paramInt, a parama)
  {
    AppMethodBeat.i(183795);
    parama.bm(Integer.valueOf(paramInt));
    AppMethodBeat.o(183795);
    return parama;
  }
  
  public static a a(long paramLong, a parama)
  {
    AppMethodBeat.i(215294);
    parama.bm(Long.valueOf(paramLong));
    AppMethodBeat.o(215294);
    return parama;
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(215290);
    jXx.set(parama);
    AppMethodBeat.o(215290);
    return parama;
  }
  
  public static a aFj()
  {
    AppMethodBeat.i(215292);
    a locala = (a)jXx.get();
    jXx.remove();
    AppMethodBeat.o(215292);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.c
 * JD-Core Version:    0.7.0.1
 */