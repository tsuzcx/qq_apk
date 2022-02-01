package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.page.c.d;
import com.tencent.mm.sdk.platformtools.Log;

final class ah$14$1
  implements View.OnClickListener
{
  ah$14$1(ah.14 param14) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47882);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
    d.h(this.qtv.qtr);
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(47882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah.14.1
 * JD-Core Version:    0.7.0.1
 */