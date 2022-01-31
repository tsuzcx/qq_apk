package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyPrepareUI$35
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$35(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42984);
    h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(this.owL)), Integer.valueOf(6) });
    x.a(this.owL, LuckyMoneyPrepareUI.d(this.owL), LuckyMoneyPrepareUI.D(this.owL), true);
    LuckyMoneyPrepareUI.E(this.owL).postDelayed(new LuckyMoneyPrepareUI.35.1(this), 100L);
    AppMethodBeat.o(42984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.35
 * JD-Core Version:    0.7.0.1
 */