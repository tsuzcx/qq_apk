package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;

public final class k
{
  public static int Gf()
  {
    int j;
    if (!g.DK())
    {
      y.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
      j = 0;
      return j;
    }
    Cursor localCursor = ((j)g.r(j.class)).FB().cuM();
    if ((localCursor != null) && (localCursor.getCount() > 0)) {
      localCursor.moveToFirst();
    }
    for (int i = localCursor.getInt(0);; i = 0)
    {
      j = i;
      if (localCursor == null) {
        break;
      }
      localCursor.close();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */