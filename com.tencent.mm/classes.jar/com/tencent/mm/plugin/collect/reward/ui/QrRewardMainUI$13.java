package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.sdk.platformtools.ab;

final class QrRewardMainUI$13
  implements o.a
{
  QrRewardMainUI$13(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(41096);
    ab.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[] { Boolean.valueOf(QrRewardMainUI.f(this.kPN)) });
    QrRewardMainUI.b(this.kPN, false);
    AppMethodBeat.o(41096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.13
 * JD-Core Version:    0.7.0.1
 */