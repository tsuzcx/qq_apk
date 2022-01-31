package com.tencent.mm.plugin.appbrand.appusage;

import a.k;
import com.tencent.mm.ck.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vending.c.a;
import java.util.concurrent.TimeUnit;

public final class ae
{
  public static final a fJQ = new a((byte)0);
  private static final long fJq = TimeUnit.DAYS.toSeconds(1L);
  
  public static final class a
  {
    public static void bJ(int paramInt1, int paramInt2)
    {
      int i;
      if ((paramInt1 == 2) || (paramInt1 == 7) || (paramInt1 == 8)) {
        i = 1;
      }
      while (i != 0)
      {
        Object localObject = com.tencent.mm.kernel.g.DP();
        a.d.b.g.j(localObject, "MMKernel.storage()");
        localObject = ((e)localObject).Dz().get(ac.a.usL, Long.valueOf(0L));
        if (localObject == null)
        {
          throw new k("null cannot be cast to non-null type kotlin.Long");
          i = 0;
        }
        else
        {
          if (((Long)localObject).longValue() > bk.UX())
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
            return;
          }
          localObject = com.tencent.mm.kernel.g.DP();
          a.d.b.g.j(localObject, "MMKernel.storage()");
          ((e)localObject).Dz().c(ac.a.usL, Long.valueOf(bk.UX() + ae.ady()));
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + paramInt1 + ", prescene=" + paramInt2);
      long l = bk.UY();
      new y(paramInt1, paramInt2, 2, 2147483647, 0).Km().j((a)new ae.a.a(paramInt1, l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ae
 * JD-Core Version:    0.7.0.1
 */