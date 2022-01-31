package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.y.j;

final class b$3$1$2
  implements com.tencent.mm.model.gdpr.b
{
  b$3$1$2(b.3.1 param1, Runnable paramRunnable) {}
  
  public final void hX(int paramInt)
  {
    if (paramInt == 0)
    {
      this.gMx.run();
      return;
    }
    a.a(this.gMw.gMv.gMr.getBaseContext(), this.gMw.gMv.gMr.getBaseContext().getString(y.j.appbrand_gdpr_deny_alert_message), this.gMw.gMv.gMr.getBaseContext().getString(y.j.appbrand_gdpr_deny_alert_title), this.gMw.gMv.gMr.getBaseContext().getString(y.j.app_ok), null, null, null, null);
    this.gMw.gMv.gMr.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.b.3.1.2
 * JD-Core Version:    0.7.0.1
 */