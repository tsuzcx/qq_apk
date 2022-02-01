package com.tencent.magicbrush.a;

import com.github.henryye.nativeiv.a.a;
import com.github.henryye.nativeiv.a.a.a;
import com.tencent.magicbrush.utils.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a cNq;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(139960);
    sLibraryLoaded = false;
    cNq = new b.1();
    AppMethodBeat.o(139960);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(139957);
    cNq = parama;
    a.a(new a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(139956);
        this.cNr.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(139956);
      }
    });
    AppMethodBeat.o(139957);
  }
  
  public static String eA(String paramString)
  {
    AppMethodBeat.i(203620);
    paramString = cNq.eA(paramString);
    AppMethodBeat.o(203620);
    return paramString;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(139959);
    if (sLibraryLoaded)
    {
      c.c.i("MagicBrush", "library already loaded", new Object[0]);
      AppMethodBeat.o(139959);
      return;
    }
    long l1 = i.currentTicks();
    c.c.i("MagicBrush", "start loadLibraries", new Object[0]);
    long l2 = i.currentTicks();
    cNq.loadLibrary("mmv8");
    long l3 = i.currentTicks();
    cNq.loadLibrary("magicbrush");
    sLibraryLoaded = true;
    c.c.i("MagicBrush", "total[%d]ms load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", new Object[] { Long.valueOf(i.ticksToNow(l1)), Long.valueOf(l3 - l2), Long.valueOf(i.ticksToNow(l3)) });
    AppMethodBeat.o(139959);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(139958);
    cNq.loadLibrary(paramString);
    AppMethodBeat.o(139958);
  }
  
  public static abstract interface a
  {
    public abstract String eA(String paramString);
    
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.a.b
 * JD-Core Version:    0.7.0.1
 */