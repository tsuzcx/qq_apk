package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyPrepareUI$20
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$20(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.lXg)), Integer.valueOf(6) });
    o.a(this.lXg, LuckyMoneyPrepareUI.c(this.lXg), LuckyMoneyPrepareUI.t(this.lXg), true);
    LuckyMoneyPrepareUI.u(this.lXg).postDelayed(new LuckyMoneyPrepareUI.20.1(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.20
 * JD-Core Version:    0.7.0.1
 */