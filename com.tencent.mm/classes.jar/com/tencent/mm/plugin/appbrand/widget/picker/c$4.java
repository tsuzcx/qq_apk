package com.tencent.mm.plugin.appbrand.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$4
  implements View.OnClickListener
{
  c$4(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138044);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = this.ozS;
    if (c.e(this.ozS) == null) {}
    for (paramView = null;; paramView = c.e(this.ozS).currentValue())
    {
      c.a((c)localObject, true, paramView);
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138044);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c.4
 * JD-Core Version:    0.7.0.1
 */