package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;
import java.util.TimerTask;

final class k$2
  extends TimerTask
{
  k$2(k paramk, e parame, d.a parama, Timer paramTimer) {}
  
  public final void run()
  {
    AppMethodBeat.i(108221);
    ab.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
    this.igi.close();
    k.a(this.itl, this.igi);
    this.igj.AM("connect response time out");
    cancel();
    this.igl.cancel();
    AppMethodBeat.o(108221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.k.2
 * JD-Core Version:    0.7.0.1
 */