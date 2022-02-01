package com.tencent.mm.libwxaudio;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a mIc;
  
  static
  {
    AppMethodBeat.i(234102);
    mIc = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(234095);
        paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aYi(), "com/tencent/mm/libwxaudio/WxAudioLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)paramAnonymousString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/libwxaudio/WxAudioLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        AppMethodBeat.o(234095);
      }
    };
    AppMethodBeat.o(234102);
  }
  
  public static void a(a parama)
  {
    mIc = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(234096);
    mIc.loadLibrary("wxWtf");
    mIc.loadLibrary("mmwebaudio");
    AppMethodBeat.o(234096);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.libwxaudio.a
 * JD-Core Version:    0.7.0.1
 */