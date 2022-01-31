package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class QrRewardMainUI$14
  implements a.a
{
  QrRewardMainUI$14(QrRewardMainUI paramQrRewardMainUI, b paramb) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41097);
    ab.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramm });
    if (!this.kPS.kOG) {
      QrRewardMainUI.b(this.kPN, false);
    }
    AppMethodBeat.o(41097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.14
 * JD-Core Version:    0.7.0.1
 */