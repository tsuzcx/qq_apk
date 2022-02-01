package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.wallet_core.ui.f;

final class LaunchAAUI$14
  implements View.OnClickListener
{
  LaunchAAUI$14(LaunchAAUI paramLaunchAAUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(189755);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    f.aY(this.jab.getContext(), this.val$url);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(189755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.14
 * JD-Core Version:    0.7.0.1
 */