package com.b.a.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.b.a.l;
import com.b.a.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends SQLiteOpenHelper
  implements b
{
  private static final String[] cBB = { "_id", "url", "length", "mime" };
  
  public a(Context paramContext)
  {
    super(paramContext, "AndroidVideoCache.db", null, 1);
    AppMethodBeat.i(183630);
    l.checkNotNull(paramContext);
    AppMethodBeat.o(183630);
  }
  
  public final void a(String paramString, q paramq)
  {
    AppMethodBeat.i(183634);
    int i = 0;
    while (i < 2)
    {
      if (new Object[] { paramString, paramq }[i] == null)
      {
        paramString = new NullPointerException();
        AppMethodBeat.o(183634);
        throw paramString;
      }
      i += 1;
    }
    if (ck(paramString) != null) {}
    ContentValues localContentValues;
    for (i = 1;; i = 0)
    {
      localContentValues = new ContentValues();
      localContentValues.put("url", paramq.url);
      localContentValues.put("length", Long.valueOf(paramq.length));
      localContentValues.put("mime", paramq.cBw);
      if (i == 0) {
        break;
      }
      getWritableDatabase().update("SourceInfo", localContentValues, "url=?", new String[] { paramString });
      AppMethodBeat.o(183634);
      return;
    }
    getWritableDatabase().insert("SourceInfo", null, localContentValues);
    AppMethodBeat.o(183634);
  }
  
  public final q ck(String paramString)
  {
    localObject2 = null;
    AppMethodBeat.i(183633);
    l.checkNotNull(paramString);
    try
    {
      localObject1 = getReadableDatabase().query("SourceInfo", cBB, "url=?", new String[] { paramString }, null, null, null);
      if (localObject1 != null) {}
      try
      {
        boolean bool = ((Cursor)localObject1).moveToFirst();
        if (!bool) {}
        for (paramString = null;; paramString = new q(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("url")), ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("length")), ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime"))))
        {
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
          AppMethodBeat.o(183633);
          return paramString;
        }
        if (localObject1 == null) {
          break label137;
        }
      }
      finally {}
    }
    finally
    {
      label137:
      Object localObject1 = localObject2;
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(183633);
    throw paramString;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(183631);
    l.checkNotNull(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    AppMethodBeat.o(183631);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(183632);
    paramSQLiteDatabase = new IllegalStateException("Should not be called. There is no any migration");
    AppMethodBeat.o(183632);
    throw paramSQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */