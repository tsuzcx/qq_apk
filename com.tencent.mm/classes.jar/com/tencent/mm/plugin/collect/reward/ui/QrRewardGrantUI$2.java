package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.u;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class QrRewardGrantUI$2
  extends u
{
  QrRewardGrantUI$2(QrRewardGrantUI paramQrRewardGrantUI) {}
  
  public final void aEI()
  {
    int i = (int)Math.round(bk.getDouble(QrRewardGrantUI.a(this.iIJ).getText(), 0.0D) * 100.0D);
    if (QrRewardGrantUI.a(this.iIJ, i)) {
      QrRewardGrantUI.b(this.iIJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.2
 * JD-Core Version:    0.7.0.1
 */