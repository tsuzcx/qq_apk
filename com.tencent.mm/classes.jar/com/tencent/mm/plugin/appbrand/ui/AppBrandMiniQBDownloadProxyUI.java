package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import java.io.File;

@a(7)
public final class AppBrandMiniQBDownloadProxyUI
  extends MMActivity
{
  private static boolean ubm = false;
  private Handler mHandler;
  private a ubn = null;
  private w ubo;
  private volatile boolean ubp;
  private Runnable ubq;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(322475);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onCreate");
    ae.g(getWindow());
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "is foreground download");
    paramBundle = getContext();
    getContext().getString(ba.i.app_tip);
    this.ubo = k.a(paramBundle, getContext().getString(ba.i.app_brand_miniqb_installing_simple_tips), true, null);
    if (this.ubo.getWindow() != null)
    {
      paramBundle = this.ubo.getWindow().getAttributes();
      paramBundle.dimAmount = 0.0F;
      this.ubo.getWindow().setAttributes(paramBundle);
    }
    this.ubo.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(321926);
        Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandMiniQBDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandMiniQBDownloadProxyUI.this.finish();
        AppMethodBeat.o(321926);
      }
    });
    paramBundle = TBSOneManager.getDefaultInstance(getContext());
    if (!paramBundle.isComponentInstalled("file")) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "file component has already installed");
        setResult(0, new Intent());
        finish();
      }
      if (this.ubn == null) {
        this.ubn = new a((byte)0);
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_ignore_wifi_state", true);
      localBundle.putBoolean("is_ignore_frequency_limitation", true);
      localBundle.putBoolean("is_ignore_flow_control", true);
      paramBundle.installComponent("file", localBundle, this.ubn);
      this.ubp = true;
      this.mHandler = new Handler();
      this.ubq = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(321924);
          AppBrandMiniQBDownloadProxyUI.bDd();
          Intent localIntent = new Intent();
          AppBrandMiniQBDownloadProxyUI.this.setResult(0, localIntent);
          AppBrandMiniQBDownloadProxyUI.this.finish();
          AppMethodBeat.o(321924);
        }
      };
      this.mHandler.postDelayed(this.ubq, 20000L);
      AppMethodBeat.o(322475);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(322486);
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDestroy");
    this.ubn = null;
    if ((this.mHandler != null) && (this.ubq != null)) {
      this.mHandler.removeCallbacks(this.ubq);
    }
    if (this.ubo != null)
    {
      this.ubo.dismiss();
      this.ubo = null;
    }
    super.onDestroy();
    AppMethodBeat.o(322486);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(322481);
    super.onNewIntent(paramIntent);
    if ((ubm) || (this.ubp))
    {
      setResult(0, paramIntent);
      finish();
    }
    AppMethodBeat.o(322481);
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
      AppMethodBeat.i(322483);
      super.onError(paramInt, paramString);
      Log.e("MicroMsg.AppBrandMiniQBDownloadProxyUI", "download miniqb fail, reason: %s", new Object[] { paramString });
      AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, false);
      paramString = new Intent();
      AppBrandMiniQBDownloadProxyUI.this.setResult(0, paramString);
      AppBrandMiniQBDownloadProxyUI.this.finish();
      AppMethodBeat.o(322483);
    }
    
    public final void onProgressChanged(int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(322478);
      super.onProgressChanged(paramInt1, paramInt2);
      Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt2) });
      if (AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this) != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(322027);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, true);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this).setMessage(AppBrandMiniQBDownloadProxyUI.this.getContext().getString(ba.i.app_brand_miniqb_installing_tips, new Object[] { String.valueOf(paramInt2) }));
            AppMethodBeat.o(322027);
          }
        });
      }
      AppMethodBeat.o(322478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */