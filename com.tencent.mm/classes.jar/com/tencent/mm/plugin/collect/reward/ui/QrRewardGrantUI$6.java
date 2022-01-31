package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardGrantUI$6
  implements a.a
{
  QrRewardGrantUI$6(QrRewardGrantUI paramQrRewardGrantUI, e parame) {}
  
  public final void i(m paramm)
  {
    y.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(this.iIK.iIe.iHq), this.iIK.iIe.iHr });
    if (!bk.bl(this.iIK.iIe.iHr)) {
      Toast.makeText(this.iIJ, this.iIK.iIe.iHr, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.6
 * JD-Core Version:    0.7.0.1
 */