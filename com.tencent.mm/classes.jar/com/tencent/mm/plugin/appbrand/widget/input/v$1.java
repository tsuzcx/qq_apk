package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class v$1
  implements View.OnClickListener
{
  v$1(v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136476);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    v.a(this.otR);
    this.otR.setVisibility(8);
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(136476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v.1
 * JD-Core Version:    0.7.0.1
 */