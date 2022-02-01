package com.tencent.mm.plugin.appbrand.h;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.44;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements com.tencent.luggage.xweb_ext.extendplugin.a.c
{
  public com.tencent.luggage.xweb_ext.extendplugin.a.b dW(String paramString)
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
    paramString.cJb = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.c();
    if (paramString.cJb != null)
    {
      paramString.cJb.b(paramString);
      paramString.cJa = paramString.cJb.QC();
      paramString.cIZ = paramString.cJb.QD();
      paramString.cIX = paramString.cJb.QG();
      paramString.cIW = paramString.cJb.QF();
      paramString.cIW.b(paramString);
      paramString.cIW.a(paramString.cJC);
      paramString.cIW.a(paramString.cEX);
      paramString.cIY = paramString.cJb.QE();
      paramString.cIY.a(new c.44(paramString));
    }
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.ag.d.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.ag.b.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.ag.a.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a();
    paramString.cEC = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a();
    if (paramString.cEC != null)
    {
      paramString.cEB = paramString.cEC.Qa();
      paramString.cEA = paramString.cEC.Qb();
      paramString.cEC.b(paramString);
    }
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new o();
    paramString.cHo = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a();
    if (paramString.cHo != null)
    {
      paramString.cHn = paramString.cHo.Qm();
      paramString.cHm = paramString.cHo.Qn();
    }
    AppMethodBeat.o(139393);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.d
 * JD-Core Version:    0.7.0.1
 */