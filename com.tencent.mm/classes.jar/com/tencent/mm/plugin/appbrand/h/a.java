package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b jhS;
  private static String jhT;
  
  static
  {
    AppMethodBeat.i(195134);
    jhS = new a.1();
    AppMethodBeat.o(195134);
  }
  
  public static void a(String paramString, b paramb)
  {
    jhT = paramString;
    jhS = paramb;
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(195133);
    jhS.b(paramString1, paramThrowable, paramString2);
    new StringBuilder().append(jhT).append(paramString1);
    AppMethodBeat.o(195133);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195132);
    jhS.e(jhT + paramString1, paramString2);
    new StringBuilder().append(jhT).append(paramString1);
    AppMethodBeat.o(195132);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195131);
    jhS.i(jhT + paramString1, paramString2);
    new StringBuilder().append(jhT).append(paramString1);
    AppMethodBeat.o(195131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a
 * JD-Core Version:    0.7.0.1
 */