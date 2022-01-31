package com.tencent.mm.plugin.luckymoney.sns;

import android.widget.Button;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class SnsLuckyMoneyPrepareUI$17
  implements am.a
{
  SnsLuckyMoneyPrepareUI$17(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final boolean tC()
  {
    int i;
    double d2;
    if ((this.lTI.lTx.bfp() != 3) && (this.lTI.lMm.bfp() != 3))
    {
      i = this.lTI.lMm.getInput();
      d2 = this.lTI.lTx.getInput();
      d1 = d2;
      if (SnsLuckyMoneyPrepareUI.a(this.lTI) != 0) {}
    }
    for (double d1 = d2 * i;; d1 = 0.0D)
    {
      if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(this.lTI).lLa) || (SnsLuckyMoneyPrepareUI.i(this.lTI).bgj()))
      {
        this.lTI.lMp.setClickable(false);
        this.lTI.lMp.setEnabled(false);
      }
      for (;;)
      {
        y.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(this.lTI).bgj());
        SnsLuckyMoneyPrepareUI.j(this.lTI).crl();
        return false;
        this.lTI.lMp.setClickable(true);
        this.lTI.lMp.setEnabled(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.17
 * JD-Core Version:    0.7.0.1
 */