package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a doM;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(201244);
    sLibraryLoaded = false;
    doM = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(201242);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(201242);
      }
    };
    AppMethodBeat.o(201244);
  }
  
  public static void a(a parama)
  {
    doM = parama;
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(201243);
    doM.loadLibrary(paramString);
    AppMethodBeat.o(201243);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.b
 * JD-Core Version:    0.7.0.1
 */