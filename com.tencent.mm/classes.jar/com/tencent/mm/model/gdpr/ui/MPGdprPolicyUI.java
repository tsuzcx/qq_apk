package com.tencent.mm.model.gdpr.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import java.io.File;
import java.util.Locale;

@com.tencent.mm.ui.base.a(1)
public class MPGdprPolicyUI
  extends MMActivity
{
  private static final String iGW;
  private MMFalseProgressBar iGX;
  private MMWebView iGY;
  private com.tencent.mm.model.gdpr.a iGZ;
  private ResultReceiver iHa;
  private String mAppID;
  
  static
  {
    AppMethodBeat.i(236428);
    iGW = "https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s";
    AppMethodBeat.o(236428);
  }
  
  private void fs(boolean paramBoolean)
  {
    AppMethodBeat.i(40100);
    ResultReceiver localResultReceiver;
    if (this.iHa != null)
    {
      localResultReceiver = this.iHa;
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
    this.iGY = f.a.Jys.eK(this);
    this.iGY.getSettings().hsU();
    this.iGY.getSettings().setJavaScriptEnabled(true);
    this.iGY.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.iGY.getSettings().hsW();
    this.iGY.getSettings().setUserAgentString(p.a(getContext(), this.iGY.getSettings().getUserAgentString(), (p.a)com.tencent.luggage.a.e.M(p.a.class)));
    this.iGY.getView().setHorizontalScrollBarEnabled(false);
    this.iGY.getView().setVerticalScrollBarEnabled(false);
    this.iGY.getSettings().setBuiltInZoomControls(true);
    this.iGY.getSettings().setUseWideViewPort(true);
    this.iGY.getSettings().setLoadWithOverviewMode(true);
    this.iGY.getSettings().hsN();
    this.iGY.getSettings().hsM();
    this.iGY.getSettings().setGeolocationEnabled(true);
    this.iGY.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.iGY.getSettings().hsS();
    this.iGY.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.iGY.getSettings().hsR();
    this.iGY.getSettings().hsT();
    this.iGY.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.iGY.setWebViewClient(c.a.Jyr.a(this.iGY, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean Lb(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean aXk()
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
      
      public final void aXl()
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
      
      public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(40095);
        if (paramAnonymousInt == 200)
        {
          boolean bool = paramAnonymousBundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
          MPGdprPolicyUI.a(MPGdprPolicyUI.this, bool);
          MPGdprPolicyUI.b(MPGdprPolicyUI.this);
          if ((bool) && (!Util.isNullOrNil(MPGdprPolicyUI.c(MPGdprPolicyUI.this))) && (MPGdprPolicyUI.d(MPGdprPolicyUI.this).iGQ != 0))
          {
            paramAnonymousBundle = new com.tencent.mm.ak.c();
            dwe localdwe = new dwe();
            localdwe.dNI = MPGdprPolicyUI.c(MPGdprPolicyUI.this);
            localdwe.scene = MPGdprPolicyUI.d(MPGdprPolicyUI.this).iGQ;
            d.a locala = new d.a();
            locala.iLN = localdwe;
            locala.iLO = new dwf();
            locala.funcId = 2734;
            locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
            paramAnonymousBundle.c(locala.aXF());
            paramAnonymousBundle.aYI();
          }
        }
        AppMethodBeat.o(40095);
        return false;
      }
    }, localBundle));
    this.iGY.setWebChromeClient(a.a.Jyq.a(this.iGY, new com.tencent.mm.plugin.webview.ui.tools.widget.b()
    {
      public final boolean Lc(final String paramAnonymousString)
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
    ((FrameLayout)paramView).addView(this.iGY, -1, -1);
    this.iGX = new MMFalseProgressBar(this);
    this.iGX.setProgressDrawable(com.tencent.mm.cb.a.l(this, 2131233975));
    ((FrameLayout)paramView).addView(this.iGX, -1, com.tencent.mm.cb.a.fromDPToPix(this, 3));
    AppMethodBeat.o(40102);
  }
  
  public void finish()
  {
    AppMethodBeat.i(40101);
    super.finish();
    if (this.iHa != null)
    {
      fs(false);
      this.iHa = null;
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
        this.iHa = paramBundle;
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
    this.iGZ = com.tencent.mm.model.gdpr.a.La(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.iGZ == null)
    {
      Log.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      fs(false);
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
      this.iGY.destroy();
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.iGY = null;
      AppMethodBeat.o(40104);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(40105);
    if ((paramInt == 4) && (this.iGY.canGoBack()))
    {
      this.iGY.goBack();
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
    }, 2131689494);
    setActionbarColor(-1);
    paramBundle = String.format(Locale.US, iGW, new Object[] { this.iGZ.iGP, LocaleUtil.getCurrentLanguage(this), (String)g.aAh().azQ().get(274436, null) });
    this.iGY.loadUrl(paramBundle);
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