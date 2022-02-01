package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public class FreeWifiActivateAuthStateUI
  extends FreeWifiActivateStateUI
{
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(24965);
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.ajQ(this.ssid)))
    {
      cSf();
      cSh();
    }
    AppMethodBeat.o(24965);
  }
  
  protected final void aTT()
  {
    AppMethodBeat.i(24966);
    j.cRE().a(this.ssid, new g.b()
    {
      public final void dC(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(24961);
        String str = d.cRn();
        ad.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramAnonymousString, FreeWifiActivateAuthStateUI.this.omw, str });
        if (!bt.isNullOrNil(paramAnonymousString)) {
          new com.tencent.mm.plugin.freewifi.d.a(FreeWifiActivateAuthStateUI.this.omw, FreeWifiActivateAuthStateUI.this.ssid, str, FreeWifiActivateAuthStateUI.this.toV, paramAnonymousString, "", paramAnonymousInt, m.ao(FreeWifiActivateAuthStateUI.this.getIntent())).c(new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(24960);
              ad.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              FreeWifiActivateAuthStateUI.this.toX = false;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2String = ((com.tencent.mm.plugin.freewifi.d.a)paramAnonymous2n).cRH();
                ad.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", new Object[] { paramAnonymous2String });
                j.cRE().a(FreeWifiActivateAuthStateUI.this.ssid, paramAnonymous2String, FreeWifiActivateAuthStateUI.this.getIntent());
                AppMethodBeat.o(24960);
                return;
              }
              if (paramAnonymous2Int2 == -2014)
              {
                d.a(FreeWifiActivateAuthStateUI.this.ssid, -2014, FreeWifiActivateAuthStateUI.this.getIntent());
                AppMethodBeat.o(24960);
                return;
              }
              d.a(FreeWifiActivateAuthStateUI.this.ssid, 3, FreeWifiActivateAuthStateUI.this.getIntent());
              AppMethodBeat.o(24960);
            }
          });
        }
        AppMethodBeat.o(24961);
      }
    }, this.cSc, getIntent());
    AppMethodBeat.o(24966);
  }
  
  protected final void cSa()
  {
    AppMethodBeat.i(24967);
    cSe();
    d.ajR(this.ssid);
    AppMethodBeat.o(24967);
  }
  
  protected final int cSb()
  {
    AppMethodBeat.i(24968);
    j.cRy();
    int i = d.ajP(this.ssid);
    AppMethodBeat.o(24968);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24963);
    super.initView();
    this.toU = ((Button)findViewById(2131300737));
    this.toU.setOnClickListener(new FreeWifiActivateAuthStateUI.1(this));
    setMMTitle(2131759653);
    AppMethodBeat.o(24963);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24962);
    super.onCreate(paramBundle);
    if (this.dnh != 2) {
      d.a(this.ssid, 1, getIntent());
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
    AppMethodBeat.o(24962);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24964);
    super.onDestroy();
    AppMethodBeat.o(24964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI
 * JD-Core Version:    0.7.0.1
 */