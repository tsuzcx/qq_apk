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
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;

@Deprecated
public class FreewifiWeChatNoAuthStateUI
  extends FreeWifiNoAuthStateUI
{
  private int dqG;
  private String tre;
  private String trf;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(25178);
    ad.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.ajQ(this.ssid)) && (this.toX))
    {
      cSf();
      this.toX = false;
      this.tre = d.cRn();
      this.trf = d.cRr();
      this.dqG = d.cRo();
      ad.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.dqG), this.tre, this.trf });
      new a(this.omw, this.tre, this.trf, this.dqG, this.cSc, m.ao(getIntent())).c(new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(25176);
          ba.aiU().b(640, this);
          ad.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            ad.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
            paramAnonymousString = ((a)paramAnonymousn).cRL();
            if (paramAnonymousString != null)
            {
              ad.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramAnonymousString.FuU, paramAnonymousString.nEt, paramAnonymousString.nDo, Integer.valueOf(paramAnonymousString.FAn), paramAnonymousString.FAo, paramAnonymousString.jdf });
              FreewifiWeChatNoAuthStateUI.this.duW = paramAnonymousString.FuU;
              FreewifiWeChatNoAuthStateUI.this.tnF = paramAnonymousString.nEt;
              FreewifiWeChatNoAuthStateUI.this.dtE = paramAnonymousString.nDo;
              FreewifiWeChatNoAuthStateUI.this.tqL = paramAnonymousString.FAn;
              FreewifiWeChatNoAuthStateUI.this.tqM = paramAnonymousString.FAo;
              FreewifiWeChatNoAuthStateUI.this.signature = paramAnonymousString.jdf;
              FreewifiWeChatNoAuthStateUI.this.tqN = paramAnonymousString.FAp;
            }
            d.a(FreewifiWeChatNoAuthStateUI.this.ssid, 2, FreewifiWeChatNoAuthStateUI.this.getIntent());
            AppMethodBeat.o(25176);
            return;
          }
          ad.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiWeChatNoAuthStateUI.a(FreewifiWeChatNoAuthStateUI.this)), FreewifiWeChatNoAuthStateUI.b(FreewifiWeChatNoAuthStateUI.this), FreewifiWeChatNoAuthStateUI.c(FreewifiWeChatNoAuthStateUI.this) });
          d.a(FreewifiWeChatNoAuthStateUI.this.ssid, -2014, FreewifiWeChatNoAuthStateUI.this.getIntent());
          d.ajS(FreewifiWeChatNoAuthStateUI.c(FreewifiWeChatNoAuthStateUI.this));
          AppMethodBeat.o(25176);
        }
      });
    }
    AppMethodBeat.o(25178);
  }
  
  protected final int cSb()
  {
    AppMethodBeat.i(25180);
    j.cRy();
    int i = d.ajP(this.ssid);
    ad.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(25180);
      return -2014;
    }
    AppMethodBeat.o(25180);
    return i;
  }
  
  protected final String cSc()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */