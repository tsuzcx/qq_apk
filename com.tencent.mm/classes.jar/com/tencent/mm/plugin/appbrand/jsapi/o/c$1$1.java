package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

final class c$1$1
  implements DialogInterface.OnClickListener
{
  c$1$1(c.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74789);
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("confirm", Boolean.TRUE);
    paramDialogInterface.put("cancel", Boolean.FALSE);
    this.hXD.bAW.h(this.hXD.bAX, this.hXD.hXC.j("ok", paramDialogInterface));
    AppMethodBeat.o(74789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c.1.1
 * JD-Core Version:    0.7.0.1
 */