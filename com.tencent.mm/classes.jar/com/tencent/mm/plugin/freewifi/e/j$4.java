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

final class j$4
  implements a.a
{
  j$4(j paramj) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(20859);
    ab.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[] { m.U(this.mLD.intent), Integer.valueOf(m.V(this.mLD.intent)), paramException.getMessage(), m.f(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.mLD.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLD.mLg, k.b.mJh, m.g(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    j.a(this.mLD, m.g(paramException), m.e(paramException));
    AppMethodBeat.o(20859);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(20858);
    int i = paramHttpURLConnection.getResponseCode();
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[] { m.U(this.mLD.intent), Integer.valueOf(m.V(this.mLD.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      j.a(this.mLD, 0, "");
      m.a(this.mLD.intent, this.mLD.coX, this.mLD.mLg, this.mLD.bWu, this.mLD.mLf, "MicroMsg.FreeWifi.Protocol32");
      AppMethodBeat.o(20858);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      j.b(this.mLD, paramHttpURLConnection);
      AppMethodBeat.o(20858);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[] { m.U(this.mLD.intent), Integer.valueOf(m.V(this.mLD.intent)) });
    paramHttpURLConnection = this.mLD.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLD.mLg, k.b.mJh, 32);
    paramHttpURLConnection.a(locald, locala);
    j.a(this.mLD, 32, "INVALID_HTTP_RESP_CODE");
    AppMethodBeat.o(20858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.4
 * JD-Core Version:    0.7.0.1
 */