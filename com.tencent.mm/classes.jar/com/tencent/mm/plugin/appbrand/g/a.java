package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b kct;
  private static String kcu;
  
  static
  {
    AppMethodBeat.i(192859);
    kct = new a.1();
    AppMethodBeat.o(192859);
  }
  
  public static void a(String paramString, b paramb)
  {
    kcu = paramString;
    kct = paramb;
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(192858);
    kct.b(paramString1, paramThrowable, paramString2);
    new StringBuilder().append(kcu).append(paramString1);
    AppMethodBeat.o(192858);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192857);
    kct.e(kcu + paramString1, paramString2);
    new StringBuilder().append(kcu).append(paramString1);
    AppMethodBeat.o(192857);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192856);
    kct.i(kcu + paramString1, paramString2);
    new StringBuilder().append(kcu).append(paramString1);
    AppMethodBeat.o(192856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a
 * JD-Core Version:    0.7.0.1
 */