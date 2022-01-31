package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  extends e.c
{
  a$3(a parama, c paramc) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(94370);
    ab.d("MicroMsg.JsApiConenctWifi", "remove listener");
    d.a(null);
    e.b(this.hxW.getAppId(), this);
    AppMethodBeat.o(94370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.a.3
 * JD-Core Version:    0.7.0.1
 */