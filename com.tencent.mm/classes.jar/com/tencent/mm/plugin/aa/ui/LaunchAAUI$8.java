package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.tools.q;

final class LaunchAAUI$8
  implements View.OnClickListener
{
  LaunchAAUI$8(LaunchAAUI paramLaunchAAUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(189747);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    q.aU(this.jab);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(189747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.8
 * JD-Core Version:    0.7.0.1
 */