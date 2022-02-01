package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class LaunchAAUI$18
  implements View.OnClickListener
{
  LaunchAAUI$18(LaunchAAUI paramLaunchAAUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213039);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Aa.LaunchAAUI", "click switch button");
    this.jXQ.hideTenpayKB();
    this.jXQ.hideVKB();
    LaunchAAUI.z(this.jXQ);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.18
 * JD-Core Version:    0.7.0.1
 */