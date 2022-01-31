package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.h.a.hn;
import com.tencent.mm.h.a.hn.b;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyBusiDetailUI$3
  implements Runnable
{
  LuckyMoneyBusiDetailUI$3(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, hn paramhn, f paramf) {}
  
  public final void run()
  {
    if (this.lUI.bPw.bPy)
    {
      y.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.lUI.bPw.bPz);
      AppCompatActivity localAppCompatActivity = this.lUH.mController.uMN;
      o.e(LuckyMoneyBusiDetailUI.i(this.lUH), this.lUI.bPw.bPz, a.e.lucky_money_busi_default_avatar);
    }
    do
    {
      return;
      y.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
    } while (bk.bl(this.lUJ.lPV));
    o.a(LuckyMoneyBusiDetailUI.i(this.lUH), this.lUJ.lPV, this.lUJ.lQp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.3
 * JD-Core Version:    0.7.0.1
 */