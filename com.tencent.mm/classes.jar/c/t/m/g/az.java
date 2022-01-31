package c.t.m.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class az
  extends SQLiteOpenHelper
{
  private static Map<String, az> a = new ConcurrentHashMap();
  private static final Object b = new Object();
  
  private az(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 2);
  }
  
  /* Error */
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 37	c/t/m/g/az:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: iload_1
    //   10: ifeq +57 -> 67
    //   13: iload_2
    //   14: ifeq +53 -> 67
    //   17: aload 4
    //   19: ldc 39
    //   21: iconst_1
    //   22: anewarray 41	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 43
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +155 -> 197
    //   45: aload 4
    //   47: invokeinterface 55 1 0
    //   52: istore_3
    //   53: aload 4
    //   55: ifnull +10 -> 65
    //   58: aload 4
    //   60: invokeinterface 58 1 0
    //   65: iload_3
    //   66: ireturn
    //   67: iload_1
    //   68: ifeq +38 -> 106
    //   71: aload 4
    //   73: ldc 39
    //   75: iconst_1
    //   76: anewarray 41	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: ldc 43
    //   83: aastore
    //   84: ldc 60
    //   86: iconst_1
    //   87: anewarray 41	java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: ldc 62
    //   94: aastore
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore 4
    //   103: goto -63 -> 40
    //   106: aload 4
    //   108: ldc 39
    //   110: iconst_1
    //   111: anewarray 41	java/lang/String
    //   114: dup
    //   115: iconst_0
    //   116: ldc 43
    //   118: aastore
    //   119: ldc 60
    //   121: iconst_1
    //   122: anewarray 41	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: ldc 64
    //   129: aastore
    //   130: aconst_null
    //   131: aconst_null
    //   132: aconst_null
    //   133: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   136: astore 4
    //   138: goto -98 -> 40
    //   141: astore 4
    //   143: aconst_null
    //   144: astore 4
    //   146: aload 4
    //   148: ifnull +47 -> 195
    //   151: aload 4
    //   153: invokeinterface 58 1 0
    //   158: iconst_0
    //   159: ireturn
    //   160: astore 4
    //   162: aload 5
    //   164: ifnull +10 -> 174
    //   167: aload 5
    //   169: invokeinterface 58 1 0
    //   174: aload 4
    //   176: athrow
    //   177: astore 6
    //   179: aload 4
    //   181: astore 5
    //   183: aload 6
    //   185: astore 4
    //   187: goto -25 -> 162
    //   190: astore 5
    //   192: goto -46 -> 146
    //   195: iconst_0
    //   196: ireturn
    //   197: iconst_0
    //   198: istore_3
    //   199: goto -146 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	az
    //   0	202	1	paramBoolean1	boolean
    //   0	202	2	paramBoolean2	boolean
    //   52	147	3	i	int
    //   7	130	4	localObject1	Object
    //   141	1	4	localThrowable1	java.lang.Throwable
    //   144	8	4	localObject2	Object
    //   160	20	4	localObject3	Object
    //   185	1	4	localObject4	Object
    //   1	181	5	localObject5	Object
    //   190	1	5	localThrowable2	java.lang.Throwable
    //   177	7	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   3	9	141	java/lang/Throwable
    //   17	40	141	java/lang/Throwable
    //   71	103	141	java/lang/Throwable
    //   106	138	141	java/lang/Throwable
    //   3	9	160	finally
    //   17	40	160	finally
    //   71	103	160	finally
    //   106	138	160	finally
    //   45	53	177	finally
    //   45	53	190	java/lang/Throwable
  }
  
  public static az a(String paramString)
  {
    synchronized (b)
    {
      az localaz = (az)a.get(paramString);
      Object localObject1 = localaz;
      if (localaz == null)
      {
        localObject1 = "HalleyAction_" + m.b() + "_" + m.h() + "_" + paramString + ".db";
        localObject1 = new az(m.a(), (String)localObject1);
        a.put(paramString, localObject1);
      }
      return localObject1;
    }
  }
  
  public final void a(List<Long> paramList)
  {
    if (paramList.size() <= 0) {}
    for (;;)
    {
      return;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("state", "remove");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localSQLiteDatabase.update("halley_action_tbl", localContentValues, "key=?", new String[] { String.valueOf(((Long)localIterator.next()).longValue()) });
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localSQLiteDatabase.delete("halley_action_tbl", "key=?", new String[] { String.valueOf(((Long)paramList.next()).longValue()) });
        }
        if (a(false, true) <= 0) {
          continue;
        }
        int i = a(true, false);
        if (i > 0) {
          continue;
        }
        try
        {
          localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
          try
          {
            label164:
            localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            return;
          }
          catch (SQLException paramList)
          {
            throw paramList;
          }
        }
        catch (SQLException paramList)
        {
          break label164;
        }
        return;
      }
      catch (Exception paramList) {}
    }
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: iconst_1
    //   3: invokespecial 163	c/t/m/g/az:a	(ZZ)I
    //   6: iload_1
    //   7: if_icmple +45 -> 52
    //   10: aload_0
    //   11: invokevirtual 37	c/t/m/g/az:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc 39
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 161	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   21: pop
    //   22: iconst_1
    //   23: ireturn
    //   24: astore_2
    //   25: aload_0
    //   26: iconst_1
    //   27: iconst_1
    //   28: invokespecial 163	c/t/m/g/az:a	(ZZ)I
    //   31: iload_1
    //   32: if_icmple +20 -> 52
    //   35: aload_0
    //   36: invokevirtual 37	c/t/m/g/az:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore_2
    //   40: aload_2
    //   41: ldc 165
    //   43: invokevirtual 168	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   46: aload_2
    //   47: ldc 170
    //   49: invokevirtual 168	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   52: iconst_0
    //   53: ireturn
    //   54: astore_2
    //   55: aload_2
    //   56: athrow
    //   57: astore_2
    //   58: goto -6 -> 52
    //   61: astore_3
    //   62: goto -16 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	az
    //   0	65	1	paramInt	int
    //   24	1	2	localException	Exception
    //   39	8	2	localSQLiteDatabase	SQLiteDatabase
    //   54	2	2	localSQLException1	SQLException
    //   57	1	2	localThrowable	java.lang.Throwable
    //   61	1	3	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   10	22	24	java/lang/Exception
    //   46	52	54	android/database/SQLException
    //   35	40	57	java/lang/Throwable
    //   40	46	57	java/lang/Throwable
    //   46	52	57	java/lang/Throwable
    //   55	57	57	java/lang/Throwable
    //   40	46	61	android/database/SQLException
  }
  
  /* Error */
  public final long b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: ldc2_w 181
    //   10: lreturn
    //   11: aload_0
    //   12: invokevirtual 37	c/t/m/g/az:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: new 121	android/content/ContentValues
    //   20: dup
    //   21: invokespecial 122	android/content/ContentValues:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 184
    //   30: aload_1
    //   31: invokevirtual 127	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 5
    //   36: ldc 124
    //   38: ldc 62
    //   40: invokevirtual 127	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 4
    //   45: ldc 39
    //   47: aconst_null
    //   48: aload 5
    //   50: invokevirtual 188	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   53: lstore_2
    //   54: lload_2
    //   55: lreturn
    //   56: astore_1
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: ldc2_w 181
    //   63: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	az
    //   0	64	1	paramString	String
    //   53	2	2	l	long
    //   15	29	4	localSQLiteDatabase	SQLiteDatabase
    //   24	25	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	54	56	finally
    //   11	54	59	java/lang/Exception
  }
  
  /* Error */
  public final List<az.a> b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 191	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 192	java/util/ArrayList:<init>	()V
    //   10: astore 8
    //   12: aload_0
    //   13: invokevirtual 37	c/t/m/g/az:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: ldc 39
    //   18: aconst_null
    //   19: ldc 60
    //   21: iconst_1
    //   22: anewarray 41	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 62
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 6
    //   38: aload 6
    //   40: ifnull +121 -> 161
    //   43: aload 6
    //   45: invokeinterface 55 1 0
    //   50: iload_1
    //   51: invokestatic 198	java/lang/Math:min	(II)I
    //   54: istore_2
    //   55: aload 6
    //   57: invokeinterface 201 1 0
    //   62: ifeq +99 -> 161
    //   65: iconst_0
    //   66: istore_1
    //   67: aload 6
    //   69: aload 6
    //   71: ldc 43
    //   73: invokeinterface 205 2 0
    //   78: invokeinterface 209 2 0
    //   83: lstore_3
    //   84: aload 6
    //   86: aload 6
    //   88: ldc 184
    //   90: invokeinterface 205 2 0
    //   95: invokeinterface 213 2 0
    //   100: astore 7
    //   102: aload 6
    //   104: aload 6
    //   106: ldc 124
    //   108: invokeinterface 205 2 0
    //   113: invokeinterface 213 2 0
    //   118: pop
    //   119: aload 8
    //   121: new 6	c/t/m/g/az$a
    //   124: dup
    //   125: lload_3
    //   126: aload 7
    //   128: iconst_0
    //   129: invokespecial 216	c/t/m/g/az$a:<init>	(JLjava/lang/String;B)V
    //   132: invokeinterface 219 2 0
    //   137: pop
    //   138: iload_1
    //   139: iconst_1
    //   140: iadd
    //   141: istore_1
    //   142: iload_1
    //   143: iload_2
    //   144: if_icmpge +17 -> 161
    //   147: aload 6
    //   149: invokeinterface 222 1 0
    //   154: istore 5
    //   156: iload 5
    //   158: ifne -91 -> 67
    //   161: aload 6
    //   163: ifnull +10 -> 173
    //   166: aload 6
    //   168: invokeinterface 58 1 0
    //   173: aload 8
    //   175: areturn
    //   176: astore 6
    //   178: aconst_null
    //   179: astore 6
    //   181: aload 6
    //   183: ifnull -10 -> 173
    //   186: aload 6
    //   188: invokeinterface 58 1 0
    //   193: aload 8
    //   195: areturn
    //   196: astore 6
    //   198: aload 7
    //   200: ifnull +10 -> 210
    //   203: aload 7
    //   205: invokeinterface 58 1 0
    //   210: aload 6
    //   212: athrow
    //   213: astore 8
    //   215: aload 6
    //   217: astore 7
    //   219: aload 8
    //   221: astore 6
    //   223: goto -25 -> 198
    //   226: astore 7
    //   228: goto -47 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	az
    //   0	231	1	paramInt	int
    //   54	91	2	i	int
    //   83	43	3	l	long
    //   154	3	5	bool	boolean
    //   36	131	6	localCursor	android.database.Cursor
    //   176	1	6	localThrowable1	java.lang.Throwable
    //   179	8	6	localObject1	Object
    //   196	20	6	localObject2	Object
    //   221	1	6	localObject3	Object
    //   1	217	7	localObject4	Object
    //   226	1	7	localThrowable2	java.lang.Throwable
    //   10	184	8	localArrayList	java.util.ArrayList
    //   213	7	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   12	38	176	java/lang/Throwable
    //   12	38	196	finally
    //   43	65	213	finally
    //   67	138	213	finally
    //   147	156	213	finally
    //   43	65	226	java/lang/Throwable
    //   67	138	226	java/lang/Throwable
    //   147	156	226	java/lang/Throwable
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      break label6;
    }
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    try
    {
      int i = paramSQLiteDatabase.getVersion();
      if (i != 0)
      {
        if (i < 2)
        {
          onUpgrade(paramSQLiteDatabase, i, 2);
          return;
        }
        if (i > 2)
        {
          onDowngrade(paramSQLiteDatabase, i, 2);
          return;
        }
      }
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.az
 * JD-Core Version:    0.7.0.1
 */