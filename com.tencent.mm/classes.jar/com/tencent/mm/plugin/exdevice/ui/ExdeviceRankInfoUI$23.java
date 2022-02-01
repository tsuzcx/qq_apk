package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.exdevice.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;

final class ExdeviceRankInfoUI$23
  implements View.OnClickListener
{
  ExdeviceRankInfoUI$23(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24233);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
    e.g(this.yCI);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(24233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.23
 * JD-Core Version:    0.7.0.1
 */