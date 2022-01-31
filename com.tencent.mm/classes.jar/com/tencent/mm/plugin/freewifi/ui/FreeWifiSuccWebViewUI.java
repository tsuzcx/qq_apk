package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;

public class FreeWifiSuccWebViewUI
  extends WebViewUI
  implements f
{
  private String bNZ;
  private String bOL;
  private int bUR;
  private String kpv;
  private int ksJ;
  private String ksK;
  private boolean ksW = false;
  private String signature;
  
  protected final void aoX()
  {
    super.aoX();
  }
  
  public void finish()
  {
    super.finish();
  }
  
  protected final void initView()
  {
    super.initView();
    mT(false);
    a(0, getString(R.l.free_wifi_finish), new FreeWifiSuccWebViewUI.1(this), s.b.uNC);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.plugin.freewifi.j.userName = "";
    com.tencent.mm.plugin.freewifi.j.type = 0;
    String str = getIntent().getStringExtra("free_wifi_qinghuai_url");
    y.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[] { str });
    getIntent().putExtra("rawUrl", str);
    getIntent().putExtra("showShare", false);
    super.onCreate(paramBundle);
    this.bOL = getIntent().getStringExtra("free_wifi_appid");
    this.kpv = getIntent().getStringExtra("free_wifi_app_nickname");
    this.bNZ = getIntent().getStringExtra("free_wifi_app_username");
    this.ksJ = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
    this.ksK = getIntent().getStringExtra("free_wifi_finish_url");
    this.signature = getIntent().getStringExtra("free_wifi_signature");
    this.bUR = com.tencent.mm.plugin.freewifi.m.E(getIntent());
    if (this.bUR == 10)
    {
      paramBundle = q.dyi.dyE;
      str = q.bc(this.mController.uMN);
      if ((!com.tencent.mm.plugin.freewifi.m.isEmpty(paramBundle)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(str))) {
        this.ksK = Uri.parse(this.ksK).buildUpon().appendQueryParameter("manufacturer", str).appendQueryParameter("manufacturerUsername", paramBundle).toString();
      }
    }
    y.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[] { this.bOL, this.kpv, this.bNZ, Integer.valueOf(this.ksJ), this.ksK, this.signature });
    WifiInfo localWifiInfo = d.aTY();
    k.a locala = k.aTx();
    if (localWifiInfo != null)
    {
      str = localWifiInfo.getMacAddress();
      paramBundle = str;
      if (Build.VERSION.SDK_INT > 22) {
        if (str != null)
        {
          paramBundle = str;
          if (!str.equals("02:00:00:00:00:00")) {}
        }
        else
        {
          paramBundle = com.tencent.mm.plugin.freewifi.m.aTC();
        }
      }
      locala.ssid = com.tencent.mm.plugin.freewifi.m.Dm(localWifiInfo.getSSID());
      locala.bssid = localWifiInfo.getBSSID();
      locala.bHJ = paramBundle;
    }
    locala.bHI = getIntent().getStringExtra("free_wifi_ap_key");
    locala.kmQ = this.bOL;
    locala.iGw = com.tencent.mm.plugin.freewifi.m.B(getIntent());
    locala.kmR = com.tencent.mm.plugin.freewifi.m.D(getIntent());
    locala.kmS = k.b.kne.knD;
    locala.kmT = k.b.kne.name;
    locala.bUR = com.tencent.mm.plugin.freewifi.m.E(getIntent());
    locala.kmU = this.bNZ;
    locala.aTz().aTy();
  }
  
  @TargetApi(11)
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(1703, this);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    String str = (String)paramMenu.getItem(0).getTitle();
    if (!getString(R.l.free_wifi_finish).equals(str)) {
      a(0, getString(R.l.free_wifi_finish), new FreeWifiSuccWebViewUI.2(this), s.b.uNC);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    au.Dk().b(1703, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI
 * JD-Core Version:    0.7.0.1
 */