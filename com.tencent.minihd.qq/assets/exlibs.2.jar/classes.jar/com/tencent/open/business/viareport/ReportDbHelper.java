package com.tencent.open.business.viareport;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.util.ArrayList;

public class ReportDbHelper
{
  protected static ReportDbHelper a;
  protected static final String a = "BusinessReport";
  
  public static ReportDbHelper a()
  {
    try
    {
      if (a == null) {
        a = new ReportDbHelper();
      }
      ReportDbHelper localReportDbHelper = a;
      return localReportDbHelper;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    try
    {
      int i = 0 + b("table_new_data", paramString);
      LogUtility.b("Jie", "new_table>>count=" + i);
      i += b("table_old_data", paramString);
      LogUtility.b("Jie", "all_table>>>count=" + i);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = a();
        if (!TextUtils.isEmpty(paramString2)) {
          continue;
        }
        paramString2 = localObject;
        i = localSQLiteDatabase.delete(paramString1, paramString2, null);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        LogUtility.e("BusinessReport", paramString1.getLocalizedMessage());
        int i = -1;
        continue;
      }
      finally {}
      return i;
      paramString2 = "uin=" + paramString2;
    }
  }
  
  /* Error */
  public int a(String paramString, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: invokestatic 86	com/tencent/mobileqq/app/SQLiteDatabase:f	()V
    //   10: aload_0
    //   11: invokevirtual 57	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: invokevirtual 89	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   17: aload_2
    //   18: invokevirtual 95	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   21: astore_2
    //   22: iload_3
    //   23: istore 4
    //   25: aload_2
    //   26: invokeinterface 101 1 0
    //   31: ifeq +28 -> 59
    //   34: iload_3
    //   35: istore 4
    //   37: aload_0
    //   38: aload_1
    //   39: aload_2
    //   40: invokeinterface 105 1 0
    //   45: checkcast 107	com/tencent/open/business/viareport/BatchReportInfo
    //   48: invokevirtual 110	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Lcom/tencent/open/business/viareport/BatchReportInfo;)J
    //   51: pop2
    //   52: iload_3
    //   53: iconst_1
    //   54: iadd
    //   55: istore_3
    //   56: goto -34 -> 22
    //   59: iload_3
    //   60: istore 4
    //   62: aload_0
    //   63: invokevirtual 57	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   66: invokevirtual 113	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   69: aload_0
    //   70: invokevirtual 57	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   73: invokevirtual 116	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   76: invokestatic 119	com/tencent/mobileqq/app/SQLiteDatabase:g	()V
    //   79: aload_0
    //   80: monitorexit
    //   81: iload_3
    //   82: ireturn
    //   83: astore_1
    //   84: iload 4
    //   86: istore_3
    //   87: ldc 9
    //   89: ldc 121
    //   91: aload_1
    //   92: invokestatic 125	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_0
    //   96: invokevirtual 57	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   99: invokevirtual 116	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   102: invokestatic 119	com/tencent/mobileqq/app/SQLiteDatabase:g	()V
    //   105: goto -26 -> 79
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: astore_1
    //   114: aload_0
    //   115: invokevirtual 57	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   118: invokevirtual 116	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   121: invokestatic 119	com/tencent/mobileqq/app/SQLiteDatabase:g	()V
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ReportDbHelper
    //   0	126	1	paramString	String
    //   0	126	2	paramArrayList	ArrayList
    //   6	81	3	i	int
    //   3	82	4	j	int
    // Exception table:
    //   from	to	target	type
    //   17	22	83	java/lang/Exception
    //   25	34	83	java/lang/Exception
    //   37	52	83	java/lang/Exception
    //   62	69	83	java/lang/Exception
    //   7	17	108	finally
    //   69	79	108	finally
    //   95	105	108	finally
    //   114	126	108	finally
    //   17	22	113	finally
    //   25	34	113	finally
    //   37	52	113	finally
    //   62	69	113	finally
    //   87	95	113	finally
  }
  
