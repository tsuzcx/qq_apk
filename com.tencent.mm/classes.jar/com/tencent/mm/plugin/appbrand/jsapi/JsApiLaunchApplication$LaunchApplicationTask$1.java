package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiLaunchApplication$LaunchApplicationTask$1
  implements JsApiLaunchApplication.a.a
{
  JsApiLaunchApplication$LaunchApplicationTask$1(JsApiLaunchApplication.LaunchApplicationTask paramLaunchApplicationTask, AppBrandProxyTransparentUIProcessTask.a parama) {}
  
  public final void q(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.ggp.success = true;
      this.ggo.ahB();
      return;
    }
    this.ggp.success = false;
    this.ggo.ahB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask.1
 * JD-Core Version:    0.7.0.1
 */