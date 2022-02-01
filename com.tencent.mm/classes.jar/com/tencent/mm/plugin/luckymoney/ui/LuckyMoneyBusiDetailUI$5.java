package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyBusiDetailUI$5
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$5(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65454);
    h.wUl.f(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.HT(this.usO.ulQ)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    z.a(this.usM, 1, false);
    AppMethodBeat.o(65454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.5
 * JD-Core Version:    0.7.0.1
 */