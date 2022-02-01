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
import com.tencent.mm.al.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.z.p;
import com.tencent.mm.plugin.appbrand.z.p.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  private MMFalseProgressBar hJb;
  private MMWebView hJc;
  private com.tencent.mm.model.gdpr.a hJd;
  private ResultReceiver hJe;
  private String mAppID;
  
  private void ey(boolean paramBoolean)
  {
    AppMethodBeat.i(40100);
    ResultReceiver localResultReceiver;
    if (this.hJe != null)
    {
      localResultReceiver = this.hJe;
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
    this.hJc = f.a.Eqm.eo(this);
    this.hJc.getSettings().gbb();
    this.hJc.getSettings().setJavaScriptEnabled(true);
    this.hJc.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.hJc.getSettings().gbd();
    this.hJc.getSettings().setUserAgentString(p.a(getContext(), this.hJc.getSettings().getUserAgentString(), (p.a)com.tencent.luggage.a.e.K(p.a.class)));
    this.hJc.getView().setHorizontalScrollBarEnabled(false);
    this.hJc.getView().setVerticalScrollBarEnabled(false);
    this.hJc.getSettings().setBuiltInZoomControls(true);
    this.hJc.getSettings().setUseWideViewPort(true);
    this.hJc.getSettings().setLoadWithOverviewMode(true);
    this.hJc.getSettings().gaU();
    this.hJc.getSettings().gaT();
    this.hJc.getSettings().setGeolocationEnabled(true);
    this.hJc.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.hJc.getSettings().gaZ();
    this.hJc.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.hJc.getSettings().gaY();
    this.hJc.getSettings().gba();
    this.hJc.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.arL() + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.hJc.setWebViewClient(c.a.Eql.a(this.hJc, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean BO(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean aDi()
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
      
      public final void aDj()
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
          if ((bool) && (!bt.isNullOrNil(MPGdprPolicyUI.c(MPGdprPolicyUI.this))) && (MPGdprPolicyUI.d(MPGdprPolicyUI.this).hIV != 0))
          {
            paramAnonymousBundle = new com.tencent.mm.al.a();
            dcg localdcg = new dcg();
            localdcg.duW = MPGdprPolicyUI.c(MPGdprPolicyUI.this);
            localdcg.scene = MPGdprPolicyUI.d(MPGdprPolicyUI.this).hIV;
            b.a locala = new b.a();
            locala.hNM = localdcg;
            locala.hNN = new dch();
            locala.funcId = 2734;
            locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
            paramAnonymousBundle.c(locala.aDC());
            paramAnonymousBundle.aED();
          }
        }
        AppMethodBeat.o(40095);
        return false;
      }
    }, localBundle));
    this.hJc.setWebChromeClient(a.a.Eqk.a(this.hJc, new com.tencent.mm.plugin.webview.ui.tools.widget.b()
    {
      public final boolean BP(final String paramAnonymousString)
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
    ((FrameLayout)paramView).addView(this.hJc, -1, -1);
    this.hJb = new MMFalseProgressBar(this);
    this.hJb.setProgressDrawable(com.tencent.mm.cc.a.l(this, 2131233300));
    ((FrameLayout)paramView).addView(this.hJb, -1, com.tencent.mm.cc.a.fromDPToPix(this, 3));
    AppMethodBeat.o(40102);
  }
  
  public void finish()
  {
    AppMethodBeat.i(40101);
    super.finish();
    if (this.hJe != null)
    {
      ey(false);
      this.hJe = null;
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
        this.hJe = paramBundle;
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
      ad.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(40099);
      return;
    }
    this.hJd = com.tencent.mm.model.gdpr.a.BN(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.hJd == null)
    {
      ad.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      ey(false);
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
      this.hJc.destroy();
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.hJc = null;
      AppMethodBeat.o(40104);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(40105);
    if ((paramInt == 4) && (this.hJc.canGoBack()))
    {
      this.hJc.goBack();
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
    paramBundle = String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[] { this.hJd.hIU, ac.iM(this), (String)g.ajC().ajl().get(274436, null) });
    this.hJc.loadUrl(paramBundle);
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