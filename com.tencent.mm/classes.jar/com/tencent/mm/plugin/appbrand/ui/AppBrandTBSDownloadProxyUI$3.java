package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandTBSDownloadProxyUI$3
  implements Runnable
{
  AppBrandTBSDownloadProxyUI$3(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(133101);
    AppBrandTBSDownloadProxyUI.aMp();
    Intent localIntent = new Intent();
    this.iOQ.setResult(0, localIntent);
    this.iOQ.finish();
    AppMethodBeat.o(133101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.3
 * JD-Core Version:    0.7.0.1
 */