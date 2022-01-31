package com.tencent.mm.plugin.luckymoney.sns;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

final class SnsLuckyMoneyPrepareUI$11
  implements h.a
{
  SnsLuckyMoneyPrepareUI$11(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, SpannableString paramSpannableString) {}
  
  public final void onClick(View paramView)
  {
    int i = this.lTI.lMm.getInput();
    double d = this.lTI.lTx.getInput();
    SnsLuckyMoneyPrepareUI.a(this.lTI, 0);
    this.lTI.lTx.setType(SnsLuckyMoneyPrepareUI.a(this.lTI));
    this.lTI.lTx.setShowGroupIcon(false);
    this.lTI.lTx.setTitle(this.lTI.getString(a.i.lucky_money_unit_amount_title));
    if ((d > 0.0D) && (i > 0)) {
      this.lTI.lTx.setAmount(e.A(d / i));
    }
    this.lTI.lTx.setMaxAmount(SnsLuckyMoneyPrepareUI.b(this.lTI).lKY);
    SnsLuckyMoneyPrepareUI.c(this.lTI).setText(this.lMC);
    h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.lTI)), Integer.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.11
 * JD-Core Version:    0.7.0.1
 */