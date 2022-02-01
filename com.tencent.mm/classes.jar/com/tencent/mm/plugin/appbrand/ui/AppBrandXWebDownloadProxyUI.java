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
import com.tencent.mm.cq.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.ah;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.c;

@a(7)
public final class AppBrandXWebDownloadProxyUI
  extends MMActivity
{
  private static boolean mbV;
  private Handler mHandler;
  private Runnable mbZ;
  private c mfQ = null;
  p tipDialog;
  
  static
  {
    AppMethodBeat.i(48908);
    d.kE(ai.getContext());
    mbV = false;
    AppMethodBeat.o(48908);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(48904);
    this.mHandler = new Handler();
    this.mbZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48891);
        AppBrandXWebDownloadProxyUI.aWD();
        Intent localIntent = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48891);
      }
    };
    this.mHandler.postDelayed(this.mbZ, 20000L);
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
    ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate");
    r.b(getWindow());
    ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
    d.aSU("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool = w.isBusy();
    ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
      if (mbV)
      {
        setResult(0, new Intent());
        finish();
        AppMethodBeat.o(48903);
        return;
      }
      if (this.mfQ == null) {
        this.mfQ = new a((byte)0);
      }
      ah.a(this.mfQ);
      ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
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
          ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "xweb already downloading, user cancel");
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
        ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel download");
        paramAnonymousDialogInterface = new Intent();
        AppBrandXWebDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandXWebDownloadProxyUI.this.finish();
        AppMethodBeat.o(48892);
      }
    });
    if (this.mfQ == null) {
      this.mfQ = new a((byte)0);
    }
    ah.a(this.mfQ);
    w.fJo();
    AppMethodBeat.o(48903);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48905);
    ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
    this.mfQ = null;
    ah.a(this.mfQ);
    if ((this.mHandler != null) && (this.mbZ != null)) {
      this.mHandler.removeCallbacks(this.mbZ);
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
    boolean mfT = false;
    
    private a() {}
    
    public final boolean bvD()
    {
      AppMethodBeat.i(48898);
      this.mfT = true;
      ap.f(new Runnable()
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
    
    public final void bvE()
    {
      AppMethodBeat.i(48900);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48900);
    }
    
    public final void bvF()
    {
      AppMethodBeat.i(48901);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48901);
    }
    
    public final void bvG()
    {
      AppMethodBeat.i(48902);
      AppBrandXWebDownloadProxyUI.c(AppBrandXWebDownloadProxyUI.this);
      ah.a(AppBrandXWebDownloadProxyUI.d(AppBrandXWebDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandXWebDownloadProxyUI.this.setResult(-1, localIntent);
      AppBrandXWebDownloadProxyUI.this.finish();
      AppMethodBeat.o(48902);
    }
    
    public final void uS(final int paramInt)
    {
      AppMethodBeat.i(48899);
      if (!this.mfT)
      {
        AppMethodBeat.o(48899);
        return;
      }
      ac.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
      if (AppBrandXWebDownloadProxyUI.this.tipDialog != null) {
        ap.f(new Runnable()
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