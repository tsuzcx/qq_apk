package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.luggage.k.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;

public final class b
{
  public static int JR(String paramString)
  {
    AppMethodBeat.i(195066);
    paramString = g.Dd(paramString);
    int i = 1;
    if (paramString == g.d.iDi) {
      i = 2;
    }
    for (;;)
    {
      AppMethodBeat.o(195066);
      return i;
      if (paramString == g.d.iDd) {
        i = 3;
      } else if (paramString == g.d.iDc) {
        i = 4;
      } else if (paramString == g.d.iDj) {
        i = 5;
      } else if (paramString == g.d.iDg) {
        i = 6;
      } else if (paramString == g.d.iDh) {
        i = 7;
      } else if (paramString == g.d.iDf) {
        i = 8;
      }
    }
  }
  
  public static AppBrandRuntime z(a parama)
  {
    AppMethodBeat.i(195067);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      parama = parama.Dj();
      if ((parama instanceof aa))
      {
        parama = ((aa)parama).getRuntime();
        AppMethodBeat.o(195067);
        return parama;
      }
      if ((parama instanceof q))
      {
        parama = ((q)parama).getRuntime();
        AppMethodBeat.o(195067);
        return parama;
      }
      AppMethodBeat.o(195067);
      return null;
    }
    AppMethodBeat.o(195067);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.b
 * JD-Core Version:    0.7.0.1
 */