package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.Button;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class LuckyMoneyPrepareUI$29
  implements am.a
{
  LuckyMoneyPrepareUI$29(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final boolean tC()
  {
    int i;
    double d2;
    if ((LuckyMoneyPrepareUI.b(this.lXg).bfp() != 3) && (LuckyMoneyPrepareUI.a(this.lXg).bfp() != 3))
    {
      i = LuckyMoneyPrepareUI.a(this.lXg).getInput();
      d2 = LuckyMoneyPrepareUI.b(this.lXg).getInput();
      d1 = d2;
      if (LuckyMoneyPrepareUI.c(this.lXg) != 0) {}
    }
    for (double d1 = d2 * i;; d1 = 0.0D)
    {
      if ((d1 == 0.0D) || (d1 > LuckyMoneyPrepareUI.d(this.lXg).lLa) || (LuckyMoneyPrepareUI.p(this.lXg).bgj()))
      {
        LuckyMoneyPrepareUI.q(this.lXg).setClickable(false);
        LuckyMoneyPrepareUI.q(this.lXg).setEnabled(false);
      }
      for (;;)
      {
        y.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.p(this.lXg).bgj());
        LuckyMoneyPrepareUI.r(this.lXg).crl();
        return false;
        LuckyMoneyPrepareUI.q(this.lXg).setClickable(true);
        LuckyMoneyPrepareUI.q(this.lXg).setEnabled(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.29
 * JD-Core Version:    0.7.0.1
 */