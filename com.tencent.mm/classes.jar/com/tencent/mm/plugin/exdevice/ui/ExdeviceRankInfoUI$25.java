package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.exdevice.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;

final class ExdeviceRankInfoUI$25
  implements View.OnClickListener
{
  ExdeviceRankInfoUI$25(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179647);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
    e.e(this.rKI);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.25
 * JD-Core Version:    0.7.0.1
 */