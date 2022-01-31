package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.TextView;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class QrRewardSelectMoneyUI$6
  implements am.b.a
{
  QrRewardSelectMoneyUI$6(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, long paramLong) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (bk.UY() - this.iJC) + " ms");
      b.M(paramString, 3);
      o.Kj().kb(paramString);
    }
    for (;;)
    {
      a.b.a(QrRewardSelectMoneyUI.c(this.iJz), paramString, 0.03F, false);
      QrRewardSelectMoneyUI.d(this.iJz).setText(j.b(this.iJz.mController.uMN, e.gV(paramString)));
      return;
      y.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.6
 * JD-Core Version:    0.7.0.1
 */