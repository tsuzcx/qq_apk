package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;

@Deprecated
public class FreeWifiAuthStateUI
  extends FreeWifiStateUI
{
  private boolean qqb = true;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(24985);
    ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.akO(this.ssid)))
    {
      cUK();
      cUM();
    }
    AppMethodBeat.o(24985);
  }
  
  protected final void aUs()
  {
    AppMethodBeat.i(24986);
    j.cUj().a(this.ssid, new g.b()
    {
      public final void dG(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(24979);
        String str = com.tencent.mm.plugin.freewifi.model.d.cTS();
        ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramAnonymousString, FreeWifiAuthStateUI.this.osm, str });
        if (!bu.isNullOrNil(paramAnonymousString)) {
          new com.tencent.mm.plugin.freewifi.d.a(FreeWifiAuthStateUI.this.osm, FreeWifiAuthStateUI.this.ssid, str, FreeWifiAuthStateUI.this.tzM, paramAnonymousString, "", paramAnonymousInt, m.ap(FreeWifiAuthStateUI.this.getIntent())).c(new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(24978);
              ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              FreeWifiAuthStateUI.this.tzO = false;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2n = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymous2n;
                paramAnonymous2String = paramAnonymous2n.cUm();
                ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[] { paramAnonymous2String });
                paramAnonymous2n = paramAnonymous2n.cUq();
                if (paramAnonymous2n != null)
                {
                  ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramAnonymous2n.FNs, paramAnonymous2n.nJO, paramAnonymous2n.nIJ, Integer.valueOf(paramAnonymous2n.FSK), paramAnonymous2n.FSL, paramAnonymous2n.jfY });
                  FreeWifiAuthStateUI.this.dwb = paramAnonymous2n.FNs;
                  FreeWifiAuthStateUI.this.tyx = paramAnonymous2n.nJO;
                  FreeWifiAuthStateUI.this.duJ = paramAnonymous2n.nIJ;
                  FreeWifiAuthStateUI.this.tBC = paramAnonymous2n.FSK;
                  FreeWifiAuthStateUI.this.tBD = paramAnonymous2n.FSL;
                  FreeWifiAuthStateUI.this.signature = paramAnonymous2n.jfY;
                  FreeWifiAuthStateUI.this.tBE = paramAnonymous2n.FSM;
                }
                j.cUj().a(FreeWifiAuthStateUI.this.ssid, paramAnonymous2String, FreeWifiAuthStateUI.this.getIntent());
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
    }, this.cSM, getIntent());
    AppMethodBeat.o(24986);
  }
  
  protected final void cUF()
  {
    AppMethodBeat.i(24988);
    cUJ();
    com.tencent.mm.plugin.freewifi.model.d.akP(this.ssid);
    AppMethodBeat.o(24988);
  }
  
  protected final int cUG()
  {
    AppMethodBeat.i(24989);
    j.cUd();
    int i = com.tencent.mm.plugin.freewifi.model.d.akN(this.ssid);
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
      ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(24987);
      return;
    }
    ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
        this.qqb = false;
      }
    }
  }
  
  public void onResume()
  {
    int j = 0;
    AppMethodBeat.i(24983);
    super.onResume();
    int i;
    if (this.qqb)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "check permission not passed!");
      }
      ae.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
      AppMethodBeat.o(24983);
      return;
      i = j;
      if (b.n(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.aIi())
        {
          h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(24980);
              com.tencent.mm.modelgeo.d.cD(FreeWifiAuthStateUI.this);
              AppMethodBeat.o(24980);
            }
          }, null);
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