package com.tencent.mm.plugin.collect.reward.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QrRewardBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  QrRewardBaseUI$1(QrRewardBaseUI paramQrRewardBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(41062);
    this.kOS.hideVKB();
    this.kOS.hideTenpayKB();
    this.kOS.finish();
    AppMethodBeat.o(41062);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI.1
 * JD-Core Version:    0.7.0.1
 */