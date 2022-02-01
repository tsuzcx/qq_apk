package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  public static com.tencent.mm.plugin.appbrand.jsapi.ac.a f(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(186722);
    ad.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide");
    parama = parama.El();
    if ((parama instanceof aa)) {
      parama = ((aa)parama).getRuntime();
    }
    while (parama == null)
    {
      ad.w("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is null");
      AppMethodBeat.o(186722);
      return null;
      if ((parama instanceof q)) {
        parama = ((q)parama).getRuntime();
      } else {
        parama = null;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.ac.a locala2 = (com.tencent.mm.plugin.appbrand.jsapi.ac.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.ac.a.class);
    com.tencent.mm.plugin.appbrand.jsapi.ac.a locala1 = locala2;
    if (locala2 == null)
    {
      ad.i("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, create");
      locala1 = new com.tencent.mm.plugin.appbrand.jsapi.ac.a(parama);
      parama.a(locala1);
    }
    AppMethodBeat.o(186722);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.e
 * JD-Core Version:    0.7.0.1
 */