package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.a.a;

public final class c
{
  private static a mzt;
  
  static
  {
    AppMethodBeat.i(158839);
    mzt = new b();
    AppMethodBeat.o(158839);
  }
  
  public static boolean b(a parama)
  {
    if (parama == null) {
      return false;
    }
    mzt = parama;
    return true;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158838);
    mzt.printLog(3, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(158838);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158836);
    mzt.printLog(6, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(158836);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158835);
    mzt.printLog(4, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(158835);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(235661);
    mzt.printLog(2, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(235661);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158837);
    mzt.printLog(5, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(158837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h.c
 * JD-Core Version:    0.7.0.1
 */