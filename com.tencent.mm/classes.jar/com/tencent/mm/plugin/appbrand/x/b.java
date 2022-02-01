package com.tencent.mm.plugin.appbrand.x;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static void L(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(140799);
    a.a.buf().K(paramString1, paramString2, paramString3);
    AppMethodBeat.o(140799);
  }
  
  public static void b(String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(140798);
    a.a.buf().a(paramString1, paramString2, paramb);
    AppMethodBeat.o(140798);
  }
  
  public static final class a
  {
    private static final b lXk;
    
    static
    {
      AppMethodBeat.i(140794);
      lXk = new b();
      AppMethodBeat.o(140794);
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140797);
      lXl = new b("INIT", 0);
      lXm = new b("PREPARE_RESOUCE", 1);
      lXn = new b("INJECT_JS", 2);
      lXo = new b("PREPARE_RENDER", 3);
      lXp = new b("JS_ERROR", 4);
      lXq = new b[] { lXl, lXm, lXn, lXo, lXp };
      AppMethodBeat.o(140797);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.b
 * JD-Core Version:    0.7.0.1
 */