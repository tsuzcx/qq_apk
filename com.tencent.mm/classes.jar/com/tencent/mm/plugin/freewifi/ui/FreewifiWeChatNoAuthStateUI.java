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
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ae;

@Deprecated
public class FreewifiWeChatNoAuthStateUI
  extends FreeWifiNoAuthStateUI
{
  private int drL;
  private String tBV;
  private String tBW;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(25178);
    ae.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.akO(this.ssid)) && (this.tzO))
    {
      cUK();
      this.tzO = false;
      this.tBV = d.cTS();
      this.tBW = d.cTW();
      this.drL = d.cTT();
      ae.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.drL), this.tBV, this.tBW });
      new a(this.osm, this.tBV, this.tBW, this.drL, this.cSM, m.ap(getIntent())).c(new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(25176);
          bc.ajj().b(640, this);
          ae.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            ae.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
            paramAnonymousString = ((a)paramAnonymousn).cUq();
            if (paramAnonymousString != null)
            {
              ae.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramAnonymousString.FNs, paramAnonymousString.nJO, paramAnonymousString.nIJ, Integer.valueOf(paramAnonymousString.FSK), paramAnonymousString.FSL, paramAnonymousString.jfY });
              FreewifiWeChatNoAuthStateUI.this.dwb = paramAnonymousString.FNs;
              FreewifiWeChatNoAuthStateUI.this.tyx = paramAnonymousString.nJO;
              FreewifiWeChatNoAuthStateUI.this.duJ = paramAnonymousString.nIJ;
              FreewifiWeChatNoAuthStateUI.this.tBC = paramAnonymousString.FSK;
              FreewifiWeChatNoAuthStateUI.this.tBD = paramAnonymousString.FSL;
              FreewifiWeChatNoAuthStateUI.this.signature = paramAnonymousString.jfY;
              FreewifiWeChatNoAuthStateUI.this.tBE = paramAnonymousString.FSM;
            }
            d.a(FreewifiWeChatNoAuthStateUI.this.ssid, 2, FreewifiWeChatNoAuthStateUI.this.getIntent());
            AppMethodBeat.o(25176);
            return;
          }
          ae.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiWeChatNoAuthStateUI.a(FreewifiWeChatNoAuthStateUI.this)), FreewifiWeChatNoAuthStateUI.b(FreewifiWeChatNoAuthStateUI.this), FreewifiWeChatNoAuthStateUI.c(FreewifiWeChatNoAuthStateUI.this) });
          d.a(FreewifiWeChatNoAuthStateUI.this.ssid, -2014, FreewifiWeChatNoAuthStateUI.this.getIntent());
          d.akQ(FreewifiWeChatNoAuthStateUI.c(FreewifiWeChatNoAuthStateUI.this));
          AppMethodBeat.o(25176);
        }
      });
    }
    AppMethodBeat.o(25178);
  }
  
  protected final int cUG()
  {
    AppMethodBeat.i(25180);
    j.cUd();
    int i = d.akN(this.ssid);
    ae.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(25180);
      return -2014;
    }
    AppMethodBeat.o(25180);
    return i;
  }
  
  protected final String cUH()
  {
    AppMethodBeat.i(25177);
    String str = getString(2131759653);
    AppMethodBeat.o(25177);
    return str;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25179);
    super.onDestroy();
    AppMethodBeat.o(25179);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */