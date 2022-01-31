package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.mm.cl.b;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.xweb.t;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;

@a(7)
public final class AppBrandTBSDownloadProxyUI
  extends MMActivity
{
  private static boolean hec = false;
  private AppBrandTBSDownloadProxyUI.a hea = null;
  private Runnable heb;
  private Handler mHandler;
  p tipDialog;
  
  static
  {
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "TRACE_ORDER:AppBrandTBSDownloadProxyUI.java");
    t.a(ae.getContext(), new AppBrandTBSDownloadProxyUI.1(), null, null);
  }
  
  private void startTimer()
  {
    this.mHandler = new Handler();
    this.heb = new AppBrandTBSDownloadProxyUI.4(this);
    this.mHandler.postDelayed(this.heb, 20000L);
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
    this.tipDialog = h.b(this.mController.uMN, null, true, null);
    this.tipDialog.setOnCancelListener(new AppBrandTBSDownloadProxyUI.5(this));
    l.a(getWindow());
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
    b.afs("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool1 = f.isDownloading();
    boolean bool2 = d.getTBSInstalling();
    boolean bool3 = f.isDownloadForeground();
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      if (bool3)
      {
        y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
        if (hec)
        {
          setResult(0, new Intent());
          finish();
          return;
        }
        if (this.hea == null) {
          this.hea = new AppBrandTBSDownloadProxyUI.a(this, (byte)0);
        }
        d.a(this.hea);
        y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
        paramBundle = this.mController.uMN;
        this.mController.uMN.getString(y.j.app_tip);
        this.tipDialog = h.b(paramBundle, this.mController.uMN.getString(y.j.app_brand_x5_installing_simple_tips), true, null);
        if (this.tipDialog.getWindow() != null)
        {
          paramBundle = this.tipDialog.getWindow().getAttributes();
          paramBundle.dimAmount = 0.0F;
          this.tipDialog.getWindow().setAttributes(paramBundle);
        }
        this.tipDialog.setOnCancelListener(new AppBrandTBSDownloadProxyUI.2(this));
        startTimer();
        return;
      }
      y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
      f.stopDownload();
    }
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
    paramBundle = new AppBrandTBSDownloadProxyUI.3(this);
    f.a(this.mController.uMN, false, true, paramBundle);
  }
  
  protected final void onDestroy()
  {
    y.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
    if ((this.mHandler != null) && (this.heb != null)) {
      this.mHandler.removeCallbacks(this.heb);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */