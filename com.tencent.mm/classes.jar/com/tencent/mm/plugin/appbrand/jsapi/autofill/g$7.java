package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.ad;

final class g$7
  implements DialogInterface.OnClickListener
{
  g$7(g paramg, gy paramgy, aa paramaa, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(192217);
    ad.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do not accept the auto fill data protocol");
    this.kAP.Fzp = false;
    this.kAq.h(this.cjQ, this.kAR.e("cancel", null));
    g.a(this.kAR, this.kAq, this.kAP);
    AppMethodBeat.o(192217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.7
 * JD-Core Version:    0.7.0.1
 */