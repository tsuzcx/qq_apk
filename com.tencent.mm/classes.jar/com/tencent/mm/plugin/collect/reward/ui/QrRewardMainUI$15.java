package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.protocal.c.na;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardMainUI$15
  implements a.a
{
  QrRewardMainUI$15(QrRewardMainUI paramQrRewardMainUI, b paramb) {}
  
  public final void i(m paramm)
  {
    y.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(this.iJn.iIa.iHq), this.iJn.iIa.iHr });
    if (!bk.bl(this.iJn.iIa.iHr)) {
      Toast.makeText(this.iJi, this.iJn.iIa.iHr, 0).show();
    }
    if (!this.iJn.iIb) {
      QrRewardMainUI.a(this.iJi, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.15
 * JD-Core Version:    0.7.0.1
 */