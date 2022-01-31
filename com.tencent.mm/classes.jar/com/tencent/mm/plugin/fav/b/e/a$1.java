package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class a$1
  extends n.a
{
  a$1(a parama) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(5325);
    boolean bool;
    c localc;
    try
    {
      bool = at.isWifi(ah.getContext());
      ab.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(this.mvc.muY) });
      if ((paramInt != 4) && (paramInt != 6))
      {
        this.mvc.muY = bool;
        AppMethodBeat.o(5325);
        return;
      }
      if ((!this.mvc.muY) || (bool)) {
        break label474;
      }
      a locala1 = this.mvc;
      ab.i("MicroMsg.Fav.FavCdnService", "pauseAll");
      localCursor = ((ae)g.G(ae.class)).getFavCdnStorage().bwE();
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        while (localCursor.moveToNext())
        {
          localc = new c();
          localc.convertFrom(localCursor);
          ab.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[] { localc.field_dataId });
          localc.field_status = 4;
          ((ae)g.G(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
          f.afO().sI(localc.field_dataId);
          a.g(((ae)g.G(ae.class)).getFavCdnStorage().NP(localc.field_dataId));
          locala1.NU(localc.field_dataId);
        }
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
      AppMethodBeat.o(5325);
      return;
    }
    Cursor localCursor = ((ae)g.G(ae.class)).getFavCdnStorage().bwF();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      while (localCursor.moveToNext())
      {
        localc = new c();
        localc.convertFrom(localCursor);
        ab.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[] { localc.field_dataId });
        localc.field_status = 4;
        ((ae)g.G(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        f.afO().sJ(localc.field_dataId);
        a.g(((ae)g.G(ae.class)).getFavCdnStorage().NP(localc.field_dataId));
        localException.NU(localc.field_dataId);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    label474:
    if ((!this.mvc.muY) && (bool))
    {
      a locala2 = this.mvc;
      ab.i("MicroMsg.Fav.FavCdnService", "startAll");
      ((ae)g.G(ae.class)).getFavCdnStorage().startAll();
      locala2.run();
    }
    this.mvc.muY = bool;
    AppMethodBeat.o(5325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.1
 * JD-Core Version:    0.7.0.1
 */