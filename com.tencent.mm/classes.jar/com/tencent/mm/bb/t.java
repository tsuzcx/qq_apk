package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class t
  extends IListener<ps>
{
  public t()
  {
    AppMethodBeat.i(161780);
    this.__eventId = ps.class.getName().hashCode();
    AppMethodBeat.o(161780);
  }
  
  private static boolean bet()
  {
    AppMethodBeat.i(150854);
    int i;
    if (g.aAf().azp())
    {
      g.aAf();
      if (!a.azj())
      {
        i = 1;
        if (i == 0) {
          break label346;
        }
        if (Util.secondsToNow(Util.nullAs((Long)g.aAh().azQ().get(68097, null), 0L)) * 1000L <= 3600000L) {
          break label123;
        }
        i = 1;
      }
    }
    LinkedList localLinkedList;
    for (;;)
    {
      if (i != 0)
      {
        localLinkedList = new LinkedList();
        Object localObject = s.aW(g.aAh().cachePath + "eggresult.rep", 0, -1);
        if (localObject == null)
        {
          AppMethodBeat.o(150854);
          return false;
          i = 0;
          break;
          label123:
          i = 0;
          continue;
        }
        try
        {
          localObject = ((i)new i().parseFrom((byte[])localObject)).jgW.iterator();
          while (((Iterator)localObject).hasNext())
          {
            h localh = (h)((Iterator)localObject).next();
            cga localcga;
            if (localh.jgU != 0)
            {
              localcga = new cga();
              localcga.Cya = 17;
              localcga.Cyk = (localh.dYn + "," + localh.jgU);
              localLinkedList.add(localcga);
            }
            if (localh.jgV != 0)
            {
              localcga = new cga();
              localcga.Cya = 18;
              localcga.Cyk = (localh.dYn + "," + localh.jgV);
              localLinkedList.add(localcga);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        }
      }
    }
    for (;;)
    {
      cf.b(localLinkedList);
      g.aAh().azQ().set(68097, Long.valueOf(Util.nowSecond()));
      label346:
      Log.d("MicroMsg.PostTaskReportEgg", "report egg done");
      AppMethodBeat.o(150854);
      return false;
      s.deleteFile(g.aAh().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.t
 * JD-Core Version:    0.7.0.1
 */