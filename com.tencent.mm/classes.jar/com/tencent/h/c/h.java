package com.tencent.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  private static boolean SpY = false;
  private static boolean gNA = true;
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(214645);
    if (gNA) {
      Log.w(paramString, "", new Object[] { paramThrowable });
    }
    AppMethodBeat.o(214645);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214644);
    if (gNA) {
      Log.d(paramString1, paramString2);
    }
    AppMethodBeat.o(214644);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(214643);
    if (gNA) {
      Log.e(paramString, "", new Object[] { paramThrowable });
    }
    AppMethodBeat.o(214643);
  }
  
  public static void hpU()
  {
    gNA = false;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214642);
    if (gNA) {
      Log.i(paramString1, paramString2);
    }
    AppMethodBeat.o(214642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.h.c.h
 * JD-Core Version:    0.7.0.1
 */