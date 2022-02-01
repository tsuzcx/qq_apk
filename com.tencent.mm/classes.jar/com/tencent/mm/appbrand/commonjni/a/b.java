package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a hlC;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(238554);
    sLibraryLoaded = false;
    hlC = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(238552);
        paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aYi(), "com/tencent/mm/appbrand/commonjni/delegates/LoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)paramAnonymousString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/appbrand/commonjni/delegates/LoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        AppMethodBeat.o(238552);
      }
    };
    AppMethodBeat.o(238554);
  }
  
  public static void a(a parama)
  {
    hlC = parama;
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(238547);
    hlC.loadLibrary(paramString);
    AppMethodBeat.o(238547);
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