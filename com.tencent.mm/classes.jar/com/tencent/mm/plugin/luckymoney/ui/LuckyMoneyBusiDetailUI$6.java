package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyBusiDetailUI$6
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$6(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.tr(this.lUJ.lQm)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    paramView = new Intent();
    paramView.setClass(this.lUH.mController.uMN, LuckyMoneyMyRecordUI.class);
    paramView.putExtra("key_type", 2);
    this.lUH.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.6
 * JD-Core Version:    0.7.0.1
 */