package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayReceiveCardUI$9
  implements m.a
{
  HoneyPayReceiveCardUI$9(HoneyPayReceiveCardUI paramHoneyPayReceiveCardUI, bhi parambhi) {}
  
  public final void aEP()
  {
    if (!bk.bl(this.lml.tzx)) {
      e.l(this.lmj.mController.uMN, this.lml.tzx, false);
    }
    h.nFQ.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.9
 * JD-Core Version:    0.7.0.1
 */