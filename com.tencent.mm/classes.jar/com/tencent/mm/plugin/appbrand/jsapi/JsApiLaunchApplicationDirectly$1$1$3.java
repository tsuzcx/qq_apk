package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiLaunchApplicationDirectly$1$1$3
  implements Runnable
{
  JsApiLaunchApplicationDirectly$1$1$3(JsApiLaunchApplicationDirectly.1.1 param1, JsApiLaunchApplicationDirectly.LaunchApplicationTask paramLaunchApplicationTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(130454);
    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", new Object[] { Boolean.valueOf(this.hyz.success) });
    this.hyz.aBk();
    if (!this.hyz.success)
    {
      this.hyx.hyw.bAW.h(this.hyx.hyw.bAX, this.hyx.hyw.hyv.j("fail:sdk launch fail", null));
      AppMethodBeat.o(130454);
      return;
    }
    this.hyx.hyw.bAW.h(this.hyx.hyw.bAX, this.hyx.hyw.hyv.j("ok", null));
    AppMethodBeat.o(130454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1.1.3
 * JD-Core Version:    0.7.0.1
 */