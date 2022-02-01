package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  implements a
{
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, at paramat)
  {
    AppMethodBeat.i(188519);
    boolean bool;
    if ((paramc == null) || (!paramc.isRunning()) || (paramat == null)) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(188519);
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
          bool = ((o)localh.getRuntime()).cpr.a(paramc, paramat.getClass());
        }
      }
    }
    AppMethodBeat.o(188519);
    return false;
  }
  
  public final int bmv()
  {
    return 5;
  }
  
  public final int bmw()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.j
 * JD-Core Version:    0.7.0.1
 */