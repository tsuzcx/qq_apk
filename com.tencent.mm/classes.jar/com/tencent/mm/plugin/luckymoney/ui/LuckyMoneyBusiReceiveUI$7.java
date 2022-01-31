package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.t;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;

final class LuckyMoneyBusiReceiveUI$7
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$7(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI, t paramt) {}
  
  public final void onClick(View paramView)
  {
    LuckyMoneyBusiReceiveUI.k(this.lUZ).setVisibility(4);
    LuckyMoneyBusiReceiveUI.l(this.lUZ).setVisibility(8);
    LuckyMoneyBusiReceiveUI.m(this.lUZ).setVisibility(8);
    if ((this.lVb.lQh != null) && (!bk.bl(this.lVb.lQh.lPF))) {}
    for (paramView = this.lVb.lQh.lPF;; paramView = this.lUZ.getString(a.i.lucky_money_share_friends_tips))
    {
      LuckyMoneyBusiReceiveUI.n(this.lUZ).setText(paramView);
      LuckyMoneyBusiReceiveUI.o(this.lUZ).setText(this.lVb.lQS);
      LuckyMoneyBusiReceiveUI.p(this.lUZ).setVisibility(0);
      LuckyMoneyBusiReceiveUI.n(this.lUZ).setOnClickListener(new LuckyMoneyBusiReceiveUI.7.1(this));
      o.a(LuckyMoneyBusiReceiveUI.k(this.lUZ), new LuckyMoneyBusiReceiveUI.7.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.7
 * JD-Core Version:    0.7.0.1
 */