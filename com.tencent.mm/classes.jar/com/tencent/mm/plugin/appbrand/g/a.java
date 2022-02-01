package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b rhI;
  private static String rhJ;
  
  static
  {
    AppMethodBeat.i(317288);
    rhI = new a.1();
    AppMethodBeat.o(317288);
  }
  
  public static void a(String paramString, b paramb)
  {
    rhJ = paramString;
    rhI = paramb;
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(317287);
    rhI.a(paramString1, paramThrowable, paramString2);
    new StringBuilder().append(rhJ).append(paramString1);
    AppMethodBeat.o(317287);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317284);
    rhI.e(rhJ + paramString1, paramString2);
    new StringBuilder().append(rhJ).append(paramString1);
    AppMethodBeat.o(317284);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317281);
    rhI.i(rhJ + paramString1, paramString2);
    new StringBuilder().append(rhJ).append(paramString1);
    AppMethodBeat.o(317281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a
 * JD-Core Version:    0.7.0.1
 */