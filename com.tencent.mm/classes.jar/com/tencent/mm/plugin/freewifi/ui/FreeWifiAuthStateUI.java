package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;

@Deprecated
public class FreeWifiAuthStateUI
  extends FreeWifiStateUI
{
  private boolean qjw = true;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(24985);
    ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.ajQ(this.ssid)))
    {
      cSf();
      cSh();
    }
    AppMethodBeat.o(24985);
  }
  
  protected final void aTT()
  {
    AppMethodBeat.i(24986);
    j.cRE().a(this.ssid, new g.b()
    {
      public final void dC(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(24979);
        String str = com.tencent.mm.plugin.freewifi.model.d.cRn();
        ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramAnonymousString, FreeWifiAuthStateUI.this.omw, str });
        if (!bt.isNullOrNil(paramAnonymousString)) {
          new com.tencent.mm.plugin.freewifi.d.a(FreeWifiAuthStateUI.this.omw, FreeWifiAuthStateUI.this.ssid, str, FreeWifiAuthStateUI.this.toV, paramAnonymousString, "", paramAnonymousInt, m.ao(FreeWifiAuthStateUI.this.getIntent())).c(new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(24978);
              ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              FreeWifiAuthStateUI.this.toX = false;
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2n = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymous2n;
                paramAnonymous2String = paramAnonymous2n.cRH();
                ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[] { paramAnonymous2String });
                paramAnonymous2n = paramAnonymous2n.cRL();
                if (paramAnonymous2n != null)
                {
                  ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramAnonymous2n.FuU, paramAnonymous2n.nEt, paramAnonymous2n.nDo, Integer.valueOf(paramAnonymous2n.FAn), paramAnonymous2n.FAo, paramAnonymous2n.jdf });
                  FreeWifiAuthStateUI.this.duW = paramAnonymous2n.FuU;
                  FreeWifiAuthStateUI.this.tnF = paramAnonymous2n.nEt;
                  FreeWifiAuthStateUI.this.dtE = paramAnonymous2n.nDo;
                  FreeWifiAuthStateUI.this.tqL = paramAnonymous2n.FAn;
                  FreeWifiAuthStateUI.this.tqM = paramAnonymous2n.FAo;
                  FreeWifiAuthStateUI.this.signature = paramAnonymous2n.jdf;
                  FreeWifiAuthStateUI.this.tqN = paramAnonymous2n.FAp;
                }
                j.cRE().a(FreeWifiAuthStateUI.this.ssid, paramAnonymous2String, FreeWifiAuthStateUI.this.getIntent());
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
    }, this.cSc, getIntent());
    AppMethodBeat.o(24986);
  }
  
  protected final void cSa()
  {
    AppMethodBeat.i(24988);
    cSe();
    com.tencent.mm.plugin.freewifi.model.d.ajR(this.ssid);
    AppMethodBeat.o(24988);
  }
  
  protected final int cSb()
  {
    AppMethodBeat.i(24989);
    j.cRy();
    int i = com.tencent.mm.plugin.freewifi.model.d.ajP(this.ssid);
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
      ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(24987);
      return;
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
        this.qjw = false;
      }
    }
  }
  
  public void onResume()
  {
    int j = 0;
    AppMethodBeat.i(24983);
    super.onResume();
    int i;
    if (this.qjw)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "check permission not passed!");
      }
      ad.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
      AppMethodBeat.o(24983);
      return;
      i = j;
      if (b.n(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.aHR())
        {
          h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(24980);
              com.tencent.mm.modelgeo.d.cB(FreeWifiAuthStateUI.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI
 * JD-Core Version:    0.7.0.1
 */