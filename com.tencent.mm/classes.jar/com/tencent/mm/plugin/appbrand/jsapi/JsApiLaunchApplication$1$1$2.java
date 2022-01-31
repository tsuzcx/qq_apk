package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.axg;

final class JsApiLaunchApplication$1$1$2
  implements Runnable
{
  JsApiLaunchApplication$1$1$2(JsApiLaunchApplication.1.1 param1, Intent paramIntent, axg paramaxg, JsApiLaunchApplication.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(130436);
    boolean bool = g.a(this.hyi.hyh.bAW.getContext(), this.val$intent, null, this.hyj.xmD, this.hyk, this.hyi.hyh.hyb);
    this.hyk.ea(bool);
    AppMethodBeat.o(130436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1.2
 * JD-Core Version:    0.7.0.1
 */