package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;

final class LaunchAAUI$37
  implements View.OnClickListener
{
  LaunchAAUI$37(LaunchAAUI paramLaunchAAUI, ImageView paramImageView, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213065);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Aa.LaunchAAUI", "choose aaByPerson mdoe");
    if (this.jYh.getVisibility() == 8) {
      this.jYh.setVisibility(0);
    }
    LaunchAAUI.a(this.jXQ, com.tencent.mm.plugin.aa.model.a.jRK);
    LaunchAAUI.b(this.jXQ, 5);
    LaunchAAUI.v(this.jXQ);
    this.gwC.bMo();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.37
 * JD-Core Version:    0.7.0.1
 */