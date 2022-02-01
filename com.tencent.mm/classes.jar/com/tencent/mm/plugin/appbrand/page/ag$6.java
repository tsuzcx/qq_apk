package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ag$6
  implements View.OnLongClickListener
{
  ag$6(ag paramag) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(47871);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    this.nry.bRN();
    a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(47871);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag.6
 * JD-Core Version:    0.7.0.1
 */