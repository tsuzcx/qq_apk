package com.tencent.mm.model.gdpr.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.appbrand.af.r;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.n.a.a;
import com.tencent.mm.plugin.n.a.b;
import com.tencent.mm.plugin.n.a.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.d.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.a;
import com.tencent.mm.protocal.protobuf.ezz;
import com.tencent.mm.protocal.protobuf.faa;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ad;
import java.io.File;
import java.util.Locale;

@com.tencent.mm.ui.base.a(1)
public class MPGdprPolicyUI
  extends MMActivity
{
  private static final String oox;
  private String mAppID;
  private com.tencent.mm.model.gdpr.a ooA;
  private ResultReceiver ooB;
  private MMFalseProgressBar ooy;
  private MMWebView ooz;
  
  static
  {
    AppMethodBeat.i(242105);
    oox = "https://" + WeChatHosts.domainString(a.c.host_weixin_qq_com) + "/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s";
    AppMethodBeat.o(242105);
  }
  
  private void gT(boolean paramBoolean)
  {
    AppMethodBeat.i(40100);
    ResultReceiver localResultReceiver;
    if (this.ooB != null)
    {
      localResultReceiver = this.ooB;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 1;; i = -1)
    {
      localResultReceiver.send(i, null);
      AppMethodBeat.o(40100);
      return;
    }
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(40102);
    super.dealContentView(paramView);
    this.ooz = i.a.Xpw.fJ(this);
    this.ooz.getSettings().kfS();
    this.ooz.getSettings().setJavaScriptEnabled(true);
    this.ooz.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.ooz.getSettings().kfU();
    this.ooz.getSettings().setUserAgentString(r.a(getContext(), this.ooz.getSettings().getUserAgentString(), (r.a)com.tencent.luggage.a.e.T(r.a.class)));
    this.ooz.getView().setHorizontalScrollBarEnabled(false);
    this.ooz.getView().setVerticalScrollBarEnabled(false);
    this.ooz.getSettings().setBuiltInZoomControls(true);
    this.ooz.getSettings().setUseWideViewPort(true);
    this.ooz.getSettings().setLoadWithOverviewMode(true);
    this.ooz.getSettings().kfN();
    this.ooz.getSettings().kfM();
    this.ooz.getSettings().setGeolocationEnabled(true);
    this.ooz.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.ooz.getSettings().kfQ();
    this.ooz.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.ooz.getSettings().kfP();
    this.ooz.getSettings().kfR();
    this.ooz.getSettings().setDatabasePath(com.tencent.mm.loader.i.b.bmq() + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.ooz.setWebViewClient(f.a.Xpv.a(this.ooz, new com.tencent.mm.plugin.webview.ui.tools.widget.h()
    {
      public final boolean Kw(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean bEj()
      {
        AppMethodBeat.i(40092);
        MPGdprPolicyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(40089);
            MPGdprPolicyUI.this.finish();
            AppMethodBeat.o(40089);
          }
        });
        AppMethodBeat.o(40092);
        return true;
      }
      
      public final void bEk()
      {
        AppMethodBeat.i(40093);
        MPGdprPolicyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(40090);
            MPGdprPolicyUI.a(MPGdprPolicyUI.this).start();
            AppMethodBeat.o(40090);
          }
        });
        AppMethodBeat.o(40093);
      }
      
      public final void c(MMWebView paramAnonymousMMWebView)
      {
        AppMethodBeat.i(40094);
        MPGdprPolicyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(40091);
            MPGdprPolicyUI.a(MPGdprPolicyUI.this).finish();
            AppMethodBeat.o(40091);
          }
        });
        AppMethodBeat.o(40094);
      }
      
      public final boolean i(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(40095);
        if (paramAnonymousInt == 200)
        {
          boolean bool = paramAnonymousBundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
          MPGdprPolicyUI.a(MPGdprPolicyUI.this, bool);
          MPGdprPolicyUI.b(MPGdprPolicyUI.this);
          if ((bool) && (!Util.isNullOrNil(MPGdprPolicyUI.c(MPGdprPolicyUI.this))) && (MPGdprPolicyUI.d(MPGdprPolicyUI.this).oor != 0))
          {
            paramAnonymousBundle = new com.tencent.mm.am.b();
            ezz localezz = new ezz();
            localezz.appid = MPGdprPolicyUI.c(MPGdprPolicyUI.this);
            localezz.scene = MPGdprPolicyUI.d(MPGdprPolicyUI.this).oor;
            c.a locala = new c.a();
            locala.otE = localezz;
            locala.otF = new faa();
            locala.funcId = 2734;
            locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
            paramAnonymousBundle.c(locala.bEF());
            paramAnonymousBundle.bFJ();
          }
        }
        AppMethodBeat.o(40095);
        return false;
      }
    }, localBundle));
    this.ooz.setWebChromeClient(d.a.Xpu.a(this.ooz, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean Kx(final String paramAnonymousString)
      {
        AppMethodBeat.i(40097);
        MPGdprPolicyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(40096);
            MPGdprPolicyUI.this.setMMTitle(paramAnonymousString);
            AppMethodBeat.o(40096);
          }
        });
        AppMethodBeat.o(40097);
        return true;
      }
    }));
    ((FrameLayout)paramView).addView(this.ooz, -1, -1);
    this.ooy = new MMFalseProgressBar(this);
    this.ooy.setProgressDrawable(com.tencent.mm.cd.a.m(this, a.a.mm_webview_progress_horizontal));
    ((FrameLayout)paramView).addView(this.ooy, -1, com.tencent.mm.cd.a.fromDPToPix(this, 3));
    AppMethodBeat.o(40102);
  }
  
  public void finish()
  {
    AppMethodBeat.i(40101);
    super.finish();
    if (this.ooB != null)
    {
      gT(false);
      this.ooB = null;
    }
    AppMethodBeat.o(40101);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40099);
    super.onCreate(paramBundle);
    try
    {
      if (getIntent() != null)
      {
        paramBundle = (ResultReceiver)getIntent().getParcelableExtra("MPGdprPolicyUI_KEY_RECEIVER");
        this.ooB = paramBundle;
        if (paramBundle != null) {}
      }
      else
      {
        finish();
        AppMethodBeat.o(40099);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(40099);
      return;
    }
    this.ooA = com.tencent.mm.model.gdpr.a.Kv(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.ooA == null)
    {
      Log.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      gT(false);
      finish();
      AppMethodBeat.o(40099);
      return;
    }
    this.mAppID = getIntent().getStringExtra("MPGdprPolicyUI_KEY_APPID");
    AppMethodBeat.o(40099);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40104);
    super.onDestroy();
    try
    {
      this.ooz.destroy();
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.ooz = null;
      AppMethodBeat.o(40104);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(40105);
    if ((paramInt == 4) && (this.ooz.canGoBack()))
    {
      this.ooz.goBack();
      AppMethodBeat.o(40105);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(40105);
    return bool;
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40103);
    super.onPostCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(40098);
        MPGdprPolicyUI.this.finish();
        AppMethodBeat.o(40098);
        return true;
      }
    }, a.b.actionbar_icon_dark_close);
    setActionbarColor(-1);
    paramBundle = String.format(Locale.US, oox, new Object[] { this.ooA.ooq, LocaleUtil.getCurrentLanguage(this), (String)com.tencent.mm.kernel.h.baE().ban().d(274436, null) });
    this.ooz.loadUrl(paramBundle);
    AppMethodBeat.o(40103);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI
 * JD-Core Version:    0.7.0.1
 */