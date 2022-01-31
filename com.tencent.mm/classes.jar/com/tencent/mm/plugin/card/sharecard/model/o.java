package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends j<n>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(88088);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "ShareCardSyncItemInfo") };
    AppMethodBeat.o(88088);
  }
  
  public o(e parame)
  {
    super(parame, n.info, "ShareCardSyncItemInfo", null);
    this.db = parame;
  }
  
  public final List<n> bcb()
  {
    AppMethodBeat.i(88087);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
    while (localCursor.moveToNext())
    {
      n localn = new n();
      localn.convertFrom(localCursor);
      localArrayList.add(localn);
    }
    localCursor.close();
    ab.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(88087);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.o
 * JD-Core Version:    0.7.0.1
 */