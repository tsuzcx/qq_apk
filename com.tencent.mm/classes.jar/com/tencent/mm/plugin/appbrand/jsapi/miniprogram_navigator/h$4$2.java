package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;

final class h$4$2
  implements DialogInterface.OnCancelListener
{
  h$4$2(h.4 param4, b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(140844);
    this.bDR.cK(new Exception("cancel"));
    AppMethodBeat.o(140844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h.4.2
 * JD-Core Version:    0.7.0.1
 */