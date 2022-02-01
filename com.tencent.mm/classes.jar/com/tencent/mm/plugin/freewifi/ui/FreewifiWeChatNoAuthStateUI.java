package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public class FreewifiWeChatNoAuthStateUI
  extends FreeWifiNoAuthStateUI
{
  private int dIX;
  private String wSW;
  private String wSX;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(25178);
    Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.axS(this.ssid)) && (this.wQQ))
    {
      dNT();
      this.wQQ = false;
      this.wSW = d.dNb();
      this.wSX = d.dNf();
      this.dIX = d.dNc();
      Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.dIX), this.wSW, this.wSX });
      new a(this.pFJ, this.wSW, this.wSX, this.dIX, this.channelId, m.aw(getIntent())).c(new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(25176);
          bg.azz().b(640, this);
          Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
            paramAnonymousString = ((a)paramAnonymousq).dNz();
            if (paramAnonymousString != null)
            {
              Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramAnonymousString.KGX, paramAnonymousString.oUJ, paramAnonymousString.UserName, Integer.valueOf(paramAnonymousString.KMt), paramAnonymousString.KMu, paramAnonymousString.keb });
              FreewifiWeChatNoAuthStateUI.this.dNI = paramAnonymousString.KGX;
              FreewifiWeChatNoAuthStateUI.this.wPA = paramAnonymousString.oUJ;
              FreewifiWeChatNoAuthStateUI.this.appUserName = paramAnonymousString.UserName;
              FreewifiWeChatNoAuthStateUI.this.wSD = paramAnonymousString.KMt;
              FreewifiWeChatNoAuthStateUI.this.wSE = paramAnonymousString.KMu;
              FreewifiWeChatNoAuthStateUI.this.signature = paramAnonymousString.keb;
              FreewifiWeChatNoAuthStateUI.this.wSF = paramAnonymousString.KMv;
            }
            d.a(FreewifiWeChatNoAuthStateUI.this.ssid, 2, FreewifiWeChatNoAuthStateUI.this.getIntent());
            AppMethodBeat.o(25176);
            return;
          }
          Log.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiWeChatNoAuthStateUI.a(FreewifiWeChatNoAuthStateUI.this)), FreewifiWeChatNoAuthStateUI.b(FreewifiWeChatNoAuthStateUI.this), FreewifiWeChatNoAuthStateUI.c(FreewifiWeChatNoAuthStateUI.this) });
          d.a(FreewifiWeChatNoAuthStateUI.this.ssid, -2014, FreewifiWeChatNoAuthStateUI.this.getIntent());
          d.axU(FreewifiWeChatNoAuthStateUI.c(FreewifiWeChatNoAuthStateUI.this));
          AppMethodBeat.o(25176);
        }
      });
    }
    AppMethodBeat.o(25178);
  }
  
  protected final int dNP()
  {
    AppMethodBeat.i(25180);
    j.dNm();
    int i = d.axR(this.ssid);
    Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(25180);
      return -2014;
    }
    AppMethodBeat.o(25180);
    return i;
  }
  
  protected final String dNQ()
  {
    AppMethodBeat.i(25177);
    String str = getString(2131760974);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */