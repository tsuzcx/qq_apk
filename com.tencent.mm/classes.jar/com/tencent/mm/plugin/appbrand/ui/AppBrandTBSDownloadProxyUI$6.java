package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandTBSDownloadProxyUI$6
  implements DialogInterface.OnClickListener
{
  AppBrandTBSDownloadProxyUI$6(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(133105);
    h.qsU.idkeyStat(366L, 3L, 1L, false);
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
    u.a.oZ(false);
    paramDialogInterface = new Intent();
    this.iOQ.setResult(2, paramDialogInterface);
    this.iOQ.finish();
    AppMethodBeat.o(133105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.6
 * JD-Core Version:    0.7.0.1
 */