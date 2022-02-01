package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b oec;
  private static String oed;
  
  static
  {
    AppMethodBeat.i(230722);
    oec = new b()
    {
      public final void a(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2) {}
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    AppMethodBeat.o(230722);
  }
  
  public static void a(String paramString, b paramb)
  {
    oed = paramString;
    oec = paramb;
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(230720);
    oec.a(paramString1, paramThrowable, paramString2);
    new StringBuilder().append(oed).append(paramString1);
    AppMethodBeat.o(230720);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(230717);
    oec.e(oed + paramString1, paramString2);
    new StringBuilder().append(oed).append(paramString1);
    AppMethodBeat.o(230717);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(230715);
    oec.i(oed + paramString1, paramString2);
    new StringBuilder().append(oed).append(paramString1);
    AppMethodBeat.o(230715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a
 * JD-Core Version:    0.7.0.1
 */