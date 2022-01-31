package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.protocal.c.na;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardMainUI$16
  implements a.a
{
  QrRewardMainUI$16(QrRewardMainUI paramQrRewardMainUI, b paramb) {}
  
  public final void i(m paramm)
  {
    QrRewardMainUI.a(this.iJi, this.iJn.iIa.iet);
    QrRewardMainUI.a(this.iJi, this.iJn.iIa.sKL);
    QrRewardMainUI.b(this.iJi, this.iJn.iIa.sKH);
    QrRewardMainUI.b(this.iJi, this.iJn.iIa.desc);
    QrRewardMainUI.c(this.iJi, this.iJn.iIa.qsJ);
    paramm = this.iJi;
    boolean bool;
    if (!this.iJn.iIa.sKF)
    {
      bool = true;
      QrRewardMainUI.b(paramm, bool);
      QrRewardMainUI.d(this.iJi, this.iJn.iIa.imZ);
      QrRewardMainUI.e(this.iJi, this.iJn.iIa.sKJ);
      QrRewardMainUI.d(this.iJi);
      QrRewardMainUI.e(this.iJi);
      if (QrRewardMainUI.f(this.iJi)) {
        break label232;
      }
      QrRewardMainUI.g(this.iJi);
    }
    for (;;)
    {
      QrRewardMainUI.f(this.iJi, this.iJn.iIa.nxM);
      QrRewardMainUI.aEO();
      y.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.j(this.iJi) });
      return;
      bool = false;
      break;
      label232:
      QrRewardMainUI.a(this.iJi, this.iJn.iIa.nxM, this.iJn.iIa.sKG);
      QrRewardMainUI.h(this.iJi);
      QrRewardMainUI.i(this.iJi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.16
 * JD-Core Version:    0.7.0.1
 */