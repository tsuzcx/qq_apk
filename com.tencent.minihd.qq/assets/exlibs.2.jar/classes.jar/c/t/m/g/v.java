package c.t.m.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class v
  extends SQLiteOpenHelper
  implements u
{
  private static v a;
  
  private v(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 2);
  }
  
  public static v a()
  {
    if (a == null) {
      a = new v(o.a(), "access.db");
    }
    return a;
  }
  
  private boolean a(String paramString, s.a parama, long paramLong)
  {
    boolean bool1 = true;
    SQLiteDatabase localSQLiteDatabase;
    try
    {
      localSQLiteDatabase = getWritableDatabase();
      for (;;)
      {
        if (!localSQLiteDatabase.isDbLockedByOtherThreads())
        {
          boolean bool2 = localSQLiteDatabase.isDbLockedByCurrentThread();
          if (!bool2) {
            break;
          }
        }
        try
        {
          Thread.sleep(10L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      localContentValues = new ContentValues();
    }
    finally {}
    ContentValues localContentValues;
    localContentValues.put("iplist", parama.a());
    localContentValues.put("schedule_lasttime", Long.valueOf(parama.d));
    localContentValues.put("apn_lasttime", Long.valueOf(paramLong));
    localContentValues.put("rule", parama.b);
    int i = localSQLiteDatabase.update("access_tbl", localContentValues, "apn=? and domain=?", new String[] { paramString, parama.a });
    if (i == 0)
    {
      localContentValues.put("apn", paramString);
      localContentValues.put("domain", parama.a);
      localContentValues.put("rule", parama.b);
      paramLong = localSQLiteDatabase.insert("access_tbl", null, localContentValues);
      ax.b("DataAccessDBImpl", "insert record...ret:" + paramLong + ",apnName:" + paramString + ",domain:" + parama.a + ",ip:" + parama.a());
      if (-1L == paramLong) {
        break label307;
      }
    }
    for (;;)
    {
      return bool1;
      ax.b("DataAccessDBImpl", "update record...ret:" + i + ",apnName:" + paramString + ",domain:" + parama.a + ",ip:" + parama.a());
      label307:
      bool1 = false;
    }
  }
  
  public final s a(String paramString)
  {
    String str1 = null;
    try
    {
      localObject = getReadableDatabase();
      boolean bool;
      for (;;)
      {
        if (!((SQLiteDatabase)localObject).isDbLockedByOtherThreads())
        {
          bool = ((SQLiteDatabase)localObject).isDbLockedByCurrentThread();
          if (!bool) {
            break;
          }
        }
        try
        {
          Thread.sleep(10L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      try
      {
        localCursor = ((SQLiteDatabase)localObject).query("access_tbl", null, "apn=?", new String[] { paramString }, null, null, null);
        localObject = str1;
        if (localCursor != null) {
          localObject = str1;
        }
        String str2;
        long l;
        if (localObject == null) {
          break label259;
        }
      }
      finally
      {
        try
        {
          if (localCursor.moveToFirst())
          {
            localObject = new s(paramString);
            do
            {
              paramString = localCursor.getString(localCursor.getColumnIndex("domain"));
              str1 = localCursor.getString(localCursor.getColumnIndex("iplist"));
              str2 = localCursor.getString(localCursor.getColumnIndex("rule"));
              l = localCursor.getLong(localCursor.getColumnIndex("schedule_lasttime"));
              localCursor.getLong(localCursor.getColumnIndex("apn_lasttime"));
              ((s)localObject).a(new s.a(paramString, l, str1, str2));
              bool = localCursor.moveToNext();
            } while (bool);
          }
          if (localCursor != null) {
            localCursor.close();
          }
          return localObject;
        }
        finally
        {
          for (;;)
          {
            Cursor localCursor;
            localObject = localCursor;
          }
        }
        paramString = finally;
        localObject = null;
      }
    }
    finally {}
    ((Cursor)localObject).close();
    label259:
    throw paramString;
  }
  
  /* Error */
  public final void a(s params)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: aload_0
    //   9: monitorexit
    //   10: return
    //   11: aload_1
    //   12: getfield 194	c/t/m/g/s:b	Ljava/util/Map;
    //   15: astore 6
    //   17: invokestatic 200	java/lang/System:currentTimeMillis	()J
    //   20: lstore_3
    //   21: aload 6
    //   23: invokeinterface 206 1 0
    //   28: invokeinterface 212 1 0
    //   33: astore 6
    //   35: aload 6
    //   37: invokeinterface 217 1 0
    //   42: ifeq +34 -> 76
    //   45: aload 6
    //   47: invokeinterface 221 1 0
    //   52: checkcast 62	c/t/m/g/s$a
    //   55: astore 7
    //   57: aload_0
    //   58: aload_1
    //   59: getfield 222	c/t/m/g/s:a	Ljava/lang/String;
    //   62: aload 7
    //   64: lload_3
    //   65: invokespecial 224	c/t/m/g/v:a	(Ljava/lang/String;Lc/t/m/g/s$a;J)Z
    //   68: ifeq +267 -> 335
    //   71: iconst_1
    //   72: istore_2
    //   73: goto +262 -> 335
    //   76: iload_2
    //   77: ifeq -69 -> 8
    //   80: ldc 114
    //   82: ldc 226
    //   84: invokestatic 229	c/t/m/g/ax:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: invokevirtual 33	c/t/m/g/v:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   91: astore 7
    //   93: aload 7
    //   95: invokevirtual 39	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   98: ifne +15 -> 113
    //   101: aload 7
    //   103: invokevirtual 42	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   106: istore 5
    //   108: iload 5
    //   110: ifeq +25 -> 135
    //   113: ldc2_w 43
    //   116: invokestatic 50	java/lang/Thread:sleep	(J)V
    //   119: goto -26 -> 93
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 54	java/lang/InterruptedException:printStackTrace	()V
    //   127: goto -34 -> 93
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: aload 7
    //   137: ldc 94
    //   139: iconst_1
    //   140: anewarray 98	java/lang/String
    //   143: dup
    //   144: iconst_0
    //   145: ldc 106
    //   147: aastore
    //   148: aconst_null
    //   149: aconst_null
    //   150: ldc 106
    //   152: aconst_null
    //   153: ldc 86
    //   155: invokevirtual 158	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   158: astore_1
    //   159: aload_1
    //   160: ifnull +167 -> 327
    //   163: aload_1
    //   164: invokeinterface 233 1 0
    //   169: invokestatic 238	c/t/m/g/b$a:b	()Lc/t/m/g/b$a;
    //   172: getfield 241	c/t/m/g/b$a:b	Lc/t/m/g/d;
    //   175: getfield 246	c/t/m/g/d:c	I
    //   178: if_icmple +149 -> 327
    //   181: aload_1
    //   182: invokeinterface 163 1 0
    //   187: ifeq +140 -> 327
    //   190: aload_1
    //   191: aload_1
    //   192: ldc 106
    //   194: invokeinterface 170 2 0
    //   199: invokeinterface 174 2 0
    //   204: astore 6
    //   206: aload 6
    //   208: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifne +116 -> 327
    //   214: ldc 114
    //   216: new 116	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 254
    //   222: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: aload 6
    //   227: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 229	c/t/m/g/ax:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_1
    //   237: ifnull +9 -> 246
    //   240: aload_1
    //   241: invokeinterface 190 1 0
    //   246: aload 6
    //   248: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne -243 -> 8
    //   254: aload 7
    //   256: ldc 94
    //   258: ldc 154
    //   260: iconst_1
    //   261: anewarray 98	java/lang/String
    //   264: dup
    //   265: iconst_0
    //   266: aload 6
    //   268: aastore
    //   269: invokevirtual 258	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   272: istore_2
    //   273: ldc 114
    //   275: new 116	java/lang/StringBuilder
    //   278: dup
    //   279: ldc_w 260
    //   282: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload 6
    //   287: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 262
    //   293: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: iload_2
    //   297: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 229	c/t/m/g/ax:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: goto -298 -> 8
    //   309: aload_1
    //   310: ifnull +9 -> 319
    //   313: aload_1
    //   314: invokeinterface 190 1 0
    //   319: aload 6
    //   321: athrow
    //   322: astore 6
    //   324: goto -15 -> 309
    //   327: ldc_w 264
    //   330: astore 6
    //   332: goto -96 -> 236
    //   335: goto -300 -> 35
    //   338: astore 6
    //   340: aconst_null
    //   341: astore_1
    //   342: goto -33 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	v
    //   0	345	1	params	s
    //   1	296	2	i	int
    //   20	45	3	l	long
    //   106	3	5	bool	boolean
    //   15	305	6	localObject1	Object
    //   322	1	6	localObject2	Object
    //   330	1	6	str	String
    //   338	1	6	localObject3	Object
    //   55	200	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   113	119	122	java/lang/InterruptedException
    //   11	35	130	finally
    //   35	71	130	finally
    //   80	93	130	finally
    //   93	108	130	finally
    //   113	119	130	finally
    //   123	127	130	finally
    //   240	246	130	finally
    //   246	306	130	finally
    //   313	319	130	finally
    //   319	322	130	finally
    //   163	236	322	finally
    //   135	159	338	finally
  }
  
  public final void b(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase;
    try
    {
      localSQLiteDatabase = getWritableDatabase();
      for (;;)
      {
        if (!localSQLiteDatabase.isDbLockedByOtherThreads())
        {
          boolean bool = localSQLiteDatabase.isDbLockedByCurrentThread();
          if (!bool) {
            break;
          }
        }
        try
        {
          Thread.sleep(10L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      localContentValues = new ContentValues();
    }
    finally {}
    ContentValues localContentValues;
    localContentValues.put("apn_lasttime", Long.valueOf(System.currentTimeMillis()));
    int i = localSQLiteDatabase.update("access_tbl", localContentValues, "apn=?", new String[] { paramString });
    ax.b("DataAccessDBImpl", "updateApnUseTime... for apn:" + paramString + ",updateRet:" + i);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      ax.b("DataAccessDBImpl", "db created.");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
      ax.a("DataAccessDBImpl", "db create failed.", paramSQLiteDatabase);
    }
  }
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 291
    //   4: invokevirtual 277	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   7: aload_1
    //   8: ldc_w 274
    //   11: invokevirtual 277	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   14: ldc 114
    //   16: ldc_w 279
    //   19: invokestatic 141	c/t/m/g/ax:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: return
    //   23: astore_1
    //   24: aload_1
    //   25: athrow
    //   26: astore_1
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	v
    //   0	29	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	29	2	paramInt1	int
    //   0	29	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   0	7	23	android/database/SQLException
    //   7	22	26	android/database/SQLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.v
 * JD-Core Version:    0.7.0.1
 */