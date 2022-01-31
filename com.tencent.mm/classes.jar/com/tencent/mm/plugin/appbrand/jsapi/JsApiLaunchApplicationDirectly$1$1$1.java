package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiLaunchApplicationDirectly$1$1$1
  implements JsApiLaunchApplicationDirectly.a.a
{
  JsApiLaunchApplicationDirectly$1$1$1(JsApiLaunchApplicationDirectly.1.1 param1) {}
  
  public final void r(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(130452);
    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    JsApiLaunchApplicationDirectly.a(this.hyx.hyw.hyv, this.hyx.hyw.bAW);
    if (paramBoolean1)
    {
      this.hyx.hyw.bAW.h(this.hyx.hyw.bAX, this.hyx.hyw.hyv.j("ok", null));
      AppMethodBeat.o(130452);
      return;
    }
    this.hyx.hyw.bAW.h(this.hyx.hyw.bAX, this.hyx.hyw.hyv.j("fail:scheme launch fail", null));
    AppMethodBeat.o(130452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1.1.1
 * JD-Core Version:    0.7.0.1
 */