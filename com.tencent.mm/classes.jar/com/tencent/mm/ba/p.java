package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bv;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
  extends c<mv>
{
  public p()
  {
    AppMethodBeat.i(78501);
    this.__eventId = mv.class.getName().hashCode();
    AppMethodBeat.o(78501);
  }
  
  private static boolean aiN()
  {
    AppMethodBeat.i(78502);
    int i;
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      com.tencent.mm.kernel.g.RJ();
      if (!a.QP())
      {
        i = 1;
        if (i == 0) {
          break label346;
        }
        if (bo.gz(bo.a((Long)com.tencent.mm.kernel.g.RL().Ru().get(68097, null), 0L)) * 1000L <= 3600000L) {
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
        Object localObject = com.tencent.mm.a.e.j(com.tencent.mm.kernel.g.RL().cachePath + "eggresult.rep", 0, -1);
        if (localObject == null)
        {
          AppMethodBeat.o(78502);
          return false;
          i = 0;
          break;
          label123:
          i = 0;
          continue;
        }
        try
        {
          localObject = ((h)new h().parseFrom((byte[])localObject)).fMC.iterator();
          while (((Iterator)localObject).hasNext())
          {
            g localg = (g)((Iterator)localObject).next();
            ayy localayy;
            if (localg.fMA != 0)
            {
              localayy = new ayy();
              localayy.qsk = 17;
              localayy.qsu = (localg.cFd + "," + localg.fMA);
              localLinkedList.add(localayy);
            }
            if (localg.fMB != 0)
            {
              localayy = new ayy();
              localayy.qsk = 18;
              localayy.qsu = (localg.cFd + "," + localg.fMB);
              localLinkedList.add(localayy);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { bo.l(localException) });
        }
      }
    }
    for (;;)
    {
      bv.b(localLinkedList);
      com.tencent.mm.kernel.g.RL().Ru().set(68097, Long.valueOf(bo.aox()));
      label346:
      ab.d("MicroMsg.PostTaskReportEgg", "report egg done");
      AppMethodBeat.o(78502);
      return false;
      com.tencent.mm.a.e.deleteFile(com.tencent.mm.kernel.g.RL().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.p
 * JD-Core Version:    0.7.0.1
 */