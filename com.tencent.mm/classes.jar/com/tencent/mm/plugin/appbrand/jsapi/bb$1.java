package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

final class bb$1
  implements MMActivity.a
{
  bb$1(bb parambb, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130516);
    if (paramInt1 != (this.hzd.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(130516);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("key_callback");
      ab.i("MicroMsg.JsApiOpenOfflinePayView", "callback: %s", new Object[] { paramIntent });
      this.hxW.h(this.bAX, this.hzd.j(paramIntent, null));
      h.qsU.e(14954, new Object[] { g.dpO(), "openOfflinePayView:ok" });
    }
    for (;;)
    {
      if (!g.dpN()) {
        g.dpP();
      }
      AppMethodBeat.o(130516);
      return;
      this.hxW.h(this.bAX, this.hzd.j("fail", null));
      if (!g.dpN()) {
        h.qsU.e(14954, new Object[] { g.dpO(), "openOfflinePayView:fail" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bb.1
 * JD-Core Version:    0.7.0.1
 */