package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeTwoUI$10
  implements Runnable
{
  ProtocolThreeTwoUI$10(ProtocolThreeTwoUI paramProtocolThreeTwoUI, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.B(this.kto.getIntent()), Integer.valueOf(m.C(this.kto.getIntent())), this.val$url });
    a.aTG();
    a.a(this.val$url, new ProtocolThreeTwoUI.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.10
 * JD-Core Version:    0.7.0.1
 */