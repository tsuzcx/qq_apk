package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public class FreewifiWeChatNoAuthStateUI
  extends FreeWifiNoAuthStateUI
{
  private int csT;
  private String mOR;
  private String mOS;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(21118);
    ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.OC(this.ssid)) && (this.mMy))
    {
      bBq();
      this.mMy = false;
      this.mOR = d.bAy();
      this.mOS = d.bAC();
      this.csT = d.bAz();
      ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.csT), this.mOR, this.mOS });
      new a(this.kdt, this.mOR, this.mOS, this.csT, this.bWu, m.U(getIntent())).c(new FreewifiWeChatNoAuthStateUI.1(this));
    }
    AppMethodBeat.o(21118);
  }
  
  protected final int bBm()
  {
    AppMethodBeat.i(21120);
    j.bAJ();
    int i = d.OB(this.ssid);
    ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(21120);
      return -2014;
    }
    AppMethodBeat.o(21120);
    return i;
  }
  
  protected final String bBn()
  {
    AppMethodBeat.i(21117);
    String str = getString(2131300181);
    AppMethodBeat.o(21117);
    return str;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21119);
    super.onDestroy();
    AppMethodBeat.o(21119);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */