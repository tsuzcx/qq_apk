package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static com.tencent.mm.ipcinvoker.h.a.a eEQ;
  
  static
  {
    AppMethodBeat.i(114128);
    eEQ = new a();
    AppMethodBeat.o(114128);
  }
  
  public static boolean b(com.tencent.mm.ipcinvoker.h.a.a parama)
  {
    if (parama == null) {
      return false;
    }
    eEQ = parama;
    return true;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(114127);
    eEQ.a(3, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(114127);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(114125);
    eEQ.a(6, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(114125);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(114124);
    eEQ.a(4, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(114124);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(114126);
    eEQ.a(5, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(114126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h.b
 * JD-Core Version:    0.7.0.1
 */