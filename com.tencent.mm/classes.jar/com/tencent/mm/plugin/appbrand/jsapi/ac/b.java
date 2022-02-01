package com.tencent.mm.plugin.appbrand.jsapi.ac;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;

public final class b
{
  public static int Rx(String paramString)
  {
    AppMethodBeat.i(186889);
    paramString = g.Kv(paramString);
    int i = 1;
    if (paramString == g.d.jwr) {
      i = 2;
    }
    for (;;)
    {
      AppMethodBeat.o(186889);
      return i;
      if (paramString == g.d.jwm) {
        i = 3;
      } else if (paramString == g.d.jwl) {
        i = 4;
      } else if (paramString == g.d.jws) {
        i = 5;
      } else if (paramString == g.d.jwp) {
        i = 6;
      } else if (paramString == g.d.jwq) {
        i = 7;
      } else if (paramString == g.d.jwo) {
        i = 8;
      }
    }
  }
  
  public static AppBrandRuntime y(a parama)
  {
    AppMethodBeat.i(186890);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.El();
      if ((parama instanceof aa))
      {
        parama = ((aa)parama).getRuntime();
        AppMethodBeat.o(186890);
        return parama;
      }
      if ((parama instanceof q))
      {
        parama = ((q)parama).getRuntime();
        AppMethodBeat.o(186890);
        return parama;
      }
      AppMethodBeat.o(186890);
      return null;
    }
    AppMethodBeat.o(186890);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b
 * JD-Core Version:    0.7.0.1
 */