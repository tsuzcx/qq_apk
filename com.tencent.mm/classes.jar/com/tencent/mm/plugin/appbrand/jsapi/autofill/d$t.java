package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class d$t
  implements DialogInterface.OnCancelListener
{
  d$t(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(147929);
    this.kBh.ef("user cancel");
    AppMethodBeat.o(147929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.d.t
 * JD-Core Version:    0.7.0.1
 */