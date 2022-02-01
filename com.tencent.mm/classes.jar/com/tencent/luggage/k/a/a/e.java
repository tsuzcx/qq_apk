package com.tencent.luggage.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
{
  public static com.tencent.mm.plugin.appbrand.jsapi.z.a f(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(206510);
    ac.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide");
    parama = parama.CM();
    if ((parama instanceof aa)) {
      parama = ((aa)parama).getRuntime();
    }
    while (parama == null)
    {
      ac.w("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is null");
      AppMethodBeat.o(206510);
      return null;
      if ((parama instanceof q)) {
        parama = ((q)parama).getRuntime();
      } else {
        parama = null;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.z.a locala2 = (com.tencent.mm.plugin.appbrand.jsapi.z.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.z.a.class);
    com.tencent.mm.plugin.appbrand.jsapi.z.a locala1 = locala2;
    if (locala2 == null)
    {
      ac.i("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, create");
      locala1 = new com.tencent.mm.plugin.appbrand.jsapi.z.a(parama);
      parama.a(locala1);
    }
    AppMethodBeat.o(206510);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.e
 * JD-Core Version:    0.7.0.1
 */