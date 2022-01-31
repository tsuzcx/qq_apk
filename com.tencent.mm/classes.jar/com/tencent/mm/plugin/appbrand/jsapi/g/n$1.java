package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.widget.d.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class n$1
  implements b.m
{
  n$1(n paramn, g paramg) {}
  
  public final void df(boolean paramBoolean)
  {
    y.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.gkW.tT(this.gtv.h("ok", null));
      n.a(this.gtv).asN();
      return;
    }
    this.gkW.tT(this.gtv.h("fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.n.1
 * JD-Core Version:    0.7.0.1
 */