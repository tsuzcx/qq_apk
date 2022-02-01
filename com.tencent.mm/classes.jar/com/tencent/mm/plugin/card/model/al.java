package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class al
  extends MAutoStorage<ak>
{
  public static final String[] SQL_CREATE;
  ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(112871);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ak.info, "PendingCardId") };
    AppMethodBeat.o(112871);
  }
  
  public al(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ak.info, "PendingCardId", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final List<ak> ctO()
  {
    AppMethodBeat.i(112870);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.rawQuery("select * from PendingCardId where retryCount < 10", null, 2);
    while (localCursor.moveToNext())
    {
      ak localak = new ak();
      localak.convertFrom(localCursor);
      localArrayList.add(localak);
    }
    localCursor.close();
    Log.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(112870);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.al
 * JD-Core Version:    0.7.0.1
 */