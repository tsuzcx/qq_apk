package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.wallet_core.ui.g;

final class LaunchAAUI$17
  implements View.OnClickListener
{
  LaunchAAUI$17(LaunchAAUI paramLaunchAAUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(194898);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    g.bA(this.mPg.getContext(), this.val$url);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(194898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.17
 * JD-Core Version:    0.7.0.1
 */