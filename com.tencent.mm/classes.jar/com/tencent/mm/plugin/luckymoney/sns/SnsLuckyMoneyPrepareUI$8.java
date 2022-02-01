package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.report.service.h;

final class SnsLuckyMoneyPrepareUI$8
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$8(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(283876);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    h.OAn.b(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.Kwc)), Integer.valueOf(6) });
    ah.a(this.Kwc, SnsLuckyMoneyPrepareUI.a(this.Kwc), SnsLuckyMoneyPrepareUI.m(this.Kwc), false);
    SnsLuckyMoneyPrepareUI.l(this.Kwc).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(283882);
        SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.8.this.Kwc).setVisibility(8);
        SnsLuckyMoneyPrepareUI.n(SnsLuckyMoneyPrepareUI.8.this.Kwc);
        AppMethodBeat.o(283882);
      }
    }, 100L);
    a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.8
 * JD-Core Version:    0.7.0.1
 */