package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;

@Deprecated
public class FreeWifiAuthStateUI
  extends FreeWifiStateUI
{
  private boolean pFR = true;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(24985);
    ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.afs(this.ssid)))
    {
      cJQ();
      cJS();
    }
    AppMethodBeat.o(24985);
  }
  
  protected final void aQH()
  {
    AppMethodBeat.i(24986);
    j.cJp().a(this.ssid, new g.b()
    {
      public final void dm(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(24979);
        String str = com.tencent.mm.plugin.freewifi.model.d.cIY();
        ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramAnonymousString, FreeWifiAuthStateUI.this.nJQ, str });
        if (!bs.isNullOrNil(paramAnonymousString)) {
          new com.tencent.mm.plugin.freewifi.d.a(FreeWifiAuthStateUI.this.nJQ, FreeWifiAuthStateUI.this.ssid, str, FreeWifiAuthStateUI.this.sst, paramAnonymousString, "", paramAnonymousInt, m.aj(FreeWifiAuthStateUI.this.getIntent())).c(new g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(24978);
              ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              FreeWifiAuthStateUI.this.ssv = false;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2n = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymous2n;
                paramAnonymous2String = paramAnonymous2n.cJs();
                ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[] { paramAnonymous2String });
                paramAnonymous2n = paramAnonymous2n.cJw();
                if (paramAnonymous2n != null)
                {
                  ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramAnonymous2n.DPF, paramAnonymous2n.ndW, paramAnonymous2n.ncR, Integer.valueOf(paramAnonymous2n.DUS), paramAnonymous2n.DUT, paramAnonymous2n.iJW });
                  FreeWifiAuthStateUI.this.djj = paramAnonymous2n.DPF;
                  FreeWifiAuthStateUI.this.sre = paramAnonymous2n.ndW;
                  FreeWifiAuthStateUI.this.dia = paramAnonymous2n.ncR;
                  FreeWifiAuthStateUI.this.suj = paramAnonymous2n.DUS;
                  FreeWifiAuthStateUI.this.suk = paramAnonymous2n.DUT;
                  FreeWifiAuthStateUI.this.signature = paramAnonymous2n.iJW;
                  FreeWifiAuthStateUI.this.sul = paramAnonymous2n.DUU;
                }
                j.cJp().a(FreeWifiAuthStateUI.this.ssid, paramAnonymous2String, FreeWifiAuthStateUI.this.getIntent());
                AppMethodBeat.o(24978);
                return;
              }
              if (paramAnonymous2Int2 == -2014)
              {
                com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiAuthStateUI.this.ssid, -2014, FreeWifiAuthStateUI.this.getIntent());
                AppMethodBeat.o(24978);
                return;
              }
              com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiAuthStateUI.this.ssid, 3, FreeWifiAuthStateUI.this.getIntent());
              AppMethodBeat.o(24978);
            }
          });
        }
        AppMethodBeat.o(24979);
      }
    }, this.cGY, getIntent());
    AppMethodBeat.o(24986);
  }
  
  protected final void cJL()
  {
    AppMethodBeat.i(24988);
    cJP();
    com.tencent.mm.plugin.freewifi.model.d.aft(this.ssid);
    AppMethodBeat.o(24988);
  }
  
  protected final int cJM()
  {
    AppMethodBeat.i(24989);
    j.cJj();
    int i = com.tencent.mm.plugin.freewifi.model.d.afr(this.ssid);
    AppMethodBeat.o(24989);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24982);
    super.initView();
    setMMTitle(2131759653);
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
    AppMethodBeat.o(24982);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24981);
    super.onCreate(paramBundle);
    AppMethodBeat.o(24981);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24984);
    super.onDestroy();
    AppMethodBeat.o(24984);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(24987);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(24987);
      return;
    }
    ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    if (paramArrayOfInt.length == 0)
    {
      AppMethodBeat.o(24987);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24987);
      return;
      if (paramArrayOfInt[0] != 0) {
        this.pFR = false;
      }
    }
  }
  
  public void onResume()
  {
    int j = 0;
    AppMethodBeat.i(24983);
    super.onResume();
    int i;
    if (this.pFR)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "check permission not passed!");
      }
      ac.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
      AppMethodBeat.o(24983);
      return;
      i = j;
      if (b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.aEM())
        {
          h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new FreeWifiAuthStateUI.2(this), null);
          i = j;
        }
        else
        {
          i = 1;
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI
 * JD-Core Version:    0.7.0.1
 */