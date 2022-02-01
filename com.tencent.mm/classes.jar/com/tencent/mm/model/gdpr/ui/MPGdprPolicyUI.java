package com.tencent.mm.model.gdpr.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.n.a.b;
import com.tencent.mm.plugin.n.a.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.aa;
import java.io.File;
import java.util.Locale;

@com.tencent.mm.ui.base.a(1)
public class MPGdprPolicyUI
  extends MMActivity
{
  private static final String lwY;
  private MMFalseProgressBar lwZ;
  private MMWebView lxa;
  private com.tencent.mm.model.gdpr.a lxb;
  private ResultReceiver lxc;
  private String mAppID;
  
  static
  {
    AppMethodBeat.i(241056);
    lwY = "https://" + WeChatHosts.domainString(a.c.host_weixin_qq_com) + "/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s";
    AppMethodBeat.o(241056);
  }
  
  private void gc(boolean paramBoolean)
  {
    AppMethodBeat.i(40100);
    ResultReceiver localResultReceiver;
    if (this.lxc != null)
    {
      localResultReceiver = this.lxc;
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
  
  @SuppressLint({"SetJavaScriptEnabled", "InlinedApi"})
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(40102);
    super.dealContentView(paramView);
    this.lxa = f.a.QwC.eN(this);
    this.lxa.getSettings().iwC();
    this.lxa.getSettings().setJavaScriptEnabled(true);
    this.lxa.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.lxa.getSettings().iwE();
    this.lxa.getSettings().setUserAgentString(p.a(getContext(), this.lxa.getSettings().getUserAgentString(), (p.a)com.tencent.luggage.a.e.K(p.a.class)));
    this.lxa.getView().setHorizontalScrollBarEnabled(false);
    this.lxa.getView().setVerticalScrollBarEnabled(false);
    this.lxa.getSettings().setBuiltInZoomControls(true);
    this.lxa.getSettings().setUseWideViewPort(true);
    this.lxa.getSettings().setLoadWithOverviewMode(true);
    this.lxa.getSettings().iwx();
    this.lxa.getSettings().iww();
    this.lxa.getSettings().setGeolocationEnabled(true);
    this.lxa.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.lxa.getSettings().iwA();
    this.lxa.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.lxa.getSettings().iwz();
    this.lxa.getSettings().iwB();
    this.lxa.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aSC() + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.lxa.setWebViewClient(c.a.QwB.a(this.lxa, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean Su(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean bgr()
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
      
      public final void bgs()
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
      
      public final boolean h(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(40095);
        if (paramAnonymousInt == 200)
        {
          boolean bool = paramAnonymousBundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
          MPGdprPolicyUI.a(MPGdprPolicyUI.this, bool);
          MPGdprPolicyUI.b(MPGdprPolicyUI.this);
          if ((bool) && (!Util.isNullOrNil(MPGdprPolicyUI.c(MPGdprPolicyUI.this))) && (MPGdprPolicyUI.d(MPGdprPolicyUI.this).lwS != 0))
          {
            paramAnonymousBundle = new com.tencent.mm.an.c();
            egg localegg = new egg();
            localegg.appid = MPGdprPolicyUI.c(MPGdprPolicyUI.this);
            localegg.scene = MPGdprPolicyUI.d(MPGdprPolicyUI.this).lwS;
            d.a locala = new d.a();
            locala.lBU = localegg;
            locala.lBV = new egh();
            locala.funcId = 2734;
            locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
            paramAnonymousBundle.c(locala.bgN());
            paramAnonymousBundle.bhW();
          }
        }
        AppMethodBeat.o(40095);
        return false;
      }
    }, localBundle));
    this.lxa.setWebChromeClient(com.tencent.mm.plugin.webview.ui.tools.widget.a.a.QwA.a(this.lxa, new com.tencent.mm.plugin.webview.ui.tools.widget.b()
    {
      public final boolean Sv(final String paramAnonymousString)
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
    ((FrameLayout)paramView).addView(this.lxa, -1, -1);
    this.lwZ = new MMFalseProgressBar(this);
    this.lwZ.setProgressDrawable(com.tencent.mm.ci.a.m(this, com.tencent.mm.plugin.n.a.a.mm_webview_progress_horizontal));
    ((FrameLayout)paramView).addView(this.lwZ, -1, com.tencent.mm.ci.a.fromDPToPix(this, 3));
    AppMethodBeat.o(40102);
  }
  
  public void finish()
  {
    AppMethodBeat.i(40101);
    super.finish();
    if (this.lxc != null)
    {
      gc(false);
      this.lxc = null;
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
        this.lxc = paramBundle;
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
    this.lxb = com.tencent.mm.model.gdpr.a.St(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.lxb == null)
    {
      Log.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      gc(false);
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
      this.lxa.destroy();
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.lxa = null;
      AppMethodBeat.o(40104);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(40105);
    if ((paramInt == 4) && (this.lxa.canGoBack()))
    {
      this.lxa.goBack();
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
    paramBundle = String.format(Locale.US, lwY, new Object[] { this.lxb.lwR, LocaleUtil.getCurrentLanguage(this), (String)h.aHG().aHp().b(274436, null) });
    this.lxa.loadUrl(paramBundle);
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