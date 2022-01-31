package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.y;

final class j$3
  implements Runnable
{
  j$3(j paramj, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.B(this.kpR.intent), Integer.valueOf(m.C(this.kpR.intent)), this.val$url });
    a.aTG();
    a.a(this.val$url, new j.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.j.3
 * JD-Core Version:    0.7.0.1
 */