package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.luggage.k.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;

public final class b
{
  public static int NY(String paramString)
  {
    AppMethodBeat.i(206699);
    paramString = g.Hg(paramString);
    int i = 1;
    if (paramString == g.d.jdi) {
      i = 2;
    }
    for (;;)
    {
      AppMethodBeat.o(206699);
      return i;
      if (paramString == g.d.jdd) {
        i = 3;
      } else if (paramString == g.d.jdc) {
        i = 4;
      } else if (paramString == g.d.jdj) {
        i = 5;
      } else if (paramString == g.d.jdg) {
        i = 6;
      } else if (paramString == g.d.jdh) {
        i = 7;
      } else if (paramString == g.d.jdf) {
        i = 8;
      }
    }
  }
  
  public static AppBrandRuntime y(a parama)
  {
    AppMethodBeat.i(206700);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      parama = parama.CM();
      if ((parama instanceof aa))
      {
        parama = ((aa)parama).getRuntime();
        AppMethodBeat.o(206700);
        return parama;
      }
      if ((parama instanceof q))
      {
        parama = ((q)parama).getRuntime();
        AppMethodBeat.o(206700);
        return parama;
      }
      AppMethodBeat.o(206700);
      return null;
    }
    AppMethodBeat.o(206700);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b
 * JD-Core Version:    0.7.0.1
 */