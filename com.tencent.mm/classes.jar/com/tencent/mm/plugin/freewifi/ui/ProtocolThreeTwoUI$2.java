package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeTwoUI$2
  implements Runnable
{
  ProtocolThreeTwoUI$2(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void run()
  {
    String str1 = d.aTV();
    String str2 = d.aTX();
    int i = d.aTW();
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.B(this.kto.getIntent()), Integer.valueOf(m.C(this.kto.getIntent())), this.kto.kpt, str1, str2, Integer.valueOf(i) });
    new a(this.kto.kpt, str1, str2, i, this.kto.bvj, m.B(this.kto.getIntent())).b(new ProtocolThreeTwoUI.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.2
 * JD-Core Version:    0.7.0.1
 */