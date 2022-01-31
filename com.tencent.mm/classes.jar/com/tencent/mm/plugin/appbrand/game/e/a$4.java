package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.mm.plugin.appbrand.game.c.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    long l1 = a.d(this.gdb) - a.f(this.gdb);
    long l2 = (System.currentTimeMillis() - a.d(this.gdb)) / 1000L;
    ??? = f.ty(a.access$600());
    double d;
    if (l2 < 10L)
    {
      if (??? == null) {
        break label559;
      }
      d = ((f)???).cx(l2);
    }
    for (;;)
    {
      a.b localb = new a.b(this.gdb);
      if ((a.a(this.gdb).size() > 0) && (a.e(this.gdb) > 0)) {
        a.a(this.gdb, localb, a.a(this.gdb));
      }
      a.a locala = new a.a(this.gdb);
      if (a.a(this.gdb).size() > 0) {
        a.a(locala, a.a(this.gdb));
      }
      a.a(this.gdb, 0);
      a.a(this.gdb).clear();
      Object localObject3 = this.gdb;
      synchronized (((a)localObject3).gcY)
      {
        localObject3 = ((a)localObject3).gcY.entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label324;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        int i = ((Integer)localEntry.getKey()).intValue();
        int j = ((Integer)localEntry.getValue()).intValue();
        y.i("MicroMsg.MBNiReporter", "hy: picSize level:%d,num:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        h.nFQ.a(936L, i, j, false);
      }
      if (??? != null)
      {
        d = ((f)???).cx(10L);
        continue;
        label324:
        a.c(this.gdb).clear();
        y.i("MicroMsg.MBNiReporter", "hy: decode performance appid:%s,inject2firstDraw:%d,firstFps:%f,PreDecodeNum:%d,PreDecodeTotalTime:%d,preDecodeAvgTime:%f,totalDecodeNum:%d,totalDecodeTime:%d,totalDecodeAvgTime:%f", new Object[] { a.access$600(), Long.valueOf(l1), Double.valueOf(d), Integer.valueOf(localObject2.gdd), Long.valueOf(localObject2.fXf), Double.valueOf(localObject2.gde), Integer.valueOf(locala.gdd), Long.valueOf(locala.fXf), Double.valueOf(locala.gde) });
        if (l1 > 0L) {
          h.nFQ.f(16136, new Object[] { a.access$600(), Long.valueOf(l1), Double.valueOf(d), Integer.valueOf(localObject2.gdd), Long.valueOf(localObject2.fXf), Double.valueOf(localObject2.gde), Integer.valueOf(locala.gdd), Long.valueOf(locala.fXf), Double.valueOf(locala.gde) });
        }
        a.g(this.gdb);
      }
      else
      {
        label559:
        d = -1.0D;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.4
 * JD-Core Version:    0.7.0.1
 */