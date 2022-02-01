package com.tencent.mm.plugin.appbrand.jsapi.ag;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;

public final class b
{
  public static int abL(String paramString)
  {
    AppMethodBeat.i(215795);
    paramString = h.Uc(paramString);
    int i = 1;
    if (paramString == h.d.kzV) {
      i = 2;
    }
    for (;;)
    {
      AppMethodBeat.o(215795);
      return i;
      if (paramString == h.d.kzQ) {
        i = 3;
      } else if (paramString == h.d.kzP) {
        i = 4;
      } else if (paramString == h.d.kzW) {
        i = 5;
      } else if (paramString == h.d.kzT) {
        i = 6;
      } else if (paramString == h.d.kzU) {
        i = 7;
      } else if (paramString == h.d.kzS) {
        i = 8;
      }
    }
  }
  
  public static AppBrandRuntime y(a parama)
  {
    AppMethodBeat.i(215796);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.NN();
      if ((parama instanceof ac))
      {
        parama = ((ac)parama).getRuntime();
        AppMethodBeat.o(215796);
        return parama;
      }
      if ((parama instanceof s))
      {
        parama = ((s)parama).getRuntime();
        AppMethodBeat.o(215796);
        return parama;
      }
      AppMethodBeat.o(215796);
      return null;
    }
    AppMethodBeat.o(215796);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b
 * JD-Core Version:    0.7.0.1
 */