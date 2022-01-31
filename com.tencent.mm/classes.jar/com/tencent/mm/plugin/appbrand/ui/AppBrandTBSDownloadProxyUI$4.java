package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;

final class AppBrandTBSDownloadProxyUI$4
  implements Runnable
{
  AppBrandTBSDownloadProxyUI$4(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void run()
  {
    AppBrandTBSDownloadProxyUI.ape();
    Intent localIntent = new Intent();
    this.hed.setResult(0, localIntent);
    this.hed.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.4
 * JD-Core Version:    0.7.0.1
 */