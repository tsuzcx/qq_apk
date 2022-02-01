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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.y.p;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.protocal.protobuf.dda;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  private MMFalseProgressBar hLU;
  private MMWebView hLV;
  private com.tencent.mm.model.gdpr.a hLW;
  private ResultReceiver hLX;
  private String mAppID;
  
  private void eA(boolean paramBoolean)
  {
    AppMethodBeat.i(40100);
    ResultReceiver localResultReceiver;
    if (this.hLX != null)
    {
      localResultReceiver = this.hLX;
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
    this.hLV = f.a.EIC.es(this);
    this.hLV.getSettings().gfD();
    this.hLV.getSettings().setJavaScriptEnabled(true);
    this.hLV.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.hLV.getSettings().gfF();
    this.hLV.getSettings().setUserAgentString(p.a(getContext(), this.hLV.getSettings().getUserAgentString(), (p.a)com.tencent.luggage.a.e.K(p.a.class)));
    this.hLV.getView().setHorizontalScrollBarEnabled(false);
    this.hLV.getView().setVerticalScrollBarEnabled(false);
    this.hLV.getSettings().setBuiltInZoomControls(true);
    this.hLV.getSettings().setUseWideViewPort(true);
    this.hLV.getSettings().setLoadWithOverviewMode(true);
    this.hLV.getSettings().gfw();
    this.hLV.getSettings().gfv();
    this.hLV.getSettings().setGeolocationEnabled(true);
    this.hLV.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.hLV.getSettings().gfB();
    this.hLV.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.hLV.getSettings().gfA();
    this.hLV.getSettings().gfC();
    this.hLV.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.asa() + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.hLV.setWebViewClient(c.a.EIB.a(this.hLV, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean Cq(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean aDy()
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
      
      public final void aDz()
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
      
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(40095);
        if (paramAnonymousInt == 200)
        {
          boolean bool = paramAnonymousBundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
          MPGdprPolicyUI.a(MPGdprPolicyUI.this, bool);
          MPGdprPolicyUI.b(MPGdprPolicyUI.this);
          if ((bool) && (!bu.isNullOrNil(MPGdprPolicyUI.c(MPGdprPolicyUI.this))) && (MPGdprPolicyUI.d(MPGdprPolicyUI.this).hLO != 0))
          {
            paramAnonymousBundle = new com.tencent.mm.ak.a();
            dda localdda = new dda();
            localdda.dwb = MPGdprPolicyUI.c(MPGdprPolicyUI.this);
            localdda.scene = MPGdprPolicyUI.d(MPGdprPolicyUI.this).hLO;
            b.a locala = new b.a();
            locala.hQF = localdda;
            locala.hQG = new ddb();
            locala.funcId = 2734;
            locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
            paramAnonymousBundle.c(locala.aDS());
            paramAnonymousBundle.aET();
          }
        }
        AppMethodBeat.o(40095);
        return false;
      }
    }, localBundle));
    this.hLV.setWebChromeClient(a.a.EIA.a(this.hLV, new com.tencent.mm.plugin.webview.ui.tools.widget.b()
    {
      public final boolean Cr(final String paramAnonymousString)
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
    ((FrameLayout)paramView).addView(this.hLV, -1, -1);
    this.hLU = new MMFalseProgressBar(this);
    this.hLU.setProgressDrawable(com.tencent.mm.cb.a.l(this, 2131233300));
    ((FrameLayout)paramView).addView(this.hLU, -1, com.tencent.mm.cb.a.fromDPToPix(this, 3));
    AppMethodBeat.o(40102);
  }
  
  public void finish()
  {
    AppMethodBeat.i(40101);
    super.finish();
    if (this.hLX != null)
    {
      eA(false);
      this.hLX = null;
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
        this.hLX = paramBundle;
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
      ae.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(40099);
      return;
    }
    this.hLW = com.tencent.mm.model.gdpr.a.Cp(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.hLW == null)
    {
      ae.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      eA(false);
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
      this.hLV.destroy();
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.hLV = null;
      AppMethodBeat.o(40104);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(40105);
    if ((paramInt == 4) && (this.hLV.canGoBack()))
    {
      this.hLV.goBack();
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
    }, 2131689492);
    setActionbarColor(-1);
    paramBundle = String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[] { this.hLW.hLN, ad.iR(this), (String)g.ajR().ajA().get(274436, null) });
    this.hLV.loadUrl(paramBundle);
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