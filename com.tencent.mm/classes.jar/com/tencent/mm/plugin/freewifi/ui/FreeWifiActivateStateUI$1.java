package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class FreeWifiActivateStateUI$1
  implements ap.a
{
  FreeWifiActivateStateUI$1(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(20899);
    if (!bo.isNullOrNil(this.mMD.ssid))
    {
      FreeWifiActivateStateUI.a(this.mMD, this.mMD.bBm());
      ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { this.mMD.ssid, Integer.valueOf(FreeWifiActivateStateUI.a(this.mMD)) });
      FreeWifiActivateStateUI.b(this.mMD).stopTimer();
      if (FreeWifiActivateStateUI.a(this.mMD) != 2)
      {
        this.mMD.bBq();
        this.mMD.bBo();
        d.a(this.mMD.ssid, 3, this.mMD.getIntent());
      }
    }
    AppMethodBeat.o(20899);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.1
 * JD-Core Version:    0.7.0.1
 */