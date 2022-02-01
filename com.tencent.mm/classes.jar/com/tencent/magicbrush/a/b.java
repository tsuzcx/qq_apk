package com.tencent.magicbrush.a;

import com.github.henryye.nativeiv.a.a;
import com.github.henryye.nativeiv.a.a.a;
import com.tencent.magicbrush.utils.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a eIL;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(139960);
    sLibraryLoaded = false;
    eIL = new b.1();
    AppMethodBeat.o(139960);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(139957);
    eIL = parama;
    a.a(new a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(139956);
        b.this.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(139956);
      }
    });
    AppMethodBeat.o(139957);
  }
  
  public static String fX(String paramString)
  {
    AppMethodBeat.i(228943);
    paramString = eIL.fX(paramString);
    AppMethodBeat.o(228943);
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
    eIL.loadLibrary("mmv8");
    long l3 = i.currentTicks();
    eIL.loadLibrary("magicbrush");
    sLibraryLoaded = true;
    c.c.i("MagicBrush", "total[%d]ms load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", new Object[] { Long.valueOf(i.ticksToNow(l1)), Long.valueOf(l3 - l2), Long.valueOf(i.ticksToNow(l3)) });
    AppMethodBeat.o(139959);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(139958);
    eIL.loadLibrary(paramString);
    AppMethodBeat.o(139958);
  }
  
  public static abstract interface a
  {
    public abstract String fX(String paramString);
    
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.a.b
 * JD-Core Version:    0.7.0.1
 */