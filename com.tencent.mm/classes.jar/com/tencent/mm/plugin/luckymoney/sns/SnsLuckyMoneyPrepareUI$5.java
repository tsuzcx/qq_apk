package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsLuckyMoneyPrepareUI$5
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$5(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.lTI)), Integer.valueOf(9) });
    paramView = new Intent();
    paramView.setClass(this.lTI.mController.uMN, LuckyMoneyCanShareListUI.class);
    this.lTI.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.5
 * JD-Core Version:    0.7.0.1
 */