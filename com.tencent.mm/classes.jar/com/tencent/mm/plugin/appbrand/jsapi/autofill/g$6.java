package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

final class g$6
  implements View.OnClickListener
{
  g$6(g paramg, ac paramac) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(229895);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
    paramView = this.lIf.getContext().getString(2131755365);
    paramView = paramView + LocaleUtil.getApplicationLanguage();
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:".concat(String.valueOf(paramView)));
    ((ag)this.lIf.M(ag.class)).a(this.lIf.getContext(), paramView, null);
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(229895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.6
 * JD-Core Version:    0.7.0.1
 */