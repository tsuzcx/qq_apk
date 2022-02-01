package com.tencent.magicbrush.a;

import com.github.henryye.nativeiv.a.a;
import com.github.henryye.nativeiv.a.a.a;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a cMD;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(139960);
    sLibraryLoaded = false;
    cMD = new a()
    {
      public final String dZ(String paramAnonymousString)
      {
        AppMethodBeat.i(206805);
        paramAnonymousString = h.findLibPath(paramAnonymousString);
        AppMethodBeat.o(206805);
        return paramAnonymousString;
      }
      
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(139955);
        h.ef(paramAnonymousString);
        AppMethodBeat.o(139955);
      }
    };
    AppMethodBeat.o(139960);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(139957);
    cMD = parama;
    a.a(new a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(139956);
        this.cME.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(139956);
      }
    });
    AppMethodBeat.o(139957);
  }
  
  public static String dZ(String paramString)
  {
    AppMethodBeat.i(206806);
    paramString = cMD.dZ(paramString);
    AppMethodBeat.o(206806);
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
    long l1 = h.currentTicks();
    c.c.i("MagicBrush", "start loadLibraries", new Object[0]);
    long l2 = h.currentTicks();
    cMD.loadLibrary("mmv8");
    long l3 = h.currentTicks();
    cMD.loadLibrary("magicbrush");
    sLibraryLoaded = true;
    c.c.i("MagicBrush", "total[%d]ms load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", new Object[] { Long.valueOf(h.ticksToNow(l1)), Long.valueOf(l3 - l2), Long.valueOf(h.ticksToNow(l3)) });
    AppMethodBeat.o(139959);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(139958);
    cMD.loadLibrary(paramString);
    AppMethodBeat.o(139958);
  }
  
  public static abstract interface a
  {
    public abstract String dZ(String paramString);
    
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.a.b
 * JD-Core Version:    0.7.0.1
 */