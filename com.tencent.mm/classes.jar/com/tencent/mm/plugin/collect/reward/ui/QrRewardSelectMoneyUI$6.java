package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class QrRewardSelectMoneyUI$6
  implements ao.b.a
{
  QrRewardSelectMoneyUI$6(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, long paramLong) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41137);
    if (paramBoolean)
    {
      ab.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (bo.aoy() - this.kQi) + " ms");
      b.U(paramString, 3);
      o.adi().qU(paramString);
    }
    for (;;)
    {
      a.b.a(QrRewardSelectMoneyUI.c(this.kQf), paramString, 0.03F, false);
      QrRewardSelectMoneyUI.d(this.kQf).setText(j.b(this.kQf.getContext(), e.nE(paramString)));
      AppMethodBeat.o(41137);
      return;
      ab.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.6
 * JD-Core Version:    0.7.0.1
 */