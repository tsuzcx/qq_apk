package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.page.c.d;

final class aa$2$1
  implements View.OnClickListener
{
  aa$2$1(aa.2 param2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(327743);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigationBarRightButton$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    d.h(this.sol.soi);
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigationBarRightButton$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(327743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.aa.2.1
 * JD-Core Version:    0.7.0.1
 */