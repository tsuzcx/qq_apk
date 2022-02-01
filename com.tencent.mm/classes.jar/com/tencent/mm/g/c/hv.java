package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public final class hv
  extends h
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static hv fES;
  
  static
  {
    AppMethodBeat.i(127419);
    fES = null;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127411);
        String str = j.getCreateSQLs(bx.VD(), "FavItemInfo");
        AppMethodBeat.o(127411);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavSearchInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127412);
        String str = j.getCreateSQLs(bz.VD(), "FavSearchInfo");
        AppMethodBeat.o(127412);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavEditInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127413);
        String str = j.getCreateSQLs(bw.VD(), "FavEditInfo");
        AppMethodBeat.o(127413);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavCdnInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127414);
        String str = j.getCreateSQLs(bu.VD(), "FavCdnInfo");
        AppMethodBeat.o(127414);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavConfigInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127415);
        String str = j.getCreateSQLs(bv.VD(), "FavConfigInfo");
        AppMethodBeat.o(127415);
        return new String[] { str };
      }
    });
    AppMethodBeat.o(127419);
  }
  
  private hv()
  {
    AppMethodBeat.i(127416);
    long l1 = System.currentTimeMillis();
    g.ajP();
    if (a.getUin() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = g.ajR().cachePath + "enFavorite.db";
      ae.d("MicroMsg.FavoriteDataBase", "db path", new Object[] { localObject });
      g.ajP();
      long l2 = a.getUin();
      q.cH(true);
      if (a("", (String)localObject, l2, baseDBFactories)) {
        break;
      }
      localObject = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(127416);
      throw ((Throwable)localObject);
    }
    Object localObject = this.JjM;
    if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject))
    {
      ae.e("MicroMsg.FavoriteDataBase", "dbinit failed :".concat(String.valueOf(localObject)));
      com.tencent.mm.sdk.a.b.O("init db Favorite Failed: [ " + (String)localObject + "]", "DBinit");
    }
    ae.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(127416);
  }
  
  public static hv Wi()
  {
    AppMethodBeat.i(127417);
    if (fES == null) {
      fES = new hv();
    }
    hv localhv = fES;
    AppMethodBeat.o(127417);
    return localhv;
  }
  
  public final void uv(String paramString)
  {
    AppMethodBeat.i(127418);
    super.uv(paramString);
    fES = null;
    AppMethodBeat.o(127418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hv
 * JD-Core Version:    0.7.0.1
 */