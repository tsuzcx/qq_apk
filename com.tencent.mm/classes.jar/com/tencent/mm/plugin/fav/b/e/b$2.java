package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class b$2
  extends n.a
{
  b$2(b paramb) {}
  
  public final void et(int paramInt)
  {
    boolean bool;
    try
    {
      bool = aq.isWifi(com.tencent.mm.sdk.platformtools.ae.getContext());
      if ((paramInt != 4) && (paramInt != 6))
      {
        b.a(this.kaK, bool);
        return;
      }
      y.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(b.c(this.kaK)) });
      if ((!b.c(this.kaK)) && (bool))
      {
        b localb = this.kaK;
        Object localObject = ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().aQv();
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break label251;
        }
        y.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (localg.field_itemStatus == 3)
          {
            localg.field_itemStatus = 1;
            ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
          }
        }
        localException.run();
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
      return;
    }
    for (;;)
    {
      b.a(this.kaK, bool);
      return;
      label251:
      y.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b.2
 * JD-Core Version:    0.7.0.1
 */