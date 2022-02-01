package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;

final class g$6
  implements View.OnClickListener
{
  g$6(g paramg, aa paramaa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(192216);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
    paramView = this.kAq.getContext().getString(2131755329);
    paramView = paramView + com.tencent.mm.sdk.platformtools.ac.fks();
    ad.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:".concat(String.valueOf(paramView)));
    ((com.tencent.mm.plugin.appbrand.jsapi.ac)this.kAq.K(com.tencent.mm.plugin.appbrand.jsapi.ac.class)).a(this.kAq.getContext(), paramView, null);
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(192216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.6
 * JD-Core Version:    0.7.0.1
 */