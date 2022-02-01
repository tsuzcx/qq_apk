package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

@Deprecated
public class FreeWifiAuthStateUI
  extends FreeWifiStateUI
{
  private boolean rHi = true;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(24985);
    Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.axS(this.ssid)))
    {
      dNT();
      dNV();
    }
    AppMethodBeat.o(24985);
  }
  
  protected final void bpf()
  {
    AppMethodBeat.i(24986);
    j.dNs().a(this.ssid, new g.b()
    {
      public final void dV(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(24979);
        String str = com.tencent.mm.plugin.freewifi.model.d.dNb();
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramAnonymousString, FreeWifiAuthStateUI.this.pFJ, str });
        if (!Util.isNullOrNil(paramAnonymousString)) {
          new com.tencent.mm.plugin.freewifi.d.a(FreeWifiAuthStateUI.this.pFJ, FreeWifiAuthStateUI.this.ssid, str, FreeWifiAuthStateUI.this.wQO, paramAnonymousString, "", paramAnonymousInt, m.aw(FreeWifiAuthStateUI.this.getIntent())).c(new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(24978);
              Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              FreeWifiAuthStateUI.this.wQQ = false;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2q = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymous2q;
                paramAnonymous2String = paramAnonymous2q.dNv();
                Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[] { paramAnonymous2String });
                paramAnonymous2q = paramAnonymous2q.dNz();
                if (paramAnonymous2q != null)
                {
                  Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramAnonymous2q.KGX, paramAnonymous2q.oUJ, paramAnonymous2q.UserName, Integer.valueOf(paramAnonymous2q.KMt), paramAnonymous2q.KMu, paramAnonymous2q.keb });
                  FreeWifiAuthStateUI.this.dNI = paramAnonymous2q.KGX;
                  FreeWifiAuthStateUI.this.wPA = paramAnonymous2q.oUJ;
                  FreeWifiAuthStateUI.this.appUserName = paramAnonymous2q.UserName;
                  FreeWifiAuthStateUI.this.wSD = paramAnonymous2q.KMt;
                  FreeWifiAuthStateUI.this.wSE = paramAnonymous2q.KMu;
                  FreeWifiAuthStateUI.this.signature = paramAnonymous2q.keb;
                  FreeWifiAuthStateUI.this.wSF = paramAnonymous2q.KMv;
                }
                j.dNs().a(FreeWifiAuthStateUI.this.ssid, paramAnonymous2String, FreeWifiAuthStateUI.this.getIntent());
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
    }, this.channelId, getIntent());
    AppMethodBeat.o(24986);
  }
  
  protected final void dNO()
  {
    AppMethodBeat.i(24988);
    dNS();
    com.tencent.mm.plugin.freewifi.model.d.axT(this.ssid);
    AppMethodBeat.o(24988);
  }
  
  protected final int dNP()
  {
    AppMethodBeat.i(24989);
    j.dNm();
    int i = com.tencent.mm.plugin.freewifi.model.d.axR(this.ssid);
    AppMethodBeat.o(24989);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24982);
    super.initView();
    setMMTitle(2131760974);
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
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(24987);
      return;
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
        this.rHi = false;
      }
    }
  }
  
  public void onResume()
  {
    int j = 0;
    AppMethodBeat.i(24983);
    super.onResume();
    int i;
    if (this.rHi)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_FINE_LOCATION", 77, null, null);
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "check permission not passed!");
      }
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
      AppMethodBeat.o(24983);
      return;
      i = j;
      if (b.n(this, "android.permission.ACCESS_FINE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.bcc())
        {
          h.a(this, getString(2131761461), getString(2131755998), getString(2131762043), getString(2131755761), false, new FreeWifiAuthStateUI.2(this), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI
 * JD-Core Version:    0.7.0.1
 */