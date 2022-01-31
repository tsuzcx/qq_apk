package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;

final class c$7
  implements DialogInterface.OnClickListener
{
  c$7(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.gkx.gkh.C(this.gkx.gfg, this.gkx.h("fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.7
 * JD-Core Version:    0.7.0.1
 */