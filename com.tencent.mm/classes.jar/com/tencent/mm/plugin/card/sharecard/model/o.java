package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends i<n>
{
  public static final String[] dXp = { i.a(n.buS, "ShareCardSyncItemInfo") };
  private e dXw;
  
  public o(e parame)
  {
    super(parame, n.buS, "ShareCardSyncItemInfo", null);
    this.dXw = parame;
  }
  
  public final List<n> aAq()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.dXw.a("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
    while (localCursor.moveToNext())
    {
      n localn = new n();
      localn.d(localCursor);
      localArrayList.add(localn);
    }
    localCursor.close();
    y.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.o
 * JD-Core Version:    0.7.0.1
 */