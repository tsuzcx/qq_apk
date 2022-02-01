package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b jIh;
  private static String jIi;
  
  static
  {
    AppMethodBeat.i(200797);
    jIh = new a.1();
    AppMethodBeat.o(200797);
  }
  
  public static void a(String paramString, b paramb)
  {
    jIi = paramString;
    jIh = paramb;
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(200796);
    jIh.b(paramString1, paramThrowable, paramString2);
    new StringBuilder().append(jIi).append(paramString1);
    AppMethodBeat.o(200796);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200795);
    jIh.e(jIi + paramString1, paramString2);
    new StringBuilder().append(jIi).append(paramString1);
    AppMethodBeat.o(200795);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200794);
    jIh.i(jIi + paramString1, paramString2);
    new StringBuilder().append(jIi).append(paramString1);
    AppMethodBeat.o(200794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a
 * JD-Core Version:    0.7.0.1
 */