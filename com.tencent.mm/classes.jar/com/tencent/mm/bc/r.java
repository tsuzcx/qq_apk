package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.by;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends c<oh>
{
  public r()
  {
    AppMethodBeat.i(161780);
    this.__eventId = oh.class.getName().hashCode();
    AppMethodBeat.o(161780);
  }
  
  private static boolean azW()
  {
    AppMethodBeat.i(150854);
    int i;
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afz();
      if (!a.aeC())
      {
        i = 1;
        if (i == 0) {
          break label346;
        }
        if (bt.lZ(bt.a((Long)com.tencent.mm.kernel.g.afB().afk().get(68097, null), 0L)) * 1000L <= 3600000L) {
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
        Object localObject = i.aR(com.tencent.mm.kernel.g.afB().cachePath + "eggresult.rep", 0, -1);
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
          localObject = ((h)new h().parseFrom((byte[])localObject)).hpk.iterator();
          while (((Iterator)localObject).hasNext())
          {
            g localg = (g)((Iterator)localObject).next();
            bkh localbkh;
            if (localg.hpi != 0)
            {
              localbkh = new bkh();
              localbkh.vJz = 17;
              localbkh.vJI = (localg.dvJ + "," + localg.hpi);
              localLinkedList.add(localbkh);
            }
            if (localg.hpj != 0)
            {
              localbkh = new bkh();
              localbkh.vJz = 18;
              localbkh.vJI = (localg.dvJ + "," + localg.hpj);
              localLinkedList.add(localbkh);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { bt.m(localException) });
        }
      }
    }
    for (;;)
    {
      by.b(localLinkedList);
      com.tencent.mm.kernel.g.afB().afk().set(68097, Long.valueOf(bt.aGK()));
      label346:
      ad.d("MicroMsg.PostTaskReportEgg", "report egg done");
      AppMethodBeat.o(150854);
      return false;
      i.deleteFile(com.tencent.mm.kernel.g.afB().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.r
 * JD-Core Version:    0.7.0.1
 */