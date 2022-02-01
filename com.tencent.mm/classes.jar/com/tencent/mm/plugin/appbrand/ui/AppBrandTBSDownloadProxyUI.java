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
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.xwebutil.c;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.f.a;

@a(7)
public final class AppBrandTBSDownloadProxyUI
  extends MMActivity
{
  private static boolean qVE;
  private Handler mHandler;
  private Runnable qVI;
  private a qYl = null;
  s tipDialog;
  
  static
  {
    AppMethodBeat.i(48807);
    c.lQ(MMApplicationContext.getContext());
    qVE = false;
    AppMethodBeat.o(48807);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(48802);
    this.mHandler = new Handler();
    this.qVI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48792);
        AppBrandTBSDownloadProxyUI.cjY();
        Intent localIntent = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(0, localIntent);
        AppBrandTBSDownloadProxyUI.this.finish();
        AppMethodBeat.o(48792);
      }
    };
    this.mHandler.postDelayed(this.qVI, 20000L);
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
    Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), null, true, null);
    this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48793);
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
        paramAnonymousDialogInterface = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(2, paramAnonymousDialogInterface);
        AppBrandTBSDownloadProxyUI.this.finish();
        AppMethodBeat.o(48793);
      }
    });
    x.e(getWindow());
    Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
    c.bCD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    boolean bool1 = f.isDownloading();
    boolean bool2 = d.getTBSInstalling();
    boolean bool3 = f.isDownloadForeground();
    Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      if (bool3)
      {
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
        if (qVE)
        {
          setResult(0, new Intent());
          finish();
          AppMethodBeat.o(48801);
          return;
        }
        if (this.qYl == null) {
          this.qYl = new a((byte)0);
        }
        d.a(this.qYl);
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
        paramBundle = getContext();
        getContext().getString(au.i.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a(paramBundle, getContext().getString(au.i.app_brand_x5_installing_simple_tips), true, null);
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
            Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
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
      Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
      f.stopDownload();
    }
    Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
    paramBundle = new f.a()
    {
      public final void onNeedDownloadFinish(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(48791);
        if ((paramAnonymousBoolean) && (paramAnonymousInt >= 36824))
        {
          Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48790);
              Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
              AppBrandTBSDownloadProxyUI.a(AppBrandTBSDownloadProxyUI.this);
              AppMethodBeat.o(48790);
            }
          });
          AppMethodBeat.o(48791);
          return;
        }
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
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
    Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
    if ((this.mHandler != null) && (this.qVI != null)) {
      this.mHandler.removeCallbacks(this.qVI);
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
      Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      t.gU(5, paramInt);
      if ((paramInt == 100) || (paramInt == 120) || (paramInt == 122))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(366L, 4L, 1L, false);
        if (paramInt == 110) {
          break label225;
        }
        if ((paramInt != 100) && (paramInt != 120) && (paramInt != 122)) {
          break label166;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(64, 64, 4, 3, 1, 1, false);
      }
      for (;;)
      {
        localObject = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (localObject != null)
        {
          Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
          ((SharedPreferences.Editor)localObject).apply();
        }
        AppMethodBeat.o(48798);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(366L, 5L, 1L, false);
        break;
        label166:
        AppBrandTBSDownloadProxyUI.d(AppBrandTBSDownloadProxyUI.this);
        d.a(AppBrandTBSDownloadProxyUI.e(AppBrandTBSDownloadProxyUI.this));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(64L, 3L, 1L, false);
        localObject = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(0, (Intent)localObject);
        AppBrandTBSDownloadProxyUI.this.finish();
      }
      label225:
      Object localObject = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (localObject != null)
      {
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
        ((SharedPreferences.Editor)localObject).apply();
      }
      AppBrandTBSDownloadProxyUI.d(AppBrandTBSDownloadProxyUI.this);
      d.a(AppBrandTBSDownloadProxyUI.e(AppBrandTBSDownloadProxyUI.this));
      localObject = new Intent();
      AppBrandTBSDownloadProxyUI.this.setResult(0, (Intent)localObject);
      AppBrandTBSDownloadProxyUI.this.finish();
      AppMethodBeat.o(48798);
    }
    
    public final void onDownloadProgress(final int paramInt)
    {
      AppMethodBeat.i(48800);
      Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
      if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48797);
            AppBrandTBSDownloadProxyUI.this.tipDialog.setMessage(AppBrandTBSDownloadProxyUI.this.getContext().getString(au.i.app_brand_x5_installing_tips, new Object[] { String.valueOf(paramInt) }));
            AppMethodBeat.o(48797);
          }
        });
      }
      AppMethodBeat.o(48800);
    }
    
    public final void onInstallFinish(int paramInt)
    {
      AppMethodBeat.i(48799);
      Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      if (AppBrandTBSDownloadProxyUI.this.tipDialog != null)
      {
        AppBrandTBSDownloadProxyUI.this.tipDialog.dismiss();
        AppBrandTBSDownloadProxyUI.this.tipDialog = null;
      }
      t.gU(6, paramInt);
      if ((paramInt == 200) || (paramInt == 220))
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(64, 64, 7, 6, 1, 1, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(366L, 6L, 1L, false);
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
        c.ikh();
        AppBrandTBSDownloadProxyUI.d(AppBrandTBSDownloadProxyUI.this);
        d.a(AppBrandTBSDownloadProxyUI.e(AppBrandTBSDownloadProxyUI.this));
        localIntent = new Intent();
        AppBrandTBSDownloadProxyUI.this.setResult(-1, localIntent);
        AppBrandTBSDownloadProxyUI.this.finish();
        AppMethodBeat.o(48799);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(64L, 6L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(366L, 7L, 1L, false);
      AppBrandTBSDownloadProxyUI.d(AppBrandTBSDownloadProxyUI.this);
      d.a(AppBrandTBSDownloadProxyUI.e(AppBrandTBSDownloadProxyUI.this));
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