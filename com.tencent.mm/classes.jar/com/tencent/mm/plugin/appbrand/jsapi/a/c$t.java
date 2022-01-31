package com.tencent.mm.plugin.appbrand.jsapi.a;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class c$t
  implements DialogInterface.OnCancelListener
{
  c$t(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(143772);
    this.hEh.cK("user cancel");
    AppMethodBeat.o(143772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.t
 * JD-Core Version:    0.7.0.1
 */