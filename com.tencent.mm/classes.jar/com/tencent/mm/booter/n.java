package com.tencent.mm.booter;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.k;
import com.tencent.mm.be.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.z;

public final class n
{
  private static long dil = 86400000L;
  
  public static void run()
  {
    au.Hx();
    if (ah.cn(Long.valueOf(ah.c((Long)c.Dz().get(81944, null))).longValue()) * 1000L > dil) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.Rc();
        d.Rd();
        if (!((d)localObject).dZI)
        {
          g.DQ();
          if (g.DP().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).dZI = true;
            g.Dk().a(159, (f)localObject);
            localObject = new k(9);
            g.Dk().a((m)localObject, 0);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.n
 * JD-Core Version:    0.7.0.1
 */