package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.y;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI
  extends FreeWifiActivateNoAuthStateUI
{
  private int bLz;
  private String ktd;
  private String kte;
  
  public final void a(NetworkInfo.State paramState)
  {
    y.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.Du(this.ssid)) && (this.kqM))
    {
      aUS();
      this.kqM = false;
      this.ktd = d.aTV();
      this.kte = d.aTX();
      this.bLz = d.aTW();
      y.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.bLz), this.ktd, this.kte });
      new a(this.kpt, this.ktd, this.kte, this.bLz, this.bvj, m.B(getIntent())).b(new FreewifiActivateWeChatNoAuthStateUI.1(this));
    }
  }
  
  protected final int aUO()
  {
    j.aUh();
    int j = d.Dt(this.ssid);
    y.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j == 0) {
      i = -2014;
    }
    return i;
  }
  
  protected final String aUP()
  {
    return getString(R.l.free_wifi_title);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */