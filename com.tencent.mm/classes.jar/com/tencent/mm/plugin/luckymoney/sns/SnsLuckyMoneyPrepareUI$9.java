package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsLuckyMoneyPrepareUI$9
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$9(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65371);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    SnsLuckyMoneyPrepareUI.l(this.vrK).setVisibility(8);
    SnsLuckyMoneyPrepareUI.o(this.vrK);
    a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.9
 * JD-Core Version:    0.7.0.1
 */