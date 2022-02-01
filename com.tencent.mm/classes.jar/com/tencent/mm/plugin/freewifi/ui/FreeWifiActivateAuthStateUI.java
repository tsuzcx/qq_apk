package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public class FreeWifiActivateAuthStateUI
  extends FreeWifiActivateStateUI
{
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(24965);
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.axS(this.ssid)))
    {
      dNT();
      dNV();
    }
    AppMethodBeat.o(24965);
  }
  
  protected final void bpf()
  {
    AppMethodBeat.i(24966);
    j.dNs().a(this.ssid, new g.b()
    {
      public final void dV(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(24961);
        String str = d.dNb();
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramAnonymousString, FreeWifiActivateAuthStateUI.this.pFJ, str });
        if (!Util.isNullOrNil(paramAnonymousString)) {
          new com.tencent.mm.plugin.freewifi.d.a(FreeWifiActivateAuthStateUI.this.pFJ, FreeWifiActivateAuthStateUI.this.ssid, str, FreeWifiActivateAuthStateUI.this.wQO, paramAnonymousString, "", paramAnonymousInt, m.aw(FreeWifiActivateAuthStateUI.this.getIntent())).c(new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(24960);
              Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              FreeWifiActivateAuthStateUI.this.wQQ = false;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2String = ((com.tencent.mm.plugin.freewifi.d.a)paramAnonymous2q).dNv();
                Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", new Object[] { paramAnonymous2String });
                j.dNs().a(FreeWifiActivateAuthStateUI.this.ssid, paramAnonymous2String, FreeWifiActivateAuthStateUI.this.getIntent());
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
    }, this.channelId, getIntent());
    AppMethodBeat.o(24966);
  }
  
  protected final void dNO()
  {
    AppMethodBeat.i(24967);
    dNS();
    d.axT(this.ssid);
    AppMethodBeat.o(24967);
  }
  
  protected final int dNP()
  {
    AppMethodBeat.i(24968);
    j.dNm();
    int i = d.axR(this.ssid);
    AppMethodBeat.o(24968);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24963);
    super.initView();
    this.wQN = ((Button)findViewById(2131302321));
    this.wQN.setOnClickListener(new FreeWifiActivateAuthStateUI.1(this));
    setMMTitle(2131760974);
    AppMethodBeat.o(24963);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24962);
    super.onCreate(paramBundle);
    if (this.source != 2) {
      d.a(this.ssid, 1, getIntent());
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI
 * JD-Core Version:    0.7.0.1
 */