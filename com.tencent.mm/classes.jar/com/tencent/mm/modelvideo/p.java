package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends MAutoStorage<n>
{
  public static final String[] SQL_CREATE;
  ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(126894);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(n.info, "SightDraftInfo") };
    AppMethodBeat.o(126894);
  }
  
  public p(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, n.info, "SightDraftInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public p(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public final List<n> bqv()
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
      n localn = new n();
      localn.convertFrom((Cursor)localObject);
      localLinkedList.add(localn);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(126892);
    return localLinkedList;
  }
  
  public final Cursor bqw()
  {
    AppMethodBeat.i(126893);
    Cursor localCursor = this.db.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[] { "1" });
    AppMethodBeat.o(126893);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */