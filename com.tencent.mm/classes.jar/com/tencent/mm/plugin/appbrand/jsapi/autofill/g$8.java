package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.Log;

final class g$8
  implements DialogInterface.OnClickListener
{
  g$8(g paramg, hl paramhl, ac paramac, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(229897);
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
    this.lIE.KLu = true;
    this.lIf.i(this.cvP, this.lIG.h("ok", null));
    g.a(this.lIG, this.lIf, this.lIE);
    AppMethodBeat.o(229897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.8
 * JD-Core Version:    0.7.0.1
 */