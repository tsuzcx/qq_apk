package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public final class ah
{
  public static void aBM()
  {
    AppMethodBeat.i(20321);
    Cursor localCursor = c.azF().fuw();
    if (localCursor == null) {}
    for (int i = 0;; i = localCursor.getCount())
    {
      ae.i("MicroMsg.HardCodeUpdateTask", "[unstarAllBizContactFor50] size:%s", new Object[] { Integer.valueOf(i) });
      if (localCursor.moveToFirst()) {
        do
        {
          an localan = new an();
          localan.convertFrom(localCursor);
          localan.adf();
          c.azF().c(localan.field_username, localan);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
      AppMethodBeat.o(20321);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ah
 * JD-Core Version:    0.7.0.1
 */