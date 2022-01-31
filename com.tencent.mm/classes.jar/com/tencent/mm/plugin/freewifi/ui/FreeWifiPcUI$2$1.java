package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.h;

final class FreeWifiPcUI$2$1
  implements ap.a
{
  FreeWifiPcUI$2$1(FreeWifiPcUI.2 param2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(21062);
    FreeWifiPcUI.a(this.mOv.mOu, h.b(this.mOv.mOu.getContext(), this.mOv.mOu.getString(2131298512), true, new FreeWifiPcUI.2.1.1(this)));
    AppMethodBeat.o(21062);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2.1
 * JD-Core Version:    0.7.0.1
 */