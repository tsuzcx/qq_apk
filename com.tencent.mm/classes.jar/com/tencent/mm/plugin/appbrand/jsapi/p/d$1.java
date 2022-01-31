package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.bl.a.a;
import com.tencent.mm.bl.a.b;
import com.tencent.mm.cg.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements a.b
{
  d$1(d paramd) {}
  
  public final void a(a.a parama1, a.a parama2)
  {
    y.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + parama1.name() + "; newOrientation:" + parama2.name());
    a.postDelayed(new d.1.1(this, parama2), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.d.1
 * JD-Core Version:    0.7.0.1
 */