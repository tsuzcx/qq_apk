package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

final class c$1$2
  implements DialogInterface.OnClickListener
{
  c$1$2(c.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74790);
    HashMap localHashMap = new HashMap();
    localHashMap.put("confirm", Boolean.FALSE);
    localHashMap.put("cancel", Boolean.TRUE);
    paramDialogInterface.dismiss();
    this.hXD.bAW.h(this.hXD.bAX, this.hXD.hXC.j("ok", localHashMap));
    AppMethodBeat.o(74790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c.1.2
 * JD-Core Version:    0.7.0.1
 */