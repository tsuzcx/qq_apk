package com.tencent.mm.model.gdpr.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.plugin.appbrand.s.q.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;
import java.io.File;
import java.util.Locale;

@com.tencent.mm.ui.base.a(1)
public class MPGdprPolicyUI
  extends MMActivity
{
  private MMFalseProgressBar foI;
  private MMWebView foJ;
  private com.tencent.mm.model.gdpr.a foK;
  private ResultReceiver foL;
  private String mAppID;
  
  private void cK(boolean paramBoolean)
  {
    AppMethodBeat.i(1506);
    ResultReceiver localResultReceiver;
    if (this.foL != null)
    {
      localResultReceiver = this.foL;
      if (!paramBoolean) {
        break label37;
      }
    }
    label37:
    for (int i = 1;; i = -1)
    {
      localResultReceiver.send(i, null);
      AppMethodBeat.o(1506);
      return;
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled", "InlinedApi"})
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(1508);
    super.dealContentView(paramView);
    this.foJ = f.a.vsl.dz(this);
    this.foJ.getSettings().dYx();
    this.foJ.getSettings().setJavaScriptEnabled(true);
    this.foJ.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.foJ.getSettings().dYz();
    this.foJ.getSettings().setUserAgentString(q.a(getContext(), this.foJ.getSettings().getUserAgentString(), (q.a)com.tencent.luggage.a.e.q(q.a.class)));
    this.foJ.getView().setHorizontalScrollBarEnabled(false);
    this.foJ.getView().setVerticalScrollBarEnabled(false);
    this.foJ.getSettings().setBuiltInZoomControls(true);
    this.foJ.getSettings().setUseWideViewPort(true);
    this.foJ.getSettings().setLoadWithOverviewMode(true);
    this.foJ.getSettings().dYs();
    this.foJ.getSettings().dYr();
    this.foJ.getSettings().setGeolocationEnabled(true);
    this.foJ.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.foJ.getSettings().dYv();
    this.foJ.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.foJ.getSettings().dYu();
    this.foJ.getSettings().dYw();
    this.foJ.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eQu + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.foJ.setWebViewClient(c.a.vsk.a(this.foJ, new MPGdprPolicyUI.1(this), localBundle));
    this.foJ.setWebChromeClient(a.a.vsj.a(this.foJ, new MPGdprPolicyUI.2(this)));
    ((FrameLayout)paramView).addView(this.foJ, -1, -1);
    this.foI = new MMFalseProgressBar(this);
    this.foI.setProgressDrawable(com.tencent.mm.cb.a.k(this, 2130839677));
    ((FrameLayout)paramView).addView(this.foI, -1, com.tencent.mm.cb.a.fromDPToPix(this, 3));
    AppMethodBeat.o(1508);
  }
  
  public void finish()
  {
    AppMethodBeat.i(1507);
    super.finish();
    if (this.foL != null)
    {
      cK(false);
      this.foL = null;
    }
    AppMethodBeat.o(1507);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1505);
    super.onCreate(paramBundle);
    try
    {
      if (getIntent() != null)
      {
        paramBundle = (ResultReceiver)getIntent().getParcelableExtra("MPGdprPolicyUI_KEY_RECEIVER");
        this.foL = paramBundle;
        if (paramBundle != null) {}
      }
      else
      {
        finish();
        AppMethodBeat.o(1505);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      ab.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(1505);
      return;
    }
    this.foK = com.tencent.mm.model.gdpr.a.pU(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.foK == null)
    {
      ab.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      cK(false);
      finish();
      AppMethodBeat.o(1505);
      return;
    }
    this.mAppID = getIntent().getStringExtra("MPGdprPolicyUI_KEY_APPID");
    AppMethodBeat.o(1505);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(1510);
    super.onDestroy();
    try
    {
      this.foJ.destroy();
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.foJ = null;
      AppMethodBeat.o(1510);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(1511);
    if ((paramInt == 4) && (this.foJ.canGoBack()))
    {
      this.foJ.goBack();
      AppMethodBeat.o(1511);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(1511);
    return bool;
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1509);
    super.onPostCreate(paramBundle);
    setBackBtn(new MPGdprPolicyUI.3(this), 2131230739);
    setActionbarColor(-1);
    paramBundle = String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[] { this.foK.foB, aa.gP(this), (String)g.RL().Ru().get(274436, null) });
    this.foJ.loadUrl(paramBundle);
    AppMethodBeat.o(1509);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI
 * JD-Core Version:    0.7.0.1
 */