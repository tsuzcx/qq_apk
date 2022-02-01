package com.tencent.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  private static boolean ahWa = false;
  private static boolean rPg = true;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212045);
    if (rPg) {
      Log.d(paramString1, paramString2);
    }
    AppMethodBeat.o(212045);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(212042);
    if (rPg) {
      Log.e(paramString, "", new Object[] { paramThrowable });
    }
    AppMethodBeat.o(212042);
  }
  
  public static void h(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(212050);
    if (rPg) {
      Log.w(paramString, "", new Object[] { paramThrowable });
    }
    AppMethodBeat.o(212050);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212038);
    if (rPg) {
      Log.i(paramString1, paramString2);
    }
    AppMethodBeat.o(212038);
  }
  
  public static void kcU()
  {
    rPg = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.c.i
 * JD-Core Version:    0.7.0.1
 */