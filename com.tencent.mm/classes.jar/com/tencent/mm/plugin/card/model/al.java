package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class al
  extends j<ak>
{
  public static final String[] SQL_CREATE;
  e db;
  
  static
  {
    AppMethodBeat.i(112871);
    SQL_CREATE = new String[] { j.getCreateSQLs(ak.info, "PendingCardId") };
    AppMethodBeat.o(112871);
  }
  
  public al(e parame)
  {
    super(parame, ak.info, "PendingCardId", null);
    this.db = parame;
  }
  
  public final List<ak> bUL()
  {
    AppMethodBeat.i(112870);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select * from PendingCardId where retryCount < 10", null, 2);
    while (localCursor.moveToNext())
    {
      ak localak = new ak();
      localak.convertFrom(localCursor);
      localArrayList.add(localak);
    }
    localCursor.close();
    ad.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(112870);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.al
 * JD-Core Version:    0.7.0.1
 */