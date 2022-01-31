package com.tencent.mm.plugin.appbrand.launching;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class AppBrandLaunchProxyUI$2
  implements DialogInterface.OnDismissListener
{
  AppBrandLaunchProxyUI$2(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.gJc.isFinishing()) {
      this.gJc.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI.2
 * JD-Core Version:    0.7.0.1
 */