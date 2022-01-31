package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class QrRewardSelectMoneyUI$3
  implements a.a
{
  QrRewardSelectMoneyUI$3(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, f paramf) {}
  
  public final void i(m paramm)
  {
    y.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[] { this.iJA });
    h.a(this.iJz.mController.uMN, this.iJz.getString(a.i.wallet_unknown_err), null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        QrRewardSelectMoneyUI.3.this.iJz.finish();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.3
 * JD-Core Version:    0.7.0.1
 */