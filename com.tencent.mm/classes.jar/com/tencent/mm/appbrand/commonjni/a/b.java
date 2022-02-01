package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a fhs;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(246851);
    sLibraryLoaded = false;
    fhs = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(246841);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(246841);
      }
    };
    AppMethodBeat.o(246851);
  }
  
  public static void a(a parama)
  {
    fhs = parama;
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(246850);
    fhs.loadLibrary(paramString);
    AppMethodBeat.o(246850);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.b
 * JD-Core Version:    0.7.0.1
 */