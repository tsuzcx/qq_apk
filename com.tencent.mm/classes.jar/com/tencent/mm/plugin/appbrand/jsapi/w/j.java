package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  implements a
{
  public final boolean a(c paramc, at paramat)
  {
    AppMethodBeat.i(222669);
    boolean bool;
    if ((paramc == null) || (!paramc.isRunning()) || (paramat == null)) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(222669);
      return true;
      if (!(paramc instanceof h))
      {
        ae.e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
        bool = false;
      }
      else
      {
        h localh = (h)paramc;
        if (!(localh.getRuntime() instanceof p))
        {
          ae.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
          bool = false;
        }
        else
        {
          bool = ((p)localh.getRuntime()).cpU.a(paramc, paramat.getClass());
        }
      }
    }
    AppMethodBeat.o(222669);
    return false;
  }
  
  public final int bne()
  {
    return 5;
  }
  
  public final int bnf()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.j
 * JD-Core Version:    0.7.0.1
 */