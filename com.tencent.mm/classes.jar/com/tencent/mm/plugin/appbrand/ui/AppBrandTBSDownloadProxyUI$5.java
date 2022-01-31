package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.ui.base.p;

final class AppBrandTBSDownloadProxyUI$5
  implements DialogInterface.OnClickListener
{
  AppBrandTBSDownloadProxyUI$5(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(133104);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(366L, 2L, 1L, false);
    u.a.oZ(false);
    m.kS(2);
    if ((this.iOQ.isFinishing()) || (this.iOQ.activityHasDestroyed()))
    {
      AppMethodBeat.o(133104);
      return;
    }
    paramDialogInterface = this.iOQ;
    AppCompatActivity localAppCompatActivity = this.iOQ.getContext();
    this.iOQ.getContext().getString(2131297087);
    paramDialogInterface.tipDialog = com.tencent.mm.ui.base.h.b(localAppCompatActivity, this.iOQ.getContext().getString(2131296886), true, null);
    this.iOQ.tipDialog.setOnCancelListener(new AppBrandTBSDownloadProxyUI.5.1(this));
    AppBrandTBSDownloadProxyUI.b(this.iOQ);
    AppBrandTBSDownloadProxyUI.c(this.iOQ);
    AppMethodBeat.o(133104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.5
 * JD-Core Version:    0.7.0.1
 */