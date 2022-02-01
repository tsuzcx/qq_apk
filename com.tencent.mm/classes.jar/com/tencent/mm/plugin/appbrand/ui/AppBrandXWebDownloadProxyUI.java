package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.q;
import com.tencent.xweb.ah;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.c;

@a(7)
public final class AppBrandXWebDownloadProxyUI
  extends MMActivity
{
  private static boolean nUg;
  private Handler mHandler;
  private Runnable nUk;
  private c nYD = null;
  q tipDialog;
  
  static
  {
    AppMethodBeat.i(48908);
    d.kT(MMApplicationContext.getContext());
    nUg = false;
    AppMethodBeat.o(48908);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(48904);
    this.mHandler = new Handler();
    this.nUk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48891);
        AppBrandXWebDownloadProxyUI.bvM();
        Intent localIntent = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48891);
      }
    };
    this.mHandler.postDelayed(this.nUk, 20000L);
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
    y.e(getWindow());
    Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
    d.bpG("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool = w.isBusy();
    Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
      if (nUg)
      {
        setResult(0, new Intent());
        finish();
        AppMethodBeat.o(48903);
        return;
      }
      if (this.nYD == null) {
        this.nYD = new a((byte)0);
      }
      ah.a(this.nYD);
      Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
      paramBundle = getContext();
      getContext().getString(2131755998);
      this.tipDialog = com.tencent.mm.ui.base.h.a(paramBundle, getContext().getString(2131755759), true, null);
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
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), null, true, null);
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
    if (this.nYD == null) {
      this.nYD = new a((byte)0);
    }
    ah.a(this.nYD);
    w.hsB();
    AppMethodBeat.o(48903);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48905);
    Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
    this.nYD = null;
    ah.a(this.nYD);
    if ((this.mHandler != null) && (this.nUk != null)) {
      this.mHandler.removeCallbacks(this.nUk);
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
    implements c
  {
    boolean nYG = false;
    
    private a() {}
    
    public final boolean bXJ()
    {
      AppMethodBeat.i(48898);
      this.nYG = true;
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
    
    public final void bXK()
    {
      AppMethodBeat.i(48900);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48900);
    }
    
    public final void bXL()
    {
      AppMethodBeat.i(48901);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48901);
    }
    
    public final void bXM()
    {
      AppMethodBeat.i(48902);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(-1, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48902);
    }
    
    public final void zq(final int paramInt)
    {
      AppMethodBeat.i(48899);
      if (!this.nYG)
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
            AppBrandXWebDownloadProxyUI.this.tipDialog.setMessage(AppBrandXWebDownloadProxyUI.this.getContext().getString(2131755760, new Object[] { String.valueOf(paramInt) }));
            AppMethodBeat.o(48897);
          }
        });
      }
      AppMethodBeat.o(48899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */