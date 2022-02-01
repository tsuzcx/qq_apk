package com.tencent.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  private static boolean ZRD = false;
  private static boolean jxV = true;
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(207852);
    if (jxV) {
      Log.w(paramString, "", new Object[] { paramThrowable });
    }
    AppMethodBeat.o(207852);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207850);
    if (jxV) {
      Log.d(paramString1, paramString2);
    }
    AppMethodBeat.o(207850);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(207849);
    if (jxV) {
      Log.e(paramString, "", new Object[] { paramThrowable });
    }
    AppMethodBeat.o(207849);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207847);
    if (jxV) {
      Log.i(paramString1, paramString2);
    }
    AppMethodBeat.o(207847);
  }
  
  public static void itz()
  {
    jxV = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.c.i
 * JD-Core Version:    0.7.0.1
 */