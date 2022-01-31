package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

final class c$1$3
  implements DialogInterface.OnCancelListener
{
  c$1$3(c.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(74791);
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("confirm", Boolean.FALSE);
    paramDialogInterface.put("cancel", Boolean.TRUE);
    this.hXD.bAW.h(this.hXD.bAX, this.hXD.hXC.j("ok", paramDialogInterface));
    AppMethodBeat.o(74791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c.1.3
 * JD-Core Version:    0.7.0.1
 */