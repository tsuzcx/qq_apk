package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.br;

public final class o
{
  public static int aAu()
  {
    AppMethodBeat.i(20317);
    if (!g.ajM())
    {
      ae.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
      AppMethodBeat.o(20317);
      return 0;
    }
    Cursor localCursor = ((l)g.ab(l.class)).azL().fuT();
    if ((localCursor != null) && (localCursor.getCount() > 0)) {
      localCursor.moveToFirst();
    }
    for (int i = localCursor.getInt(0);; i = 0)
    {
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(20317);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.o
 * JD-Core Version:    0.7.0.1
 */