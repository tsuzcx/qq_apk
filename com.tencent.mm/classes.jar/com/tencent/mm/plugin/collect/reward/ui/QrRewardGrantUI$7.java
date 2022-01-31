package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class QrRewardGrantUI$7
  implements a.a
{
  QrRewardGrantUI$7(QrRewardGrantUI paramQrRewardGrantUI, e parame) {}
  
  public final void i(m paramm)
  {
    QrRewardGrantUI.a(this.iIJ, this.iIK.iIe.bOT);
    QrRewardGrantUI.b(this.iIJ, this.iIK.iIe.sKX);
    QrRewardGrantUI.c(this.iIJ, this.iIK.iIe.swd);
    QrRewardGrantUI.d(this.iIJ, this.iIK.iIe.sKV);
    QrRewardGrantUI.e(this.iIJ, this.iIK.iIe.sKU);
    y.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { this.iIK.iIe.sLh });
    if (!bk.bl(this.iIK.iIe.sLh))
    {
      h.a(this.iIJ.mController.uMN, this.iIK.iIe.sLh, "", this.iIJ.getString(a.i.remittance_continue), this.iIJ.getString(a.i.app_cancel), new QrRewardGrantUI.7.1(this), new QrRewardGrantUI.7.2(this));
      return;
    }
    QrRewardGrantUI.d(this.iIJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.7
 * JD-Core Version:    0.7.0.1
 */