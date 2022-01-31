package com.tencent.mm.az;

import com.tencent.mm.h.a.md;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bt;
import com.tencent.mm.protocal.c.asx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
  extends c<md>
{
  public p()
  {
    this.udX = md.class.getName().hashCode();
  }
  
  private static boolean PI()
  {
    int i;
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      com.tencent.mm.kernel.g.DN();
      if (!a.CW())
      {
        i = 1;
        if (i == 0) {
          break label336;
        }
        if (bk.cn(bk.a((Long)com.tencent.mm.kernel.g.DP().Dz().get(68097, null), 0L)) * 1000L <= 3600000L) {
          break label113;
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
        Object localObject = com.tencent.mm.a.e.d(com.tencent.mm.kernel.g.DP().cachePath + "eggresult.rep", 0, -1);
        if (localObject == null)
        {
          return false;
          i = 0;
          break;
          label113:
          i = 0;
          continue;
        }
        try
        {
          localObject = ((h)new h().aH((byte[])localObject)).ewM.iterator();
          while (((Iterator)localObject).hasNext())
          {
            g localg = (g)((Iterator)localObject).next();
            asx localasx;
            if (localg.ewK != 0)
            {
              localasx = new asx();
              localasx.nFi = 17;
              localasx.nFs = (localg.ewz + "," + localg.ewK);
              localLinkedList.add(localasx);
            }
            if (localg.ewL != 0)
            {
              localasx = new asx();
              localasx.nFi = 18;
              localasx.nFs = (localg.ewz + "," + localg.ewL);
              localLinkedList.add(localasx);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { bk.j(localException) });
        }
      }
    }
    for (;;)
    {
      bt.c(localLinkedList);
      com.tencent.mm.kernel.g.DP().Dz().o(68097, Long.valueOf(bk.UX()));
      label336:
      y.d("MicroMsg.PostTaskReportEgg", "report egg done");
      return false;
      com.tencent.mm.a.e.deleteFile(com.tencent.mm.kernel.g.DP().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.az.p
 * JD-Core Version:    0.7.0.1
 */