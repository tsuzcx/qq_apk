package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.xweb.ao;

@a(7)
public final class AppBrandXWebDownloadProxyUI
  extends MMActivity
{
  private static boolean ubm;
  private Handler mHandler;
  w tipDialog;
  private Runnable ubq;
  private com.tencent.xweb.xwalk.c ugh = null;
  
  static
  {
    AppMethodBeat.i(48908);
    com.tencent.mm.xwebutil.c.nU(MMApplicationContext.getContext());
    ubm = false;
    AppMethodBeat.o(48908);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(48904);
    this.mHandler = new Handler();
    this.ubq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48891);
        AppBrandXWebDownloadProxyUI.bDd();
        Intent localIntent = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48891);
      }
    };
    this.mHandler.postDelayed(this.ubq, 20000L);
    AppMethodBeat.o(48904);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48903);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate");
    ae.g(getWindow());
    Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
    com.tencent.mm.xwebutil.c.bFh("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool = ao.isBusy();
    Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
      if (ubm)
      {
        setResult(0, new Intent());
        finish();
        AppMethodBeat.o(48903);
        return;
      }
      if (this.ugh == null) {
        this.ugh = new a((byte)0);
      }
      ao.a(this.ugh);
      Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
      paramBundle = getContext();
      getContext().getString(ba.i.app_tip);
      this.tipDialog = k.a(paramBundle, getContext().getString(ba.i.app_brand_x5_installing_simple_tips), true, null);
      if (this.tipDialog.getWindow() != null)
      {
        paramBundle = this.tipDialog.getWindow().getAttributes();
        paramBundle.dimAmount = 0.0F;
        this.tipDialog.getWindow().setAttributes(paramBundle);
      }
      this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(48890);
          Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "xweb already downloading, user cancel");
          paramAnonymousDialogInterface = new Intent();
          AppBrandXWebDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
          AppBrandXWebDownloadProxyUI.this.finish();
          AppMethodBeat.o(48890);
        }
      });
      startTimer();
      AppMethodBeat.o(48903);
      return;
    }
    this.tipDialog = k.a(getContext(), null, true, null);
    this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48892);
        Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48892);
      }
    });
    if (this.ugh == null) {
      this.ugh = new a((byte)0);
    }
    ao.a(this.ugh);
    ao.kfy();
    AppMethodBeat.o(48903);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48905);
    Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
    this.ugh = null;
    ao.a(this.ugh);
    if ((this.mHandler != null) && (this.ubq != null)) {
      this.mHandler.removeCallbacks(this.ubq);
    }
    super.onDestroy();
    AppMethodBeat.o(48905);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.xweb.xwalk.c
  {
    boolean ugk = false;
    
    private a() {}
    
    public final void Dn(final int paramInt)
    {
      AppMethodBeat.i(48899);
      if (!this.ugk)
      {
        AppMethodBeat.o(48899);
        return;
      }
      Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
      if (AppBrandXWebDownloadProxyUI.this.tipDialog != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48897);
            AppBrandXWebDownloadProxyUI.this.tipDialog.setMessage(AppBrandXWebDownloadProxyUI.this.getContext().getString(ba.i.app_brand_x5_installing_tips, new Object[] { String.valueOf(paramInt) }));
            AppMethodBeat.o(48897);
          }
        });
      }
      AppMethodBeat.o(48899);
    }
    
    public final boolean cLH()
    {
      AppMethodBeat.i(48898);
      this.ugk = true;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48896);
          AppBrandXWebDownloadProxyUI.b(AppBrandXWebDownloadProxyUI.this);
          AppMethodBeat.o(48896);
        }
      });
      AppMethodBeat.o(48898);
      return true;
    }
    
    public final void cLI()
    {
      AppMethodBeat.i(48900);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ao.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48900);
    }
    
    public final void cLJ()
    {
      AppMethodBeat.i(48901);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ao.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48901);
    }
    
    public final void cLK()
    {
      AppMethodBeat.i(48902);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ao.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(-1, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48902);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */