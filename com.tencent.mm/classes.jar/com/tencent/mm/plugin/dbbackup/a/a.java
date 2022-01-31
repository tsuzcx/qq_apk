package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.CancellationSignal;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONObject;

public final class a
  extends AsyncTask<Void, Integer, Integer>
{
  private static final String[] CONFLICT_VALUES;
  private static final SQLiteCipherSpec kUA;
  private SQLiteDatabase kUB;
  private String kUC;
  private String kUD;
  private String kUE;
  private String kUF;
  private List<String> kUG;
  private List<String> kUH;
  private byte[] kUI;
  private byte[] kUJ;
  private List<byte[]> kUK;
  private List<byte[]> kUL;
  private a.c kUM;
  private boolean kUN;
  private b kUO;
  private boolean kUP;
  private int kUQ;
  private long kUR;
  private long kUS;
  private final CancellationSignal mCancellationSignal;
  
  static
  {
    AppMethodBeat.i(19030);
    kUA = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    CONFLICT_VALUES = new String[] { "", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE" };
    AppMethodBeat.o(19030);
  }
  
  private a()
  {
    AppMethodBeat.i(19012);
    this.mCancellationSignal = new CancellationSignal();
    AppMethodBeat.o(19012);
  }
  
  private static long Jv(String paramString)
  {
    AppMethodBeat.i(19022);
    b localb = new b(paramString);
    paramString = localb;
    if (!localb.isDirectory()) {
      paramString = localb.dQI();
    }
    do
    {
      long l = paramString.getUsableSpace();
      if (l > 0L)
      {
        AppMethodBeat.o(19022);
        return l;
      }
      localb = paramString.dQI();
      paramString = localb;
    } while (localb != null);
    AppMethodBeat.o(19022);
    return 0L;
  }
  
  private int a(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, a.d paramd)
  {
    AppMethodBeat.i(19021);
    try
    {
      localObject = DatabaseUtils.stringForQuery(paramSQLiteDatabase, "SELECT sql FROM sqlite_master WHERE name = ?", new String[] { paramString });
      if ((localObject == null) || (((String)localObject).isEmpty()))
      {
        paramSQLiteDatabase = new SQLiteDoneException();
        AppMethodBeat.o(19021);
        throw paramSQLiteDatabase;
      }
    }
    catch (SQLiteDoneException paramSQLiteDatabase)
    {
      ab.e("MicroMsg.DBRecoveryTask", "There is no table named '%s' to copy.", new Object[] { paramString });
      if (this.kUB.inTransaction()) {
        this.kUB.endTransaction();
      }
      AppMethodBeat.o(19021);
      return -1;
      localObject = ((String)localObject).replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS ");
      this.kUB.execSQL((String)localObject, null, this.mCancellationSignal);
      if (!paramBoolean)
      {
        if (this.kUB.inTransaction()) {
          this.kUB.endTransaction();
        }
        AppMethodBeat.o(19021);
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
          paramString = this.kUB.compileStatement(localStringBuilder.toString());
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
          this.kUB.beginTransaction();
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
        if (this.kUB.inTransaction()) {
          this.kUB.endTransaction();
        }
        if (paramString != null) {
          paramString.close();
        }
        AppMethodBeat.o(19021);
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
      this.kUB.setTransactionSuccessful();
      if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
        ((Cursor)localObject).close();
      }
      if (this.kUB.inTransaction()) {
        this.kUB.endTransaction();
      }
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(19021);
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
  
  @SuppressLint({"DefaultLocale"})
  private static void b(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(19024);
    com.tencent.mm.plugin.report.e.qrI.g("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[] { Integer.valueOf(paramInt), paramString, "\n" + bo.l(paramThrowable) }), null);
    AppMethodBeat.o(19024);
  }
  
  private int biV()
  {
    long l2 = 0L;
    AppMethodBeat.i(19015);
    ab.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
    if ((this.kUC == null) || (this.kUC.isEmpty()))
    {
      AppMethodBeat.o(19015);
      return -1;
    }
    this.kUP = false;
    this.kUQ = 300000;
    if (this.kUF != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(com.tencent.mm.vfs.e.cS(this.kUF));
        this.kUQ = localJSONObject.getInt("message");
        this.kUP = true;
        l1 = localJSONObject.getLong("dbSize");
        if (this.kUE != null) {
          l2 = com.tencent.mm.vfs.e.avI(this.kUE);
        }
        this.kUR = Math.max(l1, l2);
        this.kUR += Math.max(this.kUR / 10L, 67108864L);
        this.kUS = Jv(this.kUC);
        if (this.kUR <= this.kUS) {
          break;
        }
        ab.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[] { Long.valueOf(this.kUR), Long.valueOf(this.kUS) });
        AppMethodBeat.o(19015);
        return -2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        ab.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.kUF);
        l1 = 0L;
        continue;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.DBRecoveryTask", localException, "Cannot read statistics from file.", new Object[0]);
      }
      long l1 = 0L;
    }
    ab.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", new Object[] { Long.valueOf(this.kUR), Long.valueOf(this.kUS), Integer.valueOf(this.kUQ) });
    AppMethodBeat.o(19015);
    return 0;
  }
  
  private int biW()
  {
    AppMethodBeat.i(19016);
    if (this.kUB != null)
    {
      if (this.kUB.isOpen()) {
        this.kUB.close();
      }
      this.kUB = null;
    }
    this.mCancellationSignal.throwIfCanceled();
    String str = this.kUC + '-' + bo.Ng(6);
    ab.i("MicroMsg.DBRecoveryTask", "Open target database: ".concat(String.valueOf(str)));
    try
    {
      this.kUB = SQLiteDatabase.openOrCreateDatabase(str, this.kUI, kUA, null, null, 1);
      DatabaseUtils.stringForQuery(this.kUB, "PRAGMA journal_mode=OFF;", null);
      this.kUB.execSQL("PRAGMA synchronous=OFF;");
      AppMethodBeat.o(19016);
      return 0;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", new Object[] { str, localException.getMessage() });
      b(1, "Cannot open target database", localException);
      AppMethodBeat.o(19016);
      throw localException;
    }
  }
  
  /* Error */
  private int biX()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore_2
    //   8: sipush 19018
    //   11: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_0
    //   15: getfield 98	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   18: invokevirtual 454	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   21: iconst_5
    //   22: anewarray 74	java/lang/String
    //   25: astore 6
    //   27: aload 6
    //   29: iconst_0
    //   30: ldc_w 398
    //   33: aastore
    //   34: aload 6
    //   36: iconst_1
    //   37: ldc_w 486
    //   40: aastore
    //   41: aload 6
    //   43: iconst_2
    //   44: ldc_w 488
    //   47: aastore
    //   48: aload 6
    //   50: iconst_3
    //   51: ldc_w 490
    //   54: aastore
    //   55: aload 6
    //   57: iconst_4
    //   58: ldc_w 492
    //   61: aastore
    //   62: aload_0
    //   63: getfield 328	com/tencent/mm/plugin/dbbackup/a/a:kUG	Ljava/util/List;
    //   66: invokeinterface 498 1 0
    //   71: astore 9
    //   73: aconst_null
    //   74: astore 4
    //   76: aload 9
    //   78: invokeinterface 503 1 0
    //   83: ifeq +884 -> 967
    //   86: aload 9
    //   88: invokeinterface 507 1 0
    //   93: checkcast 74	java/lang/String
    //   96: astore 10
    //   98: aload 10
    //   100: invokestatic 511	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   103: ifne +22 -> 125
    //   106: ldc 139
    //   108: ldc_w 513
    //   111: aload 10
    //   113: invokestatic 177	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -46 -> 76
    //   125: iconst_0
    //   126: istore_1
    //   127: aload 4
    //   129: astore 5
    //   131: aload 5
    //   133: astore 4
    //   135: iload_1
    //   136: aload_0
    //   137: getfield 515	com/tencent/mm/plugin/dbbackup/a/a:kUK	Ljava/util/List;
    //   140: invokeinterface 518 1 0
    //   145: if_icmpge -69 -> 76
    //   148: aload_0
    //   149: getfield 515	com/tencent/mm/plugin/dbbackup/a/a:kUK	Ljava/util/List;
    //   152: iload_1
    //   153: invokeinterface 522 2 0
    //   158: checkcast 523	[B
    //   161: astore 11
    //   163: aload 5
    //   165: astore 4
    //   167: aload 10
    //   169: aload 11
    //   171: aload 6
    //   173: invokestatic 529	com/tencent/wcdb/repair/RepairKit$MasterInfo:load	(Ljava/lang/String;[B[Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   176: astore 5
    //   178: aload 5
    //   180: astore 4
    //   182: ldc 139
    //   184: new 205	java/lang/StringBuilder
    //   187: dup
    //   188: ldc_w 531
    //   191: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload 10
    //   196: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 533
    //   202: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload_1
    //   206: invokevirtual 536	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload 5
    //   217: astore 4
    //   219: aload 4
    //   221: ifnonnull +403 -> 624
    //   224: aload 6
    //   226: invokestatic 540	com/tencent/wcdb/repair/RepairKit$MasterInfo:make	([Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   229: astore 6
    //   231: ldc 139
    //   233: ldc_w 542
    //   236: invokestatic 545	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: iconst_0
    //   240: istore_3
    //   241: iconst_1
    //   242: newarray int
    //   244: astore 9
    //   246: aload 9
    //   248: iconst_0
    //   249: iconst_0
    //   250: iastore
    //   251: aload 8
    //   253: astore 5
    //   255: ldc 139
    //   257: new 205	java/lang/StringBuilder
    //   260: dup
    //   261: ldc_w 547
    //   264: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   267: aload_0
    //   268: getfield 408	com/tencent/mm/plugin/dbbackup/a/a:kUE	Ljava/lang/String;
    //   271: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: iload_2
    //   281: istore_1
    //   282: aload 7
    //   284: astore 4
    //   286: aload 8
    //   288: astore 5
    //   290: iload_1
    //   291: aload_0
    //   292: getfield 549	com/tencent/mm/plugin/dbbackup/a/a:kUL	Ljava/util/List;
    //   295: invokeinterface 518 1 0
    //   300: if_icmpge +69 -> 369
    //   303: aload 8
    //   305: astore 5
    //   307: aload_0
    //   308: getfield 549	com/tencent/mm/plugin/dbbackup/a/a:kUL	Ljava/util/List;
    //   311: iload_1
    //   312: invokeinterface 522 2 0
    //   317: checkcast 523	[B
    //   320: astore 4
    //   322: aload 8
    //   324: astore 5
    //   326: new 551	com/tencent/wcdb/repair/RepairKit
    //   329: dup
    //   330: aload_0
    //   331: getfield 408	com/tencent/mm/plugin/dbbackup/a/a:kUE	Ljava/lang/String;
    //   334: aload 4
    //   336: getstatic 72	com/tencent/mm/plugin/dbbackup/a/a:kUA	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   339: aload 6
    //   341: invokespecial 554	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   344: astore 4
    //   346: aload 4
    //   348: invokevirtual 557	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   351: ifne +290 -> 641
    //   354: ldc 139
    //   356: ldc_w 559
    //   359: iload_1
    //   360: invokestatic 561	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   363: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   366: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 4
    //   371: ifnonnull +593 -> 964
    //   374: aload 4
    //   376: astore 5
    //   378: ldc 139
    //   380: ldc_w 563
    //   383: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 4
    //   388: astore 5
    //   390: new 551	com/tencent/wcdb/repair/RepairKit
    //   393: dup
    //   394: aload_0
    //   395: getfield 408	com/tencent/mm/plugin/dbbackup/a/a:kUE	Ljava/lang/String;
    //   398: aload_0
    //   399: getfield 549	com/tencent/mm/plugin/dbbackup/a/a:kUL	Ljava/util/List;
    //   402: iconst_0
    //   403: invokeinterface 522 2 0
    //   408: checkcast 523	[B
    //   411: getstatic 72	com/tencent/mm/plugin/dbbackup/a/a:kUA	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   414: aload 6
    //   416: invokespecial 554	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   419: astore 6
    //   421: aload 6
    //   423: astore 4
    //   425: aload 4
    //   427: astore 6
    //   429: aload 4
    //   431: new 565	com/tencent/mm/plugin/dbbackup/a/a$1
    //   434: dup
    //   435: aload_0
    //   436: aload 9
    //   438: invokespecial 568	com/tencent/mm/plugin/dbbackup/a/a$1:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;[I)V
    //   441: invokevirtual 572	com/tencent/wcdb/repair/RepairKit:setCallback	(Lcom/tencent/wcdb/repair/RepairKit$Callback;)V
    //   444: aload 4
    //   446: astore 6
    //   448: aload 4
    //   450: aload_0
    //   451: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   454: iconst_0
    //   455: aload_0
    //   456: getfield 98	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   459: invokevirtual 576	com/tencent/wcdb/repair/RepairKit:output	(Lcom/tencent/wcdb/database/SQLiteDatabase;ILcom/tencent/wcdb/support/CancellationSignal;)I
    //   462: istore_1
    //   463: iload_1
    //   464: ifne +291 -> 755
    //   467: aload 4
    //   469: astore 6
    //   471: aload 4
    //   473: invokevirtual 557	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   476: ifeq +187 -> 663
    //   479: aload 4
    //   481: astore 6
    //   483: aload 4
    //   485: invokevirtual 579	com/tencent/wcdb/repair/RepairKit:isDataCorrupted	()Z
    //   488: ifeq +175 -> 663
    //   491: aload 4
    //   493: astore 6
    //   495: new 484	java/lang/RuntimeException
    //   498: dup
    //   499: ldc_w 581
    //   502: invokespecial 582	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   505: astore 5
    //   507: aload 4
    //   509: astore 6
    //   511: sipush 19018
    //   514: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   517: aload 4
    //   519: astore 6
    //   521: aload 5
    //   523: athrow
    //   524: astore 6
    //   526: sipush 19018
    //   529: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: aload 6
    //   534: athrow
    //   535: astore 6
    //   537: aload 4
    //   539: astore 5
    //   541: aload 6
    //   543: astore 4
    //   545: aload 5
    //   547: ifnull +8 -> 555
    //   550: aload 5
    //   552: invokevirtual 585	com/tencent/wcdb/repair/RepairKit:release	()V
    //   555: sipush 19018
    //   558: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   561: aload 4
    //   563: athrow
    //   564: astore 5
    //   566: ldc 139
    //   568: new 205	java/lang/StringBuilder
    //   571: dup
    //   572: ldc_w 587
    //   575: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   578: aload 5
    //   580: invokevirtual 475	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   583: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 589
    //   589: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload 10
    //   594: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: ldc_w 533
    //   600: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: iload_1
    //   604: invokevirtual 536	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   607: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 591	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: iload_1
    //   614: iconst_1
    //   615: iadd
    //   616: istore_1
    //   617: aload 4
    //   619: astore 5
    //   621: goto -490 -> 131
    //   624: ldc 139
    //   626: ldc_w 593
    //   629: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: iconst_1
    //   633: istore_3
    //   634: aload 4
    //   636: astore 6
    //   638: goto -397 -> 241
    //   641: ldc 139
    //   643: ldc_w 595
    //   646: iload_1
    //   647: invokestatic 561	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   650: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   653: invokestatic 545	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   656: iload_1
    //   657: iconst_1
    //   658: iadd
    //   659: istore_1
    //   660: goto -378 -> 282
    //   663: aload 4
    //   665: astore 6
    //   667: ldc 139
    //   669: ldc_w 597
    //   672: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   675: aload 4
    //   677: astore 6
    //   679: aload_0
    //   680: getfield 385	com/tencent/mm/plugin/dbbackup/a/a:kUP	Z
    //   683: ifeq +54 -> 737
    //   686: aload 4
    //   688: astore 6
    //   690: aload 9
    //   692: iconst_0
    //   693: iaload
    //   694: i2f
    //   695: aload_0
    //   696: getfield 122	com/tencent/mm/plugin/dbbackup/a/a:kUQ	I
    //   699: i2f
    //   700: fdiv
    //   701: ldc_w 598
    //   704: fcmpg
    //   705: ifgt +32 -> 737
    //   708: aload 4
    //   710: astore 6
    //   712: getstatic 349	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   715: sipush 181
    //   718: sipush 181
    //   721: bipush 62
    //   723: bipush 63
    //   725: aload_0
    //   726: getfield 122	com/tencent/mm/plugin/dbbackup/a/a:kUQ	I
    //   729: aload 9
    //   731: iconst_0
    //   732: iaload
    //   733: iconst_1
    //   734: invokevirtual 601	com/tencent/mm/plugin/report/e:a	(IIIIIIZ)V
    //   737: aload 4
    //   739: ifnull +8 -> 747
    //   742: aload 4
    //   744: invokevirtual 585	com/tencent/wcdb/repair/RepairKit:release	()V
    //   747: sipush 19018
    //   750: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   753: iload_1
    //   754: ireturn
    //   755: iload_1
    //   756: iconst_1
    //   757: if_icmpne +99 -> 856
    //   760: aload 4
    //   762: astore 6
    //   764: ldc 139
    //   766: ldc_w 603
    //   769: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   772: aload 4
    //   774: astore 6
    //   776: aload_0
    //   777: getfield 98	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   780: invokevirtual 454	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   783: goto -108 -> 675
    //   786: astore 5
    //   788: aload 4
    //   790: astore 6
    //   792: ldc 139
    //   794: new 205	java/lang/StringBuilder
    //   797: dup
    //   798: ldc_w 605
    //   801: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   804: aload 5
    //   806: invokevirtual 606	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   809: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: invokestatic 591	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   818: aload 4
    //   820: astore 6
    //   822: iconst_2
    //   823: ldc_w 608
    //   826: iload_3
    //   827: invokestatic 611	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   830: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   833: aload 5
    //   835: invokestatic 479	com/tencent/mm/plugin/dbbackup/a/a:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   838: aload 4
    //   840: ifnull +8 -> 848
    //   843: aload 4
    //   845: invokevirtual 585	com/tencent/wcdb/repair/RepairKit:release	()V
    //   848: sipush 19018
    //   851: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   854: iconst_m1
    //   855: ireturn
    //   856: aload 4
    //   858: astore 6
    //   860: new 484	java/lang/RuntimeException
    //   863: dup
    //   864: ldc_w 613
    //   867: invokespecial 582	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   870: astore 5
    //   872: aload 4
    //   874: astore 6
    //   876: sipush 19018
    //   879: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   882: aload 4
    //   884: astore 6
    //   886: aload 5
    //   888: athrow
    //   889: astore 4
    //   891: aload 6
    //   893: astore 5
    //   895: goto -350 -> 545
    //   898: astore 4
    //   900: aconst_null
    //   901: astore 5
    //   903: goto -358 -> 545
    //   906: astore 6
    //   908: aload 4
    //   910: astore 5
    //   912: aload 6
    //   914: astore 4
    //   916: goto -371 -> 545
    //   919: astore 6
    //   921: aload 4
    //   923: astore 5
    //   925: aload 6
    //   927: astore 4
    //   929: goto -384 -> 545
    //   932: astore 5
    //   934: aconst_null
    //   935: astore 4
    //   937: goto -149 -> 788
    //   940: astore 5
    //   942: goto -154 -> 788
    //   945: astore 5
    //   947: goto -159 -> 788
    //   950: astore 6
    //   952: aload 5
    //   954: astore 4
    //   956: goto -430 -> 526
    //   959: astore 6
    //   961: goto -435 -> 526
    //   964: goto -539 -> 425
    //   967: goto -748 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	970	0	this	a
    //   126	632	1	i	int
    //   7	274	2	j	int
    //   240	587	3	bool	boolean
    //   74	809	4	localObject1	Object
    //   889	1	4	localObject2	Object
    //   898	11	4	localObject3	Object
    //   914	41	4	localObject4	Object
    //   129	422	5	localObject5	Object
    //   564	15	5	localException	Exception
    //   619	1	5	localObject6	Object
    //   786	48	5	localRuntimeException1	java.lang.RuntimeException
    //   870	54	5	localObject7	Object
    //   932	1	5	localRuntimeException2	java.lang.RuntimeException
    //   940	1	5	localRuntimeException3	java.lang.RuntimeException
    //   945	8	5	localRuntimeException4	java.lang.RuntimeException
    //   25	495	6	localObject8	Object
    //   524	9	6	localOperationCanceledException1	com.tencent.wcdb.support.OperationCanceledException
    //   535	7	6	localObject9	Object
    //   636	256	6	localObject10	Object
    //   906	7	6	localObject11	Object
    //   919	7	6	localObject12	Object
    //   950	1	6	localOperationCanceledException2	com.tencent.wcdb.support.OperationCanceledException
    //   959	1	6	localOperationCanceledException3	com.tencent.wcdb.support.OperationCanceledException
    //   4	279	7	localObject13	Object
    //   1	322	8	localObject14	Object
    //   71	659	9	localObject15	Object
    //   96	497	10	str	String
    //   161	9	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   429	444	524	com/tencent/wcdb/support/OperationCanceledException
    //   448	463	524	com/tencent/wcdb/support/OperationCanceledException
    //   471	479	524	com/tencent/wcdb/support/OperationCanceledException
    //   483	491	524	com/tencent/wcdb/support/OperationCanceledException
    //   495	507	524	com/tencent/wcdb/support/OperationCanceledException
    //   511	517	524	com/tencent/wcdb/support/OperationCanceledException
    //   521	524	524	com/tencent/wcdb/support/OperationCanceledException
    //   667	675	524	com/tencent/wcdb/support/OperationCanceledException
    //   679	686	524	com/tencent/wcdb/support/OperationCanceledException
    //   690	708	524	com/tencent/wcdb/support/OperationCanceledException
    //   712	737	524	com/tencent/wcdb/support/OperationCanceledException
    //   764	772	524	com/tencent/wcdb/support/OperationCanceledException
    //   776	783	524	com/tencent/wcdb/support/OperationCanceledException
    //   860	872	524	com/tencent/wcdb/support/OperationCanceledException
    //   876	882	524	com/tencent/wcdb/support/OperationCanceledException
    //   886	889	524	com/tencent/wcdb/support/OperationCanceledException
    //   526	535	535	finally
    //   167	178	564	java/lang/Exception
    //   182	215	564	java/lang/Exception
    //   429	444	786	java/lang/RuntimeException
    //   448	463	786	java/lang/RuntimeException
    //   471	479	786	java/lang/RuntimeException
    //   483	491	786	java/lang/RuntimeException
    //   495	507	786	java/lang/RuntimeException
    //   511	517	786	java/lang/RuntimeException
    //   521	524	786	java/lang/RuntimeException
    //   667	675	786	java/lang/RuntimeException
    //   679	686	786	java/lang/RuntimeException
    //   690	708	786	java/lang/RuntimeException
    //   712	737	786	java/lang/RuntimeException
    //   764	772	786	java/lang/RuntimeException
    //   776	783	786	java/lang/RuntimeException
    //   860	872	786	java/lang/RuntimeException
    //   876	882	786	java/lang/RuntimeException
    //   886	889	786	java/lang/RuntimeException
    //   429	444	889	finally
    //   448	463	889	finally
    //   471	479	889	finally
    //   483	491	889	finally
    //   495	507	889	finally
    //   511	517	889	finally
    //   521	524	889	finally
    //   667	675	889	finally
    //   679	686	889	finally
    //   690	708	889	finally
    //   712	737	889	finally
    //   764	772	889	finally
    //   776	783	889	finally
    //   792	818	889	finally
    //   822	838	889	finally
    //   860	872	889	finally
    //   876	882	889	finally
    //   886	889	889	finally
    //   255	280	898	finally
    //   290	303	898	finally
    //   307	322	898	finally
    //   326	346	898	finally
    //   346	369	906	finally
    //   641	656	906	finally
    //   378	386	919	finally
    //   390	421	919	finally
    //   255	280	932	java/lang/RuntimeException
    //   290	303	932	java/lang/RuntimeException
    //   307	322	932	java/lang/RuntimeException
    //   326	346	932	java/lang/RuntimeException
    //   346	369	940	java/lang/RuntimeException
    //   641	656	940	java/lang/RuntimeException
    //   378	386	945	java/lang/RuntimeException
    //   390	421	945	java/lang/RuntimeException
    //   255	280	950	com/tencent/wcdb/support/OperationCanceledException
    //   290	303	950	com/tencent/wcdb/support/OperationCanceledException
    //   307	322	950	com/tencent/wcdb/support/OperationCanceledException
    //   326	346	950	com/tencent/wcdb/support/OperationCanceledException
    //   378	386	950	com/tencent/wcdb/support/OperationCanceledException
    //   390	421	950	com/tencent/wcdb/support/OperationCanceledException
    //   346	369	959	com/tencent/wcdb/support/OperationCanceledException
    //   641	656	959	com/tencent/wcdb/support/OperationCanceledException
  }
  
  /* Error */
  private int biY()
  {
    // Byte code:
    //   0: sipush 19019
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 98	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   10: invokevirtual 454	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   13: ldc 139
    //   15: ldc_w 616
    //   18: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 339	com/tencent/mm/plugin/dbbackup/a/a:kUH	Ljava/util/List;
    //   25: invokeinterface 498 1 0
    //   30: astore 5
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 5
    //   36: invokeinterface 503 1 0
    //   41: ifeq +98 -> 139
    //   44: aload 5
    //   46: invokeinterface 507 1 0
    //   51: checkcast 74	java/lang/String
    //   54: astore 4
    //   56: new 618	com/tencent/wcdb/repair/RecoverKit
    //   59: dup
    //   60: aload_0
    //   61: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: aload 4
    //   66: aload_0
    //   67: getfield 515	com/tencent/mm/plugin/dbbackup/a/a:kUK	Ljava/util/List;
    //   70: iconst_0
    //   71: invokeinterface 522 2 0
    //   76: checkcast 523	[B
    //   79: invokespecial 621	com/tencent/wcdb/repair/RecoverKit:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[B)V
    //   82: astore_3
    //   83: ldc 139
    //   85: ldc_w 623
    //   88: aload 4
    //   90: invokestatic 177	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   96: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_3
    //   100: astore_2
    //   101: goto -67 -> 34
    //   104: astore 4
    //   106: aload_3
    //   107: astore_2
    //   108: aload 4
    //   110: astore_3
    //   111: ldc 139
    //   113: new 205	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 625
    //   120: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_3
    //   124: invokevirtual 475	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 591	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -102 -> 34
    //   139: aload_2
    //   140: ifnonnull +11 -> 151
    //   143: sipush 19019
    //   146: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_m1
    //   150: ireturn
    //   151: aload_2
    //   152: iconst_0
    //   153: aload_0
    //   154: getfield 98	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   157: invokevirtual 629	com/tencent/wcdb/repair/RecoverKit:run	(ZLcom/tencent/wcdb/support/CancellationSignal;)I
    //   160: istore_1
    //   161: iload_1
    //   162: ifne +23 -> 185
    //   165: ldc 139
    //   167: ldc_w 631
    //   170: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_2
    //   174: invokevirtual 632	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   177: sipush 19019
    //   180: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iload_1
    //   184: ireturn
    //   185: iload_1
    //   186: iconst_1
    //   187: if_icmpne +43 -> 230
    //   190: ldc 139
    //   192: ldc_w 634
    //   195: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 98	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   202: invokevirtual 454	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   205: goto -32 -> 173
    //   208: astore_3
    //   209: sipush 19019
    //   212: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_3
    //   216: athrow
    //   217: astore_3
    //   218: aload_2
    //   219: invokevirtual 632	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   222: sipush 19019
    //   225: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_3
    //   229: athrow
    //   230: ldc 139
    //   232: ldc_w 636
    //   235: invokestatic 591	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -65 -> 173
    //   241: astore_3
    //   242: ldc 139
    //   244: new 205	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 605
    //   251: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_3
    //   255: invokevirtual 475	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 591	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: iconst_4
    //   268: ldc_w 638
    //   271: aload_3
    //   272: invokestatic 479	com/tencent/mm/plugin/dbbackup/a/a:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload_2
    //   276: invokevirtual 632	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   279: sipush 19019
    //   282: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  private int biZ()
  {
    // Byte code:
    //   0: sipush 19020
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 337	com/tencent/mm/plugin/dbbackup/a/a:kUD	Ljava/lang/String;
    //   10: ifnull +13 -> 23
    //   13: aload_0
    //   14: getfield 337	com/tencent/mm/plugin/dbbackup/a/a:kUD	Ljava/lang/String;
    //   17: invokevirtual 136	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: sipush 19020
    //   26: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: ldc 139
    //   33: ldc_w 641
    //   36: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   43: ldc_w 643
    //   46: aconst_null
    //   47: invokestatic 185	com/tencent/wcdb/DatabaseUtils:longForQuery	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   50: l2i
    //   51: istore_1
    //   52: iconst_1
    //   53: newarray long
    //   55: astore 9
    //   57: aload 9
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: ldc_w 645
    //   67: aconst_null
    //   68: invokestatic 185	com/tencent/wcdb/DatabaseUtils:longForQuery	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   71: lconst_1
    //   72: ladd
    //   73: lastore
    //   74: aload 9
    //   76: iconst_0
    //   77: laload
    //   78: ldc2_w 646
    //   81: lcmp
    //   82: ifle +21 -> 103
    //   85: aload 9
    //   87: iconst_0
    //   88: laload
    //   89: ldc2_w 648
    //   92: lcmp
    //   93: ifgt +10 -> 103
    //   96: aload 9
    //   98: iconst_0
    //   99: ldc2_w 650
    //   102: lastore
    //   103: new 653	java/util/HashMap
    //   106: dup
    //   107: iload_1
    //   108: iload_1
    //   109: iconst_2
    //   110: idiv
    //   111: iadd
    //   112: sipush 10240
    //   115: invokestatic 656	java/lang/Math:max	(II)I
    //   118: invokespecial 657	java/util/HashMap:<init>	(I)V
    //   121: astore 8
    //   123: new 659	com/tencent/mm/plugin/dbbackup/a/a$2
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 662	com/tencent/mm/plugin/dbbackup/a/a$2:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;)V
    //   131: astore_2
    //   132: aload_0
    //   133: getfield 337	com/tencent/mm/plugin/dbbackup/a/a:kUD	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 373	com/tencent/mm/plugin/dbbackup/a/a:kUJ	[B
    //   140: getstatic 72	com/tencent/mm/plugin/dbbackup/a/a:kUA	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   143: aconst_null
    //   144: iconst_1
    //   145: aload_2
    //   146: iconst_1
    //   147: invokestatic 666	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   150: astore_2
    //   151: aload_0
    //   152: aload_2
    //   153: ldc_w 668
    //   156: iconst_0
    //   157: iconst_0
    //   158: iconst_0
    //   159: aconst_null
    //   160: invokespecial 670	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   163: pop
    //   164: aload_0
    //   165: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   168: invokevirtual 243	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   171: iconst_3
    //   172: anewarray 143	java/lang/Object
    //   175: astore 10
    //   177: aload 10
    //   179: iconst_0
    //   180: sipush 8197
    //   183: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: aload 10
    //   189: iconst_1
    //   190: iconst_3
    //   191: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: aload 10
    //   197: iconst_2
    //   198: ldc 76
    //   200: aastore
    //   201: aload_0
    //   202: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   205: ldc_w 672
    //   208: aload 10
    //   210: invokevirtual 675	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload 10
    //   215: iconst_0
    //   216: bipush 15
    //   218: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aastore
    //   222: aload 10
    //   224: iconst_1
    //   225: iconst_1
    //   226: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: aload 10
    //   232: iconst_2
    //   233: ldc_w 677
    //   236: aastore
    //   237: aload_0
    //   238: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   241: ldc_w 672
    //   244: aload 10
    //   246: invokevirtual 675	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: aload 10
    //   251: iconst_0
    //   252: bipush 89
    //   254: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: aload 10
    //   260: iconst_1
    //   261: iconst_1
    //   262: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: aload 10
    //   268: iconst_2
    //   269: ldc_w 679
    //   272: aastore
    //   273: aload_0
    //   274: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   277: ldc_w 672
    //   280: aload 10
    //   282: invokevirtual 675	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload_2
    //   286: getstatic 191	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   289: ldc_w 681
    //   292: iconst_1
    //   293: anewarray 74	java/lang/String
    //   296: dup
    //   297: iconst_0
    //   298: ldc_w 683
    //   301: aastore
    //   302: ldc_w 668
    //   305: invokevirtual 686	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   308: astore 5
    //   310: aload_2
    //   311: astore 4
    //   313: aload 5
    //   315: astore_3
    //   316: aload 5
    //   318: astore 6
    //   320: aload 5
    //   322: astore 7
    //   324: aload 5
    //   326: invokeinterface 689 1 0
    //   331: ifeq +113 -> 444
    //   334: aload_2
    //   335: astore 4
    //   337: aload 5
    //   339: astore_3
    //   340: aload 5
    //   342: astore 6
    //   344: aload 5
    //   346: astore 7
    //   348: aload 10
    //   350: iconst_0
    //   351: aload 5
    //   353: iconst_0
    //   354: invokeinterface 691 2 0
    //   359: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: aload_2
    //   364: astore 4
    //   366: aload 5
    //   368: astore_3
    //   369: aload 5
    //   371: astore 6
    //   373: aload 5
    //   375: astore 7
    //   377: aload 10
    //   379: iconst_1
    //   380: aload 5
    //   382: iconst_1
    //   383: invokeinterface 691 2 0
    //   388: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: aastore
    //   392: aload_2
    //   393: astore 4
    //   395: aload 5
    //   397: astore_3
    //   398: aload 5
    //   400: astore 6
    //   402: aload 5
    //   404: astore 7
    //   406: aload 10
    //   408: iconst_2
    //   409: aload 5
    //   411: iconst_2
    //   412: invokeinterface 294 2 0
    //   417: aastore
    //   418: aload_2
    //   419: astore 4
    //   421: aload 5
    //   423: astore_3
    //   424: aload 5
    //   426: astore 6
    //   428: aload 5
    //   430: astore 7
    //   432: aload_0
    //   433: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   436: ldc_w 672
    //   439: aload 10
    //   441: invokevirtual 675	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: aload_2
    //   445: astore 4
    //   447: aload 5
    //   449: astore_3
    //   450: aload 5
    //   452: astore 6
    //   454: aload 5
    //   456: astore 7
    //   458: aload 5
    //   460: invokeinterface 273 1 0
    //   465: aload_2
    //   466: astore 4
    //   468: aload 5
    //   470: astore_3
    //   471: aload 5
    //   473: astore 6
    //   475: aload 5
    //   477: astore 7
    //   479: aload_2
    //   480: getstatic 191	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   483: ldc_w 681
    //   486: iconst_1
    //   487: anewarray 74	java/lang/String
    //   490: dup
    //   491: iconst_0
    //   492: ldc_w 693
    //   495: aastore
    //   496: ldc_w 668
    //   499: invokevirtual 686	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   502: astore 5
    //   504: aload_2
    //   505: astore 4
    //   507: aload 5
    //   509: astore_3
    //   510: aload 5
    //   512: astore 6
    //   514: aload 5
    //   516: astore 7
    //   518: aload 5
    //   520: invokeinterface 689 1 0
    //   525: ifeq +113 -> 638
    //   528: aload_2
    //   529: astore 4
    //   531: aload 5
    //   533: astore_3
    //   534: aload 5
    //   536: astore 6
    //   538: aload 5
    //   540: astore 7
    //   542: aload 10
    //   544: iconst_0
    //   545: aload 5
    //   547: iconst_0
    //   548: invokeinterface 691 2 0
    //   553: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   556: aastore
    //   557: aload_2
    //   558: astore 4
    //   560: aload 5
    //   562: astore_3
    //   563: aload 5
    //   565: astore 6
    //   567: aload 5
    //   569: astore 7
    //   571: aload 10
    //   573: iconst_1
    //   574: aload 5
    //   576: iconst_1
    //   577: invokeinterface 691 2 0
    //   582: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: aastore
    //   586: aload_2
    //   587: astore 4
    //   589: aload 5
    //   591: astore_3
    //   592: aload 5
    //   594: astore 6
    //   596: aload 5
    //   598: astore 7
    //   600: aload 10
    //   602: iconst_2
    //   603: aload 5
    //   605: iconst_2
    //   606: invokeinterface 294 2 0
    //   611: aastore
    //   612: aload_2
    //   613: astore 4
    //   615: aload 5
    //   617: astore_3
    //   618: aload 5
    //   620: astore 6
    //   622: aload 5
    //   624: astore 7
    //   626: aload_0
    //   627: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   630: ldc_w 672
    //   633: aload 10
    //   635: invokevirtual 675	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   638: aload_2
    //   639: astore 4
    //   641: aload 5
    //   643: astore_3
    //   644: aload 5
    //   646: astore 6
    //   648: aload 5
    //   650: astore 7
    //   652: aload 5
    //   654: invokeinterface 273 1 0
    //   659: aload_2
    //   660: astore 4
    //   662: aload 5
    //   664: astore_3
    //   665: aload 5
    //   667: astore 6
    //   669: aload 5
    //   671: astore 7
    //   673: aload_0
    //   674: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   677: invokevirtual 316	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   680: aload_2
    //   681: astore 4
    //   683: aload 5
    //   685: astore_3
    //   686: aload 5
    //   688: astore 6
    //   690: aload 5
    //   692: astore 7
    //   694: aload_0
    //   695: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   698: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   701: aload_2
    //   702: astore 4
    //   704: aload 5
    //   706: astore_3
    //   707: aload 5
    //   709: astore 6
    //   711: aload 5
    //   713: astore 7
    //   715: aload_2
    //   716: getstatic 191	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   719: ldc_w 695
    //   722: aconst_null
    //   723: ldc_w 398
    //   726: invokevirtual 686	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   729: astore 5
    //   731: aload 5
    //   733: astore 6
    //   735: aload 6
    //   737: astore_3
    //   738: aload 6
    //   740: astore 4
    //   742: aload 6
    //   744: astore 5
    //   746: aload 6
    //   748: ldc_w 697
    //   751: invokeinterface 700 2 0
    //   756: istore_1
    //   757: aload 6
    //   759: astore_3
    //   760: aload 6
    //   762: astore 4
    //   764: aload 6
    //   766: astore 5
    //   768: aload 6
    //   770: invokeinterface 273 1 0
    //   775: aload 6
    //   777: astore_3
    //   778: aload 6
    //   780: astore 4
    //   782: aload 6
    //   784: astore 5
    //   786: aload_0
    //   787: aload_2
    //   788: ldc_w 398
    //   791: iconst_4
    //   792: iconst_1
    //   793: iconst_5
    //   794: new 702	com/tencent/mm/plugin/dbbackup/a/a$3
    //   797: dup
    //   798: aload_0
    //   799: iload_1
    //   800: aload 9
    //   802: aload 8
    //   804: invokespecial 705	com/tencent/mm/plugin/dbbackup/a/a$3:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;I[JLjava/util/HashMap;)V
    //   807: invokespecial 670	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   810: pop
    //   811: aload 6
    //   813: astore_3
    //   814: aload 6
    //   816: astore 4
    //   818: aload 6
    //   820: astore 5
    //   822: aload_0
    //   823: aload_2
    //   824: ldc_w 492
    //   827: iconst_5
    //   828: iconst_1
    //   829: iconst_0
    //   830: aconst_null
    //   831: invokespecial 670	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   834: pop
    //   835: aload 6
    //   837: astore_3
    //   838: aload 6
    //   840: astore 4
    //   842: aload 6
    //   844: astore 5
    //   846: aload_2
    //   847: getstatic 191	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   850: ldc_w 707
    //   853: aconst_null
    //   854: ldc_w 486
    //   857: invokevirtual 686	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   860: astore 6
    //   862: aload 6
    //   864: astore_3
    //   865: aload 6
    //   867: astore 4
    //   869: aload 6
    //   871: astore 5
    //   873: aload 6
    //   875: ldc_w 709
    //   878: invokeinterface 700 2 0
    //   883: istore_1
    //   884: aload 6
    //   886: astore_3
    //   887: aload 6
    //   889: astore 4
    //   891: aload 6
    //   893: astore 5
    //   895: aload 6
    //   897: invokeinterface 273 1 0
    //   902: aload 6
    //   904: astore_3
    //   905: aload 6
    //   907: astore 4
    //   909: aload 6
    //   911: astore 5
    //   913: aload_0
    //   914: aload_2
    //   915: ldc_w 486
    //   918: iconst_4
    //   919: iconst_1
    //   920: iconst_0
    //   921: new 711	com/tencent/mm/plugin/dbbackup/a/a$4
    //   924: dup
    //   925: aload_0
    //   926: iload_1
    //   927: aload 8
    //   929: invokespecial 714	com/tencent/mm/plugin/dbbackup/a/a$4:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   932: invokespecial 670	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   935: pop
    //   936: aload 6
    //   938: astore_3
    //   939: aload 6
    //   941: astore 4
    //   943: aload 6
    //   945: astore 5
    //   947: aload_2
    //   948: getstatic 191	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   951: ldc_w 716
    //   954: aconst_null
    //   955: ldc_w 488
    //   958: invokevirtual 686	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   961: astore 6
    //   963: aload 6
    //   965: astore_3
    //   966: aload 6
    //   968: astore 4
    //   970: aload 6
    //   972: astore 5
    //   974: aload 6
    //   976: ldc_w 709
    //   979: invokeinterface 700 2 0
    //   984: istore_1
    //   985: aload 6
    //   987: astore_3
    //   988: aload 6
    //   990: astore 4
    //   992: aload 6
    //   994: astore 5
    //   996: aload 6
    //   998: invokeinterface 273 1 0
    //   1003: aload 6
    //   1005: astore_3
    //   1006: aload 6
    //   1008: astore 4
    //   1010: aload 6
    //   1012: astore 5
    //   1014: aload_0
    //   1015: aload_2
    //   1016: ldc_w 488
    //   1019: iconst_4
    //   1020: iconst_1
    //   1021: iconst_0
    //   1022: new 718	com/tencent/mm/plugin/dbbackup/a/a$5
    //   1025: dup
    //   1026: aload_0
    //   1027: iload_1
    //   1028: aload 8
    //   1030: invokespecial 719	com/tencent/mm/plugin/dbbackup/a/a$5:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   1033: invokespecial 670	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$d;)I
    //   1036: pop
    //   1037: aload 6
    //   1039: ifnull +20 -> 1059
    //   1042: aload 6
    //   1044: invokeinterface 270 1 0
    //   1049: ifne +10 -> 1059
    //   1052: aload 6
    //   1054: invokeinterface 273 1 0
    //   1059: aload_0
    //   1060: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1063: invokevirtual 156	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1066: ifeq +10 -> 1076
    //   1069: aload_0
    //   1070: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1073: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1076: aload_2
    //   1077: ifnull +7 -> 1084
    //   1080: aload_2
    //   1081: invokevirtual 451	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1084: sipush 19020
    //   1087: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1090: iconst_0
    //   1091: ireturn
    //   1092: astore 5
    //   1094: aconst_null
    //   1095: astore_2
    //   1096: aconst_null
    //   1097: astore 6
    //   1099: aload 6
    //   1101: astore 4
    //   1103: aload_2
    //   1104: astore_3
    //   1105: ldc 139
    //   1107: ldc_w 721
    //   1110: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1113: aload 6
    //   1115: astore 4
    //   1117: aload_2
    //   1118: astore_3
    //   1119: sipush 19020
    //   1122: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1125: aload 6
    //   1127: astore 4
    //   1129: aload_2
    //   1130: astore_3
    //   1131: aload 5
    //   1133: athrow
    //   1134: astore 5
    //   1136: aload_3
    //   1137: astore_2
    //   1138: aload 5
    //   1140: astore_3
    //   1141: aload_2
    //   1142: ifnull +18 -> 1160
    //   1145: aload_2
    //   1146: invokeinterface 270 1 0
    //   1151: ifne +9 -> 1160
    //   1154: aload_2
    //   1155: invokeinterface 273 1 0
    //   1160: aload_0
    //   1161: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1164: invokevirtual 156	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1167: ifeq +10 -> 1177
    //   1170: aload_0
    //   1171: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1174: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1177: aload 4
    //   1179: ifnull +8 -> 1187
    //   1182: aload 4
    //   1184: invokevirtual 451	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1187: sipush 19020
    //   1190: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1193: aload_3
    //   1194: athrow
    //   1195: astore 5
    //   1197: aconst_null
    //   1198: astore_2
    //   1199: aconst_null
    //   1200: astore 7
    //   1202: aload 7
    //   1204: astore 4
    //   1206: aload_2
    //   1207: astore_3
    //   1208: ldc 139
    //   1210: new 205	java/lang/StringBuilder
    //   1213: dup
    //   1214: ldc_w 723
    //   1217: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1220: aload 5
    //   1222: invokevirtual 475	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1225: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1231: invokestatic 591	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1234: aload 7
    //   1236: astore 4
    //   1238: aload_2
    //   1239: astore_3
    //   1240: iconst_5
    //   1241: new 205	java/lang/StringBuilder
    //   1244: dup
    //   1245: ldc_w 725
    //   1248: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1251: aload_0
    //   1252: getfield 332	com/tencent/mm/plugin/dbbackup/a/a:kUN	Z
    //   1255: invokevirtual 728	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1258: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: aload 5
    //   1263: invokestatic 479	com/tencent/mm/plugin/dbbackup/a/a:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1266: aload_2
    //   1267: ifnull +18 -> 1285
    //   1270: aload_2
    //   1271: invokeinterface 270 1 0
    //   1276: ifne +9 -> 1285
    //   1279: aload_2
    //   1280: invokeinterface 273 1 0
    //   1285: aload_0
    //   1286: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1289: invokevirtual 156	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1292: ifeq +10 -> 1302
    //   1295: aload_0
    //   1296: getfield 151	com/tencent/mm/plugin/dbbackup/a/a:kUB	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1299: invokevirtual 159	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1302: aload 7
    //   1304: ifnull +8 -> 1312
    //   1307: aload 7
    //   1309: invokevirtual 451	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1312: sipush 19020
    //   1315: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1318: iconst_m1
    //   1319: ireturn
    //   1320: astore_3
    //   1321: aconst_null
    //   1322: astore_2
    //   1323: aconst_null
    //   1324: astore 4
    //   1326: goto -185 -> 1141
    //   1329: astore_3
    //   1330: aconst_null
    //   1331: astore 5
    //   1333: aload_2
    //   1334: astore 4
    //   1336: aload 5
    //   1338: astore_2
    //   1339: goto -198 -> 1141
    //   1342: astore 4
    //   1344: aload_3
    //   1345: astore 5
    //   1347: aload 4
    //   1349: astore_3
    //   1350: aload_2
    //   1351: astore 4
    //   1353: aload 5
    //   1355: astore_2
    //   1356: goto -215 -> 1141
    //   1359: astore 5
    //   1361: aconst_null
    //   1362: astore_3
    //   1363: aload_2
    //   1364: astore 7
    //   1366: aload_3
    //   1367: astore_2
    //   1368: goto -166 -> 1202
    //   1371: astore 5
    //   1373: aload_2
    //   1374: astore 7
    //   1376: aload 6
    //   1378: astore_2
    //   1379: goto -177 -> 1202
    //   1382: astore 5
    //   1384: aload_2
    //   1385: astore 7
    //   1387: aload 4
    //   1389: astore_2
    //   1390: goto -188 -> 1202
    //   1393: astore 5
    //   1395: aconst_null
    //   1396: astore_3
    //   1397: aload_2
    //   1398: astore 6
    //   1400: aload_3
    //   1401: astore_2
    //   1402: goto -303 -> 1099
    //   1405: astore 5
    //   1407: aload_2
    //   1408: astore 6
    //   1410: aload 7
    //   1412: astore_2
    //   1413: goto -314 -> 1099
    //   1416: astore 4
    //   1418: aload 5
    //   1420: astore_3
    //   1421: aload 4
    //   1423: astore 5
    //   1425: aload_2
    //   1426: astore 6
    //   1428: aload_3
    //   1429: astore_2
    //   1430: goto -331 -> 1099
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1433	0	this	a
    //   51	977	1	i	int
    //   131	1299	2	localObject1	Object
    //   315	925	3	localObject2	Object
    //   1320	1	3	localObject3	Object
    //   1329	16	3	localObject4	Object
    //   1349	80	3	localObject5	Object
    //   311	1024	4	localObject6	Object
    //   1342	6	4	localObject7	Object
    //   1351	37	4	localObject8	Object
    //   1416	6	4	localOperationCanceledException1	com.tencent.wcdb.support.OperationCanceledException
    //   308	705	5	localObject9	Object
    //   1092	40	5	localOperationCanceledException2	com.tencent.wcdb.support.OperationCanceledException
    //   1134	5	5	localObject10	Object
    //   1195	67	5	localException1	Exception
    //   1331	23	5	localObject11	Object
    //   1359	1	5	localException2	Exception
    //   1371	1	5	localException3	Exception
    //   1382	1	5	localException4	Exception
    //   1393	1	5	localOperationCanceledException3	com.tencent.wcdb.support.OperationCanceledException
    //   1405	14	5	localOperationCanceledException4	com.tencent.wcdb.support.OperationCanceledException
    //   1423	1	5	localObject12	Object
    //   318	1109	6	localObject13	Object
    //   322	1089	7	localObject14	Object
    //   121	908	8	localHashMap	java.util.HashMap
    //   55	746	9	arrayOfLong	long[]
    //   175	459	10	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   39	74	1092	com/tencent/wcdb/support/OperationCanceledException
    //   103	151	1092	com/tencent/wcdb/support/OperationCanceledException
    //   324	334	1134	finally
    //   348	363	1134	finally
    //   377	392	1134	finally
    //   406	418	1134	finally
    //   432	444	1134	finally
    //   458	465	1134	finally
    //   479	504	1134	finally
    //   518	528	1134	finally
    //   542	557	1134	finally
    //   571	586	1134	finally
    //   600	612	1134	finally
    //   626	638	1134	finally
    //   652	659	1134	finally
    //   673	680	1134	finally
    //   694	701	1134	finally
    //   715	731	1134	finally
    //   1105	1113	1134	finally
    //   1119	1125	1134	finally
    //   1131	1134	1134	finally
    //   1208	1234	1134	finally
    //   1240	1266	1134	finally
    //   39	74	1195	java/lang/Exception
    //   103	151	1195	java/lang/Exception
    //   39	74	1320	finally
    //   103	151	1320	finally
    //   151	195	1329	finally
    //   201	230	1329	finally
    //   237	266	1329	finally
    //   273	310	1329	finally
    //   746	757	1342	finally
    //   768	775	1342	finally
    //   786	811	1342	finally
    //   822	835	1342	finally
    //   846	862	1342	finally
    //   873	884	1342	finally
    //   895	902	1342	finally
    //   913	936	1342	finally
    //   947	963	1342	finally
    //   974	985	1342	finally
    //   996	1003	1342	finally
    //   1014	1037	1342	finally
    //   151	195	1359	java/lang/Exception
    //   201	230	1359	java/lang/Exception
    //   237	266	1359	java/lang/Exception
    //   273	310	1359	java/lang/Exception
    //   324	334	1371	java/lang/Exception
    //   348	363	1371	java/lang/Exception
    //   377	392	1371	java/lang/Exception
    //   406	418	1371	java/lang/Exception
    //   432	444	1371	java/lang/Exception
    //   458	465	1371	java/lang/Exception
    //   479	504	1371	java/lang/Exception
    //   518	528	1371	java/lang/Exception
    //   542	557	1371	java/lang/Exception
    //   571	586	1371	java/lang/Exception
    //   600	612	1371	java/lang/Exception
    //   626	638	1371	java/lang/Exception
    //   652	659	1371	java/lang/Exception
    //   673	680	1371	java/lang/Exception
    //   694	701	1371	java/lang/Exception
    //   715	731	1371	java/lang/Exception
    //   746	757	1382	java/lang/Exception
    //   768	775	1382	java/lang/Exception
    //   786	811	1382	java/lang/Exception
    //   822	835	1382	java/lang/Exception
    //   846	862	1382	java/lang/Exception
    //   873	884	1382	java/lang/Exception
    //   895	902	1382	java/lang/Exception
    //   913	936	1382	java/lang/Exception
    //   947	963	1382	java/lang/Exception
    //   974	985	1382	java/lang/Exception
    //   996	1003	1382	java/lang/Exception
    //   1014	1037	1382	java/lang/Exception
    //   151	195	1393	com/tencent/wcdb/support/OperationCanceledException
    //   201	230	1393	com/tencent/wcdb/support/OperationCanceledException
    //   237	266	1393	com/tencent/wcdb/support/OperationCanceledException
    //   273	310	1393	com/tencent/wcdb/support/OperationCanceledException
    //   324	334	1405	com/tencent/wcdb/support/OperationCanceledException
    //   348	363	1405	com/tencent/wcdb/support/OperationCanceledException
    //   377	392	1405	com/tencent/wcdb/support/OperationCanceledException
    //   406	418	1405	com/tencent/wcdb/support/OperationCanceledException
    //   432	444	1405	com/tencent/wcdb/support/OperationCanceledException
    //   458	465	1405	com/tencent/wcdb/support/OperationCanceledException
    //   479	504	1405	com/tencent/wcdb/support/OperationCanceledException
    //   518	528	1405	com/tencent/wcdb/support/OperationCanceledException
    //   542	557	1405	com/tencent/wcdb/support/OperationCanceledException
    //   571	586	1405	com/tencent/wcdb/support/OperationCanceledException
    //   600	612	1405	com/tencent/wcdb/support/OperationCanceledException
    //   626	638	1405	com/tencent/wcdb/support/OperationCanceledException
    //   652	659	1405	com/tencent/wcdb/support/OperationCanceledException
    //   673	680	1405	com/tencent/wcdb/support/OperationCanceledException
    //   694	701	1405	com/tencent/wcdb/support/OperationCanceledException
    //   715	731	1405	com/tencent/wcdb/support/OperationCanceledException
    //   746	757	1416	com/tencent/wcdb/support/OperationCanceledException
    //   768	775	1416	com/tencent/wcdb/support/OperationCanceledException
    //   786	811	1416	com/tencent/wcdb/support/OperationCanceledException
    //   822	835	1416	com/tencent/wcdb/support/OperationCanceledException
    //   846	862	1416	com/tencent/wcdb/support/OperationCanceledException
    //   873	884	1416	com/tencent/wcdb/support/OperationCanceledException
    //   895	902	1416	com/tencent/wcdb/support/OperationCanceledException
    //   913	936	1416	com/tencent/wcdb/support/OperationCanceledException
    //   947	963	1416	com/tencent/wcdb/support/OperationCanceledException
    //   974	985	1416	com/tencent/wcdb/support/OperationCanceledException
    //   996	1003	1416	com/tencent/wcdb/support/OperationCanceledException
    //   1014	1037	1416	com/tencent/wcdb/support/OperationCanceledException
  }
  
  private int gp(boolean paramBoolean)
  {
    AppMethodBeat.i(19017);
    ab.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.kUC);
    if (this.kUB == null)
    {
      AppMethodBeat.o(19017);
      return -1;
    }
    b localb = new b(this.kUB.getPath());
    if (this.kUB.isOpen()) {
      this.kUB.close();
    }
    if (paramBoolean)
    {
      if (!localb.p(new b(this.kUC)))
      {
        ab.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", new Object[] { localb, this.kUC });
        AppMethodBeat.o(19017);
        return -1;
      }
    }
    else
    {
      ab.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", new Object[] { localb });
      localb.delete();
    }
    AppMethodBeat.o(19017);
    return 0;
  }
  
  /* Error */
  private Integer ln()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: sipush 19013
    //   9: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: bipush 54
    //   14: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   17: iconst_m1
    //   18: istore 4
    //   20: invokestatic 759	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   23: ldc_w 761
    //   26: invokevirtual 767	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 769	android/os/PowerManager
    //   32: iconst_1
    //   33: ldc_w 771
    //   36: invokevirtual 775	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   39: astore 12
    //   41: invokestatic 780	android/os/SystemClock:uptimeMillis	()J
    //   44: lstore 7
    //   46: aload 12
    //   48: ldc2_w 781
    //   51: invokevirtual 788	android/os/PowerManager$WakeLock:acquire	(J)V
    //   54: iload 4
    //   56: istore_1
    //   57: iload 4
    //   59: istore_2
    //   60: iload 4
    //   62: istore_3
    //   63: aload_0
    //   64: iconst_1
    //   65: anewarray 248	java/lang/Integer
    //   68: dup
    //   69: iconst_0
    //   70: iconst_1
    //   71: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokevirtual 255	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   78: iload 4
    //   80: istore_1
    //   81: iload 4
    //   83: istore_2
    //   84: iload 4
    //   86: istore_3
    //   87: aload_0
    //   88: invokespecial 790	com/tencent/mm/plugin/dbbackup/a/a:biV	()I
    //   91: istore 4
    //   93: iload 4
    //   95: ifeq +112 -> 207
    //   98: iload 4
    //   100: tableswitch	default:+32 -> 132, -2:+99->199, -1:+32->132, 0:+54->154, 1:+91->191
    //   133: dstore 184
    //   135: iconst_m1
    //   136: <illegal opcode>
    //   137: aload 12
    //   139: invokevirtual 791	android/os/PowerManager$WakeLock:release	()V
    //   142: sipush 19013
    //   145: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iload 4
    //   150: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: areturn
    //   154: invokestatic 780	android/os/SystemClock:uptimeMillis	()J
    //   157: lstore 9
    //   159: bipush 55
    //   161: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   164: getstatic 349	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   167: ldc2_w 792
    //   170: ldc2_w 794
    //   173: lload 9
    //   175: lload 7
    //   177: lsub
    //   178: ldc2_w 796
    //   181: ldiv
    //   182: lconst_1
    //   183: ladd
    //   184: iconst_1
    //   185: invokevirtual 801	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   188: goto -51 -> 137
    //   191: bipush 56
    //   193: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   196: goto -59 -> 137
    //   199: bipush 58
    //   201: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   204: goto -67 -> 137
    //   207: iload 4
    //   209: istore_1
    //   210: iload 4
    //   212: istore_2
    //   213: iload 4
    //   215: istore_3
    //   216: aload_0
    //   217: getfield 322	com/tencent/mm/plugin/dbbackup/a/a:kUM	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   220: ifnull +102 -> 322
    //   223: iload 4
    //   225: istore_1
    //   226: iload 4
    //   228: istore_2
    //   229: iload 4
    //   231: istore_3
    //   232: ldc 139
    //   234: ldc_w 803
    //   237: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: iload 4
    //   242: istore_1
    //   243: iload 4
    //   245: istore_2
    //   246: iload 4
    //   248: istore_3
    //   249: aload_0
    //   250: getfield 322	com/tencent/mm/plugin/dbbackup/a/a:kUM	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   253: invokeinterface 807 1 0
    //   258: astore 11
    //   260: iload 4
    //   262: istore_1
    //   263: iload 4
    //   265: istore_2
    //   266: iload 4
    //   268: istore_3
    //   269: aload_0
    //   270: getfield 515	com/tencent/mm/plugin/dbbackup/a/a:kUK	Ljava/util/List;
    //   273: aload 11
    //   275: invokeinterface 811 2 0
    //   280: pop
    //   281: iload 4
    //   283: istore_1
    //   284: iload 4
    //   286: istore_2
    //   287: iload 4
    //   289: istore_3
    //   290: aload_0
    //   291: getfield 322	com/tencent/mm/plugin/dbbackup/a/a:kUM	Lcom/tencent/mm/plugin/dbbackup/a/a$c;
    //   294: invokeinterface 814 1 0
    //   299: astore 11
    //   301: iload 4
    //   303: istore_1
    //   304: iload 4
    //   306: istore_2
    //   307: iload 4
    //   309: istore_3
    //   310: aload_0
    //   311: getfield 549	com/tencent/mm/plugin/dbbackup/a/a:kUL	Ljava/util/List;
    //   314: aload 11
    //   316: invokeinterface 811 2 0
    //   321: pop
    //   322: iload 4
    //   324: istore_1
    //   325: iload 4
    //   327: istore_2
    //   328: iload 4
    //   330: istore_3
    //   331: aload_0
    //   332: getfield 515	com/tencent/mm/plugin/dbbackup/a/a:kUK	Ljava/util/List;
    //   335: invokeinterface 815 1 0
    //   340: ifeq +23 -> 363
    //   343: iload 4
    //   345: istore_1
    //   346: iload 4
    //   348: istore_2
    //   349: iload 4
    //   351: istore_3
    //   352: aload_0
    //   353: getfield 515	com/tencent/mm/plugin/dbbackup/a/a:kUK	Ljava/util/List;
    //   356: aconst_null
    //   357: invokeinterface 819 2 0
    //   362: pop
    //   363: iload 4
    //   365: istore_1
    //   366: iload 4
    //   368: istore_2
    //   369: iload 4
    //   371: istore_3
    //   372: aload_0
    //   373: getfield 549	com/tencent/mm/plugin/dbbackup/a/a:kUL	Ljava/util/List;
    //   376: invokeinterface 815 1 0
    //   381: ifeq +23 -> 404
    //   384: iload 4
    //   386: istore_1
    //   387: iload 4
    //   389: istore_2
    //   390: iload 4
    //   392: istore_3
    //   393: aload_0
    //   394: getfield 549	com/tencent/mm/plugin/dbbackup/a/a:kUL	Ljava/util/List;
    //   397: aconst_null
    //   398: invokeinterface 819 2 0
    //   403: pop
    //   404: iload 6
    //   406: istore_2
    //   407: aload_0
    //   408: invokespecial 821	com/tencent/mm/plugin/dbbackup/a/a:biW	()I
    //   411: istore_1
    //   412: iload_1
    //   413: istore_2
    //   414: iload_2
    //   415: istore_1
    //   416: iload_2
    //   417: istore_3
    //   418: iload_2
    //   419: istore 4
    //   421: aload_0
    //   422: iconst_1
    //   423: anewarray 248	java/lang/Integer
    //   426: dup
    //   427: iconst_0
    //   428: iconst_2
    //   429: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   432: aastore
    //   433: invokevirtual 255	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   436: iload_2
    //   437: istore_1
    //   438: iload_2
    //   439: istore_3
    //   440: iload_2
    //   441: istore 4
    //   443: aload_0
    //   444: invokespecial 823	com/tencent/mm/plugin/dbbackup/a/a:biX	()I
    //   447: istore_2
    //   448: iload_2
    //   449: istore 4
    //   451: iload 4
    //   453: iconst_1
    //   454: if_icmpne +109 -> 563
    //   457: iload 4
    //   459: tableswitch	default:+29 -> 488, -2:+96->555, -1:+29->488, 0:+51->510, 1:+88->547
    //   489: dstore 184
    //   491: iconst_m1
    //   492: <illegal opcode>
    //   493: aload 12
    //   495: invokevirtual 791	android/os/PowerManager$WakeLock:release	()V
    //   498: sipush 19013
    //   501: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: iload 4
    //   506: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: areturn
    //   510: invokestatic 780	android/os/SystemClock:uptimeMillis	()J
    //   513: lstore 9
    //   515: bipush 55
    //   517: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   520: getstatic 349	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   523: ldc2_w 792
    //   526: ldc2_w 794
    //   529: lload 9
    //   531: lload 7
    //   533: lsub
    //   534: ldc2_w 796
    //   537: ldiv
    //   538: lconst_1
    //   539: ladd
    //   540: iconst_1
    //   541: invokevirtual 801	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   544: goto -51 -> 493
    //   547: bipush 56
    //   549: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   552: goto -59 -> 493
    //   555: bipush 58
    //   557: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   560: goto -67 -> 493
    //   563: iload 4
    //   565: istore 5
    //   567: iload 4
    //   569: iconst_m1
    //   570: if_icmpne +42 -> 612
    //   573: iload 4
    //   575: istore_1
    //   576: iload 4
    //   578: istore_2
    //   579: iload 4
    //   581: istore_3
    //   582: aload_0
    //   583: iconst_1
    //   584: anewarray 248	java/lang/Integer
    //   587: dup
    //   588: iconst_0
    //   589: iconst_4
    //   590: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   593: aastore
    //   594: invokevirtual 255	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   597: iload 4
    //   599: istore_1
    //   600: iload 4
    //   602: istore_2
    //   603: iload 4
    //   605: istore_3
    //   606: aload_0
    //   607: invokespecial 825	com/tencent/mm/plugin/dbbackup/a/a:biY	()I
    //   610: istore 5
    //   612: iload 5
    //   614: ifeq +109 -> 723
    //   617: iload 5
    //   619: tableswitch	default:+29 -> 648, -2:+96->715, -1:+29->648, 0:+51->670, 1:+88->707
    //   649: dstore 184
    //   651: iconst_m1
    //   652: <illegal opcode>
    //   653: aload 12
    //   655: invokevirtual 791	android/os/PowerManager$WakeLock:release	()V
    //   658: sipush 19013
    //   661: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   664: iload 5
    //   666: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   669: areturn
    //   670: invokestatic 780	android/os/SystemClock:uptimeMillis	()J
    //   673: lstore 9
    //   675: bipush 55
    //   677: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   680: getstatic 349	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   683: ldc2_w 792
    //   686: ldc2_w 794
    //   689: lload 9
    //   691: lload 7
    //   693: lsub
    //   694: ldc2_w 796
    //   697: ldiv
    //   698: lconst_1
    //   699: ladd
    //   700: iconst_1
    //   701: invokevirtual 801	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   704: goto -51 -> 653
    //   707: bipush 56
    //   709: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   712: goto -59 -> 653
    //   715: bipush 58
    //   717: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   720: goto -67 -> 653
    //   723: iload 5
    //   725: istore_1
    //   726: iload 5
    //   728: istore_2
    //   729: iload 5
    //   731: istore_3
    //   732: aload_0
    //   733: iconst_1
    //   734: anewarray 248	java/lang/Integer
    //   737: dup
    //   738: iconst_0
    //   739: iconst_5
    //   740: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   743: aastore
    //   744: invokevirtual 255	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   747: iload 5
    //   749: istore_1
    //   750: iload 5
    //   752: istore_2
    //   753: iload 5
    //   755: istore_3
    //   756: aload_0
    //   757: invokespecial 827	com/tencent/mm/plugin/dbbackup/a/a:biZ	()I
    //   760: istore 4
    //   762: iload 4
    //   764: istore_2
    //   765: iload_2
    //   766: istore_1
    //   767: iload_2
    //   768: istore_3
    //   769: iload_2
    //   770: istore 4
    //   772: aload_0
    //   773: iconst_1
    //   774: anewarray 248	java/lang/Integer
    //   777: dup
    //   778: iconst_0
    //   779: bipush 6
    //   781: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   784: aastore
    //   785: invokevirtual 255	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   788: iload_2
    //   789: istore_1
    //   790: iload_2
    //   791: istore_3
    //   792: iload_2
    //   793: istore 4
    //   795: aload_0
    //   796: iconst_1
    //   797: invokespecial 829	com/tencent/mm/plugin/dbbackup/a/a:gp	(Z)I
    //   800: istore_2
    //   801: iload_2
    //   802: tableswitch	default:+30 -> 832, -2:+96->898, -1:+30->832, 0:+51->853, 1:+88->890
    //   833: dstore 184
    //   835: iconst_m1
    //   836: <illegal opcode>
    //   837: aload 12
    //   839: invokevirtual 791	android/os/PowerManager$WakeLock:release	()V
    //   842: sipush 19013
    //   845: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   848: iload_2
    //   849: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   852: areturn
    //   853: invokestatic 780	android/os/SystemClock:uptimeMillis	()J
    //   856: lstore 9
    //   858: bipush 55
    //   860: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   863: getstatic 349	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   866: ldc2_w 792
    //   869: ldc2_w 794
    //   872: lload 9
    //   874: lload 7
    //   876: lsub
    //   877: ldc2_w 796
    //   880: ldiv
    //   881: lconst_1
    //   882: ladd
    //   883: iconst_1
    //   884: invokevirtual 801	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   887: goto -50 -> 837
    //   890: bipush 56
    //   892: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   895: goto -58 -> 837
    //   898: bipush 58
    //   900: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   903: goto -66 -> 837
    //   906: astore 11
    //   908: iload_1
    //   909: istore_2
    //   910: iload_2
    //   911: istore_1
    //   912: ldc 139
    //   914: ldc_w 831
    //   917: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   920: iload_2
    //   921: istore_1
    //   922: aload_0
    //   923: iconst_0
    //   924: invokespecial 829	com/tencent/mm/plugin/dbbackup/a/a:gp	(Z)I
    //   927: pop
    //   928: bipush 56
    //   930: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   933: aload 12
    //   935: invokevirtual 791	android/os/PowerManager$WakeLock:release	()V
    //   938: sipush 19013
    //   941: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   944: iconst_1
    //   945: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   948: areturn
    //   949: astore 11
    //   951: iload_2
    //   952: istore_1
    //   953: iload_1
    //   954: istore_2
    //   955: ldc 139
    //   957: aload 11
    //   959: ldc_w 833
    //   962: iconst_0
    //   963: anewarray 143	java/lang/Object
    //   966: invokestatic 442	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   969: iload_1
    //   970: istore_2
    //   971: aload_0
    //   972: iconst_0
    //   973: invokespecial 829	com/tencent/mm/plugin/dbbackup/a/a:gp	(Z)I
    //   976: pop
    //   977: iconst_m1
    //   978: istore_1
    //   979: bipush 57
    //   981: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   984: aload 12
    //   986: invokevirtual 791	android/os/PowerManager$WakeLock:release	()V
    //   989: sipush 19013
    //   992: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   995: iconst_m1
    //   996: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   999: areturn
    //   1000: astore 11
    //   1002: iload_3
    //   1003: istore_2
    //   1004: iload_2
    //   1005: tableswitch	default:+31 -> 1036, -2:+95->1100, -1:+31->1036, 0:+50->1055, 1:+87->1092
    //   1037: dstore 184
    //   1039: iconst_m1
    //   1040: <illegal opcode>
    //   1041: aload 12
    //   1043: invokevirtual 791	android/os/PowerManager$WakeLock:release	()V
    //   1046: sipush 19013
    //   1049: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1052: aload 11
    //   1054: athrow
    //   1055: invokestatic 780	android/os/SystemClock:uptimeMillis	()J
    //   1058: lstore 9
    //   1060: bipush 55
    //   1062: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   1065: getstatic 349	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   1068: ldc2_w 792
    //   1071: ldc2_w 794
    //   1074: lload 9
    //   1076: lload 7
    //   1078: lsub
    //   1079: ldc2_w 796
    //   1082: ldiv
    //   1083: lconst_1
    //   1084: ladd
    //   1085: iconst_1
    //   1086: invokevirtual 801	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   1089: goto -48 -> 1041
    //   1092: bipush 56
    //   1094: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   1097: goto -56 -> 1041
    //   1100: bipush 58
    //   1102: invokestatic 753	com/tencent/mm/plugin/dbbackup/a/a:tU	(I)V
    //   1105: goto -64 -> 1041
    //   1108: astore 11
    //   1110: goto -106 -> 1004
    //   1113: astore 11
    //   1115: iload_1
    //   1116: istore_2
    //   1117: goto -113 -> 1004
    //   1120: astore 11
    //   1122: iconst_1
    //   1123: istore_1
    //   1124: goto -120 -> 1004
    //   1127: astore 11
    //   1129: iload 5
    //   1131: istore_1
    //   1132: goto -179 -> 953
    //   1135: astore 11
    //   1137: iload_3
    //   1138: istore_1
    //   1139: goto -186 -> 953
    //   1142: astore 11
    //   1144: iconst_0
    //   1145: istore_2
    //   1146: goto -236 -> 910
    //   1149: astore 11
    //   1151: iload 4
    //   1153: istore_2
    //   1154: goto -244 -> 910
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1157	0	this	a
    //   56	1060	1	i	int
    //   59	1058	2	j	int
    //   62	941	3	k	int
    //   18	776	4	m	int
    //   4	750	5	n	int
    //   1	404	6	i1	int
    //   44	1033	7	l1	long
    //   157	918	9	l2	long
    //   258	57	11	localCollection	java.util.Collection
    //   906	1	11	localOperationCanceledException	com.tencent.wcdb.support.OperationCanceledException
    //   949	9	11	localException	Exception
    //   1000	53	11	localObject1	Object
    //   1108	1	11	localObject2	Object
    //   1113	1	11	localObject3	Object
    //   39	1003	12	localWakeLock	android.os.PowerManager.WakeLock
    // Exception table:
    //   from	to	target	type
    //   63	78	906	com/tencent/wcdb/support/OperationCanceledException
    //   87	93	906	com/tencent/wcdb/support/OperationCanceledException
    //   216	223	906	com/tencent/wcdb/support/OperationCanceledException
    //   232	240	906	com/tencent/wcdb/support/OperationCanceledException
    //   249	260	906	com/tencent/wcdb/support/OperationCanceledException
    //   269	281	906	com/tencent/wcdb/support/OperationCanceledException
    //   290	301	906	com/tencent/wcdb/support/OperationCanceledException
    //   310	322	906	com/tencent/wcdb/support/OperationCanceledException
    //   331	343	906	com/tencent/wcdb/support/OperationCanceledException
    //   352	363	906	com/tencent/wcdb/support/OperationCanceledException
    //   372	384	906	com/tencent/wcdb/support/OperationCanceledException
    //   393	404	906	com/tencent/wcdb/support/OperationCanceledException
    //   582	597	906	com/tencent/wcdb/support/OperationCanceledException
    //   606	612	906	com/tencent/wcdb/support/OperationCanceledException
    //   732	747	906	com/tencent/wcdb/support/OperationCanceledException
    //   756	762	906	com/tencent/wcdb/support/OperationCanceledException
    //   63	78	949	java/lang/Exception
    //   87	93	949	java/lang/Exception
    //   216	223	949	java/lang/Exception
    //   232	240	949	java/lang/Exception
    //   249	260	949	java/lang/Exception
    //   269	281	949	java/lang/Exception
    //   290	301	949	java/lang/Exception
    //   310	322	949	java/lang/Exception
    //   331	343	949	java/lang/Exception
    //   352	363	949	java/lang/Exception
    //   372	384	949	java/lang/Exception
    //   393	404	949	java/lang/Exception
    //   582	597	949	java/lang/Exception
    //   606	612	949	java/lang/Exception
    //   732	747	949	java/lang/Exception
    //   756	762	949	java/lang/Exception
    //   63	78	1000	finally
    //   87	93	1000	finally
    //   216	223	1000	finally
    //   232	240	1000	finally
    //   249	260	1000	finally
    //   269	281	1000	finally
    //   290	301	1000	finally
    //   310	322	1000	finally
    //   331	343	1000	finally
    //   352	363	1000	finally
    //   372	384	1000	finally
    //   393	404	1000	finally
    //   582	597	1000	finally
    //   606	612	1000	finally
    //   732	747	1000	finally
    //   756	762	1000	finally
    //   407	412	1108	finally
    //   955	969	1108	finally
    //   971	977	1108	finally
    //   421	436	1113	finally
    //   443	448	1113	finally
    //   772	788	1113	finally
    //   795	801	1113	finally
    //   912	920	1113	finally
    //   922	928	1113	finally
    //   407	412	1127	java/lang/Exception
    //   421	436	1135	java/lang/Exception
    //   443	448	1135	java/lang/Exception
    //   772	788	1135	java/lang/Exception
    //   795	801	1135	java/lang/Exception
    //   407	412	1142	com/tencent/wcdb/support/OperationCanceledException
    //   421	436	1149	com/tencent/wcdb/support/OperationCanceledException
    //   443	448	1149	com/tencent/wcdb/support/OperationCanceledException
    //   772	788	1149	com/tencent/wcdb/support/OperationCanceledException
    //   795	801	1149	com/tencent/wcdb/support/OperationCanceledException
  }
  
  private static void tU(int paramInt)
  {
    AppMethodBeat.i(19023);
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, paramInt, 1L, true);
    AppMethodBeat.o(19023);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(19014);
    this.mCancellationSignal.cancel();
    ab.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
    AppMethodBeat.o(19014);
  }
  
  public static final class a
  {
    public String kUC;
    public String kUD;
    public String kUE;
    public String kUF;
    private List<String> kUG;
    private List<String> kUH;
    private byte[] kUI;
    private byte[] kUJ;
    public a.c kUM;
    public boolean kUN;
    public a.b kUO;
    private LinkedHashSet<byte[]> kVc;
    private LinkedHashSet<byte[]> kVd;
    
    public a()
    {
      AppMethodBeat.i(19006);
      this.kUG = new ArrayList();
      this.kUH = new ArrayList();
      this.kVc = new LinkedHashSet();
      this.kVd = new LinkedHashSet();
      AppMethodBeat.o(19006);
    }
    
    public final a Jw(String paramString)
    {
      AppMethodBeat.i(19008);
      this.kUG.add(paramString);
      AppMethodBeat.o(19008);
      return this;
    }
    
    public final a Jx(String paramString)
    {
      AppMethodBeat.i(19009);
      this.kUH.add(paramString);
      AppMethodBeat.o(19009);
      return this;
    }
    
    public final a aD(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(19010);
      this.kUI = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(19010);
      return this;
    }
    
    public final a aE(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(19011);
      this.kUJ = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(19011);
      return this;
    }
    
    public final a bja()
    {
      AppMethodBeat.i(19007);
      a locala = new a((byte)0);
      a.a(locala, this.kUC);
      a.b(locala, this.kUD);
      a.c(locala, this.kUE);
      a.d(locala, this.kUF);
      a.a(locala, new ArrayList(this.kUG));
      a.b(locala, new ArrayList(this.kUH));
      a.a(locala, this.kUI);
      a.b(locala, this.kUJ);
      a.a(locala, this.kUM);
      a.c(locala, new ArrayList(this.kVc));
      a.d(locala, new ArrayList(this.kVd));
      a.a(locala, this.kUN);
      a.a(locala, this.kUO);
      AppMethodBeat.o(19007);
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void H(long paramLong1, long paramLong2);
    
    public abstract void Q(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onCanceled();
    
    public abstract void onFailure();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a
 * JD-Core Version:    0.7.0.1
 */