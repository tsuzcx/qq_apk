package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class QrRewardMainUI$11
  implements View.OnClickListener
{
  QrRewardMainUI$11(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41094);
    ab.d("MicroMsg.QrRewardMainUI", "click avatar");
    this.kPN.hideVKB();
    QrRewardMainUI.d(this.kPN);
    AppMethodBeat.o(41094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.11
 * JD-Core Version:    0.7.0.1
 */