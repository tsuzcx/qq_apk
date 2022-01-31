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

final class i$2
  implements a.a
{
  i$2(i parami) {}
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(20838);
    ab.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[] { m.U(this.mLz.intent), Integer.valueOf(m.V(this.mLz.intent)), paramException.getMessage(), m.f(paramException) });
    FreeWifiFrontPageUI localFreeWifiFrontPageUI = this.mLz.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLz.mLg, k.b.mJj, m.g(paramException));
    localFreeWifiFrontPageUI.a(locald, locala);
    AppMethodBeat.o(20838);
  }
  
  public final void h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(20837);
    int i = paramHttpURLConnection.getResponseCode();
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[] { m.U(this.mLz.intent), Integer.valueOf(m.V(this.mLz.intent)), Integer.valueOf(i) });
    if (i == 200)
    {
      this.mLz.bBi();
      AppMethodBeat.o(20837);
      return;
    }
    if (i == 302)
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Location");
      i.a(this.mLz, paramHttpURLConnection);
      AppMethodBeat.o(20837);
      return;
    }
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[] { m.U(this.mLz.intent), Integer.valueOf(m.V(this.mLz.intent)) });
    paramHttpURLConnection = this.mLz.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNi = m.a(this.mLz.mLg, k.b.mJj, 32);
    paramHttpURLConnection.a(locald, locala);
    AppMethodBeat.o(20837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i.2
 * JD-Core Version:    0.7.0.1
 */