package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ad;

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
        ad.e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
        bool = false;
      }
      else
      {
        h localh = (h)paramc;
        if (!(localh.getRuntime() instanceof o))
        {
          ad.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
          bool = false;
        }
        else
        {
          bool = ((o)localh.getRuntime()).cif.a(paramc, paramar);
        }
      }
    }
    AppMethodBeat.o(46761);
    return false;
  }
  
  public final int bbO()
  {
    return 5;
  }
  
  public final int bbP()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.j
 * JD-Core Version:    0.7.0.1
 */