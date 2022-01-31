package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.sdk.platformtools.al;

final class AppBrandProfileUI$4
  implements Runnable
{
  AppBrandProfileUI$4(AppBrandProfileUI paramAppBrandProfileUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(133029);
    al.d(new AppBrandProfileUI.4.1(this, q.Ak(AppBrandProfileUI.d(this.iOj)), q.Ao(AppBrandProfileUI.d(this.iOj))));
    if (this.iOk) {
      s.Ay(AppBrandProfileUI.d(this.iOj));
    }
    AppMethodBeat.o(133029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.4
 * JD-Core Version:    0.7.0.1
 */