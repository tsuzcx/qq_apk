package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class LuckyMoneyPrepareUI$45
  implements ap.a
{
  LuckyMoneyPrepareUI$45(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(142098);
    int i;
    double d2;
    if ((LuckyMoneyPrepareUI.c(this.owL).bMP() != 3) && (LuckyMoneyPrepareUI.b(this.owL).bMP() != 3))
    {
      i = LuckyMoneyPrepareUI.b(this.owL).getInput();
      d2 = LuckyMoneyPrepareUI.c(this.owL).getInput();
      d1 = d2;
      if (LuckyMoneyPrepareUI.d(this.owL) != 0) {}
    }
    for (double d1 = d2 * i;; d1 = 0.0D)
    {
      if ((d1 == 0.0D) || (d1 > LuckyMoneyPrepareUI.e(this.owL).oiu) || (LuckyMoneyPrepareUI.j(this.owL).bNZ()))
      {
        LuckyMoneyPrepareUI.k(this.owL).setClickable(false);
        LuckyMoneyPrepareUI.k(this.owL).setEnabled(false);
      }
      for (;;)
      {
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.j(this.owL).bNZ());
        LuckyMoneyPrepareUI.l(this.owL).dtj();
        AppMethodBeat.o(142098);
        return false;
        LuckyMoneyPrepareUI.k(this.owL).setClickable(true);
        LuckyMoneyPrepareUI.k(this.owL).setEnabled(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.45
 * JD-Core Version:    0.7.0.1
 */