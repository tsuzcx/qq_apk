package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static ThreadLocal<a> fYc;
  
  static
  {
    AppMethodBeat.i(183796);
    fYc = new ThreadLocal();
    AppMethodBeat.o(183796);
  }
  
  public static a a(int paramInt, a parama)
  {
    AppMethodBeat.i(183795);
    parama.bd(Integer.valueOf(paramInt));
    AppMethodBeat.o(183795);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.c
 * JD-Core Version:    0.7.0.1
 */