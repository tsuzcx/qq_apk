package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55998);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.vrq.djU();
    this.vrq.hideVKB();
    this.vrq.activity.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(55998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a.4
 * JD-Core Version:    0.7.0.1
 */