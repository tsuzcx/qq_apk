package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends MAutoStorage<q>
{
  public static final String[] SQL_CREATE;
  ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(126894);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(q.info, "SightDraftInfo") };
    AppMethodBeat.o(126894);
  }
  
  public s(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, q.info, "SightDraftInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final List<q> bOb()
  {
    AppMethodBeat.i(126892);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
    localObject = this.db.rawQuery((String)localObject, new String[] { "7" }, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(126892);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      q localq = new q();
      localq.convertFrom((Cursor)localObject);
      localLinkedList.add(localq);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(126892);
    return localLinkedList;
  }
  
  public final Cursor bOc()
  {
    AppMethodBeat.i(126893);
    Cursor localCursor = this.db.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[] { "1" });
    AppMethodBeat.o(126893);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */