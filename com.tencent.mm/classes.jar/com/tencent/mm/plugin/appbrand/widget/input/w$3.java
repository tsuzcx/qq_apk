package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class w$3
  implements View.OnClickListener
{
  w$3(w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136505);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.nfC.bM(true);
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(136505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w.3
 * JD-Core Version:    0.7.0.1
 */