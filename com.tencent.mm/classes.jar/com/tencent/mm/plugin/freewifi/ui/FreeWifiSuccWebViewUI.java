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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.s.b;

public class FreeWifiSuccWebViewUI
  extends WebViewUI
  implements f
{
  private int channel;
  private String dtE;
  private String duW;
  private String signature;
  private String tnF;
  private int tqL;
  private String tqM;
  private boolean tqX = false;
  
  public final void bzn()
  {
    AppMethodBeat.i(25161);
    super.bzn();
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
    }, null, s.b.JbX);
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
    this.duW = getIntent().getStringExtra("free_wifi_appid");
    this.tnF = getIntent().getStringExtra("free_wifi_app_nickname");
    this.dtE = getIntent().getStringExtra("free_wifi_app_username");
    this.tqL = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.tqM = getIntent().getStringExtra("free_wifi_finish_url");
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    this.channel = m.ar(getIntent());
    if (this.channel == 10)
    {
      paramBundle = ae.gcJ.gbU;
      str = ae.bX(getContext());
      if ((!m.ea(paramBundle)) && (!m.ea(str))) {
        this.tqM = Uri.parse(this.tqM).buildUpon().appendQueryParameter("manufacturer", str).appendQueryParameter("manufacturerUsername", paramBundle).toString();
      }
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.duW, this.tnF, this.dtE, Integer.valueOf(this.tqL), this.tqM, this.signature });
    paramBundle = k.cQR();
    str = m.ajM("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
    paramBundle.ssid = ay.iV(aj.getContext());
    paramBundle.bssid = ay.iW(aj.getContext());
    paramBundle.dmN = str;
    paramBundle.dmM = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.tlf = this.duW;
    paramBundle.oZp = m.ao(getIntent());
    paramBundle.tlg = m.aq(getIntent());
    paramBundle.tlh = k.b.tlt.tlS;
    paramBundle.tli = k.b.tlt.name;
    paramBundle.channel = m.ar(getIntent());
    paramBundle.tlj = this.dtE;
    paramBundle.cQT().cQS();
    AppMethodBeat.o(25159);
  }
  
  @TargetApi(11)
  public void onDestroy()
  {
    AppMethodBeat.i(25160);
    super.onDestroy();
    ba.aiU().b(1703, this);
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
      }, null, s.b.JbX);
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(25165);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25166);
    ad.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ba.aiU().b(1703, this);
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