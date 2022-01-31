package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  extends n.a
{
  a$1(a parama) {}
  
  public final void et(int paramInt)
  {
    boolean bool;
    c localc;
    try
    {
      bool = aq.isWifi(com.tencent.mm.sdk.platformtools.ae.getContext());
      y.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(this.kaG.kaC) });
      if ((paramInt != 4) && (paramInt != 6))
      {
        this.kaG.kaC = bool;
        return;
      }
      if ((!this.kaG.kaC) || (bool)) {
        break label456;
      }
      a locala1 = this.kaG;
      y.i("MicroMsg.Fav.FavCdnService", "pauseAll");
      localCursor = ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().aQp();
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        while (localCursor.moveToNext())
        {
          localc = new c();
          localc.d(localCursor);
          y.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[] { localc.field_dataId });
          localc.field_status = 4;
          ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
          f.Nd().lL(localc.field_dataId);
          a.g(((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().CN(localc.field_dataId));
          locala1.CS(localc.field_dataId);
        }
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
      return;
    }
    Cursor localCursor = ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().aQq();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      while (localCursor.moveToNext())
      {
        localc = new c();
        localc.d(localCursor);
        y.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[] { localc.field_dataId });
        localc.field_status = 4;
        ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        f.Nd().lM(localc.field_dataId);
        a.g(((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().CN(localc.field_dataId));
        localException.CS(localc.field_dataId);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    label456:
    if ((!this.kaG.kaC) && (bool))
    {
      a locala2 = this.kaG;
      y.i("MicroMsg.Fav.FavCdnService", "startAll");
      ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().aQn();
      locala2.run();
    }
    this.kaG.kaC = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.1
 * JD-Core Version:    0.7.0.1
 */