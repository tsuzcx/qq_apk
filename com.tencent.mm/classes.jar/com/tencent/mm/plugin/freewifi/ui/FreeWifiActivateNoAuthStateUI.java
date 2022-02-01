package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI
  extends FreeWifiActivateStateUI
{
  private String dQC;
  private int wQH;
  private boolean wQI;
  
  public void a(NetworkInfo.State paramState)
  {
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.axS(this.ssid)))
    {
      dNT();
      this.wQQ = false;
      d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void bpf()
  {
    dNO();
  }
  
  protected final void dNO()
  {
    if (this.wQQ)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
      return;
    }
    this.wQQ = true;
    dNS();
    d.d(this.ssid, this.dQC, this.wQH, this.wQI);
  }
  
  protected int dNP()
  {
    if (d.axS(this.ssid))
    {
      d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String dNQ();
  
  public void initView()
  {
    super.initView();
    this.wQN.setVisibility(0);
    setMMTitle(dNQ());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.wQH = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.dQC = getIntent().getStringExtra("free_wifi_passowrd");
    this.wQI = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    d.a(this.ssid, 1, getIntent());
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */