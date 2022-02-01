package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.wallet_core.ui.e;

final class SnsLuckyMoneyPrepareUI$6
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$6(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, ai paramai) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65367);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    e.o(this.vrK.getContext(), this.vrL.vqh, false);
    a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */