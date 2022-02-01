package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cb;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends c<pa>
{
  public r()
  {
    AppMethodBeat.i(161780);
    this.__eventId = pa.class.getName().hashCode();
    AppMethodBeat.o(161780);
  }
  
  private static boolean aKq()
  {
    AppMethodBeat.i(150854);
    int i;
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.kernel.g.ajP();
      if (!a.aiT())
      {
        i = 1;
        if (i == 0) {
          break label346;
        }
        if (bu.rZ(bu.a((Long)com.tencent.mm.kernel.g.ajR().ajA().get(68097, null), 0L)) * 1000L <= 3600000L) {
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
        Object localObject = o.bb(com.tencent.mm.kernel.g.ajR().cachePath + "eggresult.rep", 0, -1);
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
          localObject = ((h)new h().parseFrom((byte[])localObject)).ilT.iterator();
          while (((Iterator)localObject).hasNext())
          {
            g localg = (g)((Iterator)localObject).next();
            bth localbth;
            if (localg.ilR != 0)
            {
              localbth = new bth();
              localbth.yxe = 17;
              localbth.yxn = (localg.dGC + "," + localg.ilR);
              localLinkedList.add(localbth);
            }
            if (localg.ilS != 0)
            {
              localbth = new bth();
              localbth.yxe = 18;
              localbth.yxn = (localg.dGC + "," + localg.ilS);
              localLinkedList.add(localbth);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { bu.o(localException) });
        }
      }
    }
    for (;;)
    {
      cb.b(localLinkedList);
      com.tencent.mm.kernel.g.ajR().ajA().set(68097, Long.valueOf(bu.aRi()));
      label346:
      ae.d("MicroMsg.PostTaskReportEgg", "report egg done");
      AppMethodBeat.o(150854);
      return false;
      o.deleteFile(com.tencent.mm.kernel.g.ajR().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.r
 * JD-Core Version:    0.7.0.1
 */