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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;

@Deprecated
public abstract class FreeWifiNoAuthStateUI
  extends FreeWifiStateUI
{
  private String dlV;
  private boolean pFR = true;
  private int ssm;
  private boolean ssn;
  
  public void a(NetworkInfo.State paramState)
  {
    ac.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (com.tencent.mm.plugin.freewifi.model.d.afs(this.ssid)))
    {
      cJQ();
      this.ssv = false;
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
    }
  }
  
  protected final void aQH()
  {
    cJL();
  }
  
  protected final void cJL()
  {
    if (this.ssv)
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
      return;
    }
    this.ssv = true;
    cJP();
    int i = com.tencent.mm.plugin.freewifi.model.d.e(this.ssid, this.dlV, this.ssm, this.ssn);
    k.a locala = k.cIC();
    locala.ssid = this.ssid;
    locala.dbq = this.dbq;
    locala.ovU = m.aj(getIntent());
    locala.soD = m.al(getIntent());
    locala.soE = k.b.soP.spp;
    locala.soF = k.b.soP.name;
    locala.result = i;
    locala.channel = m.am(getIntent());
    locala.soC = this.djj;
    locala.soG = this.dia;
    locala.cIE().cID();
  }
  
  protected int cJM()
  {
    if (com.tencent.mm.plugin.freewifi.model.d.afs(this.ssid))
    {
      com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 2, getIntent());
      return 2;
    }
    return 1;
  }
  
  protected abstract String cJN();
  
  public void initView()
  {
    super.initView();
    setMMTitle(cJN());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ssm = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
    this.dlV = getIntent().getStringExtra("free_wifi_passowrd");
    this.ssn = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, 4, getIntent());
    ac.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      ac.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
    }
    do
    {
      return;
      ac.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != -1));
    this.pFR = false;
    h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FreeWifiNoAuthStateUI.2(this), new FreeWifiNoAuthStateUI.3(this));
  }
  
  public void onResume()
  {
    int j = 0;
    super.onResume();
    int i;
    if (this.pFR)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ac.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        ac.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "check permission not passed!");
      }
      return;
      i = j;
      if (b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        if (!com.tencent.mm.modelgeo.d.aEM())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */