package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class AppBrandProcessShareMessageProxyUI$c$1
  implements Runnable
{
  AppBrandProcessShareMessageProxyUI$c$1(AppBrandProcessShareMessageProxyUI.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(133017);
    if (this.iNp.tipDialog != null) {
      this.iNp.tipDialog.dismiss();
    }
    this.iNp.aMj();
    AppMethodBeat.o(133017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.c.1
 * JD-Core Version:    0.7.0.1
 */