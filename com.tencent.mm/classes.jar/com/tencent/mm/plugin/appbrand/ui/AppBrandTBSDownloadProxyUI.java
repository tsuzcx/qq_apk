package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.f.a;

@a(7)
public final class AppBrandTBSDownloadProxyUI
  extends MMActivity
{
  private static boolean mHi;
  private Handler mHandler;
  private Runnable mHm;
  private a mJK = null;
  com.tencent.mm.ui.base.p tipDialog;
  
  static
  {
    AppMethodBeat.i(48807);
    com.tencent.mm.cp.d.kX(ak.getContext());
    mHi = false;
    AppMethodBeat.o(48807);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(48802);
    this.mHandler = new Handler();
    this.mHm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48792);
        AppBrandTBSDownloadProxyUI.bAv();
        Intent localIntent = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(0, localIntent);
        AppBrandTBSDownloadProxyUI.this.finish();
        AppMethodBeat.o(48792);
      }
    };
    this.mHandler.postDelayed(this.mHm, 20000L);
    AppMethodBeat.o(48802);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48801);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), null, true, null);
    this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48793);
        ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
        paramAnonymousDialogInterface = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandTBSDownloadProxyUI.this.finish();
        AppMethodBeat.o(48793);
      }
    });
    t.b(getWindow());
    ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
    com.tencent.mm.cp.d.bax("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    boolean bool3 = f.isDownloadForeground();
    ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      if (bool3)
      {
        ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
        if (mHi)
        {
          setResult(0, new Intent());
          finish();
          AppMethodBeat.o(48801);
          return;
        }
        if (this.mJK == null) {
          this.mJK = new a((byte)0);
        }
        com.tencent.xweb.x5.sdk.d.a(this.mJK);
        ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
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
            AppMethodBeat.i(48789);
            ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
            paramAnonymousDialogInterface = new Intent();
            AppBrandTBSDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.o(48789);
          }
        });
        startTimer();
        AppMethodBeat.o(48801);
        return;
      }
      ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
      f.stopDownload();
    }
    ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
    paramBundle = new f.a()
    {
      public final void onNeedDownloadFinish(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(48791);
        if ((paramAnonymousBoolean) && (paramAnonymousInt >= 36824))
        {
          ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48790);
              ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
              AppBrandTBSDownloadProxyUI.a(AppBrandTBSDownloadProxyUI.this);
              AppMethodBeat.o(48790);
            }
          });
          AppMethodBeat.o(48791);
          return;
        }
        ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        Intent localIntent = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(0, localIntent);
        AppBrandTBSDownloadProxyUI.this.finish();
        AppMethodBeat.o(48791);
      }
    };
    f.a(getContext(), false, true, paramBundle);
    AppMethodBeat.o(48801);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48803);
    ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
    if ((this.mHandler != null) && (this.mHm != null)) {
      this.mHandler.removeCallbacks(this.mHm);
    }
    super.onDestroy();
    AppMethodBeat.o(48803);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.xweb.x5.sdk.h
  {
    private a() {}
    
    public final void onDownloadFinish(int paramInt)
    {
      AppMethodBeat.i(48798);
      ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.pluginsdk.ui.tools.p.gi(5, paramInt);
      if ((paramInt == 100) || (paramInt == 120) || (paramInt == 122))
      {
        g.yxI.idkeyStat(366L, 4L, 1L, false);
        if (paramInt == 110) {
          break label225;
        }
        if ((paramInt != 100) && (paramInt != 120) && (paramInt != 122)) {
          break label166;
        }
        g.yxI.a(64, 64, 4, 3, 1, 1, false);
      }
      for (;;)
      {
        localObject = ak.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (localObject != null)
        {
          ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
          ((SharedPreferences.Editor)localObject).apply();
        }
        AppMethodBeat.o(48798);
        return;
        g.yxI.idkeyStat(366L, 5L, 1L, false);
        break;
        label166:
        AppBrandTBSDownloadProxyUI.d(AppBrandTBSDownloadProxyUI.this);
        com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.e(AppBrandTBSDownloadProxyUI.this));
        g.yxI.idkeyStat(64L, 3L, 1L, false);
        localObject = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(0, (Intent)localObject);
        AppBrandTBSDownloadProxyUI.this.finish();
      }
      label225:
      Object localObject = ak.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (localObject != null)
      {
        ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
        ((SharedPreferences.Editor)localObject).apply();
      }
      AppBrandTBSDownloadProxyUI.d(AppBrandTBSDownloadProxyUI.this);
      com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.e(AppBrandTBSDownloadProxyUI.this));
      localObject = new Intent();
      AppBrandTBSDownloadProxyUI.this.setResult(0, (Intent)localObject);
      AppBrandTBSDownloadProxyUI.this.finish();
      AppMethodBeat.o(48798);
    }
    
    public final void onDownloadProgress(final int paramInt)
    {
      AppMethodBeat.i(48800);
      ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
      if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48797);
            AppBrandTBSDownloadProxyUI.this.tipDialog.setMessage(AppBrandTBSDownloadProxyUI.this.getContext().getString(2131755690, new Object[] { String.valueOf(paramInt) }));
            AppMethodBeat.o(48797);
          }
        });
      }
      AppMethodBeat.o(48800);
    }
    
    public final void onInstallFinish(int paramInt)
    {
      AppMethodBeat.i(48799);
      ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      if (AppBrandTBSDownloadProxyUI.this.tipDialog != null)
      {
        AppBrandTBSDownloadProxyUI.this.tipDialog.dismiss();
        AppBrandTBSDownloadProxyUI.this.tipDialog = null;
      }
      com.tencent.mm.pluginsdk.ui.tools.p.gi(6, paramInt);
      if ((paramInt == 200) || (paramInt == 220))
      {
        g.yxI.a(64, 64, 7, 6, 1, 1, false);
        g.yxI.idkeyStat(366L, 6L, 1L, false);
        ae.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
        com.tencent.mm.cp.d.fWU();
        AppBrandTBSDownloadProxyUI.d(AppBrandTBSDownloadProxyUI.this);
        com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.e(AppBrandTBSDownloadProxyUI.this));
        localIntent = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(-1, localIntent);
        AppBrandTBSDownloadProxyUI.this.finish();
        AppMethodBeat.o(48799);
        return;
      }
      g.yxI.idkeyStat(64L, 6L, 1L, false);
      g.yxI.idkeyStat(366L, 7L, 1L, false);
      AppBrandTBSDownloadProxyUI.d(AppBrandTBSDownloadProxyUI.this);
      com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.e(AppBrandTBSDownloadProxyUI.this));
      Intent localIntent = new Intent();
      AppBrandTBSDownloadProxyUI.this.setResult(0, localIntent);
      AppBrandTBSDownloadProxyUI.this.finish();
      AppMethodBeat.o(48799);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI
 * JD-Core Version:    0.7.0.1
 */