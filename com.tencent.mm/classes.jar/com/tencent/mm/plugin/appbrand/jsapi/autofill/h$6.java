package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

final class h$6
  implements View.OnClickListener
{
  h$6(h paramh, ad paramad) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(242091);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
    paramView = this.oEt.getContext().getString(a.g.app_brand_auth_user_auto_fill_data_url);
    paramView = paramView + LocaleUtil.getApplicationLanguage();
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:".concat(String.valueOf(paramView)));
    ((ag)this.oEt.K(ag.class)).a(this.oEt.getContext(), paramView, null);
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiRequestAuthUserAutoFillData$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.h.6
 * JD-Core Version:    0.7.0.1
 */