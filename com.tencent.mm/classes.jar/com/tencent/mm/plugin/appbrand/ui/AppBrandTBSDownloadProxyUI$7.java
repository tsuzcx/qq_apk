package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandTBSDownloadProxyUI$7
  implements DialogInterface.OnClickListener
{
  AppBrandTBSDownloadProxyUI$7(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.a(366L, 3L, 1L, false);
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
    v.a.lN(false);
    paramDialogInterface = new Intent();
    this.hed.setResult(2, paramDialogInterface);
    this.hed.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.7
 * JD-Core Version:    0.7.0.1
 */