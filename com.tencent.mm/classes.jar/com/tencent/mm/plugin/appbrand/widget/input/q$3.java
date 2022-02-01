package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class q$3
  implements View.OnLongClickListener
{
  q$3(q paramq) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(136434);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputWidgetMultiLine$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
    boolean bool = this.neO.bCr();
    a.a(bool, this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputWidgetMultiLine$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(136434);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.q.3
 * JD-Core Version:    0.7.0.1
 */