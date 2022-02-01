package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b ljt;
  private static String lju;
  
  static
  {
    AppMethodBeat.i(222902);
    ljt = new a.1();
    AppMethodBeat.o(222902);
  }
  
  public static void a(String paramString, b paramb)
  {
    lju = paramString;
    ljt = paramb;
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(222901);
    ljt.a(paramString1, paramThrowable, paramString2);
    new StringBuilder().append(lju).append(paramString1);
    AppMethodBeat.o(222901);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222900);
    ljt.e(lju + paramString1, paramString2);
    new StringBuilder().append(lju).append(paramString1);
    AppMethodBeat.o(222900);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222899);
    ljt.i(lju + paramString1, paramString2);
    new StringBuilder().append(lju).append(paramString1);
    AppMethodBeat.o(222899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a
 * JD-Core Version:    0.7.0.1
 */