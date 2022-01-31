package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Queue;
import java.util.Queue<Lcom.tencent.mm.modelmulti.o.c;>;

final class o$d
  implements o.c
{
  o$d(o paramo) {}
  
  public final boolean c(Queue<o.c> paramQueue)
  {
    AppMethodBeat.i(58402);
    paramQueue = new PInt();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    Object localObject = com.tencent.mm.booter.g.a(paramQueue, a.getUin());
    int j = paramQueue.value;
    if (localObject != null) {}
    for (final int i = localObject.length;; i = -1)
    {
      ab.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", new Object[] { this, Integer.valueOf(j), Integer.valueOf(i) });
      if ((paramQueue.value != 0) && (!bo.ce((byte[])localObject))) {
        break;
      }
      AppMethodBeat.o(58402);
      return false;
    }
    i = paramQueue.value;
    paramQueue = null;
    try
    {
      t.b localb = new t.b();
      localb.fromProtoBuf((byte[])localObject);
      localObject = localb.wiN;
      paramQueue = (Queue<o.c>)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e.qrI.idkeyStat(99L, 38L, 1L, false);
        ab.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", new Object[] { this, Integer.valueOf(i), localException.getMessage() });
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.booter.g.bT(i, a.getUin());
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        e.qrI.idkeyStat(99L, 39L, 1L, false);
        long l1 = Runtime.getRuntime().freeMemory() / 1000L;
        long l2 = Runtime.getRuntime().totalMemory() / 1000L;
        ab.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), localError.getMessage() });
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.booter.g.bT(i, a.getUin());
      }
      e.qrI.idkeyStat(99L, 20L, 1L, false);
      new o.a(this.fJA, this, true, paramQueue, new o.b()
      {
        public final boolean lM(int paramAnonymousInt)
        {
          AppMethodBeat.i(58401);
          ab.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { o.d.this, Integer.valueOf(i) });
          paramAnonymousInt = i;
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RJ();
          com.tencent.mm.booter.g.bT(paramAnonymousInt, a.getUin());
          o.a(o.d.this.fJA, o.d.this);
          AppMethodBeat.o(58401);
          return true;
        }
      }, (byte)0);
      AppMethodBeat.o(58402);
    }
    if (paramQueue == null)
    {
      AppMethodBeat.o(58402);
      return false;
    }
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58403);
    String str = "LightPush[" + hashCode() + "]";
    AppMethodBeat.o(58403);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.d
 * JD-Core Version:    0.7.0.1
 */