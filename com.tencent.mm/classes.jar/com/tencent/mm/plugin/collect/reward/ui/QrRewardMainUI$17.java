package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMEditText;

final class QrRewardMainUI$17
  implements a.a
{
  QrRewardMainUI$17(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void i(m paramm)
  {
    y.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramm });
    QrRewardMainUI.a(this.iJi, (String)g.DP().Dz().get(ac.a.uyd, ""));
    QrRewardMainUI.c(this.iJi, QrRewardMainUI.k(this.iJi));
    QrRewardMainUI.l(this.iJi).setText("");
    QrRewardMainUI.i(this.iJi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.17
 * JD-Core Version:    0.7.0.1
 */