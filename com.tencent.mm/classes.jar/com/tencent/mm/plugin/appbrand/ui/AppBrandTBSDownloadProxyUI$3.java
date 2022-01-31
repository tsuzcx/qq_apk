package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.x5.sdk.f.a;

final class AppBrandTBSDownloadProxyUI$3
  implements f.a
{
  AppBrandTBSDownloadProxyUI$3(AppBrandTBSDownloadProxyUI paramAppBrandTBSDownloadProxyUI) {}
  
  public final void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt >= 36824))
    {
      y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      ai.d(new AppBrandTBSDownloadProxyUI.3.1(this));
      return;
    }
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    this.hed.setResult(0, localIntent);
    this.hed.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.3
 * JD-Core Version:    0.7.0.1
 */