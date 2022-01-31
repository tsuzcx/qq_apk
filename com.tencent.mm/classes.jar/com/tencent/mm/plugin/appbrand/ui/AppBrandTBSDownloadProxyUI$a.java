package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.p;

final class AppBrandTBSDownloadProxyUI$a
  implements com.tencent.xweb.x5.sdk.h
{
  private AppBrandTBSDownloadProxyUI$a(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onDownloadFinish(int paramInt)
  {
    AppMethodBeat.i(133107);
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
    m.gK(5, paramInt);
    if ((paramInt == 100) || (paramInt == 120) || (paramInt == 122))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(366L, 4L, 1L, false);
      if (paramInt == 110) {
        break label225;
      }
      if ((paramInt != 100) && (paramInt != 120) && (paramInt != 122)) {
        break label166;
      }
      com.tencent.mm.plugin.report.service.h.qsU.a(64, 64, 4, 3, 1, 1, false);
    }
    for (;;)
    {
      localObject = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (localObject != null)
      {
        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
        ((SharedPreferences.Editor)localObject).apply();
      }
      AppMethodBeat.o(133107);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(366L, 5L, 1L, false);
      break;
      label166:
      AppBrandTBSDownloadProxyUI.d(this.iOQ);
      com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.e(this.iOQ));
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(64L, 3L, 1L, false);
      localObject = new Intent();
      this.iOQ.setResult(0, (Intent)localObject);
      this.iOQ.finish();
    }
    label225:
    Object localObject = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localObject != null)
    {
      ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
      ((SharedPreferences.Editor)localObject).apply();
    }
    AppBrandTBSDownloadProxyUI.d(this.iOQ);
    com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.e(this.iOQ));
    localObject = new Intent();
    this.iOQ.setResult(0, (Intent)localObject);
    this.iOQ.finish();
    AppMethodBeat.o(133107);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(133109);
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.iOQ.tipDialog != null) {
      al.d(new AppBrandTBSDownloadProxyUI.a.1(this, paramInt));
    }
    AppMethodBeat.o(133109);
  }
  
  public final void onInstallFinish(int paramInt)
  {
    AppMethodBeat.i(133108);
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.iOQ.tipDialog != null)
    {
      this.iOQ.tipDialog.dismiss();
      this.iOQ.tipDialog = null;
    }
    m.gK(6, paramInt);
    if ((paramInt == 200) || (paramInt == 220))
    {
      com.tencent.mm.plugin.report.service.h.qsU.a(64, 64, 7, 6, 1, 1, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(366L, 6L, 1L, false);
      ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
      com.tencent.mm.cn.d.aNX();
      AppBrandTBSDownloadProxyUI.d(this.iOQ);
      com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.e(this.iOQ));
      localIntent = new Intent();
      this.iOQ.setResult(-1, localIntent);
      this.iOQ.finish();
      AppMethodBeat.o(133108);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(64L, 6L, 1L, false);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(366L, 7L, 1L, false);
    AppBrandTBSDownloadProxyUI.d(this.iOQ);
    com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.e(this.iOQ));
    Intent localIntent = new Intent();
    this.iOQ.setResult(0, localIntent);
    this.iOQ.finish();
    AppMethodBeat.o(133108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.a
 * JD-Core Version:    0.7.0.1
 */