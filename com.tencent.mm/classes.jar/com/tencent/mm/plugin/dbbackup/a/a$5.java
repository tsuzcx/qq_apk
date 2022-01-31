package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

final class a$5
  implements a.d
{
  a$5(a parama, int paramInt, HashMap paramHashMap) {}
  
  public final boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement)
  {
    AppMethodBeat.i(19005);
    long l = paramCursor.getLong(this.kVb);
    paramCursor = (Long)this.kUZ.get(Long.valueOf(l));
    if (paramCursor != null) {
      paramSQLiteStatement.bindLong(this.kVb + 1, paramCursor.longValue());
    }
    AppMethodBeat.o(19005);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a.5
 * JD-Core Version:    0.7.0.1
 */