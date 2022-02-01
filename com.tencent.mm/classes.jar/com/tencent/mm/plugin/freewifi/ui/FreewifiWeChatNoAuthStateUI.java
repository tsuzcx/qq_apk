package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ac;

@Deprecated
public class FreewifiWeChatNoAuthStateUI
  extends FreeWifiNoAuthStateUI
{
  private int dfk;
  private String suD;
  private String suE;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(25178);
    ac.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.afs(this.ssid)) && (this.ssv))
    {
      cJQ();
      this.ssv = false;
      this.suD = d.cIY();
      this.suE = d.cJc();
      this.dfk = d.cIZ();
      ac.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.dfk), this.suD, this.suE });
      new a(this.nJQ, this.suD, this.suE, this.dfk, this.cGY, m.aj(getIntent())).c(new g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(25176);
          az.agi().b(640, this);
          ac.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            ac.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
            paramAnonymousString = ((a)paramAnonymousn).cJw();
            if (paramAnonymousString != null)
            {
              ac.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramAnonymousString.DPF, paramAnonymousString.ndW, paramAnonymousString.ncR, Integer.valueOf(paramAnonymousString.DUS), paramAnonymousString.DUT, paramAnonymousString.iJW });
              FreewifiWeChatNoAuthStateUI.this.djj = paramAnonymousString.DPF;
              FreewifiWeChatNoAuthStateUI.this.sre = paramAnonymousString.ndW;
              FreewifiWeChatNoAuthStateUI.this.dia = paramAnonymousString.ncR;
              FreewifiWeChatNoAuthStateUI.this.suj = paramAnonymousString.DUS;
              FreewifiWeChatNoAuthStateUI.this.suk = paramAnonymousString.DUT;
              FreewifiWeChatNoAuthStateUI.this.signature = paramAnonymousString.iJW;
              FreewifiWeChatNoAuthStateUI.this.sul = paramAnonymousString.DUU;
            }
            d.a(FreewifiWeChatNoAuthStateUI.this.ssid, 2, FreewifiWeChatNoAuthStateUI.this.getIntent());
            AppMethodBeat.o(25176);
            return;
          }
          ac.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiWeChatNoAuthStateUI.a(FreewifiWeChatNoAuthStateUI.this)), FreewifiWeChatNoAuthStateUI.b(FreewifiWeChatNoAuthStateUI.this), FreewifiWeChatNoAuthStateUI.c(FreewifiWeChatNoAuthStateUI.this) });
          d.a(FreewifiWeChatNoAuthStateUI.this.ssid, -2014, FreewifiWeChatNoAuthStateUI.this.getIntent());
          d.afu(FreewifiWeChatNoAuthStateUI.c(FreewifiWeChatNoAuthStateUI.this));
          AppMethodBeat.o(25176);
        }
      });
    }
    AppMethodBeat.o(25178);
  }
  
  protected final int cJM()
  {
    AppMethodBeat.i(25180);
    j.cJj();
    int i = d.afr(this.ssid);
    ac.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(25180);
      return -2014;
    }
    AppMethodBeat.o(25180);
    return i;
  }
  
  protected final String cJN()
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