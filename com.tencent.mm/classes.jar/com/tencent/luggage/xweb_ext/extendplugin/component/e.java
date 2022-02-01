package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static com.tencent.mm.plugin.appbrand.jsapi.ag.a f(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(215542);
    Log.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide");
    parama = parama.NN();
    if ((parama instanceof ac)) {
      parama = ((ac)parama).getRuntime();
    }
    while (parama == null)
    {
      Log.w("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is null");
      AppMethodBeat.o(215542);
      return null;
      if ((parama instanceof s)) {
        parama = ((s)parama).getRuntime();
      } else {
        parama = null;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.ag.a locala2 = (com.tencent.mm.plugin.appbrand.jsapi.ag.a)parama.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
    com.tencent.mm.plugin.appbrand.jsapi.ag.a locala1 = locala2;
    if (locala2 == null)
    {
      Log.i("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, create");
      locala1 = new com.tencent.mm.plugin.appbrand.jsapi.ag.a(parama);
      parama.a(locala1);
    }
    AppMethodBeat.o(215542);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.e
 * JD-Core Version:    0.7.0.1
 */