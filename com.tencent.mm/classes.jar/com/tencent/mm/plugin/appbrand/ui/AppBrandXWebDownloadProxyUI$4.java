package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.o;

final class AppBrandXWebDownloadProxyUI$4
  implements DialogInterface.OnClickListener
{
  AppBrandXWebDownloadProxyUI$4(AppBrandXWebDownloadProxyUI paramAppBrandXWebDownloadProxyUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(133174);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(366L, 2L, 1L, false);
    if ((this.iPX.isFinishing()) || (this.iPX.activityHasDestroyed()))
    {
      AppMethodBeat.o(133174);
      return;
    }
    paramDialogInterface = this.iPX;
    AppCompatActivity localAppCompatActivity = this.iPX.getContext();
    this.iPX.getContext().getString(2131297087);
    paramDialogInterface.tipDialog = com.tencent.mm.ui.base.h.b(localAppCompatActivity, this.iPX.getContext().getString(2131296886), true, null);
    this.iPX.tipDialog.setOnCancelListener(new AppBrandXWebDownloadProxyUI.4.1(this));
    o.dYm();
    AppBrandXWebDownloadProxyUI.a(this.iPX);
    AppMethodBeat.o(133174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.4
 * JD-Core Version:    0.7.0.1
 */