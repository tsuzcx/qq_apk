package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Queue;

final class o$d
  implements o.c
{
  o$d(o paramo) {}
  
  public final boolean c(Queue<o.c> paramQueue)
  {
    Object localObject = new PInt();
    g.DQ();
    g.DN();
    paramQueue = com.tencent.mm.booter.f.a((PInt)localObject, a.CK());
    int j = ((PInt)localObject).value;
    if (paramQueue != null) {}
    for (int i = paramQueue.length;; i = -1)
    {
      y.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", new Object[] { this, Integer.valueOf(j), Integer.valueOf(i) });
      if ((((PInt)localObject).value != 0) && (!bk.bE(paramQueue))) {
        break;
      }
      return false;
    }
    i = ((PInt)localObject).value;
    try
    {
      localObject = new s.b();
      ((s.b)localObject).A(paramQueue);
      paramQueue = ((s.b)localObject).sqj;
      if (paramQueue == null) {
        return false;
      }
    }
    catch (Exception paramQueue)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.f.nEG.a(99L, 38L, 1L, false);
        y.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed ", new Object[] { this, Integer.valueOf(i) });
        g.DQ();
        g.DN();
        com.tencent.mm.booter.f.aV(i, a.CK());
        paramQueue = null;
      }
    }
    catch (Error paramQueue)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.f.nEG.a(99L, 39L, 1L, false);
        long l1 = Runtime.getRuntime().freeMemory() / 1000L;
        long l2 = Runtime.getRuntime().totalMemory() / 1000L;
        y.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
        o.G("LightPush memory error", false);
        paramQueue = null;
      }
      com.tencent.mm.plugin.report.f.nEG.a(99L, 20L, 1L, false);
      new o.a(this.etN, this, true, paramQueue, new o.d.1(this, i), (byte)0);
    }
    return true;
  }
  
  public final String toString()
  {
    return "LightPush[" + hashCode() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.d
 * JD-Core Version:    0.7.0.1
 */