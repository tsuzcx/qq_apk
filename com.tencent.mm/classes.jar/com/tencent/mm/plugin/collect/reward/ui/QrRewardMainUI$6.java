package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.reward.b.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class QrRewardMainUI$6
  implements a.a
{
  QrRewardMainUI$6(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void Z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41089);
    ab.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      al.d(new QrRewardMainUI.6.1(this));
    }
    AppMethodBeat.o(41089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.6
 * JD-Core Version:    0.7.0.1
 */