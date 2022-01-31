package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;

final class PaylistAAUI$11
  implements a.a
{
  PaylistAAUI$11(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aoW()
  {
    AppMethodBeat.i(40876);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene_balance_manager", 0);
    d.b(this.grF, "wallet", ".balance.ui.WalletBalanceManagerUI", localIntent);
    h.qsU.e(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
    AppMethodBeat.o(40876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.11
 * JD-Core Version:    0.7.0.1
 */