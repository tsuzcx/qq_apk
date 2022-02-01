package com.tencent.mm.plugin.dbbackup;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.database.SQLiteDatabase;

final class c$8
  implements ap.a
{
  c$8(c paramc) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(193203);
    SQLiteDatabase localSQLiteDatabase = g.ajC().gBq.ftT();
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(193203);
      return false;
    case 1: 
      localSQLiteDatabase.beginTransaction();
      AppMethodBeat.o(193203);
      return true;
    }
    localSQLiteDatabase.endTransaction();
    AppMethodBeat.o(193203);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.8
 * JD-Core Version:    0.7.0.1
 */