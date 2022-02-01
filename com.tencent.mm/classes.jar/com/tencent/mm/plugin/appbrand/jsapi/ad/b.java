package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;

public final class b
{
  public static int Sg(String paramString)
  {
    AppMethodBeat.i(220581);
    paramString = h.KU(paramString);
    int i = 1;
    if (paramString == h.d.jzn) {
      i = 2;
    }
    for (;;)
    {
      AppMethodBeat.o(220581);
      return i;
      if (paramString == h.d.jzi) {
        i = 3;
      } else if (paramString == h.d.jzh) {
        i = 4;
      } else if (paramString == h.d.jzo) {
        i = 5;
      } else if (paramString == h.d.jzl) {
        i = 6;
      } else if (paramString == h.d.jzm) {
        i = 7;
      } else if (paramString == h.d.jzk) {
        i = 8;
      }
    }
  }
  
  public static AppBrandRuntime y(a parama)
  {
    AppMethodBeat.i(220582);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.Eo();
      if ((parama instanceof z))
      {
        parama = ((z)parama).getRuntime();
        AppMethodBeat.o(220582);
        return parama;
      }
      if ((parama instanceof r))
      {
        parama = ((r)parama).getRuntime();
        AppMethodBeat.o(220582);
        return parama;
      }
      AppMethodBeat.o(220582);
      return null;
    }
    AppMethodBeat.o(220582);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.b
 * JD-Core Version:    0.7.0.1
 */