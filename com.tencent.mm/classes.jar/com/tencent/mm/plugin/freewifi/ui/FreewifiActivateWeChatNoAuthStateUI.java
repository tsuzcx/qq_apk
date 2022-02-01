package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ad;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI
  extends FreeWifiActivateNoAuthStateUI
{
  private int dqG;
  private String tre;
  private String trf;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(25173);
    ad.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.ajQ(this.ssid)) && (this.toX))
    {
      cSf();
      this.toX = false;
      this.tre = d.cRn();
      this.trf = d.cRr();
      this.dqG = d.cRo();
      ad.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.dqG), this.tre, this.trf });
      new a(this.omw, this.tre, this.trf, this.dqG, this.cSc, m.ao(getIntent())).c(new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(25171);
          ba.aiU().b(640, this);
          ad.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            ad.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
            d.a(FreewifiActivateWeChatNoAuthStateUI.this.ssid, 2, FreewifiActivateWeChatNoAuthStateUI.this.getIntent());
            AppMethodBeat.o(25171);
            return;
          }
          ad.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.a(FreewifiActivateWeChatNoAuthStateUI.this)), FreewifiActivateWeChatNoAuthStateUI.b(FreewifiActivateWeChatNoAuthStateUI.this), FreewifiActivateWeChatNoAuthStateUI.c(FreewifiActivateWeChatNoAuthStateUI.this) });
          FreewifiActivateWeChatNoAuthStateUI.this.CH(-2014);
          d.ajS(FreewifiActivateWeChatNoAuthStateUI.c(FreewifiActivateWeChatNoAuthStateUI.this));
          AppMethodBeat.o(25171);
        }
      });
    }
    AppMethodBeat.o(25173);
  }
  
  protected final int cSb()
  {
    AppMethodBeat.i(25175);
    j.cRy();
    int i = d.ajP(this.ssid);
    ad.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(25175);
      return -2014;
    }
    AppMethodBeat.o(25175);
    return i;
  }
  
  protected final String cSc()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */