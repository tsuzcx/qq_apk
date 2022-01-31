package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI
  extends FreeWifiActivateStateUI
{
  private String gFE;
  private int mMp;
  private boolean mMq;
  
  public void a(NetworkInfo.State paramState)
  {
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.OC(this.ssid)))
    {
      bBq();
      this.mMy = false;
      d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void arq()
  {
    bBl();
  }
  
  protected final void bBl()
  {
    if (this.mMy)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
      return;
    }
    this.mMy = true;
    bBp();
    d.c(this.ssid, this.gFE, this.mMp, this.mMq);
  }
  
  protected int bBm()
  {
    if (d.OC(this.ssid))
    {
      d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String bBn();
  
  public void initView()
  {
    super.initView();
    this.mMv.setVisibility(0);
    setMMTitle(bBn());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mMp = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.gFE = getIntent().getStringExtra("free_wifi_passowrd");
    this.mMq = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    d.a(this.ssid, 1, getIntent());
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */