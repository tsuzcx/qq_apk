package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
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
  private static final SQLiteCipherSpec oED;
  private final CancellationSignal mCancellationSignal;
  private SQLiteDatabase oEE;
  private String oEF;
  private String oEG;
  private String oEH;
  private String oEI;
  private List<String> oEJ;
  private List<String> oEK;
  private byte[] oEL;
  private byte[] oEM;
  private List<byte[]> oEN;
  private List<byte[]> oEO;
  private c oEP;
  private boolean oEQ;
  private b oER;
  private boolean oES;
  private int oET;
  private long oEU;
  private long oEV;
  
  static
  {
    AppMethodBeat.i(23138);
    oED = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    CONFLICT_VALUES = new String[] { "", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE" };
    AppMethodBeat.o(23138);
  }
  
  private a()
  {
    AppMethodBeat.i(23120);
    this.mCancellationSignal = new CancellationSignal();
    AppMethodBeat.o(23120);
  }
  
  private static long Wo(String paramString)
  {
    AppMethodBeat.i(23130);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString);
    paramString = locale;
    if (!locale.isDirectory()) {
      paramString = locale.fxU();
    }
    do
    {
      long l = paramString.getUsableSpace();
      if (l > 0L)
      {
        AppMethodBeat.o(23130);
        return l;
      }
      locale = paramString.fxU();
      paramString = locale;
    } while (locale != null);
    AppMethodBeat.o(23130);
    return 0L;
  }
  
  private int a(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, d paramd)
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
      ac.e("MicroMsg.DBRecoveryTask", "There is no table named '%s' to copy.", new Object[] { paramString });
      if (this.oEE.inTransaction()) {
        this.oEE.endTransaction();
      }
      AppMethodBeat.o(23129);
      return -1;
      localObject = ((String)localObject).replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS ");
      this.oEE.execSQL((String)localObject, null, this.mCancellationSignal);
      if (!paramBoolean)
      {
        if (this.oEE.inTransaction()) {
          this.oEE.endTransaction();
        }
        AppMethodBeat.o(23129);
        return 0;
      }
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
          paramString = this.oEE.compileStatement(localStringBuilder.toString());
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
          this.oEE.beginTransaction();
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
        if (this.oEE.inTransaction()) {
          this.oEE.endTransaction();
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
        if ((paramd == null) || (paramd.a((Cursor)localObject, paramString)))
        {
          paramString.executeInsert(this.mCancellationSignal);
          paramInt1 += 1;
        }
      }
      this.oEE.setTransactionSuccessful();
      if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
        ((Cursor)localObject).close();
      }
      if (this.oEE.inTransaction()) {
        this.oEE.endTransaction();
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
  private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 347
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   9: astore 4
    //   11: iload_2
    //   12: invokestatic 349	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   15: astore 5
    //   17: aload_0
    //   18: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   21: astore 6
    //   23: aload_1
    //   24: aload 4
    //   26: ldc_w 351
    //   29: iconst_1
    //   30: anewarray 88	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: aload 5
    //   37: aastore
    //   38: ldc_w 353
    //   41: aload 6
    //   43: invokevirtual 211	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;Lcom/tencent/wcdb/support/CancellationSignal;)Lcom/tencent/wcdb/Cursor;
    //   46: astore 5
    //   48: aconst_null
    //   49: astore 4
    //   51: aload 5
    //   53: invokeinterface 356 1 0
    //   58: ifeq +74 -> 132
    //   61: aload 5
    //   63: iconst_0
    //   64: invokeinterface 359 2 0
    //   69: istore_2
    //   70: aload 5
    //   72: iconst_1
    //   73: invokeinterface 359 2 0
    //   78: istore_3
    //   79: aload 5
    //   81: iconst_2
    //   82: invokeinterface 308 2 0
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   92: astore 6
    //   94: aload_0
    //   95: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   98: astore 7
    //   100: aload 6
    //   102: ldc_w 361
    //   105: iconst_3
    //   106: anewarray 157	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: iload_2
    //   112: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: iload_3
    //   119: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: aastore
    //   123: dup
    //   124: iconst_2
    //   125: aload_1
    //   126: aastore
    //   127: aload 7
    //   129: invokevirtual 185	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   132: aload 5
    //   134: ifnull +76 -> 210
    //   137: aload 5
    //   139: invokeinterface 287 1 0
    //   144: ldc_w 347
    //   147: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore 4
    //   153: ldc_w 347
    //   156: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload 4
    //   161: athrow
    //   162: astore_1
    //   163: aload 5
    //   165: ifnull +15 -> 180
    //   168: aload 4
    //   170: ifnull +30 -> 200
    //   173: aload 5
    //   175: invokeinterface 287 1 0
    //   180: ldc_w 347
    //   183: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_1
    //   187: athrow
    //   188: astore 5
    //   190: aload 4
    //   192: aload 5
    //   194: invokevirtual 365	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   197: goto -17 -> 180
    //   200: aload 5
    //   202: invokeinterface 287 1 0
    //   207: goto -27 -> 180
    //   210: ldc_w 347
    //   213: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private int bXp()
  {
    long l2 = 0L;
    AppMethodBeat.i(23123);
    ac.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
    if ((this.oEF == null) || (this.oEF.isEmpty()))
    {
      AppMethodBeat.o(23123);
      return -1;
    }
    this.oES = false;
    this.oET = 300000;
    if (this.oEI != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(i.aSr(this.oEI));
        this.oET = localJSONObject.getInt("message");
        this.oES = true;
        l1 = localJSONObject.getLong("dbSize");
        if (this.oEH != null) {
          l2 = i.aSp(this.oEH);
        }
        this.oEU = Math.max(l1, l2);
        this.oEU += Math.max(this.oEU / 10L, 67108864L);
        this.oEV = Wo(this.oEF);
        if (this.oEU <= this.oEV) {
          break;
        }
        ac.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[] { Long.valueOf(this.oEU), Long.valueOf(this.oEV) });
        AppMethodBeat.o(23123);
        return -2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        ac.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.oEI);
        l1 = 0L;
        continue;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.DBRecoveryTask", localException, "Cannot read statistics from file.", new Object[0]);
      }
      long l1 = 0L;
    }
    ac.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", new Object[] { Long.valueOf(this.oEU), Long.valueOf(this.oEV), Integer.valueOf(this.oET) });
    AppMethodBeat.o(23123);
    return 0;
  }
  
  private int bXq()
  {
    AppMethodBeat.i(23124);
    if (this.oEE != null)
    {
      if (this.oEE.isOpen()) {
        this.oEE.close();
      }
      this.oEE = null;
    }
    this.mCancellationSignal.throwIfCanceled();
    String str = this.oEF + '-' + bs.Yu(6);
    ac.i("MicroMsg.DBRecoveryTask", "Open target database: ".concat(String.valueOf(str)));
    try
    {
      this.oEE = SQLiteDatabase.openOrCreateDatabase(str, this.oEL, oED, null, null, 1);
      DatabaseUtils.stringForQuery(this.oEE, "PRAGMA journal_mode=OFF;", null);
      this.oEE.execSQL("PRAGMA synchronous=OFF;");
      AppMethodBeat.o(23124);
      return 0;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", new Object[] { str, localException.getMessage() });
      c(1, "Cannot open target database", localException);
      AppMethodBeat.o(23124);
      throw localException;
    }
  }
  
  /* Error */
  private int bXr()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore_2
    //   8: sipush 23126
    //   11: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_0
    //   15: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   18: invokevirtual 459	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   21: iconst_5
    //   22: anewarray 88	java/lang/String
    //   25: astore 6
    //   27: aload 6
    //   29: iconst_0
    //   30: ldc_w 403
    //   33: aastore
    //   34: aload 6
    //   36: iconst_1
    //   37: ldc_w 494
    //   40: aastore
    //   41: aload 6
    //   43: iconst_2
    //   44: ldc_w 496
    //   47: aastore
    //   48: aload 6
    //   50: iconst_3
    //   51: ldc_w 498
    //   54: aastore
    //   55: aload 6
    //   57: iconst_4
    //   58: ldc_w 500
    //   61: aastore
    //   62: aload_0
    //   63: getfield 342	com/tencent/mm/plugin/dbbackup/a/a:oEJ	Ljava/util/List;
    //   66: invokeinterface 506 1 0
    //   71: astore 9
    //   73: aconst_null
    //   74: astore 4
    //   76: aload 9
    //   78: invokeinterface 511 1 0
    //   83: ifeq +888 -> 971
    //   86: aload 9
    //   88: invokeinterface 515 1 0
    //   93: checkcast 88	java/lang/String
    //   96: astore 10
    //   98: aload 10
    //   100: invokestatic 519	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   103: ifne +22 -> 125
    //   106: ldc 153
    //   108: ldc_w 521
    //   111: aload 10
    //   113: invokestatic 191	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -46 -> 76
    //   125: iconst_0
    //   126: istore_1
    //   127: aload 4
    //   129: astore 5
    //   131: aload 5
    //   133: astore 4
    //   135: iload_1
    //   136: aload_0
    //   137: getfield 523	com/tencent/mm/plugin/dbbackup/a/a:oEN	Ljava/util/List;
    //   140: invokeinterface 526 1 0
    //   145: if_icmpge -69 -> 76
    //   148: aload_0
    //   149: getfield 523	com/tencent/mm/plugin/dbbackup/a/a:oEN	Ljava/util/List;
    //   152: iload_1
    //   153: invokeinterface 530 2 0
    //   158: checkcast 531	[B
    //   161: astore 11
    //   163: aload 5
    //   165: astore 4
    //   167: aload 10
    //   169: iconst_0
    //   170: invokestatic 537	com/tencent/mm/b/q:k	(Ljava/lang/String;Z)Ljava/lang/String;
    //   173: aload 11
    //   175: aload 6
    //   177: invokestatic 543	com/tencent/wcdb/repair/RepairKit$MasterInfo:load	(Ljava/lang/String;[B[Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   180: astore 5
    //   182: aload 5
    //   184: astore 4
    //   186: ldc 153
    //   188: new 219	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 545
    //   195: invokespecial 441	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload 10
    //   200: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 547
    //   206: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload_1
    //   210: invokevirtual 550	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 5
    //   221: astore 4
    //   223: aload 4
    //   225: ifnonnull +403 -> 628
    //   228: aload 6
    //   230: invokestatic 554	com/tencent/wcdb/repair/RepairKit$MasterInfo:make	([Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   233: astore 6
    //   235: ldc 153
    //   237: ldc_w 556
    //   240: invokestatic 559	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   259: ldc 153
    //   261: new 219	java/lang/StringBuilder
    //   264: dup
    //   265: ldc_w 561
    //   268: invokespecial 441	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield 412	com/tencent/mm/plugin/dbbackup/a/a:oEH	Ljava/lang/String;
    //   275: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: iload_2
    //   285: istore_1
    //   286: aload 7
    //   288: astore 4
    //   290: aload 8
    //   292: astore 5
    //   294: iload_1
    //   295: aload_0
    //   296: getfield 563	com/tencent/mm/plugin/dbbackup/a/a:oEO	Ljava/util/List;
    //   299: invokeinterface 526 1 0
    //   304: if_icmpge +69 -> 373
    //   307: aload 8
    //   309: astore 5
    //   311: aload_0
    //   312: getfield 563	com/tencent/mm/plugin/dbbackup/a/a:oEO	Ljava/util/List;
    //   315: iload_1
    //   316: invokeinterface 530 2 0
    //   321: checkcast 531	[B
    //   324: astore 4
    //   326: aload 8
    //   328: astore 5
    //   330: new 565	com/tencent/wcdb/repair/RepairKit
    //   333: dup
    //   334: aload_0
    //   335: getfield 412	com/tencent/mm/plugin/dbbackup/a/a:oEH	Ljava/lang/String;
    //   338: aload 4
    //   340: getstatic 86	com/tencent/mm/plugin/dbbackup/a/a:oED	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   343: aload 6
    //   345: invokespecial 568	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   348: astore 4
    //   350: aload 4
    //   352: invokevirtual 571	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   355: ifne +290 -> 645
    //   358: ldc 153
    //   360: ldc_w 573
    //   363: iload_1
    //   364: invokestatic 575	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   367: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 4
    //   375: ifnonnull +593 -> 968
    //   378: aload 4
    //   380: astore 5
    //   382: ldc 153
    //   384: ldc_w 577
    //   387: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload 4
    //   392: astore 5
    //   394: new 565	com/tencent/wcdb/repair/RepairKit
    //   397: dup
    //   398: aload_0
    //   399: getfield 412	com/tencent/mm/plugin/dbbackup/a/a:oEH	Ljava/lang/String;
    //   402: aload_0
    //   403: getfield 563	com/tencent/mm/plugin/dbbackup/a/a:oEO	Ljava/util/List;
    //   406: iconst_0
    //   407: invokeinterface 530 2 0
    //   412: checkcast 531	[B
    //   415: getstatic 86	com/tencent/mm/plugin/dbbackup/a/a:oED	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   418: aload 6
    //   420: invokespecial 568	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
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
    //   442: invokespecial 580	com/tencent/mm/plugin/dbbackup/a/a$1:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;[I)V
    //   445: invokevirtual 584	com/tencent/wcdb/repair/RepairKit:setCallback	(Lcom/tencent/wcdb/repair/RepairKit$Callback;)V
    //   448: aload 4
    //   450: astore 6
    //   452: aload 4
    //   454: aload_0
    //   455: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   458: iconst_0
    //   459: aload_0
    //   460: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   463: invokevirtual 588	com/tencent/wcdb/repair/RepairKit:output	(Lcom/tencent/wcdb/database/SQLiteDatabase;ILcom/tencent/wcdb/support/CancellationSignal;)I
    //   466: istore_1
    //   467: iload_1
    //   468: ifne +291 -> 759
    //   471: aload 4
    //   473: astore 6
    //   475: aload 4
    //   477: invokevirtual 571	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   480: ifeq +187 -> 667
    //   483: aload 4
    //   485: astore 6
    //   487: aload 4
    //   489: invokevirtual 591	com/tencent/wcdb/repair/RepairKit:isDataCorrupted	()Z
    //   492: ifeq +175 -> 667
    //   495: aload 4
    //   497: astore 6
    //   499: new 492	java/lang/RuntimeException
    //   502: dup
    //   503: ldc_w 593
    //   506: invokespecial 594	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   509: astore 5
    //   511: aload 4
    //   513: astore 6
    //   515: sipush 23126
    //   518: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: aload 4
    //   523: astore 6
    //   525: aload 5
    //   527: athrow
    //   528: astore 6
    //   530: sipush 23126
    //   533: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   556: invokevirtual 597	com/tencent/wcdb/repair/RepairKit:release	()V
    //   559: sipush 23126
    //   562: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload 4
    //   567: athrow
    //   568: astore 5
    //   570: ldc 153
    //   572: new 219	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 599
    //   579: invokespecial 441	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 5
    //   584: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   587: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 601
    //   593: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 10
    //   598: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 547
    //   604: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: iload_1
    //   608: invokevirtual 550	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   611: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 603	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: iload_1
    //   618: iconst_1
    //   619: iadd
    //   620: istore_1
    //   621: aload 4
    //   623: astore 5
    //   625: goto -494 -> 131
    //   628: ldc 153
    //   630: ldc_w 605
    //   633: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: iconst_1
    //   637: istore_3
    //   638: aload 4
    //   640: astore 6
    //   642: goto -397 -> 245
    //   645: ldc 153
    //   647: ldc_w 607
    //   650: iload_1
    //   651: invokestatic 575	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   654: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokestatic 559	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: iload_1
    //   661: iconst_1
    //   662: iadd
    //   663: istore_1
    //   664: goto -378 -> 286
    //   667: aload 4
    //   669: astore 6
    //   671: ldc 153
    //   673: ldc_w 609
    //   676: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload 4
    //   681: astore 6
    //   683: aload_0
    //   684: getfield 390	com/tencent/mm/plugin/dbbackup/a/a:oES	Z
    //   687: ifeq +54 -> 741
    //   690: aload 4
    //   692: astore 6
    //   694: aload 9
    //   696: iconst_0
    //   697: iaload
    //   698: i2f
    //   699: aload_0
    //   700: getfield 136	com/tencent/mm/plugin/dbbackup/a/a:oET	I
    //   703: i2f
    //   704: fdiv
    //   705: ldc_w 610
    //   708: fcmpg
    //   709: ifgt +32 -> 741
    //   712: aload 4
    //   714: astore 6
    //   716: getstatic 616	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   719: sipush 181
    //   722: sipush 181
    //   725: bipush 62
    //   727: bipush 63
    //   729: aload_0
    //   730: getfield 136	com/tencent/mm/plugin/dbbackup/a/a:oET	I
    //   733: aload 9
    //   735: iconst_0
    //   736: iaload
    //   737: iconst_1
    //   738: invokevirtual 619	com/tencent/mm/plugin/report/e:a	(IIIIIIZ)V
    //   741: aload 4
    //   743: ifnull +8 -> 751
    //   746: aload 4
    //   748: invokevirtual 597	com/tencent/wcdb/repair/RepairKit:release	()V
    //   751: sipush 23126
    //   754: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   757: iload_1
    //   758: ireturn
    //   759: iload_1
    //   760: iconst_1
    //   761: if_icmpne +99 -> 860
    //   764: aload 4
    //   766: astore 6
    //   768: ldc 153
    //   770: ldc_w 621
    //   773: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   776: aload 4
    //   778: astore 6
    //   780: aload_0
    //   781: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   784: invokevirtual 459	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   787: goto -108 -> 679
    //   790: astore 5
    //   792: aload 4
    //   794: astore 6
    //   796: ldc 153
    //   798: new 219	java/lang/StringBuilder
    //   801: dup
    //   802: ldc_w 623
    //   805: invokespecial 441	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: aload 5
    //   810: invokevirtual 624	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 603	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload 4
    //   824: astore 6
    //   826: iconst_2
    //   827: ldc_w 626
    //   830: iload_3
    //   831: invokestatic 629	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   834: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   837: aload 5
    //   839: invokestatic 487	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   842: aload 4
    //   844: ifnull +8 -> 852
    //   847: aload 4
    //   849: invokevirtual 597	com/tencent/wcdb/repair/RepairKit:release	()V
    //   852: sipush 23126
    //   855: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   858: iconst_m1
    //   859: ireturn
    //   860: aload 4
    //   862: astore 6
    //   864: new 492	java/lang/RuntimeException
    //   867: dup
    //   868: ldc_w 631
    //   871: invokespecial 594	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   874: astore 5
    //   876: aload 4
    //   878: astore 6
    //   880: sipush 23126
    //   883: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  private int bXs()
  {
    // Byte code:
    //   0: sipush 23127
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   10: invokevirtual 459	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   13: ldc 153
    //   15: ldc_w 634
    //   18: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 376	com/tencent/mm/plugin/dbbackup/a/a:oEK	Ljava/util/List;
    //   25: invokeinterface 506 1 0
    //   30: astore 5
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 5
    //   36: invokeinterface 511 1 0
    //   41: ifeq +98 -> 139
    //   44: aload 5
    //   46: invokeinterface 515 1 0
    //   51: checkcast 88	java/lang/String
    //   54: astore 4
    //   56: new 636	com/tencent/wcdb/repair/RecoverKit
    //   59: dup
    //   60: aload_0
    //   61: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: aload 4
    //   66: aload_0
    //   67: getfield 523	com/tencent/mm/plugin/dbbackup/a/a:oEN	Ljava/util/List;
    //   70: iconst_0
    //   71: invokeinterface 530 2 0
    //   76: checkcast 531	[B
    //   79: invokespecial 639	com/tencent/wcdb/repair/RecoverKit:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[B)V
    //   82: astore_3
    //   83: ldc 153
    //   85: ldc_w 641
    //   88: aload 4
    //   90: invokestatic 191	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   96: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_3
    //   100: astore_2
    //   101: goto -67 -> 34
    //   104: astore 4
    //   106: aload_3
    //   107: astore_2
    //   108: aload 4
    //   110: astore_3
    //   111: ldc 153
    //   113: new 219	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 643
    //   120: invokespecial 441	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_3
    //   124: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 603	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -102 -> 34
    //   139: aload_2
    //   140: ifnonnull +11 -> 151
    //   143: sipush 23127
    //   146: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_m1
    //   150: ireturn
    //   151: aload_2
    //   152: iconst_0
    //   153: aload_0
    //   154: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   157: invokevirtual 647	com/tencent/wcdb/repair/RecoverKit:run	(ZLcom/tencent/wcdb/support/CancellationSignal;)I
    //   160: istore_1
    //   161: iload_1
    //   162: ifne +23 -> 185
    //   165: ldc 153
    //   167: ldc_w 649
    //   170: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_2
    //   174: invokevirtual 650	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   177: sipush 23127
    //   180: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iload_1
    //   184: ireturn
    //   185: iload_1
    //   186: iconst_1
    //   187: if_icmpne +43 -> 230
    //   190: ldc 153
    //   192: ldc_w 652
    //   195: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   202: invokevirtual 459	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   205: goto -32 -> 173
    //   208: astore_3
    //   209: sipush 23127
    //   212: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_3
    //   216: athrow
    //   217: astore_3
    //   218: aload_2
    //   219: invokevirtual 650	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   222: sipush 23127
    //   225: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_3
    //   229: athrow
    //   230: ldc 153
    //   232: ldc_w 654
    //   235: invokestatic 603	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -65 -> 173
    //   241: astore_3
    //   242: ldc 153
    //   244: new 219	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 623
    //   251: invokespecial 441	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_3
    //   255: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 603	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: iconst_4
    //   268: ldc_w 656
    //   271: aload_3
    //   272: invokestatic 487	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload_2
    //   276: invokevirtual 650	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   279: sipush 23127
    //   282: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private int bXt()
  {
    AppMethodBeat.i(195995);
    try
    {
      this.oEE.execSQL("DELETE FROM rconversation WHERE typeof(flag) <> 'integer';", null, this.mCancellationSignal);
      AppMethodBeat.o(195995);
      return 0;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      AppMethodBeat.o(195995);
      throw localOperationCanceledException;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.DBRecoveryTask", localException, "Verification failed", new Object[0]);
      AppMethodBeat.o(195995);
    }
    return -1;
  }
  
  /* Error */
  private int bXu()
  {
    // Byte code:
    //   0: ldc_w 664
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 374	com/tencent/mm/plugin/dbbackup/a/a:oEG	Ljava/lang/String;
    //   10: ifnull +13 -> 23
    //   13: aload_0
    //   14: getfield 374	com/tencent/mm/plugin/dbbackup/a/a:oEG	Ljava/lang/String;
    //   17: invokevirtual 150	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc_w 664
    //   26: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: ldc 153
    //   33: ldc_w 666
    //   36: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   43: ldc_w 668
    //   46: aconst_null
    //   47: invokestatic 199	com/tencent/wcdb/DatabaseUtils:longForQuery	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   50: l2i
    //   51: istore_1
    //   52: iconst_1
    //   53: newarray long
    //   55: astore 10
    //   57: aload 10
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: ldc_w 670
    //   67: aconst_null
    //   68: invokestatic 199	com/tencent/wcdb/DatabaseUtils:longForQuery	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   71: lconst_1
    //   72: ladd
    //   73: lastore
    //   74: aload 10
    //   76: iconst_0
    //   77: laload
    //   78: ldc2_w 671
    //   81: lcmp
    //   82: ifle +21 -> 103
    //   85: aload 10
    //   87: iconst_0
    //   88: laload
    //   89: ldc2_w 673
    //   92: lcmp
    //   93: ifgt +10 -> 103
    //   96: aload 10
    //   98: iconst_0
    //   99: ldc2_w 675
    //   102: lastore
    //   103: new 678	java/util/HashMap
    //   106: dup
    //   107: iload_1
    //   108: iload_1
    //   109: iconst_2
    //   110: idiv
    //   111: iadd
    //   112: sipush 10240
    //   115: invokestatic 681	java/lang/Math:max	(II)I
    //   118: invokespecial 682	java/util/HashMap:<init>	(I)V
    //   121: astore 9
    //   123: new 9	com/tencent/mm/plugin/dbbackup/a/a$2
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 685	com/tencent/mm/plugin/dbbackup/a/a$2:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;)V
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 374	com/tencent/mm/plugin/dbbackup/a/a:oEG	Ljava/lang/String;
    //   137: aload_0
    //   138: getfield 378	com/tencent/mm/plugin/dbbackup/a/a:oEM	[B
    //   141: getstatic 86	com/tencent/mm/plugin/dbbackup/a/a:oED	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   144: aconst_null
    //   145: iconst_1
    //   146: aload 4
    //   148: iconst_1
    //   149: invokestatic 689	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   152: astore 4
    //   154: aload_0
    //   155: aload 4
    //   157: ldc_w 353
    //   160: iconst_0
    //   161: iconst_0
    //   162: iconst_0
    //   163: aconst_null
    //   164: invokespecial 691	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   167: pop
    //   168: aload_0
    //   169: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   172: invokevirtual 257	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   175: iconst_3
    //   176: anewarray 157	java/lang/Object
    //   179: astore 5
    //   181: aload 5
    //   183: iconst_0
    //   184: sipush 8197
    //   187: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: aload 5
    //   193: iconst_1
    //   194: iconst_3
    //   195: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: aload 5
    //   201: iconst_2
    //   202: ldc 90
    //   204: aastore
    //   205: aload_0
    //   206: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   209: ldc_w 361
    //   212: aload 5
    //   214: invokevirtual 694	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aload 5
    //   219: iconst_0
    //   220: bipush 15
    //   222: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload 5
    //   228: iconst_1
    //   229: iconst_1
    //   230: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: aastore
    //   234: aload 5
    //   236: iconst_2
    //   237: ldc_w 696
    //   240: aastore
    //   241: aload_0
    //   242: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   245: ldc_w 361
    //   248: aload 5
    //   250: invokevirtual 694	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: aload 5
    //   255: iconst_0
    //   256: bipush 89
    //   258: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: aastore
    //   262: aload 5
    //   264: iconst_1
    //   265: iconst_1
    //   266: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: aload 5
    //   272: iconst_2
    //   273: ldc_w 698
    //   276: aastore
    //   277: aload_0
    //   278: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   281: ldc_w 361
    //   284: aload 5
    //   286: invokevirtual 694	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload_0
    //   290: aload 4
    //   292: iconst_2
    //   293: invokespecial 700	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   296: aload_0
    //   297: aload 4
    //   299: bipush 9
    //   301: invokespecial 700	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   304: aload_0
    //   305: aload 4
    //   307: bipush 42
    //   309: invokespecial 700	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   312: aload_0
    //   313: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   316: invokevirtual 330	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   319: aload_0
    //   320: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   323: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   326: aload 4
    //   328: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   331: ldc_w 702
    //   334: aconst_null
    //   335: ldc_w 403
    //   338: invokevirtual 705	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   341: astore 8
    //   343: aload 8
    //   345: astore 5
    //   347: aload 8
    //   349: astore 6
    //   351: aload 8
    //   353: astore 7
    //   355: aload 8
    //   357: ldc_w 707
    //   360: invokeinterface 710 2 0
    //   365: istore_1
    //   366: aload 8
    //   368: astore 5
    //   370: aload 8
    //   372: astore 6
    //   374: aload 8
    //   376: astore 7
    //   378: aload 8
    //   380: invokeinterface 287 1 0
    //   385: aload 8
    //   387: astore 5
    //   389: aload 8
    //   391: astore 6
    //   393: aload 8
    //   395: astore 7
    //   397: aload_0
    //   398: aload 4
    //   400: ldc_w 403
    //   403: iconst_4
    //   404: iconst_1
    //   405: iconst_5
    //   406: new 11	com/tencent/mm/plugin/dbbackup/a/a$3
    //   409: dup
    //   410: aload_0
    //   411: iload_1
    //   412: aload 10
    //   414: aload 9
    //   416: invokespecial 713	com/tencent/mm/plugin/dbbackup/a/a$3:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;I[JLjava/util/HashMap;)V
    //   419: invokespecial 691	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   422: pop
    //   423: aload 8
    //   425: astore 5
    //   427: aload 8
    //   429: astore 6
    //   431: aload 8
    //   433: astore 7
    //   435: aload_0
    //   436: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   439: ldc_w 715
    //   442: aconst_null
    //   443: aload_0
    //   444: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   447: invokevirtual 185	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   450: aload 8
    //   452: astore 5
    //   454: aload 8
    //   456: astore 6
    //   458: aload 8
    //   460: astore 7
    //   462: aload 4
    //   464: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   467: ldc_w 717
    //   470: aconst_null
    //   471: ldc_w 500
    //   474: invokevirtual 705	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   477: astore 8
    //   479: aload 8
    //   481: astore 5
    //   483: aload 4
    //   485: astore 8
    //   487: aload 5
    //   489: astore 7
    //   491: aload 5
    //   493: ldc_w 719
    //   496: invokeinterface 710 2 0
    //   501: istore_1
    //   502: aload 4
    //   504: astore 8
    //   506: aload 5
    //   508: astore 7
    //   510: aload 5
    //   512: ldc_w 721
    //   515: invokeinterface 710 2 0
    //   520: istore_2
    //   521: aload 4
    //   523: astore 8
    //   525: aload 5
    //   527: astore 7
    //   529: aload 5
    //   531: ldc_w 723
    //   534: invokeinterface 710 2 0
    //   539: istore_3
    //   540: aload 4
    //   542: astore 8
    //   544: aload 5
    //   546: astore 7
    //   548: iconst_1
    //   549: anewarray 88	java/lang/String
    //   552: astore 6
    //   554: aload 4
    //   556: astore 8
    //   558: aload 5
    //   560: astore 7
    //   562: aload 5
    //   564: invokeinterface 287 1 0
    //   569: aload 4
    //   571: astore 8
    //   573: aload 5
    //   575: astore 7
    //   577: aload_0
    //   578: aload 4
    //   580: ldc_w 500
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
    //   596: invokespecial 726	com/tencent/mm/plugin/dbbackup/a/a$4:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;I[Ljava/lang/String;II)V
    //   599: invokespecial 691	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   602: pop
    //   603: aload 4
    //   605: astore 8
    //   607: aload 5
    //   609: astore 7
    //   611: aload 4
    //   613: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   616: ldc_w 728
    //   619: aconst_null
    //   620: ldc_w 494
    //   623: invokevirtual 705	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
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
    //   646: ldc_w 730
    //   649: invokeinterface 710 2 0
    //   654: istore_1
    //   655: aload 8
    //   657: astore 5
    //   659: aload 8
    //   661: astore 6
    //   663: aload 8
    //   665: astore 7
    //   667: aload 8
    //   669: invokeinterface 287 1 0
    //   674: aload 8
    //   676: astore 5
    //   678: aload 8
    //   680: astore 6
    //   682: aload 8
    //   684: astore 7
    //   686: aload_0
    //   687: aload 4
    //   689: ldc_w 494
    //   692: iconst_4
    //   693: iconst_1
    //   694: iconst_0
    //   695: new 15	com/tencent/mm/plugin/dbbackup/a/a$5
    //   698: dup
    //   699: aload_0
    //   700: iload_1
    //   701: aload 9
    //   703: invokespecial 733	com/tencent/mm/plugin/dbbackup/a/a$5:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   706: invokespecial 691	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   709: pop
    //   710: aload 8
    //   712: astore 5
    //   714: aload 8
    //   716: astore 6
    //   718: aload 8
    //   720: astore 7
    //   722: aload 4
    //   724: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   727: ldc_w 735
    //   730: aconst_null
    //   731: ldc_w 496
    //   734: invokevirtual 705	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   737: astore 8
    //   739: aload 8
    //   741: astore 5
    //   743: aload 8
    //   745: astore 6
    //   747: aload 8
    //   749: astore 7
    //   751: aload 8
    //   753: ldc_w 730
    //   756: invokeinterface 710 2 0
    //   761: istore_1
    //   762: aload 8
    //   764: astore 5
    //   766: aload 8
    //   768: astore 6
    //   770: aload 8
    //   772: astore 7
    //   774: aload 8
    //   776: invokeinterface 287 1 0
    //   781: aload 8
    //   783: astore 5
    //   785: aload 8
    //   787: astore 6
    //   789: aload 8
    //   791: astore 7
    //   793: aload_0
    //   794: aload 4
    //   796: ldc_w 496
    //   799: iconst_4
    //   800: iconst_1
    //   801: iconst_0
    //   802: new 17	com/tencent/mm/plugin/dbbackup/a/a$6
    //   805: dup
    //   806: aload_0
    //   807: iload_1
    //   808: aload 9
    //   810: invokespecial 736	com/tencent/mm/plugin/dbbackup/a/a$6:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   813: invokespecial 691	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   816: pop
    //   817: aload 8
    //   819: ifnull +20 -> 839
    //   822: aload 8
    //   824: invokeinterface 284 1 0
    //   829: ifne +10 -> 839
    //   832: aload 8
    //   834: invokeinterface 287 1 0
    //   839: aload_0
    //   840: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   843: invokevirtual 170	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   846: ifeq +10 -> 856
    //   849: aload_0
    //   850: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   853: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   856: aload 4
    //   858: ifnull +8 -> 866
    //   861: aload 4
    //   863: invokevirtual 456	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   866: ldc_w 664
    //   869: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: iconst_0
    //   873: ireturn
    //   874: astore 5
    //   876: aconst_null
    //   877: astore 4
    //   879: aconst_null
    //   880: astore 6
    //   882: ldc 153
    //   884: ldc_w 738
    //   887: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   890: ldc_w 664
    //   893: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   896: aload 5
    //   898: athrow
    //   899: astore 5
    //   901: aload 4
    //   903: ifnull +20 -> 923
    //   906: aload 4
    //   908: invokeinterface 284 1 0
    //   913: ifne +10 -> 923
    //   916: aload 4
    //   918: invokeinterface 287 1 0
    //   923: aload_0
    //   924: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   927: invokevirtual 170	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   930: ifeq +10 -> 940
    //   933: aload_0
    //   934: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   937: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   940: aload 6
    //   942: ifnull +8 -> 950
    //   945: aload 6
    //   947: invokevirtual 456	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   950: ldc_w 664
    //   953: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   975: ldc 153
    //   977: new 219	java/lang/StringBuilder
    //   980: dup
    //   981: ldc_w 740
    //   984: invokespecial 441	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   987: aload 6
    //   989: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   992: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: invokestatic 603	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1001: aload 9
    //   1003: astore 8
    //   1005: aload 4
    //   1007: astore 7
    //   1009: iconst_5
    //   1010: new 219	java/lang/StringBuilder
    //   1013: dup
    //   1014: ldc_w 742
    //   1017: invokespecial 441	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1020: aload_0
    //   1021: getfield 368	com/tencent/mm/plugin/dbbackup/a/a:oEQ	Z
    //   1024: invokevirtual 745	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: aload 6
    //   1032: invokestatic 487	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1035: aload 4
    //   1037: ifnull +20 -> 1057
    //   1040: aload 4
    //   1042: invokeinterface 284 1 0
    //   1047: ifne +10 -> 1057
    //   1050: aload 4
    //   1052: invokeinterface 287 1 0
    //   1057: aload_0
    //   1058: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1061: invokevirtual 170	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1064: ifeq +10 -> 1074
    //   1067: aload_0
    //   1068: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:oEE	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1071: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1074: aload 9
    //   1076: ifnull +8 -> 1084
    //   1079: aload 9
    //   1081: invokevirtual 456	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1084: ldc_w 664
    //   1087: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  @SuppressLint({"DefaultLocale"})
  private static void c(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(23132);
    com.tencent.mm.plugin.report.e.wTc.g("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[] { Integer.valueOf(paramInt), paramString, "\n" + bs.m(paramThrowable) }), null);
    AppMethodBeat.o(23132);
  }
  
  private int jD(boolean paramBoolean)
  {
    AppMethodBeat.i(23125);
    ac.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.oEF);
    if (this.oEE == null)
    {
      AppMethodBeat.o(23125);
      return -1;
    }
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(this.oEE.getPath());
    if (this.oEE.isOpen()) {
      this.oEE.close();
    }
    if (paramBoolean)
    {
      if (!locale.ae(new com.tencent.mm.vfs.e(this.oEF)))
      {
        ac.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", new Object[] { locale, this.oEF });
        AppMethodBeat.o(23125);
        return -1;
      }
    }
    else
    {
      ac.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", new Object[] { locale });
      locale.delete();
    }
    AppMethodBeat.o(23125);
    return 0;
  }
  
  private static void kW(int paramInt)
  {
    AppMethodBeat.i(23131);
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(181L, paramInt, 1L, true);
    AppMethodBeat.o(23131);
  }
  
  /* Error */
  private Integer qh()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: sipush 23121
    //   9: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: bipush 54
    //   14: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   17: iconst_m1
    //   18: istore 4
    //   20: invokestatic 802	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   23: ldc_w 804
    //   26: invokevirtual 810	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 812	android/os/PowerManager
    //   32: iconst_1
    //   33: ldc_w 814
    //   36: invokevirtual 818	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   39: astore 12
    //   41: invokestatic 823	android/os/SystemClock:uptimeMillis	()J
    //   44: lstore 7
    //   46: aload 12
    //   48: ldc2_w 824
    //   51: invokevirtual 831	android/os/PowerManager$WakeLock:acquire	(J)V
    //   54: iload 4
    //   56: istore_1
    //   57: iload 4
    //   59: istore_2
    //   60: iload 4
    //   62: istore_3
    //   63: aload_0
    //   64: iconst_1
    //   65: anewarray 262	java/lang/Integer
    //   68: dup
    //   69: iconst_0
    //   70: iconst_1
    //   71: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokevirtual 269	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   78: iload 4
    //   80: istore_1
    //   81: iload 4
    //   83: istore_2
    //   84: iload 4
    //   86: istore_3
    //   87: aload_0
    //   88: invokespecial 833	com/tencent/mm/plugin/dbbackup/a/a:bXp	()I
    //   91: istore 4
    //   93: iload 4
    //   95: ifeq +120 -> 215
    //   98: iload 4
    //   100: tableswitch	default:+32 -> 132, -2:+107->207, -1:+32->132, 0:+62->162, 1:+99->199
    //   133: dstore 184
    //   135: iconst_0
    //   136: iload_2
    //   137: aload 12
    //   139: invokevirtual 836	android/os/PowerManager$WakeLock:isHeld	()Z
    //   142: ifeq +8 -> 150
    //   145: aload 12
    //   147: invokevirtual 837	android/os/PowerManager$WakeLock:release	()V
    //   150: sipush 23121
    //   153: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iload 4
    //   158: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: areturn
    //   162: invokestatic 823	android/os/SystemClock:uptimeMillis	()J
    //   165: lstore 9
    //   167: bipush 55
    //   169: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   172: getstatic 616	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   175: ldc2_w 787
    //   178: ldc2_w 838
    //   181: lload 9
    //   183: lload 7
    //   185: lsub
    //   186: ldc2_w 840
    //   189: ldiv
    //   190: lconst_1
    //   191: ladd
    //   192: iconst_1
    //   193: invokevirtual 792	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   196: goto -59 -> 137
    //   199: bipush 56
    //   201: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   204: goto -67 -> 137
    //   207: bipush 58
    //   209: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   212: goto -75 -> 137
    //   215: iload 4
    //   217: istore_1
    //   218: iload 4
    //   220: istore_2
    //   221: iload 4
    //   223: istore_3
    //   224: aload_0
    //   225: getfield 336	com/tencent/mm/plugin/dbbackup/a/a:oEP	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   228: ifnull +102 -> 330
    //   231: iload 4
    //   233: istore_1
    //   234: iload 4
    //   236: istore_2
    //   237: iload 4
    //   239: istore_3
    //   240: ldc 153
    //   242: ldc_w 843
    //   245: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: iload 4
    //   250: istore_1
    //   251: iload 4
    //   253: istore_2
    //   254: iload 4
    //   256: istore_3
    //   257: aload_0
    //   258: getfield 336	com/tencent/mm/plugin/dbbackup/a/a:oEP	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   261: invokeinterface 847 1 0
    //   266: astore 11
    //   268: iload 4
    //   270: istore_1
    //   271: iload 4
    //   273: istore_2
    //   274: iload 4
    //   276: istore_3
    //   277: aload_0
    //   278: getfield 523	com/tencent/mm/plugin/dbbackup/a/a:oEN	Ljava/util/List;
    //   281: aload 11
    //   283: invokeinterface 851 2 0
    //   288: pop
    //   289: iload 4
    //   291: istore_1
    //   292: iload 4
    //   294: istore_2
    //   295: iload 4
    //   297: istore_3
    //   298: aload_0
    //   299: getfield 336	com/tencent/mm/plugin/dbbackup/a/a:oEP	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   302: invokeinterface 854 1 0
    //   307: astore 11
    //   309: iload 4
    //   311: istore_1
    //   312: iload 4
    //   314: istore_2
    //   315: iload 4
    //   317: istore_3
    //   318: aload_0
    //   319: getfield 563	com/tencent/mm/plugin/dbbackup/a/a:oEO	Ljava/util/List;
    //   322: aload 11
    //   324: invokeinterface 851 2 0
    //   329: pop
    //   330: iload 4
    //   332: istore_1
    //   333: iload 4
    //   335: istore_2
    //   336: iload 4
    //   338: istore_3
    //   339: aload_0
    //   340: getfield 523	com/tencent/mm/plugin/dbbackup/a/a:oEN	Ljava/util/List;
    //   343: invokeinterface 855 1 0
    //   348: ifeq +23 -> 371
    //   351: iload 4
    //   353: istore_1
    //   354: iload 4
    //   356: istore_2
    //   357: iload 4
    //   359: istore_3
    //   360: aload_0
    //   361: getfield 523	com/tencent/mm/plugin/dbbackup/a/a:oEN	Ljava/util/List;
    //   364: aconst_null
    //   365: invokeinterface 859 2 0
    //   370: pop
    //   371: iload 4
    //   373: istore_1
    //   374: iload 4
    //   376: istore_2
    //   377: iload 4
    //   379: istore_3
    //   380: aload_0
    //   381: getfield 563	com/tencent/mm/plugin/dbbackup/a/a:oEO	Ljava/util/List;
    //   384: invokeinterface 855 1 0
    //   389: ifeq +23 -> 412
    //   392: iload 4
    //   394: istore_1
    //   395: iload 4
    //   397: istore_2
    //   398: iload 4
    //   400: istore_3
    //   401: aload_0
    //   402: getfield 563	com/tencent/mm/plugin/dbbackup/a/a:oEO	Ljava/util/List;
    //   405: aconst_null
    //   406: invokeinterface 859 2 0
    //   411: pop
    //   412: iload 6
    //   414: istore_2
    //   415: aload_0
    //   416: invokespecial 861	com/tencent/mm/plugin/dbbackup/a/a:bXq	()I
    //   419: istore_1
    //   420: iload_1
    //   421: istore_2
    //   422: iload_2
    //   423: istore_1
    //   424: iload_2
    //   425: istore_3
    //   426: iload_2
    //   427: istore 4
    //   429: aload_0
    //   430: iconst_1
    //   431: anewarray 262	java/lang/Integer
    //   434: dup
    //   435: iconst_0
    //   436: iconst_2
    //   437: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: invokevirtual 269	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   444: iload_2
    //   445: istore_1
    //   446: iload_2
    //   447: istore_3
    //   448: iload_2
    //   449: istore 4
    //   451: aload_0
    //   452: invokespecial 863	com/tencent/mm/plugin/dbbackup/a/a:bXr	()I
    //   455: istore_2
    //   456: iload_2
    //   457: istore 4
    //   459: iload 4
    //   461: iconst_1
    //   462: if_icmpne +117 -> 579
    //   465: iload 4
    //   467: tableswitch	default:+29 -> 496, -2:+104->571, -1:+29->496, 0:+59->526, 1:+96->563
    //   497: dstore 184
    //   499: iconst_0
    //   500: iload_2
    //   501: aload 12
    //   503: invokevirtual 836	android/os/PowerManager$WakeLock:isHeld	()Z
    //   506: ifeq +8 -> 514
    //   509: aload 12
    //   511: invokevirtual 837	android/os/PowerManager$WakeLock:release	()V
    //   514: sipush 23121
    //   517: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   520: iload 4
    //   522: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: areturn
    //   526: invokestatic 823	android/os/SystemClock:uptimeMillis	()J
    //   529: lstore 9
    //   531: bipush 55
    //   533: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   536: getstatic 616	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   539: ldc2_w 787
    //   542: ldc2_w 838
    //   545: lload 9
    //   547: lload 7
    //   549: lsub
    //   550: ldc2_w 840
    //   553: ldiv
    //   554: lconst_1
    //   555: ladd
    //   556: iconst_1
    //   557: invokevirtual 792	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   560: goto -59 -> 501
    //   563: bipush 56
    //   565: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   568: goto -67 -> 501
    //   571: bipush 58
    //   573: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   576: goto -75 -> 501
    //   579: iload 4
    //   581: istore 5
    //   583: iload 4
    //   585: iconst_m1
    //   586: if_icmpne +42 -> 628
    //   589: iload 4
    //   591: istore_1
    //   592: iload 4
    //   594: istore_2
    //   595: iload 4
    //   597: istore_3
    //   598: aload_0
    //   599: iconst_1
    //   600: anewarray 262	java/lang/Integer
    //   603: dup
    //   604: iconst_0
    //   605: iconst_4
    //   606: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   609: aastore
    //   610: invokevirtual 269	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   613: iload 4
    //   615: istore_1
    //   616: iload 4
    //   618: istore_2
    //   619: iload 4
    //   621: istore_3
    //   622: aload_0
    //   623: invokespecial 865	com/tencent/mm/plugin/dbbackup/a/a:bXs	()I
    //   626: istore 5
    //   628: iload 5
    //   630: ifeq +117 -> 747
    //   633: iload 5
    //   635: tableswitch	default:+29 -> 664, -2:+104->739, -1:+29->664, 0:+59->694, 1:+96->731
    //   665: dstore 184
    //   667: iconst_0
    //   668: iload_2
    //   669: aload 12
    //   671: invokevirtual 836	android/os/PowerManager$WakeLock:isHeld	()Z
    //   674: ifeq +8 -> 682
    //   677: aload 12
    //   679: invokevirtual 837	android/os/PowerManager$WakeLock:release	()V
    //   682: sipush 23121
    //   685: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: iload 5
    //   690: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   693: areturn
    //   694: invokestatic 823	android/os/SystemClock:uptimeMillis	()J
    //   697: lstore 9
    //   699: bipush 55
    //   701: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   704: getstatic 616	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   707: ldc2_w 787
    //   710: ldc2_w 838
    //   713: lload 9
    //   715: lload 7
    //   717: lsub
    //   718: ldc2_w 840
    //   721: ldiv
    //   722: lconst_1
    //   723: ladd
    //   724: iconst_1
    //   725: invokevirtual 792	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   728: goto -59 -> 669
    //   731: bipush 56
    //   733: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   736: goto -67 -> 669
    //   739: bipush 58
    //   741: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   744: goto -75 -> 669
    //   747: iload 5
    //   749: istore_1
    //   750: iload 5
    //   752: istore_2
    //   753: iload 5
    //   755: istore_3
    //   756: aload_0
    //   757: iconst_1
    //   758: anewarray 262	java/lang/Integer
    //   761: dup
    //   762: iconst_0
    //   763: iconst_5
    //   764: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   767: aastore
    //   768: invokevirtual 269	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   771: iload 5
    //   773: istore_1
    //   774: iload 5
    //   776: istore_2
    //   777: iload 5
    //   779: istore_3
    //   780: aload_0
    //   781: invokespecial 867	com/tencent/mm/plugin/dbbackup/a/a:bXt	()I
    //   784: pop
    //   785: iload 5
    //   787: istore_1
    //   788: iload 5
    //   790: istore_2
    //   791: iload 5
    //   793: istore_3
    //   794: aload_0
    //   795: invokespecial 869	com/tencent/mm/plugin/dbbackup/a/a:bXu	()I
    //   798: istore 4
    //   800: iload 4
    //   802: istore_2
    //   803: iload_2
    //   804: istore_1
    //   805: iload_2
    //   806: istore_3
    //   807: iload_2
    //   808: istore 4
    //   810: aload_0
    //   811: iconst_1
    //   812: anewarray 262	java/lang/Integer
    //   815: dup
    //   816: iconst_0
    //   817: bipush 6
    //   819: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   822: aastore
    //   823: invokevirtual 269	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   826: iload_2
    //   827: istore_1
    //   828: iload_2
    //   829: istore_3
    //   830: iload_2
    //   831: istore 4
    //   833: aload_0
    //   834: iconst_1
    //   835: invokespecial 871	com/tencent/mm/plugin/dbbackup/a/a:jD	(Z)I
    //   838: istore_2
    //   839: iload_2
    //   840: tableswitch	default:+32 -> 872, -2:+106->946, -1:+32->872, 0:+61->901, 1:+98->938
    //   873: dstore 184
    //   875: iconst_0
    //   876: iload_2
    //   877: aload 12
    //   879: invokevirtual 836	android/os/PowerManager$WakeLock:isHeld	()Z
    //   882: ifeq +8 -> 890
    //   885: aload 12
    //   887: invokevirtual 837	android/os/PowerManager$WakeLock:release	()V
    //   890: sipush 23121
    //   893: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   896: iload_2
    //   897: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   900: areturn
    //   901: invokestatic 823	android/os/SystemClock:uptimeMillis	()J
    //   904: lstore 9
    //   906: bipush 55
    //   908: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   911: getstatic 616	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   914: ldc2_w 787
    //   917: ldc2_w 838
    //   920: lload 9
    //   922: lload 7
    //   924: lsub
    //   925: ldc2_w 840
    //   928: ldiv
    //   929: lconst_1
    //   930: ladd
    //   931: iconst_1
    //   932: invokevirtual 792	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   935: goto -58 -> 877
    //   938: bipush 56
    //   940: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   943: goto -66 -> 877
    //   946: bipush 58
    //   948: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   951: goto -74 -> 877
    //   954: astore 11
    //   956: iload_1
    //   957: istore_2
    //   958: iload_2
    //   959: istore_1
    //   960: ldc 153
    //   962: ldc_w 873
    //   965: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   968: iload_2
    //   969: istore_1
    //   970: aload_0
    //   971: iconst_0
    //   972: invokespecial 871	com/tencent/mm/plugin/dbbackup/a/a:jD	(Z)I
    //   975: pop
    //   976: bipush 56
    //   978: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   981: aload 12
    //   983: invokevirtual 836	android/os/PowerManager$WakeLock:isHeld	()Z
    //   986: ifeq +8 -> 994
    //   989: aload 12
    //   991: invokevirtual 837	android/os/PowerManager$WakeLock:release	()V
    //   994: sipush 23121
    //   997: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1000: iconst_1
    //   1001: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1004: areturn
    //   1005: astore 11
    //   1007: iload_2
    //   1008: istore_1
    //   1009: iload_1
    //   1010: istore_2
    //   1011: ldc 153
    //   1013: aload 11
    //   1015: ldc_w 875
    //   1018: iconst_0
    //   1019: anewarray 157	java/lang/Object
    //   1022: invokestatic 447	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1025: iload_1
    //   1026: istore_2
    //   1027: aload_0
    //   1028: iconst_0
    //   1029: invokespecial 871	com/tencent/mm/plugin/dbbackup/a/a:jD	(Z)I
    //   1032: pop
    //   1033: iconst_m1
    //   1034: istore_1
    //   1035: bipush 57
    //   1037: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   1040: aload 12
    //   1042: invokevirtual 836	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1045: ifeq +8 -> 1053
    //   1048: aload 12
    //   1050: invokevirtual 837	android/os/PowerManager$WakeLock:release	()V
    //   1053: sipush 23121
    //   1056: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1059: iconst_m1
    //   1060: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1063: areturn
    //   1064: astore 11
    //   1066: iload_3
    //   1067: istore_2
    //   1068: iload_2
    //   1069: tableswitch	default:+31 -> 1100, -2:+103->1172, -1:+31->1100, 0:+58->1127, 1:+95->1164
    //   1101: dstore 184
    //   1103: iconst_0
    //   1104: iload_2
    //   1105: aload 12
    //   1107: invokevirtual 836	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1110: ifeq +8 -> 1118
    //   1113: aload 12
    //   1115: invokevirtual 837	android/os/PowerManager$WakeLock:release	()V
    //   1118: sipush 23121
    //   1121: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1124: aload 11
    //   1126: athrow
    //   1127: invokestatic 823	android/os/SystemClock:uptimeMillis	()J
    //   1130: lstore 9
    //   1132: bipush 55
    //   1134: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   1137: getstatic 616	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   1140: ldc2_w 787
    //   1143: ldc2_w 838
    //   1146: lload 9
    //   1148: lload 7
    //   1150: lsub
    //   1151: ldc2_w 840
    //   1154: ldiv
    //   1155: lconst_1
    //   1156: ladd
    //   1157: iconst_1
    //   1158: invokevirtual 792	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   1161: goto -56 -> 1105
    //   1164: bipush 56
    //   1166: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   1169: goto -64 -> 1105
    //   1172: bipush 58
    //   1174: invokestatic 796	com/tencent/mm/plugin/dbbackup/a/a:kW	(I)V
    //   1177: goto -72 -> 1105
    //   1180: astore 11
    //   1182: goto -114 -> 1068
    //   1185: astore 11
    //   1187: iload_1
    //   1188: istore_2
    //   1189: goto -121 -> 1068
    //   1192: astore 11
    //   1194: iconst_1
    //   1195: istore_1
    //   1196: goto -128 -> 1068
    //   1199: astore 11
    //   1201: iload 5
    //   1203: istore_1
    //   1204: goto -195 -> 1009
    //   1207: astore 11
    //   1209: iload_3
    //   1210: istore_1
    //   1211: goto -202 -> 1009
    //   1214: astore 11
    //   1216: iconst_0
    //   1217: istore_2
    //   1218: goto -260 -> 958
    //   1221: astore 11
    //   1223: iload 4
    //   1225: istore_2
    //   1226: goto -268 -> 958
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1229	0	this	a
    //   56	1132	1	i	int
    //   59	1130	2	j	int
    //   62	1005	3	k	int
    //   18	814	4	m	int
    //   4	788	5	n	int
    //   1	412	6	i1	int
    //   44	1105	7	l1	long
    //   165	982	9	l2	long
    //   266	57	11	localCollection	Collection
    //   954	1	11	localOperationCanceledException	OperationCanceledException
    //   1005	9	11	localException	Exception
    //   1064	61	11	localObject1	Object
    //   1180	1	11	localObject2	Object
    //   1185	1	11	localObject3	Object
    //   39	1075	12	localWakeLock	android.os.PowerManager.WakeLock
    // Exception table:
    //   from	to	target	type
    //   63	78	954	com/tencent/wcdb/support/OperationCanceledException
    //   87	93	954	com/tencent/wcdb/support/OperationCanceledException
    //   224	231	954	com/tencent/wcdb/support/OperationCanceledException
    //   240	248	954	com/tencent/wcdb/support/OperationCanceledException
    //   257	268	954	com/tencent/wcdb/support/OperationCanceledException
    //   277	289	954	com/tencent/wcdb/support/OperationCanceledException
    //   298	309	954	com/tencent/wcdb/support/OperationCanceledException
    //   318	330	954	com/tencent/wcdb/support/OperationCanceledException
    //   339	351	954	com/tencent/wcdb/support/OperationCanceledException
    //   360	371	954	com/tencent/wcdb/support/OperationCanceledException
    //   380	392	954	com/tencent/wcdb/support/OperationCanceledException
    //   401	412	954	com/tencent/wcdb/support/OperationCanceledException
    //   598	613	954	com/tencent/wcdb/support/OperationCanceledException
    //   622	628	954	com/tencent/wcdb/support/OperationCanceledException
    //   756	771	954	com/tencent/wcdb/support/OperationCanceledException
    //   780	785	954	com/tencent/wcdb/support/OperationCanceledException
    //   794	800	954	com/tencent/wcdb/support/OperationCanceledException
    //   63	78	1005	java/lang/Exception
    //   87	93	1005	java/lang/Exception
    //   224	231	1005	java/lang/Exception
    //   240	248	1005	java/lang/Exception
    //   257	268	1005	java/lang/Exception
    //   277	289	1005	java/lang/Exception
    //   298	309	1005	java/lang/Exception
    //   318	330	1005	java/lang/Exception
    //   339	351	1005	java/lang/Exception
    //   360	371	1005	java/lang/Exception
    //   380	392	1005	java/lang/Exception
    //   401	412	1005	java/lang/Exception
    //   598	613	1005	java/lang/Exception
    //   622	628	1005	java/lang/Exception
    //   756	771	1005	java/lang/Exception
    //   780	785	1005	java/lang/Exception
    //   794	800	1005	java/lang/Exception
    //   63	78	1064	finally
    //   87	93	1064	finally
    //   224	231	1064	finally
    //   240	248	1064	finally
    //   257	268	1064	finally
    //   277	289	1064	finally
    //   298	309	1064	finally
    //   318	330	1064	finally
    //   339	351	1064	finally
    //   360	371	1064	finally
    //   380	392	1064	finally
    //   401	412	1064	finally
    //   598	613	1064	finally
    //   622	628	1064	finally
    //   756	771	1064	finally
    //   780	785	1064	finally
    //   794	800	1064	finally
    //   415	420	1180	finally
    //   1011	1025	1180	finally
    //   1027	1033	1180	finally
    //   429	444	1185	finally
    //   451	456	1185	finally
    //   810	826	1185	finally
    //   833	839	1185	finally
    //   960	968	1185	finally
    //   970	976	1185	finally
    //   415	420	1199	java/lang/Exception
    //   429	444	1207	java/lang/Exception
    //   451	456	1207	java/lang/Exception
    //   810	826	1207	java/lang/Exception
    //   833	839	1207	java/lang/Exception
    //   415	420	1214	com/tencent/wcdb/support/OperationCanceledException
    //   429	444	1221	com/tencent/wcdb/support/OperationCanceledException
    //   451	456	1221	com/tencent/wcdb/support/OperationCanceledException
    //   810	826	1221	com/tencent/wcdb/support/OperationCanceledException
    //   833	839	1221	com/tencent/wcdb/support/OperationCanceledException
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(23122);
    this.mCancellationSignal.cancel();
    ac.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
    AppMethodBeat.o(23122);
  }
  
  public static final class a
  {
    public String oEF;
    public String oEG;
    public String oEH;
    public String oEI;
    private List<String> oEJ;
    private List<String> oEK;
    private byte[] oEL;
    private byte[] oEM;
    public a.c oEP;
    public boolean oEQ;
    public a.b oER;
    private LinkedHashSet<byte[]> oFj;
    private LinkedHashSet<byte[]> oFk;
    
    public a()
    {
      AppMethodBeat.i(23114);
      this.oEJ = new ArrayList();
      this.oEK = new ArrayList();
      this.oFj = new LinkedHashSet();
      this.oFk = new LinkedHashSet();
      AppMethodBeat.o(23114);
    }
    
    public final a Wp(String paramString)
    {
      AppMethodBeat.i(23116);
      this.oEJ.add(paramString);
      AppMethodBeat.o(23116);
      return this;
    }
    
    public final a Wq(String paramString)
    {
      AppMethodBeat.i(23117);
      this.oEK.add(paramString);
      AppMethodBeat.o(23117);
      return this;
    }
    
    public final a aS(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(23118);
      this.oEL = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(23118);
      return this;
    }
    
    public final a aT(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(23119);
      this.oEM = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(23119);
      return this;
    }
    
    public final a bXv()
    {
      AppMethodBeat.i(23115);
      a locala = new a((byte)0);
      a.a(locala, this.oEF);
      a.b(locala, this.oEG);
      a.c(locala, this.oEH);
      a.d(locala, this.oEI);
      a.a(locala, new ArrayList(this.oEJ));
      a.b(locala, new ArrayList(this.oEK));
      a.a(locala, this.oEL);
      a.b(locala, this.oEM);
      a.a(locala, this.oEP);
      a.c(locala, new ArrayList(this.oFj));
      a.d(locala, new ArrayList(this.oFk));
      a.a(locala, this.oEQ);
      a.a(locala, this.oER);
      AppMethodBeat.o(23115);
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void J(long paramLong1, long paramLong2);
    
    public abstract void U(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onCanceled();
    
    public abstract void onFailure();
    
    public abstract void onSuccess();
  }
  
  public static abstract interface c
  {
    public abstract Collection<byte[]> bXh();
    
    public abstract Collection<byte[]> bXi();
  }
  
  static abstract interface d
  {
    public abstract boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a
 * JD-Core Version:    0.7.0.1
 */