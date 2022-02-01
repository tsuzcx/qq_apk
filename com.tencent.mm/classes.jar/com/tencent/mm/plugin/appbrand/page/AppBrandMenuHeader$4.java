package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppBrandMenuHeader$4
  implements View.OnClickListener
{
  AppBrandMenuHeader$4(AppBrandMenuHeader paramAppBrandMenuHeader, h paramh, ad paramad) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47774);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    new h.6(this.mdz, this.mdA).run();
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(47774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.4
 * JD-Core Version:    0.7.0.1
 */