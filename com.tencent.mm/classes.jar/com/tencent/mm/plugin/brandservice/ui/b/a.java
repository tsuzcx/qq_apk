package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.protocal.c.bxq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static int iiR = 180;
  private static long iiS = 43200000L;
  private static long iiT = 0L;
  
  public static long ayC()
  {
    if (iiS <= 0L) {
      iiS = 43200000L;
    }
    return iiS;
  }
  
  public static void cP(long paramLong)
  {
    iiS = paramLong;
  }
  
  public static void cQ(long paramLong)
  {
    iiT = paramLong;
  }
  
  public static boolean e(q paramq)
  {
    if (paramq == null) {}
    do
    {
      do
      {
        return false;
        String str = paramq.field_talker;
        if (!bk.bl(str))
        {
          Object localObject = d.ayg();
          if (localObject != null)
          {
            localObject = ((bxp)localObject).tNF;
            if (!bk.dk((List)localObject))
            {
              localObject = ((LinkedList)localObject).iterator();
              bxq localbxq;
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localbxq = (bxq)((Iterator)localObject).next();
              } while ((localbxq == null) || (!str.equals(localbxq.sxi)));
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramq.umV = bool;
          if ((!oF(2)) || (!paramq.umV)) {
            break;
          }
          return true;
        }
      } while (!oF(1));
      paramq = ((j)g.r(j.class)).Fw().abl(paramq.field_talker);
    } while ((paramq == null) || (!paramq.Bl()));
    return true;
  }
  
  public static boolean oF(int paramInt)
  {
    return (iiT & paramInt) != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */