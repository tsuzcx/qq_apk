package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.y;

final class j$3
  implements e.c
{
  j$3(j paramj, e parame, String paramString, int paramInt) {}
  
  public final void onDestroy()
  {
    y.i("MicroMsg.JsApiInsertMap", "onDestroy");
    this.gtq.b(this);
    f.p(this.val$appId, this.gtq.ahJ(), this.gkY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.j.3
 * JD-Core Version:    0.7.0.1
 */