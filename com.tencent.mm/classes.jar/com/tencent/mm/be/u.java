package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cg;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;

public final class u
  extends IListener<qq>
{
  public u()
  {
    AppMethodBeat.i(161780);
    this.__eventId = qq.class.getName().hashCode();
    AppMethodBeat.o(161780);
  }
  
  private static boolean bnS()
  {
    AppMethodBeat.i(150854);
    int i;
    if (h.aHE().aGM())
    {
      h.aHE();
      if (!b.aGE())
      {
        i = 1;
        if (i == 0) {
          break label346;
        }
        if (Util.secondsToNow(Util.nullAs((Long)h.aHG().aHp().b(68097, null), 0L)) * 1000L <= 3600000L) {
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
        Object localObject = com.tencent.mm.vfs.u.aY(h.aHG().cachePath + "eggresult.rep", 0, -1);
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
          localObject = ((j)new j().parseFrom((byte[])localObject)).lXy.iterator();
          while (((Iterator)localObject).hasNext())
          {
            i locali = (i)((Iterator)localObject).next();
            cow localcow;
            if (locali.lXw != 0)
            {
              localcow = new cow();
              localcow.IyZ = 17;
              localcow.Izj = (locali.fSe + "," + locali.lXw);
              localLinkedList.add(localcow);
            }
            if (locali.lXx != 0)
            {
              localcow = new cow();
              localcow.IyZ = 18;
              localcow.Izj = (locali.fSe + "," + locali.lXx);
              localLinkedList.add(localcow);
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
      cg.b(localLinkedList);
      h.aHG().aHp().i(68097, Long.valueOf(Util.nowSecond()));
      label346:
      Log.d("MicroMsg.PostTaskReportEgg", "report egg done");
      AppMethodBeat.o(150854);
      return false;
      com.tencent.mm.vfs.u.deleteFile(h.aHG().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.u
 * JD-Core Version:    0.7.0.1
 */