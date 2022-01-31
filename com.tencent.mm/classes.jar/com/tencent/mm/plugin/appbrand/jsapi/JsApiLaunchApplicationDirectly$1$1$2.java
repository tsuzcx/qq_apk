package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.axg;

final class JsApiLaunchApplicationDirectly$1$1$2
  implements Runnable
{
  JsApiLaunchApplicationDirectly$1$1$2(JsApiLaunchApplicationDirectly.1.1 param1, Intent paramIntent, axg paramaxg, JsApiLaunchApplicationDirectly.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(130453);
    boolean bool = g.a(this.hyx.hyw.bAW.getContext(), this.val$intent, null, this.hyj.xmD, this.hyy, this.hyx.hyw.hyb);
    this.hyy.ea(bool);
    AppMethodBeat.o(130453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1.1.2
 * JD-Core Version:    0.7.0.1
 */