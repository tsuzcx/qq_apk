package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppBrandMenuHeader$1
  implements View.OnClickListener
{
  AppBrandMenuHeader$1(AppBrandMenuHeader paramAppBrandMenuHeader, Runnable paramRunnable) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47771);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.nnO.run();
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(47771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.1
 * JD-Core Version:    0.7.0.1
 */