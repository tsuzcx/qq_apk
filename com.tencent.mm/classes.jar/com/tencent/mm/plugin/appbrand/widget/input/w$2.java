package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class w$2
  implements View.OnClickListener
{
  w$2(w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136504);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView.isSelected())
    {
      w.bFy().o(this.nkK);
      paramView.setSelected(false);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(136504);
      return;
      w.bFy().p(this.nkK);
      paramView.setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w.2
 * JD-Core Version:    0.7.0.1
 */