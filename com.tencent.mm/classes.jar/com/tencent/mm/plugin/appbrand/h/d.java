package com.tencent.mm.plugin.appbrand.h;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements com.tencent.luggage.xweb_ext.extendplugin.a.c
{
  public com.tencent.luggage.xweb_ext.extendplugin.a.b ex(String paramString)
  {
    AppMethodBeat.i(139393);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(139393);
        return null;
        if (paramString.equals("video"))
        {
          i = 0;
          continue;
          if (paramString.equals("map"))
          {
            i = 1;
            continue;
            if (paramString.equals("canvas"))
            {
              i = 2;
              continue;
              if (paramString.equals("camera"))
              {
                i = 3;
                continue;
                if (paramString.equals("liveplayer"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("livepusher")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.video.c();
    paramString.a(new com.tencent.mm.plugin.appbrand.jsapi.ai.e.c());
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.ai.d.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.ai.b.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.ai.a.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b();
    paramString.cFi = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.a();
    if (paramString.cFi != null)
    {
      paramString.cFh = paramString.cFi.TB();
      paramString.cFg = paramString.cFi.TC();
      paramString.cFi.b(paramString);
    }
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new p();
    paramString.cHU = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.a();
    if (paramString.cHU != null)
    {
      paramString.cHT = paramString.cHU.TO();
      paramString.cHS = paramString.cHU.TP();
    }
    AppMethodBeat.o(139393);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.d
 * JD-Core Version:    0.7.0.1
 */