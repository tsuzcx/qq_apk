package com.tencent.magicbrush.a;

import com.tencent.magicbrush.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b.a bJt;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(115858);
    sLibraryLoaded = false;
    bJt = new b.1();
    AppMethodBeat.o(115858);
  }
  
  public static void a(b.a parama)
  {
    bJt = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(115857);
    if (sLibraryLoaded)
    {
      AppMethodBeat.o(115857);
      return;
    }
    long l1 = e.yB();
    bJt.loadLibrary("mmv8");
    long l2 = e.yB();
    bJt.loadLibrary("magicbrush");
    sLibraryLoaded = true;
    c.c.i("MagicBrush", "load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", new Object[] { Long.valueOf(e.av(l2)), Long.valueOf(l2 - l1) });
    AppMethodBeat.o(115857);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(115856);
    bJt.loadLibrary(paramString);
    AppMethodBeat.o(115856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.a.b
 * JD-Core Version:    0.7.0.1
 */