package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  extends g.b
{
  c$1(c paramc, q paramq) {}
  
  public final void onDestroy()
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "AppBrandLifeCycle onDestroy");
    g.b(this.gkf.mAppId, this);
    this.gkx.aih();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.1
 * JD-Core Version:    0.7.0.1
 */