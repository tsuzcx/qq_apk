package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;

final class JsApiUpdateApp$1$1$2
  implements DialogInterface.OnClickListener
{
  JsApiUpdateApp$1$1$2(JsApiUpdateApp.1.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(131487);
    this.ibx.ibw.hxC.h(this.ibx.ibw.bAX, this.ibx.ibw.ibv.j("fail user canceled updateApp", null));
    AppMethodBeat.o(131487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.1.1.2
 * JD-Core Version:    0.7.0.1
 */