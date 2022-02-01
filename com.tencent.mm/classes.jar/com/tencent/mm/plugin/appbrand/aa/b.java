package com.tencent.mm.plugin.appbrand.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static void N(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(140799);
    a.a.bVC().M(paramString1, paramString2, paramString3);
    AppMethodBeat.o(140799);
  }
  
  public static void b(String paramString1, String paramString2, b.b paramb)
  {
    AppMethodBeat.i(140798);
    a.a.bVC().a(paramString1, paramString2, paramb);
    AppMethodBeat.o(140798);
  }
  
  public static final class a
  {
    private static final b nOf;
    
    static
    {
      AppMethodBeat.i(140794);
      nOf = new b();
      AppMethodBeat.o(140794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.b
 * JD-Core Version:    0.7.0.1
 */