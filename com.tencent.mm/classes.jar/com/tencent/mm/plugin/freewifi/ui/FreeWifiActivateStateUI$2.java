package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class FreeWifiActivateStateUI$2
  implements am.a
{
  FreeWifiActivateStateUI$2(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final boolean tC()
  {
    if (d.Du(this.kqR.ssid))
    {
      this.kqR.a(NetworkInfo.State.CONNECTED);
      FreeWifiActivateStateUI.b(this.kqR).stopTimer();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.2
 * JD-Core Version:    0.7.0.1
 */