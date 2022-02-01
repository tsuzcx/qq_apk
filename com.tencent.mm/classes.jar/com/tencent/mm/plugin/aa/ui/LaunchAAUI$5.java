package com.tencent.mm.plugin.aa.ui;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.a.e;

final class LaunchAAUI$5
  implements View.OnClickListener
{
  LaunchAAUI$5(LaunchAAUI paramLaunchAAUI, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213025);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    LaunchAAUI.getKV().edit().putBoolean("new_user_guide_show", false);
    this.gwC.bMo();
    this.jXQ.uZ(2);
    a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.5
 * JD-Core Version:    0.7.0.1
 */