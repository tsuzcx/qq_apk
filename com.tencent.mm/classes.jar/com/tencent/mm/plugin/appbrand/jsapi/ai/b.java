package com.tencent.mm.plugin.appbrand.jsapi.ai;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;

public final class b
{
  public static int ajG(String paramString)
  {
    AppMethodBeat.i(224194);
    paramString = k.abM(paramString);
    int i = 1;
    if (paramString == k.d.nth) {
      i = 2;
    }
    for (;;)
    {
      AppMethodBeat.o(224194);
      return i;
      if (paramString == k.d.ntc) {
        i = 3;
      } else if (paramString == k.d.ntb) {
        i = 4;
      } else if (paramString == k.d.nti) {
        i = 5;
      } else if (paramString == k.d.ntf) {
        i = 6;
      } else if (paramString == k.d.ntg) {
        i = 7;
      } else if (paramString == k.d.nte) {
        i = 8;
      }
    }
  }
  
  public static AppBrandRuntime z(a parama)
  {
    AppMethodBeat.i(224202);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.QK();
      if ((parama instanceof ad))
      {
        parama = ((ad)parama).getRuntime();
        AppMethodBeat.o(224202);
        return parama;
      }
      if ((parama instanceof v))
      {
        parama = ((v)parama).getRuntime();
        AppMethodBeat.o(224202);
        return parama;
      }
      AppMethodBeat.o(224202);
      return null;
    }
    AppMethodBeat.o(224202);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.b
 * JD-Core Version:    0.7.0.1
 */