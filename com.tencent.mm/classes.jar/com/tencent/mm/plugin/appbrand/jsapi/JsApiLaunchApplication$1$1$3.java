package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiLaunchApplication$1$1$3
  implements Runnable
{
  JsApiLaunchApplication$1$1$3(JsApiLaunchApplication.1.1 param1, JsApiLaunchApplication.LaunchApplicationTask paramLaunchApplicationTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(130437);
    ab.i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", new Object[] { Boolean.valueOf(this.hyl.success) });
    this.hyl.aBk();
    if (!this.hyl.success)
    {
      this.hyi.hyh.bAW.h(this.hyi.hyh.bAX, this.hyi.hyh.hyg.j("fail:sdk launch fail", null));
      AppMethodBeat.o(130437);
      return;
    }
    this.hyi.hyh.bAW.h(this.hyi.hyh.bAX, this.hyi.hyh.hyg.j("ok", null));
    AppMethodBeat.o(130437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1.3
 * JD-Core Version:    0.7.0.1
 */