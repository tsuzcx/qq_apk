package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  extends g.b
{
  a$3(a parama, c paramc) {}
  
  public final void onDestroy()
  {
    y.d("MicroMsg.JsApiConenctWifi", "remove listener");
    d.a(null);
    g.b(this.ggH.getAppId(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.a.3
 * JD-Core Version:    0.7.0.1
 */