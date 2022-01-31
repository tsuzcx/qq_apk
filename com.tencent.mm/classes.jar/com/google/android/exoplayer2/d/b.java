package com.google.android.exoplayer2.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static boolean DEBUG = true;
  private static a aMD = null;
  
  public static void a(a parama)
  {
    aMD = parama;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(95229);
    if (aMD != null) {
      aMD.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(95229);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(95227);
    if (aMD != null) {
      aMD.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(95227);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(95228);
    if (aMD != null) {
      aMD.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(95228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.d.b
 * JD-Core Version:    0.7.0.1
 */