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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
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
  private static boolean mHi = false;
  private Handler mHandler;
  private a mHj = null;
  private p mHk;
  private volatile boolean mHl;
  private Runnable mHm;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(223102);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onCreate");
    t.b(getWindow());
    ae.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "is foreground download");
    paramBundle = getContext();
    getContext().getString(2131755906);
    this.mHk = h.b(paramBundle, getContext().getString(2131755517), true, null);
    if (this.mHk.getWindow() != null)
    {
      paramBundle = this.mHk.getWindow().getAttributes();
      paramBundle.dimAmount = 0.0F;
      this.mHk.getWindow().setAttributes(paramBundle);
    }
    this.mHk.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(223097);
        ae.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandMiniQBDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandMiniQBDownloadProxyUI.this.finish();
        AppMethodBeat.o(223097);
      }
    });
    paramBundle = TBSOneManager.getDefaultInstance(getContext());
    if (!paramBundle.isComponentInstalled("file")) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ae.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "file component has already installed");
        setResult(0, new Intent());
        finish();
      }
      if (this.mHj == null) {
        this.mHj = new a((byte)0);
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_ignore_wifi_state", true);
      localBundle.putBoolean("is_ignore_frequency_limitation", true);
      localBundle.putBoolean("is_ignore_flow_control", true);
      paramBundle.installComponent("file", localBundle, this.mHj);
      this.mHl = true;
      this.mHandler = new Handler();
      this.mHm = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(223096);
          AppBrandMiniQBDownloadProxyUI.bay();
          Intent localIntent = new Intent();
          AppBrandMiniQBDownloadProxyUI.this.setResult(0, localIntent);
          AppBrandMiniQBDownloadProxyUI.this.finish();
          AppMethodBeat.o(223096);
        }
      };
      this.mHandler.postDelayed(this.mHm, 20000L);
      AppMethodBeat.o(223102);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(223104);
    ae.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDestroy");
    this.mHj = null;
    if ((this.mHandler != null) && (this.mHm != null)) {
      this.mHandler.removeCallbacks(this.mHm);
    }
    if (this.mHk != null)
    {
      this.mHk.dismiss();
      this.mHk = null;
    }
    super.onDestroy();
    AppMethodBeat.o(223104);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(223103);
    super.onNewIntent(paramIntent);
    if ((mHi) || (this.mHl))
    {
      setResult(0, paramIntent);
      finish();
    }
    AppMethodBeat.o(223103);
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
      AppMethodBeat.i(223100);
      super.onError(paramInt, paramString);
      ae.e("MicroMsg.AppBrandMiniQBDownloadProxyUI", "download miniqb fail, reason: %s", new Object[] { paramString });
      AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, false);
      paramString = new Intent();
      AppBrandMiniQBDownloadProxyUI.this.setResult(0, paramString);
      AppBrandMiniQBDownloadProxyUI.this.finish();
      AppMethodBeat.o(223100);
    }
    
    public final void onProgressChanged(int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(223099);
      super.onProgressChanged(paramInt1, paramInt2);
      ae.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt2) });
      if (AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this) != null) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(223098);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, true);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this).setMessage(AppBrandMiniQBDownloadProxyUI.this.getContext().getString(2131755518, new Object[] { String.valueOf(paramInt2) }));
            AppMethodBeat.o(223098);
          }
        });
      }
      AppMethodBeat.o(223099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */