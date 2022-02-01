package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$30
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$30(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, ai paramai) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65860);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    e.o(this.vAO.getContext(), this.vrL.vqh, false);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.30
 * JD-Core Version:    0.7.0.1
 */