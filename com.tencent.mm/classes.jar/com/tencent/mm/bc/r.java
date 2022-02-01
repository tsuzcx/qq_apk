package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bz;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends c<oz>
{
  public r()
  {
    AppMethodBeat.i(161780);
    this.__eventId = oz.class.getName().hashCode();
    AppMethodBeat.o(161780);
  }
  
  private static boolean aJX()
  {
    AppMethodBeat.i(150854);
    int i;
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      com.tencent.mm.kernel.g.ajA();
      if (!a.aiE())
      {
        i = 1;
        if (i == 0) {
          break label346;
        }
        if (bt.rM(bt.a((Long)com.tencent.mm.kernel.g.ajC().ajl().get(68097, null), 0L)) * 1000L <= 3600000L) {
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
        Object localObject = i.aY(com.tencent.mm.kernel.g.ajC().cachePath + "eggresult.rep", 0, -1);
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
          localObject = ((h)new h().parseFrom((byte[])localObject)).ija.iterator();
          while (((Iterator)localObject).hasNext())
          {
            g localg = (g)((Iterator)localObject).next();
            bsn localbsn;
            if (localg.iiY != 0)
            {
              localbsn = new bsn();
              localbsn.yhn = 17;
              localbsn.yhw = (localg.dFx + "," + localg.iiY);
              localLinkedList.add(localbsn);
            }
            if (localg.iiZ != 0)
            {
              localbsn = new bsn();
              localbsn.yhn = 18;
              localbsn.yhw = (localg.dFx + "," + localg.iiZ);
              localLinkedList.add(localbsn);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { bt.n(localException) });
        }
      }
    }
    for (;;)
    {
      bz.b(localLinkedList);
      com.tencent.mm.kernel.g.ajC().ajl().set(68097, Long.valueOf(bt.aQJ()));
      label346:
      ad.d("MicroMsg.PostTaskReportEgg", "report egg done");
      AppMethodBeat.o(150854);
      return false;
      i.deleteFile(com.tencent.mm.kernel.g.ajC().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.r
 * JD-Core Version:    0.7.0.1
 */