package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardSetMoneyUI$3
  implements a.a
{
  QrRewardSetMoneyUI$3(QrRewardSetMoneyUI paramQrRewardSetMoneyUI, g paramg) {}
  
  public final void i(m paramm)
  {
    y.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(this.iJP.iIg.iHq), this.iJP.iIg.iHr });
    if (!bk.bl(this.iJP.iIg.iHr))
    {
      Toast.makeText(this.iJO, this.iJP.iIg.iHr, 1).show();
      return;
    }
    Toast.makeText(this.iJO, a.i.qr_reward_set_code_failure_text, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.3
 * JD-Core Version:    0.7.0.1
 */