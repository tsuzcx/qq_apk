package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.a;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

@Deprecated
public class FreeWifiAuthStateUI
  extends FreeWifiStateUI
{
  private boolean mMF = true;
  
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(20915);
    ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.OC(this.ssid)))
    {
      bBq();
      bBs();
    }
    AppMethodBeat.o(20915);
  }
  
  protected final void arq()
  {
    AppMethodBeat.i(20916);
    j.bAP().a(this.ssid, new FreeWifiAuthStateUI.1(this), this.bWu, getIntent());
    AppMethodBeat.o(20916);
  }
  
  protected final void bBl()
  {
    AppMethodBeat.i(20918);
    bBp();
    com.tencent.mm.plugin.freewifi.model.d.OD(this.ssid);
    AppMethodBeat.o(20918);
  }
  
  protected final int bBm()
  {
    AppMethodBeat.i(20919);
    j.bAJ();
    int i = com.tencent.mm.plugin.freewifi.model.d.OB(this.ssid);
    AppMethodBeat.o(20919);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20912);
    super.initView();
    setMMTitle(2131300181);
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
    AppMethodBeat.o(20912);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20911);
    super.onCreate(paramBundle);
    AppMethodBeat.o(20911);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20914);
    super.onDestroy();
    AppMethodBeat.o(20914);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(20917);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(20917);
      return;
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    if (paramArrayOfInt.length == 0)
    {
      AppMethodBeat.o(20917);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20917);
      return;
      if (paramArrayOfInt[0] != 0) {
        this.mMF = false;
      }
    }
  }
  
  public void onResume()
  {
    int j = 0;
    AppMethodBeat.i(20913);
    super.onResume();
    int i;
    if (this.mMF)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "check permission not passed!");
      }
      ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
      AppMethodBeat.o(20913);
      return;
      i = j;
      if (b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.agR())
        {
          h.a(this, getString(2131300538), getString(2131297087), getString(2131300996), getString(2131296888), false, new FreeWifiAuthStateUI.2(this), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI
 * JD-Core Version:    0.7.0.1
 */