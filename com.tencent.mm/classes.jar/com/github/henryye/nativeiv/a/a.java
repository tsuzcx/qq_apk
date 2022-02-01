package com.github.henryye.nativeiv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a cEK;
  
  static
  {
    AppMethodBeat.i(127379);
    cEK = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(127377);
        paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aYi(), "com/github/henryye/nativeiv/delegate/LibraryLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)paramAnonymousString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/github/henryye/nativeiv/delegate/LibraryLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        AppMethodBeat.o(127377);
      }
    };
    AppMethodBeat.o(127379);
  }
  
  public static void a(a parama)
  {
    cEK = parama;
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(127378);
    cEK.loadLibrary(paramString);
    AppMethodBeat.o(127378);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.a.a
 * JD-Core Version:    0.7.0.1
 */