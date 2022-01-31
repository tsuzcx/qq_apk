package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyReceiveUI$4
  implements View.OnClickListener
{
  LuckyMoneyReceiveUI$4(LuckyMoneyReceiveUI paramLuckyMoneyReceiveUI, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.lXB) {
      h.nFQ.f(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyReceiveUI.tv(LuckyMoneyReceiveUI.d(this.lXA).lPR)), Integer.valueOf(LuckyMoneyReceiveUI.e(this.lXA)), Integer.valueOf(0), Integer.valueOf(1) });
    }
    paramView = new Intent();
    paramView.setClass(this.lXA.mController.uMN, LuckyMoneyDetailUI.class);
    paramView.putExtra("key_native_url", LuckyMoneyReceiveUI.d(this.lXA).ceb);
    paramView.putExtra("key_sendid", LuckyMoneyReceiveUI.d(this.lXA).lMg);
    this.lXA.startActivity(paramView);
    this.lXA.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */