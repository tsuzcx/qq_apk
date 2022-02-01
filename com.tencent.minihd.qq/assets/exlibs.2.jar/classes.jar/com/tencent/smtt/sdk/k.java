package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class k
{
  public static final String a = CookieManager.LOGTAG;
  static File b;
  
  public static File a(Context paramContext)
  {
    if ((b == null) && (paramContext != null)) {
      b = new File(paramContext.getDir("webview", 0), "Cookies");
    }
    if (b == null) {
      b = new File("/data/data/" + paramContext.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
    }
    return b;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from " + paramString, null);
    int i = paramSQLiteDatabase.getCount();
    int j = paramSQLiteDatabase.getColumnCount();
    paramString = new StringBuilder();
    paramString.append("raws:" + i + ",columns:" + j + "\n");
    if ((i > 0) && (paramSQLiteDatabase.moveToFirst())) {
      label133:
      do
      {
        paramString.append("\n");
        i = 0;
        while (i < j)
        {
          try
          {
            String str = paramSQLiteDatabase.getString(i);
            paramString.append(str).append(",");
          }
          catch (Exception localException)
          {
            break label133;
          }
          i += 1;
        }
        paramString.append("\n");
      } while (paramSQLiteDatabase.moveToNext());
    } else {
      return paramString.toString();
    }
  }
  
  /* Error */
  public static java.util.ArrayList<String> a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 109	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 110	java/util/ArrayList:<init>	()V
    //   15: astore 4
    //   17: aload_0
    //   18: ldc 112
    //   20: aconst_null
    //   21: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_3
    //   27: aload_2
    //   28: invokeinterface 95 1 0
    //   33: ifeq +56 -> 89
    //   36: aload_2
    //   37: astore_3
    //   38: aload_2
    //   39: iconst_1
    //   40: invokeinterface 99 2 0
    //   45: astore 5
    //   47: aload_2
    //   48: astore_3
    //   49: aload_2
    //   50: iconst_4
    //   51: invokeinterface 99 2 0
    //   56: pop
    //   57: aload_2
    //   58: astore_3
    //   59: aload 4
    //   61: aload 5
    //   63: invokevirtual 116	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_2
    //   68: astore_3
    //   69: aload_0
    //   70: aload 5
    //   72: invokestatic 118	com/tencent/smtt/sdk/k:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    //   75: pop
    //   76: aload_2
    //   77: astore_3
    //   78: aload_2
    //   79: invokeinterface 104 1 0
    //   84: istore_1
    //   85: iload_1
    //   86: ifne -50 -> 36
    //   89: aload_2
    //   90: ifnull +9 -> 99
    //   93: aload_2
    //   94: invokeinterface 121 1 0
    //   99: aload_0
    //   100: ifnull +14 -> 114
    //   103: aload_0
    //   104: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   107: ifeq +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   114: aload 4
    //   116: areturn
    //   117: astore_2
    //   118: aload_3
    //   119: ifnull +9 -> 128
    //   122: aload_3
    //   123: invokeinterface 121 1 0
    //   128: aload_0
    //   129: ifnull -15 -> 114
    //   132: aload_0
    //   133: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   136: ifeq -22 -> 114
    //   139: aload_0
    //   140: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   143: goto -29 -> 114
    //   146: astore_2
    //   147: aconst_null
    //   148: astore 4
    //   150: aload_2
    //   151: astore_3
    //   152: aload 4
    //   154: ifnull +10 -> 164
    //   157: aload 4
    //   159: invokeinterface 121 1 0
    //   164: aload_0
    //   165: ifnull +14 -> 179
    //   168: aload_0
    //   169: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   172: ifeq +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   179: aload_3
    //   180: athrow
    //   181: astore_3
    //   182: aload_2
    //   183: astore 4
    //   185: goto -33 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramSQLiteDatabase	SQLiteDatabase
    //   84	2	1	bool	boolean
    //   24	70	2	localCursor	Cursor
    //   117	1	2	localThrowable	Throwable
    //   146	37	2	localObject1	Object
    //   1	179	3	localObject2	Object
    //   181	1	3	localObject3	Object
    //   15	169	4	localObject4	Object
    //   45	26	5	str	String
    // Exception table:
    //   from	to	target	type
    //   17	25	117	java/lang/Throwable
    //   27	36	117	java/lang/Throwable
    //   38	47	117	java/lang/Throwable
    //   49	57	117	java/lang/Throwable
    //   59	67	117	java/lang/Throwable
    //   69	76	117	java/lang/Throwable
    //   78	85	117	java/lang/Throwable
    //   17	25	146	finally
    //   27	36	181	finally
    //   38	47	181	finally
    //   49	57	181	finally
    //   59	67	181	finally
    //   69	76	181	finally
    //   78	85	181	finally
  }
  
  public static void a(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = null;
    Cursor localCursor = null;
    if (paramContext == null) {}
    label10:
    String[] arrayOfString;
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        break label10;
        break label10;
        do
        {
          return;
        } while ((parama == CookieManager.a.b) && (TextUtils.isEmpty(paramString)));
        arrayOfString = paramString.split(",");
      } while ((arrayOfString == null) || (arrayOfString.length < 1));
      localSQLiteDatabase = c(paramContext);
    } while (localSQLiteDatabase == null);
    HashMap localHashMap = new HashMap();
    paramString = localCursor;
    for (;;)
    {
      int i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("select * from cookies", null);
        paramString = localCursor;
        localObject = localCursor;
        if (localCursor.getCount() > 0)
        {
          paramString = localCursor;
          localObject = localCursor;
          if (localCursor.moveToFirst())
          {
            paramString = localCursor;
            localObject = localCursor;
            str = localCursor.getString(localCursor.getColumnIndex("host_key"));
            paramString = localCursor;
            localObject = localCursor;
            if (parama != CookieManager.a.b) {
              continue;
            }
            paramString = localCursor;
            localObject = localCursor;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label664;
            }
            paramString = localCursor;
            localObject = localCursor;
            if (!str.equals(arrayOfString[i])) {
              continue;
            }
            i = 1;
            break label667;
            paramString = localCursor;
            localObject = localCursor;
            paramBoolean2 = localCursor.moveToNext();
            if (paramBoolean2) {
              continue;
            }
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
        if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
          localSQLiteDatabase.close();
        }
      }
      catch (Throwable parama)
      {
        String str;
        StringBuilder localStringBuilder;
        localObject = paramString;
        Log.e(a, "getCookieDBVersion exception:" + parama.toString());
        if (paramString == null) {
          continue;
        }
        paramString.close();
        if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {
          continue;
        }
        localSQLiteDatabase.close();
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
        if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {
          continue;
        }
        localSQLiteDatabase.close();
      }
      if (localHashMap.isEmpty()) {
        break;
      }
      b(paramContext);
      parama = localHashMap.entrySet().iterator();
      if (parama.hasNext())
      {
        localObject = (Map.Entry)parama.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        CookieManager.getInstance().setCookie(paramString, (String)localObject, true);
        continue;
        i += 1;
        continue;
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder = new StringBuilder();
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder.append(localCursor.getString(localCursor.getColumnIndex("value")));
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder.append(";").append(localCursor.getString(localCursor.getColumnIndex("name")));
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder.append(";").append(localCursor.getInt(localCursor.getColumnIndex("expires_utc")));
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder.append(";").append(localCursor.getInt(localCursor.getColumnIndex("priority")));
        paramString = localCursor;
        localObject = localCursor;
        localHashMap.put(str, localStringBuilder.toString());
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 21) {
          CookieManager.getInstance().flush();
        }
        for (;;)
        {
          if (!paramBoolean1) {
            break label662;
          }
          a(c(paramContext));
          i = d(paramContext);
          if (i == -1) {
            break;
          }
          CookieManager.getInstance();
          CookieManager.setROMCookieDBVersion(paramContext, i);
          return;
          CookieSyncManager.getInstance().sync();
        }
        label662:
        break label10;
        label664:
        i = 0;
        label667:
        if (i != 0) {}
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    FileUtil.a(a(paramContext), false);
    return true;
  }
  
  public static SQLiteDatabase c(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramContext == null) {}
    for (;;)
    {
      return localObject1;
      paramContext = a(paramContext);
      if (paramContext == null) {
        continue;
      }
      try
      {
        paramContext = SQLiteDatabase.openDatabase(paramContext.getAbsolutePath(), null, 0);
        localObject1 = paramContext;
        if (paramContext != null) {
          continue;
        }
        TbsLog.i(a, "dbPath is not exist!");
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = localObject2;
        }
      }
    }
  }
  
  /* Error */
  public static int d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aconst_null
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 9
    //   10: aconst_null
    //   11: astore 8
    //   13: aconst_null
    //   14: astore 7
    //   16: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   19: pop2
    //   20: aload_0
    //   21: invokestatic 149	com/tencent/smtt/sdk/k:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnonnull +40 -> 66
    //   29: iconst_m1
    //   30: istore_1
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 287	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 288	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: iload_1
    //   44: istore_2
    //   45: aload_0
    //   46: ifnull +18 -> 64
    //   49: iload_1
    //   50: istore_2
    //   51: aload_0
    //   52: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   55: ifeq +9 -> 64
    //   58: aload_0
    //   59: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   62: iload_1
    //   63: istore_2
    //   64: iload_2
    //   65: ireturn
    //   66: aload 9
    //   68: astore 6
    //   70: aload 8
    //   72: astore 7
    //   74: aload_0
    //   75: ldc_w 290
    //   78: aconst_null
    //   79: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore 8
    //   84: aload 8
    //   86: astore 6
    //   88: aload 8
    //   90: astore 7
    //   92: aload 8
    //   94: invokeinterface 79 1 0
    //   99: istore 4
    //   101: aload 8
    //   103: astore 6
    //   105: aload 8
    //   107: astore 7
    //   109: aload 8
    //   111: invokeinterface 82 1 0
    //   116: pop
    //   117: iload_2
    //   118: istore_1
    //   119: iload 4
    //   121: ifle +68 -> 189
    //   124: iload_2
    //   125: istore_1
    //   126: aload 8
    //   128: astore 6
    //   130: aload 8
    //   132: astore 7
    //   134: aload 8
    //   136: invokeinterface 95 1 0
    //   141: ifeq +48 -> 189
    //   144: aload 8
    //   146: astore 6
    //   148: aload 8
    //   150: astore 7
    //   152: aload 8
    //   154: iconst_0
    //   155: invokeinterface 99 2 0
    //   160: ldc_w 292
    //   163: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +56 -> 222
    //   169: aload 8
    //   171: astore 6
    //   173: aload 8
    //   175: astore 7
    //   177: aload 8
    //   179: iconst_1
    //   180: invokeinterface 99 2 0
    //   185: invokestatic 297	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   188: istore_1
    //   189: aload 8
    //   191: ifnull +10 -> 201
    //   194: aload 8
    //   196: invokeinterface 121 1 0
    //   201: iload_1
    //   202: istore_2
    //   203: aload_0
    //   204: ifnull -140 -> 64
    //   207: iload_1
    //   208: istore_2
    //   209: aload_0
    //   210: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   213: ifeq -149 -> 64
    //   216: aload_0
    //   217: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   220: iload_1
    //   221: ireturn
    //   222: aload 8
    //   224: astore 6
    //   226: aload 8
    //   228: astore 7
    //   230: aload 8
    //   232: invokeinterface 104 1 0
    //   237: istore 5
    //   239: iload 5
    //   241: ifne -97 -> 144
    //   244: iload_2
    //   245: istore_1
    //   246: goto -57 -> 189
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_0
    //   252: aload 7
    //   254: ifnull +10 -> 264
    //   257: aload 7
    //   259: invokeinterface 121 1 0
    //   264: iload_3
    //   265: istore_2
    //   266: aload_0
    //   267: ifnull -203 -> 64
    //   270: iload_3
    //   271: istore_2
    //   272: aload_0
    //   273: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   276: ifeq -212 -> 64
    //   279: aload_0
    //   280: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   283: iconst_0
    //   284: ireturn
    //   285: astore 7
    //   287: aconst_null
    //   288: astore_0
    //   289: aload 6
    //   291: ifnull +10 -> 301
    //   294: aload 6
    //   296: invokeinterface 121 1 0
    //   301: aload_0
    //   302: ifnull +14 -> 316
    //   305: aload_0
    //   306: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   309: ifeq +7 -> 316
    //   312: aload_0
    //   313: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   316: aload 7
    //   318: athrow
    //   319: astore 7
    //   321: goto -32 -> 289
    //   324: astore 6
    //   326: goto -74 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramContext	Context
    //   30	216	1	i	int
    //   1	271	2	j	int
    //   3	268	3	k	int
    //   99	21	4	m	int
    //   237	3	5	bool	boolean
    //   5	290	6	localObject1	Object
    //   324	1	6	localThrowable	Throwable
    //   14	244	7	localCursor1	Cursor
    //   285	32	7	localObject2	Object
    //   319	1	7	localObject3	Object
    //   11	220	8	localCursor2	Cursor
    //   8	59	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	249	java/lang/Throwable
    //   20	25	285	finally
    //   74	84	319	finally
    //   92	101	319	finally
    //   109	117	319	finally
    //   134	144	319	finally
    //   152	169	319	finally
    //   177	189	319	finally
    //   230	239	319	finally
    //   74	84	324	java/lang/Throwable
    //   92	101	324	java/lang/Throwable
    //   109	117	324	java/lang/Throwable
    //   134	144	324	java/lang/Throwable
    //   152	169	324	java/lang/Throwable
    //   177	189	324	java/lang/Throwable
    //   230	239	324	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.k
 * JD-Core Version:    0.7.0.1
 */