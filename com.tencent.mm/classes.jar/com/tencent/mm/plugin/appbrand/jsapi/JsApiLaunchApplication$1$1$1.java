package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiLaunchApplication$1$1$1
  implements JsApiLaunchApplication.a.a
{
  JsApiLaunchApplication$1$1$1(JsApiLaunchApplication.1.1 param1) {}
  
  public final void q(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.ggj.ggi.gcp.C(this.ggj.ggi.dIS, this.ggj.ggi.ggh.h("ok", null));
      return;
    }
    this.ggj.ggi.gcp.C(this.ggj.ggi.dIS, this.ggj.ggi.ggh.h("fail:scheme launch fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1.1
 * JD-Core Version:    0.7.0.1
 */