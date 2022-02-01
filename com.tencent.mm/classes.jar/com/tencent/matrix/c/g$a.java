package com.tencent.matrix.c;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.ISQLiteExecutionDelegate;
import com.tencent.wcdb.database.SQLiteDatabase;

final class g$a
  implements ISQLiteExecutionDelegate
{
  private final SQLiteDatabase mDb;
  
  g$a(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDb = paramSQLiteDatabase;
  }
  
  public final void execSQL(String paramString)
  {
    if (!this.mDb.isOpen())
    {
      Log.w("Matrix.MatrixSQLiteLintManager", "rawQuery db close", new Object[0]);
      return;
    }
    this.mDb.execSQL(paramString);
  }
  
  public final Cursor rawQuery(String paramString, String... paramVarArgs)
  {
    if (!this.mDb.isOpen())
    {
      Log.w("Matrix.MatrixSQLiteLintManager", "rawQuery db close", new Object[0]);
      return null;
    }
    return this.mDb.rawQuery(paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.c.g.a
 * JD-Core Version:    0.7.0.1
 */