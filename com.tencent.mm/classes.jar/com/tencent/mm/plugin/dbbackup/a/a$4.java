package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

final class a$4
  implements a.d
{
  a$4(a parama, int paramInt, HashMap paramHashMap) {}
  
  public final boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement)
  {
    AppMethodBeat.i(19004);
    long l = paramCursor.getLong(this.kVa);
    paramCursor = (Long)this.kUZ.get(Long.valueOf(l));
    if (paramCursor != null) {
      paramSQLiteStatement.bindLong(this.kVa + 1, paramCursor.longValue());
    }
    AppMethodBeat.o(19004);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a.4
 * JD-Core Version:    0.7.0.1
 */