package com.tencent.mm.plugin.appbrand.h;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements com.tencent.luggage.xweb_ext.extendplugin.a.c
{
  public com.tencent.luggage.xweb_ext.extendplugin.a.b fU(String paramString)
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
    paramString.a(new com.tencent.mm.plugin.appbrand.jsapi.al.e.c());
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.al.d.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.al.b.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.mm.plugin.appbrand.jsapi.al.a.a();
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b();
    paramString.eyw = new com.tencent.mm.plugin.appbrand.jsapi.al.c.a.a();
    if (paramString.eyw != null)
    {
      paramString.eyv = paramString.eyw.aug();
      paramString.eyu = paramString.eyw.auh();
      paramString.eyw.b(paramString);
    }
    AppMethodBeat.o(139393);
    return paramString;
    paramString = new r();
    paramString.eBr = new com.tencent.mm.plugin.appbrand.jsapi.al.c.b.a();
    if (paramString.eBr != null)
    {
      paramString.eBq = paramString.eBr.auw();
      paramString.eBp = paramString.eBr.aux();
    }
    AppMethodBeat.o(139393);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.d
 * JD-Core Version:    0.7.0.1
 */