package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.ui.MMActivity.a;

final class bf$1
  implements MMActivity.a
{
  bf$1(bf parambf, Context paramContext, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130520);
    if (paramInt1 != (this.hzk.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(130520);
      return;
    }
    if (paramInt2 == -1)
    {
      new Intent().putExtra("key_mode", 1);
      d.H(this.hzj, "wallet", ".balance.ui.lqt.WalletLqtPlanHomeUI");
      this.hxW.h(this.bAX, this.hzk.j("ok", null));
    }
    for (;;)
    {
      if (!g.dpN()) {
        g.dpP();
      }
      AppMethodBeat.o(130520);
      return;
      this.hxW.h(this.bAX, this.hzk.j("fail", null));
      if (!g.dpN()) {
        h.qsU.e(14954, new Object[] { g.dpO(), "openWCPayLQTDepositPlan:fail" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bf.1
 * JD-Core Version:    0.7.0.1
 */