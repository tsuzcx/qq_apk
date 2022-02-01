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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.t.b;

public class FreeWifiSuccWebViewUI
  extends WebViewUI
  implements i
{
  private String appUserName;
  private int channel;
  private String dNI;
  private String signature;
  private String wPA;
  private int wSD;
  private String wSE;
  private boolean wSP = false;
  
  public final void bXg()
  {
    AppMethodBeat.i(25161);
    super.bXg();
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
    addTextOptionMenu(0, getString(2131760952), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25157);
        FreeWifiSuccWebViewUI.this.finish();
        FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
        AppMethodBeat.o(25157);
        return true;
      }
    }, null, t.b.OGZ);
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
    Log.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[] { str });
    getIntent().putExtra("rawUrl", str);
    getIntent().putExtra("showShare", false);
    super.onCreate(paramBundle);
    this.dNI = getIntent().getStringExtra("free_wifi_appid");
    this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
    this.appUserName = getIntent().getStringExtra("free_wifi_app_username");
    this.wSD = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.wSE = getIntent().getStringExtra("free_wifi_finish_url");
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    this.channel = m.az(getIntent());
    if (this.channel == 10)
    {
      paramBundle = ae.gKy.gJB;
      str = ae.cu(getContext());
      if ((!m.eP(paramBundle)) && (!m.eP(str))) {
        this.wSE = Uri.parse(this.wSE).buildUpon().appendQueryParameter("manufacturer", str).appendQueryParameter("manufacturerUsername", paramBundle).toString();
      }
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.dNI, this.wPA, this.appUserName, Integer.valueOf(this.wSD), this.wSE, this.signature });
    paramBundle = k.dMF();
    str = m.axO("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
    paramBundle.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
    paramBundle.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
    paramBundle.dFe = str;
    paramBundle.dFd = getIntent().getStringExtra("free_wifi_ap_key");
    paramBundle.wNb = this.dNI;
    paramBundle.quX = m.aw(getIntent());
    paramBundle.wNc = m.ay(getIntent());
    paramBundle.wNd = k.b.wNp.wNO;
    paramBundle.wNe = k.b.wNp.name;
    paramBundle.channel = m.az(getIntent());
    paramBundle.wNf = this.appUserName;
    paramBundle.dMH().dMG();
    AppMethodBeat.o(25159);
  }
  
  @TargetApi(11)
  public void onDestroy()
  {
    AppMethodBeat.i(25160);
    super.onDestroy();
    bg.azz().b(1703, this);
    AppMethodBeat.o(25160);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25165);
    String str = (String)paramMenu.getItem(0).getTitle();
    if (!getString(2131760952).equals(str)) {
      addTextOptionMenu(0, getString(2131760952), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(25158);
          FreeWifiSuccWebViewUI.this.finish();
          FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
          AppMethodBeat.o(25158);
          return true;
        }
      }, null, t.b.OGZ);
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(25165);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25166);
    Log.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    bg.azz().b(1703, this);
    AppMethodBeat.o(25166);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI
 * JD-Core Version:    0.7.0.1
 */