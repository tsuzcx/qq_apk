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
import com.tencent.mm.plugin.appbrand.aa.o;
import com.tencent.mm.plugin.appbrand.aa.o.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.y;
import java.io.File;
import java.util.Locale;

@com.tencent.mm.ui.base.a(1)
public class MPGdprPolicyUI
  extends MMActivity
{
  private MMFalseProgressBar gQj;
  private MMWebView gQk;
  private com.tencent.mm.model.gdpr.a gQl;
  private ResultReceiver gQm;
  private String mAppID;
  
  private void eb(boolean paramBoolean)
  {
    AppMethodBeat.i(40100);
    ResultReceiver localResultReceiver;
    if (this.gQm != null)
    {
      localResultReceiver = this.gQm;
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
    this.gQk = f.a.Bud.eg(this);
    this.gQk.getSettings().frg();
    this.gQk.getSettings().setJavaScriptEnabled(true);
    this.gQk.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.gQk.getSettings().fri();
    this.gQk.getSettings().setUserAgentString(o.a(getContext(), this.gQk.getSettings().getUserAgentString(), (o.a)com.tencent.luggage.a.e.K(o.a.class)));
    this.gQk.getView().setHorizontalScrollBarEnabled(false);
    this.gQk.getView().setVerticalScrollBarEnabled(false);
    this.gQk.getSettings().setBuiltInZoomControls(true);
    this.gQk.getSettings().setUseWideViewPort(true);
    this.gQk.getSettings().setLoadWithOverviewMode(true);
    this.gQk.getSettings().fqZ();
    this.gQk.getSettings().fqY();
    this.gQk.getSettings().setGeolocationEnabled(true);
    this.gQk.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.gQk.getSettings().fre();
    this.gQk.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.gQk.getSettings().frd();
    this.gQk.getSettings().frf();
    this.gQk.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.ahY() + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.gQk.setWebViewClient(c.a.Buc.a(this.gQk, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean ato()
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
      
      public final void atp()
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
      
      public final void b(MMWebView paramAnonymousMMWebView)
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
          if ((bool) && (!bt.isNullOrNil(MPGdprPolicyUI.c(MPGdprPolicyUI.this))) && (MPGdprPolicyUI.d(MPGdprPolicyUI.this).gQd != 0))
          {
            paramAnonymousBundle = new com.tencent.mm.al.c();
            crk localcrk = new crk();
            localcrk.dlB = MPGdprPolicyUI.c(MPGdprPolicyUI.this);
            localcrk.scene = MPGdprPolicyUI.d(MPGdprPolicyUI.this).gQd;
            b.a locala = new b.a();
            locala.gUU = localcrk;
            locala.gUV = new crl();
            locala.funcId = 2734;
            locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
            paramAnonymousBundle.rr = locala.atI();
            paramAnonymousBundle.auK();
          }
        }
        AppMethodBeat.o(40095);
        return false;
      }
      
      public final boolean uJ(String paramAnonymousString)
      {
        return false;
      }
    }, localBundle));
    this.gQk.setWebChromeClient(a.a.Bub.a(this.gQk, new com.tencent.mm.plugin.webview.ui.tools.widget.b()
    {
      public final boolean uK(final String paramAnonymousString)
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
    ((FrameLayout)paramView).addView(this.gQk, -1, -1);
    this.gQj = new MMFalseProgressBar(this);
    this.gQj.setProgressDrawable(com.tencent.mm.cd.a.l(this, 2131233300));
    ((FrameLayout)paramView).addView(this.gQj, -1, com.tencent.mm.cd.a.fromDPToPix(this, 3));
    AppMethodBeat.o(40102);
  }
  
  public void finish()
  {
    AppMethodBeat.i(40101);
    super.finish();
    if (this.gQm != null)
    {
      eb(false);
      this.gQm = null;
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
        this.gQm = paramBundle;
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
    this.gQl = com.tencent.mm.model.gdpr.a.uI(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.gQl == null)
    {
      ad.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      eb(false);
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
      this.gQk.destroy();
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.gQk = null;
      AppMethodBeat.o(40104);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(40105);
    if ((paramInt == 4) && (this.gQk.canGoBack()))
    {
      this.gQk.goBack();
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
    paramBundle = String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[] { this.gQl.gQc, ac.ir(this), (String)g.afB().afk().get(274436, null) });
    this.gQk.loadUrl(paramBundle);
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