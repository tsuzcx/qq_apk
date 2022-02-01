package com.tencent.mm.app;

import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

final class ak$2
  implements MTimerHandler.CallBack
{
  ak$2(ak paramak) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(239273);
    Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "killAppBrandTimer onTimerExpired");
    if (i.tWs == null)
    {
      AppMethodBeat.o(239273);
      return false;
    }
    if ((ak.aDa() == null) && (h.baC().aZN()) && (h.ax(a.class) != null)) {
      ak.e(Integer.valueOf(((a)h.ax(a.class)).aRC().getInt("ClientBenchmarkLevel", -1)));
    }
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    Object localObject = i.tWs.asg();
    Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "appbrand process count = %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      if ((locald.etW.get()) && (locald.arZ().isEmpty()))
      {
        if (((ak.aDa() != null) && (ak.aDa().intValue() >= 16)) || (locald.etX == LuggageServiceType.euv))
        {
          localLinkedList.add(locald.etX);
          locald.ase();
        }
        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "Kill idle appbrand process, type(%s), real type(%s)", new Object[] { localLinkedList.peek(), locald.etY });
      }
    }
    if (localLinkedList.size() > 0)
    {
      ak.i(this.hiO);
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "mLuggageSameLevelReleaseCnt:%d mLuggageSameLevelReleaseCnt:%d mLuggageReleaseLevel:%d", new Object[] { Integer.valueOf(ak.j(this.hiO)), Long.valueOf(ak.k(this.hiO)), Integer.valueOf(ak.l(this.hiO)) });
      if ((l - ak.k(this.hiO) <= 2L * ak.m(this.hiO)) && (ak.j(this.hiO) >= 2))
      {
        ak.n(this.hiO);
        ak.o(this.hiO);
        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "level up, now:%d", new Object[] { Integer.valueOf(ak.l(this.hiO)) });
      }
      ak.b(this.hiO, l);
    }
    AppMethodBeat.o(239273);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.ak.2
 * JD-Core Version:    0.7.0.1
 */