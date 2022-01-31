package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeOneUI$6
  implements Runnable
{
  ProtocolThreeOneUI$6(ProtocolThreeOneUI paramProtocolThreeOneUI, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.B(this.kti.getIntent()), Integer.valueOf(m.C(this.kti.getIntent())), this.val$url });
    a.aTG();
    a.a(this.val$url, new ProtocolThreeOneUI.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.6
 * JD-Core Version:    0.7.0.1
 */