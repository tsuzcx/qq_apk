package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  private static volatile boolean sIsEnable = false;
  
  public static void enable()
  {
    AppMethodBeat.i(220604);
    Log.i("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "enable");
    sIsEnable = true;
    AppMethodBeat.o(220604);
  }
  
  public static com.tencent.mm.plugin.appbrand.jsapi.al.a f(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(220609);
    Log.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide");
    if (!sIsEnable)
    {
      Log.i("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, not support");
      AppMethodBeat.o(220609);
      return null;
    }
    parama = parama.aqX();
    if ((parama instanceof ad)) {
      parama = ((ad)parama).getRuntime();
    }
    while (parama == null)
    {
      Log.w("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is null");
      AppMethodBeat.o(220609);
      return null;
      if ((parama instanceof y)) {
        parama = ((y)parama).getRuntime();
      } else {
        parama = null;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.al.a locala2 = (com.tencent.mm.plugin.appbrand.jsapi.al.a)parama.aO(com.tencent.mm.plugin.appbrand.jsapi.al.a.class);
    com.tencent.mm.plugin.appbrand.jsapi.al.a locala1 = locala2;
    if (locala2 == null)
    {
      Log.i("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, create");
      locala1 = new com.tencent.mm.plugin.appbrand.jsapi.al.a(parama);
      parama.a(locala1);
    }
    AppMethodBeat.o(220609);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.e
 * JD-Core Version:    0.7.0.1
 */