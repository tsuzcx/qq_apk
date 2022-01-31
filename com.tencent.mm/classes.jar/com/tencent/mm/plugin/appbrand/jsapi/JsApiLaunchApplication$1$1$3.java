package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiLaunchApplication$1$1$3
  implements Runnable
{
  JsApiLaunchApplication$1$1$3(JsApiLaunchApplication.1.1 param1, JsApiLaunchApplication.LaunchApplicationTask paramLaunchApplicationTask) {}
  
  public final void run()
  {
    y.i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", new Object[] { Boolean.valueOf(this.ggm.success) });
    this.ggm.ahD();
    if (!this.ggm.success)
    {
      this.ggj.ggi.gcp.C(this.ggj.ggi.dIS, this.ggj.ggi.ggh.h("fail:sdk launch fail", null));
      return;
    }
    this.ggj.ggi.gcp.C(this.ggj.ggi.dIS, this.ggj.ggi.ggh.h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1.3
 * JD-Core Version:    0.7.0.1
 */