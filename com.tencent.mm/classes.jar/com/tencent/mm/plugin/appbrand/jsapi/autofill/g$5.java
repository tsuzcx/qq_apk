package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.Log;

final class g$5
  implements View.OnClickListener
{
  g$5(g paramg, hl paramhl, ac paramac, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(229894);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, rejectButton");
    this.lIE.KLu = false;
    this.lIf.i(this.cvP, this.lIG.h("cancel", null));
    g.a(this.lIG, this.lIf, this.lIE);
    g.a(this.lIG);
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(229894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.5
 * JD-Core Version:    0.7.0.1
 */