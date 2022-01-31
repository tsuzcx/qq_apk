package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;

final class SnsLuckyMoneyPrepareUI$8
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$8(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.lTI)), Integer.valueOf(6) });
    o.a(this.lTI, SnsLuckyMoneyPrepareUI.a(this.lTI), SnsLuckyMoneyPrepareUI.m(this.lTI), false);
    SnsLuckyMoneyPrepareUI.l(this.lTI).postDelayed(new Runnable()
    {
      public final void run()
      {
        SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.8.this.lTI).setVisibility(8);
        SnsLuckyMoneyPrepareUI.n(SnsLuckyMoneyPrepareUI.8.this.lTI);
      }
    }, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.8
 * JD-Core Version:    0.7.0.1
 */