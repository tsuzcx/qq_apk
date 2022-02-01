package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.repair.RepairKit.Callback;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONObject;

public final class a
  extends AsyncTask<Void, Integer, Integer>
{
  private static final String[] CONFLICT_VALUES;
  private static final SQLiteCipherSpec udq;
  private final CancellationSignal mCancellationSignal;
  private List<byte[]> udA;
  private List<byte[]> udB;
  private d udC;
  private boolean udD;
  private b udE;
  private boolean udF;
  private int udG;
  private long udH;
  private long udI;
  private SQLiteDatabase udr;
  private String uds;
  private String udt;
  private String udu;
  private String udv;
  private List<String> udw;
  private List<String> udx;
  private byte[] udy;
  private byte[] udz;
  
  static
  {
    AppMethodBeat.i(23138);
    udq = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    CONFLICT_VALUES = new String[] { "", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE" };
    AppMethodBeat.o(23138);
  }
  
  private a()
  {
    AppMethodBeat.i(23120);
    this.mCancellationSignal = new CancellationSignal();
    AppMethodBeat.o(23120);
  }
  
  private int a(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, e parame)
  {
    AppMethodBeat.i(23129);
    try
    {
      localObject = DatabaseUtils.stringForQuery(paramSQLiteDatabase, "SELECT sql FROM sqlite_master WHERE name = ?", new String[] { paramString });
      if ((localObject == null) || (((String)localObject).isEmpty()))
      {
        paramSQLiteDatabase = new SQLiteDoneException();
        AppMethodBeat.o(23129);
        throw paramSQLiteDatabase;
      }
    }
    catch (SQLiteDoneException paramSQLiteDatabase)
    {
      Log.e("MicroMsg.DBRecoveryTask", "There is no table named '%s' to copy.", new Object[] { paramString });
      if (this.udr.inTransaction()) {
        this.udr.endTransaction();
      }
      AppMethodBeat.o(23129);
      return -1;
      localObject = ((String)localObject).replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS ");
      this.udr.execSQL((String)localObject, null, this.mCancellationSignal);
      if (!paramBoolean)
      {
        if (this.udr.inTransaction()) {
          this.udr.endTransaction();
        }
        AppMethodBeat.o(23129);
        return 0;
      }
      Log.i("MicroMsg.DBRecoveryTask", "Create %d column to '%s' by ALTER TABLE.", new Object[] { Integer.valueOf(b(paramSQLiteDatabase, paramString)), paramString });
      int j = (int)DatabaseUtils.longForQuery(paramSQLiteDatabase, "SELECT count(*) FROM ".concat(String.valueOf(paramString)), null);
      localObject = paramSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM ".concat(String.valueOf(paramString)), null, paramString, this.mCancellationSignal);
      for (;;)
      {
        try
        {
          paramSQLiteDatabase = ((Cursor)localObject).getColumnNames();
          StringBuilder localStringBuilder = new StringBuilder(1024);
          localStringBuilder.append("INSERT").append(CONFLICT_VALUES[paramInt1]).append(" INTO ").append(paramString).append(" (");
          i = paramSQLiteDatabase.length;
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            localStringBuilder.append(paramSQLiteDatabase[paramInt1]).append(',');
            paramInt1 += 1;
            continue;
          }
          localStringBuilder.setCharAt(localStringBuilder.length() - 1, ')');
          localStringBuilder.append(" VALUES (");
          paramInt1 = 0;
          if (paramInt1 < paramSQLiteDatabase.length)
          {
            localStringBuilder.append("?,");
            paramInt1 += 1;
            continue;
          }
          localStringBuilder.setCharAt(localStringBuilder.length() - 1, ')');
          paramString = this.udr.compileStatement(localStringBuilder.toString());
          paramInt1 = 0;
        }
        finally
        {
          int i;
          paramString = null;
          continue;
          i += 1;
          continue;
        }
        try
        {
          this.udr.beginTransaction();
          if (!((Cursor)localObject).moveToNext()) {
            continue;
          }
          if ((paramInt1 % 1024 == 0) && (paramInt2 != 0)) {
            publishProgress(new Integer[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(j) });
          }
          paramString.clearBindings();
          i = 0;
          if (i >= paramSQLiteDatabase.length) {
            continue;
          }
          switch (((Cursor)localObject).getType(i))
          {
          case 0: 
            paramString.bindNull(i + 1);
            continue;
          }
        }
        finally {}
        if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
          ((Cursor)localObject).close();
        }
        if (this.udr.inTransaction()) {
          this.udr.endTransaction();
        }
        if (paramString != null) {
          paramString.close();
        }
        AppMethodBeat.o(23129);
        throw paramSQLiteDatabase;
        paramString.bindLong(i + 1, ((Cursor)localObject).getLong(i));
        continue;
        paramString.bindDouble(i + 1, ((Cursor)localObject).getDouble(i));
        continue;
        paramString.bindString(i + 1, ((Cursor)localObject).getString(i));
        continue;
        paramString.bindBlob(i + 1, ((Cursor)localObject).getBlob(i));
        continue;
        if ((parame == null) || (parame.a((Cursor)localObject, paramString)))
        {
          paramString.executeInsert(this.mCancellationSignal);
          paramInt1 += 1;
        }
      }
      this.udr.setTransactionSuccessful();
      if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
        ((Cursor)localObject).close();
      }
      if (this.udr.inTransaction()) {
        this.udr.endTransaction();
      }
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(23129);
      return paramInt1;
    }
    finally
    {
      for (;;)
      {
        paramString = null;
        Object localObject = null;
      }
    }
  }
  
  /* Error */
  private static List<c> a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 337
    //   6: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   13: new 215	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 339
    //   20: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 344
    //   30: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 347	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   41: astore 5
    //   43: aload 5
    //   45: invokeinterface 350 1 0
    //   50: istore_2
    //   51: iload_2
    //   52: ifne +23 -> 75
    //   55: aload 5
    //   57: ifnull +10 -> 67
    //   60: aload 5
    //   62: invokeinterface 278 1 0
    //   67: ldc_w 337
    //   70: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: new 352	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 353	java/util/ArrayList:<init>	()V
    //   82: astore_0
    //   83: aload 5
    //   85: iconst_1
    //   86: invokeinterface 299 2 0
    //   91: astore_1
    //   92: aload 5
    //   94: iconst_2
    //   95: invokeinterface 299 2 0
    //   100: astore 6
    //   102: aload 5
    //   104: iconst_3
    //   105: invokeinterface 356 2 0
    //   110: ifeq +79 -> 189
    //   113: iconst_1
    //   114: istore_2
    //   115: aload 5
    //   117: iconst_4
    //   118: invokeinterface 299 2 0
    //   123: astore 7
    //   125: aload 5
    //   127: iconst_5
    //   128: invokeinterface 356 2 0
    //   133: ifeq +61 -> 194
    //   136: iconst_1
    //   137: istore_3
    //   138: aload_0
    //   139: new 25	com/tencent/mm/plugin/dbbackup/a/a$c
    //   142: dup
    //   143: aload_1
    //   144: aload 6
    //   146: iload_2
    //   147: aload 7
    //   149: iload_3
    //   150: invokespecial 359	com/tencent/mm/plugin/dbbackup/a/a$c:<init>	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V
    //   153: invokevirtual 363	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   156: pop
    //   157: aload 5
    //   159: invokeinterface 256 1 0
    //   164: istore_2
    //   165: iload_2
    //   166: ifne -83 -> 83
    //   169: aload 5
    //   171: ifnull +10 -> 181
    //   174: aload 5
    //   176: invokeinterface 278 1 0
    //   181: ldc_w 337
    //   184: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_0
    //   188: areturn
    //   189: iconst_0
    //   190: istore_2
    //   191: goto -76 -> 115
    //   194: iconst_0
    //   195: istore_3
    //   196: goto -58 -> 138
    //   199: astore_1
    //   200: ldc_w 337
    //   203: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: astore_0
    //   209: aload 5
    //   211: ifnull +14 -> 225
    //   214: aload_1
    //   215: ifnull +29 -> 244
    //   218: aload 5
    //   220: invokeinterface 278 1 0
    //   225: ldc_w 337
    //   228: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_0
    //   232: athrow
    //   233: astore 4
    //   235: aload_1
    //   236: aload 4
    //   238: invokevirtual 367	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   241: goto -16 -> 225
    //   244: aload 5
    //   246: invokeinterface 278 1 0
    //   251: goto -26 -> 225
    //   254: astore_0
    //   255: aload 4
    //   257: astore_1
    //   258: goto -49 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	261	1	paramString	String
    //   50	141	2	bool1	boolean
    //   137	59	3	bool2	boolean
    //   1	1	4	localObject	Object
    //   233	23	4	localThrowable	Throwable
    //   41	204	5	localCursor	com.tencent.wcdb.Cursor
    //   100	45	6	str1	String
    //   123	25	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   43	51	199	java/lang/Throwable
    //   75	83	199	java/lang/Throwable
    //   83	113	199	java/lang/Throwable
    //   115	136	199	java/lang/Throwable
    //   138	165	199	java/lang/Throwable
    //   200	208	208	finally
    //   218	225	233	java/lang/Throwable
    //   43	51	254	finally
    //   75	83	254	finally
    //   83	113	254	finally
    //   115	136	254	finally
    //   138	165	254	finally
  }
  
  /* Error */
  private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 372
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   9: astore 4
    //   11: iload_2
    //   12: invokestatic 374	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   15: astore 5
    //   17: aload_0
    //   18: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   21: astore 6
    //   23: aload_1
    //   24: aload 4
    //   26: ldc_w 376
    //   29: iconst_1
    //   30: anewarray 91	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: aload 5
    //   37: aastore
    //   38: ldc_w 378
    //   41: aload 6
    //   43: invokevirtual 207	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;Lcom/tencent/wcdb/support/CancellationSignal;)Lcom/tencent/wcdb/Cursor;
    //   46: astore 5
    //   48: aconst_null
    //   49: astore 4
    //   51: aload 5
    //   53: invokeinterface 350 1 0
    //   58: ifeq +74 -> 132
    //   61: aload 5
    //   63: iconst_0
    //   64: invokeinterface 356 2 0
    //   69: istore_2
    //   70: aload 5
    //   72: iconst_1
    //   73: invokeinterface 356 2 0
    //   78: istore_3
    //   79: aload 5
    //   81: iconst_2
    //   82: invokeinterface 299 2 0
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   92: astore 6
    //   94: aload_0
    //   95: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   98: astore 7
    //   100: aload 6
    //   102: ldc_w 380
    //   105: iconst_3
    //   106: anewarray 142	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: iload_2
    //   112: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: iload_3
    //   119: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: aastore
    //   123: dup
    //   124: iconst_2
    //   125: aload_1
    //   126: aastore
    //   127: aload 7
    //   129: invokevirtual 169	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   132: aload 5
    //   134: ifnull +76 -> 210
    //   137: aload 5
    //   139: invokeinterface 278 1 0
    //   144: ldc_w 372
    //   147: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore 4
    //   153: ldc_w 372
    //   156: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload 4
    //   161: athrow
    //   162: astore_1
    //   163: aload 5
    //   165: ifnull +15 -> 180
    //   168: aload 4
    //   170: ifnull +30 -> 200
    //   173: aload 5
    //   175: invokeinterface 278 1 0
    //   180: ldc_w 372
    //   183: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_1
    //   187: athrow
    //   188: astore 5
    //   190: aload 4
    //   192: aload 5
    //   194: invokevirtual 367	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   197: goto -17 -> 180
    //   200: aload 5
    //   202: invokeinterface 278 1 0
    //   207: goto -27 -> 180
    //   210: ldc_w 372
    //   213: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: return
    //   217: astore_1
    //   218: goto -55 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	a
    //   0	221	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	221	2	paramInt	int
    //   78	41	3	i	int
    //   9	41	4	localCursorFactory	com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
    //   151	40	4	localThrowable1	Throwable
    //   15	159	5	localObject1	Object
    //   188	13	5	localThrowable2	Throwable
    //   21	80	6	localObject2	Object
    //   98	30	7	localCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   51	132	151	java/lang/Throwable
    //   153	162	162	finally
    //   173	180	188	java/lang/Throwable
    //   51	132	217	finally
  }
  
  private static long asM(String paramString)
  {
    AppMethodBeat.i(23130);
    q localq = new q(paramString);
    paramString = localq;
    if (!localq.isDirectory()) {
      paramString = localq.ifB();
    }
    do
    {
      long l = paramString.ifN();
      if (l > 0L)
      {
        AppMethodBeat.o(23130);
        return l;
      }
      localq = paramString.ifB();
      paramString = localq;
    } while (localq != null);
    AppMethodBeat.o(23130);
    return 0L;
  }
  
  private int b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(220082);
    paramSQLiteDatabase = a(paramSQLiteDatabase, paramString);
    Object localObject = a(this.udr, paramString);
    if (paramSQLiteDatabase == null)
    {
      Log.e("MicroMsg.DBRecoveryTask", "ALTER TABLE detection for '%s' failed because no such table in source DB.");
      AppMethodBeat.o(220082);
      return -1;
    }
    if (localObject == null)
    {
      Log.e("MicroMsg.DBRecoveryTask", "ALTER TABLE detection for '%s' failed because no such table in target DB.");
      AppMethodBeat.o(220082);
      return -1;
    }
    if (((List)localObject).size() < paramSQLiteDatabase.size()) {
      try
      {
        this.udr.beginTransaction();
        StringBuilder localStringBuilder = new StringBuilder();
        int i = ((List)localObject).size();
        while (i < paramSQLiteDatabase.size())
        {
          localObject = (c)paramSQLiteDatabase.get(i);
          localStringBuilder.setLength(0);
          localStringBuilder.append("ALTER TABLE ").append(paramString).append(" ADD COLUMN ").append(((c)localObject).name).append(' ').append(((c)localObject).type);
          if (((c)localObject).udY) {
            localStringBuilder.append(" NOT NULL");
          }
          if ((((c)localObject).rAi != null) && (!((c)localObject).rAi.isEmpty())) {
            localStringBuilder.append(" DEFAULT (").append(((c)localObject).rAi).append(')');
          }
          localStringBuilder.append(';');
          localObject = localStringBuilder.toString();
          this.udr.execSQL((String)localObject, null, this.mCancellationSignal);
          Log.i("MicroMsg.DBRecoveryTask", ">>> ".concat(String.valueOf(localObject)));
          j += 1;
          i += 1;
        }
        this.udr.setTransactionSuccessful();
        return j;
      }
      finally
      {
        if (this.udr.inTransaction()) {
          this.udr.endTransaction();
        }
        AppMethodBeat.o(220082);
      }
    }
    AppMethodBeat.o(220082);
    return 0;
  }
  
  @SuppressLint({"DefaultLocale"})
  private static void c(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(23132);
    f.Iyx.e("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[] { Integer.valueOf(paramInt), paramString, "\n" + Util.stackTraceToString(paramThrowable) }), null);
    AppMethodBeat.o(23132);
  }
  
  private int cPG()
  {
    long l2 = 0L;
    AppMethodBeat.i(23123);
    Log.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
    if ((this.uds == null) || (this.uds.isEmpty()))
    {
      AppMethodBeat.o(23123);
      return -1;
    }
    this.udF = false;
    this.udG = 300000;
    if (this.udv != null) {}
    long l1;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(u.bBS(this.udv));
        this.udG = localJSONObject.getInt("message");
        this.udF = true;
        l1 = localJSONObject.getLong("dbSize");
        if (this.udu != null) {
          l2 = u.bBQ(this.udu);
        }
        this.udH = Math.max(l1, l2);
        this.udH += Math.max(this.udH / 10L, 67108864L);
        this.udI = asM(this.uds);
        if (this.udH <= this.udI) {
          break;
        }
        Log.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[] { Long.valueOf(this.udH), Long.valueOf(this.udI) });
        AppMethodBeat.o(23123);
        return -2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.udv);
        l1 = 0L;
        continue;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.DBRecoveryTask", localException, "Cannot read statistics from file.", new Object[0]);
      }
      l1 = 0L;
    }
    Log.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d, corrupted db size: %d, latest statistic db size: %d", new Object[] { Long.valueOf(this.udH), Long.valueOf(this.udI), Integer.valueOf(this.udG), Long.valueOf(l2), Long.valueOf(l1) });
    AppMethodBeat.o(23123);
    return 0;
  }
  
  private int cPH()
  {
    AppMethodBeat.i(23124);
    if (this.udr != null)
    {
      if (this.udr.isOpen()) {
        this.udr.close();
      }
      this.udr = null;
    }
    this.mCancellationSignal.throwIfCanceled();
    String str = this.uds + '-' + Util.getRandomString(6);
    Log.i("MicroMsg.DBRecoveryTask", "Open target database: ".concat(String.valueOf(str)));
    try
    {
      this.udr = SQLiteDatabase.openOrCreateDatabase(str, this.udy, udq, null, null, 1);
      DatabaseUtils.stringForQuery(this.udr, "PRAGMA journal_mode=OFF;", null);
      this.udr.execSQL("PRAGMA synchronous=OFF;");
      AppMethodBeat.o(23124);
      return 0;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", new Object[] { str, localException.getMessage() });
      c(1, "Cannot open target database", localException);
      AppMethodBeat.o(23124);
      throw localException;
    }
  }
  
  /* Error */
  private int cPI()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore_2
    //   8: sipush 23126
    //   11: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_0
    //   15: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   18: invokevirtual 563	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   21: iconst_5
    //   22: anewarray 91	java/lang/String
    //   25: astore 6
    //   27: aload 6
    //   29: iconst_0
    //   30: ldc_w 512
    //   33: aastore
    //   34: aload 6
    //   36: iconst_1
    //   37: ldc_w 594
    //   40: aastore
    //   41: aload 6
    //   43: iconst_2
    //   44: ldc_w 596
    //   47: aastore
    //   48: aload 6
    //   50: iconst_3
    //   51: ldc_w 598
    //   54: aastore
    //   55: aload 6
    //   57: iconst_4
    //   58: ldc_w 600
    //   61: aastore
    //   62: aload_0
    //   63: getfield 333	com/tencent/mm/plugin/dbbackup/a/a:udw	Ljava/util/List;
    //   66: invokeinterface 604 1 0
    //   71: astore 9
    //   73: aconst_null
    //   74: astore 4
    //   76: aload 9
    //   78: invokeinterface 609 1 0
    //   83: ifeq +888 -> 971
    //   86: aload 9
    //   88: invokeinterface 613 1 0
    //   93: checkcast 91	java/lang/String
    //   96: astore 10
    //   98: aload 10
    //   100: invokestatic 617	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   103: ifne +22 -> 125
    //   106: ldc 138
    //   108: ldc_w 619
    //   111: aload 10
    //   113: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -46 -> 76
    //   125: iconst_0
    //   126: istore_1
    //   127: aload 4
    //   129: astore 5
    //   131: aload 5
    //   133: astore 4
    //   135: iload_1
    //   136: aload_0
    //   137: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:udA	Ljava/util/List;
    //   140: invokeinterface 417 1 0
    //   145: if_icmpge -69 -> 76
    //   148: aload_0
    //   149: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:udA	Ljava/util/List;
    //   152: iload_1
    //   153: invokeinterface 422 2 0
    //   158: checkcast 620	[B
    //   161: astore 11
    //   163: aload 5
    //   165: astore 4
    //   167: aload 10
    //   169: iconst_0
    //   170: invokestatic 626	com/tencent/mm/b/q:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   173: aload 11
    //   175: aload 6
    //   177: invokestatic 632	com/tencent/wcdb/repair/RepairKit$MasterInfo:load	(Ljava/lang/String;[B[Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   180: astore 5
    //   182: aload 5
    //   184: astore 4
    //   186: ldc 138
    //   188: new 215	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 634
    //   195: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload 10
    //   200: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 636
    //   206: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload_1
    //   210: invokevirtual 639	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 5
    //   221: astore 4
    //   223: aload 4
    //   225: ifnonnull +403 -> 628
    //   228: aload 6
    //   230: invokestatic 643	com/tencent/wcdb/repair/RepairKit$MasterInfo:make	([Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   233: astore 6
    //   235: ldc 138
    //   237: ldc_w 645
    //   240: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: iconst_0
    //   244: istore_3
    //   245: iconst_1
    //   246: newarray int
    //   248: astore 9
    //   250: aload 9
    //   252: iconst_0
    //   253: iconst_0
    //   254: iastore
    //   255: aload 8
    //   257: astore 5
    //   259: ldc 138
    //   261: new 215	java/lang/StringBuilder
    //   264: dup
    //   265: ldc_w 650
    //   268: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield 458	com/tencent/mm/plugin/dbbackup/a/a:udu	Ljava/lang/String;
    //   275: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: iload_2
    //   285: istore_1
    //   286: aload 7
    //   288: astore 4
    //   290: aload 8
    //   292: astore 5
    //   294: iload_1
    //   295: aload_0
    //   296: getfield 652	com/tencent/mm/plugin/dbbackup/a/a:udB	Ljava/util/List;
    //   299: invokeinterface 417 1 0
    //   304: if_icmpge +69 -> 373
    //   307: aload 8
    //   309: astore 5
    //   311: aload_0
    //   312: getfield 652	com/tencent/mm/plugin/dbbackup/a/a:udB	Ljava/util/List;
    //   315: iload_1
    //   316: invokeinterface 422 2 0
    //   321: checkcast 620	[B
    //   324: astore 4
    //   326: aload 8
    //   328: astore 5
    //   330: new 654	com/tencent/wcdb/repair/RepairKit
    //   333: dup
    //   334: aload_0
    //   335: getfield 458	com/tencent/mm/plugin/dbbackup/a/a:udu	Ljava/lang/String;
    //   338: aload 4
    //   340: getstatic 89	com/tencent/mm/plugin/dbbackup/a/a:udq	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   343: aload 6
    //   345: invokespecial 657	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   348: astore 4
    //   350: aload 4
    //   352: invokevirtual 660	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   355: ifne +290 -> 645
    //   358: ldc 138
    //   360: ldc_w 662
    //   363: iload_1
    //   364: invokestatic 664	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   367: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 4
    //   375: ifnonnull +593 -> 968
    //   378: aload 4
    //   380: astore 5
    //   382: ldc 138
    //   384: ldc_w 666
    //   387: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload 4
    //   392: astore 5
    //   394: new 654	com/tencent/wcdb/repair/RepairKit
    //   397: dup
    //   398: aload_0
    //   399: getfield 458	com/tencent/mm/plugin/dbbackup/a/a:udu	Ljava/lang/String;
    //   402: aload_0
    //   403: getfield 652	com/tencent/mm/plugin/dbbackup/a/a:udB	Ljava/util/List;
    //   406: iconst_0
    //   407: invokeinterface 422 2 0
    //   412: checkcast 620	[B
    //   415: getstatic 89	com/tencent/mm/plugin/dbbackup/a/a:udq	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   418: aload 6
    //   420: invokespecial 657	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   423: astore 6
    //   425: aload 6
    //   427: astore 4
    //   429: aload 4
    //   431: astore 6
    //   433: aload 4
    //   435: new 7	com/tencent/mm/plugin/dbbackup/a/a$1
    //   438: dup
    //   439: aload_0
    //   440: aload 9
    //   442: invokespecial 669	com/tencent/mm/plugin/dbbackup/a/a$1:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;[I)V
    //   445: invokevirtual 673	com/tencent/wcdb/repair/RepairKit:setCallback	(Lcom/tencent/wcdb/repair/RepairKit$Callback;)V
    //   448: aload 4
    //   450: astore 6
    //   452: aload 4
    //   454: aload_0
    //   455: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   458: iconst_0
    //   459: aload_0
    //   460: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   463: invokevirtual 677	com/tencent/wcdb/repair/RepairKit:output	(Lcom/tencent/wcdb/database/SQLiteDatabase;ILcom/tencent/wcdb/support/CancellationSignal;)I
    //   466: istore_1
    //   467: iload_1
    //   468: ifne +291 -> 759
    //   471: aload 4
    //   473: astore 6
    //   475: aload 4
    //   477: invokevirtual 660	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   480: ifeq +187 -> 667
    //   483: aload 4
    //   485: astore 6
    //   487: aload 4
    //   489: invokevirtual 680	com/tencent/wcdb/repair/RepairKit:isDataCorrupted	()Z
    //   492: ifeq +175 -> 667
    //   495: aload 4
    //   497: astore 6
    //   499: new 592	java/lang/RuntimeException
    //   502: dup
    //   503: ldc_w 682
    //   506: invokespecial 683	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   509: astore 5
    //   511: aload 4
    //   513: astore 6
    //   515: sipush 23126
    //   518: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: aload 4
    //   523: astore 6
    //   525: aload 5
    //   527: athrow
    //   528: astore 6
    //   530: sipush 23126
    //   533: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   536: aload 6
    //   538: athrow
    //   539: astore 6
    //   541: aload 4
    //   543: astore 5
    //   545: aload 6
    //   547: astore 4
    //   549: aload 5
    //   551: ifnull +8 -> 559
    //   554: aload 5
    //   556: invokevirtual 686	com/tencent/wcdb/repair/RepairKit:release	()V
    //   559: sipush 23126
    //   562: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload 4
    //   567: athrow
    //   568: astore 5
    //   570: ldc 138
    //   572: new 215	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 688
    //   579: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 5
    //   584: invokevirtual 583	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   587: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 690
    //   593: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 10
    //   598: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 636
    //   604: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: iload_1
    //   608: invokevirtual 639	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   611: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: iload_1
    //   618: iconst_1
    //   619: iadd
    //   620: istore_1
    //   621: aload 4
    //   623: astore 5
    //   625: goto -494 -> 131
    //   628: ldc 138
    //   630: ldc_w 692
    //   633: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: iconst_1
    //   637: istore_3
    //   638: aload 4
    //   640: astore 6
    //   642: goto -397 -> 245
    //   645: ldc 138
    //   647: ldc_w 694
    //   650: iload_1
    //   651: invokestatic 664	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   654: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: iload_1
    //   661: iconst_1
    //   662: iadd
    //   663: istore_1
    //   664: goto -378 -> 286
    //   667: aload 4
    //   669: astore 6
    //   671: ldc 138
    //   673: ldc_w 696
    //   676: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload 4
    //   681: astore 6
    //   683: aload_0
    //   684: getfield 499	com/tencent/mm/plugin/dbbackup/a/a:udF	Z
    //   687: ifeq +54 -> 741
    //   690: aload 4
    //   692: astore 6
    //   694: aload 9
    //   696: iconst_0
    //   697: iaload
    //   698: i2f
    //   699: aload_0
    //   700: getfield 120	com/tencent/mm/plugin/dbbackup/a/a:udG	I
    //   703: i2f
    //   704: fdiv
    //   705: ldc_w 697
    //   708: fcmpg
    //   709: ifgt +32 -> 741
    //   712: aload 4
    //   714: astore 6
    //   716: getstatic 470	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   719: sipush 181
    //   722: sipush 181
    //   725: bipush 62
    //   727: bipush 63
    //   729: aload_0
    //   730: getfield 120	com/tencent/mm/plugin/dbbackup/a/a:udG	I
    //   733: aload 9
    //   735: iconst_0
    //   736: iaload
    //   737: iconst_1
    //   738: invokevirtual 700	com/tencent/mm/plugin/report/f:a	(IIIIIIZ)V
    //   741: aload 4
    //   743: ifnull +8 -> 751
    //   746: aload 4
    //   748: invokevirtual 686	com/tencent/wcdb/repair/RepairKit:release	()V
    //   751: sipush 23126
    //   754: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   757: iload_1
    //   758: ireturn
    //   759: iload_1
    //   760: iconst_1
    //   761: if_icmpne +99 -> 860
    //   764: aload 4
    //   766: astore 6
    //   768: ldc 138
    //   770: ldc_w 702
    //   773: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   776: aload 4
    //   778: astore 6
    //   780: aload_0
    //   781: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   784: invokevirtual 563	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   787: goto -108 -> 679
    //   790: astore 5
    //   792: aload 4
    //   794: astore 6
    //   796: ldc 138
    //   798: new 215	java/lang/StringBuilder
    //   801: dup
    //   802: ldc_w 704
    //   805: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: aload 5
    //   810: invokevirtual 705	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload 4
    //   824: astore 6
    //   826: iconst_2
    //   827: ldc_w 707
    //   830: iload_3
    //   831: invokestatic 710	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   834: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   837: aload 5
    //   839: invokestatic 587	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   842: aload 4
    //   844: ifnull +8 -> 852
    //   847: aload 4
    //   849: invokevirtual 686	com/tencent/wcdb/repair/RepairKit:release	()V
    //   852: sipush 23126
    //   855: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   858: iconst_m1
    //   859: ireturn
    //   860: aload 4
    //   862: astore 6
    //   864: new 592	java/lang/RuntimeException
    //   867: dup
    //   868: ldc_w 712
    //   871: invokespecial 683	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   874: astore 5
    //   876: aload 4
    //   878: astore 6
    //   880: sipush 23126
    //   883: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   886: aload 4
    //   888: astore 6
    //   890: aload 5
    //   892: athrow
    //   893: astore 4
    //   895: aload 6
    //   897: astore 5
    //   899: goto -350 -> 549
    //   902: astore 4
    //   904: aconst_null
    //   905: astore 5
    //   907: goto -358 -> 549
    //   910: astore 6
    //   912: aload 4
    //   914: astore 5
    //   916: aload 6
    //   918: astore 4
    //   920: goto -371 -> 549
    //   923: astore 6
    //   925: aload 4
    //   927: astore 5
    //   929: aload 6
    //   931: astore 4
    //   933: goto -384 -> 549
    //   936: astore 5
    //   938: aconst_null
    //   939: astore 4
    //   941: goto -149 -> 792
    //   944: astore 5
    //   946: goto -154 -> 792
    //   949: astore 5
    //   951: goto -159 -> 792
    //   954: astore 6
    //   956: aload 5
    //   958: astore 4
    //   960: goto -430 -> 530
    //   963: astore 6
    //   965: goto -435 -> 530
    //   968: goto -539 -> 429
    //   971: goto -748 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	974	0	this	a
    //   126	636	1	i	int
    //   7	278	2	j	int
    //   244	587	3	bool	boolean
    //   74	813	4	localObject1	Object
    //   893	1	4	localObject2	Object
    //   902	11	4	localObject3	Object
    //   918	41	4	localObject4	Object
    //   129	426	5	localObject5	Object
    //   568	15	5	localException	Exception
    //   623	1	5	localObject6	Object
    //   790	48	5	localRuntimeException1	java.lang.RuntimeException
    //   874	54	5	localObject7	Object
    //   936	1	5	localRuntimeException2	java.lang.RuntimeException
    //   944	1	5	localRuntimeException3	java.lang.RuntimeException
    //   949	8	5	localRuntimeException4	java.lang.RuntimeException
    //   25	499	6	localObject8	Object
    //   528	9	6	localOperationCanceledException1	OperationCanceledException
    //   539	7	6	localObject9	Object
    //   640	256	6	localObject10	Object
    //   910	7	6	localObject11	Object
    //   923	7	6	localObject12	Object
    //   954	1	6	localOperationCanceledException2	OperationCanceledException
    //   963	1	6	localOperationCanceledException3	OperationCanceledException
    //   4	283	7	localObject13	Object
    //   1	326	8	localObject14	Object
    //   71	663	9	localObject15	Object
    //   96	501	10	str	String
    //   161	13	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   433	448	528	com/tencent/wcdb/support/OperationCanceledException
    //   452	467	528	com/tencent/wcdb/support/OperationCanceledException
    //   475	483	528	com/tencent/wcdb/support/OperationCanceledException
    //   487	495	528	com/tencent/wcdb/support/OperationCanceledException
    //   499	511	528	com/tencent/wcdb/support/OperationCanceledException
    //   515	521	528	com/tencent/wcdb/support/OperationCanceledException
    //   525	528	528	com/tencent/wcdb/support/OperationCanceledException
    //   671	679	528	com/tencent/wcdb/support/OperationCanceledException
    //   683	690	528	com/tencent/wcdb/support/OperationCanceledException
    //   694	712	528	com/tencent/wcdb/support/OperationCanceledException
    //   716	741	528	com/tencent/wcdb/support/OperationCanceledException
    //   768	776	528	com/tencent/wcdb/support/OperationCanceledException
    //   780	787	528	com/tencent/wcdb/support/OperationCanceledException
    //   864	876	528	com/tencent/wcdb/support/OperationCanceledException
    //   880	886	528	com/tencent/wcdb/support/OperationCanceledException
    //   890	893	528	com/tencent/wcdb/support/OperationCanceledException
    //   530	539	539	finally
    //   167	182	568	java/lang/Exception
    //   186	219	568	java/lang/Exception
    //   433	448	790	java/lang/RuntimeException
    //   452	467	790	java/lang/RuntimeException
    //   475	483	790	java/lang/RuntimeException
    //   487	495	790	java/lang/RuntimeException
    //   499	511	790	java/lang/RuntimeException
    //   515	521	790	java/lang/RuntimeException
    //   525	528	790	java/lang/RuntimeException
    //   671	679	790	java/lang/RuntimeException
    //   683	690	790	java/lang/RuntimeException
    //   694	712	790	java/lang/RuntimeException
    //   716	741	790	java/lang/RuntimeException
    //   768	776	790	java/lang/RuntimeException
    //   780	787	790	java/lang/RuntimeException
    //   864	876	790	java/lang/RuntimeException
    //   880	886	790	java/lang/RuntimeException
    //   890	893	790	java/lang/RuntimeException
    //   433	448	893	finally
    //   452	467	893	finally
    //   475	483	893	finally
    //   487	495	893	finally
    //   499	511	893	finally
    //   515	521	893	finally
    //   525	528	893	finally
    //   671	679	893	finally
    //   683	690	893	finally
    //   694	712	893	finally
    //   716	741	893	finally
    //   768	776	893	finally
    //   780	787	893	finally
    //   796	822	893	finally
    //   826	842	893	finally
    //   864	876	893	finally
    //   880	886	893	finally
    //   890	893	893	finally
    //   259	284	902	finally
    //   294	307	902	finally
    //   311	326	902	finally
    //   330	350	902	finally
    //   350	373	910	finally
    //   645	660	910	finally
    //   382	390	923	finally
    //   394	425	923	finally
    //   259	284	936	java/lang/RuntimeException
    //   294	307	936	java/lang/RuntimeException
    //   311	326	936	java/lang/RuntimeException
    //   330	350	936	java/lang/RuntimeException
    //   350	373	944	java/lang/RuntimeException
    //   645	660	944	java/lang/RuntimeException
    //   382	390	949	java/lang/RuntimeException
    //   394	425	949	java/lang/RuntimeException
    //   259	284	954	com/tencent/wcdb/support/OperationCanceledException
    //   294	307	954	com/tencent/wcdb/support/OperationCanceledException
    //   311	326	954	com/tencent/wcdb/support/OperationCanceledException
    //   330	350	954	com/tencent/wcdb/support/OperationCanceledException
    //   382	390	954	com/tencent/wcdb/support/OperationCanceledException
    //   394	425	954	com/tencent/wcdb/support/OperationCanceledException
    //   350	373	963	com/tencent/wcdb/support/OperationCanceledException
    //   645	660	963	com/tencent/wcdb/support/OperationCanceledException
  }
  
  /* Error */
  private int cPJ()
  {
    // Byte code:
    //   0: sipush 23127
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   10: invokevirtual 563	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   13: ldc 138
    //   15: ldc_w 715
    //   18: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 454	com/tencent/mm/plugin/dbbackup/a/a:udx	Ljava/util/List;
    //   25: invokeinterface 604 1 0
    //   30: astore 5
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 5
    //   36: invokeinterface 609 1 0
    //   41: ifeq +98 -> 139
    //   44: aload 5
    //   46: invokeinterface 613 1 0
    //   51: checkcast 91	java/lang/String
    //   54: astore 4
    //   56: new 717	com/tencent/wcdb/repair/RecoverKit
    //   59: dup
    //   60: aload_0
    //   61: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: aload 4
    //   66: aload_0
    //   67: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:udA	Ljava/util/List;
    //   70: iconst_0
    //   71: invokeinterface 422 2 0
    //   76: checkcast 620	[B
    //   79: invokespecial 720	com/tencent/wcdb/repair/RecoverKit:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[B)V
    //   82: astore_3
    //   83: ldc 138
    //   85: ldc_w 722
    //   88: aload 4
    //   90: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   96: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_3
    //   100: astore_2
    //   101: goto -67 -> 34
    //   104: astore 4
    //   106: aload_3
    //   107: astore_2
    //   108: aload 4
    //   110: astore_3
    //   111: ldc 138
    //   113: new 215	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 724
    //   120: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_3
    //   124: invokevirtual 583	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -102 -> 34
    //   139: aload_2
    //   140: ifnonnull +11 -> 151
    //   143: sipush 23127
    //   146: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_m1
    //   150: ireturn
    //   151: aload_2
    //   152: iconst_0
    //   153: aload_0
    //   154: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   157: invokevirtual 728	com/tencent/wcdb/repair/RecoverKit:run	(ZLcom/tencent/wcdb/support/CancellationSignal;)I
    //   160: istore_1
    //   161: iload_1
    //   162: ifne +23 -> 185
    //   165: ldc 138
    //   167: ldc_w 730
    //   170: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_2
    //   174: invokevirtual 731	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   177: sipush 23127
    //   180: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iload_1
    //   184: ireturn
    //   185: iload_1
    //   186: iconst_1
    //   187: if_icmpne +43 -> 230
    //   190: ldc 138
    //   192: ldc_w 733
    //   195: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   202: invokevirtual 563	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   205: goto -32 -> 173
    //   208: astore_3
    //   209: sipush 23127
    //   212: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_3
    //   216: athrow
    //   217: astore_3
    //   218: aload_2
    //   219: invokevirtual 731	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   222: sipush 23127
    //   225: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_3
    //   229: athrow
    //   230: ldc 138
    //   232: ldc_w 735
    //   235: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -65 -> 173
    //   241: astore_3
    //   242: ldc 138
    //   244: new 215	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 704
    //   251: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_3
    //   255: invokevirtual 583	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: iconst_4
    //   268: ldc_w 737
    //   271: aload_3
    //   272: invokestatic 587	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload_2
    //   276: invokevirtual 731	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   279: sipush 23127
    //   282: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_m1
    //   286: ireturn
    //   287: astore_3
    //   288: goto -177 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	a
    //   160	28	1	i	int
    //   33	243	2	localObject1	Object
    //   82	42	3	localObject2	Object
    //   208	8	3	localOperationCanceledException	OperationCanceledException
    //   217	12	3	localObject3	Object
    //   241	31	3	localException1	Exception
    //   287	1	3	localException2	Exception
    //   54	35	4	str	String
    //   104	5	4	localException3	Exception
    //   30	15	5	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   83	99	104	java/lang/Exception
    //   151	161	208	com/tencent/wcdb/support/OperationCanceledException
    //   165	173	208	com/tencent/wcdb/support/OperationCanceledException
    //   190	205	208	com/tencent/wcdb/support/OperationCanceledException
    //   230	238	208	com/tencent/wcdb/support/OperationCanceledException
    //   151	161	217	finally
    //   165	173	217	finally
    //   190	205	217	finally
    //   209	217	217	finally
    //   230	238	217	finally
    //   242	275	217	finally
    //   151	161	241	java/lang/Exception
    //   165	173	241	java/lang/Exception
    //   190	205	241	java/lang/Exception
    //   230	238	241	java/lang/Exception
    //   56	83	287	java/lang/Exception
  }
  
  private int cPK()
  {
    AppMethodBeat.i(220028);
    try
    {
      this.udr.execSQL("DELETE FROM rconversation WHERE typeof(flag) <> 'integer';", null, this.mCancellationSignal);
      AppMethodBeat.o(220028);
      return 0;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      AppMethodBeat.o(220028);
      throw localOperationCanceledException;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.DBRecoveryTask", localException, "Verification failed", new Object[0]);
      AppMethodBeat.o(220028);
    }
    return -1;
  }
  
  /* Error */
  private int cPL()
  {
    // Byte code:
    //   0: ldc_w 745
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 452	com/tencent/mm/plugin/dbbackup/a/a:udt	Ljava/lang/String;
    //   10: ifnull +13 -> 23
    //   13: aload_0
    //   14: getfield 452	com/tencent/mm/plugin/dbbackup/a/a:udt	Ljava/lang/String;
    //   17: invokevirtual 135	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc_w 745
    //   26: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: ldc 138
    //   33: ldc_w 747
    //   36: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   43: ldc_w 749
    //   46: aconst_null
    //   47: invokestatic 195	com/tencent/wcdb/DatabaseUtils:longForQuery	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   50: l2i
    //   51: istore_1
    //   52: iconst_1
    //   53: newarray long
    //   55: astore 10
    //   57: aload 10
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: ldc_w 751
    //   67: aconst_null
    //   68: invokestatic 195	com/tencent/wcdb/DatabaseUtils:longForQuery	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   71: lconst_1
    //   72: ladd
    //   73: lastore
    //   74: aload 10
    //   76: iconst_0
    //   77: laload
    //   78: ldc2_w 752
    //   81: lcmp
    //   82: ifle +21 -> 103
    //   85: aload 10
    //   87: iconst_0
    //   88: laload
    //   89: ldc2_w 754
    //   92: lcmp
    //   93: ifgt +10 -> 103
    //   96: aload 10
    //   98: iconst_0
    //   99: ldc2_w 756
    //   102: lastore
    //   103: new 759	java/util/HashMap
    //   106: dup
    //   107: iload_1
    //   108: iload_1
    //   109: iconst_2
    //   110: idiv
    //   111: iadd
    //   112: sipush 10240
    //   115: invokestatic 762	java/lang/Math:max	(II)I
    //   118: invokespecial 763	java/util/HashMap:<init>	(I)V
    //   121: astore 9
    //   123: new 9	com/tencent/mm/plugin/dbbackup/a/a$2
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 766	com/tencent/mm/plugin/dbbackup/a/a$2:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;)V
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 452	com/tencent/mm/plugin/dbbackup/a/a:udt	Ljava/lang/String;
    //   137: aload_0
    //   138: getfield 456	com/tencent/mm/plugin/dbbackup/a/a:udz	[B
    //   141: getstatic 89	com/tencent/mm/plugin/dbbackup/a/a:udq	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   144: aconst_null
    //   145: iconst_1
    //   146: aload 4
    //   148: iconst_1
    //   149: invokestatic 770	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   152: astore 4
    //   154: aload_0
    //   155: aload 4
    //   157: ldc_w 378
    //   160: iconst_0
    //   161: iconst_0
    //   162: iconst_0
    //   163: aconst_null
    //   164: invokespecial 772	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   167: pop
    //   168: aload_0
    //   169: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   172: invokevirtual 253	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   175: iconst_3
    //   176: anewarray 142	java/lang/Object
    //   179: astore 5
    //   181: aload 5
    //   183: iconst_0
    //   184: sipush 8197
    //   187: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: aload 5
    //   193: iconst_1
    //   194: iconst_3
    //   195: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: aload 5
    //   201: iconst_2
    //   202: ldc 93
    //   204: aastore
    //   205: aload_0
    //   206: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   209: ldc_w 380
    //   212: aload 5
    //   214: invokevirtual 775	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aload 5
    //   219: iconst_0
    //   220: bipush 15
    //   222: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload 5
    //   228: iconst_1
    //   229: iconst_1
    //   230: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: aastore
    //   234: aload 5
    //   236: iconst_2
    //   237: ldc_w 777
    //   240: aastore
    //   241: aload_0
    //   242: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   245: ldc_w 380
    //   248: aload 5
    //   250: invokevirtual 775	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: aload 5
    //   255: iconst_0
    //   256: bipush 89
    //   258: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: aastore
    //   262: aload 5
    //   264: iconst_1
    //   265: iconst_1
    //   266: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: aload 5
    //   272: iconst_2
    //   273: ldc_w 779
    //   276: aastore
    //   277: aload_0
    //   278: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   281: ldc_w 380
    //   284: aload 5
    //   286: invokevirtual 775	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload_0
    //   290: aload 4
    //   292: iconst_2
    //   293: invokespecial 781	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   296: aload_0
    //   297: aload 4
    //   299: bipush 9
    //   301: invokespecial 781	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   304: aload_0
    //   305: aload 4
    //   307: bipush 42
    //   309: invokespecial 781	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   312: aload_0
    //   313: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   316: invokevirtual 321	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   319: aload_0
    //   320: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   323: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   326: aload 4
    //   328: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   331: ldc_w 783
    //   334: aconst_null
    //   335: ldc_w 512
    //   338: invokevirtual 347	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   341: astore 8
    //   343: aload 8
    //   345: astore 5
    //   347: aload 8
    //   349: astore 6
    //   351: aload 8
    //   353: astore 7
    //   355: aload 8
    //   357: ldc_w 785
    //   360: invokeinterface 788 2 0
    //   365: istore_1
    //   366: aload 8
    //   368: astore 5
    //   370: aload 8
    //   372: astore 6
    //   374: aload 8
    //   376: astore 7
    //   378: aload 8
    //   380: invokeinterface 278 1 0
    //   385: aload 8
    //   387: astore 5
    //   389: aload 8
    //   391: astore 6
    //   393: aload 8
    //   395: astore 7
    //   397: aload_0
    //   398: aload 4
    //   400: ldc_w 512
    //   403: iconst_4
    //   404: iconst_1
    //   405: iconst_5
    //   406: new 11	com/tencent/mm/plugin/dbbackup/a/a$3
    //   409: dup
    //   410: aload_0
    //   411: iload_1
    //   412: aload 10
    //   414: aload 9
    //   416: invokespecial 791	com/tencent/mm/plugin/dbbackup/a/a$3:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;I[JLjava/util/HashMap;)V
    //   419: invokespecial 772	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   422: pop
    //   423: aload 8
    //   425: astore 5
    //   427: aload 8
    //   429: astore 6
    //   431: aload 8
    //   433: astore 7
    //   435: aload_0
    //   436: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   439: ldc_w 793
    //   442: aconst_null
    //   443: aload_0
    //   444: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   447: invokevirtual 169	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   450: aload 8
    //   452: astore 5
    //   454: aload 8
    //   456: astore 6
    //   458: aload 8
    //   460: astore 7
    //   462: aload 4
    //   464: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   467: ldc_w 795
    //   470: aconst_null
    //   471: ldc_w 600
    //   474: invokevirtual 347	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   477: astore 8
    //   479: aload 8
    //   481: astore 5
    //   483: aload 4
    //   485: astore 8
    //   487: aload 5
    //   489: astore 7
    //   491: aload 5
    //   493: ldc_w 797
    //   496: invokeinterface 788 2 0
    //   501: istore_1
    //   502: aload 4
    //   504: astore 8
    //   506: aload 5
    //   508: astore 7
    //   510: aload 5
    //   512: ldc_w 799
    //   515: invokeinterface 788 2 0
    //   520: istore_2
    //   521: aload 4
    //   523: astore 8
    //   525: aload 5
    //   527: astore 7
    //   529: aload 5
    //   531: ldc_w 801
    //   534: invokeinterface 788 2 0
    //   539: istore_3
    //   540: aload 4
    //   542: astore 8
    //   544: aload 5
    //   546: astore 7
    //   548: iconst_1
    //   549: anewarray 91	java/lang/String
    //   552: astore 6
    //   554: aload 4
    //   556: astore 8
    //   558: aload 5
    //   560: astore 7
    //   562: aload 5
    //   564: invokeinterface 278 1 0
    //   569: aload 4
    //   571: astore 8
    //   573: aload 5
    //   575: astore 7
    //   577: aload_0
    //   578: aload 4
    //   580: ldc_w 600
    //   583: iconst_5
    //   584: iconst_1
    //   585: iconst_0
    //   586: new 13	com/tencent/mm/plugin/dbbackup/a/a$4
    //   589: dup
    //   590: aload_0
    //   591: iload_3
    //   592: aload 6
    //   594: iload_1
    //   595: iload_2
    //   596: invokespecial 804	com/tencent/mm/plugin/dbbackup/a/a$4:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;I[Ljava/lang/String;II)V
    //   599: invokespecial 772	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   602: pop
    //   603: aload 4
    //   605: astore 8
    //   607: aload 5
    //   609: astore 7
    //   611: aload 4
    //   613: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   616: ldc_w 806
    //   619: aconst_null
    //   620: ldc_w 594
    //   623: invokevirtual 347	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   626: astore 6
    //   628: aload 6
    //   630: astore 8
    //   632: aload 8
    //   634: astore 5
    //   636: aload 8
    //   638: astore 6
    //   640: aload 8
    //   642: astore 7
    //   644: aload 8
    //   646: ldc_w 808
    //   649: invokeinterface 788 2 0
    //   654: istore_1
    //   655: aload 8
    //   657: astore 5
    //   659: aload 8
    //   661: astore 6
    //   663: aload 8
    //   665: astore 7
    //   667: aload 8
    //   669: invokeinterface 278 1 0
    //   674: aload 8
    //   676: astore 5
    //   678: aload 8
    //   680: astore 6
    //   682: aload 8
    //   684: astore 7
    //   686: aload_0
    //   687: aload 4
    //   689: ldc_w 594
    //   692: iconst_4
    //   693: iconst_1
    //   694: iconst_0
    //   695: new 15	com/tencent/mm/plugin/dbbackup/a/a$5
    //   698: dup
    //   699: aload_0
    //   700: iload_1
    //   701: aload 9
    //   703: invokespecial 811	com/tencent/mm/plugin/dbbackup/a/a$5:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   706: invokespecial 772	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   709: pop
    //   710: aload 8
    //   712: astore 5
    //   714: aload 8
    //   716: astore 6
    //   718: aload 8
    //   720: astore 7
    //   722: aload 4
    //   724: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   727: ldc_w 813
    //   730: aconst_null
    //   731: ldc_w 596
    //   734: invokevirtual 347	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   737: astore 8
    //   739: aload 8
    //   741: astore 5
    //   743: aload 8
    //   745: astore 6
    //   747: aload 8
    //   749: astore 7
    //   751: aload 8
    //   753: ldc_w 808
    //   756: invokeinterface 788 2 0
    //   761: istore_1
    //   762: aload 8
    //   764: astore 5
    //   766: aload 8
    //   768: astore 6
    //   770: aload 8
    //   772: astore 7
    //   774: aload 8
    //   776: invokeinterface 278 1 0
    //   781: aload 8
    //   783: astore 5
    //   785: aload 8
    //   787: astore 6
    //   789: aload 8
    //   791: astore 7
    //   793: aload_0
    //   794: aload 4
    //   796: ldc_w 596
    //   799: iconst_4
    //   800: iconst_1
    //   801: iconst_0
    //   802: new 17	com/tencent/mm/plugin/dbbackup/a/a$6
    //   805: dup
    //   806: aload_0
    //   807: iload_1
    //   808: aload 9
    //   810: invokespecial 814	com/tencent/mm/plugin/dbbackup/a/a$6:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   813: invokespecial 772	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   816: pop
    //   817: aload 8
    //   819: ifnull +20 -> 839
    //   822: aload 8
    //   824: invokeinterface 275 1 0
    //   829: ifne +10 -> 839
    //   832: aload 8
    //   834: invokeinterface 278 1 0
    //   839: aload_0
    //   840: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   843: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   846: ifeq +10 -> 856
    //   849: aload_0
    //   850: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   853: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   856: aload 4
    //   858: ifnull +8 -> 866
    //   861: aload 4
    //   863: invokevirtual 560	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   866: ldc_w 745
    //   869: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: iconst_0
    //   873: ireturn
    //   874: astore 5
    //   876: aconst_null
    //   877: astore 4
    //   879: aconst_null
    //   880: astore 6
    //   882: ldc 138
    //   884: ldc_w 816
    //   887: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   890: ldc_w 745
    //   893: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   896: aload 5
    //   898: athrow
    //   899: astore 5
    //   901: aload 4
    //   903: ifnull +20 -> 923
    //   906: aload 4
    //   908: invokeinterface 275 1 0
    //   913: ifne +10 -> 923
    //   916: aload 4
    //   918: invokeinterface 278 1 0
    //   923: aload_0
    //   924: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   927: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   930: ifeq +10 -> 940
    //   933: aload_0
    //   934: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   937: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   940: aload 6
    //   942: ifnull +8 -> 950
    //   945: aload 6
    //   947: invokevirtual 560	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   950: ldc_w 745
    //   953: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   956: aload 5
    //   958: athrow
    //   959: astore 6
    //   961: aconst_null
    //   962: astore 4
    //   964: aconst_null
    //   965: astore 9
    //   967: aload 9
    //   969: astore 8
    //   971: aload 4
    //   973: astore 7
    //   975: ldc 138
    //   977: new 215	java/lang/StringBuilder
    //   980: dup
    //   981: ldc_w 818
    //   984: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   987: aload 6
    //   989: invokevirtual 583	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   992: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1001: aload 9
    //   1003: astore 8
    //   1005: aload 4
    //   1007: astore 7
    //   1009: iconst_5
    //   1010: new 215	java/lang/StringBuilder
    //   1013: dup
    //   1014: ldc_w 820
    //   1017: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1020: aload_0
    //   1021: getfield 383	com/tencent/mm/plugin/dbbackup/a/a:udD	Z
    //   1024: invokevirtual 823	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: aload 6
    //   1032: invokestatic 587	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1035: aload 4
    //   1037: ifnull +20 -> 1057
    //   1040: aload 4
    //   1042: invokeinterface 275 1 0
    //   1047: ifne +10 -> 1057
    //   1050: aload 4
    //   1052: invokeinterface 278 1 0
    //   1057: aload_0
    //   1058: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1061: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1064: ifeq +10 -> 1074
    //   1067: aload_0
    //   1068: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:udr	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1071: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1074: aload 9
    //   1076: ifnull +8 -> 1084
    //   1079: aload 9
    //   1081: invokevirtual 560	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1084: ldc_w 745
    //   1087: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1090: iconst_m1
    //   1091: ireturn
    //   1092: astore 5
    //   1094: aconst_null
    //   1095: astore 4
    //   1097: aconst_null
    //   1098: astore 6
    //   1100: goto -199 -> 901
    //   1103: astore 5
    //   1105: aconst_null
    //   1106: astore 7
    //   1108: aload 4
    //   1110: astore 6
    //   1112: aload 7
    //   1114: astore 4
    //   1116: goto -215 -> 901
    //   1119: astore 6
    //   1121: aload 5
    //   1123: astore 7
    //   1125: aload 6
    //   1127: astore 5
    //   1129: aload 4
    //   1131: astore 6
    //   1133: aload 7
    //   1135: astore 4
    //   1137: goto -236 -> 901
    //   1140: astore 5
    //   1142: aload 8
    //   1144: astore 6
    //   1146: aload 7
    //   1148: astore 4
    //   1150: goto -249 -> 901
    //   1153: astore 6
    //   1155: aconst_null
    //   1156: astore 5
    //   1158: aload 4
    //   1160: astore 9
    //   1162: aload 5
    //   1164: astore 4
    //   1166: goto -199 -> 967
    //   1169: astore 7
    //   1171: aload 6
    //   1173: astore 5
    //   1175: aload 7
    //   1177: astore 6
    //   1179: aload 4
    //   1181: astore 9
    //   1183: aload 5
    //   1185: astore 4
    //   1187: goto -220 -> 967
    //   1190: astore 6
    //   1192: aload 4
    //   1194: astore 9
    //   1196: aload 5
    //   1198: astore 4
    //   1200: goto -233 -> 967
    //   1203: astore 5
    //   1205: aconst_null
    //   1206: astore 7
    //   1208: aload 4
    //   1210: astore 6
    //   1212: aload 7
    //   1214: astore 4
    //   1216: goto -334 -> 882
    //   1219: astore 5
    //   1221: aload 4
    //   1223: astore 6
    //   1225: aload 7
    //   1227: astore 4
    //   1229: goto -347 -> 882
    //   1232: astore 6
    //   1234: aload 5
    //   1236: astore 7
    //   1238: aload 6
    //   1240: astore 5
    //   1242: aload 4
    //   1244: astore 6
    //   1246: aload 7
    //   1248: astore 4
    //   1250: goto -368 -> 882
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1253	0	this	a
    //   51	757	1	i	int
    //   520	76	2	j	int
    //   539	53	3	k	int
    //   131	1118	4	localObject1	Object
    //   179	605	5	localObject2	Object
    //   874	23	5	localOperationCanceledException1	OperationCanceledException
    //   899	58	5	localObject3	Object
    //   1092	1	5	localObject4	Object
    //   1103	19	5	localObject5	Object
    //   1127	1	5	localObject6	Object
    //   1140	1	5	localObject7	Object
    //   1156	41	5	localObject8	Object
    //   1203	1	5	localOperationCanceledException2	OperationCanceledException
    //   1219	16	5	localOperationCanceledException3	OperationCanceledException
    //   1240	1	5	localObject9	Object
    //   349	597	6	localObject10	Object
    //   959	72	6	localException1	Exception
    //   1098	13	6	localObject11	Object
    //   1119	7	6	localObject12	Object
    //   1131	14	6	localObject13	Object
    //   1153	19	6	localException2	Exception
    //   1177	1	6	localObject14	Object
    //   1190	1	6	localException3	Exception
    //   1210	14	6	localObject15	Object
    //   1232	7	6	localOperationCanceledException4	OperationCanceledException
    //   1244	1	6	localObject16	Object
    //   353	794	7	localObject17	Object
    //   1169	7	7	localException4	Exception
    //   1206	41	7	localOperationCanceledException5	OperationCanceledException
    //   341	802	8	localObject18	Object
    //   121	1074	9	localObject19	Object
    //   55	358	10	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   39	74	874	com/tencent/wcdb/support/OperationCanceledException
    //   103	154	874	com/tencent/wcdb/support/OperationCanceledException
    //   882	899	899	finally
    //   39	74	959	java/lang/Exception
    //   103	154	959	java/lang/Exception
    //   39	74	1092	finally
    //   103	154	1092	finally
    //   154	199	1103	finally
    //   205	234	1103	finally
    //   241	270	1103	finally
    //   277	343	1103	finally
    //   355	366	1119	finally
    //   378	385	1119	finally
    //   397	423	1119	finally
    //   435	450	1119	finally
    //   462	479	1119	finally
    //   644	655	1119	finally
    //   667	674	1119	finally
    //   686	710	1119	finally
    //   722	739	1119	finally
    //   751	762	1119	finally
    //   774	781	1119	finally
    //   793	817	1119	finally
    //   491	502	1140	finally
    //   510	521	1140	finally
    //   529	540	1140	finally
    //   548	554	1140	finally
    //   562	569	1140	finally
    //   577	603	1140	finally
    //   611	628	1140	finally
    //   975	1001	1140	finally
    //   1009	1035	1140	finally
    //   154	199	1153	java/lang/Exception
    //   205	234	1153	java/lang/Exception
    //   241	270	1153	java/lang/Exception
    //   277	343	1153	java/lang/Exception
    //   355	366	1169	java/lang/Exception
    //   378	385	1169	java/lang/Exception
    //   397	423	1169	java/lang/Exception
    //   435	450	1169	java/lang/Exception
    //   462	479	1169	java/lang/Exception
    //   644	655	1169	java/lang/Exception
    //   667	674	1169	java/lang/Exception
    //   686	710	1169	java/lang/Exception
    //   722	739	1169	java/lang/Exception
    //   751	762	1169	java/lang/Exception
    //   774	781	1169	java/lang/Exception
    //   793	817	1169	java/lang/Exception
    //   491	502	1190	java/lang/Exception
    //   510	521	1190	java/lang/Exception
    //   529	540	1190	java/lang/Exception
    //   548	554	1190	java/lang/Exception
    //   562	569	1190	java/lang/Exception
    //   577	603	1190	java/lang/Exception
    //   611	628	1190	java/lang/Exception
    //   154	199	1203	com/tencent/wcdb/support/OperationCanceledException
    //   205	234	1203	com/tencent/wcdb/support/OperationCanceledException
    //   241	270	1203	com/tencent/wcdb/support/OperationCanceledException
    //   277	343	1203	com/tencent/wcdb/support/OperationCanceledException
    //   355	366	1219	com/tencent/wcdb/support/OperationCanceledException
    //   378	385	1219	com/tencent/wcdb/support/OperationCanceledException
    //   397	423	1219	com/tencent/wcdb/support/OperationCanceledException
    //   435	450	1219	com/tencent/wcdb/support/OperationCanceledException
    //   462	479	1219	com/tencent/wcdb/support/OperationCanceledException
    //   644	655	1219	com/tencent/wcdb/support/OperationCanceledException
    //   667	674	1219	com/tencent/wcdb/support/OperationCanceledException
    //   686	710	1219	com/tencent/wcdb/support/OperationCanceledException
    //   722	739	1219	com/tencent/wcdb/support/OperationCanceledException
    //   751	762	1219	com/tencent/wcdb/support/OperationCanceledException
    //   774	781	1219	com/tencent/wcdb/support/OperationCanceledException
    //   793	817	1219	com/tencent/wcdb/support/OperationCanceledException
    //   491	502	1232	com/tencent/wcdb/support/OperationCanceledException
    //   510	521	1232	com/tencent/wcdb/support/OperationCanceledException
    //   529	540	1232	com/tencent/wcdb/support/OperationCanceledException
    //   548	554	1232	com/tencent/wcdb/support/OperationCanceledException
    //   562	569	1232	com/tencent/wcdb/support/OperationCanceledException
    //   577	603	1232	com/tencent/wcdb/support/OperationCanceledException
    //   611	628	1232	com/tencent/wcdb/support/OperationCanceledException
  }
  
  private int mc(boolean paramBoolean)
  {
    AppMethodBeat.i(23125);
    Log.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.uds);
    if (this.udr == null)
    {
      AppMethodBeat.o(23125);
      return -1;
    }
    q localq = new q(this.udr.getPath());
    if (this.udr.isOpen()) {
      this.udr.close();
    }
    if (paramBoolean)
    {
      if (!localq.aj(new q(this.uds)))
      {
        Log.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", new Object[] { localq, this.uds });
        AppMethodBeat.o(23125);
        return -1;
      }
    }
    else
    {
      Log.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", new Object[] { localq });
      localq.cFq();
    }
    AppMethodBeat.o(23125);
    return 0;
  }
  
  /* Error */
  private Integer pw()
  {
    // Byte code:
    //   0: sipush 23121
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: bipush 54
    //   8: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   11: iconst_m1
    //   12: istore_2
    //   13: invokestatic 852	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   16: ldc_w 854
    //   19: invokevirtual 860	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 862	android/os/PowerManager
    //   25: iconst_1
    //   26: ldc_w 864
    //   29: invokevirtual 868	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   32: astore 11
    //   34: invokestatic 873	android/os/SystemClock:uptimeMillis	()J
    //   37: lstore 6
    //   39: ldc2_w 874
    //   42: new 877	com/tencent/mm/hellhoundlib/b/a
    //   45: dup
    //   46: invokespecial 878	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   49: invokestatic 883	com/tencent/mm/hellhoundlib/b/c:a	(JLcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   52: astore 10
    //   54: aload 11
    //   56: aload 10
    //   58: invokevirtual 887	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   61: ldc_w 889
    //   64: ldc_w 891
    //   67: ldc_w 893
    //   70: ldc_w 895
    //   73: ldc_w 897
    //   76: ldc_w 899
    //   79: invokestatic 904	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload 10
    //   84: invokestatic 907	com/tencent/mm/hellhoundlib/b/c:a	(Lcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   87: iconst_0
    //   88: invokevirtual 910	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   91: checkcast 542	java/lang/Long
    //   94: invokevirtual 913	java/lang/Long:longValue	()J
    //   97: lstore 8
    //   99: invokestatic 917	com/tencent/mm/hellhoundlib/b/c:aFj	()Lcom/tencent/mm/hellhoundlib/b/a;
    //   102: pop
    //   103: aload 11
    //   105: lload 8
    //   107: invokevirtual 921	android/os/PowerManager$WakeLock:acquire	(J)V
    //   110: aload 11
    //   112: ldc_w 889
    //   115: ldc_w 891
    //   118: ldc_w 893
    //   121: ldc_w 895
    //   124: ldc_w 897
    //   127: ldc_w 899
    //   130: invokestatic 924	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   133: iload_2
    //   134: istore_1
    //   135: aload_0
    //   136: iconst_1
    //   137: anewarray 176	java/lang/Integer
    //   140: dup
    //   141: iconst_0
    //   142: iconst_1
    //   143: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   150: iload_2
    //   151: istore_1
    //   152: aload_0
    //   153: invokespecial 926	com/tencent/mm/plugin/dbbackup/a/a:cPG	()I
    //   156: istore 4
    //   158: iload 4
    //   160: ifeq +165 -> 325
    //   163: iload 4
    //   165: tableswitch	default:+31 -> 196, -2:+152->317, -1:+31->196, 0:+107->272, 1:+144->309
    //   197: dstore 184
    //   199: iconst_0
    //   200: astore_3
    //   201: aload 11
    //   203: invokevirtual 929	android/os/PowerManager$WakeLock:isHeld	()Z
    //   206: ifeq +54 -> 260
    //   209: aload 11
    //   211: ldc_w 889
    //   214: ldc_w 891
    //   217: ldc_w 893
    //   220: ldc_w 895
    //   223: ldc_w 930
    //   226: ldc_w 931
    //   229: invokestatic 933	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 11
    //   234: invokevirtual 934	android/os/PowerManager$WakeLock:release	()V
    //   237: aload 11
    //   239: ldc_w 889
    //   242: ldc_w 891
    //   245: ldc_w 893
    //   248: ldc_w 895
    //   251: ldc_w 930
    //   254: ldc_w 931
    //   257: invokestatic 924	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   260: sipush 23121
    //   263: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: iload 4
    //   268: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: areturn
    //   272: invokestatic 873	android/os/SystemClock:uptimeMillis	()J
    //   275: lstore 8
    //   277: bipush 55
    //   279: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   282: getstatic 470	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   285: ldc2_w 935
    //   288: ldc2_w 937
    //   291: lload 8
    //   293: lload 6
    //   295: lsub
    //   296: ldc2_w 939
    //   299: ldiv
    //   300: lconst_1
    //   301: ladd
    //   302: iconst_1
    //   303: invokevirtual 944	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   306: goto -105 -> 201
    //   309: bipush 56
    //   311: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   314: goto -113 -> 201
    //   317: bipush 58
    //   319: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   322: goto -121 -> 201
    //   325: iload 4
    //   327: istore_1
    //   328: iload 4
    //   330: istore_2
    //   331: iload 4
    //   333: istore_3
    //   334: aload_0
    //   335: getfield 327	com/tencent/mm/plugin/dbbackup/a/a:udC	Lcom/tencent/mm/plugin/dbbackup/a/a$d;
    //   338: ifnull +102 -> 440
    //   341: iload 4
    //   343: istore_1
    //   344: iload 4
    //   346: istore_2
    //   347: iload 4
    //   349: istore_3
    //   350: ldc 138
    //   352: ldc_w 946
    //   355: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: iload 4
    //   360: istore_1
    //   361: iload 4
    //   363: istore_2
    //   364: iload 4
    //   366: istore_3
    //   367: aload_0
    //   368: getfield 327	com/tencent/mm/plugin/dbbackup/a/a:udC	Lcom/tencent/mm/plugin/dbbackup/a/a$d;
    //   371: invokeinterface 950 1 0
    //   376: astore 10
    //   378: iload 4
    //   380: istore_1
    //   381: iload 4
    //   383: istore_2
    //   384: iload 4
    //   386: istore_3
    //   387: aload_0
    //   388: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:udA	Ljava/util/List;
    //   391: aload 10
    //   393: invokeinterface 954 2 0
    //   398: pop
    //   399: iload 4
    //   401: istore_1
    //   402: iload 4
    //   404: istore_2
    //   405: iload 4
    //   407: istore_3
    //   408: aload_0
    //   409: getfield 327	com/tencent/mm/plugin/dbbackup/a/a:udC	Lcom/tencent/mm/plugin/dbbackup/a/a$d;
    //   412: invokeinterface 957 1 0
    //   417: astore 10
    //   419: iload 4
    //   421: istore_1
    //   422: iload 4
    //   424: istore_2
    //   425: iload 4
    //   427: istore_3
    //   428: aload_0
    //   429: getfield 652	com/tencent/mm/plugin/dbbackup/a/a:udB	Ljava/util/List;
    //   432: aload 10
    //   434: invokeinterface 954 2 0
    //   439: pop
    //   440: iload 4
    //   442: istore_1
    //   443: iload 4
    //   445: istore_2
    //   446: iload 4
    //   448: istore_3
    //   449: aload_0
    //   450: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:udA	Ljava/util/List;
    //   453: invokeinterface 958 1 0
    //   458: ifeq +23 -> 481
    //   461: iload 4
    //   463: istore_1
    //   464: iload 4
    //   466: istore_2
    //   467: iload 4
    //   469: istore_3
    //   470: aload_0
    //   471: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:udA	Ljava/util/List;
    //   474: aconst_null
    //   475: invokeinterface 959 2 0
    //   480: pop
    //   481: iload 4
    //   483: istore_1
    //   484: iload 4
    //   486: istore_2
    //   487: iload 4
    //   489: istore_3
    //   490: aload_0
    //   491: getfield 652	com/tencent/mm/plugin/dbbackup/a/a:udB	Ljava/util/List;
    //   494: invokeinterface 958 1 0
    //   499: ifeq +23 -> 522
    //   502: iload 4
    //   504: istore_1
    //   505: iload 4
    //   507: istore_2
    //   508: iload 4
    //   510: istore_3
    //   511: aload_0
    //   512: getfield 652	com/tencent/mm/plugin/dbbackup/a/a:udB	Ljava/util/List;
    //   515: aconst_null
    //   516: invokeinterface 959 2 0
    //   521: pop
    //   522: iconst_0
    //   523: istore_2
    //   524: iconst_0
    //   525: istore_3
    //   526: iconst_0
    //   527: istore_1
    //   528: aload_0
    //   529: invokespecial 961	com/tencent/mm/plugin/dbbackup/a/a:cPH	()I
    //   532: istore 4
    //   534: iload 4
    //   536: istore_1
    //   537: iload 4
    //   539: istore_2
    //   540: iload 4
    //   542: istore_3
    //   543: aload_0
    //   544: iconst_1
    //   545: anewarray 176	java/lang/Integer
    //   548: dup
    //   549: iconst_0
    //   550: iconst_2
    //   551: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   554: aastore
    //   555: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   558: iload 4
    //   560: istore_1
    //   561: iload 4
    //   563: istore_2
    //   564: iload 4
    //   566: istore_3
    //   567: aload_0
    //   568: invokespecial 963	com/tencent/mm/plugin/dbbackup/a/a:cPI	()I
    //   571: istore 5
    //   573: iload 5
    //   575: iconst_1
    //   576: if_icmpne +165 -> 741
    //   579: iload 5
    //   581: tableswitch	default:+31 -> 612, -2:+152->733, -1:+31->612, 0:+107->688, 1:+144->725
    //   613: dstore 184
    //   615: iconst_0
    //   616: astore_3
    //   617: aload 11
    //   619: invokevirtual 929	android/os/PowerManager$WakeLock:isHeld	()Z
    //   622: ifeq +54 -> 676
    //   625: aload 11
    //   627: ldc_w 889
    //   630: ldc_w 891
    //   633: ldc_w 893
    //   636: ldc_w 895
    //   639: ldc_w 930
    //   642: ldc_w 931
    //   645: invokestatic 933	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   648: aload 11
    //   650: invokevirtual 934	android/os/PowerManager$WakeLock:release	()V
    //   653: aload 11
    //   655: ldc_w 889
    //   658: ldc_w 891
    //   661: ldc_w 893
    //   664: ldc_w 895
    //   667: ldc_w 930
    //   670: ldc_w 931
    //   673: invokestatic 924	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   676: sipush 23121
    //   679: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   682: iload 5
    //   684: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   687: areturn
    //   688: invokestatic 873	android/os/SystemClock:uptimeMillis	()J
    //   691: lstore 8
    //   693: bipush 55
    //   695: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   698: getstatic 470	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   701: ldc2_w 935
    //   704: ldc2_w 937
    //   707: lload 8
    //   709: lload 6
    //   711: lsub
    //   712: ldc2_w 939
    //   715: ldiv
    //   716: lconst_1
    //   717: ladd
    //   718: iconst_1
    //   719: invokevirtual 944	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   722: goto -105 -> 617
    //   725: bipush 56
    //   727: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   730: goto -113 -> 617
    //   733: bipush 58
    //   735: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   738: goto -121 -> 617
    //   741: iload 5
    //   743: istore 4
    //   745: iload 5
    //   747: iconst_m1
    //   748: if_icmpne +42 -> 790
    //   751: iload 5
    //   753: istore_1
    //   754: iload 5
    //   756: istore_2
    //   757: iload 5
    //   759: istore_3
    //   760: aload_0
    //   761: iconst_1
    //   762: anewarray 176	java/lang/Integer
    //   765: dup
    //   766: iconst_0
    //   767: iconst_4
    //   768: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   771: aastore
    //   772: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   775: iload 5
    //   777: istore_1
    //   778: iload 5
    //   780: istore_2
    //   781: iload 5
    //   783: istore_3
    //   784: aload_0
    //   785: invokespecial 965	com/tencent/mm/plugin/dbbackup/a/a:cPJ	()I
    //   788: istore 4
    //   790: iload 4
    //   792: ifeq +165 -> 957
    //   795: iload 4
    //   797: tableswitch	default:+31 -> 828, -2:+152->949, -1:+31->828, 0:+107->904, 1:+144->941
    //   829: dstore 184
    //   831: iconst_0
    //   832: astore_3
    //   833: aload 11
    //   835: invokevirtual 929	android/os/PowerManager$WakeLock:isHeld	()Z
    //   838: ifeq +54 -> 892
    //   841: aload 11
    //   843: ldc_w 889
    //   846: ldc_w 891
    //   849: ldc_w 893
    //   852: ldc_w 895
    //   855: ldc_w 930
    //   858: ldc_w 931
    //   861: invokestatic 933	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   864: aload 11
    //   866: invokevirtual 934	android/os/PowerManager$WakeLock:release	()V
    //   869: aload 11
    //   871: ldc_w 889
    //   874: ldc_w 891
    //   877: ldc_w 893
    //   880: ldc_w 895
    //   883: ldc_w 930
    //   886: ldc_w 931
    //   889: invokestatic 924	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   892: sipush 23121
    //   895: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   898: iload 4
    //   900: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   903: areturn
    //   904: invokestatic 873	android/os/SystemClock:uptimeMillis	()J
    //   907: lstore 8
    //   909: bipush 55
    //   911: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   914: getstatic 470	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   917: ldc2_w 935
    //   920: ldc2_w 937
    //   923: lload 8
    //   925: lload 6
    //   927: lsub
    //   928: ldc2_w 939
    //   931: ldiv
    //   932: lconst_1
    //   933: ladd
    //   934: iconst_1
    //   935: invokevirtual 944	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   938: goto -105 -> 833
    //   941: bipush 56
    //   943: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   946: goto -113 -> 833
    //   949: bipush 58
    //   951: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   954: goto -121 -> 833
    //   957: iload 4
    //   959: istore_1
    //   960: iload 4
    //   962: istore_2
    //   963: iload 4
    //   965: istore_3
    //   966: aload_0
    //   967: iconst_1
    //   968: anewarray 176	java/lang/Integer
    //   971: dup
    //   972: iconst_0
    //   973: iconst_5
    //   974: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   977: aastore
    //   978: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   981: iload 4
    //   983: istore_1
    //   984: iload 4
    //   986: istore_2
    //   987: iload 4
    //   989: istore_3
    //   990: aload_0
    //   991: invokespecial 967	com/tencent/mm/plugin/dbbackup/a/a:cPK	()I
    //   994: pop
    //   995: iload 4
    //   997: istore_1
    //   998: iload 4
    //   1000: istore_2
    //   1001: iload 4
    //   1003: istore_3
    //   1004: aload_0
    //   1005: invokespecial 969	com/tencent/mm/plugin/dbbackup/a/a:cPL	()I
    //   1008: istore 4
    //   1010: iload 4
    //   1012: istore_1
    //   1013: iload 4
    //   1015: istore_2
    //   1016: iload 4
    //   1018: istore_3
    //   1019: aload_0
    //   1020: iconst_1
    //   1021: anewarray 176	java/lang/Integer
    //   1024: dup
    //   1025: iconst_0
    //   1026: bipush 6
    //   1028: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1031: aastore
    //   1032: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   1035: iload 4
    //   1037: istore_1
    //   1038: iload 4
    //   1040: istore_2
    //   1041: iload 4
    //   1043: istore_3
    //   1044: aload_0
    //   1045: iconst_1
    //   1046: invokespecial 971	com/tencent/mm/plugin/dbbackup/a/a:mc	(Z)I
    //   1049: istore 4
    //   1051: iload 4
    //   1053: tableswitch	default:+31 -> 1084, -2:+152->1205, -1:+31->1084, 0:+107->1160, 1:+144->1197
    //   1085: dstore 184
    //   1087: iconst_0
    //   1088: astore_3
    //   1089: aload 11
    //   1091: invokevirtual 929	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1094: ifeq +54 -> 1148
    //   1097: aload 11
    //   1099: ldc_w 889
    //   1102: ldc_w 891
    //   1105: ldc_w 893
    //   1108: ldc_w 895
    //   1111: ldc_w 930
    //   1114: ldc_w 931
    //   1117: invokestatic 933	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1120: aload 11
    //   1122: invokevirtual 934	android/os/PowerManager$WakeLock:release	()V
    //   1125: aload 11
    //   1127: ldc_w 889
    //   1130: ldc_w 891
    //   1133: ldc_w 893
    //   1136: ldc_w 895
    //   1139: ldc_w 930
    //   1142: ldc_w 931
    //   1145: invokestatic 924	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1148: sipush 23121
    //   1151: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1154: iload 4
    //   1156: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1159: areturn
    //   1160: invokestatic 873	android/os/SystemClock:uptimeMillis	()J
    //   1163: lstore 8
    //   1165: bipush 55
    //   1167: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   1170: getstatic 470	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1173: ldc2_w 935
    //   1176: ldc2_w 937
    //   1179: lload 8
    //   1181: lload 6
    //   1183: lsub
    //   1184: ldc2_w 939
    //   1187: ldiv
    //   1188: lconst_1
    //   1189: ladd
    //   1190: iconst_1
    //   1191: invokevirtual 944	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1194: goto -105 -> 1089
    //   1197: bipush 56
    //   1199: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   1202: goto -113 -> 1089
    //   1205: bipush 58
    //   1207: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   1210: goto -121 -> 1089
    //   1213: astore 10
    //   1215: iconst_m1
    //   1216: istore_3
    //   1217: iload_3
    //   1218: istore_1
    //   1219: ldc 138
    //   1221: ldc_w 973
    //   1224: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1227: iload_3
    //   1228: istore_1
    //   1229: aload_0
    //   1230: iconst_0
    //   1231: invokespecial 971	com/tencent/mm/plugin/dbbackup/a/a:mc	(Z)I
    //   1234: pop
    //   1235: iconst_1
    //   1236: istore_1
    //   1237: bipush 56
    //   1239: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   1242: aload 11
    //   1244: invokevirtual 929	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1247: ifeq +54 -> 1301
    //   1250: aload 11
    //   1252: ldc_w 889
    //   1255: ldc_w 891
    //   1258: ldc_w 893
    //   1261: ldc_w 895
    //   1264: ldc_w 930
    //   1267: ldc_w 931
    //   1270: invokestatic 933	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1273: aload 11
    //   1275: invokevirtual 934	android/os/PowerManager$WakeLock:release	()V
    //   1278: aload 11
    //   1280: ldc_w 889
    //   1283: ldc_w 891
    //   1286: ldc_w 893
    //   1289: ldc_w 895
    //   1292: ldc_w 930
    //   1295: ldc_w 931
    //   1298: invokestatic 924	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1301: sipush 23121
    //   1304: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1307: iconst_1
    //   1308: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1311: areturn
    //   1312: astore 10
    //   1314: iload_2
    //   1315: istore_1
    //   1316: ldc 138
    //   1318: aload 10
    //   1320: ldc_w 975
    //   1323: iconst_0
    //   1324: anewarray 142	java/lang/Object
    //   1327: invokestatic 553	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1330: iload_2
    //   1331: istore_1
    //   1332: aload_0
    //   1333: iconst_0
    //   1334: invokespecial 971	com/tencent/mm/plugin/dbbackup/a/a:mc	(Z)I
    //   1337: pop
    //   1338: iconst_m1
    //   1339: istore_1
    //   1340: bipush 57
    //   1342: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   1345: aload 11
    //   1347: invokevirtual 929	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1350: ifeq +54 -> 1404
    //   1353: aload 11
    //   1355: ldc_w 889
    //   1358: ldc_w 891
    //   1361: ldc_w 893
    //   1364: ldc_w 895
    //   1367: ldc_w 930
    //   1370: ldc_w 931
    //   1373: invokestatic 933	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1376: aload 11
    //   1378: invokevirtual 934	android/os/PowerManager$WakeLock:release	()V
    //   1381: aload 11
    //   1383: ldc_w 889
    //   1386: ldc_w 891
    //   1389: ldc_w 893
    //   1392: ldc_w 895
    //   1395: ldc_w 930
    //   1398: ldc_w 931
    //   1401: invokestatic 924	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1404: sipush 23121
    //   1407: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1410: iconst_m1
    //   1411: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1414: areturn
    //   1415: astore 10
    //   1417: iload_1
    //   1418: tableswitch	default:+30 -> 1448, -2:+148->1566, -1:+30->1448, 0:+103->1521, 1:+140->1558
    //   1449: dstore 184
    //   1451: iconst_0
    //   1452: astore_3
    //   1453: aload 11
    //   1455: invokevirtual 929	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1458: ifeq +54 -> 1512
    //   1461: aload 11
    //   1463: ldc_w 889
    //   1466: ldc_w 891
    //   1469: ldc_w 893
    //   1472: ldc_w 895
    //   1475: ldc_w 930
    //   1478: ldc_w 931
    //   1481: invokestatic 933	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1484: aload 11
    //   1486: invokevirtual 934	android/os/PowerManager$WakeLock:release	()V
    //   1489: aload 11
    //   1491: ldc_w 889
    //   1494: ldc_w 891
    //   1497: ldc_w 893
    //   1500: ldc_w 895
    //   1503: ldc_w 930
    //   1506: ldc_w 931
    //   1509: invokestatic 924	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1512: sipush 23121
    //   1515: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1518: aload 10
    //   1520: athrow
    //   1521: invokestatic 873	android/os/SystemClock:uptimeMillis	()J
    //   1524: lstore 8
    //   1526: bipush 55
    //   1528: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   1531: getstatic 470	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1534: ldc2_w 935
    //   1537: ldc2_w 937
    //   1540: lload 8
    //   1542: lload 6
    //   1544: lsub
    //   1545: ldc2_w 939
    //   1548: ldiv
    //   1549: lconst_1
    //   1550: ladd
    //   1551: iconst_1
    //   1552: invokevirtual 944	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1555: goto -102 -> 1453
    //   1558: bipush 56
    //   1560: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   1563: goto -110 -> 1453
    //   1566: bipush 58
    //   1568: invokestatic 846	com/tencent/mm/plugin/dbbackup/a/a:qS	(I)V
    //   1571: goto -118 -> 1453
    //   1574: astore 10
    //   1576: goto -159 -> 1417
    //   1579: astore 10
    //   1581: goto -267 -> 1314
    //   1584: astore 10
    //   1586: goto -369 -> 1217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1589	0	this	a
    //   134	1284	1	i	int
    //   12	1319	2	j	int
    //   333	895	3	k	int
    //   156	999	4	m	int
    //   571	211	5	n	int
    //   37	1506	6	l1	long
    //   97	1444	8	l2	long
    //   52	381	10	localObject1	Object
    //   1213	1	10	localOperationCanceledException1	OperationCanceledException
    //   1312	7	10	localException1	Exception
    //   1415	104	10	localObject2	Object
    //   1574	1	10	localObject3	Object
    //   1579	1	10	localException2	Exception
    //   1584	1	10	localOperationCanceledException2	OperationCanceledException
    //   32	1458	11	localWakeLock	android.os.PowerManager.WakeLock
    // Exception table:
    //   from	to	target	type
    //   135	150	1213	com/tencent/wcdb/support/OperationCanceledException
    //   152	158	1213	com/tencent/wcdb/support/OperationCanceledException
    //   135	150	1312	java/lang/Exception
    //   152	158	1312	java/lang/Exception
    //   135	150	1415	finally
    //   152	158	1415	finally
    //   1316	1330	1415	finally
    //   1332	1338	1415	finally
    //   334	341	1574	finally
    //   350	358	1574	finally
    //   367	378	1574	finally
    //   387	399	1574	finally
    //   408	419	1574	finally
    //   428	440	1574	finally
    //   449	461	1574	finally
    //   470	481	1574	finally
    //   490	502	1574	finally
    //   511	522	1574	finally
    //   528	534	1574	finally
    //   543	558	1574	finally
    //   567	573	1574	finally
    //   760	775	1574	finally
    //   784	790	1574	finally
    //   966	981	1574	finally
    //   990	995	1574	finally
    //   1004	1010	1574	finally
    //   1019	1035	1574	finally
    //   1044	1051	1574	finally
    //   1219	1227	1574	finally
    //   1229	1235	1574	finally
    //   334	341	1579	java/lang/Exception
    //   350	358	1579	java/lang/Exception
    //   367	378	1579	java/lang/Exception
    //   387	399	1579	java/lang/Exception
    //   408	419	1579	java/lang/Exception
    //   428	440	1579	java/lang/Exception
    //   449	461	1579	java/lang/Exception
    //   470	481	1579	java/lang/Exception
    //   490	502	1579	java/lang/Exception
    //   511	522	1579	java/lang/Exception
    //   528	534	1579	java/lang/Exception
    //   543	558	1579	java/lang/Exception
    //   567	573	1579	java/lang/Exception
    //   760	775	1579	java/lang/Exception
    //   784	790	1579	java/lang/Exception
    //   966	981	1579	java/lang/Exception
    //   990	995	1579	java/lang/Exception
    //   1004	1010	1579	java/lang/Exception
    //   1019	1035	1579	java/lang/Exception
    //   1044	1051	1579	java/lang/Exception
    //   334	341	1584	com/tencent/wcdb/support/OperationCanceledException
    //   350	358	1584	com/tencent/wcdb/support/OperationCanceledException
    //   367	378	1584	com/tencent/wcdb/support/OperationCanceledException
    //   387	399	1584	com/tencent/wcdb/support/OperationCanceledException
    //   408	419	1584	com/tencent/wcdb/support/OperationCanceledException
    //   428	440	1584	com/tencent/wcdb/support/OperationCanceledException
    //   449	461	1584	com/tencent/wcdb/support/OperationCanceledException
    //   470	481	1584	com/tencent/wcdb/support/OperationCanceledException
    //   490	502	1584	com/tencent/wcdb/support/OperationCanceledException
    //   511	522	1584	com/tencent/wcdb/support/OperationCanceledException
    //   528	534	1584	com/tencent/wcdb/support/OperationCanceledException
    //   543	558	1584	com/tencent/wcdb/support/OperationCanceledException
    //   567	573	1584	com/tencent/wcdb/support/OperationCanceledException
    //   760	775	1584	com/tencent/wcdb/support/OperationCanceledException
    //   784	790	1584	com/tencent/wcdb/support/OperationCanceledException
    //   966	981	1584	com/tencent/wcdb/support/OperationCanceledException
    //   990	995	1584	com/tencent/wcdb/support/OperationCanceledException
    //   1004	1010	1584	com/tencent/wcdb/support/OperationCanceledException
    //   1019	1035	1584	com/tencent/wcdb/support/OperationCanceledException
    //   1044	1051	1584	com/tencent/wcdb/support/OperationCanceledException
  }
  
  private static void qS(int paramInt)
  {
    AppMethodBeat.i(23131);
    f.Iyx.idkeyStat(181L, paramInt, 1L, true);
    AppMethodBeat.o(23131);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(23122);
    this.mCancellationSignal.cancel();
    Log.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
    AppMethodBeat.o(23122);
  }
  
  public static final class a
  {
    public a.d udC;
    public boolean udD;
    public a.b udE;
    private LinkedHashSet<byte[]> udW;
    private LinkedHashSet<byte[]> udX;
    public String uds;
    public String udt;
    public String udu;
    public String udv;
    private List<String> udw;
    private List<String> udx;
    private byte[] udy;
    private byte[] udz;
    
    public a()
    {
      AppMethodBeat.i(23114);
      this.udw = new ArrayList();
      this.udx = new ArrayList();
      this.udW = new LinkedHashSet();
      this.udX = new LinkedHashSet();
      AppMethodBeat.o(23114);
    }
    
    public final a asN(String paramString)
    {
      AppMethodBeat.i(23116);
      this.udw.add(paramString);
      AppMethodBeat.o(23116);
      return this;
    }
    
    public final a asO(String paramString)
    {
      AppMethodBeat.i(23117);
      this.udx.add(paramString);
      AppMethodBeat.o(23117);
      return this;
    }
    
    public final a by(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(23118);
      this.udy = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(23118);
      return this;
    }
    
    public final a bz(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(23119);
      this.udz = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(23119);
      return this;
    }
    
    public final a cPM()
    {
      AppMethodBeat.i(23115);
      a locala = new a((byte)0);
      a.a(locala, this.uds);
      a.b(locala, this.udt);
      a.c(locala, this.udu);
      a.d(locala, this.udv);
      a.a(locala, new ArrayList(this.udw));
      a.b(locala, new ArrayList(this.udx));
      a.a(locala, this.udy);
      a.b(locala, this.udz);
      a.a(locala, this.udC);
      a.c(locala, new ArrayList(this.udW));
      a.d(locala, new ArrayList(this.udX));
      a.a(locala, this.udD);
      a.a(locala, this.udE);
      AppMethodBeat.o(23115);
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void O(long paramLong1, long paramLong2);
    
    public abstract void Y(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onCanceled();
    
    public abstract void onFailure();
    
    public abstract void onSuccess();
  }
  
  static final class c
  {
    final String name;
    final String rAi;
    final String type;
    final boolean udY;
    final boolean udZ;
    
    c(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2)
    {
      this.name = paramString1;
      this.type = paramString2;
      this.udY = paramBoolean1;
      this.rAi = paramString3;
      this.udZ = paramBoolean2;
    }
  }
  
  public static abstract interface d
  {
    public abstract Collection<byte[]> cPy();
    
    public abstract Collection<byte[]> cPz();
  }
  
  static abstract interface e
  {
    public abstract boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a
 * JD-Core Version:    0.7.0.1
 */