package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ah$4
  implements View.OnClickListener
{
  ah$4(ah paramah) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47870);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.qtr.a(this.qtr.cdX(), null, null);
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(47870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah.4
 * JD-Core Version:    0.7.0.1
 */