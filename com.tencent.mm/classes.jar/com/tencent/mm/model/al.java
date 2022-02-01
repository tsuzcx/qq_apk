package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class al
{
  public static void ben()
  {
    AppMethodBeat.i(20321);
    Cursor localCursor = c.bbL().hyo();
    if (localCursor == null) {}
    for (int i = 0;; i = localCursor.getCount())
    {
      Log.i("MicroMsg.HardCodeUpdateTask", "[unstarAllBizContactFor50] size:%s", new Object[] { Integer.valueOf(i) });
      if (localCursor.moveToFirst()) {
        do
        {
          as localas = new as();
          localas.convertFrom(localCursor);
          localas.axA();
          c.bbL().c(localas.field_username, localas);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
      AppMethodBeat.o(20321);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.al
 * JD-Core Version:    0.7.0.1
 */