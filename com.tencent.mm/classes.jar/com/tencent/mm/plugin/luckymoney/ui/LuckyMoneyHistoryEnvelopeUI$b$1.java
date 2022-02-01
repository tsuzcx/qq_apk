package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.view.recyclerview.i;

final class LuckyMoneyHistoryEnvelopeUI$b$1
  implements View.OnClickListener
{
  LuckyMoneyHistoryEnvelopeUI$b$1(LuckyMoneyHistoryEnvelopeUI.b paramb, i parami, cjf paramcjf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(277842);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$EnvelopeConvertItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.EJu.a(this.EEG, this.EJt, true);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$EnvelopeConvertItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.b.1
 * JD-Core Version:    0.7.0.1
 */