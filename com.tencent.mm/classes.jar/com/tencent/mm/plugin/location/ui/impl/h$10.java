package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.location.ui.j;

final class h$10
  implements View.OnClickListener
{
  h$10(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(56124);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.yND.yNs.edw();
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(56124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.10
 * JD-Core Version:    0.7.0.1
 */