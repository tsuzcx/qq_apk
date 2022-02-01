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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import java.io.File;

@a(7)
public final class AppBrandMiniQBDownloadProxyUI
  extends MMActivity
{
  private static boolean nUg = false;
  private Handler mHandler;
  private a nUh = null;
  private q nUi;
  private volatile boolean nUj;
  private Runnable nUk;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227617);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onCreate");
    y.e(getWindow());
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "is foreground download");
    paramBundle = getContext();
    getContext().getString(2131755998);
    this.nUi = h.a(paramBundle, getContext().getString(2131755555), true, null);
    if (this.nUi.getWindow() != null)
    {
      paramBundle = this.nUi.getWindow().getAttributes();
      paramBundle.dimAmount = 0.0F;
      this.nUi.getWindow().setAttributes(paramBundle);
    }
    this.nUi.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(227612);
        Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandMiniQBDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandMiniQBDownloadProxyUI.this.finish();
        AppMethodBeat.o(227612);
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
      if (this.nUh == null) {
        this.nUh = new a((byte)0);
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_ignore_wifi_state", true);
      localBundle.putBoolean("is_ignore_frequency_limitation", true);
      localBundle.putBoolean("is_ignore_flow_control", true);
      paramBundle.installComponent("file", localBundle, this.nUh);
      this.nUj = true;
      this.mHandler = new Handler();
      this.nUk = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227611);
          AppBrandMiniQBDownloadProxyUI.bvM();
          Intent localIntent = new Intent();
          AppBrandMiniQBDownloadProxyUI.this.setResult(0, localIntent);
          AppBrandMiniQBDownloadProxyUI.this.finish();
          AppMethodBeat.o(227611);
        }
      };
      this.mHandler.postDelayed(this.nUk, 20000L);
      AppMethodBeat.o(227617);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(227619);
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDestroy");
    this.nUh = null;
    if ((this.mHandler != null) && (this.nUk != null)) {
      this.mHandler.removeCallbacks(this.nUk);
    }
    if (this.nUi != null)
    {
      this.nUi.dismiss();
      this.nUi = null;
    }
    super.onDestroy();
    AppMethodBeat.o(227619);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(227618);
    super.onNewIntent(paramIntent);
    if ((nUg) || (this.nUj))
    {
      setResult(0, paramIntent);
      finish();
    }
    AppMethodBeat.o(227618);
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
      AppMethodBeat.i(227615);
      super.onError(paramInt, paramString);
      Log.e("MicroMsg.AppBrandMiniQBDownloadProxyUI", "download miniqb fail, reason: %s", new Object[] { paramString });
      AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, false);
      paramString = new Intent();
      AppBrandMiniQBDownloadProxyUI.this.setResult(0, paramString);
      AppBrandMiniQBDownloadProxyUI.this.finish();
      AppMethodBeat.o(227615);
    }
    
    public final void onProgressChanged(int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(227614);
      super.onProgressChanged(paramInt1, paramInt2);
      Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt2) });
      if (AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this) != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(227613);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, true);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this).setMessage(AppBrandMiniQBDownloadProxyUI.this.getContext().getString(2131755556, new Object[] { String.valueOf(paramInt2) }));
            AppMethodBeat.o(227613);
          }
        });
      }
      AppMethodBeat.o(227614);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */