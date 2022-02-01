package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteDatabase
{
  static final String jdField_a_of_type_JavaLangString = "select sql from sqlite_master where type=? and name=?";
  public static boolean a = false;
  private static final String jdField_b_of_type_JavaLangString = "db";
  private static final boolean jdField_b_of_type_Boolean = false;
  private static final String c = "SQLiteDataBaseLog";
  final android.database.sqlite.SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private TableNameCache jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache = null;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Map jdField_b_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  SQLiteDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, TableNameCache paramTableNameCache)
  {
    this.b = new HashMap();
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = paramSQLiteDatabase;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache = paramTableNameCache;
  }
  
  private ContentValues a(String paramString, ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return paramContentValues;
    }
    ContentValues localContentValues = new ContentValues(paramContentValues);
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (paramContentValues.containsKey(str))
        {
          Object localObject = paramContentValues.get(str);
          if ((localObject instanceof String))
          {
            localObject = (String)paramContentValues.get(str);
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              localContentValues.put(str, a(localObject));
            }
          }
          else if ((localObject instanceof byte[]))
          {
            localContentValues.put(str, a((byte[])localObject));
          }
        }
      }
    }
    return localContentValues;
  }
  
  /* Error */
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: aload_0
    //   6: aload_2
    //   7: aload 4
    //   9: aload 5
    //   11: invokespecial 108	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 39	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   18: iconst_0
    //   19: aload_2
    //   20: aload_3
    //   21: aload 4
    //   23: aload 5
    //   25: aload 6
    //   27: aload 7
    //   29: aload 8
    //   31: aload 9
    //   33: invokevirtual 113	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 14
    //   38: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   41: lstore 12
    //   43: getstatic 23	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_Boolean	Z
    //   46: ifne +13 -> 59
    //   49: aload 14
    //   51: astore 15
    //   53: getstatic 118	com/tencent/mobileqq/activity/aio/AIOUtils:g	Z
    //   56: ifeq +95 -> 151
    //   59: ldc 119
    //   61: aload_2
    //   62: new 121	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   69: aload_3
    //   70: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: ldc 128
    //   75: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload 4
    //   80: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 128
    //   85: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload 5
    //   90: invokestatic 134	com/tencent/mobileqq/app/SQLiteDatabase:a	([Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 128
    //   98: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 6
    //   103: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 128
    //   108: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 7
    //   113: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 128
    //   118: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 8
    //   123: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 128
    //   128: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 9
    //   133: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: lload 12
    //   141: lload 10
    //   143: lsub
    //   144: invokestatic 141	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   147: aload 14
    //   149: astore 15
    //   151: invokestatic 146	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   154: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   157: lload 10
    //   159: lsub
    //   160: invokevirtual 149	com/tencent/util/MsgAutoMonitorUtil:a	(J)V
    //   163: aload 15
    //   165: areturn
    //   166: astore_2
    //   167: aconst_null
    //   168: astore 14
    //   170: aload_0
    //   171: aload_2
    //   172: invokespecial 152	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/Throwable;)V
    //   175: aload 14
    //   177: astore 15
    //   179: goto -28 -> 151
    //   182: astore_2
    //   183: aload_2
    //   184: athrow
    //   185: astore_2
    //   186: goto -16 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	SQLiteDatabase
    //   0	189	1	paramBoolean	boolean
    //   0	189	2	paramString1	String
    //   0	189	3	paramArrayOfString1	String[]
    //   0	189	4	paramString2	String
    //   0	189	5	paramArrayOfString2	String[]
    //   0	189	6	paramString3	String
    //   0	189	7	paramString4	String
    //   0	189	8	paramString5	String
    //   0	189	9	paramString6	String
    //   3	155	10	l1	long
    //   41	99	12	l2	long
    //   36	140	14	localCursor1	Cursor
    //   51	127	15	localCursor2	Cursor
    // Exception table:
    //   from	to	target	type
    //   14	38	166	java/lang/Throwable
    //   14	38	182	finally
    //   38	49	182	finally
    //   53	59	182	finally
    //   59	147	182	finally
    //   170	175	182	finally
    //   38	49	185	java/lang/Throwable
    //   53	59	185	java/lang/Throwable
    //   59	147	185	java/lang/Throwable
  }
  
  private String a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      str = paramObject.toString();
      paramObject = str;
    } while (str.length() <= 0);
    return SecurityUtile.b(str);
  }
  
  private static String a(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if (localObject == null) {
        localStringBuilder.append("null,");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(localObject.toString()).append(',');
      }
    }
    return localStringBuilder.toString();
  }
  
  private ArrayList a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      Cursor localCursor = a("select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          ArrayList localArrayList = a(SecurityUtile.a(localCursor.getString(0)), new String[] { "TEXT", "BLOB" });
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localArrayList);
        }
        localCursor.close();
      }
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private ArrayList a(String paramString, String[] paramArrayOfString)
  {
    paramString = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")")).split(",");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = paramArrayOfString[i].toLowerCase();
      int m = paramString.length;
      int j = 0;
      while (j < m)
      {
        String[] arrayOfString = paramString[j].trim().split(" ");
        if ((arrayOfString.length > 1) && (str.equals(arrayOfString[1].toLowerCase()))) {
          localArrayList.add(arrayOfString[0]);
        }
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map a()
  {
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0).getBoolean("isLogcatDBOperation", false);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    Object localObject = Thread.currentThread();
    String str = ((Thread)localObject).getName();
    if (localObject == Looper.getMainLooper().getThread()) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TableName:").append(paramString2).append('|');
      ((StringBuilder)localObject).append("ExecuteType:").append(paramString1).append("|");
      ((StringBuilder)localObject).append("CurrentThreadName:").append(str).append('|');
      ((StringBuilder)localObject).append("IsMainThread:").append(bool).append('|');
      ((StringBuilder)localObject).append("Cost:").append(paramLong).append('|');
      ((StringBuilder)localObject).append("CMD:").append(paramString3);
      paramString1 = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("SQLiteDataBaseLog", 2, paramString1);
      }
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((paramString2 == null) || (paramArrayOfString == null)) {}
    for (;;)
    {
      return;
      paramString1 = a(paramString1);
      if (paramString1 != null)
      {
        paramString2 = b(paramString2);
        int i = 0;
        while (i < paramString2.size())
        {
          if ((paramString1.contains(paramString2.get(i))) && ((paramArrayOfString[i] instanceof String))) {
            paramArrayOfString[i] = a(paramArrayOfString[i]);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SQLiteDatabase", 2, paramThrowable.getMessage());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((jdField_a_of_type_Boolean ^ paramBoolean))
    {
      jdField_a_of_type_Boolean = paramBoolean;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0).edit();
      localEditor.putBoolean("isLogcatDBOperation", paramBoolean);
      localEditor.commit();
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    return SecurityUtile.a(paramArrayOfByte);
  }
  
  private ArrayList b(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (ArrayList)this.b.get(paramString);
    }
    Matcher localMatcher = Pattern.compile("\\s*\\w+\\s*(>|<|=|>=|<=|!=|=!|<>)\\s*\\?\\s*").matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (localMatcher.find())
    {
      Object localObject = localMatcher.group().trim();
      localObject = Pattern.compile("\\w+").matcher((CharSequence)localObject);
      ((Matcher)localObject).find();
      localArrayList.add(((Matcher)localObject).group());
    }
    this.b.put(paramString, localArrayList);
    return localArrayList;
  }
  
  public static void f() {}
  
  public static void g() {}
  
  private void h()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.jdField_a_of_type_Boolean) {}
    try
    {
      String[] arrayOfString = a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(arrayOfString);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("db", 2, "buildTableNameCache exception", localException);
    }
  }
  
  public int a(String paramString)
  {
    int i = 0;
    int j = 0;
    long l = System.currentTimeMillis();
    paramString = a("select count() from " + paramString, null);
    if (paramString != null) {
      i = j;
    }
    try
    {
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
        i = j;
      }
    }
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    a(paramString1, paramString2, paramArrayOfString);
    try
    {
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      l = System.currentTimeMillis() - l;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("update", paramString1, paramContentValues + ";" + paramString2 + ";" + a(paramArrayOfString), l);
      }
      MsgAutoMonitorUtil.a().a(l);
      return i;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1;
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l1 = System.currentTimeMillis();
    a(paramString1, paramString2, paramArrayOfString);
    try
    {
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      long l2 = System.currentTimeMillis() - l1;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("delete", paramString1, paramString2 + ";" + a(paramArrayOfString), l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return i;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l1);
    }
    return -1;
  }
  
  public long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    try
    {
      long l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("insert", paramString1, paramString2 + ";" + paramContentValues, l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return l1;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1L;
  }
  
  /* Error */
  public Cursor a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokespecial 108	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 39	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_1
    //   18: aload 4
    //   20: invokevirtual 402	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore 9
    //   25: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   28: lstore 7
    //   30: getstatic 23	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_Boolean	Z
    //   33: ifne +13 -> 46
    //   36: aload 9
    //   38: astore 10
    //   40: getstatic 118	com/tencent/mobileqq/activity/aio/AIOUtils:g	Z
    //   43: ifeq +55 -> 98
    //   46: ldc_w 403
    //   49: aload_2
    //   50: new 121	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   57: aload_1
    //   58: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 128
    //   63: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 128
    //   72: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 4
    //   77: invokestatic 134	com/tencent/mobileqq/app/SQLiteDatabase:a	([Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: lload 7
    //   88: lload 5
    //   90: lsub
    //   91: invokestatic 141	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   94: aload 9
    //   96: astore 10
    //   98: invokestatic 146	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   101: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   104: lload 5
    //   106: lsub
    //   107: invokevirtual 149	com/tencent/util/MsgAutoMonitorUtil:a	(J)V
    //   110: aload 10
    //   112: areturn
    //   113: astore_1
    //   114: aconst_null
    //   115: astore 9
    //   117: aload_0
    //   118: aload_1
    //   119: invokespecial 152	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/Throwable;)V
    //   122: aload 9
    //   124: astore 10
    //   126: goto -28 -> 98
    //   129: astore_1
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: goto -16 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	SQLiteDatabase
    //   0	136	1	paramString1	String
    //   0	136	2	paramString2	String
    //   0	136	3	paramString3	String
    //   0	136	4	paramArrayOfString	String[]
    //   3	102	5	l1	long
    //   28	59	7	l2	long
    //   23	100	9	localCursor1	Cursor
    //   38	87	10	localCursor2	Cursor
    // Exception table:
    //   from	to	target	type
    //   13	25	113	java/lang/Throwable
    //   13	25	129	finally
    //   25	36	129	finally
    //   40	46	129	finally
    //   46	94	129	finally
    //   117	122	129	finally
    //   25	36	132	java/lang/Throwable
    //   40	46	132	java/lang/Throwable
    //   46	94	132	java/lang/Throwable
  }
  
  public Cursor a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return a(false, paramString1, null, paramString2, paramArrayOfString, null, null, null, null);
  }
  
  @Deprecated
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    try
    {
      paramString = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = paramString;
        a(paramString);
        paramString = localObject;
      }
    }
    finally {}
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3, paramString4);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(paramString);
  }
  
  public boolean a(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      l = System.currentTimeMillis() - l;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("execSQL", "", paramString, l);
      }
      MsgAutoMonitorUtil.a().a(l);
      return true;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, Object[] paramArrayOfObject)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString, paramArrayOfObject);
      l = System.currentTimeMillis() - l;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("execSQL", "", paramString + ";" + a(paramArrayOfObject), l);
      }
      MsgAutoMonitorUtil.a().a(l);
      return true;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return false;
  }
  
  public String[] a()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    long l = System.currentTimeMillis();
    Cursor localCursor;
    int i;
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      localCursor = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
      localObject1 = localObject2;
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = new String[localCursor.getCount()];
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject1[i] = SecurityUtile.a(localCursor.getString(0));
      if (!localCursor.moveToNext())
      {
        if (localCursor != null) {
          localCursor.close();
        }
        MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
        return localObject1;
      }
      i += 1;
    }
  }
  
  public int b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    String str2 = "select count(*) from " + paramString1;
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramArrayOfString != null)
      {
        a(paramString1, paramString2, paramArrayOfString);
        str1 = str2 + " where " + paramString2;
      }
    }
    paramString1 = a(str1, paramArrayOfString);
    int i;
    if (paramString1 != null)
    {
      paramString1.moveToFirst();
      i = paramString1.getInt(0);
      paramString1.close();
    }
    for (;;)
    {
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return i;
      i = 0;
    }
  }
  
  public long b(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    try
    {
      long l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("replace", paramString1, paramString2 + ";" + paramContentValues, l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return l1;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1L;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    try
    {
      f();
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      MsgAutoMonitorUtil.a().b(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setLockingEnabled(paramBoolean);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public boolean b(String paramString)
  {
    h();
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(paramString);
  }
  
  public String[] b()
  {
    h();
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a();
  }
  
  public void c()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void d()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
      g();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void e()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */