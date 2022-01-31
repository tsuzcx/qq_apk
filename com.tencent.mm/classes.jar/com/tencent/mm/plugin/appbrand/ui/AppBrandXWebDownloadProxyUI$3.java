package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandXWebDownloadProxyUI$3
  implements DialogInterface.OnCancelListener
{
  AppBrandXWebDownloadProxyUI$3(AppBrandXWebDownloadProxyUI paramAppBrandXWebDownloadProxyUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(133172);
    ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel download");
    paramDialogInterface = new Intent();
    this.iPX.setResult(2, paramDialogInterface);
    this.iPX.finish();
    AppMethodBeat.o(133172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.3
 * JD-Core Version:    0.7.0.1
 */