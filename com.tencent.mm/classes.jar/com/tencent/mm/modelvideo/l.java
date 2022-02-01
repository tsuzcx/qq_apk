package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends MAutoStorage<j>
{
  public static final String[] SQL_CREATE;
  ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(126894);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.info, "SightDraftInfo") };
    AppMethodBeat.o(126894);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.info, "SightDraftInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final List<j> bhd()
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
      j localj = new j();
      localj.convertFrom((Cursor)localObject);
      localLinkedList.add(localj);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(126892);
    return localLinkedList;
  }
  
  public final Cursor bhe()
  {
    AppMethodBeat.i(126893);
    Cursor localCursor = this.db.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[] { "1" });
    AppMethodBeat.o(126893);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.l
 * JD-Core Version:    0.7.0.1
 */