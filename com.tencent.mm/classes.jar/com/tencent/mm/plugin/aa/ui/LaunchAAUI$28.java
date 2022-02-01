package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LaunchAAUI$28
  implements View.OnClickListener
{
  LaunchAAUI$28(LaunchAAUI paramLaunchAAUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63662);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    LaunchAAUI.b(this.jab);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(63662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.28
 * JD-Core Version:    0.7.0.1
 */