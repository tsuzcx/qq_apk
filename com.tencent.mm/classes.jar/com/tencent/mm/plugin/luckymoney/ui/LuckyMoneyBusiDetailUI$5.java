package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyBusiDetailUI$5
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$5(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42587);
    h.qsU.e(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.yv(this.orS.onK)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    x.a(this.orQ, 1, false);
    AppMethodBeat.o(42587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.5
 * JD-Core Version:    0.7.0.1
 */