package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeOneUI$1
  implements am.a
{
  ProtocolThreeOneUI$1(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final boolean tC()
  {
    if (!bk.bl(this.kti.ssid))
    {
      ProtocolThreeOneUI.a(this.kti, this.kti.aUO());
      if (ProtocolThreeOneUI.a(this.kti) != 2)
      {
        ProtocolThreeOneUI.b(this.kti);
        y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { m.B(this.kti.getIntent()), Integer.valueOf(m.C(this.kti.getIntent())), d.rr(ProtocolThreeOneUI.a(this.kti)) });
        d.a(this.kti.ssid, 3, this.kti.getIntent());
        ProtocolThreeOneUI.a(this.kti, 31, "AUTH_TIMEOUT");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.1
 * JD-Core Version:    0.7.0.1
 */