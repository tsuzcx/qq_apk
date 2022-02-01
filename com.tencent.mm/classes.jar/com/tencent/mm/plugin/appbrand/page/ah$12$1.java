package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.page.c.d;
import com.tencent.mm.sdk.platformtools.Log;

final class ah$12$1
  implements View.OnClickListener
{
  ah$12$1(ah.12 param12) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(325045);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
    d.h(this.tyb.txX);
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(325045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah.12.1
 * JD-Core Version:    0.7.0.1
 */