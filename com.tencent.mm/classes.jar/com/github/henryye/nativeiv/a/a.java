package com.github.henryye.nativeiv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a aKO;
  
  static
  {
    AppMethodBeat.i(127379);
    aKO = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(127377);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(127377);
      }
    };
    AppMethodBeat.o(127379);
  }
  
  public static void a(a parama)
  {
    aKO = parama;
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(127378);
    aKO.loadLibrary(paramString);
    AppMethodBeat.o(127378);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.a.a
 * JD-Core Version:    0.7.0.1
 */