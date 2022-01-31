package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiLaunchApplicationForNative$LaunchApplicationTask$1
  implements JsApiLaunchApplicationForNative.a.a
{
  JsApiLaunchApplicationForNative$LaunchApplicationTask$1(JsApiLaunchApplicationForNative.LaunchApplicationTask paramLaunchApplicationTask, AppBrandProxyTransparentUIProcessTask.a parama) {}
  
  public final void r(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143337);
    ab.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.hBo.success = true;
      this.hyn.aBh();
      AppMethodBeat.o(143337);
      return;
    }
    this.hBo.success = false;
    this.hyn.aBh();
    AppMethodBeat.o(143337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.LaunchApplicationTask.1
 * JD-Core Version:    0.7.0.1
 */