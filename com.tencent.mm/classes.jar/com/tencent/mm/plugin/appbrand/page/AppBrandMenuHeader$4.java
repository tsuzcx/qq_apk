package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppBrandMenuHeader$4
  implements View.OnClickListener
{
  AppBrandMenuHeader$4(AppBrandMenuHeader paramAppBrandMenuHeader, k paramk, ag paramag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47774);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    new k.6(this.nnR, this.nnS).run();
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(47774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.4
 * JD-Core Version:    0.7.0.1
 */