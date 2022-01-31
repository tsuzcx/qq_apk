package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class QrRewardMainUI$7
  implements m.a
{
  QrRewardMainUI$7(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void aEP()
  {
    y.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[] { QrRewardMainUI.q(this.iJi) });
    e.l(this.iJi.mController.uMN, QrRewardMainUI.q(this.iJi), false);
    h.nFQ.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.7
 * JD-Core Version:    0.7.0.1
 */