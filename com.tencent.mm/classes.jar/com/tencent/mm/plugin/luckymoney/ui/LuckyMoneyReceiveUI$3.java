package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyReceiveUI$3
  implements View.OnClickListener
{
  LuckyMoneyReceiveUI$3(LuckyMoneyReceiveUI paramLuckyMoneyReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyReceiveUI.tv(LuckyMoneyReceiveUI.d(this.lXA).lPR)), Integer.valueOf(LuckyMoneyReceiveUI.e(this.lXA)), Integer.valueOf(0), Integer.valueOf(2) });
    paramView = this.lXA;
    paramView.b(new ad(paramView.lRQ.msgType, paramView.lRQ.bvj, paramView.lRQ.lMg, paramView.lRQ.ceb, o.bfL(), q.Gl(), paramView.getIntent().getStringExtra("key_username"), "v1.0", paramView.lRQ.lRM), false);
    o.c(paramView.lMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI.3
 * JD-Core Version:    0.7.0.1
 */