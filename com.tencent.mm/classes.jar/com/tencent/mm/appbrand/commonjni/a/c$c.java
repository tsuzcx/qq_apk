package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$c
{
  private static c.b fht;
  
  static
  {
    AppMethodBeat.i(246870);
    fht = new c.a((byte)0);
    AppMethodBeat.o(246870);
  }
  
  public static void a(c.b paramb)
  {
    fht = paramb;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(246868);
    fht.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(246868);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(246865);
    fht.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(246865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.c.c
 * JD-Core Version:    0.7.0.1
 */