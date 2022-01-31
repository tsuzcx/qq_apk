package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import junit.framework.Assert;

public final class gc
  extends h
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private static gc dXB;
  
  static
  {
    AppMethodBeat.i(51352);
    dXB = null;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new gc.1());
    baseDBFactories.put(Integer.valueOf("FavSearchInfo".hashCode()), new gc.2());
    baseDBFactories.put(Integer.valueOf("FavEditInfo".hashCode()), new gc.3());
    baseDBFactories.put(Integer.valueOf("FavCdnInfo".hashCode()), new gc.4());
    baseDBFactories.put(Integer.valueOf("FavConfigInfo".hashCode()), new gc.5());
    AppMethodBeat.o(51352);
  }
  
  private gc()
  {
    AppMethodBeat.i(51349);
    long l1 = System.currentTimeMillis();
    g.RJ();
    if (a.getUin() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = g.RL().cachePath + "enFavorite.db";
      ab.d("MicroMsg.FavoriteDataBase", "db path", new Object[] { localObject });
      g.RJ();
      long l2 = a.getUin();
      q.bP(true);
      if (a("", (String)localObject, l2, baseDBFactories)) {
        break;
      }
      localObject = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(51349);
      throw ((Throwable)localObject);
    }
    Object localObject = this.yQT;
    if (!bo.isNullOrNil((String)localObject))
    {
      ab.e("MicroMsg.FavoriteDataBase", "dbinit failed :".concat(String.valueOf(localObject)));
      com.tencent.mm.sdk.a.b.G("init db Favorite Failed: [ " + (String)localObject + "]", "DBinit");
    }
    ab.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(51349);
  }
  
  public static gc HH()
  {
    AppMethodBeat.i(51350);
    if (dXB == null) {
      dXB = new gc();
    }
    gc localgc = dXB;
    AppMethodBeat.o(51350);
    return localgc;
  }
  
  public final void kr(String paramString)
  {
    AppMethodBeat.i(51351);
    super.kr(paramString);
    dXB = null;
    AppMethodBeat.o(51351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.c.gc
 * JD-Core Version:    0.7.0.1
 */