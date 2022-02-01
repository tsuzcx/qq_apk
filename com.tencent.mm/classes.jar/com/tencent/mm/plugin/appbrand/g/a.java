package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b kfK;
  private static String kfL;
  
  static
  {
    AppMethodBeat.i(208238);
    kfK = new a.1();
    AppMethodBeat.o(208238);
  }
  
  public static void a(String paramString, b paramb)
  {
    kfL = paramString;
    kfK = paramb;
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(208237);
    kfK.b(paramString1, paramThrowable, paramString2);
    new StringBuilder().append(kfL).append(paramString1);
    AppMethodBeat.o(208237);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208236);
    kfK.e(kfL + paramString1, paramString2);
    new StringBuilder().append(kfL).append(paramString1);
    AppMethodBeat.o(208236);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208235);
    kfK.i(kfL + paramString1, paramString2);
    new StringBuilder().append(kfL).append(paramString1);
    AppMethodBeat.o(208235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a
 * JD-Core Version:    0.7.0.1
 */