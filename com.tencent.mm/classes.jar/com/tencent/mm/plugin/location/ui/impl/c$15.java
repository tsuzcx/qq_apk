package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$15
  implements View.OnClickListener
{
  c$15(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(182063);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    c.P(this.vgy).setText("");
    c.A(this.vgy);
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(182063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.15
 * JD-Core Version:    0.7.0.1
 */