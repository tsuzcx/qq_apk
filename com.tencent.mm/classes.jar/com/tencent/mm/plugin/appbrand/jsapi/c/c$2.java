package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  extends e.c
{
  c$2(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(94363);
    ab.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
    e.b(this.hza.getAppId(), this);
    a.a locala = a.Ca(this.hza.getAppId());
    if (locala != null)
    {
      locala.Ez();
      a.remove(this.hza.getAppId());
    }
    this.hMx.hMu = null;
    AppMethodBeat.o(94363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.c.2
 * JD-Core Version:    0.7.0.1
 */