package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class al
  extends i<ak>
{
  public static final String[] dXp = { i.a(ak.buS, "PendingCardId") };
  e dXw;
  
  public al(e parame)
  {
    super(parame, ak.buS, "PendingCardId", null);
    this.dXw = parame;
  }
  
  public final List<ak> aAq()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.dXw.a("select * from PendingCardId where retryCount < 10", null, 2);
    while (localCursor.moveToNext())
    {
      ak localak = new ak();
      localak.d(localCursor);
      localArrayList.add(localak);
    }
    localCursor.close();
    y.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.al
 * JD-Core Version:    0.7.0.1
 */