package com.tencent.mm.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a jTd;
  
  static
  {
    AppMethodBeat.i(43439);
    jTd = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(43437);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(43437);
      }
    };
    AppMethodBeat.o(43439);
  }
  
  public static void a(a parama)
  {
    jTd = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(43438);
    jTd.loadLibrary("mmlockstep");
    AppMethodBeat.o(43438);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.b.a
 * JD-Core Version:    0.7.0.1
 */