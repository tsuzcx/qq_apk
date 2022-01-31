package com.tencent.mm.plugin.collect.reward.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class QrRewardMainUI$5
  implements n.d
{
  QrRewardMainUI$5(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      y.i("MicroMsg.QrRewardMainUI", "unknown menu: %s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
      QrRewardMainUI.c(this.iJi, true);
      return;
    case 1: 
      QrRewardMainUI.a(this.iJi, "");
      QrRewardMainUI.n(this.iJi);
      QrRewardMainUI.c(this.iJi, true);
      h.nFQ.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
      return;
    }
    QrRewardMainUI.c(this.iJi, false);
    QrRewardMainUI.o(this.iJi);
    h.nFQ.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.5
 * JD-Core Version:    0.7.0.1
 */