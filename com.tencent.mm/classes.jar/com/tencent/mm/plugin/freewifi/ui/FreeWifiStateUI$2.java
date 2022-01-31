package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class FreeWifiStateUI$2
  implements am.a
{
  FreeWifiStateUI$2(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final boolean tC()
  {
    if (d.Du(this.ksM.ssid))
    {
      this.ksM.a(NetworkInfo.State.CONNECTED);
      FreeWifiStateUI.b(this.ksM).stopTimer();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.2
 * JD-Core Version:    0.7.0.1
 */