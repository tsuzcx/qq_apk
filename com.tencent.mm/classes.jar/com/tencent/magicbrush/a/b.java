package com.tencent.magicbrush.a;

import com.github.henryye.nativeiv.a.a;
import com.github.henryye.nativeiv.a.a.a;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a cxP;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(139960);
    sLibraryLoaded = false;
    cxP = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(139955);
        h.dH(paramAnonymousString);
        AppMethodBeat.o(139955);
      }
    };
    AppMethodBeat.o(139960);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(139957);
    cxP = parama;
    a.a(new a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(139956);
        this.cxQ.loadLibrary(paramAnonymousString);
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
    cxP.loadLibrary("mmavmedia");
    cxP.loadLibrary("mmmediasdk");
    cxP.loadLibrary("mmbox2d");
    cxP.loadLibrary("mmphysx");
    long l1 = h.HI();
    cxP.loadLibrary("mmv8");
    long l2 = h.HI();
    cxP.loadLibrary("magicbrush");
    sLibraryLoaded = true;
    c.c.i("MagicBrush", "load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", new Object[] { Long.valueOf(h.aO(l2)), Long.valueOf(l2 - l1) });
    AppMethodBeat.o(139959);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(139958);
    cxP.loadLibrary(paramString);
    AppMethodBeat.o(139958);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.a.b
 * JD-Core Version:    0.7.0.1
 */