package com.tencent.mm.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public final class ir
  extends com.tencent.mm.storagebase.h
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static ir iOj;
  
  static
  {
    AppMethodBeat.i(127419);
    iOj = null;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127411);
        String str = MAutoStorage.getCreateSQLs(by.aoY(), "FavItemInfo");
        AppMethodBeat.o(127411);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavSearchInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127412);
        String str = MAutoStorage.getCreateSQLs(ca.aoY(), "FavSearchInfo");
        AppMethodBeat.o(127412);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavEditInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127413);
        String str = MAutoStorage.getCreateSQLs(bx.aoY(), "FavEditInfo");
        AppMethodBeat.o(127413);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavCdnInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127414);
        String str = MAutoStorage.getCreateSQLs(bv.aoY(), "FavCdnInfo");
        AppMethodBeat.o(127414);
        return new String[] { str };
      }
    });
    baseDBFactories.put(Integer.valueOf("FavConfigInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(127415);
        String str = MAutoStorage.getCreateSQLs(bw.aoY(), "FavConfigInfo");
        AppMethodBeat.o(127415);
        return new String[] { str };
      }
    });
    AppMethodBeat.o(127419);
  }
  
  private ir()
  {
    AppMethodBeat.i(127416);
    long l1 = System.currentTimeMillis();
    com.tencent.mm.kernel.h.aHE();
    if (com.tencent.mm.kernel.b.getUin() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = com.tencent.mm.kernel.h.aHG().cachePath + "enFavorite.db";
      Log.d("MicroMsg.FavoriteDataBase", "db path", new Object[] { localObject });
      com.tencent.mm.kernel.h.aHE();
      long l2 = com.tencent.mm.kernel.b.getUin();
      q.dR(true);
      if (a("", (String)localObject, l2, baseDBFactories)) {
        break;
      }
      localObject = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(127416);
      throw ((Throwable)localObject);
    }
    Object localObject = this.VJF;
    if (!Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.FavoriteDataBase", "dbinit failed :".concat(String.valueOf(localObject)));
      CrashReportFactory.reportRawMessage("init db Favorite Failed: [ " + (String)localObject + "]", "DBinit");
    }
    Log.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(127416);
  }
  
  public static ir apU()
  {
    AppMethodBeat.i(127417);
    if (iOj == null) {
      iOj = new ir();
    }
    ir localir = iOj;
    AppMethodBeat.o(127417);
    return localir;
  }
  
  public final void JA(String paramString)
  {
    AppMethodBeat.i(127418);
    super.JA(paramString);
    iOj = null;
    AppMethodBeat.o(127418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ir
 * JD-Core Version:    0.7.0.1
 */