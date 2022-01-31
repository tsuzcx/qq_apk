package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.y;

final class f$3
  implements DialogInterface.OnClickListener
{
  f$3(f paramf, er paramer, q paramq, int paramInt, com.tencent.mm.ah.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
    this.gkN.syz = true;
    this.gkf.C(this.dIS, this.gkR.h("ok", null));
    com.tencent.mm.ipcinvoker.wx_extension.b.a(this.eew, new f.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.f.3
 * JD-Core Version:    0.7.0.1
 */