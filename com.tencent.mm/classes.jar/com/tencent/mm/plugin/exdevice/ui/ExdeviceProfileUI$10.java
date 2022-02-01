package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.exdevice.g.a.e;

final class ExdeviceProfileUI$10
  implements View.OnClickListener
{
  ExdeviceProfileUI$10(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24103);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    e.f(this.vpc);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(24103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.10
 * JD-Core Version:    0.7.0.1
 */