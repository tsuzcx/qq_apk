package com.tencent.mm.plugin.appbrand.page.capsulebar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;

public final class a$a
{
  private static final a mkr;
  
  static
  {
    AppMethodBeat.i(207863);
    mkr = new a()
    {
      public final i.a a(a.b paramAnonymousb)
      {
        return i.mlb;
      }
      
      public final int bwn()
      {
        return -2147483648;
      }
    };
    AppMethodBeat.o(207863);
  }
  
  public static a a(AppBrandRuntime paramAppBrandRuntime, i.a parama)
  {
    AppMethodBeat.i(207862);
    paramAppBrandRuntime = new b(paramAppBrandRuntime, parama);
    AppMethodBeat.o(207862);
    return paramAppBrandRuntime;
  }
  
  public static a ag(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207861);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()) || (paramAppBrandRuntime.SB))
    {
      paramAppBrandRuntime = mkr;
      AppMethodBeat.o(207861);
      return paramAppBrandRuntime;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.jzJ.mkN;
    AppMethodBeat.o(207861);
    return paramAppBrandRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.a.a
 * JD-Core Version:    0.7.0.1
 */