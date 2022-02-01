package com.tencent.open.agent.report;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;

public class ReportDatabaseHelper
  extends SQLiteOpenHelper
{
  protected static final int a = 20;
  protected static ReportDatabaseHelper a;
  protected static final String a = "agent_report.db";
  protected static final String[] a;
  private static final int b = 2;
  protected static final String b = "via_cgi_report";
  protected static final String c = "key";
  protected static final String d = "type";
  protected static final String e = "blob";
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "key" };
  }
  
  public ReportDatabaseHelper(Context paramContext)
  {
    super(paramContext, "agent_report.db", null, 2);
  }
  
  public static ReportDatabaseHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper == null) {
        jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper = new ReportDatabaseHelper(CommonDataAdapter.a().a());
      }
      ReportDatabaseHelper localReportDatabaseHelper = jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper;
      return localReportDatabaseHelper;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    try
    {
      localSQLiteDatabase = getReadableDatabase();
      if (localSQLiteDatabase != null)
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (!bool) {
          break label30;
        }
      }
      j = 0;
    }
    finally
    {
      for (;;)
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase;
          label30:
          paramString = localSQLiteDatabase.query("via_cgi_report", jdField_a_of_type_ArrayOfJavaLangString, "type = ?", new String[] { paramString }, null, null, null);
          if (paramString == null) {
            break label109;
          }
        }
        finally
        {
          int j;
          paramString = null;
          if (paramString != null) {
            paramString.close();
          }
        }
        try
        {
          i = paramString.getCount();
          j = i;
          if (paramString != null)
          {
            paramString.close();
            j = i;
          }
        }
        finally {}
      }
      paramString = finally;
    }
    return j;
    for (;;)
    {
      label109:
      int i = 0;
    }
  }
  
  /* Error */
  public java.util.List a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 85	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 87	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_0
    //   12: invokevirtual 55	com/tencent/open/agent/report/ReportDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +12 -> 29
    //   20: aload_1
    //   21: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: istore_2
    //   25: iload_2
    //   26: ifeq +8 -> 34
    //   29: aload_0
    //   30: monitorexit
    //   31: aload 5
    //   33: areturn
    //   34: aload_3
    //   35: ldc 16
    //   37: aconst_null
    //   38: ldc 63
    //   40: iconst_1
    //   41: anewarray 29	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: aload_1
    //   47: aastore
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: invokevirtual 69	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 4
    //   56: aload 4
    //   58: ifnull +104 -> 162
    //   61: aload 4
    //   63: invokeinterface 75 1 0
    //   68: ifle +94 -> 162
    //   71: aload 4
    //   73: invokeinterface 91 1 0
    //   78: pop
    //   79: new 93	java/io/ByteArrayInputStream
    //   82: dup
    //   83: aload 4
    //   85: aload 4
    //   87: ldc 25
    //   89: invokeinterface 96 2 0
    //   94: invokeinterface 100 2 0
    //   99: invokespecial 103	java/io/ByteArrayInputStream:<init>	([B)V
    //   102: astore 6
    //   104: new 105	java/io/ObjectInputStream
    //   107: dup
    //   108: aload 6
    //   110: invokespecial 108	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 112	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   118: checkcast 114	java/io/Serializable
    //   121: astore_3
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 115	java/io/ObjectInputStream:close	()V
    //   130: aload 6
    //   132: invokevirtual 116	java/io/ByteArrayInputStream:close	()V
    //   135: aload_3
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +12 -> 150
    //   141: aload 5
    //   143: aload_1
    //   144: invokeinterface 122 2 0
    //   149: pop
    //   150: aload 4
    //   152: invokeinterface 125 1 0
    //   157: istore_2
    //   158: iload_2
    //   159: ifne -80 -> 79
    //   162: aload 4
    //   164: ifnull +10 -> 174
    //   167: aload 4
    //   169: invokeinterface 78 1 0
    //   174: iconst_0
    //   175: ifeq +11 -> 186
    //   178: new 127	java/lang/NullPointerException
    //   181: dup
    //   182: invokespecial 128	java/lang/NullPointerException:<init>	()V
    //   185: athrow
    //   186: goto -157 -> 29
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: ifnull +7 -> 200
    //   196: aload_1
    //   197: invokevirtual 115	java/io/ObjectInputStream:close	()V
    //   200: aload 6
    //   202: invokevirtual 116	java/io/ByteArrayInputStream:close	()V
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -70 -> 137
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -76 -> 137
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_1
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 115	java/io/ObjectInputStream:close	()V
    //   227: aload 6
    //   229: invokevirtual 116	java/io/ByteArrayInputStream:close	()V
    //   232: aload_3
    //   233: athrow
    //   234: astore_1
    //   235: aload 4
    //   237: astore_3
    //   238: aload_3
    //   239: ifnull +9 -> 248
    //   242: aload_3
    //   243: invokeinterface 78 1 0
    //   248: iconst_0
    //   249: ifeq +11 -> 260
    //   252: new 127	java/lang/NullPointerException
    //   255: dup
    //   256: invokespecial 128	java/lang/NullPointerException:<init>	()V
    //   259: athrow
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: aload_0
    //   264: monitorexit
    //   265: aload_1
    //   266: athrow
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   272: goto -86 -> 186
    //   275: astore_3
    //   276: aload_3
    //   277: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   280: goto -20 -> 260
    //   283: astore_1
    //   284: goto -154 -> 130
    //   287: astore_1
    //   288: aload_3
    //   289: astore_1
    //   290: goto -153 -> 137
    //   293: astore_1
    //   294: goto -94 -> 200
    //   297: astore_1
    //   298: goto -71 -> 227
    //   301: astore_1
    //   302: goto -70 -> 232
    //   305: astore_1
    //   306: aconst_null
    //   307: astore_3
    //   308: goto -70 -> 238
    //   311: astore_3
    //   312: goto -93 -> 219
    //   315: astore_3
    //   316: goto -124 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	ReportDatabaseHelper
    //   0	319	1	paramString	String
    //   24	135	2	bool	boolean
    //   15	121	3	localObject1	Object
    //   216	17	3	localObject2	Object
    //   237	6	3	localObject3	Object
    //   275	14	3	localIOException	java.io.IOException
    //   307	1	3	localObject4	Object
    //   311	1	3	localObject5	Object
    //   315	1	3	localException	java.lang.Exception
    //   54	182	4	localCursor	Cursor
    //   9	133	5	localArrayList	java.util.ArrayList
    //   102	126	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   104	114	189	java/lang/Exception
    //   200	205	210	java/io/IOException
    //   104	114	216	finally
    //   61	79	234	finally
    //   79	104	234	finally
    //   126	130	234	finally
    //   130	135	234	finally
    //   141	150	234	finally
    //   150	158	234	finally
    //   196	200	234	finally
    //   200	205	234	finally
    //   223	227	234	finally
    //   227	232	234	finally
    //   232	234	234	finally
    //   2	16	262	finally
    //   20	25	262	finally
    //   167	174	262	finally
    //   178	186	262	finally
    //   242	248	262	finally
    //   252	260	262	finally
    //   260	262	262	finally
    //   268	272	262	finally
    //   276	280	262	finally
    //   178	186	267	java/io/IOException
    //   252	260	275	java/io/IOException
    //   126	130	283	java/io/IOException
    //   130	135	287	java/io/IOException
    //   196	200	293	java/io/IOException
    //   223	227	297	java/io/IOException
    //   227	232	301	java/io/IOException
    //   34	56	305	finally
    //   114	122	311	finally
    //   114	122	315	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 135	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_3
    //   24: ldc 16
    //   26: ldc 63
    //   28: iconst_1
    //   29: anewarray 29	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: invokevirtual 139	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   39: pop
    //   40: goto -20 -> 20
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ReportDatabaseHelper
    //   0	48	1	paramString	String
    //   15	2	2	bool	boolean
    //   6	18	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   11	16	43	finally
    //   23	40	43	finally
  }
  
  /* Error */
  public void a(String paramString, java.util.List paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokeinterface 143 1 0
    //   11: istore_3
    //   12: iload_3
    //   13: ifne +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: iload_3
    //   20: bipush 20
    //   22: if_icmpgt +157 -> 179
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 145	com/tencent/open/agent/report/ReportDatabaseHelper:a	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual 135	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore 7
    //   36: aload 7
    //   38: ifnull -22 -> 16
    //   41: aload_1
    //   42: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne -29 -> 16
    //   48: aload 7
    //   50: invokevirtual 148	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   53: new 150	android/content/ContentValues
    //   56: dup
    //   57: invokespecial 151	android/content/ContentValues:<init>	()V
    //   60: astore 9
    //   62: iconst_0
    //   63: istore 4
    //   65: iload 4
    //   67: iload_3
    //   68: if_icmpge +177 -> 245
    //   71: aload_2
    //   72: iload 4
    //   74: invokeinterface 155 2 0
    //   79: checkcast 114	java/io/Serializable
    //   82: astore 10
    //   84: aload 10
    //   86: ifnull +79 -> 165
    //   89: aload 9
    //   91: ldc 22
    //   93: aload_1
    //   94: invokevirtual 159	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: new 161	java/io/ByteArrayOutputStream
    //   100: dup
    //   101: sipush 512
    //   104: invokespecial 164	java/io/ByteArrayOutputStream:<init>	(I)V
    //   107: astore 8
    //   109: new 166	java/io/ObjectOutputStream
    //   112: dup
    //   113: aload 8
    //   115: invokespecial 169	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   118: astore 5
    //   120: aload 5
    //   122: aload 10
    //   124: invokevirtual 173	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   127: aload 5
    //   129: ifnull +8 -> 137
    //   132: aload 5
    //   134: invokevirtual 174	java/io/ObjectOutputStream:close	()V
    //   137: aload 8
    //   139: invokevirtual 175	java/io/ByteArrayOutputStream:close	()V
    //   142: aload 9
    //   144: ldc 25
    //   146: aload 8
    //   148: invokevirtual 179	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   151: invokevirtual 182	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   154: aload 7
    //   156: ldc 16
    //   158: aconst_null
    //   159: aload 9
    //   161: invokevirtual 186	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   164: pop2
    //   165: aload 9
    //   167: invokevirtual 189	android/content/ContentValues:clear	()V
    //   170: iload 4
    //   172: iconst_1
    //   173: iadd
    //   174: istore 4
    //   176: goto -111 -> 65
    //   179: bipush 20
    //   181: istore_3
    //   182: goto -157 -> 25
    //   185: astore 5
    //   187: aconst_null
    //   188: astore 5
    //   190: aload 5
    //   192: ifnull +8 -> 200
    //   195: aload 5
    //   197: invokevirtual 174	java/io/ObjectOutputStream:close	()V
    //   200: aload 8
    //   202: invokevirtual 175	java/io/ByteArrayOutputStream:close	()V
    //   205: goto -63 -> 142
    //   208: astore 5
    //   210: goto -68 -> 142
    //   213: astore_1
    //   214: aload 6
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 174	java/io/ObjectOutputStream:close	()V
    //   225: aload 8
    //   227: invokevirtual 175	java/io/ByteArrayOutputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: aload 7
    //   235: invokevirtual 192	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    //   245: aload 7
    //   247: invokevirtual 195	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   250: aload 7
    //   252: invokevirtual 192	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   255: goto -239 -> 16
    //   258: astore 5
    //   260: goto -123 -> 137
    //   263: astore 5
    //   265: goto -123 -> 142
    //   268: astore 5
    //   270: goto -70 -> 200
    //   273: astore_2
    //   274: goto -49 -> 225
    //   277: astore_2
    //   278: goto -48 -> 230
    //   281: astore_1
    //   282: aload 5
    //   284: astore_2
    //   285: goto -68 -> 217
    //   288: astore 10
    //   290: goto -100 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	ReportDatabaseHelper
    //   0	293	1	paramString	String
    //   0	293	2	paramList	java.util.List
    //   11	171	3	i	int
    //   63	112	4	j	int
    //   118	15	5	localObjectOutputStream	java.io.ObjectOutputStream
    //   185	1	5	localIOException1	java.io.IOException
    //   188	8	5	localObject1	Object
    //   208	1	5	localIOException2	java.io.IOException
    //   258	1	5	localIOException3	java.io.IOException
    //   263	1	5	localIOException4	java.io.IOException
    //   268	15	5	localIOException5	java.io.IOException
    //   1	214	6	localObject2	Object
    //   34	217	7	localSQLiteDatabase	SQLiteDatabase
    //   107	119	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   60	106	9	localContentValues	android.content.ContentValues
    //   82	41	10	localSerializable	java.io.Serializable
    //   288	1	10	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   109	120	185	java/io/IOException
    //   200	205	208	java/io/IOException
    //   109	120	213	finally
    //   53	62	232	finally
    //   71	84	232	finally
    //   89	109	232	finally
    //   132	137	232	finally
    //   137	142	232	finally
    //   142	165	232	finally
    //   165	170	232	finally
    //   195	200	232	finally
    //   200	205	232	finally
    //   221	225	232	finally
    //   225	230	232	finally
    //   230	232	232	finally
    //   245	250	232	finally
    //   5	12	240	finally
    //   25	36	240	finally
    //   41	53	240	finally
    //   233	240	240	finally
    //   250	255	240	finally
    //   132	137	258	java/io/IOException
    //   137	142	263	java/io/IOException
    //   195	200	268	java/io/IOException
    //   221	225	273	java/io/IOException
    //   225	230	277	java/io/IOException
    //   120	127	281	finally
    //   120	127	288	java/io/IOException
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */