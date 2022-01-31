package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;

final class b$d
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private long muQ;
  private int muS;
  
  private b$d(b paramb, long paramLong)
  {
    this.muQ = paramLong;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(5308);
    String str = String.format("{favItemId: %d transactionCount: %d}", new Object[] { Long.valueOf(this.muQ), Integer.valueOf(this.muS) });
    AppMethodBeat.o(5308);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(5307);
    if (this.muL.muJ == null)
    {
      ab.e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
      AppMethodBeat.o(5307);
      return true;
    }
    ab.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
    Cursor localCursor2 = this.muL.muJ.a("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[] { String.valueOf(this.muQ) }, 2);
    Cursor localCursor3 = localCursor2;
    Cursor localCursor1 = localCursor2;
    Object localObject1 = localCursor2;
    try
    {
      if (localCursor2.moveToFirst())
      {
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        b.c localc = new b.c(this.muL, (byte)0);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        localc.convertFrom(localCursor2);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        localCursor2.close();
        localCursor2 = null;
        Object localObject3 = null;
        localCursor3 = null;
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        this.muL.muI.beginTransaction();
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        long l = this.muQ;
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        this.muL.muI.c(c.mQB, l);
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        this.muS = b.a(this.muL, localc);
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        this.muL.muI.commit();
      }
      if (localCursor3 != null) {
        localCursor3.close();
      }
      AppMethodBeat.o(5307);
      return true;
    }
    catch (Exception localException)
    {
      localObject1 = localCursor1;
      AppMethodBeat.o(5307);
      localObject1 = localCursor1;
      throw localException;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      AppMethodBeat.o(5307);
    }
  }
  
  public final String getName()
  {
    return "InsertFavItemTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */