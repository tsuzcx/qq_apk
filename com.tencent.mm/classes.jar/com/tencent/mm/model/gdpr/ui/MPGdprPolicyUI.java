package com.tencent.mm.model.gdpr.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.u.q;
import com.tencent.mm.plugin.appbrand.u.q.a;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.n;
import java.io.File;
import java.util.Locale;

@com.tencent.mm.ui.base.a(1)
public class MPGdprPolicyUI
  extends MMActivity
{
  private MMFalseProgressBar dYE;
  private MMWebView dYF;
  private com.tencent.mm.model.gdpr.a dYG;
  private ResultReceiver dYH;
  private String mAppID;
  
  private void bI(boolean paramBoolean)
  {
    ResultReceiver localResultReceiver;
    if (this.dYH != null)
    {
      localResultReceiver = this.dYH;
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (int i = 1;; i = -1)
    {
      localResultReceiver.send(i, null);
      return;
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled", "InlinedApi"})
  protected final void dealContentView(View paramView)
  {
    super.dealContentView(paramView);
    this.dYF = f.a.rBZ.cO(this);
    this.dYF.getSettings().cSs();
    this.dYF.getSettings().setJavaScriptEnabled(true);
    this.dYF.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.dYF.getSettings().cSu();
    this.dYF.getSettings().setUserAgentString(q.a(this.mController.uMN, this.dYF.getSettings().getUserAgentString(), (q.a)com.tencent.luggage.b.e.i(q.a.class)));
    this.dYF.getView().setHorizontalScrollBarEnabled(false);
    this.dYF.getView().setVerticalScrollBarEnabled(false);
    this.dYF.getSettings().setBuiltInZoomControls(true);
    this.dYF.getSettings().setUseWideViewPort(true);
    this.dYF.getSettings().setLoadWithOverviewMode(true);
    this.dYF.getSettings().cSn();
    this.dYF.getSettings().cSm();
    this.dYF.getSettings().setGeolocationEnabled(true);
    this.dYF.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.dYF.getSettings().cSq();
    this.dYF.getSettings().setAppCachePath(this.mController.uMN.getDir("webviewcache", 0).getAbsolutePath());
    this.dYF.getSettings().cSp();
    this.dYF.getSettings().cSr();
    this.dYF.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.dOO + "databases/");
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
    this.dYF.setWebViewClient(c.a.rBY.a(this.dYF, new MPGdprPolicyUI.1(this), localBundle));
    this.dYF.setWebChromeClient(com.tencent.mm.plugin.webview.ui.tools.widget.a.a.rBX.a(this.dYF, new MPGdprPolicyUI.2(this)));
    ((FrameLayout)paramView).addView(this.dYF, -1, -1);
    this.dYE = new MMFalseProgressBar(this);
    this.dYE.setProgressDrawable(com.tencent.mm.cb.a.g(this, com.tencent.mm.plugin.m.a.a.mm_webview_progress_horizontal));
    ((FrameLayout)paramView).addView(this.dYE, -1, com.tencent.mm.cb.a.fromDPToPix(this, 3));
  }
  
  public void finish()
  {
    super.finish();
    if (this.dYH != null)
    {
      bI(false);
      this.dYH = null;
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      if (getIntent() != null)
      {
        paramBundle = (ResultReceiver)getIntent().getParcelableExtra("MPGdprPolicyUI_KEY_RECEIVER");
        this.dYH = paramBundle;
        if (paramBundle != null) {}
      }
      else
      {
        finish();
        return;
      }
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", new Object[] { paramBundle });
      finish();
      return;
    }
    this.dYG = com.tencent.mm.model.gdpr.a.jg(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
    if (this.dYG == null)
    {
      y.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
      bI(false);
      finish();
      return;
    }
    this.mAppID = getIntent().getStringExtra("MPGdprPolicyUI_KEY_APPID");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.dYF.destroy();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[] { localException });
      return;
    }
    finally
    {
      this.dYF = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.dYF.canGoBack()))
    {
      this.dYF.goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    setBackBtn(new MPGdprPolicyUI.3(this), a.b.actionbar_icon_dark_close);
    ta(-1);
    paramBundle = String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[] { this.dYG.dYw, x.fB(this), (String)g.DP().Dz().get(274436, null) });
    this.dYF.loadUrl(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI
 * JD-Core Version:    0.7.0.1
 */