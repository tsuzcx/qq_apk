package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class QrRewardSelectMoneyUI$6
  implements au.b.a
{
  QrRewardSelectMoneyUI$6(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, long paramLong) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63996);
    if (paramBoolean)
    {
      ae.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (bu.fpO() - this.pjT) + " ms");
      c.al(paramString, 3);
      p.aEP().Dw(paramString);
    }
    for (;;)
    {
      a.b.a(QrRewardSelectMoneyUI.c(this.pjQ), paramString, 0.03F, false);
      QrRewardSelectMoneyUI.k(this.pjQ, paramString);
      AppMethodBeat.o(63996);
      return;
      ae.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.6
 * JD-Core Version:    0.7.0.1
 */