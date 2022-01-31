package com.tencent.mm.plugin.appbrand.jsapi.a;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class c$m
  implements DialogInterface.OnClickListener
{
  c$m(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(143760);
    d.i("MicroMsg.JsApiGetPhoneNumberNew", "cancel to bind phone number");
    paramDialogInterface.dismiss();
    this.hEh.cK("user cancel");
    AppMethodBeat.o(143760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.m
 * JD-Core Version:    0.7.0.1
 */