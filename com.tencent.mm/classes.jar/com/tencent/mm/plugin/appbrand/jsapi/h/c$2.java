package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;

final class c$2
  extends k.c
{
  c$2(c paramc, e parame) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144678);
    Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
    k.b(this.owM.getAppId(), this);
    a.a locala = a.ahC(this.owM.getAppId());
    if (locala != null)
    {
      locala.TV();
      a.remove(this.owM.getAppId());
    }
    this.oUe.oIi = null;
    AppMethodBeat.o(144678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.c.2
 * JD-Core Version:    0.7.0.1
 */