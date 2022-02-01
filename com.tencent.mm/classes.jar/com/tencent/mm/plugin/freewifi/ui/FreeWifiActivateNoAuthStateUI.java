package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ac;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI
  extends FreeWifiActivateStateUI
{
  private String dlV;
  private int ssm;
  private boolean ssn;
  
  public void a(NetworkInfo.State paramState)
  {
    ac.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.afs(this.ssid)))
    {
      cJQ();
      this.ssv = false;
      d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void aQH()
  {
    cJL();
  }
  
  protected final void cJL()
  {
    if (this.ssv)
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
      return;
    }
    this.ssv = true;
    cJP();
    d.e(this.ssid, this.dlV, this.ssm, this.ssn);
  }
  
  protected int cJM()
  {
    if (d.afs(this.ssid))
    {
      d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String cJN();
  
  public void initView()
  {
    super.initView();
    this.sss.setVisibility(0);
    setMMTitle(cJN());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ssm = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.dlV = getIntent().getStringExtra("free_wifi_passowrd");
    this.ssn = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    d.a(this.ssid, 1, getIntent());
    ac.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
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