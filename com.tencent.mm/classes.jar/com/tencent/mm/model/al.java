package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class al
{
  public static void bCg()
  {
    AppMethodBeat.i(20321);
    Cursor localCursor = c.bzA().iZV();
    if (localCursor == null) {}
    for (int i = 0;; i = localCursor.getCount())
    {
      Log.i("MicroMsg.HardCodeUpdateTask", "[unstarAllBizContactFor50] size:%s", new Object[] { Integer.valueOf(i) });
      if (localCursor.moveToFirst()) {
        do
        {
          au localau = new au();
          localau.convertFrom(localCursor);
          localau.aSc();
          c.bzA().d(localau.field_username, localau);
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