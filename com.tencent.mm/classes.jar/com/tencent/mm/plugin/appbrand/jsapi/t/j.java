package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  implements a
{
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, ar paramar)
  {
    AppMethodBeat.i(46761);
    boolean bool;
    if (!paramc.isRunning()) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(46761);
      return true;
      if (!(paramc instanceof h))
      {
        ac.e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
        bool = false;
      }
      else
      {
        h localh = (h)paramc;
        if (!(localh.getRuntime() instanceof o))
        {
          ac.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
          bool = false;
        }
        else
        {
          bool = ((o)localh.getRuntime()).cfa.a(paramc, paramar);
        }
      }
    }
    AppMethodBeat.o(46761);
    return false;
  }
  
  public final int biJ()
  {
    return 5;
  }
  
  public final int biK()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.j
 * JD-Core Version:    0.7.0.1
 */