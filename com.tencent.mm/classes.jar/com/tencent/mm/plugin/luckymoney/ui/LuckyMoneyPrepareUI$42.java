package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$42
  implements j.a
{
  LuckyMoneyPrepareUI$42(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, SpannableString paramSpannableString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42989);
    int i = LuckyMoneyPrepareUI.b(this.owL).getInput();
    double d = LuckyMoneyPrepareUI.c(this.owL).getInput();
    LuckyMoneyPrepareUI.a(this.owL, 1);
    LuckyMoneyPrepareUI.c(this.owL).setType(LuckyMoneyPrepareUI.d(this.owL));
    LuckyMoneyPrepareUI.c(this.owL).setMaxAmount(LuckyMoneyPrepareUI.e(this.owL).oiu);
    LuckyMoneyPrepareUI.c(this.owL).setTitle(this.owL.getString(2131301333));
    LuckyMoneyPrepareUI.c(this.owL).setShowGroupIcon(true);
    if ((d > 0.0D) && (i > 0)) {
      LuckyMoneyPrepareUI.c(this.owL).setAmount(e.E(d * i));
    }
    LuckyMoneyPrepareUI.f(this.owL).setText(this.ojW);
    h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(this.owL)), Integer.valueOf(2) });
    AppMethodBeat.o(42989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.42
 * JD-Core Version:    0.7.0.1
 */