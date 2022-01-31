package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;
import java.util.Map;

final class c$1$3
  implements DialogInterface.OnCancelListener
{
  c$1$3(c.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("confirm", Boolean.valueOf(false));
    paramDialogInterface.put("cancel", Boolean.valueOf(true));
    this.gAq.gcp.C(this.gAq.dIS, this.gAq.gAp.h("ok", paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.c.1.3
 * JD-Core Version:    0.7.0.1
 */