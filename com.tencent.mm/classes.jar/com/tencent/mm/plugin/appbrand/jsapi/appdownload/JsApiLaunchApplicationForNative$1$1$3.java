package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiLaunchApplicationForNative$1$1$3
  implements Runnable
{
  JsApiLaunchApplicationForNative$1$1$3(JsApiLaunchApplicationForNative.1.1 param1, JsApiLaunchApplicationForNative.LaunchApplicationTask paramLaunchApplicationTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(143334);
    ab.i("MicroMsg.JsApiLaunchApplicationForNative", "callback task.success:%b", new Object[] { Boolean.valueOf(this.hBn.success) });
    this.hBn.aBk();
    if (!this.hBn.success)
    {
      this.hBl.hBk.bAW.h(this.hBl.hBk.bAX, this.hBl.hBk.hBj.j("fail:sdk launch fail", null));
      AppMethodBeat.o(143334);
      return;
    }
    this.hBl.hBk.bAW.h(this.hBl.hBk.bAX, this.hBl.hBk.hBj.j("ok", null));
    AppMethodBeat.o(143334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.1.1.3
 * JD-Core Version:    0.7.0.1
 */