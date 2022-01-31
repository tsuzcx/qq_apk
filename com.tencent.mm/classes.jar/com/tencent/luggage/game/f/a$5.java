package com.tencent.luggage.game.f;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.CopyOnWriteArrayList;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(140545);
    long l1 = a.g(this.bCw) - a.h(this.bCw);
    long l2 = (bo.yB() - a.g(this.bCw)) / 1000L;
    double d;
    if ((l2 > 0L) && (l2 < 10L))
    {
      if (a.c(this.bCw) == null) {
        break label450;
      }
      d = a.c(this.bCw).fH(a.d(this.bCw));
    }
    for (;;)
    {
      a.c localc = new a.c(this.bCw);
      if ((a.a(this.bCw).size() > 0) && (a.b(this.bCw) > 0)) {
        a.a(this.bCw, localc, a.a(this.bCw));
      }
      a.b localb = new a.b(this.bCw);
      if (a.a(this.bCw).size() > 0) {
        a.a(localb, a.a(this.bCw));
      }
      a.a(this.bCw, 0);
      a.a(this.bCw).clear();
      a.j(this.bCw);
      ab.i("MicroMsg.MBNiReporter", "hy: decode performance appid:%s,inject2firstDraw:%d,firstFps:%f,PreDecodeNum:%d,PreDecodeTotalTime:%d,preDecodeAvgTime:%f,totalDecodeNum:%d,totalDecodeTime:%d,totalDecodeAvgTime:%f", new Object[] { a.k(this.bCw), Long.valueOf(l1), Double.valueOf(d), Integer.valueOf(localc.bCy), Long.valueOf(localc.bCz), Double.valueOf(localc.bCA), Integer.valueOf(localb.bCy), Long.valueOf(localb.bCz), Double.valueOf(localb.bCA) });
      if (l1 > 0L) {
        ((b)e.r(b.class)).e(16136, new Object[] { a.k(this.bCw), Long.valueOf(l1), Double.valueOf(d), Integer.valueOf(localc.bCy), Long.valueOf(localc.bCz), Double.valueOf(localc.bCA), Integer.valueOf(localb.bCy), Long.valueOf(localb.bCz), Double.valueOf(localb.bCA) });
      }
      a.l(this.bCw);
      AppMethodBeat.o(140545);
      return;
      d = a.i(this.bCw);
      continue;
      label450:
      d = -1.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.f.a.5
 * JD-Core Version:    0.7.0.1
 */