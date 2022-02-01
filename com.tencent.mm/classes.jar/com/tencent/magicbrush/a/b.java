package com.tencent.magicbrush.a;

import com.github.henryye.nativeiv.a.a;
import com.github.henryye.nativeiv.a.a.a;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a cnk;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(139960);
    sLibraryLoaded = false;
    cnk = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(139955);
        h.cE(paramAnonymousString);
        AppMethodBeat.o(139955);
      }
    };
    AppMethodBeat.o(139960);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(139957);
    cnk = parama;
    a.a(new a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(139956);
        this.cnl.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(139956);
      }
    });
    AppMethodBeat.o(139957);
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(139959);
    if (sLibraryLoaded)
    {
      AppMethodBeat.o(139959);
      return;
    }
    c.c.i("MagicBrush", "start loadLibraries", new Object[0]);
    cnk.loadLibrary("mmavmedia");
    cnk.loadLibrary("mmmediasdk");
    cnk.loadLibrary("mmbox2d");
    cnk.loadLibrary("mmphysx");
    long l1 = h.Gn();
    cnk.loadLibrary("mmv8");
    long l2 = h.Gn();
    cnk.loadLibrary("magicbrush");
    sLibraryLoaded = true;
    c.c.i("MagicBrush", "load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", new Object[] { Long.valueOf(h.aO(l2)), Long.valueOf(l2 - l1) });
    AppMethodBeat.o(139959);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(139958);
    cnk.loadLibrary(paramString);
    AppMethodBeat.o(139958);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.a.b
 * JD-Core Version:    0.7.0.1
 */