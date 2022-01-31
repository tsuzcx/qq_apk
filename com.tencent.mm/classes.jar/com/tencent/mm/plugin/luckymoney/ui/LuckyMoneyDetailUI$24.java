package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyDetailUI$24
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$24(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42674);
    h.qsU.e(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.yy(this.orS.onK)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    x.a(this.otz, 1, false);
    AppMethodBeat.o(42674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.24
 * JD-Core Version:    0.7.0.1
 */