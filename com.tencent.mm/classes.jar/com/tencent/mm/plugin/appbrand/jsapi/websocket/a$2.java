package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;
import java.util.TimerTask;

final class a$2
  extends TimerTask
{
  a$2(a parama, e parame, d.a parama1, Timer paramTimer) {}
  
  public final void run()
  {
    AppMethodBeat.i(108085);
    ab.e("MicroMsg.AppBrandNetworkWcWssSocket", "connect response time out taskid:%s", new Object[] { this.igi.aAR() });
    this.igi.close();
    a.a(this.igk, this.igi);
    this.igj.AM("connect response time out");
    cancel();
    this.igl.cancel();
    AppMethodBeat.o(108085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.a.2
 * JD-Core Version:    0.7.0.1
 */