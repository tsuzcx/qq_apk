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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.af;
import com.tencent.xweb.v;
import com.tencent.xweb.xwalk.b;

@a(7)
public final class AppBrandXWebDownloadProxyUI
  extends MMActivity
{
  private static boolean lzZ;
  private Runnable lAd;
  private b lDW = null;
  private Handler mHandler;
  p tipDialog;
  
  static
  {
    AppMethodBeat.i(48908);
    d.ks(aj.getContext());
    lzZ = false;
    AppMethodBeat.o(48908);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(48904);
    this.mHandler = new Handler();
    this.lAd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48891);
        AppBrandXWebDownloadProxyUI.aPL();
        Intent localIntent = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48891);
      }
    };
    this.mHandler.postDelayed(this.lAd, 20000L);
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
    ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate");
    r.b(getWindow());
    ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
    d.aNr("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool = v.isBusy();
    ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
      if (lzZ)
      {
        setResult(0, new Intent());
        finish();
        AppMethodBeat.o(48903);
        return;
      }
      if (this.lDW == null) {
        this.lDW = new a((byte)0);
      }
      af.a(this.lDW);
      ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
      paramBundle = getContext();
      getContext().getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getContext().getString(2131755689), true, null);
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
          ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "xweb already downloading, user cancel");
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
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), null, true, null);
    this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48892);
        ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48892);
      }
    });
    if (this.lDW == null) {
      this.lDW = new a((byte)0);
    }
    af.a(this.lDW);
    v.fqO();
    AppMethodBeat.o(48903);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48905);
    ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
    this.lDW = null;
    af.a(this.lDW);
    if ((this.mHandler != null) && (this.lAd != null)) {
      this.mHandler.removeCallbacks(this.lAd);
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
    implements b
  {
    boolean lDZ = false;
    
    private a() {}
    
    public final boolean boI()
    {
      AppMethodBeat.i(48898);
      this.lDZ = true;
      aq.f(new Runnable()
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
    
    public final void boJ()
    {
      AppMethodBeat.i(48900);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      af.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48900);
    }
    
    public final void boK()
    {
      AppMethodBeat.i(48901);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      af.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48901);
    }
    
    public final void boL()
    {
      AppMethodBeat.i(48902);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      af.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(-1, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48902);
    }
    
    public final void ua(final int paramInt)
    {
      AppMethodBeat.i(48899);
      if (!this.lDZ)
      {
        AppMethodBeat.o(48899);
        return;
      }
      ad.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
      if (AppBrandXWebDownloadProxyUI.this.tipDialog != null) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48897);
            AppBrandXWebDownloadProxyUI.this.tipDialog.setMessage(AppBrandXWebDownloadProxyUI.this.getContext().getString(2131755690, new Object[] { String.valueOf(paramInt) }));
            AppMethodBeat.o(48897);
          }
        });
      }
      AppMethodBeat.o(48899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */