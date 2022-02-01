package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.i;

final class LuckyMoneyHistoryEnvelopeUI$7
  implements View.OnClickListener
{
  LuckyMoneyHistoryEnvelopeUI$7(LuckyMoneyHistoryEnvelopeUI paramLuckyMoneyHistoryEnvelopeUI, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(268006);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.qVA.dismiss();
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(268006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.7
 * JD-Core Version:    0.7.0.1
 */