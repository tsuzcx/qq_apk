package com.danikula.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.Preconditions;
import com.danikula.videocache.SourceInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DatabaseSourceInfoStorage
  extends SQLiteOpenHelper
  implements SourceInfoStorage
{
  private static final String[] ALL_COLUMNS = { "_id", "url", "length", "mime" };
  private static final String COLUMN_ID = "_id";
  private static final String COLUMN_LENGTH = "length";
  private static final String COLUMN_MIME = "mime";
  private static final String COLUMN_URL = "url";
  private static final String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
  private static final String TABLE = "SourceInfo";
  
  DatabaseSourceInfoStorage(Context paramContext)
  {
    super(paramContext, "AndroidVideoCache.db", null, 1);
    AppMethodBeat.i(183630);
    Preconditions.checkNotNull(paramContext);
    AppMethodBeat.o(183630);
  }
  
  private ContentValues convert(SourceInfo paramSourceInfo)
  {
    AppMethodBeat.i(190360);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("url", paramSourceInfo.url);
    localContentValues.put("length", Long.valueOf(paramSourceInfo.length));
    localContentValues.put("mime", paramSourceInfo.mime);
    AppMethodBeat.o(190360);
    return localContentValues;
  }
  
  private SourceInfo convert(Cursor paramCursor)
  {
    AppMethodBeat.i(190359);
    paramCursor = new SourceInfo(paramCursor.getString(paramCursor.getColumnIndexOrThrow("url")), paramCursor.getLong(paramCursor.getColumnIndexOrThrow("length")), paramCursor.getString(paramCursor.getColumnIndexOrThrow("mime")));
    AppMethodBeat.o(190359);
    return paramCursor;
  }
  
  /* Error */
  public SourceInfo get(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 108
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 54	com/danikula/videocache/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 112	com/danikula/videocache/sourcestorage/DatabaseSourceInfoStorage:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc 27
    //   19: getstatic 33	com/danikula/videocache/sourcestorage/DatabaseSourceInfoStorage:ALL_COLUMNS	[Ljava/lang/String;
    //   22: ldc 114
    //   24: iconst_1
    //   25: anewarray 31	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 120	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +14 -> 54
    //   43: aload_3
    //   44: invokeinterface 124 1 0
    //   49: istore_2
    //   50: iload_2
    //   51: ifne +22 -> 73
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_3
    //   57: ifnull +9 -> 66
    //   60: aload_3
    //   61: invokeinterface 127 1 0
    //   66: ldc 108
    //   68: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_1
    //   72: areturn
    //   73: aload_0
    //   74: aload_3
    //   75: invokespecial 129	com/danikula/videocache/sourcestorage/DatabaseSourceInfoStorage:convert	(Landroid/database/Cursor;)Lcom/danikula/videocache/SourceInfo;
    //   78: astore_1
    //   79: goto -23 -> 56
    //   82: astore_1
    //   83: aload 4
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +9 -> 96
    //   90: aload_3
    //   91: invokeinterface 127 1 0
    //   96: ldc 108
    //   98: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: goto -18 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	DatabaseSourceInfoStorage
    //   0	107	1	paramString	String
    //   49	2	2	bool	boolean
    //   38	53	3	localObject1	Object
    //   1	83	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	39	82	finally
    //   43	50	103	finally
    //   73	79	103	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(183631);
    Preconditions.checkNotNull(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    AppMethodBeat.o(183631);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(183632);
    paramSQLiteDatabase = new IllegalStateException("Should not be called. There is no any migration");
    AppMethodBeat.o(183632);
    throw paramSQLiteDatabase;
  }
  
  public void put(String paramString, SourceInfo paramSourceInfo)
  {
    AppMethodBeat.i(183634);
    Preconditions.checkAllNotNull(new Object[] { paramString, paramSourceInfo });
    if (get(paramString) != null) {}
    for (int i = 1;; i = 0)
    {
      paramSourceInfo = convert(paramSourceInfo);
      if (i == 0) {
        break;
      }
      getWritableDatabase().update("SourceInfo", paramSourceInfo, "url=?", new String[] { paramString });
      AppMethodBeat.o(183634);
      return;
    }
    getWritableDatabase().insert("SourceInfo", null, paramSourceInfo);
    AppMethodBeat.o(183634);
  }
  
  public void release()
  {
    AppMethodBeat.i(190358);
    close();
    AppMethodBeat.o(190358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.sourcestorage.DatabaseSourceInfoStorage
 * JD-Core Version:    0.7.0.1
 */