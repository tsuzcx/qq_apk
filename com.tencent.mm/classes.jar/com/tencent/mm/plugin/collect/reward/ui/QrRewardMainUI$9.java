package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class QrRewardMainUI$9
  implements View.OnClickListener
{
  QrRewardMainUI$9(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63951);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.QrRewardMainUI", "open click");
    QrRewardMainUI.b(this.qyI, true);
    h.CyF.a(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(63951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.9
 * JD-Core Version:    0.7.0.1
 */