package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;

final class ap$1
  implements MMActivity.a
{
  ap$1(ap paramap, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != (this.ggI.hashCode() & 0xFFFF)) {}
    for (;;)
    {
      return;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("key_callback");
        y.i("MicroMsg.JsApiOpenOfflinePayView", "callback: %s", new Object[] { paramIntent });
        this.ggH.C(this.dIS, this.ggI.h(paramIntent, null));
        h.nFQ.f(14954, new Object[] { f.cox(), "openOfflinePayView:ok" });
      }
      while (!f.cow())
      {
        f.coy();
        return;
        this.ggH.C(this.dIS, this.ggI.h("fail", null));
        if (!f.cow()) {
          h.nFQ.f(14954, new Object[] { f.cox(), "openOfflinePayView:fail" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ap.1
 * JD-Core Version:    0.7.0.1
 */