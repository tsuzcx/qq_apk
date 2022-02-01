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
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI
  extends FreeWifiActivateNoAuthStateUI
{
  private int dIX;
  private String wSW;
  private String wSX;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(25173);
    Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.axS(this.ssid)) && (this.wQQ))
    {
      dNT();
      this.wQQ = false;
      this.wSW = d.dNb();
      this.wSX = d.dNf();
      this.dIX = d.dNc();
      Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(this.dIX), this.wSW, this.wSX });
      new a(this.pFJ, this.wSW, this.wSX, this.dIX, this.channelId, m.aw(getIntent())).c(new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(25171);
          bg.azz().b(640, this);
          Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
            d.a(FreewifiActivateWeChatNoAuthStateUI.this.ssid, 2, FreewifiActivateWeChatNoAuthStateUI.this.getIntent());
            AppMethodBeat.o(25171);
            return;
          }
          Log.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.a(FreewifiActivateWeChatNoAuthStateUI.this)), FreewifiActivateWeChatNoAuthStateUI.b(FreewifiActivateWeChatNoAuthStateUI.this), FreewifiActivateWeChatNoAuthStateUI.c(FreewifiActivateWeChatNoAuthStateUI.this) });
          FreewifiActivateWeChatNoAuthStateUI.this.GE(-2014);
          d.axU(FreewifiActivateWeChatNoAuthStateUI.c(FreewifiActivateWeChatNoAuthStateUI.this));
          AppMethodBeat.o(25171);
        }
      });
    }
    AppMethodBeat.o(25173);
  }
  
  protected final int dNP()
  {
    AppMethodBeat.i(25175);
    j.dNm();
    int i = d.axR(this.ssid);
    Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(25175);
      return -2014;
    }
    AppMethodBeat.o(25175);
    return i;
  }
  
  protected final String dNQ()
  {
    AppMethodBeat.i(25172);
    String str = getString(2131760974);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */