package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;
import java.util.Map;

final class c$1$2
  implements DialogInterface.OnClickListener
{
  c$1$2(c.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("confirm", Boolean.valueOf(false));
    localHashMap.put("cancel", Boolean.valueOf(true));
    paramDialogInterface.dismiss();
    this.gAq.gcp.C(this.gAq.dIS, this.gAq.gAp.h("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.c.1.2
 * JD-Core Version:    0.7.0.1
 */