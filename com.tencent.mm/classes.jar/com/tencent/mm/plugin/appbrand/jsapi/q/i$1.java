package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  extends g.b
{
  i$1(i parami, c paramc) {}
  
  public final void a(g.c paramc)
  {
    y.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
    if (i.a(this.gCl)) {
      i.b(this.gCl);
    }
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
    if (i.a(this.gCl)) {
      i.b(this.gCl);
    }
    g.b(this.ggH.getAppId(), this);
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
    if (i.access$200()) {
      i.c(this.gCl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.i.1
 * JD-Core Version:    0.7.0.1
 */