package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMEditText;

final class QrRewardMainUI$3
  implements a.a
{
  QrRewardMainUI$3(QrRewardMainUI paramQrRewardMainUI, h paramh) {}
  
  public final void i(m paramm)
  {
    y.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { this.iJj.iet, QrRewardMainUI.l(this.iJi).getText() });
    if (this.iJj.iet.equals(QrRewardMainUI.m(this.iJi)))
    {
      g.DP().Dz().c(ac.a.uyd, QrRewardMainUI.m(this.iJi));
      QrRewardMainUI.i(this.iJi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.3
 * JD-Core Version:    0.7.0.1
 */