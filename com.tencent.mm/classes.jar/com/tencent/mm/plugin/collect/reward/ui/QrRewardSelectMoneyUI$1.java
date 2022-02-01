package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class QrRewardSelectMoneyUI$1
  implements AdapterView.OnItemClickListener
{
  QrRewardSelectMoneyUI$1(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(63990);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    paramInt = ((Integer)paramAdapterView.getAdapter().getItem(paramInt)).intValue();
    QrRewardSelectMoneyUI.a(this.pjQ, paramInt, 1);
    a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(63990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.1
 * JD-Core Version:    0.7.0.1
 */