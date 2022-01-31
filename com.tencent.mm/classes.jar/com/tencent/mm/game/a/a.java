package com.tencent.mm.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a.a ezH;
  
  static
  {
    AppMethodBeat.i(152620);
    ezH = new a.1();
    AppMethodBeat.o(152620);
  }
  
  public static void a(a.a parama)
  {
    ezH = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(152619);
    ezH.loadLibrary("mmlockstep");
    AppMethodBeat.o(152619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.a.a
 * JD-Core Version:    0.7.0.1
 */