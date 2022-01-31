package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;

final class ProtocolThreeTwoUI$9$1$1
  implements a.a
{
  ProtocolThreeTwoUI$9$1$1(ProtocolThreeTwoUI.9.1 param1) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(21182);
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.U(this.mPf.mPe.mPc.getIntent()), Integer.valueOf(m.V(this.mPf.mPe.mPc.getIntent())), paramException.getMessage() });
    d.a(this.mPf.mPe.mPc.ssid, 3, this.mPf.mPe.mPc.getIntent());
    ProtocolThreeTwoUI.a(this.mPf.mPe.mPc, 101, m.e(paramException));
    AppMethodBeat.o(21182);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(21181);
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[] { m.U(this.mPf.mPe.mPc.getIntent()), Integer.valueOf(m.V(this.mPf.mPe.mPc.getIntent())) });
      d.a(this.mPf.mPe.mPc.ssid, 3, this.mPf.mPe.mPc.getIntent());
      ProtocolThreeTwoUI.a(this.mPf.mPe.mPc, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
      AppMethodBeat.o(21181);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      ProtocolThreeTwoUI.9.1.a(this.mPf, paramHttpURLConnection);
      AppMethodBeat.o(21181);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.U(this.mPf.mPe.mPc.getIntent()), Integer.valueOf(m.V(this.mPf.mPe.mPc.getIntent())) });
    d.a(this.mPf.mPe.mPc.ssid, 3, this.mPf.mPe.mPc.getIntent());
    ProtocolThreeTwoUI.a(this.mPf.mPe.mPc, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(21181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9.1.1
 * JD-Core Version:    0.7.0.1
 */