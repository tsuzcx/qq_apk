package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.model.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.y;

@Deprecated
public class FreeWifiAuthStateUI
  extends FreeWifiStateUI
{
  protected final void XJ()
  {
    j.aUn().a(this.ssid, new FreeWifiAuthStateUI.1(this), this.bvj, getIntent());
  }
  
  public final void a(NetworkInfo.State paramState)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
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
    setMMTitle(R.l.free_wifi_title);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d.a(this.ssid, 4, getIntent());
    y.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI
 * JD-Core Version:    0.7.0.1
 */