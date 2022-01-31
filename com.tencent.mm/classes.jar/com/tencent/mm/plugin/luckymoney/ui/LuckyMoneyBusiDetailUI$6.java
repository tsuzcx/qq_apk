package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyBusiDetailUI$6
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$6(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42588);
    h.qsU.e(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.yv(this.orS.onK)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    paramView = new Intent();
    paramView.setClass(this.orQ.getContext(), LuckyMoneyMyRecordUI.class);
    paramView.putExtra("key_type", 2);
    this.orQ.startActivity(paramView);
    AppMethodBeat.o(42588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.6
 * JD-Core Version:    0.7.0.1
 */