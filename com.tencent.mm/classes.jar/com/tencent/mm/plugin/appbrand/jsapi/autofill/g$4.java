package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.ad;

final class g$4
  implements View.OnClickListener
{
  g$4(g paramg, gy paramgy, aa paramaa, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(192214);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, acceptButton");
    this.kAP.Fzp = true;
    this.kAq.h(this.cjQ, this.kAR.e("ok", null));
    g.a(this.kAR, this.kAq, this.kAP);
    g.a(this.kAR);
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(192214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.4
 * JD-Core Version:    0.7.0.1
 */