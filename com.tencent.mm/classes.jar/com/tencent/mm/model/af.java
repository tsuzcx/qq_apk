package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;

public final class af
{
  public static void arB()
  {
    AppMethodBeat.i(20321);
    Cursor localCursor = c.apM().eKR();
    if (localCursor == null) {}
    for (int i = 0;; i = localCursor.getCount())
    {
      ad.i("MicroMsg.HardCodeUpdateTask", "[unstarAllBizContactFor50] size:%s", new Object[] { Integer.valueOf(i) });
      if (localCursor.moveToFirst()) {
        do
        {
          com.tencent.mm.storage.af localaf = new com.tencent.mm.storage.af();
          localaf.convertFrom(localCursor);
          localaf.Zw();
          c.apM().c(localaf.field_username, localaf);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
      AppMethodBeat.o(20321);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.af
 * JD-Core Version:    0.7.0.1
 */