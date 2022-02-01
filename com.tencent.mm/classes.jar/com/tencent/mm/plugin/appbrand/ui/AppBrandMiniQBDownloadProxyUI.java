package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import java.io.File;

@a(7)
public final class AppBrandMiniQBDownloadProxyUI
  extends MMActivity
{
  private static boolean qVE = false;
  private Handler mHandler;
  private a qVF = null;
  private s qVG;
  private volatile boolean qVH;
  private Runnable qVI;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(274251);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onCreate");
    x.e(getWindow());
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "is foreground download");
    paramBundle = getContext();
    getContext().getString(au.i.app_tip);
    this.qVG = h.a(paramBundle, getContext().getString(au.i.app_brand_miniqb_installing_simple_tips), true, null);
    if (this.qVG.getWindow() != null)
    {
      paramBundle = this.qVG.getWindow().getAttributes();
      paramBundle.dimAmount = 0.0F;
      this.qVG.getWindow().setAttributes(paramBundle);
    }
    this.qVG.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(274101);
        Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandMiniQBDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandMiniQBDownloadProxyUI.this.finish();
        AppMethodBeat.o(274101);
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
      if (this.qVF == null) {
        this.qVF = new a((byte)0);
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_ignore_wifi_state", true);
      localBundle.putBoolean("is_ignore_frequency_limitation", true);
      localBundle.putBoolean("is_ignore_flow_control", true);
      paramBundle.installComponent("file", localBundle, this.qVF);
      this.qVH = true;
      this.mHandler = new Handler();
      this.qVI = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(275390);
          AppBrandMiniQBDownloadProxyUI.bfm();
          Intent localIntent = new Intent();
          AppBrandMiniQBDownloadProxyUI.this.setResult(0, localIntent);
          AppBrandMiniQBDownloadProxyUI.this.finish();
          AppMethodBeat.o(275390);
        }
      };
      this.mHandler.postDelayed(this.qVI, 20000L);
      AppMethodBeat.o(274251);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(274253);
    Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDestroy");
    this.qVF = null;
    if ((this.mHandler != null) && (this.qVI != null)) {
      this.mHandler.removeCallbacks(this.qVI);
    }
    if (this.qVG != null)
    {
      this.qVG.dismiss();
      this.qVG = null;
    }
    super.onDestroy();
    AppMethodBeat.o(274253);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(274252);
    super.onNewIntent(paramIntent);
    if ((qVE) || (this.qVH))
    {
      setResult(0, paramIntent);
      finish();
    }
    AppMethodBeat.o(274252);
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
      AppMethodBeat.i(253982);
      super.onError(paramInt, paramString);
      Log.e("MicroMsg.AppBrandMiniQBDownloadProxyUI", "download miniqb fail, reason: %s", new Object[] { paramString });
      AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, false);
      paramString = new Intent();
      AppBrandMiniQBDownloadProxyUI.this.setResult(0, paramString);
      AppBrandMiniQBDownloadProxyUI.this.finish();
      AppMethodBeat.o(253982);
    }
    
    public final void onProgressChanged(int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(253981);
      super.onProgressChanged(paramInt1, paramInt2);
      Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt2) });
      if (AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this) != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277616);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, true);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this).setMessage(AppBrandMiniQBDownloadProxyUI.this.getContext().getString(au.i.app_brand_miniqb_installing_tips, new Object[] { String.valueOf(paramInt2) }));
            AppMethodBeat.o(277616);
          }
        });
      }
      AppMethodBeat.o(253981);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */