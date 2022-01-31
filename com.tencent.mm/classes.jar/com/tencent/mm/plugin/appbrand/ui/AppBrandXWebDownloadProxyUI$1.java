package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandXWebDownloadProxyUI$1
  implements DialogInterface.OnCancelListener
{
  AppBrandXWebDownloadProxyUI$1(AppBrandXWebDownloadProxyUI paramAppBrandXWebDownloadProxyUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(133170);
    ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "xweb already downloading, user cancel");
    paramDialogInterface = new Intent();
    this.iPX.setResult(2, paramDialogInterface);
    this.iPX.finish();
    AppMethodBeat.o(133170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.1
 * JD-Core Version:    0.7.0.1
 */