package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class LaunchAAUI$34
  implements View.OnClickListener
{
  LaunchAAUI$34(LaunchAAUI paramLaunchAAUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63662);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Aa.LaunchAAUI", "click launchButton，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.b(this.jXQ)), Integer.valueOf(LaunchAAUI.c(this.jXQ)) });
    LaunchAAUI.d(this.jXQ);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(63662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.34
 * JD-Core Version:    0.7.0.1
 */