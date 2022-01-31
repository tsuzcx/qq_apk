package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$22
  implements h.a
{
  LuckyMoneyPrepareUI$22(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, SpannableString paramSpannableString) {}
  
  public final void onClick(View paramView)
  {
    int i = LuckyMoneyPrepareUI.a(this.lXg).getInput();
    double d = LuckyMoneyPrepareUI.b(this.lXg).getInput();
    LuckyMoneyPrepareUI.a(this.lXg, 1);
    LuckyMoneyPrepareUI.b(this.lXg).setType(LuckyMoneyPrepareUI.c(this.lXg));
    LuckyMoneyPrepareUI.b(this.lXg).setMaxAmount(LuckyMoneyPrepareUI.d(this.lXg).lLa);
    LuckyMoneyPrepareUI.b(this.lXg).setTitle(this.lXg.getString(a.i.lucky_money_total_amount_title));
    LuckyMoneyPrepareUI.b(this.lXg).setShowGroupIcon(true);
    if ((d > 0.0D) && (i > 0)) {
      LuckyMoneyPrepareUI.b(this.lXg).setAmount(e.A(d * i));
    }
    LuckyMoneyPrepareUI.e(this.lXg).setText(this.lMD);
    h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.lXg)), Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.22
 * JD-Core Version:    0.7.0.1
 */