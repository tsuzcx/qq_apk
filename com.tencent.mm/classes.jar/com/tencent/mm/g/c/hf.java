package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public final class hf
  extends h
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static hf fhm;
  
  static
  {
    AppMethodBeat.i(127419);
    fhm = null;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127411);
        String str = j.getCreateSQLs(bu.So(), "FavItemInfo");
        AppMethodBeat.o(127411);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavSearchInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127412);
        String str = j.getCreateSQLs(bw.So(), "FavSearchInfo");
        AppMethodBeat.o(127412);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavEditInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127413);
        String str = j.getCreateSQLs(bt.So(), "FavEditInfo");
        AppMethodBeat.o(127413);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavCdnInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127414);
        String str = j.getCreateSQLs(br.So(), "FavCdnInfo");
        AppMethodBeat.o(127414);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavConfigInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127415);
        String str = j.getCreateSQLs(bs.So(), "FavConfigInfo");
        AppMethodBeat.o(127415);
        return new String[] { str };
      }
    });
    AppMethodBeat.o(127419);
  }
  
  private hf()
  {
    AppMethodBeat.i(127416);
    long l1 = System.currentTimeMillis();
    g.afz();
    if (a.getUin() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = g.afB().cachePath + "enFavorite.db";
      ad.d("MicroMsg.FavoriteDataBase", "db path", new Object[] { localObject });
      g.afz();
      long l2 = a.getUin();
      q.cG(true);
      if (a("", (String)localObject, l2, baseDBFactories)) {
        break;
      }
      localObject = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(127416);
      throw ((Throwable)localObject);
    }
    Object localObject = this.FCL;
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject))
    {
      ad.e("MicroMsg.FavoriteDataBase", "dbinit failed :".concat(String.valueOf(localObject)));
      com.tencent.mm.sdk.a.b.M("init db Favorite Failed: [ " + (String)localObject + "]", "DBinit");
    }
    ad.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(127416);
  }
  
  public static hf SP()
  {
    AppMethodBeat.i(127417);
    if (fhm == null) {
      fhm = new hf();
    }
    hf localhf = fhm;
    AppMethodBeat.o(127417);
    return localhf;
  }
  
  public final void oi(String paramString)
  {
    AppMethodBeat.i(127418);
    super.oi(paramString);
    fhm = null;
    AppMethodBeat.o(127418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hf
 * JD-Core Version:    0.7.0.1
 */