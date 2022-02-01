package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class QrRewardSelectMoneyUI$2
  implements View.OnClickListener
{
  QrRewardSelectMoneyUI$2(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63991);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    QrRewardSelectMoneyUI.a(this.pjQ, 0, 2);
    a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(63991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.2
 * JD-Core Version:    0.7.0.1
 */