  public int a(ArrayList paramArrayList)
  {
    try
    {
      int i = a("table_old_data", paramArrayList);
      return i;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public long a(String paramString, BatchReportInfo paramBatchReportInfo)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("actiontype", paramBatchReportInfo.c);
      localContentValues.put("appid", paramBatchReportInfo.a);
      localContentValues.put("qua", paramBatchReportInfo.e);
      localContentValues.put("uin", paramBatchReportInfo.d);
      localContentValues.put("via", paramBatchReportInfo.b);
      localContentValues.put("network", paramBatchReportInfo.a());
      localContentValues.put("timestamp", paramBatchReportInfo.g);
      localContentValues.put("expand1", paramBatchReportInfo.h);
      localContentValues.put("expand2", paramBatchReportInfo.i);
      localContentValues.put("expand3", paramBatchReportInfo.j);
      localContentValues.put("expand4", paramBatchReportInfo.k);
      localContentValues.put("expand5", paramBatchReportInfo.l);
      long l1 = -1L;
      try
      {
        long l2 = a().insertOrThrow(paramString, "_id", localContentValues);
        l1 = l2;
      }
      catch (SQLException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          LogUtility.e("BusinessReport", paramString.getLocalizedMessage());
        }
      }
      return l1;
    }
    finally {}
  }
  
  protected SQLiteDatabase a()
  {
    return ReportSqliteHelper.a(CommonDataAdapter.a().a()).getWritableDatabase();
  }
  
  public ArrayList a(String paramString)
  {
    try
    {
      paramString = a("table_new_data", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public ArrayList a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: new 91	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 221	java/util/ArrayList:<init>	()V
    //   15: astore 8
    //   17: aload_2
    //   18: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +429 -> 450
    //   24: aconst_null
    //   25: astore 5
    //   27: aload_2
    //   28: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: istore_3
    //   32: iload_3
    //   33: ifeq +424 -> 457
    //   36: aconst_null
    //   37: astore 6
    //   39: aload 7
    //   41: astore_2
    //   42: aload_0
    //   43: invokevirtual 57	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   46: aload_1
    //   47: aconst_null
    //   48: aload 5
    //   50: aload 6
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 225	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_1
    //   59: aload_1
    //   60: astore_2
    //   61: aload_1
    //   62: astore 4
    //   64: aload_1
    //   65: invokeinterface 230 1 0
    //   70: pop
    //   71: aload_1
    //   72: astore_2
    //   73: aload_1
    //   74: astore 4
    //   76: aload_1
    //   77: invokeinterface 233 1 0
    //   82: ifne +394 -> 476
    //   85: aload_1
    //   86: astore_2
    //   87: aload_1
    //   88: astore 4
    //   90: new 107	com/tencent/open/business/viareport/BatchReportInfo
    //   93: dup
    //   94: invokespecial 234	com/tencent/open/business/viareport/BatchReportInfo:<init>	()V
    //   97: astore 5
    //   99: aload_1
    //   100: astore_2
    //   101: aload_1
    //   102: astore 4
    //   104: aload 5
    //   106: aload_1
    //   107: aload_1
    //   108: ldc 135
    //   110: invokeinterface 237 2 0
    //   115: invokeinterface 241 2 0
    //   120: putfield 137	com/tencent/open/business/viareport/BatchReportInfo:c	Ljava/lang/String;
    //   123: aload_1
    //   124: astore_2
    //   125: aload_1
    //   126: astore 4
    //   128: aload 5
    //   130: aload_1
    //   131: aload_1
    //   132: ldc 142
    //   134: invokeinterface 237 2 0
    //   139: invokeinterface 241 2 0
    //   144: putfield 144	com/tencent/open/business/viareport/BatchReportInfo:a	Ljava/lang/String;
    //   147: aload_1
    //   148: astore_2
    //   149: aload_1
    //   150: astore 4
    //   152: aload 5
    //   154: aload_1
    //   155: aload_1
    //   156: ldc 146
    //   158: invokeinterface 237 2 0
    //   163: invokeinterface 241 2 0
    //   168: putfield 148	com/tencent/open/business/viareport/BatchReportInfo:e	Ljava/lang/String;
    //   171: aload_1
    //   172: astore_2
    //   173: aload_1
    //   174: astore 4
    //   176: aload 5
    //   178: aload_1
    //   179: aload_1
    //   180: ldc 150
    //   182: invokeinterface 237 2 0
    //   187: invokeinterface 241 2 0
    //   192: putfield 153	com/tencent/open/business/viareport/BatchReportInfo:d	Ljava/lang/String;
    //   195: aload_1
    //   196: astore_2
    //   197: aload_1
    //   198: astore 4
    //   200: aload 5
    //   202: aload_1
    //   203: aload_1
    //   204: ldc 155
    //   206: invokeinterface 237 2 0
    //   211: invokeinterface 241 2 0
    //   216: putfield 157	com/tencent/open/business/viareport/BatchReportInfo:b	Ljava/lang/String;
    //   219: aload_1
    //   220: astore_2
    //   221: aload_1
    //   222: astore 4
    //   224: aload 5
    //   226: aload_1
    //   227: aload_1
    //   228: ldc 159
    //   230: invokeinterface 237 2 0
    //   235: invokeinterface 241 2 0
    //   240: putfield 243	com/tencent/open/business/viareport/BatchReportInfo:f	Ljava/lang/String;
    //   243: aload_1
    //   244: astore_2
    //   245: aload_1
    //   246: astore 4
    //   248: aload 5
    //   250: aload_1
    //   251: aload_1
    //   252: ldc 163
    //   254: invokeinterface 237 2 0
    //   259: invokeinterface 241 2 0
    //   264: putfield 165	com/tencent/open/business/viareport/BatchReportInfo:g	Ljava/lang/String;
    //   267: aload_1
    //   268: astore_2
    //   269: aload_1
    //   270: astore 4
    //   272: aload 5
    //   274: aload_1
    //   275: aload_1
    //   276: ldc 167
    //   278: invokeinterface 237 2 0
    //   283: invokeinterface 241 2 0
    //   288: putfield 170	com/tencent/open/business/viareport/BatchReportInfo:h	Ljava/lang/String;
    //   291: aload_1
    //   292: astore_2
    //   293: aload_1
    //   294: astore 4
    //   296: aload 5
    //   298: aload_1
    //   299: aload_1
    //   300: ldc 172
    //   302: invokeinterface 237 2 0
    //   307: invokeinterface 241 2 0
    //   312: putfield 175	com/tencent/open/business/viareport/BatchReportInfo:i	Ljava/lang/String;
    //   315: aload_1
    //   316: astore_2
    //   317: aload_1
    //   318: astore 4
    //   320: aload 5
    //   322: aload_1
    //   323: aload_1
    //   324: ldc 177
    //   326: invokeinterface 237 2 0
    //   331: invokeinterface 241 2 0
    //   336: putfield 180	com/tencent/open/business/viareport/BatchReportInfo:j	Ljava/lang/String;
    //   339: aload_1
    //   340: astore_2
    //   341: aload_1
    //   342: astore 4
    //   344: aload 5
    //   346: aload_1
    //   347: aload_1
    //   348: ldc 182
    //   350: invokeinterface 237 2 0
    //   355: invokeinterface 241 2 0
    //   360: putfield 185	com/tencent/open/business/viareport/BatchReportInfo:k	Ljava/lang/String;
    //   363: aload_1
    //   364: astore_2
    //   365: aload_1
    //   366: astore 4
    //   368: aload 5
    //   370: aload_1
    //   371: aload_1
    //   372: ldc 187
    //   374: invokeinterface 237 2 0
    //   379: invokeinterface 241 2 0
    //   384: putfield 190	com/tencent/open/business/viareport/BatchReportInfo:l	Ljava/lang/String;
    //   387: aload_1
    //   388: astore_2
    //   389: aload_1
    //   390: astore 4
    //   392: aload 8
    //   394: aload 5
    //   396: invokevirtual 247	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   399: pop
    //   400: aload_1
    //   401: astore_2
    //   402: aload_1
    //   403: astore 4
    //   405: aload_1
    //   406: invokeinterface 250 1 0
    //   411: pop
    //   412: goto -341 -> 71
    //   415: astore_1
    //   416: aload_2
    //   417: astore 4
    //   419: aload_1
    //   420: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   423: aload_2
    //   424: astore 4
    //   426: ldc 9
    //   428: aload_1
    //   429: invokevirtual 77	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   432: invokestatic 80	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload_2
    //   436: ifnull +9 -> 445
    //   439: aload_2
    //   440: invokeinterface 253 1 0
    //   445: aload_0
    //   446: monitorexit
    //   447: aload 8
    //   449: areturn
    //   450: ldc 255
    //   452: astore 5
    //   454: goto -427 -> 27
    //   457: iconst_1
    //   458: anewarray 257	java/lang/String
    //   461: astore 6
    //   463: aload 6
    //   465: iconst_0
    //   466: aload_2
    //   467: aastore
    //   468: goto -429 -> 39
    //   471: astore_1
    //   472: aload_0
    //   473: monitorexit
    //   474: aload_1
    //   475: athrow
    //   476: aload_1
    //   477: ifnull -32 -> 445
    //   480: aload_1
    //   481: invokeinterface 253 1 0
    //   486: goto -41 -> 445
    //   489: astore_1
    //   490: aload 4
    //   492: ifnull +10 -> 502
    //   495: aload 4
    //   497: invokeinterface 253 1 0
    //   502: aload_1
    //   503: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	ReportDbHelper
    //   0	504	1	paramString1	String
    //   0	504	2	paramString2	String
    //   31	2	3	bool	boolean
    //   1	495	4	str	String
    //   25	428	5	localObject1	Object
    //   37	427	6	arrayOfString	String[]
    //   4	36	7	localObject2	Object
    //   15	433	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   42	59	415	java/lang/Exception
    //   64	71	415	java/lang/Exception
    //   76	85	415	java/lang/Exception
    //   90	99	415	java/lang/Exception
    //   104	123	415	java/lang/Exception
    //   128	147	415	java/lang/Exception
    //   152	171	415	java/lang/Exception
    //   176	195	415	java/lang/Exception
    //   200	219	415	java/lang/Exception
    //   224	243	415	java/lang/Exception
    //   248	267	415	java/lang/Exception
    //   272	291	415	java/lang/Exception
    //   296	315	415	java/lang/Exception
    //   320	339	415	java/lang/Exception
    //   344	363	415	java/lang/Exception
    //   368	387	415	java/lang/Exception
    //   392	400	415	java/lang/Exception
    //   405	412	415	java/lang/Exception
    //   8	24	471	finally
    //   27	32	471	finally
    //   439	445	471	finally
    //   457	463	471	finally
    //   480	486	471	finally
    //   495	502	471	finally
    //   502	504	471	finally
    //   42	59	489	finally
    //   64	71	489	finally
    //   76	85	489	finally
    //   90	99	489	finally
    //   104	123	489	finally
    //   128	147	489	finally
    //   152	171	489	finally
    //   176	195	489	finally
    //   200	219	489	finally
    //   224	243	489	finally
    //   248	267	489	finally
    //   272	291	489	finally
    //   296	315	489	finally
    //   320	339	489	finally
    //   344	363	489	finally
    //   368	387	489	finally
    //   392	400	489	finally
    //   405	412	489	finally
    //   419	423	489	finally
    //   426	435	489	finally
  }
  
  /* Error */
  public int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_2
    //   9: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +73 -> 85
    //   15: aconst_null
    //   16: astore 7
    //   18: aload_2
    //   19: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: istore 5
    //   24: iload 5
    //   26: ifeq +66 -> 92
    //   29: aconst_null
    //   30: astore 8
    //   32: aload 9
    //   34: astore_2
    //   35: aload_0
    //   36: invokevirtual 57	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: aload_1
    //   40: aconst_null
    //   41: aload 7
    //   43: aload 8
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 225	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore_1
    //   52: aload_1
    //   53: astore_2
    //   54: aload_1
    //   55: astore 6
    //   57: aload_1
    //   58: invokeinterface 261 1 0
    //   63: istore_3
    //   64: iload_3
    //   65: istore 4
    //   67: aload_1
    //   68: ifnull +12 -> 80
    //   71: aload_1
    //   72: invokeinterface 253 1 0
    //   77: iload_3
    //   78: istore 4
    //   80: aload_0
    //   81: monitorexit
    //   82: iload 4
    //   84: ireturn
    //   85: ldc 255
    //   87: astore 7
    //   89: goto -71 -> 18
    //   92: iconst_1
    //   93: anewarray 257	java/lang/String
    //   96: astore 8
    //   98: aload 8
    //   100: iconst_0
    //   101: aload_2
    //   102: aastore
    //   103: goto -71 -> 32
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: aload_2
    //   113: astore 6
    //   115: aload_1
    //   116: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   119: aload_2
    //   120: astore 6
    //   122: ldc 9
    //   124: aload_1
    //   125: invokevirtual 77	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   128: invokestatic 80	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_2
    //   132: ifnull +27 -> 159
    //   135: aload_2
    //   136: invokeinterface 253 1 0
    //   141: goto +18 -> 159
    //   144: astore_1
    //   145: aload 6
    //   147: ifnull +10 -> 157
    //   150: aload 6
    //   152: invokeinterface 253 1 0
    //   157: aload_1
    //   158: athrow
    //   159: iconst_0
    //   160: istore 4
    //   162: goto -82 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	ReportDbHelper
    //   0	165	1	paramString1	String
    //   0	165	2	paramString2	String
    //   63	15	3	i	int
    //   65	96	4	j	int
    //   22	3	5	bool	boolean
    //   1	150	6	str1	String
    //   16	72	7	str2	String
    //   30	69	8	arrayOfString	String[]
    //   4	29	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	15	106	finally
    //   18	24	106	finally
    //   71	77	106	finally
    //   92	98	106	finally
    //   135	141	106	finally
    //   150	157	106	finally
    //   157	159	106	finally
    //   35	52	111	java/lang/Exception
    //   57	64	111	java/lang/Exception
    //   35	52	144	finally
    //   57	64	144	finally
    //   115	119	144	finally
    //   122	131	144	finally
  }
  
  public ArrayList b(String paramString)
  {
    try
    {
      paramString = a("table_old_data", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportDbHelper
 * JD-Core Version:    0.7.0.1
 */