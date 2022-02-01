package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.r.b;

public class FreeWifiSuccWebViewUI
  extends WebViewUI
  implements g
{
  private int channel;
  private String dkB;
  private String dlB;
  private String ril;
  private boolean rlC = false;
  private int rlq;
  private String rlr;
  private String signature;
  
  public final void bol()
  {
    AppMethodBeat.i(25161);
    super.bol();
    AppMethodBeat.o(25161);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25162);
    super.finish();
    AppMethodBeat.o(25162);
  }
  
  public void initView()
  {
    AppMethodBeat.i(25164);
    super.initView();
    setBackBtnVisible(false);
    addTextOptionMenu(0, getString(2131759631), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25157);
        FreeWifiSuccWebViewUI.this.finish();
        FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
        AppMethodBeat.o(25157);
        return true;
      }
    }, null, r.b.FOG);
    AppMethodBeat.o(25164);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(25163);
    super.onBackPressed();
    AppMethodBeat.o(25163);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25159);
    com.tencent.mm.plugin.freewifi.j.userName = "";
    com.tencent.mm.plugin.freewifi.j.type = 0;
    String str = getIntent().getStringExtra("free_wifi_qinghuai_url");
    ad.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[] { str });
    getIntent().putExtra("rawUrl", str);
    getIntent().putExtra("showShare", false);
    super.onCreate(paramBundle);
    this.dlB = getIntent().getStringExtra("free_wifi_appid");
    this.ril = getIntent().getStringExtra("free_wifi_app_nickname");
    this.dkB = getIntent().getStringExtra("free_wifi_app_username");
    this.rlq = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.rlr = getIntent().getStringExtra("free_wifi_finish_url");
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    this.channel = m.al(getIntent());
    if (this.channel == 10)
    {
      paramBundle = ae.fFB.fEN;
      str = ae.bW(getContext());
      if ((!m.dq(paramBundle)) && (!m.dq(str))) {
        this.rlr = Uri.parse(this.rlr).buildUpon().appendQueryParameter("manufacturer", str).appendQueryParameter("manufacturerUsername", paramBundle).toString();
      }
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.dlB, this.ril, this.dkB, Integer.valueOf(this.rlq), this.rlr, this.signature });
    paramBundle = k.cvq();
    str = m.aaw("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
    paramBundle.ssid = ay.iA(aj.getContext());
    paramBundle.bssid = ay.iB(aj.getContext());
    paramBundle.ddV = str;
    paramBundle.ddU = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.rfK = this.dlB;
    paramBundle.nSA = m.ai(getIntent());
    paramBundle.rfL = m.ak(getIntent());
    paramBundle.rfM = k.b.rfY.rgx;
    paramBundle.rfN = k.b.rfY.name;
    paramBundle.channel = m.al(getIntent());
    paramBundle.rfO = this.dkB;
    paramBundle.cvs().cvr();
    AppMethodBeat.o(25159);
  }
  
  @TargetApi(11)
  public void onDestroy()
  {
    AppMethodBeat.i(25160);
    super.onDestroy();
    az.aeS().b(1703, this);
    AppMethodBeat.o(25160);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25165);
    String str = (String)paramMenu.getItem(0).getTitle();
    if (!getString(2131759631).equals(str)) {
      addTextOptionMenu(0, getString(2131759631), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(25158);
          FreeWifiSuccWebViewUI.this.finish();
          FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
          AppMethodBeat.o(25158);
          return true;
        }
      }, null, r.b.FOG);
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(25165);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25166);
    ad.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    az.aeS().b(1703, this);
    AppMethodBeat.o(25166);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI
 * JD-Core Version:    0.7.0.1
 */