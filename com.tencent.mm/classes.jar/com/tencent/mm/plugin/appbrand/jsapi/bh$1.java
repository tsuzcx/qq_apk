package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.ui.MMActivity.a;

final class bh$1
  implements MMActivity.a
{
  bh$1(bh parambh, Context paramContext, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130524);
    if (paramInt1 != (this.hzm.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(130524);
      return;
    }
    if (paramInt2 == -1)
    {
      new Intent().putExtra("key_account_type", 1);
      d.H(this.hzj, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
      this.hxW.h(this.bAX, this.hzm.j("ok", null));
    }
    for (;;)
    {
      if (!g.dpN()) {
        g.dpP();
      }
      AppMethodBeat.o(130524);
      return;
      this.hxW.h(this.bAX, this.hzm.j("fail", null));
      if (!g.dpN()) {
        h.qsU.e(14954, new Object[] { g.dpO(), "JsApiOpenWCPayLQTDetail:fail" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bh.1
 * JD-Core Version:    0.7.0.1
 */