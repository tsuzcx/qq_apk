package com.tencent.open.downloadnew.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadDBHelper
  extends SQLiteOpenHelper
{
  public static final int a = 10;
  protected static volatile DownloadDBHelper a;
  protected static final String a;
  protected static final byte[] a;
  public static final String[] a;
  public static final int b = 0;
  public static final String b = "app_plugin_download.db";
  public static final int c = 1;
  protected static final String c = "download_info";
  public static final int d = 2;
  protected static final String d = "appid";
  public static final int e = 3;
  protected static final String e = "download_url";
  public static final int f = 4;
  protected static final String f = "package";
  public static final int g = 5;
  protected static final String g = "push_title";
  public static final int h = 6;
  protected static final String h = "sendtime_col";
  public static final int i = 7;
  protected static final String i = "uin_col";
  public static final int j = 8;
  protected static final String j = "triggertime_col";
  public static final int k = 9;
  protected static final String k = "via_col";
  public static final int l = 10;
  protected static final String l = "patch_url";
  public static final int m = 11;
  protected static final String m = "update_type";
  public static final int n = 12;
  protected static final String n = "myappid_col";
  public static final int o = 13;
  protected static final String o = "apkid_col";
  public static final int p = 14;
  protected static final String p = "version_col";
  public static final int q = 15;
  protected static final String q = "downloadtype_col";
  public static final int r = 16;
  protected static final String r = "filepath_col";
  public static final int s = 17;
  protected static final String s = "source_col";
  public static final int t = 18;
  protected static final String t = "last_download_size";
  protected static final String u = "is_apk";
  protected static final String v = "myapp_download_from";
  protected long a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadDBHelper.class.getName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "appid", "download_url", "package", "push_title", "sendtime_col", "uin_col", "triggertime_col", "via_col", "patch_url", "update_type", "myappid_col", "apkid_col", "version_col", "downloadtype_col", "filepath_col", "source_col", "last_download_size", "is_apk", "myapp_download_from" };
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected DownloadDBHelper(Context paramContext)
  {
    super(paramContext, "app_plugin_download.db", null, 10);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static DownloadDBHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper = new DownloadDBHelper(CommonDataAdapter.a().a());
      }
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long == 0L)
      {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long = CommonDataAdapter.a().a();
        if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long == 0L) {
          jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long = CommonDataAdapter.a().b();
        }
      }
      DownloadDBHelper localDownloadDBHelper = jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper;
      return localDownloadDBHelper;
    }
    finally {}
  }
  
  protected DownloadInfo a(Cursor paramCursor)
  {
    String str1 = paramCursor.getString(0);
    String str2 = paramCursor.getString(1);
    String str3 = paramCursor.getString(2);
    String str4 = paramCursor.getString(3);
    String str5 = paramCursor.getString(4);
    long l1 = paramCursor.getLong(6);
    String str6 = paramCursor.getString(7);
    String str7 = paramCursor.getString(8);
    int i1 = paramCursor.getInt(9);
    String str8 = paramCursor.getString(10);
    String str9 = paramCursor.getString(11);
    int i2 = paramCursor.getInt(12);
    int i3 = paramCursor.getInt(13);
    String str10 = paramCursor.getString(14);
    int i4 = paramCursor.getInt(15);
    long l2 = paramCursor.getLong(16);
    if (paramCursor.getInt(17) == 1) {}
    for (boolean bool = true;; bool = false) {
      return new DownloadInfo(str1, str2, str3, str4, str5, l1, str6, str7, i1, str8, str9, i2, i3, str10, i4, l2, bool, paramCursor.getInt(18));
    }
  }
  
  public DownloadInfo a(String paramString)
  {
    return a("package = ?", new String[] { paramString });
  }
  
  /* Error */
  protected DownloadInfo a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: getstatic 109	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 7
    //   14: aload 7
    //   16: monitorenter
    //   17: aload_0
    //   18: invokevirtual 167	com/tencent/open/downloadnew/common/DownloadDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 19
    //   25: getstatic 107	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   28: aload_1
    //   29: aload_2
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 173	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload 6
    //   39: astore_1
    //   40: aload_2
    //   41: invokeinterface 177 1 0
    //   46: ifle +16 -> 62
    //   49: aload_2
    //   50: invokeinterface 181 1 0
    //   55: pop
    //   56: aload_0
    //   57: aload_2
    //   58: invokevirtual 183	com/tencent/open/downloadnew/common/DownloadDBHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   61: astore_1
    //   62: aload_2
    //   63: ifnull +9 -> 72
    //   66: aload_2
    //   67: invokeinterface 186 1 0
    //   72: aload_1
    //   73: astore_2
    //   74: aload_3
    //   75: ifnull +9 -> 84
    //   78: aload_3
    //   79: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   82: aload_1
    //   83: astore_2
    //   84: aload 7
    //   86: monitorexit
    //   87: aload_2
    //   88: areturn
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: getstatic 103	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: ldc 189
    //   99: aload_3
    //   100: invokestatic 194	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +9 -> 113
    //   107: aload_2
    //   108: invokeinterface 186 1 0
    //   113: aload 4
    //   115: astore_2
    //   116: aload_1
    //   117: ifnull -33 -> 84
    //   120: aload_1
    //   121: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   124: aload 4
    //   126: astore_2
    //   127: goto -43 -> 84
    //   130: astore_1
    //   131: aload 7
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_1
    //   139: aload 5
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +9 -> 152
    //   146: aload_3
    //   147: invokeinterface 186 1 0
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: aload_3
    //   164: astore_1
    //   165: aload 5
    //   167: astore_3
    //   168: goto -26 -> 142
    //   171: astore 5
    //   173: aload_2
    //   174: astore 4
    //   176: aload_3
    //   177: astore_1
    //   178: aload 5
    //   180: astore_2
    //   181: aload 4
    //   183: astore_3
    //   184: goto -42 -> 142
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: goto -52 -> 142
    //   197: astore_2
    //   198: aload_3
    //   199: astore_1
    //   200: aload_2
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -110 -> 94
    //   207: astore 5
    //   209: aload_3
    //   210: astore_1
    //   211: aload 5
    //   213: astore_3
    //   214: goto -120 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	DownloadDBHelper
    //   0	217	1	paramString	String
    //   0	217	2	paramArrayOfString	String[]
    //   21	58	3	localSQLiteDatabase	SQLiteDatabase
    //   89	11	3	localException1	Exception
    //   141	73	3	localObject1	Object
    //   1	181	4	arrayOfString	String[]
    //   187	5	4	localObject2	Object
    //   4	162	5	localObject3	Object
    //   171	8	5	localObject4	Object
    //   207	5	5	localException2	Exception
    //   7	31	6	localObject5	Object
    //   12	120	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	22	89	java/lang/Exception
    //   66	72	130	finally
    //   78	82	130	finally
    //   84	87	130	finally
    //   107	113	130	finally
    //   120	124	130	finally
    //   131	134	130	finally
    //   146	152	130	finally
    //   156	160	130	finally
    //   160	162	130	finally
    //   17	22	136	finally
    //   22	37	162	finally
    //   40	62	171	finally
    //   94	103	187	finally
    //   22	37	197	java/lang/Exception
    //   40	62	207	java/lang/Exception
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = CommonDataAdapter.a().a();
      if (this.jdField_a_of_type_Long == 0L) {
        LogUtility.e(jdField_a_of_type_JavaLangString, "getUin() is empty!");
      }
    }
    return String.valueOf(this.jdField_a_of_type_Long);
  }
  
  /* Error */
  public java.util.Map a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: getstatic 103	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: ldc 206
    //   10: invokestatic 208	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: new 210	java/util/concurrent/ConcurrentHashMap
    //   16: dup
    //   17: invokespecial 212	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   20: astore 7
    //   22: getstatic 109	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   25: astore 6
    //   27: aload 6
    //   29: monitorenter
    //   30: aload_0
    //   31: invokevirtual 167	com/tencent/open/downloadnew/common/DownloadDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore_2
    //   35: aload_2
    //   36: ldc 19
    //   38: getstatic 107	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 173	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 4
    //   51: aload 4
    //   53: invokeinterface 177 1 0
    //   58: ifle +105 -> 163
    //   61: aload 4
    //   63: invokeinterface 181 1 0
    //   68: pop
    //   69: aload 4
    //   71: iconst_0
    //   72: invokeinterface 142 2 0
    //   77: astore_3
    //   78: getstatic 103	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: new 214	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   88: ldc 217
    //   90: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 208	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: aload 4
    //   106: invokevirtual 183	com/tencent/open/downloadnew/common/DownloadDBHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   109: astore 5
    //   111: getstatic 103	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: new 214	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   121: ldc 226
    //   123: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 5
    //   128: invokevirtual 227	com/tencent/open/downloadnew/DownloadInfo:toString	()Ljava/lang/String;
    //   131: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 208	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 7
    //   142: aload_3
    //   143: aload 5
    //   145: invokeinterface 233 3 0
    //   150: pop
    //   151: aload 4
    //   153: invokeinterface 236 1 0
    //   158: istore_1
    //   159: iload_1
    //   160: ifne -91 -> 69
    //   163: aload 4
    //   165: ifnull +10 -> 175
    //   168: aload 4
    //   170: invokeinterface 186 1 0
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   183: aload 6
    //   185: monitorexit
    //   186: aload 7
    //   188: areturn
    //   189: astore 4
    //   191: aconst_null
    //   192: astore 5
    //   194: aload_3
    //   195: astore_2
    //   196: aload 5
    //   198: astore_3
    //   199: getstatic 103	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: ldc 238
    //   204: aload 4
    //   206: invokestatic 194	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_3
    //   210: ifnull +9 -> 219
    //   213: aload_3
    //   214: invokeinterface 186 1 0
    //   219: aload_2
    //   220: ifnull -37 -> 183
    //   223: aload_2
    //   224: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   227: goto -44 -> 183
    //   230: astore_2
    //   231: aload 6
    //   233: monitorexit
    //   234: aload_2
    //   235: athrow
    //   236: astore_3
    //   237: aconst_null
    //   238: astore 5
    //   240: aload 4
    //   242: astore_2
    //   243: aload 5
    //   245: astore 4
    //   247: aload 4
    //   249: ifnull +10 -> 259
    //   252: aload 4
    //   254: invokeinterface 186 1 0
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   267: aload_3
    //   268: athrow
    //   269: astore_3
    //   270: aconst_null
    //   271: astore 4
    //   273: goto -26 -> 247
    //   276: astore_3
    //   277: goto -30 -> 247
    //   280: astore 5
    //   282: aload_3
    //   283: astore 4
    //   285: aload 5
    //   287: astore_3
    //   288: goto -41 -> 247
    //   291: astore 4
    //   293: aconst_null
    //   294: astore_3
    //   295: goto -96 -> 199
    //   298: astore_3
    //   299: aload 4
    //   301: astore 5
    //   303: aload_3
    //   304: astore 4
    //   306: aload 5
    //   308: astore_3
    //   309: goto -110 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	DownloadDBHelper
    //   158	2	1	bool	boolean
    //   34	190	2	localObject1	Object
    //   230	5	2	localObject2	Object
    //   242	22	2	localException1	Exception
    //   4	210	3	localObject3	Object
    //   236	32	3	localObject4	Object
    //   269	1	3	localObject5	Object
    //   276	7	3	localObject6	Object
    //   287	8	3	localObject7	Object
    //   298	6	3	localException2	Exception
    //   308	1	3	localObject8	Object
    //   1	168	4	localCursor	Cursor
    //   189	52	4	localException3	Exception
    //   245	39	4	localObject9	Object
    //   291	9	4	localException4	Exception
    //   304	1	4	localObject10	Object
    //   109	135	5	localDownloadInfo	DownloadInfo
    //   280	6	5	localObject11	Object
    //   301	6	5	localException5	Exception
    //   25	207	6	arrayOfByte	byte[]
    //   20	167	7	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   30	35	189	java/lang/Exception
    //   168	175	230	finally
    //   179	183	230	finally
    //   183	186	230	finally
    //   213	219	230	finally
    //   223	227	230	finally
    //   231	234	230	finally
    //   252	259	230	finally
    //   263	267	230	finally
    //   267	269	230	finally
    //   30	35	236	finally
    //   35	51	269	finally
    //   51	69	276	finally
    //   69	159	276	finally
    //   199	209	280	finally
    //   35	51	291	java/lang/Exception
    //   51	69	298	java/lang/Exception
    //   69	159	298	java/lang/Exception
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    localObject2 = null;
    localObject1 = null;
    i1 = 1;
    byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;
    try
    {
      localSQLiteDatabase = getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues = new ContentValues();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appid", paramDownloadInfo.jdField_b_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("download_url", paramDownloadInfo.jdField_c_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("package", paramDownloadInfo.d);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("push_title", paramDownloadInfo.e);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("sendtime_col", paramDownloadInfo.jdField_f_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("uin_col", a());
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("triggertime_col", Long.valueOf(paramDownloadInfo.jdField_a_of_type_Long));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("via_col", paramDownloadInfo.jdField_g_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("patch_url", paramDownloadInfo.jdField_h_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("update_type", Integer.valueOf(paramDownloadInfo.jdField_f_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("myappid_col", paramDownloadInfo.jdField_i_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("apkid_col", paramDownloadInfo.j);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("version_col", Integer.valueOf(paramDownloadInfo.jdField_g_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("downloadtype_col", Integer.valueOf(paramDownloadInfo.jdField_h_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("filepath_col", paramDownloadInfo.k);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("source_col", Integer.valueOf(paramDownloadInfo.jdField_i_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("last_download_size", Long.valueOf(paramDownloadInfo.jdField_b_of_type_Long));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      if (!paramDownloadInfo.jdField_c_of_type_Boolean) {
        break label705;
      }
    }
    catch (Exception paramDownloadInfo)
    {
      for (;;)
      {
        SQLiteDatabase localSQLiteDatabase;
        ContentValues localContentValues;
        long l1;
        localObject2 = localObject1;
        LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
        if (localObject1 != null) {
          try
          {
            localObject1.endTransaction();
            localObject1.close();
          }
          catch (Exception paramDownloadInfo)
          {
            LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        if (localObject2 != null) {}
        try
        {
          localObject2.endTransaction();
          localObject2.close();
          throw paramDownloadInfo;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", localException);
          }
        }
        i1 = 0;
      }
    }
    localObject1 = localSQLiteDatabase;
    localObject2 = localSQLiteDatabase;
    localContentValues.put("is_apk", Integer.valueOf(i1));
    localObject1 = localSQLiteDatabase;
    localObject2 = localSQLiteDatabase;
    localContentValues.put("myapp_download_from", Integer.valueOf(paramDownloadInfo.m));
    localObject1 = localSQLiteDatabase;
    localObject2 = localSQLiteDatabase;
    i1 = localSQLiteDatabase.update("download_info", localContentValues, "appid = ?", new String[] { paramDownloadInfo.jdField_b_of_type_JavaLangString });
    localObject1 = localSQLiteDatabase;
    localObject2 = localSQLiteDatabase;
    LogUtility.a(jdField_a_of_type_JavaLangString, "addDownloadInfo>>>update affected rowNum=" + i1);
    if (i1 == 0)
    {
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      l1 = localSQLiteDatabase.insert("download_info", null, localContentValues);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      LogUtility.a(jdField_a_of_type_JavaLangString, "addDownloadInfo>>>insert rowID = " + l1);
    }
    localObject1 = localSQLiteDatabase;
    localObject2 = localSQLiteDatabase;
    localSQLiteDatabase.setTransactionSuccessful();
    if (localSQLiteDatabase != null) {}
    try
    {
      localSQLiteDatabase.endTransaction();
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramDownloadInfo)
    {
      for (;;)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
      }
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: getstatic 109	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_0
    //   13: invokevirtual 262	com/tencent/open/downloadnew/common/DownloadDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 4
    //   18: aload 4
    //   20: astore_2
    //   21: aload 4
    //   23: astore_3
    //   24: getstatic 103	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: new 214	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 347
    //   37: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iconst_1
    //   41: anewarray 105	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: aload_1
    //   47: aastore
    //   48: invokestatic 352	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 208	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 4
    //   68: ldc 19
    //   70: ldc_w 323
    //   73: iconst_1
    //   74: anewarray 105	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokevirtual 356	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   84: pop
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   95: aload 5
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: aload_2
    //   101: astore_3
    //   102: getstatic 103	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   105: ldc_w 358
    //   108: aload_1
    //   109: invokestatic 194	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: ifnull -18 -> 95
    //   116: aload_2
    //   117: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   120: goto -25 -> 95
    //   123: astore_1
    //   124: aload 5
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_3
    //   131: ifnull +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 187	android/database/sqlite/SQLiteDatabase:close	()V
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	DownloadDBHelper
    //   0	140	1	paramString	String
    //   11	106	2	localObject1	Object
    //   9	126	3	localObject2	Object
    //   16	75	4	localSQLiteDatabase	SQLiteDatabase
    //   3	122	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	18	99	java/lang/Exception
    //   24	60	99	java/lang/Exception
    //   66	85	99	java/lang/Exception
    //   90	95	123	finally
    //   95	98	123	finally
    //   116	120	123	finally
    //   124	127	123	finally
    //   134	138	123	finally
    //   138	140	123	finally
    //   12	18	129	finally
    //   24	60	129	finally
    //   66	85	129	finally
    //   102	112	129	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (appid TEXT PRIMARY KEY,download_url TEXT,package TEXT,push_title TEXT,sendtime_col TEXT,uin_col TEXT,triggertime_col INTEGER,via_col TEXT,patch_url TEXT,update_type INTEGER,myappid_col TEXT,apkid_col TEXT,version_col INTEGER,downloadtype_col INTEGER,filepath_col TEXT,source_col INTEGER,last_download_size INTEGER,is_apk INTEGER,myapp_download_from INTEGER); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadDBHelper
 * JD-Core Version:    0.7.0.1
 */