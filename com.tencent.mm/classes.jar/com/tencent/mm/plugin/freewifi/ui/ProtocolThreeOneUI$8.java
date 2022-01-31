package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeOneUI$8
  implements Runnable
{
  ProtocolThreeOneUI$8(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final void run()
  {
    String str1 = d.aTV();
    String str2 = d.aTX();
    int i = d.aTW();
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.B(this.kti.getIntent()), Integer.valueOf(m.C(this.kti.getIntent())), this.kti.kpt, str1, str2, Integer.valueOf(i) });
    new a(this.kti.kpt, str1, str2, i, this.kti.bvj, m.B(this.kti.getIntent())).b(new ProtocolThreeOneUI.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.8
 * JD-Core Version:    0.7.0.1
 */