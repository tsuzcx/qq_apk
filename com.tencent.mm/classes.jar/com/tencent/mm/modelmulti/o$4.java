package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

final class o$4
  implements Runnable
{
  o$4(o paramo, o.c paramc) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(146146);
    if ((a.QP()) || (!g.RG()))
    {
      ab.w("MicroMsg.SyncService", "begin to doLoop but MMCore account has not ready or MMCore is hold.");
      AppMethodBeat.o(146146);
      return;
    }
    long l;
    if (this.fJC != null)
    {
      ab.i("MicroMsg.SyncService", "finish proc:%s running:%s RunTime:%s ", new Object[] { this.fJC, o.a(this.fJA), Long.valueOf(bo.hl(o.d(this.fJA))) });
      if (this.fJC != o.a(this.fJA))
      {
        localObject = o.e(this.fJA).keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          o.c localc = (o.c)((Iterator)localObject).next();
          ab.w("MicroMsg.SyncService", "check unfinish proc :%s timediff:%s", new Object[] { localc, Long.valueOf(bo.hl(((Long)o.e(this.fJA).get(localc)).longValue())) });
        }
        l = bo.a((Long)o.e(this.fJA).remove(this.fJC), -1L);
        localObject = "oldproc timeout, should in timeoutMap:" + this.fJC;
        if (l != -1L) {}
        for (bool = true;; bool = false)
        {
          o.K((String)localObject, bool);
          AppMethodBeat.o(146146);
          return;
        }
      }
      o.a(this.fJC, o.d(this.fJA));
      o.b(this.fJA, null);
      o.a(this.fJA, 0L);
      o.f(this.fJA);
    }
    if (o.a(this.fJA) != null)
    {
      l = bo.hl(o.d(this.fJA));
      if (l > 90000L)
      {
        ab.w("MicroMsg.SyncService", "tryStart last proc:%s TIMEOUT:%s Run Next Now.", new Object[] { o.a(this.fJA), Long.valueOf(l) });
        o.c(o.a(this.fJA));
        o.e(this.fJA).put(o.a(this.fJA), Long.valueOf(o.d(this.fJA)));
        o.b(this.fJA, null);
        o.a(this.fJA, 0L);
        o.f(this.fJA);
      }
    }
    else
    {
      localObject = (b)g.E(b.class);
      if (!((b)localObject).dkL().abm()) {
        break label493;
      }
      ab.w("MicroMsg.SyncService", "Warning: Set SyncService Pause Now.");
      ((b)localObject).dkL().abk();
      AppMethodBeat.o(146146);
      return;
    }
    ab.i("MicroMsg.SyncService", "tryStart last proc:%s running:%s ", new Object[] { o.a(this.fJA), Long.valueOf(l) });
    AppMethodBeat.o(146146);
    return;
    label493:
    if (((b)localObject).dkL().abn())
    {
      ab.w("MicroMsg.SyncService", "Warning: SyncService is Paused.");
      AppMethodBeat.o(146146);
      return;
    }
    Object localObject = new o.d(this.fJA);
    if (((o.d)localObject).c(null))
    {
      o.a(this.fJA, "LightPush");
      o.b(this.fJA, (o.c)localObject);
      o.a(this.fJA, bo.aoy());
      AppMethodBeat.o(146146);
      return;
    }
    while (!o.b(this.fJA).isEmpty())
    {
      localObject = (o.c)o.b(this.fJA).poll();
      ab.i("MicroMsg.SyncService", "tryStart check NotifyData ListSize:%s proc:%s", new Object[] { Integer.valueOf(o.b(this.fJA).size()), localObject });
      if ((localObject != null) && (((o.c)localObject).c(null)))
      {
        o.a(this.fJA, "NotifyData");
        o.b(this.fJA, (o.c)localObject);
        o.a(this.fJA, bo.aoy());
        AppMethodBeat.o(146146);
        return;
      }
    }
    if (!o.c(this.fJA).isEmpty())
    {
      localObject = (o.c)o.c(this.fJA).poll();
      ab.i("MicroMsg.SyncService", "tryStart check Sync ListSize:%s proc:%s", new Object[] { Integer.valueOf(o.c(this.fJA).size()), localObject });
      if ((localObject != null) && (((o.c)localObject).c(o.c(this.fJA))))
      {
        o.a(this.fJA, "NetSync");
        o.b(this.fJA, (o.c)localObject);
        o.a(this.fJA, bo.aoy());
        AppMethodBeat.o(146146);
        return;
      }
    }
    ab.i("MicroMsg.SyncService", "tryStart FINISH Check running:%s sync:%s notify:%s", new Object[] { o.a(this.fJA), Integer.valueOf(o.c(this.fJA).size()), Integer.valueOf(o.b(this.fJA).size()) });
    if ((o.a(this.fJA) == null) && (o.c(this.fJA).isEmpty()) && (o.b(this.fJA).isEmpty())) {}
    for (;;)
    {
      o.K("", bool);
      AppMethodBeat.o(146146);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.4
 * JD-Core Version:    0.7.0.1
 */