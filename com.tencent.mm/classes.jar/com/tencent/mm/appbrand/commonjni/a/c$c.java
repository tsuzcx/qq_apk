package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$c
{
  private static c.b doN;
  
  static
  {
    AppMethodBeat.i(201251);
    doN = new c.a((byte)0);
    AppMethodBeat.o(201251);
  }
  
  public static void a(c.b paramb)
  {
    doN = paramb;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(201250);
    doN.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(201250);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(201248);
    doN.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(201248);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(201249);
    doN.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(201249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.c.c
 * JD-Core Version:    0.7.0.1
 */