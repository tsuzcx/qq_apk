package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.sdk.platformtools.Log;

final class QrRewardMainUI$13
  implements q.a
{
  QrRewardMainUI$13(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void dF(View paramView)
  {
    AppMethodBeat.i(63955);
    Log.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[] { Boolean.valueOf(QrRewardMainUI.f(this.qyI)) });
    QrRewardMainUI.b(this.qyI, false);
    AppMethodBeat.o(63955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.13
 * JD-Core Version:    0.7.0.1
 */