package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;

final class h$2
  implements a.a
{
  h$2(h paramh) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(20828);
    ab.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[] { m.U(this.mLs.intent), Integer.valueOf(m.V(this.mLs.intent)), paramException.getMessage(), m.f(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.mLs.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLs.mLg, k.b.mJg, m.g(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    h.a(this.mLs, m.g(paramException), m.e(paramException));
    AppMethodBeat.o(20828);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(20827);
    int i = paramHttpURLConnection.getResponseCode();
    ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[] { m.U(this.mLs.intent), Integer.valueOf(m.V(this.mLs.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      h.a(this.mLs, 0, "");
      m.a(this.mLs.intent, this.mLs.coX, this.mLs.mLg, this.mLs.bWu, this.mLs.mLf, "MicroMsg.FreeWifi.ProtocolThreeOne");
      AppMethodBeat.o(20827);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      h.a(this.mLs, paramHttpURLConnection);
      AppMethodBeat.o(20827);
      return;
    }
    ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[] { m.U(this.mLs.intent), Integer.valueOf(m.V(this.mLs.intent)) });
    paramHttpURLConnection = this.mLs.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLs.mLg, k.b.mJg, 32);
    paramHttpURLConnection.a(locald, locala);
    h.a(this.mLs, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(20827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h.2
 * JD-Core Version:    0.7.0.1
 */