package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeThreeUI$8
  implements Runnable
{
  ProtocolThreeThreeUI$8(ProtocolThreeThreeUI paramProtocolThreeThreeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(21158);
    String str1 = d.bAy();
    String str2 = d.bAC();
    int i = d.bAz();
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.U(this.mOZ.getIntent()), Integer.valueOf(m.V(this.mOZ.getIntent())), "", str1, str2, Integer.valueOf(i) });
    new f(this.mOZ.ssid, this.mOZ.bssid, this.mOZ.appId, this.mOZ.mLu, this.mOZ.mLv, this.mOZ.mLw, this.mOZ.cqf, this.mOZ.sign).c(new ProtocolThreeThreeUI.8.1(this));
    AppMethodBeat.o(21158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.8
 * JD-Core Version:    0.7.0.1
 */