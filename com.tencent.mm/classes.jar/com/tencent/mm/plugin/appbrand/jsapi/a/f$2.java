package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;

final class f$2
  implements View.OnClickListener
{
  f$2(f paramf, v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(101966);
    ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
    paramView = this.hEe.getContext().getString(2131306123);
    paramView = paramView + aa.dsG();
    ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:".concat(String.valueOf(paramView)));
    ((x)this.hEe.q(x.class)).a(this.hEe.getContext(), paramView, null);
    AppMethodBeat.o(101966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.f.2
 * JD-Core Version:    0.7.0.1
 */