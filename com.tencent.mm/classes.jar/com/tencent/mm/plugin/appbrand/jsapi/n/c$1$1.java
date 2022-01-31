package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;
import java.util.Map;

final class c$1$1
  implements DialogInterface.OnClickListener
{
  c$1$1(c.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("confirm", Boolean.valueOf(true));
    paramDialogInterface.put("cancel", Boolean.valueOf(false));
    this.gAq.gcp.C(this.gAq.dIS, this.gAq.gAp.h("ok", paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.c.1.1
 * JD-Core Version:    0.7.0.1
 */