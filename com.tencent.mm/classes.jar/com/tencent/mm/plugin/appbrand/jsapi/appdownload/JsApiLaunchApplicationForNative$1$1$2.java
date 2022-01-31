package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.axg;

final class JsApiLaunchApplicationForNative$1$1$2
  implements Runnable
{
  JsApiLaunchApplicationForNative$1$1$2(JsApiLaunchApplicationForNative.1.1 param1, Intent paramIntent, axg paramaxg, JsApiLaunchApplicationForNative.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(143333);
    boolean bool = g.a(this.hBl.hBk.bAW.getContext(), this.val$intent, null, this.hyj.xmD, this.hBm, this.hBl.hBk.hyb);
    this.hBm.ea(bool);
    AppMethodBeat.o(143333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.1.1.2
 * JD-Core Version:    0.7.0.1
 */