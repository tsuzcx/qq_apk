package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardMainUI$14
  implements a.a
{
  QrRewardMainUI$14(QrRewardMainUI paramQrRewardMainUI, b paramb) {}
  
  public final void i(m paramm)
  {
    y.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramm });
    if (!this.iJn.iIb) {
      QrRewardMainUI.a(this.iJi, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.14
 * JD-Core Version:    0.7.0.1
 */