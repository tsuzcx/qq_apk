package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class FreeWifiStateUI$2
  implements ap.a
{
  FreeWifiStateUI$2(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(21072);
    if (d.OC(this.mOB.ssid))
    {
      this.mOB.a(NetworkInfo.State.CONNECTED);
      FreeWifiStateUI.b(this.mOB).stopTimer();
      AppMethodBeat.o(21072);
      return false;
    }
    AppMethodBeat.o(21072);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.2
 * JD-Core Version:    0.7.0.1
 */