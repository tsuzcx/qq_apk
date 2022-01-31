package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.cl.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.x5.sdk.d;

final class AppBrandTBSDownloadProxyUI$a
  implements com.tencent.xweb.x5.sdk.h
{
  private AppBrandTBSDownloadProxyUI$a(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onDownloadFinish(int paramInt)
  {
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
    k.eZ(5, paramInt);
    if ((paramInt == 100) || (paramInt == 120) || (paramInt == 122))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(366L, 4L, 1L, false);
      if (paramInt == 110) {
        break label215;
      }
      if ((paramInt != 100) && (paramInt != 120) && (paramInt != 122)) {
        break label156;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(64, 64, 4, 3, 1, 1, false);
    }
    for (;;)
    {
      localObject = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (localObject != null)
      {
        y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
        ((SharedPreferences.Editor)localObject).apply();
      }
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.a(366L, 5L, 1L, false);
      break;
      label156:
      AppBrandTBSDownloadProxyUI.d(this.hed);
      d.a(AppBrandTBSDownloadProxyUI.e(this.hed));
      com.tencent.mm.plugin.report.service.h.nFQ.a(64L, 3L, 1L, false);
      localObject = new Intent();
      this.hed.setResult(0, (Intent)localObject);
      this.hed.finish();
    }
    label215:
    Object localObject = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localObject != null)
    {
      y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
      ((SharedPreferences.Editor)localObject).apply();
    }
    AppBrandTBSDownloadProxyUI.d(this.hed);
    d.a(AppBrandTBSDownloadProxyUI.e(this.hed));
    localObject = new Intent();
    this.hed.setResult(0, (Intent)localObject);
    this.hed.finish();
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.hed.tipDialog != null) {
      ai.d(new AppBrandTBSDownloadProxyUI.a.1(this, paramInt));
    }
  }
  
  public final void onInstallFinish(int paramInt)
  {
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.hed.tipDialog != null)
    {
      this.hed.tipDialog.dismiss();
      this.hed.tipDialog = null;
    }
    k.eZ(6, paramInt);
    if ((paramInt == 200) || (paramInt == 220))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(64, 64, 7, 6, 1, 1, false);
      com.tencent.mm.plugin.report.service.h.nFQ.a(366L, 6L, 1L, false);
      y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
      b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      AppBrandTBSDownloadProxyUI.d(this.hed);
      d.a(AppBrandTBSDownloadProxyUI.e(this.hed));
      localIntent = new Intent();
      this.hed.setResult(-1, localIntent);
      this.hed.finish();
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(64L, 6L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(366L, 7L, 1L, false);
    AppBrandTBSDownloadProxyUI.d(this.hed);
    d.a(AppBrandTBSDownloadProxyUI.e(this.hed));
    Intent localIntent = new Intent();
    this.hed.setResult(0, localIntent);
    this.hed.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.a
 * JD-Core Version:    0.7.0.1
 */