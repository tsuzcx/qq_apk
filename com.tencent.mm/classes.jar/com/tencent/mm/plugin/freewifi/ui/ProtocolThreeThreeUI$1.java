package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeThreeUI$1
  implements am.a
{
  ProtocolThreeThreeUI$1(ProtocolThreeThreeUI paramProtocolThreeThreeUI) {}
  
  public final boolean tC()
  {
    if (!bk.bl(this.ktl.ssid))
    {
      ProtocolThreeThreeUI.a(this.ktl, this.ktl.aUO());
      if (ProtocolThreeThreeUI.a(this.ktl) != 2)
      {
        y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[] { m.B(this.ktl.getIntent()), Integer.valueOf(m.C(this.ktl.getIntent())), d.rr(ProtocolThreeThreeUI.a(this.ktl)) });
        d.a(this.ktl.ssid, 3, this.ktl.getIntent());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.1
 * JD-Core Version:    0.7.0.1
 */