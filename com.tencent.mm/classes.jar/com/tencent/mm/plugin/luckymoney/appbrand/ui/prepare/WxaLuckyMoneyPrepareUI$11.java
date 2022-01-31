package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.widget.Toast;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;
import com.tencent.mm.wallet_core.ui.e;

final class WxaLuckyMoneyPrepareUI$11
  extends u
{
  WxaLuckyMoneyPrepareUI$11(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, String paramString) {}
  
  public final void aEI()
  {
    if (WxaLuckyMoneyPrepareUI.a(this.lMx) == null) {
      y.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
    }
    int i;
    double d;
    String str1;
    label155:
    do
    {
      return;
      if (WxaLuckyMoneyPrepareUI.b(this.lMx).bfp() != 0)
      {
        com.tencent.mm.ui.base.s.makeText(this.lMx.mController.uMN, a.i.wallet_balance_save_input_invalid, 0).show();
        return;
      }
      i = WxaLuckyMoneyPrepareUI.c(this.lMx).getInput();
      d = WxaLuckyMoneyPrepareUI.b(this.lMx).getInput();
      String str2 = WxaLuckyMoneyPrepareUI.d(this.lMx).getInput();
      str1 = str2;
      if (bk.bl(str2)) {
        if (bk.bl(this.lMB)) {
          break label155;
        }
      }
      for (str1 = this.lMB; WxaLuckyMoneyPrepareUI.e(this.lMx) == h.a.lLg; str1 = this.lMx.getString(a.i.lucky_money_default_wish))
      {
        WxaLuckyMoneyPrepareUI.a(this.lMx).c((int)e.C(d), i, str1, WxaLuckyMoneyPrepareUI.f(this.lMx));
        return;
      }
    } while (WxaLuckyMoneyPrepareUI.e(this.lMx) != h.a.lLh);
    WxaLuckyMoneyPrepareUI.a(this.lMx).d((int)e.C(d), i, str1, WxaLuckyMoneyPrepareUI.f(this.lMx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.11
 * JD-Core Version:    0.7.0.1
 */