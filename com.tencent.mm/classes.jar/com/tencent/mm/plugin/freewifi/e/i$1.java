package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;

final class i$1
  implements Runnable
{
  i$1(i parami, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(20836);
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.U(this.mLz.intent), Integer.valueOf(m.V(this.mLz.intent)), this.val$url });
    a.bAk();
    a.a(this.val$url, new i.1.1(this));
    AppMethodBeat.o(20836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i.1
 * JD-Core Version:    0.7.0.1
 */