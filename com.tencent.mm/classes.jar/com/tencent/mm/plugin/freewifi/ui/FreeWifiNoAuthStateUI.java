package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

@Deprecated
public abstract class FreeWifiNoAuthStateUI
  extends FreeWifiStateUI
{
  private String gFE;
  private boolean mMF = true;
  private int mMp;
  private boolean mMq;
  
  public void a(NetworkInfo.State paramState)
  {
    ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.OC(this.ssid)))
    {
      bBq();
      this.mMy = false;
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void arq()
  {
    bBl();
  }
  
  protected final void bBl()
  {
    if (this.mMy)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
      return;
    }
    this.mMy = true;
    bBp();
    int i = com.tencent.mm.plugin.freewifi.model.d.c(this.ssid, this.gFE, this.mMp, this.mMq);
    k.a locala = k.bAc();
    locala.ssid = this.ssid;
    locala.coX = this.coX;
    locala.kMp = m.U(getIntent());
    locala.mIE = m.W(getIntent());
    locala.mIF = k.b.mIQ.mJq;
    locala.mIG = k.b.mIQ.name;
    locala.result = i;
    locala.cCy = m.X(getIntent());
    locala.mIC = this.cwc;
    locala.mIH = this.cvr;
    locala.bAe().bAd();
  }
  
  protected int bBm()
  {
    if (com.tencent.mm.plugin.freewifi.model.d.OC(this.ssid))
    {
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String bBn();
  
  public void initView()
  {
    super.initView();
    setMMTitle(bBn());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mMp = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.gFE = getIntent().getStringExtra("free_wifi_passowrd");
    this.mMq = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
    ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
    }
    do
    {
      return;
      ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != -1));
    this.mMF = false;
    h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new FreeWifiNoAuthStateUI.2(this), new FreeWifiNoAuthStateUI.3(this));
  }
  
  public void onResume()
  {
    int j = 0;
    super.onResume();
    int i;
    if (this.mMF)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "check permission not passed!");
      }
      return;
      i = j;
      if (b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.agR())
        {
          h.a(this, getString(2131300538), getString(2131297087), getString(2131300996), getString(2131296888), false, new FreeWifiNoAuthStateUI.1(this), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */