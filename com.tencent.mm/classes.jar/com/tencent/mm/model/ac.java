package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class ac
{
  public static void aag()
  {
    AppMethodBeat.i(16275);
    Cursor localCursor = c.YA().dwO();
    if (localCursor == null) {}
    for (int i = 0;; i = localCursor.getCount())
    {
      ab.i("MicroMsg.HardCodeUpdateTask", "[unstarAllBizContactFor50] size:%s", new Object[] { Integer.valueOf(i) });
      if (localCursor.moveToFirst()) {
        do
        {
          ad localad = new ad();
          localad.convertFrom(localCursor);
          localad.NJ();
          c.YA().b(localad.field_username, localad);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
      AppMethodBeat.o(16275);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.ac
 * JD-Core Version:    0.7.0.1
 */