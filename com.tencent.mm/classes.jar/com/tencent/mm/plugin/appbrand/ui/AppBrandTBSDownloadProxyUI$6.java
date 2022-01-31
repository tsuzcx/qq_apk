package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

final class AppBrandTBSDownloadProxyUI$6
  implements DialogInterface.OnClickListener
{
  AppBrandTBSDownloadProxyUI$6(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.a(366L, 2L, 1L, false);
    v.a.lN(false);
    k.jdMethod_if(2);
    if ((this.hed.isFinishing()) || (this.hed.uMr)) {
      return;
    }
    paramDialogInterface = this.hed;
    AppCompatActivity localAppCompatActivity = this.hed.mController.uMN;
    this.hed.mController.uMN.getString(y.j.app_tip);
    paramDialogInterface.tipDialog = com.tencent.mm.ui.base.h.b(localAppCompatActivity, this.hed.mController.uMN.getString(y.j.app_brand_x5_installing_simple_tips), true, null);
    this.hed.tipDialog.setOnCancelListener(new AppBrandTBSDownloadProxyUI.6.1(this));
    AppBrandTBSDownloadProxyUI.b(this.hed);
    AppBrandTBSDownloadProxyUI.c(this.hed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.6
 * JD-Core Version:    0.7.0.1
 */