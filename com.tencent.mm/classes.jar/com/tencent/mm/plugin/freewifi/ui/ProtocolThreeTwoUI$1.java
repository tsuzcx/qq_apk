package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class ProtocolThreeTwoUI$1
  implements ap.a
{
  ProtocolThreeTwoUI$1(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(21172);
    if (!bo.isNullOrNil(this.mPc.ssid))
    {
      ProtocolThreeTwoUI.a(this.mPc, this.mPc.bBm());
      if (ProtocolThreeTwoUI.a(this.mPc) != 2)
      {
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { m.U(this.mPc.getIntent()), Integer.valueOf(m.V(this.mPc.getIntent())), d.wl(ProtocolThreeTwoUI.a(this.mPc)) });
        d.a(this.mPc.ssid, 3, this.mPc.getIntent());
        ProtocolThreeTwoUI.a(this.mPc, 33, "AUTH_302_TIMES_EXCESS");
      }
    }
    AppMethodBeat.o(21172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.1
 * JD-Core Version:    0.7.0.1
 */