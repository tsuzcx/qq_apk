package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap.a;

final class FreeWifiNetCheckUI$3
  implements ap.a
{
  FreeWifiNetCheckUI$3(FreeWifiNetCheckUI paramFreeWifiNetCheckUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(21036);
    this.mOl.mOd.sendEmptyMessage(1);
    AppMethodBeat.o(21036);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.3
 * JD-Core Version:    0.7.0.1
 */