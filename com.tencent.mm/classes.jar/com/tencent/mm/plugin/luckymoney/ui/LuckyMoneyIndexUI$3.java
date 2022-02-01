package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyIndexUI$3
  implements View.OnClickListener
{
  LuckyMoneyIndexUI$3(LuckyMoneyIndexUI paramLuckyMoneyIndexUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65600);
    h.vKh.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    LuckyMoneyIndexUI.a(this.tms, 1);
    AppMethodBeat.o(65600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.3
 * JD-Core Version:    0.7.0.1
 */