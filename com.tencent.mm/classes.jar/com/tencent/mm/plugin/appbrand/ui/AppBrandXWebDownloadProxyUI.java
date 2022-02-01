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
import com.tencent.mm.cp.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.ah;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.c;

@a(7)
public final class AppBrandXWebDownloadProxyUI
  extends MMActivity
{
  private static boolean mHi;
  private Handler mHandler;
  private Runnable mHm;
  private c mLv = null;
  p tipDialog;
  
  static
  {
    AppMethodBeat.i(48908);
    d.kX(ak.getContext());
    mHi = false;
    AppMethodBeat.o(48908);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(48904);
    this.mHandler = new Handler();
    this.mHm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48891);
        AppBrandXWebDownloadProxyUI.bay();
        Intent localIntent = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48891);
      }
    };
    this.mHandler.postDelayed(this.mHm, 20000L);
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
    ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate");
    t.b(getWindow());
    ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
    d.bax("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool = w.isBusy();
    ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
      if (mHi)
      {
        setResult(0, new Intent());
        finish();
        AppMethodBeat.o(48903);
        return;
      }
      if (this.mLv == null) {
        this.mLv = new a((byte)0);
      }
      ah.a(this.mLv);
      ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
      paramBundle = getContext();
      getContext().getString(2131755906);
      this.tipDialog = h.b(paramBundle, getContext().getString(2131755689), true, null);
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
          ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "xweb already downloading, user cancel");
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
    this.tipDialog = h.b(getContext(), null, true, null);
    this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48892);
        ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48892);
      }
    });
    if (this.mLv == null) {
      this.mLv = new a((byte)0);
    }
    ah.a(this.mLv);
    w.gfk();
    AppMethodBeat.o(48903);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48905);
    ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
    this.mLv = null;
    ah.a(this.mLv);
    if ((this.mHandler != null) && (this.mHm != null)) {
      this.mHandler.removeCallbacks(this.mHm);
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
    boolean mLy = false;
    
    private a() {}
    
    public final boolean bAE()
    {
      AppMethodBeat.i(48898);
      this.mLy = true;
      ar.f(new Runnable()
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
    
    public final void bAF()
    {
      AppMethodBeat.i(48900);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48900);
    }
    
    public final void bAG()
    {
      AppMethodBeat.i(48901);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48901);
    }
    
    public final void bAH()
    {
      AppMethodBeat.i(48902);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(-1, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48902);
    }
    
    public final void vC(final int paramInt)
    {
      AppMethodBeat.i(48899);
      if (!this.mLy)
      {
        AppMethodBeat.o(48899);
        return;
      }
      ae.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
      if (AppBrandXWebDownloadProxyUI.this.tipDialog != null) {
        ar.f(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */