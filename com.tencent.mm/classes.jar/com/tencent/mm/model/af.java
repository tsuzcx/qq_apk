package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public final class af
{
  public static void ays()
  {
    AppMethodBeat.i(20321);
    Cursor localCursor = c.awB().fat();
    if (localCursor == null) {}
    for (int i = 0;; i = localCursor.getCount())
    {
      ac.i("MicroMsg.HardCodeUpdateTask", "[unstarAllBizContactFor50] size:%s", new Object[] { Integer.valueOf(i) });
      if (localCursor.moveToFirst()) {
        do
        {
          ai localai = new ai();
          localai.convertFrom(localCursor);
          localai.aar();
          c.awB().c(localai.field_username, localai);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
      AppMethodBeat.o(20321);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.af
 * JD-Core Version:    0.7.0.1
 */