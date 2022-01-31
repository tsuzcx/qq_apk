package com.tencent.mm.plugin.appbrand.o;

import com.tencent.mm.plugin.appbrand.w.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Timer;
import java.util.TimerTask;

final class k$3
  extends TimerTask
{
  k$3(k paramk, k.b paramb, a parama, Timer paramTimer) {}
  
  public final void run()
  {
    y.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
    this.gRy.sL("connect response time out");
    this.gRA.close();
    this.gRz.b(this.gRA);
    cancel();
    this.gRB.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.k.3
 * JD-Core Version:    0.7.0.1
 */