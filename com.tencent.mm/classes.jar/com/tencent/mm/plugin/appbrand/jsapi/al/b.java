package com.tencent.mm.plugin.appbrand.jsapi.al;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;

public final class b
{
  public static int acG(String paramString)
  {
    AppMethodBeat.i(326987);
    paramString = k.Uo(paramString);
    int i = 1;
    if (paramString == k.d.qrM) {
      i = 2;
    }
    for (;;)
    {
      AppMethodBeat.o(326987);
      return i;
      if (paramString == k.d.qrH) {
        i = 3;
      } else if (paramString == k.d.qrG) {
        i = 4;
      } else if (paramString == k.d.qrN) {
        i = 5;
      } else if (paramString == k.d.qrK) {
        i = 6;
      } else if (paramString == k.d.qrL) {
        i = 7;
      } else if (paramString == k.d.qrJ) {
        i = 8;
      }
    }
  }
  
  public static AppBrandRuntime z(a parama)
  {
    AppMethodBeat.i(326994);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.aqX();
      if ((parama instanceof ad))
      {
        parama = ((ad)parama).getRuntime();
        AppMethodBeat.o(326994);
        return parama;
      }
      if ((parama instanceof y))
      {
        parama = ((y)parama).getRuntime();
        AppMethodBeat.o(326994);
        return parama;
      }
      AppMethodBeat.o(326994);
      return null;
    }
    AppMethodBeat.o(326994);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b
 * JD-Core Version:    0.7.0.1
 */