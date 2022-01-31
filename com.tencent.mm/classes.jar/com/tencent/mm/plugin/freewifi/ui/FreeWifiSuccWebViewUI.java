package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.x;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.q.b;

public class FreeWifiSuccWebViewUI
  extends WebViewUI
  implements f
{
  private int cCy;
  private String cvr;
  private String cwc;
  private String mLh;
  private boolean mOK = false;
  private int mOy;
  private String mOz;
  private String signature;
  
  public final void aMf()
  {
    AppMethodBeat.i(21101);
    super.aMf();
    AppMethodBeat.o(21101);
  }
  
  public void finish()
  {
    AppMethodBeat.i(21102);
    super.finish();
    AppMethodBeat.o(21102);
  }
  
  public void initView()
  {
    AppMethodBeat.i(21104);
    super.initView();
    setBackBtnVisible(false);
    addTextOptionMenu(0, getString(2131300159), new FreeWifiSuccWebViewUI.1(this), null, q.b.zbD);
    AppMethodBeat.o(21104);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(21103);
    super.onBackPressed();
    AppMethodBeat.o(21103);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21099);
    com.tencent.mm.plugin.freewifi.j.userName = "";
    com.tencent.mm.plugin.freewifi.j.type = 0;
    String str = getIntent().getStringExtra("free_wifi_qinghuai_url");
    ab.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[] { str });
    getIntent().putExtra("rawUrl", str);
    getIntent().putExtra("showShare", false);
    super.onCreate(paramBundle);
    this.cwc = getIntent().getStringExtra("free_wifi_appid");
    this.mLh = getIntent().getStringExtra("free_wifi_app_nickname");
    this.cvr = getIntent().getStringExtra("free_wifi_app_username");
    this.mOy = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.mOz = getIntent().getStringExtra("free_wifi_finish_url");
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    this.cCy = com.tencent.mm.plugin.freewifi.m.X(getIntent());
    if (this.cCy == 10)
    {
      paramBundle = ac.erz.ere;
      str = ac.bH(getContext());
      if ((!com.tencent.mm.plugin.freewifi.m.isEmpty(paramBundle)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(str))) {
        this.mOz = Uri.parse(this.mOz).buildUpon().appendQueryParameter("manufacturer", str).appendQueryParameter("manufacturerUsername", paramBundle).toString();
      }
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.cwc, this.mLh, this.cvr, Integer.valueOf(this.mOy), this.mOz, this.signature });
    paramBundle = k.bAc();
    str = com.tencent.mm.plugin.freewifi.m.Oy("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
    paramBundle.ssid = at.gX(ah.getContext());
    paramBundle.bssid = at.gY(ah.getContext());
    paramBundle.coY = str;
    paramBundle.coX = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.mIC = this.cwc;
    paramBundle.kMp = com.tencent.mm.plugin.freewifi.m.U(getIntent());
    paramBundle.mIE = com.tencent.mm.plugin.freewifi.m.W(getIntent());
    paramBundle.mIF = k.b.mIR.mJq;
    paramBundle.mIG = k.b.mIR.name;
    paramBundle.cCy = com.tencent.mm.plugin.freewifi.m.X(getIntent());
    paramBundle.mIH = this.cvr;
    paramBundle.bAe().bAd();
    AppMethodBeat.o(21099);
  }
  
  @TargetApi(11)
  public void onDestroy()
  {
    AppMethodBeat.i(21100);
    super.onDestroy();
    aw.Rc().b(1703, this);
    AppMethodBeat.o(21100);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(21105);
    String str = (String)paramMenu.getItem(0).getTitle();
    if (!getString(2131300159).equals(str)) {
      addTextOptionMenu(0, getString(2131300159), new FreeWifiSuccWebViewUI.2(this), null, q.b.zbD);
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(21105);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(21106);
    ab.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    aw.Rc().b(1703, this);
    AppMethodBeat.o(21106);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI
 * JD-Core Version:    0.7.0.1
 */