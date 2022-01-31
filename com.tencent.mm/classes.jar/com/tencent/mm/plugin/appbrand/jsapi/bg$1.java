package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.ui.MMActivity.a;

final class bg$1
  implements MMActivity.a
{
  bg$1(bg parambg, Context paramContext, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130522);
    if (paramInt1 != (this.hzl.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(130522);
      return;
    }
    if (paramInt2 == -1)
    {
      paramIntent = new Intent();
      paramIntent.putExtra("key_mode", 1);
      d.b(this.hzj, "wallet", ".balance.ui.lqt.WalletLqtPlanAddUI", paramIntent);
      this.hxW.h(this.bAX, this.hzl.j("ok", null));
    }
    for (;;)
    {
      if (!g.dpN()) {
        g.dpP();
      }
      AppMethodBeat.o(130522);
      return;
      this.hxW.h(this.bAX, this.hzl.j("fail", null));
      if (!g.dpN()) {
        h.qsU.e(14954, new Object[] { g.dpO(), "openWCPayLQTDepositPlanAdd:fail" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bg.1
 * JD-Core Version:    0.7.0.1
 */