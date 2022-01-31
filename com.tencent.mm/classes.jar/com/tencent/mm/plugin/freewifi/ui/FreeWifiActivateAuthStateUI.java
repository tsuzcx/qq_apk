package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public class FreeWifiActivateAuthStateUI
  extends FreeWifiActivateStateUI
{
  public final void a(NetworkInfo.State paramState)
  {
    AppMethodBeat.i(20895);
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", new Object[] { paramState.toString() });
    if ((paramState == NetworkInfo.State.CONNECTED) && (d.OC(this.ssid)))
    {
      bBq();
      bBs();
    }
    AppMethodBeat.o(20895);
  }
  
  protected final void arq()
  {
    AppMethodBeat.i(20896);
    j.bAP().a(this.ssid, new FreeWifiActivateAuthStateUI.2(this), this.bWu, getIntent());
    AppMethodBeat.o(20896);
  }
  
  protected final void bBl()
  {
    AppMethodBeat.i(20897);
    bBp();
    d.OD(this.ssid);
    AppMethodBeat.o(20897);
  }
  
  protected final int bBm()
  {
    AppMethodBeat.i(20898);
    j.bAJ();
    int i = d.OB(this.ssid);
    AppMethodBeat.o(20898);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20893);
    super.initView();
    this.mMv = ((Button)findViewById(2131824268));
    this.mMv.setOnClickListener(new FreeWifiActivateAuthStateUI.1(this));
    setMMTitle(2131300181);
    AppMethodBeat.o(20893);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20892);
    super.onCreate(paramBundle);
    if (this.cpt != 2) {
      d.a(this.ssid, 1, getIntent());
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
    AppMethodBeat.o(20892);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20894);
    super.onDestroy();
    AppMethodBeat.o(20894);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI
 * JD-Core Version:    0.7.0.1
 */