package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

final class a$5
  implements a.c
{
  a$5(a parama, int paramInt, HashMap paramHashMap) {}
  
  public final boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement)
  {
    long l = paramCursor.getLong(this.iNY);
    paramCursor = (Long)this.iNW.get(Long.valueOf(l));
    if (paramCursor != null) {
      paramSQLiteStatement.bindLong(this.iNY + 1, paramCursor.longValue());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a.5
 * JD-Core Version:    0.7.0.1
 */