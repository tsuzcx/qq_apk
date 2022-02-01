package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends com.tencent.mm.sdk.e.j<j>
{
  public static final String[] SQL_CREATE;
  e db;
  
  static
  {
    AppMethodBeat.i(126894);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(j.info, "SightDraftInfo") };
    AppMethodBeat.o(126894);
  }
  
  public l(e parame)
  {
    super(parame, j.info, "SightDraftInfo", null);
    this.db = parame;
  }
  
  public final List<j> aNb()
  {
    AppMethodBeat.i(126892);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
    localObject = this.db.a((String)localObject, new String[] { "7" }, 2);
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
  
  public final Cursor aNc()
  {
    AppMethodBeat.i(126893);
    Cursor localCursor = this.db.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[] { "1" });
    AppMethodBeat.o(126893);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.l
 * JD-Core Version:    0.7.0.1
 */