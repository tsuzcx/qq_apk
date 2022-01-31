package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class ProtocolThreeThreeUI$1
  implements ap.a
{
  ProtocolThreeThreeUI$1(ProtocolThreeThreeUI paramProtocolThreeThreeUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(21148);
    if (!bo.isNullOrNil(this.mOZ.ssid))
    {
      ProtocolThreeThreeUI.a(this.mOZ, this.mOZ.bBm());
      if (ProtocolThreeThreeUI.a(this.mOZ) != 2)
      {
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { m.U(this.mOZ.getIntent()), Integer.valueOf(m.V(this.mOZ.getIntent())), d.wl(ProtocolThreeThreeUI.a(this.mOZ)) });
        d.a(this.mOZ.ssid, 3, this.mOZ.getIntent());
      }
    }
    AppMethodBeat.o(21148);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.1
 * JD-Core Version:    0.7.0.1
 */