package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
{
  public static com.tencent.mm.plugin.appbrand.jsapi.ad.a f(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(220405);
    ae.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide");
    parama = parama.Eo();
    if ((parama instanceof z)) {
      parama = ((z)parama).getRuntime();
    }
    while (parama == null)
    {
      ae.w("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is null");
      AppMethodBeat.o(220405);
      return null;
      if ((parama instanceof r)) {
        parama = ((r)parama).getRuntime();
      } else {
        parama = null;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.ad.a locala2 = (com.tencent.mm.plugin.appbrand.jsapi.ad.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.ad.a.class);
    com.tencent.mm.plugin.appbrand.jsapi.ad.a locala1 = locala2;
    if (locala2 == null)
    {
      ae.i("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, create");
      locala1 = new com.tencent.mm.plugin.appbrand.jsapi.ad.a(parama);
      parama.a(locala1);
    }
    AppMethodBeat.o(220405);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.e
 * JD-Core Version:    0.7.0.1
 */