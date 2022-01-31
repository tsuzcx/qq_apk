package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandXWebDownloadProxyUI$2
  implements Runnable
{
  AppBrandXWebDownloadProxyUI$2(AppBrandXWebDownloadProxyUI paramAppBrandXWebDownloadProxyUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(133171);
    AppBrandXWebDownloadProxyUI.aMv();
    Intent localIntent = new Intent();
    this.iPX.setResult(0, localIntent);
    this.iPX.finish();
    AppMethodBeat.o(133171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.2
 * JD-Core Version:    0.7.0.1
 */