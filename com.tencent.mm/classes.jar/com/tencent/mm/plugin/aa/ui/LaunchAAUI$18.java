package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;

final class LaunchAAUI$18
  implements View.OnClickListener
{
  LaunchAAUI$18(LaunchAAUI paramLaunchAAUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(189759);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.jab.hideTenpayKB();
    this.jab.hideVKB();
    LaunchAAUI.a(this.jab, this.fQb);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(189759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.18
 * JD-Core Version:    0.7.0.1
 */