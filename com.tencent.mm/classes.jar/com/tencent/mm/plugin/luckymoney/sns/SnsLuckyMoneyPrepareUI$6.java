package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.wallet_core.ui.i;

final class SnsLuckyMoneyPrepareUI$6
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$6(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, as paramas) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65366);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    i.p(this.Kwc.getContext(), this.Kwd.Kuq, false);
    a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */