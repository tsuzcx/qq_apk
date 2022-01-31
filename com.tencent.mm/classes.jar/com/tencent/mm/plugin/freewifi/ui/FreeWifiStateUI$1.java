package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiStateUI$1
  implements am.a
{
  FreeWifiStateUI$1(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final boolean tC()
  {
    if (!bk.bl(this.ksM.ssid))
    {
      FreeWifiStateUI.a(this.ksM, this.ksM.aUO());
      y.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { this.ksM.ssid, Integer.valueOf(FreeWifiStateUI.a(this.ksM)) });
      FreeWifiStateUI.b(this.ksM).stopTimer();
      k.a locala = k.aTx();
      locala.ssid = this.ksM.ssid;
      locala.bHI = this.ksM.bHI;
      locala.iGw = m.B(this.ksM.getIntent());
      locala.kmR = m.D(this.ksM.getIntent());
      locala.kmS = k.b.knd.knD;
      locala.kmT = k.b.knd.name;
      locala.result = -16;
      locala.bUR = m.E(this.ksM.getIntent());
      locala.kmQ = this.ksM.bOL;
      locala.kmU = this.ksM.bNZ;
      locala.aTz().aTy();
      if (FreeWifiStateUI.a(this.ksM) != 2)
      {
        this.ksM.aUS();
        this.ksM.aUQ();
        d.a(this.ksM.ssid, 3, this.ksM.getIntent());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.1
 * JD-Core Version:    0.7.0.1
 */