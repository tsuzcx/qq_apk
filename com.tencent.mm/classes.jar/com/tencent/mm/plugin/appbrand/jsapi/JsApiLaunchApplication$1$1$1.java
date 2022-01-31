package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiLaunchApplication$1$1$1
  implements JsApiLaunchApplication.a.a
{
  JsApiLaunchApplication$1$1$1(JsApiLaunchApplication.1.1 param1) {}
  
  public final void r(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(130435);
    ab.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.hyi.hyh.bAW.h(this.hyi.hyh.bAX, this.hyi.hyh.hyg.j("ok", null));
      AppMethodBeat.o(130435);
      return;
    }
    this.hyi.hyh.bAW.h(this.hyi.hyh.bAX, this.hyi.hyh.hyg.j("fail:scheme launch fail", null));
    AppMethodBeat.o(130435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1.1
 * JD-Core Version:    0.7.0.1
 */