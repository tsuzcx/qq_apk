package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Iterator;
import java.util.List;

final class b$2
  extends n.a
{
  b$2(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(5351);
    boolean bool;
    try
    {
      bool = at.isWifi(ah.getContext());
      if ((paramInt != 4) && (paramInt != 6))
      {
        b.a(this.mvg, bool);
        AppMethodBeat.o(5351);
        return;
      }
      ab.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(b.c(this.mvg)) });
      if ((!b.c(this.mvg)) && (bool))
      {
        b localb = this.mvg;
        Object localObject = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwK();
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break label275;
        }
        ab.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (localg.field_itemStatus == 3)
          {
            localg.field_itemStatus = 1;
            ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
          }
        }
        localException.run();
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
      AppMethodBeat.o(5351);
      return;
    }
    for (;;)
    {
      b.a(this.mvg, bool);
      AppMethodBeat.o(5351);
      return;
      label275:
      ab.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b.2
 * JD-Core Version:    0.7.0.1
 */