package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ae;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI
  extends FreeWifiActivateStateUI
{
  private String dyO;
  private int tzF;
  private boolean tzG;
  
  public void a(NetworkInfo.State paramState)
  {
    ae.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.akO(this.ssid)))
    {
      cUK();
      this.tzO = false;
      d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void aUs()
  {
    cUF();
  }
  
  protected final void cUF()
  {
    if (this.tzO)
    {
      ae.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
      return;
    }
    this.tzO = true;
    cUJ();
    d.e(this.ssid, this.dyO, this.tzF, this.tzG);
  }
  
  protected int cUG()
  {
    if (d.akO(this.ssid))
    {
      d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String cUH();
  
  public void initView()
  {
    super.initView();
    this.tzL.setVisibility(0);
    setMMTitle(cUH());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.tzF = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.dyO = getIntent().getStringExtra("free_wifi_passowrd");
    this.tzG = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    d.a(this.ssid, 1, getIntent());
    ae.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */