package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final SQLiteCipherSpec obe;
  private final CancellationSignal mCancellationSignal;
  private SQLiteDatabase obf;
  private String obg;
  private String obh;
  private String obi;
  private String obk;
  private List<String> obl;
  private List<String> obm;
  private byte[] obn;
  private byte[] obo;
  private List<byte[]> obp;
  private List<byte[]> obq;
  private c obr;
  private boolean obs;
  private b obt;
  private boolean obu;
  private int obv;
  private long obw;
  private long obx;
  
  static
  {
    AppMethodBeat.i(23138);
    obe = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    CONFLICT_VALUES = new String[] { "", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE" };
    AppMethodBeat.o(23138);
  }
  
  private a()
  {
    AppMethodBeat.i(23120);
    this.mCancellationSignal = new CancellationSignal();
    AppMethodBeat.o(23120);
  }
  
  private static long Sc(String paramString)
  {
    AppMethodBeat.i(23130);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString);
    paramString = locale;
    if (!locale.isDirectory()) {
      paramString = locale.fhT();
    }
    do
    {
      long l = paramString.getUsableSpace();
      if (l > 0L)
      {
        AppMethodBeat.o(23130);
        return l;
      }
      locale = paramString.fhT();
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
      ad.e("MicroMsg.DBRecoveryTask", "There is no table named '%s' to copy.", new Object[] { paramString });
      if (this.obf.inTransaction()) {
        this.obf.endTransaction();
      }
      AppMethodBeat.o(23129);
      return -1;
      localObject = ((String)localObject).replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS ");
      this.obf.execSQL((String)localObject, null, this.mCancellationSignal);
      if (!paramBoolean)
      {
        if (this.obf.inTransaction()) {
          this.obf.endTransaction();
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
          paramString = this.obf.compileStatement(localStringBuilder.toString());
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
          this.obf.beginTransaction();
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
        if (this.obf.inTransaction()) {
          this.obf.endTransaction();
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
        if (paramd != null) {
          paramd.a((Cursor)localObject, paramString);
        }
        paramString.executeInsert(this.mCancellationSignal);
        paramInt1 += 1;
      }
      this.obf.setTransactionSuccessful();
      if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
        ((Cursor)localObject).close();
      }
      if (this.obf.inTransaction()) {
        this.obf.endTransaction();
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
  
  private int bPZ()
  {
    long l2 = 0L;
    AppMethodBeat.i(23123);
    ad.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
    if ((this.obg == null) || (this.obg.isEmpty()))
    {
      AppMethodBeat.o(23123);
      return -1;
    }
    this.obu = false;
    this.obv = 300000;
    if (this.obk != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(i.aMP(this.obk));
        this.obv = localJSONObject.getInt("message");
        this.obu = true;
        l1 = localJSONObject.getLong("dbSize");
        if (this.obi != null) {
          l2 = i.aMN(this.obi);
        }
        this.obw = Math.max(l1, l2);
        this.obw += Math.max(this.obw / 10L, 67108864L);
        this.obx = Sc(this.obg);
        if (this.obw <= this.obx) {
          break;
        }
        ad.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[] { Long.valueOf(this.obw), Long.valueOf(this.obx) });
        AppMethodBeat.o(23123);
        return -2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        ad.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.obk);
        l1 = 0L;
        continue;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.DBRecoveryTask", localException, "Cannot read statistics from file.", new Object[0]);
      }
      long l1 = 0L;
    }
    ad.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", new Object[] { Long.valueOf(this.obw), Long.valueOf(this.obx), Integer.valueOf(this.obv) });
    AppMethodBeat.o(23123);
    return 0;
  }
  
  private int bQa()
  {
    AppMethodBeat.i(23124);
    if (this.obf != null)
    {
      if (this.obf.isOpen()) {
        this.obf.close();
      }
      this.obf = null;
    }
    this.mCancellationSignal.throwIfCanceled();
    String str = this.obg + '-' + bt.Wl(6);
    ad.i("MicroMsg.DBRecoveryTask", "Open target database: ".concat(String.valueOf(str)));
    try
    {
      this.obf = SQLiteDatabase.openOrCreateDatabase(str, this.obn, obe, null, null, 1);
      DatabaseUtils.stringForQuery(this.obf, "PRAGMA journal_mode=OFF;", null);
      this.obf.execSQL("PRAGMA synchronous=OFF;");
      AppMethodBeat.o(23124);
      return 0;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", new Object[] { str, localException.getMessage() });
      c(1, "Cannot open target database", localException);
      AppMethodBeat.o(23124);
      throw localException;
    }
  }
  
  /* Error */
  private int bQb()
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
    //   18: invokevirtual 438	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   21: iconst_5
    //   22: anewarray 88	java/lang/String
    //   25: astore 6
    //   27: aload 6
    //   29: iconst_0
    //   30: ldc_w 381
    //   33: aastore
    //   34: aload 6
    //   36: iconst_1
    //   37: ldc_w 473
    //   40: aastore
    //   41: aload 6
    //   43: iconst_2
    //   44: ldc_w 475
    //   47: aastore
    //   48: aload 6
    //   50: iconst_3
    //   51: ldc_w 477
    //   54: aastore
    //   55: aload 6
    //   57: iconst_4
    //   58: ldc_w 479
    //   61: aastore
    //   62: aload_0
    //   63: getfield 342	com/tencent/mm/plugin/dbbackup/a/a:obl	Ljava/util/List;
    //   66: invokeinterface 485 1 0
    //   71: astore 9
    //   73: aconst_null
    //   74: astore 4
    //   76: aload 9
    //   78: invokeinterface 490 1 0
    //   83: ifeq +888 -> 971
    //   86: aload 9
    //   88: invokeinterface 494 1 0
    //   93: checkcast 88	java/lang/String
    //   96: astore 10
    //   98: aload 10
    //   100: invokestatic 498	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   103: ifne +22 -> 125
    //   106: ldc 153
    //   108: ldc_w 500
    //   111: aload 10
    //   113: invokestatic 191	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -46 -> 76
    //   125: iconst_0
    //   126: istore_1
    //   127: aload 4
    //   129: astore 5
    //   131: aload 5
    //   133: astore 4
    //   135: iload_1
    //   136: aload_0
    //   137: getfield 502	com/tencent/mm/plugin/dbbackup/a/a:obp	Ljava/util/List;
    //   140: invokeinterface 505 1 0
    //   145: if_icmpge -69 -> 76
    //   148: aload_0
    //   149: getfield 502	com/tencent/mm/plugin/dbbackup/a/a:obp	Ljava/util/List;
    //   152: iload_1
    //   153: invokeinterface 509 2 0
    //   158: checkcast 510	[B
    //   161: astore 11
    //   163: aload 5
    //   165: astore 4
    //   167: aload 10
    //   169: iconst_0
    //   170: invokestatic 516	com/tencent/mm/b/q:k	(Ljava/lang/String;Z)Ljava/lang/String;
    //   173: aload 11
    //   175: aload 6
    //   177: invokestatic 522	com/tencent/wcdb/repair/RepairKit$MasterInfo:load	(Ljava/lang/String;[B[Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   180: astore 5
    //   182: aload 5
    //   184: astore 4
    //   186: ldc 153
    //   188: new 219	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 524
    //   195: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload 10
    //   200: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 526
    //   206: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload_1
    //   210: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 5
    //   221: astore 4
    //   223: aload 4
    //   225: ifnonnull +403 -> 628
    //   228: aload 6
    //   230: invokestatic 533	com/tencent/wcdb/repair/RepairKit$MasterInfo:make	([Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   233: astore 6
    //   235: ldc 153
    //   237: ldc_w 535
    //   240: invokestatic 538	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   265: ldc_w 540
    //   268: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield 391	com/tencent/mm/plugin/dbbackup/a/a:obi	Ljava/lang/String;
    //   275: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: iload_2
    //   285: istore_1
    //   286: aload 7
    //   288: astore 4
    //   290: aload 8
    //   292: astore 5
    //   294: iload_1
    //   295: aload_0
    //   296: getfield 542	com/tencent/mm/plugin/dbbackup/a/a:obq	Ljava/util/List;
    //   299: invokeinterface 505 1 0
    //   304: if_icmpge +69 -> 373
    //   307: aload 8
    //   309: astore 5
    //   311: aload_0
    //   312: getfield 542	com/tencent/mm/plugin/dbbackup/a/a:obq	Ljava/util/List;
    //   315: iload_1
    //   316: invokeinterface 509 2 0
    //   321: checkcast 510	[B
    //   324: astore 4
    //   326: aload 8
    //   328: astore 5
    //   330: new 544	com/tencent/wcdb/repair/RepairKit
    //   333: dup
    //   334: aload_0
    //   335: getfield 391	com/tencent/mm/plugin/dbbackup/a/a:obi	Ljava/lang/String;
    //   338: aload 4
    //   340: getstatic 86	com/tencent/mm/plugin/dbbackup/a/a:obe	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   343: aload 6
    //   345: invokespecial 547	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   348: astore 4
    //   350: aload 4
    //   352: invokevirtual 550	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   355: ifne +290 -> 645
    //   358: ldc 153
    //   360: ldc_w 552
    //   363: iload_1
    //   364: invokestatic 554	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   367: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 4
    //   375: ifnonnull +593 -> 968
    //   378: aload 4
    //   380: astore 5
    //   382: ldc 153
    //   384: ldc_w 556
    //   387: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload 4
    //   392: astore 5
    //   394: new 544	com/tencent/wcdb/repair/RepairKit
    //   397: dup
    //   398: aload_0
    //   399: getfield 391	com/tencent/mm/plugin/dbbackup/a/a:obi	Ljava/lang/String;
    //   402: aload_0
    //   403: getfield 542	com/tencent/mm/plugin/dbbackup/a/a:obq	Ljava/util/List;
    //   406: iconst_0
    //   407: invokeinterface 509 2 0
    //   412: checkcast 510	[B
    //   415: getstatic 86	com/tencent/mm/plugin/dbbackup/a/a:obe	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   418: aload 6
    //   420: invokespecial 547	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
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
    //   442: invokespecial 559	com/tencent/mm/plugin/dbbackup/a/a$1:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;[I)V
    //   445: invokevirtual 563	com/tencent/wcdb/repair/RepairKit:setCallback	(Lcom/tencent/wcdb/repair/RepairKit$Callback;)V
    //   448: aload 4
    //   450: astore 6
    //   452: aload 4
    //   454: aload_0
    //   455: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   458: iconst_0
    //   459: aload_0
    //   460: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   463: invokevirtual 567	com/tencent/wcdb/repair/RepairKit:output	(Lcom/tencent/wcdb/database/SQLiteDatabase;ILcom/tencent/wcdb/support/CancellationSignal;)I
    //   466: istore_1
    //   467: iload_1
    //   468: ifne +291 -> 759
    //   471: aload 4
    //   473: astore 6
    //   475: aload 4
    //   477: invokevirtual 550	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   480: ifeq +187 -> 667
    //   483: aload 4
    //   485: astore 6
    //   487: aload 4
    //   489: invokevirtual 570	com/tencent/wcdb/repair/RepairKit:isDataCorrupted	()Z
    //   492: ifeq +175 -> 667
    //   495: aload 4
    //   497: astore 6
    //   499: new 471	java/lang/RuntimeException
    //   502: dup
    //   503: ldc_w 572
    //   506: invokespecial 573	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
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
    //   556: invokevirtual 576	com/tencent/wcdb/repair/RepairKit:release	()V
    //   559: sipush 23126
    //   562: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload 4
    //   567: athrow
    //   568: astore 5
    //   570: ldc 153
    //   572: new 219	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 578
    //   579: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 5
    //   584: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   587: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 580
    //   593: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 10
    //   598: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 526
    //   604: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: iload_1
    //   608: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   611: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 582	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: iload_1
    //   618: iconst_1
    //   619: iadd
    //   620: istore_1
    //   621: aload 4
    //   623: astore 5
    //   625: goto -494 -> 131
    //   628: ldc 153
    //   630: ldc_w 584
    //   633: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: iconst_1
    //   637: istore_3
    //   638: aload 4
    //   640: astore 6
    //   642: goto -397 -> 245
    //   645: ldc 153
    //   647: ldc_w 586
    //   650: iload_1
    //   651: invokestatic 554	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   654: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokestatic 538	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: iload_1
    //   661: iconst_1
    //   662: iadd
    //   663: istore_1
    //   664: goto -378 -> 286
    //   667: aload 4
    //   669: astore 6
    //   671: ldc 153
    //   673: ldc_w 588
    //   676: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload 4
    //   681: astore 6
    //   683: aload_0
    //   684: getfield 368	com/tencent/mm/plugin/dbbackup/a/a:obu	Z
    //   687: ifeq +54 -> 741
    //   690: aload 4
    //   692: astore 6
    //   694: aload 9
    //   696: iconst_0
    //   697: iaload
    //   698: i2f
    //   699: aload_0
    //   700: getfield 136	com/tencent/mm/plugin/dbbackup/a/a:obv	I
    //   703: i2f
    //   704: fdiv
    //   705: ldc_w 589
    //   708: fcmpg
    //   709: ifgt +32 -> 741
    //   712: aload 4
    //   714: astore 6
    //   716: getstatic 595	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
    //   719: sipush 181
    //   722: sipush 181
    //   725: bipush 62
    //   727: bipush 63
    //   729: aload_0
    //   730: getfield 136	com/tencent/mm/plugin/dbbackup/a/a:obv	I
    //   733: aload 9
    //   735: iconst_0
    //   736: iaload
    //   737: iconst_1
    //   738: invokevirtual 598	com/tencent/mm/plugin/report/e:a	(IIIIIIZ)V
    //   741: aload 4
    //   743: ifnull +8 -> 751
    //   746: aload 4
    //   748: invokevirtual 576	com/tencent/wcdb/repair/RepairKit:release	()V
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
    //   770: ldc_w 600
    //   773: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   776: aload 4
    //   778: astore 6
    //   780: aload_0
    //   781: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   784: invokevirtual 438	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   787: goto -108 -> 679
    //   790: astore 5
    //   792: aload 4
    //   794: astore 6
    //   796: ldc 153
    //   798: new 219	java/lang/StringBuilder
    //   801: dup
    //   802: ldc_w 602
    //   805: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: aload 5
    //   810: invokevirtual 603	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 582	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload 4
    //   824: astore 6
    //   826: iconst_2
    //   827: ldc_w 605
    //   830: iload_3
    //   831: invokestatic 608	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   834: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   837: aload 5
    //   839: invokestatic 466	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   842: aload 4
    //   844: ifnull +8 -> 852
    //   847: aload 4
    //   849: invokevirtual 576	com/tencent/wcdb/repair/RepairKit:release	()V
    //   852: sipush 23126
    //   855: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   858: iconst_m1
    //   859: ireturn
    //   860: aload 4
    //   862: astore 6
    //   864: new 471	java/lang/RuntimeException
    //   867: dup
    //   868: ldc_w 610
    //   871: invokespecial 573	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
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
    //   528	9	6	localOperationCanceledException1	com.tencent.wcdb.support.OperationCanceledException
    //   539	7	6	localObject9	Object
    //   640	256	6	localObject10	Object
    //   910	7	6	localObject11	Object
    //   923	7	6	localObject12	Object
    //   954	1	6	localOperationCanceledException2	com.tencent.wcdb.support.OperationCanceledException
    //   963	1	6	localOperationCanceledException3	com.tencent.wcdb.support.OperationCanceledException
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
  private int bQc()
  {
    // Byte code:
    //   0: sipush 23127
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   10: invokevirtual 438	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   13: ldc 153
    //   15: ldc_w 613
    //   18: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 354	com/tencent/mm/plugin/dbbackup/a/a:obm	Ljava/util/List;
    //   25: invokeinterface 485 1 0
    //   30: astore 5
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 5
    //   36: invokeinterface 490 1 0
    //   41: ifeq +98 -> 139
    //   44: aload 5
    //   46: invokeinterface 494 1 0
    //   51: checkcast 88	java/lang/String
    //   54: astore 4
    //   56: new 615	com/tencent/wcdb/repair/RecoverKit
    //   59: dup
    //   60: aload_0
    //   61: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: aload 4
    //   66: aload_0
    //   67: getfield 502	com/tencent/mm/plugin/dbbackup/a/a:obp	Ljava/util/List;
    //   70: iconst_0
    //   71: invokeinterface 509 2 0
    //   76: checkcast 510	[B
    //   79: invokespecial 618	com/tencent/wcdb/repair/RecoverKit:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[B)V
    //   82: astore_3
    //   83: ldc 153
    //   85: ldc_w 620
    //   88: aload 4
    //   90: invokestatic 191	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   96: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   117: ldc_w 622
    //   120: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_3
    //   124: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 582	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   157: invokevirtual 626	com/tencent/wcdb/repair/RecoverKit:run	(ZLcom/tencent/wcdb/support/CancellationSignal;)I
    //   160: istore_1
    //   161: iload_1
    //   162: ifne +23 -> 185
    //   165: ldc 153
    //   167: ldc_w 628
    //   170: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_2
    //   174: invokevirtual 629	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   177: sipush 23127
    //   180: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iload_1
    //   184: ireturn
    //   185: iload_1
    //   186: iconst_1
    //   187: if_icmpne +43 -> 230
    //   190: ldc 153
    //   192: ldc_w 631
    //   195: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 112	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   202: invokevirtual 438	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   205: goto -32 -> 173
    //   208: astore_3
    //   209: sipush 23127
    //   212: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_3
    //   216: athrow
    //   217: astore_3
    //   218: aload_2
    //   219: invokevirtual 629	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   222: sipush 23127
    //   225: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_3
    //   229: athrow
    //   230: ldc 153
    //   232: ldc_w 633
    //   235: invokestatic 582	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -65 -> 173
    //   241: astore_3
    //   242: ldc 153
    //   244: new 219	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 602
    //   251: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_3
    //   255: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 582	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: iconst_4
    //   268: ldc_w 635
    //   271: aload_3
    //   272: invokestatic 466	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload_2
    //   276: invokevirtual 629	com/tencent/wcdb/repair/RecoverKit:release	()V
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
    //   208	8	3	localOperationCanceledException	com.tencent.wcdb.support.OperationCanceledException
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
  
  /* Error */
  private int bQd()
  {
    // Byte code:
    //   0: sipush 23128
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 352	com/tencent/mm/plugin/dbbackup/a/a:obh	Ljava/lang/String;
    //   10: ifnull +13 -> 23
    //   13: aload_0
    //   14: getfield 352	com/tencent/mm/plugin/dbbackup/a/a:obh	Ljava/lang/String;
    //   17: invokevirtual 150	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: sipush 23128
    //   26: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: ldc 153
    //   33: ldc_w 638
    //   36: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   43: ldc_w 640
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
    //   61: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: ldc_w 642
    //   67: aconst_null
    //   68: invokestatic 199	com/tencent/wcdb/DatabaseUtils:longForQuery	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   71: lconst_1
    //   72: ladd
    //   73: lastore
    //   74: aload 10
    //   76: iconst_0
    //   77: laload
    //   78: ldc2_w 643
    //   81: lcmp
    //   82: ifle +21 -> 103
    //   85: aload 10
    //   87: iconst_0
    //   88: laload
    //   89: ldc2_w 645
    //   92: lcmp
    //   93: ifgt +10 -> 103
    //   96: aload 10
    //   98: iconst_0
    //   99: ldc2_w 647
    //   102: lastore
    //   103: new 650	java/util/HashMap
    //   106: dup
    //   107: iload_1
    //   108: iload_1
    //   109: iconst_2
    //   110: idiv
    //   111: iadd
    //   112: sipush 10240
    //   115: invokestatic 653	java/lang/Math:max	(II)I
    //   118: invokespecial 654	java/util/HashMap:<init>	(I)V
    //   121: astore 9
    //   123: new 9	com/tencent/mm/plugin/dbbackup/a/a$2
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 657	com/tencent/mm/plugin/dbbackup/a/a$2:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;)V
    //   131: astore_3
    //   132: aload_0
    //   133: getfield 352	com/tencent/mm/plugin/dbbackup/a/a:obh	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 356	com/tencent/mm/plugin/dbbackup/a/a:obo	[B
    //   140: getstatic 86	com/tencent/mm/plugin/dbbackup/a/a:obe	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   143: aconst_null
    //   144: iconst_1
    //   145: aload_3
    //   146: iconst_1
    //   147: invokestatic 661	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   150: astore_3
    //   151: aload_0
    //   152: aload_3
    //   153: ldc_w 663
    //   156: iconst_0
    //   157: iconst_0
    //   158: iconst_0
    //   159: aconst_null
    //   160: invokespecial 665	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   163: pop
    //   164: aload_0
    //   165: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   168: invokevirtual 257	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   171: iconst_3
    //   172: anewarray 157	java/lang/Object
    //   175: astore 11
    //   177: aload 11
    //   179: iconst_0
    //   180: sipush 8197
    //   183: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: aload 11
    //   189: iconst_1
    //   190: iconst_3
    //   191: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: aload 11
    //   197: iconst_2
    //   198: ldc 90
    //   200: aastore
    //   201: aload_0
    //   202: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   205: ldc_w 667
    //   208: aload 11
    //   210: invokevirtual 670	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload 11
    //   215: iconst_0
    //   216: bipush 15
    //   218: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aastore
    //   222: aload 11
    //   224: iconst_1
    //   225: iconst_1
    //   226: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: aload 11
    //   232: iconst_2
    //   233: ldc_w 672
    //   236: aastore
    //   237: aload_0
    //   238: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   241: ldc_w 667
    //   244: aload 11
    //   246: invokevirtual 670	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: aload 11
    //   251: iconst_0
    //   252: bipush 89
    //   254: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: aload 11
    //   260: iconst_1
    //   261: iconst_1
    //   262: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: aload 11
    //   268: iconst_2
    //   269: ldc_w 674
    //   272: aastore
    //   273: aload_0
    //   274: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   277: ldc_w 667
    //   280: aload 11
    //   282: invokevirtual 670	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload_3
    //   286: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   289: ldc_w 676
    //   292: iconst_1
    //   293: anewarray 88	java/lang/String
    //   296: dup
    //   297: iconst_0
    //   298: ldc_w 678
    //   301: aastore
    //   302: ldc_w 663
    //   305: invokevirtual 681	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   308: astore 6
    //   310: aload_3
    //   311: astore 5
    //   313: aload 6
    //   315: astore 4
    //   317: aload 6
    //   319: astore 7
    //   321: aload 6
    //   323: astore 8
    //   325: aload 6
    //   327: invokeinterface 684 1 0
    //   332: ifeq +117 -> 449
    //   335: aload_3
    //   336: astore 5
    //   338: aload 6
    //   340: astore 4
    //   342: aload 6
    //   344: astore 7
    //   346: aload 6
    //   348: astore 8
    //   350: aload 11
    //   352: iconst_0
    //   353: aload 6
    //   355: iconst_0
    //   356: invokeinterface 686 2 0
    //   361: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   364: aastore
    //   365: aload_3
    //   366: astore 5
    //   368: aload 6
    //   370: astore 4
    //   372: aload 6
    //   374: astore 7
    //   376: aload 6
    //   378: astore 8
    //   380: aload 11
    //   382: iconst_1
    //   383: aload 6
    //   385: iconst_1
    //   386: invokeinterface 686 2 0
    //   391: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aastore
    //   395: aload_3
    //   396: astore 5
    //   398: aload 6
    //   400: astore 4
    //   402: aload 6
    //   404: astore 7
    //   406: aload 6
    //   408: astore 8
    //   410: aload 11
    //   412: iconst_2
    //   413: aload 6
    //   415: iconst_2
    //   416: invokeinterface 308 2 0
    //   421: aastore
    //   422: aload_3
    //   423: astore 5
    //   425: aload 6
    //   427: astore 4
    //   429: aload 6
    //   431: astore 7
    //   433: aload 6
    //   435: astore 8
    //   437: aload_0
    //   438: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   441: ldc_w 667
    //   444: aload 11
    //   446: invokevirtual 670	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: aload_3
    //   450: astore 5
    //   452: aload 6
    //   454: astore 4
    //   456: aload 6
    //   458: astore 7
    //   460: aload 6
    //   462: astore 8
    //   464: aload 6
    //   466: invokeinterface 287 1 0
    //   471: aload_3
    //   472: astore 5
    //   474: aload 6
    //   476: astore 4
    //   478: aload 6
    //   480: astore 7
    //   482: aload 6
    //   484: astore 8
    //   486: aload_3
    //   487: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   490: ldc_w 676
    //   493: iconst_1
    //   494: anewarray 88	java/lang/String
    //   497: dup
    //   498: iconst_0
    //   499: ldc_w 688
    //   502: aastore
    //   503: ldc_w 663
    //   506: invokevirtual 681	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   509: astore 6
    //   511: aload_3
    //   512: astore 5
    //   514: aload 6
    //   516: astore 4
    //   518: aload 6
    //   520: astore 7
    //   522: aload 6
    //   524: astore 8
    //   526: aload 6
    //   528: invokeinterface 684 1 0
    //   533: ifeq +117 -> 650
    //   536: aload_3
    //   537: astore 5
    //   539: aload 6
    //   541: astore 4
    //   543: aload 6
    //   545: astore 7
    //   547: aload 6
    //   549: astore 8
    //   551: aload 11
    //   553: iconst_0
    //   554: aload 6
    //   556: iconst_0
    //   557: invokeinterface 686 2 0
    //   562: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: aastore
    //   566: aload_3
    //   567: astore 5
    //   569: aload 6
    //   571: astore 4
    //   573: aload 6
    //   575: astore 7
    //   577: aload 6
    //   579: astore 8
    //   581: aload 11
    //   583: iconst_1
    //   584: aload 6
    //   586: iconst_1
    //   587: invokeinterface 686 2 0
    //   592: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   595: aastore
    //   596: aload_3
    //   597: astore 5
    //   599: aload 6
    //   601: astore 4
    //   603: aload 6
    //   605: astore 7
    //   607: aload 6
    //   609: astore 8
    //   611: aload 11
    //   613: iconst_2
    //   614: aload 6
    //   616: iconst_2
    //   617: invokeinterface 308 2 0
    //   622: aastore
    //   623: aload_3
    //   624: astore 5
    //   626: aload 6
    //   628: astore 4
    //   630: aload 6
    //   632: astore 7
    //   634: aload 6
    //   636: astore 8
    //   638: aload_0
    //   639: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   642: ldc_w 667
    //   645: aload 11
    //   647: invokevirtual 670	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   650: aload_3
    //   651: astore 5
    //   653: aload 6
    //   655: astore 4
    //   657: aload 6
    //   659: astore 7
    //   661: aload 6
    //   663: astore 8
    //   665: aload 6
    //   667: invokeinterface 287 1 0
    //   672: aload_3
    //   673: astore 5
    //   675: aload 6
    //   677: astore 4
    //   679: aload 6
    //   681: astore 7
    //   683: aload 6
    //   685: astore 8
    //   687: aload_0
    //   688: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   691: invokevirtual 330	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   694: aload_3
    //   695: astore 5
    //   697: aload 6
    //   699: astore 4
    //   701: aload 6
    //   703: astore 7
    //   705: aload 6
    //   707: astore 8
    //   709: aload_0
    //   710: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   713: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   716: aload_3
    //   717: astore 5
    //   719: aload 6
    //   721: astore 4
    //   723: aload 6
    //   725: astore 7
    //   727: aload 6
    //   729: astore 8
    //   731: aload_3
    //   732: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   735: ldc_w 690
    //   738: aconst_null
    //   739: ldc_w 381
    //   742: invokevirtual 681	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   745: astore 6
    //   747: aload 6
    //   749: astore 7
    //   751: aload 7
    //   753: astore 4
    //   755: aload 7
    //   757: astore 5
    //   759: aload 7
    //   761: astore 6
    //   763: aload 7
    //   765: ldc_w 692
    //   768: invokeinterface 695 2 0
    //   773: istore_1
    //   774: aload 7
    //   776: astore 4
    //   778: aload 7
    //   780: astore 5
    //   782: aload 7
    //   784: astore 6
    //   786: aload 7
    //   788: invokeinterface 287 1 0
    //   793: aload 7
    //   795: astore 4
    //   797: aload 7
    //   799: astore 5
    //   801: aload 7
    //   803: astore 6
    //   805: aload_0
    //   806: aload_3
    //   807: ldc_w 381
    //   810: iconst_4
    //   811: iconst_1
    //   812: iconst_5
    //   813: new 11	com/tencent/mm/plugin/dbbackup/a/a$3
    //   816: dup
    //   817: aload_0
    //   818: iload_1
    //   819: aload 10
    //   821: aload 9
    //   823: invokespecial 698	com/tencent/mm/plugin/dbbackup/a/a$3:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;I[JLjava/util/HashMap;)V
    //   826: invokespecial 665	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   829: pop
    //   830: aload 7
    //   832: astore 4
    //   834: aload 7
    //   836: astore 5
    //   838: aload 7
    //   840: astore 6
    //   842: aload_3
    //   843: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   846: ldc_w 700
    //   849: aconst_null
    //   850: ldc_w 479
    //   853: invokevirtual 681	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   856: astore 7
    //   858: aload 7
    //   860: astore 4
    //   862: aload 7
    //   864: astore 5
    //   866: aload 7
    //   868: astore 6
    //   870: aload 7
    //   872: ldc_w 702
    //   875: invokeinterface 695 2 0
    //   880: istore_1
    //   881: aload 7
    //   883: astore 4
    //   885: aload 7
    //   887: astore 5
    //   889: aload 7
    //   891: astore 6
    //   893: aload 7
    //   895: ldc_w 704
    //   898: invokeinterface 695 2 0
    //   903: istore_2
    //   904: aload 7
    //   906: astore 4
    //   908: aload 7
    //   910: astore 5
    //   912: aload 7
    //   914: astore 6
    //   916: iconst_1
    //   917: anewarray 88	java/lang/String
    //   920: astore 8
    //   922: aload 7
    //   924: astore 4
    //   926: aload 7
    //   928: astore 5
    //   930: aload 7
    //   932: astore 6
    //   934: aload 7
    //   936: invokeinterface 287 1 0
    //   941: aload 7
    //   943: astore 4
    //   945: aload 7
    //   947: astore 5
    //   949: aload 7
    //   951: astore 6
    //   953: aload_0
    //   954: aload_3
    //   955: ldc_w 479
    //   958: iconst_5
    //   959: iconst_1
    //   960: iconst_0
    //   961: new 13	com/tencent/mm/plugin/dbbackup/a/a$4
    //   964: dup
    //   965: aload_0
    //   966: aload 8
    //   968: iload_1
    //   969: iload_2
    //   970: invokespecial 707	com/tencent/mm/plugin/dbbackup/a/a$4:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;[Ljava/lang/String;II)V
    //   973: invokespecial 665	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   976: pop
    //   977: aload 7
    //   979: astore 4
    //   981: aload 7
    //   983: astore 5
    //   985: aload 7
    //   987: astore 6
    //   989: aload_3
    //   990: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   993: ldc_w 709
    //   996: aconst_null
    //   997: ldc_w 473
    //   1000: invokevirtual 681	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   1003: astore 7
    //   1005: aload 7
    //   1007: astore 4
    //   1009: aload 7
    //   1011: astore 5
    //   1013: aload 7
    //   1015: astore 6
    //   1017: aload 7
    //   1019: ldc_w 711
    //   1022: invokeinterface 695 2 0
    //   1027: istore_1
    //   1028: aload 7
    //   1030: astore 4
    //   1032: aload 7
    //   1034: astore 5
    //   1036: aload 7
    //   1038: astore 6
    //   1040: aload 7
    //   1042: invokeinterface 287 1 0
    //   1047: aload 7
    //   1049: astore 4
    //   1051: aload 7
    //   1053: astore 5
    //   1055: aload 7
    //   1057: astore 6
    //   1059: aload_0
    //   1060: aload_3
    //   1061: ldc_w 473
    //   1064: iconst_4
    //   1065: iconst_1
    //   1066: iconst_0
    //   1067: new 15	com/tencent/mm/plugin/dbbackup/a/a$5
    //   1070: dup
    //   1071: aload_0
    //   1072: iload_1
    //   1073: aload 9
    //   1075: invokespecial 714	com/tencent/mm/plugin/dbbackup/a/a$5:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   1078: invokespecial 665	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   1081: pop
    //   1082: aload 7
    //   1084: astore 4
    //   1086: aload 7
    //   1088: astore 5
    //   1090: aload 7
    //   1092: astore 6
    //   1094: aload_3
    //   1095: getstatic 205	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   1098: ldc_w 716
    //   1101: aconst_null
    //   1102: ldc_w 475
    //   1105: invokevirtual 681	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   1108: astore 7
    //   1110: aload 7
    //   1112: astore 4
    //   1114: aload 7
    //   1116: astore 5
    //   1118: aload 7
    //   1120: astore 6
    //   1122: aload 7
    //   1124: ldc_w 711
    //   1127: invokeinterface 695 2 0
    //   1132: istore_1
    //   1133: aload 7
    //   1135: astore 4
    //   1137: aload 7
    //   1139: astore 5
    //   1141: aload 7
    //   1143: astore 6
    //   1145: aload 7
    //   1147: invokeinterface 287 1 0
    //   1152: aload 7
    //   1154: astore 4
    //   1156: aload 7
    //   1158: astore 5
    //   1160: aload 7
    //   1162: astore 6
    //   1164: aload_0
    //   1165: aload_3
    //   1166: ldc_w 475
    //   1169: iconst_4
    //   1170: iconst_1
    //   1171: iconst_0
    //   1172: new 17	com/tencent/mm/plugin/dbbackup/a/a$6
    //   1175: dup
    //   1176: aload_0
    //   1177: iload_1
    //   1178: aload 9
    //   1180: invokespecial 717	com/tencent/mm/plugin/dbbackup/a/a$6:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   1183: invokespecial 665	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   1186: pop
    //   1187: aload 7
    //   1189: ifnull +20 -> 1209
    //   1192: aload 7
    //   1194: invokeinterface 284 1 0
    //   1199: ifne +10 -> 1209
    //   1202: aload 7
    //   1204: invokeinterface 287 1 0
    //   1209: aload_0
    //   1210: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1213: invokevirtual 170	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1216: ifeq +10 -> 1226
    //   1219: aload_0
    //   1220: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1223: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1226: aload_3
    //   1227: ifnull +7 -> 1234
    //   1230: aload_3
    //   1231: invokevirtual 435	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1234: sipush 23128
    //   1237: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1240: iconst_0
    //   1241: ireturn
    //   1242: astore 6
    //   1244: aconst_null
    //   1245: astore_3
    //   1246: aconst_null
    //   1247: astore 7
    //   1249: aload 7
    //   1251: astore 5
    //   1253: aload_3
    //   1254: astore 4
    //   1256: ldc 153
    //   1258: ldc_w 719
    //   1261: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1264: aload 7
    //   1266: astore 5
    //   1268: aload_3
    //   1269: astore 4
    //   1271: sipush 23128
    //   1274: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1277: aload 7
    //   1279: astore 5
    //   1281: aload_3
    //   1282: astore 4
    //   1284: aload 6
    //   1286: athrow
    //   1287: astore 6
    //   1289: aload 4
    //   1291: astore_3
    //   1292: aload 6
    //   1294: astore 4
    //   1296: aload_3
    //   1297: ifnull +18 -> 1315
    //   1300: aload_3
    //   1301: invokeinterface 284 1 0
    //   1306: ifne +9 -> 1315
    //   1309: aload_3
    //   1310: invokeinterface 287 1 0
    //   1315: aload_0
    //   1316: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1319: invokevirtual 170	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1322: ifeq +10 -> 1332
    //   1325: aload_0
    //   1326: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1329: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1332: aload 5
    //   1334: ifnull +8 -> 1342
    //   1337: aload 5
    //   1339: invokevirtual 435	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1342: sipush 23128
    //   1345: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1348: aload 4
    //   1350: athrow
    //   1351: astore 6
    //   1353: aconst_null
    //   1354: astore_3
    //   1355: aconst_null
    //   1356: astore 8
    //   1358: aload 8
    //   1360: astore 5
    //   1362: aload_3
    //   1363: astore 4
    //   1365: ldc 153
    //   1367: new 219	java/lang/StringBuilder
    //   1370: dup
    //   1371: ldc_w 721
    //   1374: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1377: aload 6
    //   1379: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1382: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1388: invokestatic 582	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1391: aload 8
    //   1393: astore 5
    //   1395: aload_3
    //   1396: astore 4
    //   1398: iconst_5
    //   1399: new 219	java/lang/StringBuilder
    //   1402: dup
    //   1403: ldc_w 723
    //   1406: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1409: aload_0
    //   1410: getfield 346	com/tencent/mm/plugin/dbbackup/a/a:obs	Z
    //   1413: invokevirtual 726	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1416: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: aload 6
    //   1421: invokestatic 466	com/tencent/mm/plugin/dbbackup/a/a:c	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1424: aload_3
    //   1425: ifnull +18 -> 1443
    //   1428: aload_3
    //   1429: invokeinterface 284 1 0
    //   1434: ifne +9 -> 1443
    //   1437: aload_3
    //   1438: invokeinterface 287 1 0
    //   1443: aload_0
    //   1444: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1447: invokevirtual 170	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1450: ifeq +10 -> 1460
    //   1453: aload_0
    //   1454: getfield 165	com/tencent/mm/plugin/dbbackup/a/a:obf	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1457: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1460: aload 8
    //   1462: ifnull +8 -> 1470
    //   1465: aload 8
    //   1467: invokevirtual 435	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1470: sipush 23128
    //   1473: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1476: iconst_m1
    //   1477: ireturn
    //   1478: astore 4
    //   1480: aconst_null
    //   1481: astore_3
    //   1482: aconst_null
    //   1483: astore 5
    //   1485: goto -189 -> 1296
    //   1488: astore 4
    //   1490: aconst_null
    //   1491: astore 6
    //   1493: aload_3
    //   1494: astore 5
    //   1496: aload 6
    //   1498: astore_3
    //   1499: goto -203 -> 1296
    //   1502: astore 5
    //   1504: aload 4
    //   1506: astore 6
    //   1508: aload 5
    //   1510: astore 4
    //   1512: aload_3
    //   1513: astore 5
    //   1515: aload 6
    //   1517: astore_3
    //   1518: goto -222 -> 1296
    //   1521: astore 6
    //   1523: aconst_null
    //   1524: astore 4
    //   1526: aload_3
    //   1527: astore 8
    //   1529: aload 4
    //   1531: astore_3
    //   1532: goto -174 -> 1358
    //   1535: astore 6
    //   1537: aload_3
    //   1538: astore 8
    //   1540: aload 7
    //   1542: astore_3
    //   1543: goto -185 -> 1358
    //   1546: astore 6
    //   1548: aload_3
    //   1549: astore 8
    //   1551: aload 5
    //   1553: astore_3
    //   1554: goto -196 -> 1358
    //   1557: astore 6
    //   1559: aconst_null
    //   1560: astore 4
    //   1562: aload_3
    //   1563: astore 7
    //   1565: aload 4
    //   1567: astore_3
    //   1568: goto -319 -> 1249
    //   1571: astore 6
    //   1573: aload_3
    //   1574: astore 7
    //   1576: aload 8
    //   1578: astore_3
    //   1579: goto -330 -> 1249
    //   1582: astore 5
    //   1584: aload 6
    //   1586: astore 4
    //   1588: aload 5
    //   1590: astore 6
    //   1592: aload_3
    //   1593: astore 7
    //   1595: aload 4
    //   1597: astore_3
    //   1598: goto -349 -> 1249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1601	0	this	a
    //   51	1127	1	i	int
    //   903	67	2	j	int
    //   131	1467	3	localObject1	Object
    //   315	1082	4	localObject2	Object
    //   1478	1	4	localObject3	Object
    //   1488	17	4	localObject4	Object
    //   1510	86	4	localObject5	Object
    //   311	1184	5	localObject6	Object
    //   1502	7	5	localObject7	Object
    //   1513	39	5	localObject8	Object
    //   1582	7	5	localOperationCanceledException1	com.tencent.wcdb.support.OperationCanceledException
    //   308	855	6	localObject9	Object
    //   1242	43	6	localOperationCanceledException2	com.tencent.wcdb.support.OperationCanceledException
    //   1287	6	6	localObject10	Object
    //   1351	69	6	localException1	Exception
    //   1491	25	6	localObject11	Object
    //   1521	1	6	localException2	Exception
    //   1535	1	6	localException3	Exception
    //   1546	1	6	localException4	Exception
    //   1557	1	6	localOperationCanceledException3	com.tencent.wcdb.support.OperationCanceledException
    //   1571	14	6	localOperationCanceledException4	com.tencent.wcdb.support.OperationCanceledException
    //   1590	1	6	localObject12	Object
    //   319	1275	7	localObject13	Object
    //   323	1254	8	localObject14	Object
    //   121	1058	9	localHashMap	HashMap
    //   55	765	10	arrayOfLong	long[]
    //   175	471	11	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   39	74	1242	com/tencent/wcdb/support/OperationCanceledException
    //   103	151	1242	com/tencent/wcdb/support/OperationCanceledException
    //   325	335	1287	finally
    //   350	365	1287	finally
    //   380	395	1287	finally
    //   410	422	1287	finally
    //   437	449	1287	finally
    //   464	471	1287	finally
    //   486	511	1287	finally
    //   526	536	1287	finally
    //   551	566	1287	finally
    //   581	596	1287	finally
    //   611	623	1287	finally
    //   638	650	1287	finally
    //   665	672	1287	finally
    //   687	694	1287	finally
    //   709	716	1287	finally
    //   731	747	1287	finally
    //   1256	1264	1287	finally
    //   1271	1277	1287	finally
    //   1284	1287	1287	finally
    //   1365	1391	1287	finally
    //   1398	1424	1287	finally
    //   39	74	1351	java/lang/Exception
    //   103	151	1351	java/lang/Exception
    //   39	74	1478	finally
    //   103	151	1478	finally
    //   151	195	1488	finally
    //   201	230	1488	finally
    //   237	266	1488	finally
    //   273	310	1488	finally
    //   763	774	1502	finally
    //   786	793	1502	finally
    //   805	830	1502	finally
    //   842	858	1502	finally
    //   870	881	1502	finally
    //   893	904	1502	finally
    //   916	922	1502	finally
    //   934	941	1502	finally
    //   953	977	1502	finally
    //   989	1005	1502	finally
    //   1017	1028	1502	finally
    //   1040	1047	1502	finally
    //   1059	1082	1502	finally
    //   1094	1110	1502	finally
    //   1122	1133	1502	finally
    //   1145	1152	1502	finally
    //   1164	1187	1502	finally
    //   151	195	1521	java/lang/Exception
    //   201	230	1521	java/lang/Exception
    //   237	266	1521	java/lang/Exception
    //   273	310	1521	java/lang/Exception
    //   325	335	1535	java/lang/Exception
    //   350	365	1535	java/lang/Exception
    //   380	395	1535	java/lang/Exception
    //   410	422	1535	java/lang/Exception
    //   437	449	1535	java/lang/Exception
    //   464	471	1535	java/lang/Exception
    //   486	511	1535	java/lang/Exception
    //   526	536	1535	java/lang/Exception
    //   551	566	1535	java/lang/Exception
    //   581	596	1535	java/lang/Exception
    //   611	623	1535	java/lang/Exception
    //   638	650	1535	java/lang/Exception
    //   665	672	1535	java/lang/Exception
    //   687	694	1535	java/lang/Exception
    //   709	716	1535	java/lang/Exception
    //   731	747	1535	java/lang/Exception
    //   763	774	1546	java/lang/Exception
    //   786	793	1546	java/lang/Exception
    //   805	830	1546	java/lang/Exception
    //   842	858	1546	java/lang/Exception
    //   870	881	1546	java/lang/Exception
    //   893	904	1546	java/lang/Exception
    //   916	922	1546	java/lang/Exception
    //   934	941	1546	java/lang/Exception
    //   953	977	1546	java/lang/Exception
    //   989	1005	1546	java/lang/Exception
    //   1017	1028	1546	java/lang/Exception
    //   1040	1047	1546	java/lang/Exception
    //   1059	1082	1546	java/lang/Exception
    //   1094	1110	1546	java/lang/Exception
    //   1122	1133	1546	java/lang/Exception
    //   1145	1152	1546	java/lang/Exception
    //   1164	1187	1546	java/lang/Exception
    //   151	195	1557	com/tencent/wcdb/support/OperationCanceledException
    //   201	230	1557	com/tencent/wcdb/support/OperationCanceledException
    //   237	266	1557	com/tencent/wcdb/support/OperationCanceledException
    //   273	310	1557	com/tencent/wcdb/support/OperationCanceledException
    //   325	335	1571	com/tencent/wcdb/support/OperationCanceledException
    //   350	365	1571	com/tencent/wcdb/support/OperationCanceledException
    //   380	395	1571	com/tencent/wcdb/support/OperationCanceledException
    //   410	422	1571	com/tencent/wcdb/support/OperationCanceledException
    //   437	449	1571	com/tencent/wcdb/support/OperationCanceledException
    //   464	471	1571	com/tencent/wcdb/support/OperationCanceledException
    //   486	511	1571	com/tencent/wcdb/support/OperationCanceledException
    //   526	536	1571	com/tencent/wcdb/support/OperationCanceledException
    //   551	566	1571	com/tencent/wcdb/support/OperationCanceledException
    //   581	596	1571	com/tencent/wcdb/support/OperationCanceledException
    //   611	623	1571	com/tencent/wcdb/support/OperationCanceledException
    //   638	650	1571	com/tencent/wcdb/support/OperationCanceledException
    //   665	672	1571	com/tencent/wcdb/support/OperationCanceledException
    //   687	694	1571	com/tencent/wcdb/support/OperationCanceledException
    //   709	716	1571	com/tencent/wcdb/support/OperationCanceledException
    //   731	747	1571	com/tencent/wcdb/support/OperationCanceledException
    //   763	774	1582	com/tencent/wcdb/support/OperationCanceledException
    //   786	793	1582	com/tencent/wcdb/support/OperationCanceledException
    //   805	830	1582	com/tencent/wcdb/support/OperationCanceledException
    //   842	858	1582	com/tencent/wcdb/support/OperationCanceledException
    //   870	881	1582	com/tencent/wcdb/support/OperationCanceledException
    //   893	904	1582	com/tencent/wcdb/support/OperationCanceledException
    //   916	922	1582	com/tencent/wcdb/support/OperationCanceledException
    //   934	941	1582	com/tencent/wcdb/support/OperationCanceledException
    //   953	977	1582	com/tencent/wcdb/support/OperationCanceledException
    //   989	1005	1582	com/tencent/wcdb/support/OperationCanceledException
    //   1017	1028	1582	com/tencent/wcdb/support/OperationCanceledException
    //   1040	1047	1582	com/tencent/wcdb/support/OperationCanceledException
    //   1059	1082	1582	com/tencent/wcdb/support/OperationCanceledException
    //   1094	1110	1582	com/tencent/wcdb/support/OperationCanceledException
    //   1122	1133	1582	com/tencent/wcdb/support/OperationCanceledException
    //   1145	1152	1582	com/tencent/wcdb/support/OperationCanceledException
    //   1164	1187	1582	com/tencent/wcdb/support/OperationCanceledException
  }
  
  @SuppressLint({"DefaultLocale"})
  private static void c(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(23132);
    com.tencent.mm.plugin.report.e.vIY.e("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[] { Integer.valueOf(paramInt), paramString, "\n" + bt.m(paramThrowable) }), null);
    AppMethodBeat.o(23132);
  }
  
  private int ja(boolean paramBoolean)
  {
    AppMethodBeat.i(23125);
    ad.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.obg);
    if (this.obf == null)
    {
      AppMethodBeat.o(23125);
      return -1;
    }
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(this.obf.getPath());
    if (this.obf.isOpen()) {
      this.obf.close();
    }
    if (paramBoolean)
    {
      if (!locale.af(new com.tencent.mm.vfs.e(this.obg)))
      {
        ad.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", new Object[] { locale, this.obg });
        AppMethodBeat.o(23125);
        return -1;
      }
    }
    else
    {
      ad.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", new Object[] { locale });
      locale.delete();
    }
    AppMethodBeat.o(23125);
    return 0;
  }
  
  private static void lc(int paramInt)
  {
    AppMethodBeat.i(23131);
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(181L, paramInt, 1L, true);
    AppMethodBeat.o(23131);
  }
  
  /* Error */
  private Integer pX()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: sipush 23121
    //   9: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: bipush 54
    //   14: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   17: iconst_m1
    //   18: istore 4
    //   20: invokestatic 782	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   23: ldc_w 784
    //   26: invokevirtual 790	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 792	android/os/PowerManager
    //   32: iconst_1
    //   33: ldc_w 794
    //   36: invokevirtual 798	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   39: astore 12
    //   41: invokestatic 803	android/os/SystemClock:uptimeMillis	()J
    //   44: lstore 7
    //   46: aload 12
    //   48: ldc2_w 804
    //   51: invokevirtual 811	android/os/PowerManager$WakeLock:acquire	(J)V
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
    //   88: invokespecial 813	com/tencent/mm/plugin/dbbackup/a/a:bPZ	()I
    //   91: istore 4
    //   93: iload 4
    //   95: ifeq +120 -> 215
    //   98: iload 4
    //   100: tableswitch	default:+32 -> 132, -2:+107->207, -1:+32->132, 0:+62->162, 1:+99->199
    //   133: dstore 184
    //   135: iconst_0
    //   136: iconst_5
    //   137: aload 12
    //   139: invokevirtual 816	android/os/PowerManager$WakeLock:isHeld	()Z
    //   142: ifeq +8 -> 150
    //   145: aload 12
    //   147: invokevirtual 817	android/os/PowerManager$WakeLock:release	()V
    //   150: sipush 23121
    //   153: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iload 4
    //   158: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: areturn
    //   162: invokestatic 803	android/os/SystemClock:uptimeMillis	()J
    //   165: lstore 9
    //   167: bipush 55
    //   169: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   172: getstatic 595	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
    //   175: ldc2_w 767
    //   178: ldc2_w 818
    //   181: lload 9
    //   183: lload 7
    //   185: lsub
    //   186: ldc2_w 820
    //   189: ldiv
    //   190: lconst_1
    //   191: ladd
    //   192: iconst_1
    //   193: invokevirtual 772	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   196: goto -59 -> 137
    //   199: bipush 56
    //   201: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   204: goto -67 -> 137
    //   207: bipush 58
    //   209: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   212: goto -75 -> 137
    //   215: iload 4
    //   217: istore_1
    //   218: iload 4
    //   220: istore_2
    //   221: iload 4
    //   223: istore_3
    //   224: aload_0
    //   225: getfield 336	com/tencent/mm/plugin/dbbackup/a/a:obr	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   228: ifnull +102 -> 330
    //   231: iload 4
    //   233: istore_1
    //   234: iload 4
    //   236: istore_2
    //   237: iload 4
    //   239: istore_3
    //   240: ldc 153
    //   242: ldc_w 823
    //   245: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: iload 4
    //   250: istore_1
    //   251: iload 4
    //   253: istore_2
    //   254: iload 4
    //   256: istore_3
    //   257: aload_0
    //   258: getfield 336	com/tencent/mm/plugin/dbbackup/a/a:obr	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   261: invokeinterface 827 1 0
    //   266: astore 11
    //   268: iload 4
    //   270: istore_1
    //   271: iload 4
    //   273: istore_2
    //   274: iload 4
    //   276: istore_3
    //   277: aload_0
    //   278: getfield 502	com/tencent/mm/plugin/dbbackup/a/a:obp	Ljava/util/List;
    //   281: aload 11
    //   283: invokeinterface 831 2 0
    //   288: pop
    //   289: iload 4
    //   291: istore_1
    //   292: iload 4
    //   294: istore_2
    //   295: iload 4
    //   297: istore_3
    //   298: aload_0
    //   299: getfield 336	com/tencent/mm/plugin/dbbackup/a/a:obr	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   302: invokeinterface 834 1 0
    //   307: astore 11
    //   309: iload 4
    //   311: istore_1
    //   312: iload 4
    //   314: istore_2
    //   315: iload 4
    //   317: istore_3
    //   318: aload_0
    //   319: getfield 542	com/tencent/mm/plugin/dbbackup/a/a:obq	Ljava/util/List;
    //   322: aload 11
    //   324: invokeinterface 831 2 0
    //   329: pop
    //   330: iload 4
    //   332: istore_1
    //   333: iload 4
    //   335: istore_2
    //   336: iload 4
    //   338: istore_3
    //   339: aload_0
    //   340: getfield 502	com/tencent/mm/plugin/dbbackup/a/a:obp	Ljava/util/List;
    //   343: invokeinterface 835 1 0
    //   348: ifeq +23 -> 371
    //   351: iload 4
    //   353: istore_1
    //   354: iload 4
    //   356: istore_2
    //   357: iload 4
    //   359: istore_3
    //   360: aload_0
    //   361: getfield 502	com/tencent/mm/plugin/dbbackup/a/a:obp	Ljava/util/List;
    //   364: aconst_null
    //   365: invokeinterface 839 2 0
    //   370: pop
    //   371: iload 4
    //   373: istore_1
    //   374: iload 4
    //   376: istore_2
    //   377: iload 4
    //   379: istore_3
    //   380: aload_0
    //   381: getfield 542	com/tencent/mm/plugin/dbbackup/a/a:obq	Ljava/util/List;
    //   384: invokeinterface 835 1 0
    //   389: ifeq +23 -> 412
    //   392: iload 4
    //   394: istore_1
    //   395: iload 4
    //   397: istore_2
    //   398: iload 4
    //   400: istore_3
    //   401: aload_0
    //   402: getfield 542	com/tencent/mm/plugin/dbbackup/a/a:obq	Ljava/util/List;
    //   405: aconst_null
    //   406: invokeinterface 839 2 0
    //   411: pop
    //   412: iload 6
    //   414: istore_2
    //   415: aload_0
    //   416: invokespecial 841	com/tencent/mm/plugin/dbbackup/a/a:bQa	()I
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
    //   452: invokespecial 843	com/tencent/mm/plugin/dbbackup/a/a:bQb	()I
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
    //   500: iconst_5
    //   501: aload 12
    //   503: invokevirtual 816	android/os/PowerManager$WakeLock:isHeld	()Z
    //   506: ifeq +8 -> 514
    //   509: aload 12
    //   511: invokevirtual 817	android/os/PowerManager$WakeLock:release	()V
    //   514: sipush 23121
    //   517: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   520: iload 4
    //   522: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: areturn
    //   526: invokestatic 803	android/os/SystemClock:uptimeMillis	()J
    //   529: lstore 9
    //   531: bipush 55
    //   533: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   536: getstatic 595	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
    //   539: ldc2_w 767
    //   542: ldc2_w 818
    //   545: lload 9
    //   547: lload 7
    //   549: lsub
    //   550: ldc2_w 820
    //   553: ldiv
    //   554: lconst_1
    //   555: ladd
    //   556: iconst_1
    //   557: invokevirtual 772	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   560: goto -59 -> 501
    //   563: bipush 56
    //   565: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   568: goto -67 -> 501
    //   571: bipush 58
    //   573: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
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
    //   623: invokespecial 845	com/tencent/mm/plugin/dbbackup/a/a:bQc	()I
    //   626: istore 5
    //   628: iload 5
    //   630: ifeq +117 -> 747
    //   633: iload 5
    //   635: tableswitch	default:+29 -> 664, -2:+104->739, -1:+29->664, 0:+59->694, 1:+96->731
    //   665: dstore 184
    //   667: iconst_0
    //   668: iconst_5
    //   669: aload 12
    //   671: invokevirtual 816	android/os/PowerManager$WakeLock:isHeld	()Z
    //   674: ifeq +8 -> 682
    //   677: aload 12
    //   679: invokevirtual 817	android/os/PowerManager$WakeLock:release	()V
    //   682: sipush 23121
    //   685: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: iload 5
    //   690: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   693: areturn
    //   694: invokestatic 803	android/os/SystemClock:uptimeMillis	()J
    //   697: lstore 9
    //   699: bipush 55
    //   701: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   704: getstatic 595	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
    //   707: ldc2_w 767
    //   710: ldc2_w 818
    //   713: lload 9
    //   715: lload 7
    //   717: lsub
    //   718: ldc2_w 820
    //   721: ldiv
    //   722: lconst_1
    //   723: ladd
    //   724: iconst_1
    //   725: invokevirtual 772	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   728: goto -59 -> 669
    //   731: bipush 56
    //   733: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   736: goto -67 -> 669
    //   739: bipush 58
    //   741: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
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
    //   781: invokespecial 847	com/tencent/mm/plugin/dbbackup/a/a:bQd	()I
    //   784: istore 4
    //   786: iload 4
    //   788: istore_2
    //   789: iload_2
    //   790: istore_1
    //   791: iload_2
    //   792: istore_3
    //   793: iload_2
    //   794: istore 4
    //   796: aload_0
    //   797: iconst_1
    //   798: anewarray 262	java/lang/Integer
    //   801: dup
    //   802: iconst_0
    //   803: bipush 6
    //   805: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: aastore
    //   809: invokevirtual 269	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   812: iload_2
    //   813: istore_1
    //   814: iload_2
    //   815: istore_3
    //   816: iload_2
    //   817: istore 4
    //   819: aload_0
    //   820: iconst_1
    //   821: invokespecial 849	com/tencent/mm/plugin/dbbackup/a/a:ja	(Z)I
    //   824: istore_2
    //   825: iload_2
    //   826: tableswitch	default:+30 -> 856, -2:+104->930, -1:+30->856, 0:+59->885, 1:+96->922
    //   857: dstore 184
    //   859: iconst_0
    //   860: iconst_5
    //   861: aload 12
    //   863: invokevirtual 816	android/os/PowerManager$WakeLock:isHeld	()Z
    //   866: ifeq +8 -> 874
    //   869: aload 12
    //   871: invokevirtual 817	android/os/PowerManager$WakeLock:release	()V
    //   874: sipush 23121
    //   877: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   880: iload_2
    //   881: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   884: areturn
    //   885: invokestatic 803	android/os/SystemClock:uptimeMillis	()J
    //   888: lstore 9
    //   890: bipush 55
    //   892: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   895: getstatic 595	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
    //   898: ldc2_w 767
    //   901: ldc2_w 818
    //   904: lload 9
    //   906: lload 7
    //   908: lsub
    //   909: ldc2_w 820
    //   912: ldiv
    //   913: lconst_1
    //   914: ladd
    //   915: iconst_1
    //   916: invokevirtual 772	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   919: goto -58 -> 861
    //   922: bipush 56
    //   924: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   927: goto -66 -> 861
    //   930: bipush 58
    //   932: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   935: goto -74 -> 861
    //   938: astore 11
    //   940: iload_1
    //   941: istore_2
    //   942: iload_2
    //   943: istore_1
    //   944: ldc 153
    //   946: ldc_w 851
    //   949: invokestatic 366	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   952: iload_2
    //   953: istore_1
    //   954: aload_0
    //   955: iconst_0
    //   956: invokespecial 849	com/tencent/mm/plugin/dbbackup/a/a:ja	(Z)I
    //   959: pop
    //   960: bipush 56
    //   962: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   965: aload 12
    //   967: invokevirtual 816	android/os/PowerManager$WakeLock:isHeld	()Z
    //   970: ifeq +8 -> 978
    //   973: aload 12
    //   975: invokevirtual 817	android/os/PowerManager$WakeLock:release	()V
    //   978: sipush 23121
    //   981: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   984: iconst_1
    //   985: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   988: areturn
    //   989: astore 11
    //   991: iload_2
    //   992: istore_1
    //   993: iload_1
    //   994: istore_2
    //   995: ldc 153
    //   997: aload 11
    //   999: ldc_w 853
    //   1002: iconst_0
    //   1003: anewarray 157	java/lang/Object
    //   1006: invokestatic 426	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1009: iload_1
    //   1010: istore_2
    //   1011: aload_0
    //   1012: iconst_0
    //   1013: invokespecial 849	com/tencent/mm/plugin/dbbackup/a/a:ja	(Z)I
    //   1016: pop
    //   1017: iconst_m1
    //   1018: istore_1
    //   1019: bipush 57
    //   1021: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   1024: aload 12
    //   1026: invokevirtual 816	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1029: ifeq +8 -> 1037
    //   1032: aload 12
    //   1034: invokevirtual 817	android/os/PowerManager$WakeLock:release	()V
    //   1037: sipush 23121
    //   1040: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1043: iconst_m1
    //   1044: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1047: areturn
    //   1048: astore 11
    //   1050: iload_3
    //   1051: istore_2
    //   1052: iload_2
    //   1053: tableswitch	default:+31 -> 1084, -2:+103->1156, -1:+31->1084, 0:+58->1111, 1:+95->1148
    //   1085: dstore 184
    //   1087: iconst_0
    //   1088: iconst_5
    //   1089: aload 12
    //   1091: invokevirtual 816	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1094: ifeq +8 -> 1102
    //   1097: aload 12
    //   1099: invokevirtual 817	android/os/PowerManager$WakeLock:release	()V
    //   1102: sipush 23121
    //   1105: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1108: aload 11
    //   1110: athrow
    //   1111: invokestatic 803	android/os/SystemClock:uptimeMillis	()J
    //   1114: lstore 9
    //   1116: bipush 55
    //   1118: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   1121: getstatic 595	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
    //   1124: ldc2_w 767
    //   1127: ldc2_w 818
    //   1130: lload 9
    //   1132: lload 7
    //   1134: lsub
    //   1135: ldc2_w 820
    //   1138: ldiv
    //   1139: lconst_1
    //   1140: ladd
    //   1141: iconst_1
    //   1142: invokevirtual 772	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   1145: goto -56 -> 1089
    //   1148: bipush 56
    //   1150: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   1153: goto -64 -> 1089
    //   1156: bipush 58
    //   1158: invokestatic 776	com/tencent/mm/plugin/dbbackup/a/a:lc	(I)V
    //   1161: goto -72 -> 1089
    //   1164: astore 11
    //   1166: goto -114 -> 1052
    //   1169: astore 11
    //   1171: iload_1
    //   1172: istore_2
    //   1173: goto -121 -> 1052
    //   1176: astore 11
    //   1178: iconst_1
    //   1179: istore_1
    //   1180: goto -128 -> 1052
    //   1183: astore 11
    //   1185: iload 5
    //   1187: istore_1
    //   1188: goto -195 -> 993
    //   1191: astore 11
    //   1193: iload_3
    //   1194: istore_1
    //   1195: goto -202 -> 993
    //   1198: astore 11
    //   1200: iconst_0
    //   1201: istore_2
    //   1202: goto -260 -> 942
    //   1205: astore 11
    //   1207: iload 4
    //   1209: istore_2
    //   1210: goto -268 -> 942
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1213	0	this	a
    //   56	1116	1	i	int
    //   59	1114	2	j	int
    //   62	989	3	k	int
    //   18	800	4	m	int
    //   4	774	5	n	int
    //   1	412	6	i1	int
    //   44	1089	7	l1	long
    //   165	966	9	l2	long
    //   266	57	11	localCollection	Collection
    //   938	1	11	localOperationCanceledException	com.tencent.wcdb.support.OperationCanceledException
    //   989	9	11	localException	Exception
    //   1048	61	11	localObject1	Object
    //   1164	1	11	localObject2	Object
    //   1169	1	11	localObject3	Object
    //   39	1059	12	localWakeLock	android.os.PowerManager.WakeLock
    // Exception table:
    //   from	to	target	type
    //   63	78	938	com/tencent/wcdb/support/OperationCanceledException
    //   87	93	938	com/tencent/wcdb/support/OperationCanceledException
    //   224	231	938	com/tencent/wcdb/support/OperationCanceledException
    //   240	248	938	com/tencent/wcdb/support/OperationCanceledException
    //   257	268	938	com/tencent/wcdb/support/OperationCanceledException
    //   277	289	938	com/tencent/wcdb/support/OperationCanceledException
    //   298	309	938	com/tencent/wcdb/support/OperationCanceledException
    //   318	330	938	com/tencent/wcdb/support/OperationCanceledException
    //   339	351	938	com/tencent/wcdb/support/OperationCanceledException
    //   360	371	938	com/tencent/wcdb/support/OperationCanceledException
    //   380	392	938	com/tencent/wcdb/support/OperationCanceledException
    //   401	412	938	com/tencent/wcdb/support/OperationCanceledException
    //   598	613	938	com/tencent/wcdb/support/OperationCanceledException
    //   622	628	938	com/tencent/wcdb/support/OperationCanceledException
    //   756	771	938	com/tencent/wcdb/support/OperationCanceledException
    //   780	786	938	com/tencent/wcdb/support/OperationCanceledException
    //   63	78	989	java/lang/Exception
    //   87	93	989	java/lang/Exception
    //   224	231	989	java/lang/Exception
    //   240	248	989	java/lang/Exception
    //   257	268	989	java/lang/Exception
    //   277	289	989	java/lang/Exception
    //   298	309	989	java/lang/Exception
    //   318	330	989	java/lang/Exception
    //   339	351	989	java/lang/Exception
    //   360	371	989	java/lang/Exception
    //   380	392	989	java/lang/Exception
    //   401	412	989	java/lang/Exception
    //   598	613	989	java/lang/Exception
    //   622	628	989	java/lang/Exception
    //   756	771	989	java/lang/Exception
    //   780	786	989	java/lang/Exception
    //   63	78	1048	finally
    //   87	93	1048	finally
    //   224	231	1048	finally
    //   240	248	1048	finally
    //   257	268	1048	finally
    //   277	289	1048	finally
    //   298	309	1048	finally
    //   318	330	1048	finally
    //   339	351	1048	finally
    //   360	371	1048	finally
    //   380	392	1048	finally
    //   401	412	1048	finally
    //   598	613	1048	finally
    //   622	628	1048	finally
    //   756	771	1048	finally
    //   780	786	1048	finally
    //   415	420	1164	finally
    //   995	1009	1164	finally
    //   1011	1017	1164	finally
    //   429	444	1169	finally
    //   451	456	1169	finally
    //   796	812	1169	finally
    //   819	825	1169	finally
    //   944	952	1169	finally
    //   954	960	1169	finally
    //   415	420	1183	java/lang/Exception
    //   429	444	1191	java/lang/Exception
    //   451	456	1191	java/lang/Exception
    //   796	812	1191	java/lang/Exception
    //   819	825	1191	java/lang/Exception
    //   415	420	1198	com/tencent/wcdb/support/OperationCanceledException
    //   429	444	1205	com/tencent/wcdb/support/OperationCanceledException
    //   451	456	1205	com/tencent/wcdb/support/OperationCanceledException
    //   796	812	1205	com/tencent/wcdb/support/OperationCanceledException
    //   819	825	1205	com/tencent/wcdb/support/OperationCanceledException
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(23122);
    this.mCancellationSignal.cancel();
    ad.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
    AppMethodBeat.o(23122);
  }
  
  public static final class a
  {
    private LinkedHashSet<byte[]> obK;
    private LinkedHashSet<byte[]> obL;
    public String obg;
    public String obh;
    public String obi;
    public String obk;
    private List<String> obl;
    private List<String> obm;
    private byte[] obn;
    private byte[] obo;
    public a.c obr;
    public boolean obs;
    public a.b obt;
    
    public a()
    {
      AppMethodBeat.i(23114);
      this.obl = new ArrayList();
      this.obm = new ArrayList();
      this.obK = new LinkedHashSet();
      this.obL = new LinkedHashSet();
      AppMethodBeat.o(23114);
    }
    
    public final a Sd(String paramString)
    {
      AppMethodBeat.i(23116);
      this.obl.add(paramString);
      AppMethodBeat.o(23116);
      return this;
    }
    
    public final a Se(String paramString)
    {
      AppMethodBeat.i(23117);
      this.obm.add(paramString);
      AppMethodBeat.o(23117);
      return this;
    }
    
    public final a aT(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(23118);
      this.obn = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(23118);
      return this;
    }
    
    public final a aU(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(23119);
      this.obo = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(23119);
      return this;
    }
    
    public final a bQe()
    {
      AppMethodBeat.i(23115);
      a locala = new a((byte)0);
      a.a(locala, this.obg);
      a.b(locala, this.obh);
      a.c(locala, this.obi);
      a.d(locala, this.obk);
      a.a(locala, new ArrayList(this.obl));
      a.b(locala, new ArrayList(this.obm));
      a.a(locala, this.obn);
      a.b(locala, this.obo);
      a.a(locala, this.obr);
      a.c(locala, new ArrayList(this.obK));
      a.d(locala, new ArrayList(this.obL));
      a.a(locala, this.obs);
      a.a(locala, this.obt);
      AppMethodBeat.o(23115);
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void N(long paramLong1, long paramLong2);
    
    public abstract void T(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onCanceled();
    
    public abstract void onFailure();
    
    public abstract void onSuccess();
  }
  
  public static abstract interface c
  {
    public abstract Collection<byte[]> bPR();
    
    public abstract Collection<byte[]> bPS();
  }
  
  static abstract interface d
  {
    public abstract boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a
 * JD-Core Version:    0.7.0.1
 */