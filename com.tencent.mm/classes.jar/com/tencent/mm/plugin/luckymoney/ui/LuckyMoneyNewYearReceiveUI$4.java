package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyNewYearReceiveUI$4
  implements View.OnClickListener
{
  LuckyMoneyNewYearReceiveUI$4(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42787);
    this.ouD.finish();
    h.qsU.e(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
    AppMethodBeat.o(42787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */