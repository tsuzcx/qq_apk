package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

final class AppBrandTBSDownloadProxyUI$a$1
  implements Runnable
{
  AppBrandTBSDownloadProxyUI$a$1(AppBrandTBSDownloadProxyUI.a parama, int paramInt) {}
  
  public final void run()
  {
    this.heg.hed.tipDialog.setMessage(this.heg.hed.mController.uMN.getString(y.j.app_brand_x5_installing_tips, new Object[] { String.valueOf(this.dMX) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.a.1
 * JD-Core Version:    0.7.0.1
 */