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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.s.b;

public class FreeWifiSuccWebViewUI
  extends WebViewUI
  implements f
{
  private int channel;
  private String duJ;
  private String dwb;
  private String signature;
  private int tBC;
  private String tBD;
  private boolean tBO = false;
  private String tyx;
  
  public final void bAi()
  {
    AppMethodBeat.i(25161);
    super.bAi();
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
    }, null, s.b.JwF);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[] { str });
    getIntent().putExtra("rawUrl", str);
    getIntent().putExtra("showShare", false);
    super.onCreate(paramBundle);
    this.dwb = getIntent().getStringExtra("free_wifi_appid");
    this.tyx = getIntent().getStringExtra("free_wifi_app_nickname");
    this.duJ = getIntent().getStringExtra("free_wifi_app_username");
    this.tBC = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.tBD = getIntent().getStringExtra("free_wifi_finish_url");
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    this.channel = m.as(getIntent());
    if (this.channel == 10)
    {
      paramBundle = com.tencent.mm.compatible.deviceinfo.ae.geR.gec;
      str = com.tencent.mm.compatible.deviceinfo.ae.bZ(getContext());
      if ((!m.ef(paramBundle)) && (!m.ef(str))) {
        this.tBD = Uri.parse(this.tBD).buildUpon().appendQueryParameter("manufacturer", str).appendQueryParameter("manufacturerUsername", paramBundle).toString();
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.dwb, this.tyx, this.duJ, Integer.valueOf(this.tBC), this.tBD, this.signature });
    paramBundle = k.cTw();
    str = m.akK("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
    paramBundle.ssid = az.ja(ak.getContext());
    paramBundle.bssid = az.jb(ak.getContext());
    paramBundle.dnP = str;
    paramBundle.dnO = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.tvX = this.dwb;
    paramBundle.pfT = m.ap(getIntent());
    paramBundle.tvY = m.ar(getIntent());
    paramBundle.tvZ = k.b.twl.twK;
    paramBundle.twa = k.b.twl.name;
    paramBundle.channel = m.as(getIntent());
    paramBundle.twb = this.duJ;
    paramBundle.cTy().cTx();
    AppMethodBeat.o(25159);
  }
  
  @TargetApi(11)
  public void onDestroy()
  {
    AppMethodBeat.i(25160);
    super.onDestroy();
    bc.ajj().b(1703, this);
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
      }, null, s.b.JwF);
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(25165);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25166);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    bc.ajj().b(1703, this);
    AppMethodBeat.o(25166);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI
 * JD-Core Version:    0.7.0.1
 */