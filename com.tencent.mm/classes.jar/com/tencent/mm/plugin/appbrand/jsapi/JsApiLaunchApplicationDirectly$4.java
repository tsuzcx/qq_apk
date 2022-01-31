package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiLaunchApplicationDirectly$4
  implements DialogInterface.OnClickListener
{
  JsApiLaunchApplicationDirectly$4(JsApiLaunchApplicationDirectly paramJsApiLaunchApplicationDirectly, r paramr, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(130459);
    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "fail:user canceled install");
    JsApiLaunchApplicationDirectly.a(this.hyv, this.bAW);
    this.bAW.h(this.bAX, this.hyv.j("fail:user canceled install", null));
    AppMethodBeat.o(130459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.4
 * JD-Core Version:    0.7.0.1
 */