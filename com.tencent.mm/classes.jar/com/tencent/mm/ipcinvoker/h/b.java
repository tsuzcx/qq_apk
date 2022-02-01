package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static com.tencent.mm.ipcinvoker.h.a.a gAO;
  
  static
  {
    AppMethodBeat.i(158839);
    gAO = new a();
    AppMethodBeat.o(158839);
  }
  
  public static boolean b(com.tencent.mm.ipcinvoker.h.a.a parama)
  {
    if (parama == null) {
      return false;
    }
    gAO = parama;
    return true;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158838);
    gAO.printLog(3, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(158838);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158836);
    gAO.printLog(6, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(158836);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158835);
    gAO.printLog(4, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(158835);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158837);
    gAO.printLog(5, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(158837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h.b
 * JD-Core Version:    0.7.0.1
 */