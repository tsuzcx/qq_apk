package com.tencent.mm.h.c;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import junit.framework.Assert;

public final class fo
  extends h
{
  private static fo dgo = null;
  private static HashMap<Integer, h.d> dgp;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new fo.1());
    dgp.put(Integer.valueOf("FavSearchInfo".hashCode()), new fo.2());
    dgp.put(Integer.valueOf("FavEditInfo".hashCode()), new fo.3());
    dgp.put(Integer.valueOf("FavCdnInfo".hashCode()), new fo.4());
    dgp.put(Integer.valueOf("FavConfigInfo".hashCode()), new fo.5());
  }
  
  private fo()
  {
    long l = System.currentTimeMillis();
    g.DN();
    if (a.CK() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = g.DP().cachePath + "enFavorite.db";
      y.d("MicroMsg.FavoriteDataBase", "db path", new Object[] { str });
      g.DN();
      if (a("", str, a.CK(), q.zf(), dgp)) {
        break;
      }
      throw new com.tencent.mm.model.b((byte)0);
    }
    String str = this.uEk;
    if (!bk.bl(str))
    {
      y.e("MicroMsg.FavoriteDataBase", "dbinit failed :" + str);
      com.tencent.mm.sdk.a.b.t("init db Favorite Failed: [ " + str + "]", "DBinit");
    }
    y.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public static fo vy()
  {
    if (dgo == null) {
      dgo = new fo();
    }
    return dgo;
  }
  
  public final void ek(String paramString)
  {
    super.ek(paramString);
    dgo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.fo
 * JD-Core Version:    0.7.0.1
 */