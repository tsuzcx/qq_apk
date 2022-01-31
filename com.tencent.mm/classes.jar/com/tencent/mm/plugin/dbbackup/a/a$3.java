package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

final class a$3
  implements a.c
{
  a$3(a parama, int paramInt, long[] paramArrayOfLong, HashMap paramHashMap) {}
  
  public final boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement)
  {
    long l1 = paramCursor.getLong(this.iNU);
    paramCursor = this.iNV;
    long l2 = paramCursor[0];
    paramCursor[0] = (1L + l2);
    this.iNW.put(Long.valueOf(l1), Long.valueOf(l2));
    paramSQLiteStatement.bindLong(this.iNU + 1, l2);
    if ((this.iNV[0] > 1000000L) && (this.iNV[0] <= 10000000L)) {
      this.iNV[0] = 10000001L;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a.3
 * JD-Core Version:    0.7.0.1
 */