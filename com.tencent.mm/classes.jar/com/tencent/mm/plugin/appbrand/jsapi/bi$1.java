package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

final class bi$1
  implements MMActivity.a
{
  bi$1(bi parambi, Context paramContext, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130526);
    ab.d("MicroMsg.JsApiOpenWCPayLQTSave", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == (this.hzn.hashCode() & 0xFFFF))
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        d.b(this.hzj, "wallet", ".balance.ui.lqt.WalletLqtBeforeSaveUI", paramIntent, this.hzn.hashCode() & 0xFFFE);
        this.hxW.h(this.bAX, this.hzn.j("ok", null));
      }
      while (!g.dpN())
      {
        g.dpP();
        AppMethodBeat.o(130526);
        return;
        this.hxW.h(this.bAX, this.hzn.j("fail", null));
        if (!g.dpN()) {
          h.qsU.e(14954, new Object[] { g.dpO(), "JsApiOpenWCPayLQTSave:fail" });
        }
      }
    }
    if (paramInt1 != (this.hzn.hashCode() & 0xFFFE))
    {
      ab.d("MicroMsg.JsApiOpenWCPayLQTSave", "beforeSave callback");
      if (paramInt2 == -1)
      {
        this.hxW.h(this.bAX, this.hzn.j("ok", null));
        AppMethodBeat.o(130526);
        return;
      }
      this.hxW.h(this.bAX, this.hzn.j("fail", null));
    }
    AppMethodBeat.o(130526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bi.1
 * JD-Core Version:    0.7.0.1
 */