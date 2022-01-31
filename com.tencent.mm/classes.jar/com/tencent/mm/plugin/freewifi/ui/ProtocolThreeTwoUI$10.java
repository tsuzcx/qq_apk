package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeTwoUI$10
  implements Runnable
{
  ProtocolThreeTwoUI$10(ProtocolThreeTwoUI paramProtocolThreeTwoUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(21192);
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.U(this.mPc.getIntent()), Integer.valueOf(m.V(this.mPc.getIntent())), this.val$url });
    a.bAk();
    a.a(this.val$url, new ProtocolThreeTwoUI.10.1(this));
    AppMethodBeat.o(21192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.10
 * JD-Core Version:    0.7.0.1
 */