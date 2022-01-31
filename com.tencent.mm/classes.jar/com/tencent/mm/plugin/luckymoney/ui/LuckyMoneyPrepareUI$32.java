package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyPrepareUI$32
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$32(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42979);
    h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(this.owL)), Integer.valueOf(6) });
    x.a(this.owL, LuckyMoneyPrepareUI.d(this.owL), LuckyMoneyPrepareUI.D(this.owL), true);
    LuckyMoneyPrepareUI.E(this.owL).postDelayed(new LuckyMoneyPrepareUI.32.1(this), 100L);
    AppMethodBeat.o(42979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.32
 * JD-Core Version:    0.7.0.1
 */