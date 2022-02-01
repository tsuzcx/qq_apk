package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public final class ag
{
  public static void aBw()
  {
    AppMethodBeat.i(20321);
    Cursor localCursor = c.azp().fqw();
    if (localCursor == null) {}
    for (int i = 0;; i = localCursor.getCount())
    {
      ad.i("MicroMsg.HardCodeUpdateTask", "[unstarAllBizContactFor50] size:%s", new Object[] { Integer.valueOf(i) });
      if (localCursor.moveToFirst()) {
        do
        {
          am localam = new am();
          localam.convertFrom(localCursor);
          localam.acT();
          c.azp().c(localam.field_username, localam);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
      AppMethodBeat.o(20321);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ag
 * JD-Core Version:    0.7.0.1
 */