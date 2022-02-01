package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$9
  implements View.OnClickListener
{
  c$9(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(170177);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!c.g(this.KiS)) {
      c.H(this.KiS);
    }
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(170177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.9
 * JD-Core Version:    0.7.0.1
 */