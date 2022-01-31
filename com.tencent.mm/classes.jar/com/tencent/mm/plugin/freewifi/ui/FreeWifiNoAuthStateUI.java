package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

@Deprecated
public abstract class FreeWifiNoAuthStateUI
  extends FreeWifiStateUI
{
  private String foj;
  private int kqD;
  private boolean kqE;
  
  protected final void XJ()
  {
    aUN();
  }
  
  public void a(NetworkInfo.State paramState)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.Du(this.ssid)))
    {
      aUS();
      this.kqM = false;
      d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void aUN()
  {
    if (this.kqM)
    {
      y.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
      return;
    }
    this.kqM = true;
    aUR();
    int i = d.c(this.ssid, this.foj, this.kqD, this.kqE);
    k.a locala = k.aTx();
    locala.ssid = this.ssid;
    locala.bHI = this.bHI;
    locala.iGw = m.B(getIntent());
    locala.kmR = m.D(getIntent());
    locala.kmS = k.b.knd.knD;
    locala.kmT = k.b.knd.name;
    locala.result = i;
    locala.bUR = m.E(getIntent());
    locala.kmQ = this.bOL;
    locala.kmU = this.bNZ;
    locala.aTz().aTy();
  }
  
  protected int aUO()
  {
    if (d.Du(this.ssid))
    {
      d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String aUP();
  
  protected final void initView()
  {
    super.initView();
    setMMTitle(aUP());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.kqD = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.foj = getIntent().getStringExtra("free_wifi_passowrd");
    this.kqE = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    d.a(this.ssid, 4, getIntent());
    y.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */