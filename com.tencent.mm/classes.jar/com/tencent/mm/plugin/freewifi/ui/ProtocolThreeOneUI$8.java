package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeOneUI$8
  implements Runnable
{
  ProtocolThreeOneUI$8(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(21132);
    String str1 = d.bAy();
    String str2 = d.bAC();
    int i = d.bAz();
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.U(this.mOW.getIntent()), Integer.valueOf(m.V(this.mOW.getIntent())), this.mOW.kdt, str1, str2, Integer.valueOf(i) });
    new a(this.mOW.kdt, str1, str2, i, this.mOW.bWu, m.U(this.mOW.getIntent())).c(new ProtocolThreeOneUI.8.1(this));
    AppMethodBeat.o(21132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.8
 * JD-Core Version:    0.7.0.1
 */