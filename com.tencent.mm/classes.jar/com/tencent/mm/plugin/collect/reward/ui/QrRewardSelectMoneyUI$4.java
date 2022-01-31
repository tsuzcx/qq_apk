package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardSelectMoneyUI$4
  implements a.a
{
  QrRewardSelectMoneyUI$4(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, f paramf) {}
  
  public final void i(m paramm)
  {
    y.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
    if (!bk.bl(this.iJA.iIf.iHr)) {
      Toast.makeText(this.iJz, this.iJA.iIf.iHr, 1).show();
    }
    this.iJz.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.4
 * JD-Core Version:    0.7.0.1
 */