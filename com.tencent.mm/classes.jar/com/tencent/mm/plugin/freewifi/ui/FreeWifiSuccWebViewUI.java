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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.s.b;

public class FreeWifiSuccWebViewUI
  extends WebViewUI
  implements g
{
  private int channel;
  private String dia;
  private String djj;
  private String signature;
  private String sre;
  private int suj;
  private String suk;
  private boolean suw = false;
  
  public final void bvh()
  {
    AppMethodBeat.i(25161);
    super.bvh();
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
    }, null, s.b.Hor);
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
    ac.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[] { str });
    getIntent().putExtra("rawUrl", str);
    getIntent().putExtra("showShare", false);
    super.onCreate(paramBundle);
    this.djj = getIntent().getStringExtra("free_wifi_appid");
    this.sre = getIntent().getStringExtra("free_wifi_app_nickname");
    this.dia = getIntent().getStringExtra("free_wifi_app_username");
    this.suj = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.suk = getIntent().getStringExtra("free_wifi_finish_url");
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    this.channel = m.am(getIntent());
    if (this.channel == 10)
    {
      paramBundle = ae.fJi.fIu;
      str = ae.bZ(getContext());
      if ((!m.cX(paramBundle)) && (!m.cX(str))) {
        this.suk = Uri.parse(this.suk).buildUpon().appendQueryParameter("manufacturer", str).appendQueryParameter("manufacturerUsername", paramBundle).toString();
      }
    }
    ac.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.djj, this.sre, this.dia, Integer.valueOf(this.suj), this.suk, this.signature });
    paramBundle = k.cIC();
    str = m.afo("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
    paramBundle.ssid = ax.iL(ai.getContext());
    paramBundle.bssid = ax.iM(ai.getContext());
    paramBundle.dbr = str;
    paramBundle.dbq = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.soC = this.djj;
    paramBundle.ovU = m.aj(getIntent());
    paramBundle.soD = m.al(getIntent());
    paramBundle.soE = k.b.soQ.spp;
    paramBundle.soF = k.b.soQ.name;
    paramBundle.channel = m.am(getIntent());
    paramBundle.soG = this.dia;
    paramBundle.cIE().cID();
    AppMethodBeat.o(25159);
  }
  
  @TargetApi(11)
  public void onDestroy()
  {
    AppMethodBeat.i(25160);
    super.onDestroy();
    az.agi().b(1703, this);
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
      }, null, s.b.Hor);
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(25165);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25166);
    ac.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    az.agi().b(1703, this);
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