package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

final class WxaLuckyMoneyPrepareUI$15
  implements com.tencent.mm.plugin.wallet_core.ui.h.a
{
  WxaLuckyMoneyPrepareUI$15(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, SpannableString paramSpannableString) {}
  
  public final void onClick(View paramView)
  {
    int i = WxaLuckyMoneyPrepareUI.c(this.lMx).getInput();
    double d = WxaLuckyMoneyPrepareUI.b(this.lMx).getInput();
    WxaLuckyMoneyPrepareUI.a(this.lMx, com.tencent.mm.plugin.luckymoney.appbrand.a.h.a.lLg);
    WxaLuckyMoneyPrepareUI.b(this.lMx).setType(WxaLuckyMoneyPrepareUI.e(this.lMx));
    WxaLuckyMoneyPrepareUI.b(this.lMx).setMaxAmount(g.lKW.lLa);
    WxaLuckyMoneyPrepareUI.b(this.lMx).setTitle(this.lMx.getString(a.i.lucky_money_total_amount_title));
    WxaLuckyMoneyPrepareUI.b(this.lMx).setShowGroupIcon(true);
    if ((d > 0.0D) && (i > 0)) {
      WxaLuckyMoneyPrepareUI.b(this.lMx).setAmount(e.A(d * i));
    }
    WxaLuckyMoneyPrepareUI.g(this.lMx).setText(this.lMD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.15
 * JD-Core Version:    0.7.0.1
 */