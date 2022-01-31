package com.tencent.mm.plugin.collect.reward.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class QrRewardMainUI$5
  implements n.d
{
  QrRewardMainUI$5(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(41087);
    switch (paramMenuItem.getItemId())
    {
    default: 
      ab.i("MicroMsg.QrRewardMainUI", "unknown menu: %s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
      QrRewardMainUI.a(this.kPN, true);
      AppMethodBeat.o(41087);
      return;
    case 1: 
      QrRewardMainUI.a(this.kPN, "");
      QrRewardMainUI.b(this.kPN);
      QrRewardMainUI.a(this.kPN, true);
      h.qsU.e(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
      AppMethodBeat.o(41087);
      return;
    }
    QrRewardMainUI.a(this.kPN, false);
    QrRewardMainUI.p(this.kPN);
    h.qsU.e(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
    AppMethodBeat.o(41087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.5
 * JD-Core Version:    0.7.0.1
 */