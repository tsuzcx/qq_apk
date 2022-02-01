package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public final class ih
  extends h
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static ih gkc;
  
  static
  {
    AppMethodBeat.i(127419);
    gkc = null;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127411);
        String str = MAutoStorage.getCreateSQLs(by.ajs(), "FavItemInfo");
        AppMethodBeat.o(127411);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavSearchInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127412);
        String str = MAutoStorage.getCreateSQLs(ca.ajs(), "FavSearchInfo");
        AppMethodBeat.o(127412);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavEditInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127413);
        String str = MAutoStorage.getCreateSQLs(bx.ajs(), "FavEditInfo");
        AppMethodBeat.o(127413);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavCdnInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127414);
        String str = MAutoStorage.getCreateSQLs(bv.ajs(), "FavCdnInfo");
        AppMethodBeat.o(127414);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavConfigInfo".hashCode()), new ih.5());
    AppMethodBeat.o(127419);
  }
  
  private ih()
  {
    AppMethodBeat.i(127416);
    long l1 = System.currentTimeMillis();
    g.aAf();
    if (a.getUin() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = g.aAh().cachePath + "enFavorite.db";
      Log.d("MicroMsg.FavoriteDataBase", "db path", new Object[] { localObject });
      g.aAf();
      long l2 = a.getUin();
      q.dr(true);
      if (a("", (String)localObject, l2, baseDBFactories)) {
        break;
      }
      localObject = new b((byte)0);
      AppMethodBeat.o(127416);
      throw ((Throwable)localObject);
    }
    Object localObject = this.OtE;
    if (!Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.FavoriteDataBase", "dbinit failed :".concat(String.valueOf(localObject)));
      CrashReportFactory.reportRawMessage("init db Favorite Failed: [ " + (String)localObject + "]", "DBinit");
    }
    Log.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(127416);
  }
  
  public static ih ajW()
  {
    AppMethodBeat.i(127417);
    if (gkc == null) {
      gkc = new ih();
    }
    ih localih = gkc;
    AppMethodBeat.o(127417);
    return localih;
  }
  
  public final void CL(String paramString)
  {
    AppMethodBeat.i(127418);
    super.CL(paramString);
    gkc = null;
    AppMethodBeat.o(127418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ih
 * JD-Core Version:    0.7.0.1
 */