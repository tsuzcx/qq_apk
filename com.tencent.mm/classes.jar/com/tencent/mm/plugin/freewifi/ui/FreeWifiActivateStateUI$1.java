package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiActivateStateUI$1
  implements am.a
{
  FreeWifiActivateStateUI$1(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final boolean tC()
  {
    if (!bk.bl(this.kqR.ssid))
    {
      FreeWifiActivateStateUI.a(this.kqR, this.kqR.aUO());
      y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { this.kqR.ssid, Integer.valueOf(FreeWifiActivateStateUI.a(this.kqR)) });
      FreeWifiActivateStateUI.b(this.kqR).stopTimer();
      if (FreeWifiActivateStateUI.a(this.kqR) != 2)
      {
        this.kqR.aUS();
        this.kqR.aUQ();
        d.a(this.kqR.ssid, 3, this.kqR.getIntent());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.1
 * JD-Core Version:    0.7.0.1
 */