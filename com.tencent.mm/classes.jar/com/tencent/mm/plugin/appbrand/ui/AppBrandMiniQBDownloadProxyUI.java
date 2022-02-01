package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import java.io.File;

@a(7)
public final class AppBrandMiniQBDownloadProxyUI
  extends MMActivity
{
  private static boolean mbV = false;
  private Handler mHandler;
  private a mbW = null;
  private p mbX;
  private volatile boolean mbY;
  private Runnable mbZ;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187028);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onCreate");
    r.b(getWindow());
    ac.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "is foreground download");
    paramBundle = getContext();
    getContext().getString(2131755906);
    this.mbX = h.b(paramBundle, getContext().getString(2131755517), true, null);
    if (this.mbX.getWindow() != null)
    {
      paramBundle = this.mbX.getWindow().getAttributes();
      paramBundle.dimAmount = 0.0F;
      this.mbX.getWindow().setAttributes(paramBundle);
    }
    this.mbX.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(187023);
        ac.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandMiniQBDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandMiniQBDownloadProxyUI.this.finish();
        AppMethodBeat.o(187023);
      }
    });
    paramBundle = TBSOneManager.getDefaultInstance(getContext());
    if (!paramBundle.isComponentInstalled("file")) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ac.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "file component has already installed");
        setResult(0, new Intent());
        finish();
      }
      if (this.mbW == null) {
        this.mbW = new a((byte)0);
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_ignore_wifi_state", true);
      localBundle.putBoolean("is_ignore_frequency_limitation", true);
      localBundle.putBoolean("is_ignore_flow_control", true);
      paramBundle.installComponent("file", localBundle, this.mbW);
      this.mbY = true;
      this.mHandler = new Handler();
      this.mbZ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187022);
          AppBrandMiniQBDownloadProxyUI.aWD();
          Intent localIntent = new Intent();
          AppBrandMiniQBDownloadProxyUI.this.setResult(0, localIntent);
          AppBrandMiniQBDownloadProxyUI.this.finish();
          AppMethodBeat.o(187022);
        }
      };
      this.mHandler.postDelayed(this.mbZ, 20000L);
      AppMethodBeat.o(187028);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(187030);
    ac.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDestroy");
    this.mbW = null;
    if ((this.mHandler != null) && (this.mbZ != null)) {
      this.mHandler.removeCallbacks(this.mbZ);
    }
    if (this.mbX != null)
    {
      this.mbX.dismiss();
      this.mbX = null;
    }
    super.onDestroy();
    AppMethodBeat.o(187030);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(187029);
    super.onNewIntent(paramIntent);
    if ((mbV) || (this.mbY))
    {
      setResult(0, paramIntent);
      finish();
    }
    AppMethodBeat.o(187029);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends TBSOneCallback<File>
  {
    private a() {}
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(187026);
      super.onError(paramInt, paramString);
      ac.e("MicroMsg.AppBrandMiniQBDownloadProxyUI", "download miniqb fail, reason: %s", new Object[] { paramString });
      AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, false);
      paramString = new Intent();
      AppBrandMiniQBDownloadProxyUI.this.setResult(0, paramString);
      AppBrandMiniQBDownloadProxyUI.this.finish();
      AppMethodBeat.o(187026);
    }
    
    public final void onProgressChanged(int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(187025);
      super.onProgressChanged(paramInt1, paramInt2);
      ac.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt2) });
      if (AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this) != null) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187024);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, true);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this).setMessage(AppBrandMiniQBDownloadProxyUI.this.getContext().getString(2131755518, new Object[] { String.valueOf(paramInt2) }));
            AppMethodBeat.o(187024);
          }
        });
      }
      AppMethodBeat.o(187025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */