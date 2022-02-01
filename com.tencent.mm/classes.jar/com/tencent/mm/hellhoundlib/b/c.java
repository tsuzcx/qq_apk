package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static ThreadLocal<a> mxr;
  
  static
  {
    AppMethodBeat.i(183796);
    mxr = new ThreadLocal();
    AppMethodBeat.o(183796);
  }
  
  public static a a(int paramInt, a parama)
  {
    AppMethodBeat.i(183795);
    parama.cG(Integer.valueOf(paramInt));
    AppMethodBeat.o(183795);
    return parama;
  }
  
  public static a a(long paramLong, a parama)
  {
    AppMethodBeat.i(231507);
    parama.cG(Long.valueOf(paramLong));
    AppMethodBeat.o(231507);
    return parama;
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(231501);
    mxr.set(parama);
    AppMethodBeat.o(231501);
    return parama;
  }
  
  public static a aYk()
  {
    AppMethodBeat.i(231504);
    a locala = (a)mxr.get();
    mxr.remove();
    AppMethodBeat.o(231504);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.c
 * JD-Core Version:    0.7.0.1
 */