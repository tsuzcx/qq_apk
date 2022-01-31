package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class QrRewardGrantUI$5
  implements a.a
{
  QrRewardGrantUI$5(QrRewardGrantUI paramQrRewardGrantUI) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41066);
    ab.e("MicroMsg.QrRewardGrantUI", "net error: %s", new Object[] { paramm });
    if (QrRewardGrantUI.d(this.kPo)) {
      this.kPo.hideLoading();
    }
    AppMethodBeat.o(41066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.5
 * JD-Core Version:    0.7.0.1
 */