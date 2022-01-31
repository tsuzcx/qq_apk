package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeTwoUI$2
  implements Runnable
{
  ProtocolThreeTwoUI$2(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(21174);
    String str1 = d.bAy();
    String str2 = d.bAC();
    int i = d.bAz();
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.U(this.mPc.getIntent()), Integer.valueOf(m.V(this.mPc.getIntent())), this.mPc.kdt, str1, str2, Integer.valueOf(i) });
    new a(this.mPc.kdt, str1, str2, i, this.mPc.bWu, m.U(this.mPc.getIntent())).c(new ProtocolThreeTwoUI.2.1(this));
    AppMethodBeat.o(21174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.2
 * JD-Core Version:    0.7.0.1
 */