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
import com.tencent.mm.plugin.appbrand.z.o;
import com.tencent.mm.plugin.appbrand.z.o.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
  private MMFalseProgressBar hqJ;
  private MMWebView hqK;
  private com.tencent.mm.model.gdpr.a hqL;
  private ResultReceiver hqM;
  private String mAppID;
  
  private void ew(boolean paramBoolean)
  {
    AppMethodBeat.i(40100);
    ResultReceiver localResultReceiver;
    if (this.hqM != null)
    {
      localResultReceiver = this.hqM;
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
    this.hqK = f.a.CMm.eo(this);
    this.hqK.getSettings().fJH();
    this.hqK.getSettings().setJavaScriptEnabled(true);
    this.hqK.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.hqK.getSettings().fJJ();
    this.hqK.getSettings().setUserAgentString(o.a(getContext(), this.hqK.getSettings().getUserAgentString(), (o.a)com.tencent.luggage.a.e.K(o.a.class)));
    this.hqK.getView().setHorizontalScrollBarEnabled(false);
    this.hqK.getView().setVerticalScrollBarEnabled(false);
    this.hqK.getSettings().setBuiltInZoomControls(true);
    this.hqK.getSettings().setUseWideViewPort(true);
    this.hqK.getSettings().setLoadWithOverviewMode(true);
    this.hqK.getSettings().fJA();
    this.hqK.getSettings().fJz();
    this.hqK.getSettings().setGeolocationEnabled(true);
    this.hqK.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.hqK.getSettings().fJF();
    this.hqK.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.hqK.getSettings().fJE();
    this.hqK.getSettings().fJG();
    this.hqK.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aoY() + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.hqK.setWebViewClient(c.a.CMl.a(this.hqK, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean aAf()
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
      
      public final void aAg()
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
      
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(40095);
        if (paramAnonymousInt == 200)
        {
          boolean bool = paramAnonymousBundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
          MPGdprPolicyUI.a(MPGdprPolicyUI.this, bool);
          MPGdprPolicyUI.b(MPGdprPolicyUI.this);
          if ((bool) && (!bs.isNullOrNil(MPGdprPolicyUI.c(MPGdprPolicyUI.this))) && (MPGdprPolicyUI.d(MPGdprPolicyUI.this).hqD != 0))
          {
            paramAnonymousBundle = new com.tencent.mm.ak.c();
            cwt localcwt = new cwt();
            localcwt.djj = MPGdprPolicyUI.c(MPGdprPolicyUI.this);
            localcwt.scene = MPGdprPolicyUI.d(MPGdprPolicyUI.this).hqD;
            b.a locala = new b.a();
            locala.hvt = localcwt;
            locala.hvu = new cwu();
            locala.funcId = 2734;
            locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
            paramAnonymousBundle.rr = locala.aAz();
            paramAnonymousBundle.aBB();
          }
        }
        AppMethodBeat.o(40095);
        return false;
      }
      
      public final boolean yP(String paramAnonymousString)
      {
        return false;
      }
    }, localBundle));
    this.hqK.setWebChromeClient(a.a.CMk.a(this.hqK, new com.tencent.mm.plugin.webview.ui.tools.widget.b()
    {
      public final boolean yQ(final String paramAnonymousString)
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
    ((FrameLayout)paramView).addView(this.hqK, -1, -1);
    this.hqJ = new MMFalseProgressBar(this);
    this.hqJ.setProgressDrawable(com.tencent.mm.cc.a.l(this, 2131233300));
    ((FrameLayout)paramView).addView(this.hqJ, -1, com.tencent.mm.cc.a.fromDPToPix(this, 3));
    AppMethodBeat.o(40102);
  }
  
  public void finish()
  {
    AppMethodBeat.i(40101);
    super.finish();
    if (this.hqM != null)
    {
      ew(false);
      this.hqM = null;
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
        this.hqM = paramBundle;
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
      ac.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(40099);
      return;
    }
    this.hqL = com.tencent.mm.model.gdpr.a.yO(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.hqL == null)
    {
      ac.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      ew(false);
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
      this.hqK.destroy();
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.hqK = null;
      AppMethodBeat.o(40104);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(40105);
    if ((paramInt == 4) && (this.hqK.canGoBack()))
    {
      this.hqK.goBack();
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
    paramBundle = String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[] { this.hqL.hqC, ab.iC(this), (String)g.agR().agA().get(274436, null) });
    this.hqK.loadUrl(paramBundle);
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