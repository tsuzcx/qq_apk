package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI
  extends FreeWifiActivateStateUI
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
    y.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
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
      y.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
      return;
    }
    this.kqM = true;
    aUR();
    d.c(this.ssid, this.foj, this.kqD, this.kqE);
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
    this.kqJ.setVisibility(0);
    setMMTitle(aUP());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.kqD = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.foj = getIntent().getStringExtra("free_wifi_passowrd");
    this.kqE = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    d.a(this.ssid, 1, getIntent());
    y.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */