package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ae;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI
  extends FreeWifiActivateNoAuthStateUI
{
  private int drL;
  private String tBV;
  private String tBW;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(25173);
    ae.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.akO(this.ssid)) && (this.tzO))
    {
      cUK();
      this.tzO = false;
      this.tBV = d.cTS();
      this.tBW = d.cTW();
      this.drL = d.cTT();
      ae.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.drL), this.tBV, this.tBW });
      new a(this.osm, this.tBV, this.tBW, this.drL, this.cSM, m.ap(getIntent())).c(new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(25171);
          bc.ajj().b(640, this);
          ae.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            ae.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
            d.a(FreewifiActivateWeChatNoAuthStateUI.this.ssid, 2, FreewifiActivateWeChatNoAuthStateUI.this.getIntent());
            AppMethodBeat.o(25171);
            return;
          }
          ae.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.a(FreewifiActivateWeChatNoAuthStateUI.this)), FreewifiActivateWeChatNoAuthStateUI.b(FreewifiActivateWeChatNoAuthStateUI.this), FreewifiActivateWeChatNoAuthStateUI.c(FreewifiActivateWeChatNoAuthStateUI.this) });
          FreewifiActivateWeChatNoAuthStateUI.this.CT(-2014);
          d.akQ(FreewifiActivateWeChatNoAuthStateUI.c(FreewifiActivateWeChatNoAuthStateUI.this));
          AppMethodBeat.o(25171);
        }
      });
    }
    AppMethodBeat.o(25173);
  }
  
  protected final int cUG()
  {
    AppMethodBeat.i(25175);
    j.cUd();
    int i = d.akN(this.ssid);
    ae.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(25175);
      return -2014;
    }
    AppMethodBeat.o(25175);
    return i;
  }
  
  protected final String cUH()
  {
    AppMethodBeat.i(25172);
    String str = getString(2131759653);
    AppMethodBeat.o(25172);
    return str;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25174);
    super.onDestroy();
    AppMethodBeat.o(25174);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */