package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;

final class b$1$2
  implements DialogInterface.OnCancelListener
{
  b$1$2(b.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(74782);
    this.hXu.bAW.h(this.hXu.bAX, this.hXu.hXs.j("cancel", null));
    AppMethodBeat.o(74782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b.1.2
 * JD-Core Version:    0.7.0.1
 */