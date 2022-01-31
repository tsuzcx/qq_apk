package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandTBSDownloadProxyUI$2
  implements DialogInterface.OnCancelListener
{
  AppBrandTBSDownloadProxyUI$2(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
    paramDialogInterface = new Intent();
    this.hed.setResult(2, paramDialogInterface);
    this.hed.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.2
 * JD-Core Version:    0.7.0.1
 */