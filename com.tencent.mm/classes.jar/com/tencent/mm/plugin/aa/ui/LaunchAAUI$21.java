package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;

final class LaunchAAUI$21
  implements View.OnClickListener
{
  LaunchAAUI$21(LaunchAAUI paramLaunchAAUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213042);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.jXQ.hideTenpayKB();
    this.jXQ.hideVKB();
    LaunchAAUI.a(this.jXQ, this.gvl);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.21
 * JD-Core Version:    0.7.0.1
 */