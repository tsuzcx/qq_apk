package com.tencent.mm.libwxaudio;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a khD;
  
  static
  {
    AppMethodBeat.i(199855);
    khD = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(199850);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(199850);
      }
    };
    AppMethodBeat.o(199855);
  }
  
  public static void a(a parama)
  {
    khD = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(199853);
    khD.loadLibrary("wxWtf");
    khD.loadLibrary("mmwebaudio");
    AppMethodBeat.o(199853);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.libwxaudio.a
 * JD-Core Version:    0.7.0.1
 */