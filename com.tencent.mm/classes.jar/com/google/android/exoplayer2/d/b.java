package com.google.android.exoplayer2.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static boolean DEBUG = true;
  private static a cWu = null;
  
  public static void a(a parama)
  {
    cWu = parama;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92351);
    if (cWu != null) {
      cWu.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(92351);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92349);
    if (cWu != null) {
      cWu.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(92349);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92350);
    if (cWu != null) {
      cWu.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(92350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.d.b
 * JD-Core Version:    0.7.0.1
 */