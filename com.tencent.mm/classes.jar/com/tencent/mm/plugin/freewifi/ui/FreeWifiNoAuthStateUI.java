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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;

@Deprecated
public abstract class FreeWifiNoAuthStateUI
  extends FreeWifiStateUI
{
  private String dxJ;
  private boolean qjw = true;
  private int toO;
  private boolean toP;
  
  public void a(NetworkInfo.State paramState)
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.ajQ(this.ssid)))
    {
      cSf();
      this.toX = false;
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void aTT()
  {
    cSa();
  }
  
  protected final void cSa()
  {
    if (this.toX)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
      return;
    }
    this.toX = true;
    cSe();
    int i = com.tencent.mm.plugin.freewifi.model.d.e(this.ssid, this.dxJ, this.toO, this.toP);
    k.a locala = k.cQR();
    locala.ssid = this.ssid;
    locala.dmM = this.dmM;
    locala.oZp = m.ao(getIntent());
    locala.tlg = m.aq(getIntent());
    locala.tlh = k.b.tls.tlS;
    locala.tli = k.b.tls.name;
    locala.result = i;
    locala.channel = m.ar(getIntent());
    locala.tlf = this.duW;
    locala.tlj = this.dtE;
    locala.cQT().cQS();
  }
  
  protected int cSb()
  {
    if (com.tencent.mm.plugin.freewifi.model.d.ajQ(this.ssid))
    {
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String cSc();
  
  public void initView()
  {
    super.initView();
    setMMTitle(cSc());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.toO = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.dxJ = getIntent().getStringExtra("free_wifi_passowrd");
    this.toP = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
    ad.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      ad.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
    }
    do
    {
      return;
      ad.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != -1));
    this.qjw = false;
    h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FreeWifiNoAuthStateUI.2(this), new FreeWifiNoAuthStateUI.3(this));
  }
  
  public void onResume()
  {
    int j = 0;
    super.onResume();
    int i;
    if (this.qjw)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ad.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        ad.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "check permission not passed!");
      }
      return;
      i = j;
      if (b.n(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.aHR())
        {
          h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new FreeWifiNoAuthStateUI.1(this), null);
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
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */