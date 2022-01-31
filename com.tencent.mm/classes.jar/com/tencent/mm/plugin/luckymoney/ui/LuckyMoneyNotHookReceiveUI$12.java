package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyNotHookReceiveUI$12
  implements View.OnClickListener
{
  LuckyMoneyNotHookReceiveUI$12(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42859);
    if (this.ovy) {
      h.qsU.e(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.yG(LuckyMoneyNotHookReceiveUI.i(this.ovv).cMP)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.j(this.ovv)), Integer.valueOf(0), Integer.valueOf(1) });
    }
    paramView = new Intent();
    paramView.setClass(this.ovv.getContext(), LuckyMoneyBeforeDetailUI.class);
    paramView.putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.i(this.ovv).cMO);
    paramView.putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.i(this.ovv).ojA);
    paramView.putExtra("key_lucky_money_can_received", true);
    paramView.putExtra("key_username", this.ovv.getIntent().getStringExtra("key_username"));
    this.ovv.startActivity(paramView);
    this.ovv.finish();
    AppMethodBeat.o(42859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.12
 * JD-Core Version:    0.7.0.1
 */