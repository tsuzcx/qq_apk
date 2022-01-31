package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class t
{
  private static boolean ijo = false;
  
  public static i d(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73184);
    if (x.oC(paramInt))
    {
      paramString = new u(paramString, paramArrayOfByte);
      if (!(paramString instanceof c)) {
        break label82;
      }
      h.qsU.idkeyStat(434L, 5L, 1L, false);
      ab.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
    }
    for (;;)
    {
      h.qsU.idkeyStat(434L, 0L, 1L, false);
      AppMethodBeat.o(73184);
      return paramString;
      paramString = new c(paramString, paramArrayOfByte);
      break;
      label82:
      h.qsU.idkeyStat(434L, 6L, 1L, false);
      ab.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
    }
  }
  
  public static String f(i parami)
  {
    if ((parami instanceof v)) {
      return "WebView-Package";
    }
    if ((parami instanceof c)) {
      return "J2V8-Package";
    }
    if ((parami instanceof u)) {
      return "NodeJS";
    }
    return "unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.t
 * JD-Core Version:    0.7.0.1
 */