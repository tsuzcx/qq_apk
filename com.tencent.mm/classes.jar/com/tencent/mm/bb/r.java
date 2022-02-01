package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.by;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends c<oq>
{
  public r()
  {
    AppMethodBeat.i(161780);
    this.__eventId = oq.class.getName().hashCode();
    AppMethodBeat.o(161780);
  }
  
  private static boolean aGM()
  {
    AppMethodBeat.i(150854);
    int i;
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agP();
      if (!a.afS())
      {
        i = 1;
        if (i == 0) {
          break label346;
        }
        if (bs.pN(bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(68097, null), 0L)) * 1000L <= 3600000L) {
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
        Object localObject = i.aU(com.tencent.mm.kernel.g.agR().cachePath + "eggresult.rep", 0, -1);
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
          localObject = ((h)new h().parseFrom((byte[])localObject)).hPM.iterator();
          while (((Iterator)localObject).hasNext())
          {
            g localg = (g)((Iterator)localObject).next();
            bob localbob;
            if (localg.hPK != 0)
            {
              localbob = new bob();
              localbob.wTD = 17;
              localbob.wTM = (localg.dtw + "," + localg.hPK);
              localLinkedList.add(localbob);
            }
            if (localg.hPL != 0)
            {
              localbob = new bob();
              localbob.wTD = 18;
              localbob.wTM = (localg.dtw + "," + localg.hPL);
              localLinkedList.add(localbob);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { bs.m(localException) });
        }
      }
    }
    for (;;)
    {
      by.b(localLinkedList);
      com.tencent.mm.kernel.g.agR().agA().set(68097, Long.valueOf(bs.aNx()));
      label346:
      ac.d("MicroMsg.PostTaskReportEgg", "report egg done");
      AppMethodBeat.o(150854);
      return false;
      i.deleteFile(com.tencent.mm.kernel.g.agR().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.r
 * JD-Core Version:    0.7.0.1
 */