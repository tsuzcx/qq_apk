package com.tencent.mm.plugin.appbrand.f;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.1;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements com.tencent.luggage.xweb_ext.extendplugin.a.c
{
  public static d hrG;
  
  public final com.tencent.luggage.xweb_ext.extendplugin.a.b cp(String paramString)
  {
    AppMethodBeat.i(140023);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(140023);
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
              if (paramString.equals("liveplayer"))
              {
                i = 3;
                continue;
                if (paramString.equals("livepusher")) {
                  i = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.video.a();
    paramString.bHz = new com.tencent.mm.plugin.appbrand.jsapi.v.d.a();
    if (paramString.bHz != null)
    {
      paramString.bHy = paramString.bHz.xP();
      paramString.bHx = paramString.bHz.xQ();
      paramString.bHv = paramString.bHz.xS();
      if (paramString.bHv != null) {
        paramString.bHv.a(paramString);
      }
      paramString.bHw = paramString.bHz.xR();
      if (paramString.bHw != null)
      {
        paramString.bHw.a(paramString);
        paramString.bHw.a(new a.1(paramString));
      }
    }
    AppMethodBeat.o(140023);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.v.c.a();
    AppMethodBeat.o(140023);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.v.a.a();
    AppMethodBeat.o(140023);
    return paramString;
    paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a();
    paramString.bFY = new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a();
    if (paramString.bFY != null)
    {
      paramString.bFX = paramString.bFY.xv();
      paramString.bFW = paramString.bFY.xw();
    }
    AppMethodBeat.o(140023);
    return paramString;
    paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a();
    paramString.bGC = new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a();
    if (paramString.bGC != null)
    {
      paramString.bGB = paramString.bGC.xy();
      paramString.bGA = paramString.bGC.xz();
    }
    AppMethodBeat.o(140023);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.d
 * JD-Core Version:    0.7.0.1
 */