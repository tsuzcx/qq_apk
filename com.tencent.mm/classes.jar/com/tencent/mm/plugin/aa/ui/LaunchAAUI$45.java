package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LaunchAAUI$45
  implements View.OnClickListener
{
  LaunchAAUI$45(LaunchAAUI paramLaunchAAUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213070);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    LaunchAAUI.h(this.jXQ);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.45
 * JD-Core Version:    0.7.0.1
 */