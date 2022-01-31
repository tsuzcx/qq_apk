package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;
import java.util.TimerTask;

final class k$3
  extends TimerTask
{
  k$3(k paramk, e parame, d.a parama, Timer paramTimer) {}
  
  public final void run()
  {
    AppMethodBeat.i(108222);
    ab.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
    this.igi.close();
    k.a(this.itl, this.igi);
    this.igj.AM("connect response time out");
    cancel();
    this.igl.cancel();
    AppMethodBeat.o(108222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.k.3
 * JD-Core Version:    0.7.0.1
 */