package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ab;

final class g$6
  implements View.OnClickListener
{
  g$6(g paramg, aa paramaa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(206139);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
    paramView = this.kfC.getContext().getString(2131755329);
    paramView = paramView + ab.eUO();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:".concat(String.valueOf(paramView)));
    ((com.tencent.mm.plugin.appbrand.jsapi.ac)this.kfC.K(com.tencent.mm.plugin.appbrand.jsapi.ac.class)).a(this.kfC.getContext(), paramView, null);
    AppMethodBeat.o(206139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.6
 * JD-Core Version:    0.7.0.1
 */