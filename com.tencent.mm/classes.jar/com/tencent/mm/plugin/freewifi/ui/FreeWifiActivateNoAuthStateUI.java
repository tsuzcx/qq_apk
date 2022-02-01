package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ad;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI
  extends FreeWifiActivateStateUI
{
  private String dxJ;
  private int toO;
  private boolean toP;
  
  public void a(NetworkInfo.State paramState)
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.ajQ(this.ssid)))
    {
      cSf();
      this.toX = false;
      d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void aTT()
  {
    cSa();
  }
  
  protected final void cSa()
  {
    if (this.toX)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
      return;
    }
    this.toX = true;
    cSe();
    d.e(this.ssid, this.dxJ, this.toO, this.toP);
  }
  
  protected int cSb()
  {
    if (d.ajQ(this.ssid))
    {
      d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String cSc();
  
  public void initView()
  {
    super.initView();
    this.toU.setVisibility(0);
    setMMTitle(cSc());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.toO = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.dxJ = getIntent().getStringExtra("free_wifi_passowrd");
    this.toP = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    d.a(this.ssid, 1, getIntent());
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */