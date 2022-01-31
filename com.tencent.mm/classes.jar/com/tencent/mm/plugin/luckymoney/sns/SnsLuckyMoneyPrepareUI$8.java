package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;

final class SnsLuckyMoneyPrepareUI$8
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$8(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42515);
    h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.oqN)), Integer.valueOf(6) });
    x.a(this.oqN, SnsLuckyMoneyPrepareUI.a(this.oqN), SnsLuckyMoneyPrepareUI.m(this.oqN), false);
    SnsLuckyMoneyPrepareUI.l(this.oqN).postDelayed(new SnsLuckyMoneyPrepareUI.8.1(this), 100L);
    AppMethodBeat.o(42515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.8
 * JD-Core Version:    0.7.0.1
 */