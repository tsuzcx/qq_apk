package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends MAutoStorage<n>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(113027);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(n.info, "ShareCardSyncItemInfo") };
    AppMethodBeat.o(113027);
  }
  
  public o(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, n.info, "ShareCardSyncItemInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final List<n> dkH()
  {
    AppMethodBeat.i(113026);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.rawQuery("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
    while (localCursor.moveToNext())
    {
      n localn = new n();
      localn.convertFrom(localCursor);
      localArrayList.add(localn);
    }
    localCursor.close();
    Log.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(113026);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.o
 * JD-Core Version:    0.7.0.1
 */