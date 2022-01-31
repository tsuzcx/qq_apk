package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class QrRewardGrantUI$2
  extends t
{
  QrRewardGrantUI$2(QrRewardGrantUI paramQrRewardGrantUI) {}
  
  public final void bhX()
  {
    AppMethodBeat.i(41064);
    int i = (int)Math.round(bo.getDouble(QrRewardGrantUI.a(this.kPo).getText(), 0.0D) * 100.0D);
    if (QrRewardGrantUI.a(this.kPo, i)) {
      QrRewardGrantUI.b(this.kPo);
    }
    AppMethodBeat.o(41064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.2
 * JD-Core Version:    0.7.0.1
 */