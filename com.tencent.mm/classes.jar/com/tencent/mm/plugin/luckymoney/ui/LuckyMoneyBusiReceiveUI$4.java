package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyBusiReceiveUI$4
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$4(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42619);
    h.qsU.e(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    if (LuckyMoneyBusiReceiveUI.f(this.osi).isChecked()) {
      h.qsU.e(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(this.osi)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(this.osi).ooM });
    }
    for (;;)
    {
      LuckyMoneyBusiReceiveUI.i(this.osi);
      AppMethodBeat.o(42619);
      return;
      h.qsU.e(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(this.osi)), Integer.valueOf(2), "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */