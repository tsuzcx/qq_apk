package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

final class a$3
  implements a.d
{
  a$3(a parama, int paramInt, long[] paramArrayOfLong, HashMap paramHashMap) {}
  
  public final boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement)
  {
    AppMethodBeat.i(19003);
    long l1 = paramCursor.getLong(this.kUX);
    paramCursor = this.kUY;
    long l2 = paramCursor[0];
    paramCursor[0] = (1L + l2);
    this.kUZ.put(Long.valueOf(l1), Long.valueOf(l2));
    paramSQLiteStatement.bindLong(this.kUX + 1, l2);
    if ((this.kUY[0] > 1000000L) && (this.kUY[0] <= 10000000L)) {
      this.kUY[0] = 10000001L;
    }
    AppMethodBeat.o(19003);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a.3
 * JD-Core Version:    0.7.0.1
 */