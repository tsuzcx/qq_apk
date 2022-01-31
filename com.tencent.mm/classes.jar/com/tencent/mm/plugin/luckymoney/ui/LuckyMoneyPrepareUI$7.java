package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.c;
import com.tencent.mm.plugin.luckymoney.model.f;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyPrepareUI$7
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$7(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142061);
    ab.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout");
    paramView = x.ev(this.owL.getContext());
    f localf = f.bNf();
    localf.b(new c(""));
    localf.a(new LuckyMoneyPrepareUI.7.1(this, paramView));
    h.qsU.e(16822, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(142061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.7
 * JD-Core Version:    0.7.0.1
 */