package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.g;

final class PaylistAAUI$11
  implements a.a
{
  PaylistAAUI$11(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aRM()
  {
    AppMethodBeat.i(63721);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene_balance_manager", 0);
    d.b(this.jaM, "wallet", ".balance.ui.WalletBalanceManagerUI", localIntent);
    g.yxI.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
    AppMethodBeat.o(63721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.11
 * JD-Core Version:    0.7.0.1
 */