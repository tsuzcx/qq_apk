package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandTBSDownloadProxyUI$4
  implements DialogInterface.OnCancelListener
{
  AppBrandTBSDownloadProxyUI$4(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(133102);
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
    paramDialogInterface = new Intent();
    this.iOQ.setResult(2, paramDialogInterface);
    this.iOQ.finish();
    AppMethodBeat.o(133102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.4
 * JD-Core Version:    0.7.0.1
 */