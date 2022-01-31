package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.model.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.y;

@Deprecated
public class FreeWifiActivateAuthStateUI
  extends FreeWifiActivateStateUI
{
  protected final void XJ()
  {
    j.aUn().a(this.ssid, new FreeWifiActivateAuthStateUI.2(this), this.bvj, getIntent());
  }
  
  public final void a(NetworkInfo.State paramState)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.Du(this.ssid)))
    {
      aUS();
      aUU();
    }
  }
  
  protected final void aUN()
  {
    aUR();
    d.Dv(this.ssid);
  }
  
  protected final int aUO()
  {
    j.aUh();
    return d.Dt(this.ssid);
  }
  
  protected final void initView()
  {
    super.initView();
    this.kqJ = ((Button)findViewById(R.h.help_btn));
    this.kqJ.setOnClickListener(new FreeWifiActivateAuthStateUI.1(this));
    setMMTitle(R.l.free_wifi_title);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.source != 2) {
      d.a(this.ssid, 1, getIntent());
    }
    y.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI
 * JD-Core Version:    0.7.0.1
 */