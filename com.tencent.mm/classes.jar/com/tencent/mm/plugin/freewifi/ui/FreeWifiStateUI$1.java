package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class FreeWifiStateUI$1
  implements ap.a
{
  FreeWifiStateUI$1(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(21071);
    if (!bo.isNullOrNil(this.mOB.ssid))
    {
      FreeWifiStateUI.a(this.mOB, this.mOB.bBm());
      ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { this.mOB.ssid, Integer.valueOf(FreeWifiStateUI.a(this.mOB)) });
      FreeWifiStateUI.b(this.mOB).stopTimer();
      k.a locala = k.bAc();
      locala.ssid = this.mOB.ssid;
      locala.coX = this.mOB.coX;
      locala.kMp = m.U(this.mOB.getIntent());
      locala.mIE = m.W(this.mOB.getIntent());
      locala.mIF = k.b.mIQ.mJq;
      locala.mIG = k.b.mIQ.name;
      locala.result = -16;
      locala.cCy = m.X(this.mOB.getIntent());
      locala.mIC = this.mOB.cwc;
      locala.mIH = this.mOB.cvr;
      locala.bAe().bAd();
      if (FreeWifiStateUI.a(this.mOB) != 2)
      {
        this.mOB.bBq();
        this.mOB.bBo();
        d.a(this.mOB.ssid, 3, this.mOB.getIntent());
      }
    }
    AppMethodBeat.o(21071);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.1
 * JD-Core Version:    0.7.0.1
 */