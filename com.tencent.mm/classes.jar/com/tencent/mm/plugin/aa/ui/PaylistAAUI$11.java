package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;

final class PaylistAAUI$11
  implements a.a
{
  PaylistAAUI$11(PaylistAAUI paramPaylistAAUI) {}
  
  public final void Vx()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene_balance_manager", 0);
    d.b(this.eZM, "wallet", ".balance.ui.WalletBalanceManagerUI", localIntent);
    h.nFQ.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.11
 * JD-Core Version:    0.7.0.1
 */