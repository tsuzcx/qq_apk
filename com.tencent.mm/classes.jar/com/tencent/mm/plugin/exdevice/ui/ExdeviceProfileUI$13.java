package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ExdeviceProfileUI$13
  implements View.OnClickListener
{
  ExdeviceProfileUI$13(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24107);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ExdeviceProfileUI.w(this.vpc);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(24107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.13
 * JD-Core Version:    0.7.0.1
 */