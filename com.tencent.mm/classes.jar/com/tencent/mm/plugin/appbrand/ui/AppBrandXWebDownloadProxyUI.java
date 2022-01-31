package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.xwalk.b;

@a(7)
public final class AppBrandXWebDownloadProxyUI
  extends MMActivity
{
  private static boolean iOP;
  private Runnable iOO;
  private b iPW = null;
  private Handler mHandler;
  p tipDialog;
  
  static
  {
    AppMethodBeat.i(133188);
    d.iO(ah.getContext());
    iOP = false;
    AppMethodBeat.o(133188);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(133184);
    this.mHandler = new Handler();
    this.iOO = new AppBrandXWebDownloadProxyUI.2(this);
    this.mHandler.postDelayed(this.iOO, 20000L);
    AppMethodBeat.o(133184);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(133183);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate");
    o.a(getWindow());
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
    d.awm("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool = com.tencent.xweb.o.isBusy();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
      if (iOP)
      {
        setResult(0, new Intent());
        finish();
        AppMethodBeat.o(133183);
        return;
      }
      if (this.iPW == null) {
        this.iPW = new AppBrandXWebDownloadProxyUI.a(this, (byte)0);
      }
      com.tencent.xweb.ab.a(this.iPW);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
      paramBundle = getContext();
      getContext().getString(2131297087);
      this.tipDialog = h.b(paramBundle, getContext().getString(2131296886), true, null);
      if (this.tipDialog.getWindow() != null)
      {
        paramBundle = this.tipDialog.getWindow().getAttributes();
        paramBundle.dimAmount = 0.0F;
        this.tipDialog.getWindow().setAttributes(paramBundle);
      }
      this.tipDialog.setOnCancelListener(new AppBrandXWebDownloadProxyUI.1(this));
      startTimer();
      AppMethodBeat.o(133183);
      return;
    }
    this.tipDialog = h.b(getContext(), null, true, null);
    this.tipDialog.setOnCancelListener(new AppBrandXWebDownloadProxyUI.3(this));
    if (this.iPW == null) {
      this.iPW = new AppBrandXWebDownloadProxyUI.a(this, (byte)0);
    }
    com.tencent.xweb.ab.a(this.iPW);
    com.tencent.xweb.o.dYl();
    AppMethodBeat.o(133183);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(133185);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
    this.iPW = null;
    com.tencent.xweb.ab.a(this.iPW);
    if ((this.mHandler != null) && (this.iOO != null)) {
      this.mHandler.removeCallbacks(this.iOO);
    }
    super.onDestroy();
    AppMethodBeat.o(133185);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */