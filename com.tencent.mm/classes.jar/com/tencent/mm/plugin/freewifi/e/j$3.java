package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;

final class j$3
  implements Runnable
{
  j$3(j paramj, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(20857);
    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.U(this.mLD.intent), Integer.valueOf(m.V(this.mLD.intent)), this.val$url });
    a.bAk();
    a.a(this.val$url, new j.3.1(this));
    AppMethodBeat.o(20857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.3
 * JD-Core Version:    0.7.0.1
 */