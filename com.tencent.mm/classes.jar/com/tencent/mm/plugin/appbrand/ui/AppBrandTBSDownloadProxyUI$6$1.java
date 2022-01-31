package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandTBSDownloadProxyUI$6$1
  implements DialogInterface.OnCancelListener
{
  AppBrandTBSDownloadProxyUI$6$1(AppBrandTBSDownloadProxyUI.6 param6) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancel loading download background");
    paramDialogInterface = new Intent();
    this.hef.hed.setResult(2, paramDialogInterface);
    this.hef.hed.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.6.1
 * JD-Core Version:    0.7.0.1
 */