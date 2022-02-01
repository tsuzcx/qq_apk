package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.w;

final class h$1
  implements View.OnClickListener
{
  h$1(w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(321991);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    k.a(this.qrd.mAppId, k.d.qrG);
    this.qrd.finish();
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(321991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.1
 * JD-Core Version:    0.7.0.1
 */