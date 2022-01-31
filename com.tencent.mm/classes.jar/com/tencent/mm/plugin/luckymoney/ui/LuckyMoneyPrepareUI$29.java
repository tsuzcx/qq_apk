package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyPrepareUI$29
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$29(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42974);
    h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(this.owL)), Integer.valueOf(9) });
    paramView = new Intent();
    paramView.setClass(this.owL.getContext(), LuckyMoneyCanShareListUI.class);
    this.owL.startActivity(paramView);
    AppMethodBeat.o(42974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.29
 * JD-Core Version:    0.7.0.1
 */