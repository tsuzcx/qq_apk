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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
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
  private static boolean mCd = false;
  private a mCe = null;
  private p mCf;
  private volatile boolean mCg;
  private Runnable mCh;
  private Handler mHandler;
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(188870);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onCreate");
    s.b(getWindow());
    ad.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "is foreground download");
    paramBundle = getContext();
    getContext().getString(2131755906);
    this.mCf = h.b(paramBundle, getContext().getString(2131755517), true, null);
    if (this.mCf.getWindow() != null)
    {
      paramBundle = this.mCf.getWindow().getAttributes();
      paramBundle.dimAmount = 0.0F;
      this.mCf.getWindow().setAttributes(paramBundle);
    }
    this.mCf.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(188865);
        ad.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandMiniQBDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandMiniQBDownloadProxyUI.this.finish();
        AppMethodBeat.o(188865);
      }
    });
    paramBundle = TBSOneManager.getDefaultInstance(getContext());
    if (!paramBundle.isComponentInstalled("file")) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "file component has already installed");
        setResult(0, new Intent());
        finish();
      }
      if (this.mCe == null) {
        this.mCe = new a((byte)0);
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_ignore_wifi_state", true);
      localBundle.putBoolean("is_ignore_frequency_limitation", true);
      localBundle.putBoolean("is_ignore_flow_control", true);
      paramBundle.installComponent("file", localBundle, this.mCe);
      this.mCg = true;
      this.mHandler = new Handler();
      this.mCh = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188864);
          AppBrandMiniQBDownloadProxyUI.aZZ();
          Intent localIntent = new Intent();
          AppBrandMiniQBDownloadProxyUI.this.setResult(0, localIntent);
          AppBrandMiniQBDownloadProxyUI.this.finish();
          AppMethodBeat.o(188864);
        }
      };
      this.mHandler.postDelayed(this.mCh, 20000L);
      AppMethodBeat.o(188870);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(188872);
    ad.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDestroy");
    this.mCe = null;
    if ((this.mHandler != null) && (this.mCh != null)) {
      this.mHandler.removeCallbacks(this.mCh);
    }
    if (this.mCf != null)
    {
      this.mCf.dismiss();
      this.mCf = null;
    }
    super.onDestroy();
    AppMethodBeat.o(188872);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(188871);
    super.onNewIntent(paramIntent);
    if ((mCd) || (this.mCg))
    {
      setResult(0, paramIntent);
      finish();
    }
    AppMethodBeat.o(188871);
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
      AppMethodBeat.i(188868);
      super.onError(paramInt, paramString);
      ad.e("MicroMsg.AppBrandMiniQBDownloadProxyUI", "download miniqb fail, reason: %s", new Object[] { paramString });
      AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, false);
      paramString = new Intent();
      AppBrandMiniQBDownloadProxyUI.this.setResult(0, paramString);
      AppBrandMiniQBDownloadProxyUI.this.finish();
      AppMethodBeat.o(188868);
    }
    
    public final void onProgressChanged(int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(188867);
      super.onProgressChanged(paramInt1, paramInt2);
      ad.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt2) });
      if (AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this) != null) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(188866);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this, true);
            AppBrandMiniQBDownloadProxyUI.a(AppBrandMiniQBDownloadProxyUI.this).setMessage(AppBrandMiniQBDownloadProxyUI.this.getContext().getString(2131755518, new Object[] { String.valueOf(paramInt2) }));
            AppMethodBeat.o(188866);
          }
        });
      }
      AppMethodBeat.o(188867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */