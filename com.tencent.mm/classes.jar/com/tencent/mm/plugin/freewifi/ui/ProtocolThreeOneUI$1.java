package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class ProtocolThreeOneUI$1
  implements ap.a
{
  ProtocolThreeOneUI$1(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(21121);
    if (!bo.isNullOrNil(this.mOW.ssid))
    {
      ProtocolThreeOneUI.a(this.mOW, this.mOW.bBm());
      if (ProtocolThreeOneUI.a(this.mOW) != 2)
      {
        ProtocolThreeOneUI.b(this.mOW);
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { m.U(this.mOW.getIntent()), Integer.valueOf(m.V(this.mOW.getIntent())), d.wl(ProtocolThreeOneUI.a(this.mOW)) });
        d.a(this.mOW.ssid, 3, this.mOW.getIntent());
        ProtocolThreeOneUI.a(this.mOW, 31, "AUTH_TIMEOUT");
      }
    }
    AppMethodBeat.o(21121);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.1
 * JD-Core Version:    0.7.0.1
 */