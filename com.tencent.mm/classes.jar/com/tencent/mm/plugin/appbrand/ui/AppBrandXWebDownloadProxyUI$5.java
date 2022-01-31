package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandXWebDownloadProxyUI$5
  implements DialogInterface.OnClickListener
{
  AppBrandXWebDownloadProxyUI$5(AppBrandXWebDownloadProxyUI paramAppBrandXWebDownloadProxyUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(133175);
    h.qsU.idkeyStat(366L, 3L, 1L, false);
    ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel");
    paramDialogInterface = new Intent();
    this.iPX.setResult(2, paramDialogInterface);
    this.iPX.finish();
    AppMethodBeat.o(133175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.5
 * JD-Core Version:    0.7.0.1
 */