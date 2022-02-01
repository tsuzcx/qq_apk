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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

@Deprecated
public abstract class FreeWifiNoAuthStateUI
  extends FreeWifiStateUI
{
  private String dQC;
  private boolean rHi = true;
  private int wQH;
  private boolean wQI;
  
  public void a(NetworkInfo.State paramState)
  {
    Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.axS(this.ssid)))
    {
      dNT();
      this.wQQ = false;
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void bpf()
  {
    dNO();
  }
  
  protected final void dNO()
  {
    if (this.wQQ)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
      return;
    }
    this.wQQ = true;
    dNS();
    int i = com.tencent.mm.plugin.freewifi.model.d.d(this.ssid, this.dQC, this.wQH, this.wQI);
    k.a locala = k.dMF();
    locala.ssid = this.ssid;
    locala.dFd = this.dFd;
    locala.quX = m.aw(getIntent());
    locala.wNc = m.ay(getIntent());
    locala.wNd = k.b.wNo.wNO;
    locala.wNe = k.b.wNo.name;
    locala.result = i;
    locala.channel = m.az(getIntent());
    locala.wNb = this.dNI;
    locala.wNf = this.appUserName;
    locala.dMH().dMG();
  }
  
  protected int dNP()
  {
    if (com.tencent.mm.plugin.freewifi.model.d.axS(this.ssid))
    {
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String dNQ();
  
  public void initView()
  {
    super.initView();
    setMMTitle(dNQ());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.wQH = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.dQC = getIntent().getStringExtra("free_wifi_passowrd");
    this.wQI = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
    Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
    }
    do
    {
      return;
      Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != -1));
    this.rHi = false;
    h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new FreeWifiNoAuthStateUI.2(this), new FreeWifiNoAuthStateUI.3(this));
  }
  
  public void onResume()
  {
    int j = 0;
    super.onResume();
    int i;
    if (this.rHi)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_FINE_LOCATION", 77, null, null);
      Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "check permission not passed!");
      }
      return;
      i = j;
      if (b.n(this, "android.permission.ACCESS_FINE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.bcc())
        {
          h.a(this, getString(2131761461), getString(2131755998), getString(2131762043), getString(2131755761), false, new FreeWifiNoAuthStateUI.1(this), null);
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
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */