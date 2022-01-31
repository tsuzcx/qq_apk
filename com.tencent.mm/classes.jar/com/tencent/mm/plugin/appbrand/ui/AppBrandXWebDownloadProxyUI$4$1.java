package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandXWebDownloadProxyUI$4$1
  implements DialogInterface.OnCancelListener
{
  AppBrandXWebDownloadProxyUI$4$1(AppBrandXWebDownloadProxyUI.4 param4) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(133173);
    ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "cancel loading download background");
    paramDialogInterface = new Intent();
    this.iPY.iPX.setResult(2, paramDialogInterface);
    this.iPY.iPX.finish();
    AppMethodBeat.o(133173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.4.1
 * JD-Core Version:    0.7.0.1
 */