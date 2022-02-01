package com.tencent.mm.plugin.aa.ui;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.a.e;

final class LaunchAAUI$7
  implements View.OnClickListener
{
  LaunchAAUI$7(LaunchAAUI paramLaunchAAUI, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63636);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    LaunchAAUI.getKV().edit().putBoolean("new_open_IM_user_guide_show", false);
    this.jaP.bYF();
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(63636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.7
 * JD-Core Version:    0.7.0.1
 */