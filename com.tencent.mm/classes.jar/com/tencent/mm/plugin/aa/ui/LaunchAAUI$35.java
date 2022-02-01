package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;

final class LaunchAAUI$35
  implements View.OnClickListener
{
  LaunchAAUI$35(LaunchAAUI paramLaunchAAUI, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213063);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.gwC.bMo();
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.35
 * JD-Core Version:    0.7.0.1
 */