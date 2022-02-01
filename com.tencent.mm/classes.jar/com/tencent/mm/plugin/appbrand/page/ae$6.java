package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ae$6
  implements View.OnLongClickListener
{
  ae$6(ae paramae) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(47871);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
    this.mcH.buW();
    a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(47871);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.6
 * JD-Core Version:    0.7.0.1
 */