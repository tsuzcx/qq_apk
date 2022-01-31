package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class c$14
  implements DialogInterface.OnClickListener
{
  c$14(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "cancel to confirm login");
    paramDialogInterface.dismiss();
    this.gkx.gkh.C(this.gkx.gfg, this.gkx.h("fail:cancel to confirm login", null));
    h.nFQ.f(14249, new Object[] { this.gkx.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.gkx.gku), Integer.valueOf(this.gkx.gkv), Integer.valueOf(this.gkx.gkt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.14
 * JD-Core Version:    0.7.0.1
 */