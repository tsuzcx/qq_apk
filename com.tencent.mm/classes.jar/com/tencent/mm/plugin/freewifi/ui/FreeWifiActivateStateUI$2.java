package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class FreeWifiActivateStateUI$2
  implements ap.a
{
  FreeWifiActivateStateUI$2(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(20900);
    if (d.OC(this.mMD.ssid))
    {
      this.mMD.a(NetworkInfo.State.CONNECTED);
      FreeWifiActivateStateUI.b(this.mMD).stopTimer();
      AppMethodBeat.o(20900);
      return false;
    }
    AppMethodBeat.o(20900);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.2
 * JD-Core Version:    0.7.0.1
 */