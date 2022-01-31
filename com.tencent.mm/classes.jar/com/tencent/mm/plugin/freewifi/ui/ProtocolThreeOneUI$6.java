package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeOneUI$6
  implements Runnable
{
  ProtocolThreeOneUI$6(ProtocolThreeOneUI paramProtocolThreeOneUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(21128);
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.U(this.mOW.getIntent()), Integer.valueOf(m.V(this.mOW.getIntent())), this.val$url });
    a.bAk();
    a.a(this.val$url, new ProtocolThreeOneUI.6.1(this));
    AppMethodBeat.o(21128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.6
 * JD-Core Version:    0.7.0.1
 */