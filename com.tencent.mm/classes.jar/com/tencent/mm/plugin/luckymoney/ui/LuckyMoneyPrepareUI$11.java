package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$11
  implements h.a
{
  LuckyMoneyPrepareUI$11(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, SpannableString paramSpannableString) {}
  
  public final void onClick(View paramView)
  {
    int i = LuckyMoneyPrepareUI.a(this.lXg).getInput();
    double d = LuckyMoneyPrepareUI.b(this.lXg).getInput();
    LuckyMoneyPrepareUI.a(this.lXg, 0);
    LuckyMoneyPrepareUI.b(this.lXg).setType(LuckyMoneyPrepareUI.c(this.lXg));
    LuckyMoneyPrepareUI.b(this.lXg).setShowGroupIcon(false);
    LuckyMoneyPrepareUI.b(this.lXg).setTitle(this.lXg.getString(a.i.lucky_money_unit_amount_title));
    if ((d > 0.0D) && (i > 0)) {
      LuckyMoneyPrepareUI.b(this.lXg).setAmount(e.A(d / i));
    }
    LuckyMoneyPrepareUI.b(this.lXg).setMaxAmount(LuckyMoneyPrepareUI.d(this.lXg).lKY);
    LuckyMoneyPrepareUI.e(this.lXg).setText(this.lMC);
    h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.lXg)), Integer.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.11
 * JD-Core Version:    0.7.0.1
 */