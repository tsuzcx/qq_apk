package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.sdk.platformtools.ae;

final class QrRewardSetMoneyUI$2
  implements a.a
{
  QrRewardSetMoneyUI$2(QrRewardSetMoneyUI paramQrRewardSetMoneyUI) {}
  
  public final void g(n paramn)
  {
    AppMethodBeat.i(64011);
    ae.e("MicroMsg.QrRewardSetMoneyUI", "net error: %s", new Object[] { paramn });
    AppMethodBeat.o(64011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.2
 * JD-Core Version:    0.7.0.1
 */