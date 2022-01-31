package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;

final class b$d
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private long kau;
  private int kaw;
  
  private b$d(b paramb, long paramLong)
  {
    this.kau = paramLong;
  }
  
  public final String afJ()
  {
    return String.format("{favItemId: %d transactionCount: %d}", new Object[] { Long.valueOf(this.kau), Integer.valueOf(this.kaw) });
  }
  
  public final boolean execute()
  {
    if (this.kap.kan == null) {
      y.e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
    }
    for (;;)
    {
      return true;
      y.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
      Cursor localCursor2 = this.kap.kan.a("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[] { String.valueOf(this.kau) }, 2);
      Cursor localCursor3 = localCursor2;
      Cursor localCursor1 = localCursor2;
      Object localObject1 = localCursor2;
      try
      {
        if (localCursor2.moveToFirst())
        {
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          b.c localc = new b.c(this.kap, (byte)0);
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          localc.d(localCursor2);
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          localCursor2.close();
          localCursor2 = null;
          Object localObject3 = null;
          localCursor3 = null;
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          this.kap.kam.beginTransaction();
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          long l = this.kau;
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          this.kap.kam.c(c.kuO, l);
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          this.kaw = b.a(this.kap, localc);
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          this.kap.kam.commit();
        }
        if (localCursor3 == null) {
          continue;
        }
        localCursor3.close();
        return true;
      }
      catch (Exception localException)
      {
        localObject1 = localCursor1;
        throw localException;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
  }
  
  public final String getName()
  {
    return "InsertFavItemTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */