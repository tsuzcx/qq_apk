package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.x5.sdk.f;

@a(7)
public final class AppBrandTBSDownloadProxyUI
  extends MMActivity
{
  private static boolean iOP;
  private AppBrandTBSDownloadProxyUI.a iON = null;
  private Runnable iOO;
  private Handler mHandler;
  p tipDialog;
  
  static
  {
    AppMethodBeat.i(133116);
    com.tencent.mm.cn.d.iO(ah.getContext());
    iOP = false;
    AppMethodBeat.o(133116);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(133111);
    this.mHandler = new Handler();
    this.iOO = new AppBrandTBSDownloadProxyUI.3(this);
    this.mHandler.postDelayed(this.iOO, 20000L);
    AppMethodBeat.o(133111);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(133110);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
    this.tipDialog = h.b(getContext(), null, true, null);
    this.tipDialog.setOnCancelListener(new AppBrandTBSDownloadProxyUI.4(this));
    o.a(getWindow());
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
    com.tencent.mm.cn.d.awm("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    boolean bool3 = f.isDownloadForeground();
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      if (bool3)
      {
        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
        if (iOP)
        {
          setResult(0, new Intent());
          finish();
          AppMethodBeat.o(133110);
          return;
        }
        if (this.iON == null) {
          this.iON = new AppBrandTBSDownloadProxyUI.a(this, (byte)0);
        }
        com.tencent.xweb.x5.sdk.d.a(this.iON);
        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
        paramBundle = getContext();
        getContext().getString(2131297087);
        this.tipDialog = h.b(paramBundle, getContext().getString(2131296886), true, null);
        if (this.tipDialog.getWindow() != null)
        {
          paramBundle = this.tipDialog.getWindow().getAttributes();
          paramBundle.dimAmount = 0.0F;
          this.tipDialog.getWindow().setAttributes(paramBundle);
        }
        this.tipDialog.setOnCancelListener(new AppBrandTBSDownloadProxyUI.1(this));
        startTimer();
        AppMethodBeat.o(133110);
        return;
      }
      ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
      f.stopDownload();
    }
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
    paramBundle = new AppBrandTBSDownloadProxyUI.2(this);
    f.a(getContext(), false, true, paramBundle);
    AppMethodBeat.o(133110);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(133112);
    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
    if ((this.mHandler != null) && (this.iOO != null)) {
      this.mHandler.removeCallbacks(this.iOO);
    }
    super.onDestroy();
    AppMethodBeat.o(133112);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */