package com.tencent.mm.plugin.appbrand.ui;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.platformtools.al;

final class AppBrandProfileUI$4$1
  implements Runnable
{
  AppBrandProfileUI$4$1(AppBrandProfileUI.4 param4, v paramv, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(133028);
    AppBrandProfileUI.a(this.iOn.iOj, this.iOl);
    if ((this.iOn.iOk) && (!this.iOn.iOj.isFinishing()) && (!this.iOn.iOj.activityHasDestroyed())) {
      q.ayA().add(this.iOn.iOj, e.aNS().oNc.getLooper());
    }
    AppMethodBeat.o(133028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.4.1
 * JD-Core Version:    0.7.0.1
 */