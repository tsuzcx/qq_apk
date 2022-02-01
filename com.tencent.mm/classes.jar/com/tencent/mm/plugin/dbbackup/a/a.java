package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
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
  private static final SQLiteCipherSpec xjt;
  private final CancellationSignal mCancellationSignal;
  private List<String> xjA;
  private byte[] xjB;
  private byte[] xjC;
  private List<byte[]> xjD;
  private List<byte[]> xjE;
  private d xjF;
  private boolean xjG;
  private b xjH;
  private boolean xjI;
  private int xjJ;
  private long xjK;
  private long xjL;
  private SQLiteDatabase xju;
  private String xjv;
  private String xjw;
  private String xjx;
  private String xjy;
  private List<String> xjz;
  
  static
  {
    AppMethodBeat.i(23138);
    xjt = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
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
      if (this.xju.inTransaction()) {
        this.xju.endTransaction();
      }
      AppMethodBeat.o(23129);
      return -1;
      localObject = ((String)localObject).replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS ");
      this.xju.execSQL((String)localObject, null, this.mCancellationSignal);
      if (!paramBoolean)
      {
        if (this.xju.inTransaction()) {
          this.xju.endTransaction();
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
          paramString = this.xju.compileStatement(localStringBuilder.toString());
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
          this.xju.beginTransaction();
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
        if (this.xju.inTransaction()) {
          this.xju.endTransaction();
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
      this.xju.setTransactionSuccessful();
      if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
        ((Cursor)localObject).close();
      }
      if (this.xju.inTransaction()) {
        this.xju.endTransaction();
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
  
  private static List<c> a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    AppMethodBeat.i(264939);
    paramSQLiteDatabase = paramSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "PRAGMA table_info(" + paramString + ");", null, null);
    try
    {
      boolean bool1 = paramSQLiteDatabase.moveToFirst();
      if (!bool1)
      {
        if (paramSQLiteDatabase != null) {
          paramSQLiteDatabase.close();
        }
        AppMethodBeat.o(264939);
        return null;
      }
      paramString = new ArrayList();
      String str1 = paramSQLiteDatabase.getString(1);
      String str2 = paramSQLiteDatabase.getString(2);
      label106:
      String str3;
      if (paramSQLiteDatabase.getInt(3) != 0)
      {
        bool1 = true;
        str3 = paramSQLiteDatabase.getString(4);
        if (paramSQLiteDatabase.getInt(5) == 0) {
          break label181;
        }
      }
      label181:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramString.add(new c(str1, str2, bool1, str3, bool2));
        bool1 = paramSQLiteDatabase.moveToNext();
        if (bool1) {
          break;
        }
        if (paramSQLiteDatabase != null) {
          paramSQLiteDatabase.close();
        }
        AppMethodBeat.o(264939);
        return paramString;
        bool1 = false;
        break label106;
      }
      try
      {
        paramSQLiteDatabase.close();
        AppMethodBeat.o(264939);
        throw paramString;
      }
      finally
      {
        paramString.addSuppressed(paramSQLiteDatabase);
      }
    }
    finally
    {
      if (paramSQLiteDatabase == null) {}
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    AppMethodBeat.i(264932);
    Object localObject1 = SQLiteDirectCursor.FACTORY;
    Object localObject3 = Integer.toString(paramInt);
    CancellationSignal localCancellationSignal = this.mCancellationSignal;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQueryWithFactory((SQLiteDatabase.CursorFactory)localObject1, "SELECT id,type,value FROM userinfo WHERE id=?", new String[] { localObject3 }, "userinfo", localCancellationSignal);
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramInt = paramSQLiteDatabase.getInt(0);
        int i = paramSQLiteDatabase.getInt(1);
        localObject1 = paramSQLiteDatabase.getString(2);
        localObject3 = this.xju;
        localCancellationSignal = this.mCancellationSignal;
        ((SQLiteDatabase)localObject3).execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject1 }, localCancellationSignal);
      }
      if (paramSQLiteDatabase != null)
      {
        paramSQLiteDatabase.close();
        AppMethodBeat.o(264932);
        return;
      }
    }
    finally
    {
      if (paramSQLiteDatabase != null) {}
      try
      {
        paramSQLiteDatabase.close();
        AppMethodBeat.o(264932);
        throw localObject2;
      }
      finally
      {
        localObject2.addSuppressed(paramSQLiteDatabase);
      }
      AppMethodBeat.o(264932);
    }
  }
  
  private static long amB(String paramString)
  {
    AppMethodBeat.i(23130);
    u localu = new u(paramString);
    paramString = localu;
    if (!localu.isDirectory()) {
      paramString = localu.jKP();
    }
    do
    {
      long l = paramString.jLa();
      if (l > 0L)
      {
        AppMethodBeat.o(23130);
        return l;
      }
      localu = paramString.jKP();
      paramString = localu;
    } while (localu != null);
    AppMethodBeat.o(23130);
    return 0L;
  }
  
  private int b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(264943);
    paramSQLiteDatabase = a(paramSQLiteDatabase, paramString);
    Object localObject = a(this.xju, paramString);
    if (paramSQLiteDatabase == null)
    {
      Log.e("MicroMsg.DBRecoveryTask", "ALTER TABLE detection for '%s' failed because no such table in source DB.");
      AppMethodBeat.o(264943);
      return -1;
    }
    if (localObject == null)
    {
      Log.e("MicroMsg.DBRecoveryTask", "ALTER TABLE detection for '%s' failed because no such table in target DB.");
      AppMethodBeat.o(264943);
      return -1;
    }
    if (((List)localObject).size() < paramSQLiteDatabase.size()) {
      try
      {
        this.xju.beginTransaction();
        StringBuilder localStringBuilder = new StringBuilder();
        int i = ((List)localObject).size();
        while (i < paramSQLiteDatabase.size())
        {
          localObject = (c)paramSQLiteDatabase.get(i);
          localStringBuilder.setLength(0);
          localStringBuilder.append("ALTER TABLE ").append(paramString).append(" ADD COLUMN ").append(((c)localObject).name).append(' ').append(((c)localObject).type);
          if (((c)localObject).xkb) {
            localStringBuilder.append(" NOT NULL");
          }
          if ((((c)localObject).defaultValue != null) && (!((c)localObject).defaultValue.isEmpty())) {
            localStringBuilder.append(" DEFAULT (").append(((c)localObject).defaultValue).append(')');
          }
          localStringBuilder.append(';');
          localObject = localStringBuilder.toString();
          this.xju.execSQL((String)localObject, null, this.mCancellationSignal);
          Log.i("MicroMsg.DBRecoveryTask", ">>> ".concat(String.valueOf(localObject)));
          j += 1;
          i += 1;
        }
        this.xju.setTransactionSuccessful();
        return j;
      }
      finally
      {
        if (this.xju.inTransaction()) {
          this.xju.endTransaction();
        }
        AppMethodBeat.o(264943);
      }
    }
    AppMethodBeat.o(264943);
    return 0;
  }
  
  /* Error */
  private Integer duc()
  {
    // Byte code:
    //   0: sipush 23121
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: bipush 54
    //   8: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   11: iconst_m1
    //   12: istore_2
    //   13: invokestatic 479	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   16: ldc_w 481
    //   19: invokevirtual 487	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 489	android/os/PowerManager
    //   25: iconst_1
    //   26: ldc_w 491
    //   29: invokevirtual 495	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   32: astore 11
    //   34: invokestatic 500	android/os/SystemClock:uptimeMillis	()J
    //   37: lstore 6
    //   39: ldc2_w 501
    //   42: new 504	com/tencent/mm/hellhoundlib/b/a
    //   45: dup
    //   46: invokespecial 505	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   49: invokestatic 510	com/tencent/mm/hellhoundlib/b/c:a	(JLcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   52: astore 10
    //   54: aload 11
    //   56: aload 10
    //   58: invokevirtual 514	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   61: ldc_w 516
    //   64: ldc_w 518
    //   67: ldc_w 520
    //   70: ldc_w 522
    //   73: ldc_w 524
    //   76: ldc_w 526
    //   79: invokestatic 531	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload 10
    //   84: invokestatic 534	com/tencent/mm/hellhoundlib/b/c:a	(Lcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   87: iconst_0
    //   88: invokevirtual 537	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   91: checkcast 539	java/lang/Long
    //   94: invokevirtual 542	java/lang/Long:longValue	()J
    //   97: lstore 8
    //   99: invokestatic 546	com/tencent/mm/hellhoundlib/b/c:aYk	()Lcom/tencent/mm/hellhoundlib/b/a;
    //   102: pop
    //   103: aload 11
    //   105: lload 8
    //   107: invokevirtual 550	android/os/PowerManager$WakeLock:acquire	(J)V
    //   110: aload 11
    //   112: ldc_w 516
    //   115: ldc_w 518
    //   118: ldc_w 520
    //   121: ldc_w 522
    //   124: ldc_w 524
    //   127: ldc_w 526
    //   130: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    //   153: invokespecial 556	com/tencent/mm/plugin/dbbackup/a/a:dud	()I
    //   156: istore 4
    //   158: iload 4
    //   160: ifeq +165 -> 325
    //   163: iload 4
    //   165: tableswitch	default:+31 -> 196, -2:+152->317, -1:+31->196, 0:+107->272, 1:+144->309
    //   197: dstore 184
    //   199: aconst_null
    //   200: <illegal opcode>
    //   201: aload 11
    //   203: invokevirtual 559	android/os/PowerManager$WakeLock:isHeld	()Z
    //   206: ifeq +54 -> 260
    //   209: aload 11
    //   211: ldc_w 516
    //   214: ldc_w 518
    //   217: ldc_w 520
    //   220: ldc_w 522
    //   223: ldc_w 561
    //   226: ldc_w 562
    //   229: invokestatic 564	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 11
    //   234: invokevirtual 566	android/os/PowerManager$WakeLock:release	()V
    //   237: aload 11
    //   239: ldc_w 516
    //   242: ldc_w 518
    //   245: ldc_w 520
    //   248: ldc_w 522
    //   251: ldc_w 561
    //   254: ldc_w 562
    //   257: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   260: sipush 23121
    //   263: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: iload 4
    //   268: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: areturn
    //   272: invokestatic 500	android/os/SystemClock:uptimeMillis	()J
    //   275: lstore 8
    //   277: bipush 55
    //   279: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   282: getstatic 572	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   285: ldc2_w 573
    //   288: ldc2_w 575
    //   291: lload 8
    //   293: lload 6
    //   295: lsub
    //   296: ldc2_w 577
    //   299: ldiv
    //   300: lconst_1
    //   301: ladd
    //   302: iconst_1
    //   303: invokevirtual 582	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   306: goto -105 -> 201
    //   309: bipush 56
    //   311: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   314: goto -113 -> 201
    //   317: bipush 58
    //   319: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   322: goto -121 -> 201
    //   325: iload 4
    //   327: istore_1
    //   328: iload 4
    //   330: istore_2
    //   331: iload 4
    //   333: istore_3
    //   334: aload_0
    //   335: getfield 327	com/tencent/mm/plugin/dbbackup/a/a:xjF	Lcom/tencent/mm/plugin/dbbackup/a/a$d;
    //   338: ifnull +112 -> 450
    //   341: iload 4
    //   343: istore_1
    //   344: iload 4
    //   346: istore_2
    //   347: iload 4
    //   349: istore_3
    //   350: ldc 138
    //   352: ldc_w 584
    //   355: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: iload 4
    //   360: istore_1
    //   361: iload 4
    //   363: istore_2
    //   364: iload 4
    //   366: istore_3
    //   367: aload_0
    //   368: getfield 327	com/tencent/mm/plugin/dbbackup/a/a:xjF	Lcom/tencent/mm/plugin/dbbackup/a/a$d;
    //   371: invokeinterface 588 1 0
    //   376: astore 10
    //   378: aload 10
    //   380: ifnull +24 -> 404
    //   383: iload 4
    //   385: istore_1
    //   386: iload 4
    //   388: istore_2
    //   389: iload 4
    //   391: istore_3
    //   392: aload_0
    //   393: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:xjD	Ljava/util/List;
    //   396: aload 10
    //   398: invokeinterface 592 2 0
    //   403: pop
    //   404: iload 4
    //   406: istore_1
    //   407: iload 4
    //   409: istore_2
    //   410: iload 4
    //   412: istore_3
    //   413: aload_0
    //   414: getfield 327	com/tencent/mm/plugin/dbbackup/a/a:xjF	Lcom/tencent/mm/plugin/dbbackup/a/a$d;
    //   417: invokeinterface 595 1 0
    //   422: astore 10
    //   424: aload 10
    //   426: ifnull +24 -> 450
    //   429: iload 4
    //   431: istore_1
    //   432: iload 4
    //   434: istore_2
    //   435: iload 4
    //   437: istore_3
    //   438: aload_0
    //   439: getfield 464	com/tencent/mm/plugin/dbbackup/a/a:xjE	Ljava/util/List;
    //   442: aload 10
    //   444: invokeinterface 592 2 0
    //   449: pop
    //   450: iload 4
    //   452: istore_1
    //   453: iload 4
    //   455: istore_2
    //   456: iload 4
    //   458: istore_3
    //   459: aload_0
    //   460: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:xjD	Ljava/util/List;
    //   463: invokeinterface 596 1 0
    //   468: ifeq +23 -> 491
    //   471: iload 4
    //   473: istore_1
    //   474: iload 4
    //   476: istore_2
    //   477: iload 4
    //   479: istore_3
    //   480: aload_0
    //   481: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:xjD	Ljava/util/List;
    //   484: aconst_null
    //   485: invokeinterface 597 2 0
    //   490: pop
    //   491: iload 4
    //   493: istore_1
    //   494: iload 4
    //   496: istore_2
    //   497: iload 4
    //   499: istore_3
    //   500: aload_0
    //   501: getfield 464	com/tencent/mm/plugin/dbbackup/a/a:xjE	Ljava/util/List;
    //   504: invokeinterface 596 1 0
    //   509: ifeq +23 -> 532
    //   512: iload 4
    //   514: istore_1
    //   515: iload 4
    //   517: istore_2
    //   518: iload 4
    //   520: istore_3
    //   521: aload_0
    //   522: getfield 464	com/tencent/mm/plugin/dbbackup/a/a:xjE	Ljava/util/List;
    //   525: aconst_null
    //   526: invokeinterface 597 2 0
    //   531: pop
    //   532: iconst_0
    //   533: istore_2
    //   534: iconst_0
    //   535: istore_3
    //   536: iconst_0
    //   537: istore_1
    //   538: aload_0
    //   539: invokespecial 600	com/tencent/mm/plugin/dbbackup/a/a:due	()I
    //   542: istore 4
    //   544: iload 4
    //   546: ifeq +163 -> 709
    //   549: iload 4
    //   551: tableswitch	default:+29 -> 580, -2:+150->701, -1:+29->580, 0:+105->656, 1:+142->693
    //   581: dstore 184
    //   583: aconst_null
    //   584: <illegal opcode>
    //   585: aload 11
    //   587: invokevirtual 559	android/os/PowerManager$WakeLock:isHeld	()Z
    //   590: ifeq +54 -> 644
    //   593: aload 11
    //   595: ldc_w 516
    //   598: ldc_w 518
    //   601: ldc_w 520
    //   604: ldc_w 522
    //   607: ldc_w 561
    //   610: ldc_w 562
    //   613: invokestatic 564	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload 11
    //   618: invokevirtual 566	android/os/PowerManager$WakeLock:release	()V
    //   621: aload 11
    //   623: ldc_w 516
    //   626: ldc_w 518
    //   629: ldc_w 520
    //   632: ldc_w 522
    //   635: ldc_w 561
    //   638: ldc_w 562
    //   641: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   644: sipush 23121
    //   647: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   650: iload 4
    //   652: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   655: areturn
    //   656: invokestatic 500	android/os/SystemClock:uptimeMillis	()J
    //   659: lstore 8
    //   661: bipush 55
    //   663: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   666: getstatic 572	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   669: ldc2_w 573
    //   672: ldc2_w 575
    //   675: lload 8
    //   677: lload 6
    //   679: lsub
    //   680: ldc2_w 577
    //   683: ldiv
    //   684: lconst_1
    //   685: ladd
    //   686: iconst_1
    //   687: invokevirtual 582	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   690: goto -105 -> 585
    //   693: bipush 56
    //   695: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   698: goto -113 -> 585
    //   701: bipush 58
    //   703: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   706: goto -121 -> 585
    //   709: iload 4
    //   711: istore_1
    //   712: iload 4
    //   714: istore_2
    //   715: iload 4
    //   717: istore_3
    //   718: aload_0
    //   719: iconst_1
    //   720: anewarray 176	java/lang/Integer
    //   723: dup
    //   724: iconst_0
    //   725: iconst_2
    //   726: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   729: aastore
    //   730: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   733: iload 4
    //   735: istore_1
    //   736: iload 4
    //   738: istore_2
    //   739: iload 4
    //   741: istore_3
    //   742: aload_0
    //   743: invokespecial 603	com/tencent/mm/plugin/dbbackup/a/a:duf	()I
    //   746: istore 5
    //   748: iload 5
    //   750: iconst_1
    //   751: if_icmpne +166 -> 917
    //   754: iload 5
    //   756: tableswitch	default:+32 -> 788, -2:+153->909, -1:+32->788, 0:+108->864, 1:+145->901
    //   789: dstore 184
    //   791: aconst_null
    //   792: <illegal opcode>
    //   793: aload 11
    //   795: invokevirtual 559	android/os/PowerManager$WakeLock:isHeld	()Z
    //   798: ifeq +54 -> 852
    //   801: aload 11
    //   803: ldc_w 516
    //   806: ldc_w 518
    //   809: ldc_w 520
    //   812: ldc_w 522
    //   815: ldc_w 561
    //   818: ldc_w 562
    //   821: invokestatic 564	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   824: aload 11
    //   826: invokevirtual 566	android/os/PowerManager$WakeLock:release	()V
    //   829: aload 11
    //   831: ldc_w 516
    //   834: ldc_w 518
    //   837: ldc_w 520
    //   840: ldc_w 522
    //   843: ldc_w 561
    //   846: ldc_w 562
    //   849: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   852: sipush 23121
    //   855: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   858: iload 5
    //   860: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   863: areturn
    //   864: invokestatic 500	android/os/SystemClock:uptimeMillis	()J
    //   867: lstore 8
    //   869: bipush 55
    //   871: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   874: getstatic 572	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   877: ldc2_w 573
    //   880: ldc2_w 575
    //   883: lload 8
    //   885: lload 6
    //   887: lsub
    //   888: ldc2_w 577
    //   891: ldiv
    //   892: lconst_1
    //   893: ladd
    //   894: iconst_1
    //   895: invokevirtual 582	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   898: goto -105 -> 793
    //   901: bipush 56
    //   903: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   906: goto -113 -> 793
    //   909: bipush 58
    //   911: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   914: goto -121 -> 793
    //   917: iload 5
    //   919: istore 4
    //   921: iload 5
    //   923: iconst_m1
    //   924: if_icmpne +42 -> 966
    //   927: iload 5
    //   929: istore_1
    //   930: iload 5
    //   932: istore_2
    //   933: iload 5
    //   935: istore_3
    //   936: aload_0
    //   937: iconst_1
    //   938: anewarray 176	java/lang/Integer
    //   941: dup
    //   942: iconst_0
    //   943: iconst_4
    //   944: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   947: aastore
    //   948: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   951: iload 5
    //   953: istore_1
    //   954: iload 5
    //   956: istore_2
    //   957: iload 5
    //   959: istore_3
    //   960: aload_0
    //   961: invokespecial 606	com/tencent/mm/plugin/dbbackup/a/a:dug	()I
    //   964: istore 4
    //   966: iload 4
    //   968: ifeq +165 -> 1133
    //   971: iload 4
    //   973: tableswitch	default:+31 -> 1004, -2:+152->1125, -1:+31->1004, 0:+107->1080, 1:+144->1117
    //   1005: dstore 184
    //   1007: aconst_null
    //   1008: <illegal opcode>
    //   1009: aload 11
    //   1011: invokevirtual 559	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1014: ifeq +54 -> 1068
    //   1017: aload 11
    //   1019: ldc_w 516
    //   1022: ldc_w 518
    //   1025: ldc_w 520
    //   1028: ldc_w 522
    //   1031: ldc_w 561
    //   1034: ldc_w 562
    //   1037: invokestatic 564	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1040: aload 11
    //   1042: invokevirtual 566	android/os/PowerManager$WakeLock:release	()V
    //   1045: aload 11
    //   1047: ldc_w 516
    //   1050: ldc_w 518
    //   1053: ldc_w 520
    //   1056: ldc_w 522
    //   1059: ldc_w 561
    //   1062: ldc_w 562
    //   1065: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1068: sipush 23121
    //   1071: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1074: iload 4
    //   1076: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1079: areturn
    //   1080: invokestatic 500	android/os/SystemClock:uptimeMillis	()J
    //   1083: lstore 8
    //   1085: bipush 55
    //   1087: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1090: getstatic 572	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1093: ldc2_w 573
    //   1096: ldc2_w 575
    //   1099: lload 8
    //   1101: lload 6
    //   1103: lsub
    //   1104: ldc2_w 577
    //   1107: ldiv
    //   1108: lconst_1
    //   1109: ladd
    //   1110: iconst_1
    //   1111: invokevirtual 582	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1114: goto -105 -> 1009
    //   1117: bipush 56
    //   1119: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1122: goto -113 -> 1009
    //   1125: bipush 58
    //   1127: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1130: goto -121 -> 1009
    //   1133: iload 4
    //   1135: istore_1
    //   1136: iload 4
    //   1138: istore_2
    //   1139: iload 4
    //   1141: istore_3
    //   1142: aload_0
    //   1143: iconst_1
    //   1144: anewarray 176	java/lang/Integer
    //   1147: dup
    //   1148: iconst_0
    //   1149: iconst_5
    //   1150: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1153: aastore
    //   1154: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   1157: iload 4
    //   1159: istore_1
    //   1160: iload 4
    //   1162: istore_2
    //   1163: iload 4
    //   1165: istore_3
    //   1166: aload_0
    //   1167: invokespecial 609	com/tencent/mm/plugin/dbbackup/a/a:duh	()I
    //   1170: pop
    //   1171: iload 4
    //   1173: istore_1
    //   1174: iload 4
    //   1176: istore_2
    //   1177: iload 4
    //   1179: istore_3
    //   1180: aload_0
    //   1181: invokespecial 612	com/tencent/mm/plugin/dbbackup/a/a:dui	()I
    //   1184: istore 4
    //   1186: iload 4
    //   1188: istore_1
    //   1189: iload 4
    //   1191: istore_2
    //   1192: iload 4
    //   1194: istore_3
    //   1195: aload_0
    //   1196: iconst_1
    //   1197: anewarray 176	java/lang/Integer
    //   1200: dup
    //   1201: iconst_0
    //   1202: bipush 6
    //   1204: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1207: aastore
    //   1208: invokevirtual 260	com/tencent/mm/plugin/dbbackup/a/a:publishProgress	([Ljava/lang/Object;)V
    //   1211: iload 4
    //   1213: istore_1
    //   1214: iload 4
    //   1216: istore_2
    //   1217: iload 4
    //   1219: istore_3
    //   1220: aload_0
    //   1221: iconst_1
    //   1222: invokespecial 616	com/tencent/mm/plugin/dbbackup/a/a:ny	(Z)I
    //   1225: istore 4
    //   1227: iload 4
    //   1229: tableswitch	default:+31 -> 1260, -2:+152->1381, -1:+31->1260, 0:+107->1336, 1:+144->1373
    //   1261: dstore 184
    //   1263: aconst_null
    //   1264: <illegal opcode>
    //   1265: aload 11
    //   1267: invokevirtual 559	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1270: ifeq +54 -> 1324
    //   1273: aload 11
    //   1275: ldc_w 516
    //   1278: ldc_w 518
    //   1281: ldc_w 520
    //   1284: ldc_w 522
    //   1287: ldc_w 561
    //   1290: ldc_w 562
    //   1293: invokestatic 564	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1296: aload 11
    //   1298: invokevirtual 566	android/os/PowerManager$WakeLock:release	()V
    //   1301: aload 11
    //   1303: ldc_w 516
    //   1306: ldc_w 518
    //   1309: ldc_w 520
    //   1312: ldc_w 522
    //   1315: ldc_w 561
    //   1318: ldc_w 562
    //   1321: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1324: sipush 23121
    //   1327: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1330: iload 4
    //   1332: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1335: areturn
    //   1336: invokestatic 500	android/os/SystemClock:uptimeMillis	()J
    //   1339: lstore 8
    //   1341: bipush 55
    //   1343: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1346: getstatic 572	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1349: ldc2_w 573
    //   1352: ldc2_w 575
    //   1355: lload 8
    //   1357: lload 6
    //   1359: lsub
    //   1360: ldc2_w 577
    //   1363: ldiv
    //   1364: lconst_1
    //   1365: ladd
    //   1366: iconst_1
    //   1367: invokevirtual 582	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1370: goto -105 -> 1265
    //   1373: bipush 56
    //   1375: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1378: goto -113 -> 1265
    //   1381: bipush 58
    //   1383: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1386: goto -121 -> 1265
    //   1389: astore 10
    //   1391: iconst_m1
    //   1392: istore_3
    //   1393: iload_3
    //   1394: istore_1
    //   1395: ldc 138
    //   1397: ldc_w 618
    //   1400: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1403: iload_3
    //   1404: istore_1
    //   1405: aload_0
    //   1406: iconst_0
    //   1407: invokespecial 616	com/tencent/mm/plugin/dbbackup/a/a:ny	(Z)I
    //   1410: pop
    //   1411: iconst_1
    //   1412: istore_1
    //   1413: bipush 56
    //   1415: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1418: aload 11
    //   1420: invokevirtual 559	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1423: ifeq +54 -> 1477
    //   1426: aload 11
    //   1428: ldc_w 516
    //   1431: ldc_w 518
    //   1434: ldc_w 520
    //   1437: ldc_w 522
    //   1440: ldc_w 561
    //   1443: ldc_w 562
    //   1446: invokestatic 564	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1449: aload 11
    //   1451: invokevirtual 566	android/os/PowerManager$WakeLock:release	()V
    //   1454: aload 11
    //   1456: ldc_w 516
    //   1459: ldc_w 518
    //   1462: ldc_w 520
    //   1465: ldc_w 522
    //   1468: ldc_w 561
    //   1471: ldc_w 562
    //   1474: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1477: sipush 23121
    //   1480: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1483: iconst_1
    //   1484: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1487: areturn
    //   1488: astore 10
    //   1490: iload_2
    //   1491: istore_1
    //   1492: ldc 138
    //   1494: aload 10
    //   1496: ldc_w 620
    //   1499: iconst_0
    //   1500: anewarray 142	java/lang/Object
    //   1503: invokestatic 624	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1506: iload_2
    //   1507: istore_1
    //   1508: aload_0
    //   1509: iconst_0
    //   1510: invokespecial 616	com/tencent/mm/plugin/dbbackup/a/a:ny	(Z)I
    //   1513: pop
    //   1514: iconst_m1
    //   1515: istore_1
    //   1516: bipush 57
    //   1518: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1521: aload 11
    //   1523: invokevirtual 559	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1526: ifeq +54 -> 1580
    //   1529: aload 11
    //   1531: ldc_w 516
    //   1534: ldc_w 518
    //   1537: ldc_w 520
    //   1540: ldc_w 522
    //   1543: ldc_w 561
    //   1546: ldc_w 562
    //   1549: invokestatic 564	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1552: aload 11
    //   1554: invokevirtual 566	android/os/PowerManager$WakeLock:release	()V
    //   1557: aload 11
    //   1559: ldc_w 516
    //   1562: ldc_w 518
    //   1565: ldc_w 520
    //   1568: ldc_w 522
    //   1571: ldc_w 561
    //   1574: ldc_w 562
    //   1577: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1580: sipush 23121
    //   1583: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1586: iconst_m1
    //   1587: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1590: areturn
    //   1591: astore 10
    //   1593: iload_1
    //   1594: tableswitch	default:+30 -> 1624, -2:+148->1742, -1:+30->1624, 0:+103->1697, 1:+140->1734
    //   1625: dstore 184
    //   1627: aconst_null
    //   1628: <illegal opcode>
    //   1629: aload 11
    //   1631: invokevirtual 559	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1634: ifeq +54 -> 1688
    //   1637: aload 11
    //   1639: ldc_w 516
    //   1642: ldc_w 518
    //   1645: ldc_w 520
    //   1648: ldc_w 522
    //   1651: ldc_w 561
    //   1654: ldc_w 562
    //   1657: invokestatic 564	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1660: aload 11
    //   1662: invokevirtual 566	android/os/PowerManager$WakeLock:release	()V
    //   1665: aload 11
    //   1667: ldc_w 516
    //   1670: ldc_w 518
    //   1673: ldc_w 520
    //   1676: ldc_w 522
    //   1679: ldc_w 561
    //   1682: ldc_w 562
    //   1685: invokestatic 553	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1688: sipush 23121
    //   1691: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1694: aload 10
    //   1696: athrow
    //   1697: invokestatic 500	android/os/SystemClock:uptimeMillis	()J
    //   1700: lstore 8
    //   1702: bipush 55
    //   1704: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1707: getstatic 572	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1710: ldc2_w 573
    //   1713: ldc2_w 575
    //   1716: lload 8
    //   1718: lload 6
    //   1720: lsub
    //   1721: ldc2_w 577
    //   1724: ldiv
    //   1725: lconst_1
    //   1726: ladd
    //   1727: iconst_1
    //   1728: invokevirtual 582	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1731: goto -102 -> 1629
    //   1734: bipush 56
    //   1736: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1739: goto -110 -> 1629
    //   1742: bipush 58
    //   1744: invokestatic 473	com/tencent/mm/plugin/dbbackup/a/a:qY	(I)V
    //   1747: goto -118 -> 1629
    //   1750: astore 10
    //   1752: goto -159 -> 1593
    //   1755: astore 10
    //   1757: goto -267 -> 1490
    //   1760: astore 10
    //   1762: goto -369 -> 1393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1765	0	this	a
    //   134	1460	1	i	int
    //   12	1495	2	j	int
    //   333	1071	3	k	int
    //   156	1175	4	m	int
    //   746	212	5	n	int
    //   37	1682	6	l1	long
    //   97	1620	8	l2	long
    //   52	391	10	localObject1	Object
    //   1389	1	10	localOperationCanceledException1	OperationCanceledException
    //   1488	7	10	localException1	Exception
    //   1591	104	10	localObject2	Object
    //   1750	1	10	localObject3	Object
    //   1755	1	10	localException2	Exception
    //   1760	1	10	localOperationCanceledException2	OperationCanceledException
    //   32	1634	11	localWakeLock	android.os.PowerManager.WakeLock
    // Exception table:
    //   from	to	target	type
    //   135	150	1389	com/tencent/wcdb/support/OperationCanceledException
    //   152	158	1389	com/tencent/wcdb/support/OperationCanceledException
    //   135	150	1488	java/lang/Exception
    //   152	158	1488	java/lang/Exception
    //   135	150	1591	finally
    //   152	158	1591	finally
    //   1492	1506	1591	finally
    //   1508	1514	1591	finally
    //   334	341	1750	finally
    //   350	358	1750	finally
    //   367	378	1750	finally
    //   392	404	1750	finally
    //   413	424	1750	finally
    //   438	450	1750	finally
    //   459	471	1750	finally
    //   480	491	1750	finally
    //   500	512	1750	finally
    //   521	532	1750	finally
    //   538	544	1750	finally
    //   718	733	1750	finally
    //   742	748	1750	finally
    //   936	951	1750	finally
    //   960	966	1750	finally
    //   1142	1157	1750	finally
    //   1166	1171	1750	finally
    //   1180	1186	1750	finally
    //   1195	1211	1750	finally
    //   1220	1227	1750	finally
    //   1395	1403	1750	finally
    //   1405	1411	1750	finally
    //   334	341	1755	java/lang/Exception
    //   350	358	1755	java/lang/Exception
    //   367	378	1755	java/lang/Exception
    //   392	404	1755	java/lang/Exception
    //   413	424	1755	java/lang/Exception
    //   438	450	1755	java/lang/Exception
    //   459	471	1755	java/lang/Exception
    //   480	491	1755	java/lang/Exception
    //   500	512	1755	java/lang/Exception
    //   521	532	1755	java/lang/Exception
    //   538	544	1755	java/lang/Exception
    //   718	733	1755	java/lang/Exception
    //   742	748	1755	java/lang/Exception
    //   936	951	1755	java/lang/Exception
    //   960	966	1755	java/lang/Exception
    //   1142	1157	1755	java/lang/Exception
    //   1166	1171	1755	java/lang/Exception
    //   1180	1186	1755	java/lang/Exception
    //   1195	1211	1755	java/lang/Exception
    //   1220	1227	1755	java/lang/Exception
    //   334	341	1760	com/tencent/wcdb/support/OperationCanceledException
    //   350	358	1760	com/tencent/wcdb/support/OperationCanceledException
    //   367	378	1760	com/tencent/wcdb/support/OperationCanceledException
    //   392	404	1760	com/tencent/wcdb/support/OperationCanceledException
    //   413	424	1760	com/tencent/wcdb/support/OperationCanceledException
    //   438	450	1760	com/tencent/wcdb/support/OperationCanceledException
    //   459	471	1760	com/tencent/wcdb/support/OperationCanceledException
    //   480	491	1760	com/tencent/wcdb/support/OperationCanceledException
    //   500	512	1760	com/tencent/wcdb/support/OperationCanceledException
    //   521	532	1760	com/tencent/wcdb/support/OperationCanceledException
    //   538	544	1760	com/tencent/wcdb/support/OperationCanceledException
    //   718	733	1760	com/tencent/wcdb/support/OperationCanceledException
    //   742	748	1760	com/tencent/wcdb/support/OperationCanceledException
    //   936	951	1760	com/tencent/wcdb/support/OperationCanceledException
    //   960	966	1760	com/tencent/wcdb/support/OperationCanceledException
    //   1142	1157	1760	com/tencent/wcdb/support/OperationCanceledException
    //   1166	1171	1760	com/tencent/wcdb/support/OperationCanceledException
    //   1180	1186	1760	com/tencent/wcdb/support/OperationCanceledException
    //   1195	1211	1760	com/tencent/wcdb/support/OperationCanceledException
    //   1220	1227	1760	com/tencent/wcdb/support/OperationCanceledException
  }
  
  private int dud()
  {
    long l2 = 0L;
    AppMethodBeat.i(23123);
    Log.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
    if ((this.xjv == null) || (this.xjv.isEmpty()))
    {
      AppMethodBeat.o(23123);
      return -1;
    }
    this.xjI = false;
    this.xjJ = 300000;
    if (this.xjy != null) {}
    long l1;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(y.bEn(this.xjy));
        this.xjJ = localJSONObject.getInt("message");
        this.xjI = true;
        l1 = localJSONObject.getLong("dbSize");
        if (this.xjx != null) {
          l2 = y.bEl(this.xjx);
        }
        this.xjK = Math.max(l1, l2);
        this.xjK += Math.max(this.xjK / 10L, 67108864L);
        this.xjL = amB(this.xjv);
        if (this.xjK <= this.xjL) {
          break;
        }
        Log.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[] { Long.valueOf(this.xjK), Long.valueOf(this.xjL) });
        AppMethodBeat.o(23123);
        return -2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.xjy);
        l1 = 0L;
        continue;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.DBRecoveryTask", localException, "Cannot read statistics from file.", new Object[0]);
      }
      l1 = 0L;
    }
    Log.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d, corrupted db size: %d, latest statistic db size: %d", new Object[] { Long.valueOf(this.xjK), Long.valueOf(this.xjL), Integer.valueOf(this.xjJ), Long.valueOf(l2), Long.valueOf(l1) });
    AppMethodBeat.o(23123);
    return 0;
  }
  
  private int due()
  {
    AppMethodBeat.i(23124);
    if (this.xju != null)
    {
      if (this.xju.isOpen()) {
        this.xju.close();
      }
      this.xju = null;
    }
    this.mCancellationSignal.throwIfCanceled();
    String str = this.xjv + '-' + Util.getRandomString(6);
    Log.i("MicroMsg.DBRecoveryTask", "Open target database: ".concat(String.valueOf(str)));
    try
    {
      this.xju = SQLiteDatabase.openOrCreateDatabase(str, this.xjB, xjt, null, null, 1);
      DatabaseUtils.stringForQuery(this.xju, "PRAGMA journal_mode=OFF;", null);
      this.xju.execSQL("PRAGMA synchronous=OFF;");
      AppMethodBeat.o(23124);
      return 0;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", new Object[] { str, localException.getMessage() });
      e(1, "Cannot open target database", localException);
      AppMethodBeat.o(23124);
      throw localException;
    }
  }
  
  /* Error */
  private int duf()
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
    //   18: invokevirtual 685	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   21: iconst_5
    //   22: anewarray 91	java/lang/String
    //   25: astore 6
    //   27: aload 6
    //   29: iconst_0
    //   30: ldc_w 641
    //   33: aastore
    //   34: aload 6
    //   36: iconst_1
    //   37: ldc_w 716
    //   40: aastore
    //   41: aload 6
    //   43: iconst_2
    //   44: ldc_w 718
    //   47: aastore
    //   48: aload 6
    //   50: iconst_3
    //   51: ldc_w 720
    //   54: aastore
    //   55: aload 6
    //   57: iconst_4
    //   58: ldc_w 722
    //   61: aastore
    //   62: aload_0
    //   63: getfield 333	com/tencent/mm/plugin/dbbackup/a/a:xjz	Ljava/util/List;
    //   66: invokeinterface 726 1 0
    //   71: astore 9
    //   73: aconst_null
    //   74: astore 4
    //   76: aload 9
    //   78: invokeinterface 731 1 0
    //   83: ifeq +888 -> 971
    //   86: aload 9
    //   88: invokeinterface 735 1 0
    //   93: checkcast 91	java/lang/String
    //   96: astore 10
    //   98: aload 10
    //   100: invokestatic 739	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   103: ifne +22 -> 125
    //   106: ldc 138
    //   108: ldc_w 741
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
    //   137: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:xjD	Ljava/util/List;
    //   140: invokeinterface 417 1 0
    //   145: if_icmpge -69 -> 76
    //   148: aload_0
    //   149: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:xjD	Ljava/util/List;
    //   152: iload_1
    //   153: invokeinterface 422 2 0
    //   158: checkcast 742	[B
    //   161: astore 11
    //   163: aload 5
    //   165: astore 4
    //   167: aload 10
    //   169: iconst_0
    //   170: invokestatic 748	com/tencent/mm/b/q:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   173: aload 11
    //   175: aload 6
    //   177: invokestatic 754	com/tencent/wcdb/repair/RepairKit$MasterInfo:load	(Ljava/lang/String;[B[Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   180: astore 5
    //   182: aload 5
    //   184: astore 4
    //   186: ldc 138
    //   188: new 215	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 756
    //   195: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload 10
    //   200: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 758
    //   206: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload_1
    //   210: invokevirtual 761	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 5
    //   221: astore 4
    //   223: aload 4
    //   225: ifnonnull +403 -> 628
    //   228: aload 6
    //   230: invokestatic 765	com/tencent/wcdb/repair/RepairKit$MasterInfo:make	([Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   233: astore 6
    //   235: ldc 138
    //   237: ldc_w 767
    //   240: invokestatic 770	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   265: ldc_w 772
    //   268: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield 458	com/tencent/mm/plugin/dbbackup/a/a:xjx	Ljava/lang/String;
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
    //   296: getfield 464	com/tencent/mm/plugin/dbbackup/a/a:xjE	Ljava/util/List;
    //   299: invokeinterface 417 1 0
    //   304: if_icmpge +69 -> 373
    //   307: aload 8
    //   309: astore 5
    //   311: aload_0
    //   312: getfield 464	com/tencent/mm/plugin/dbbackup/a/a:xjE	Ljava/util/List;
    //   315: iload_1
    //   316: invokeinterface 422 2 0
    //   321: checkcast 742	[B
    //   324: astore 4
    //   326: aload 8
    //   328: astore 5
    //   330: new 774	com/tencent/wcdb/repair/RepairKit
    //   333: dup
    //   334: aload_0
    //   335: getfield 458	com/tencent/mm/plugin/dbbackup/a/a:xjx	Ljava/lang/String;
    //   338: aload 4
    //   340: getstatic 89	com/tencent/mm/plugin/dbbackup/a/a:xjt	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   343: aload 6
    //   345: invokespecial 777	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   348: astore 4
    //   350: aload 4
    //   352: invokevirtual 780	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   355: ifne +290 -> 645
    //   358: ldc 138
    //   360: ldc_w 782
    //   363: iload_1
    //   364: invokestatic 784	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   367: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 4
    //   375: ifnonnull +593 -> 968
    //   378: aload 4
    //   380: astore 5
    //   382: ldc 138
    //   384: ldc_w 786
    //   387: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload 4
    //   392: astore 5
    //   394: new 774	com/tencent/wcdb/repair/RepairKit
    //   397: dup
    //   398: aload_0
    //   399: getfield 458	com/tencent/mm/plugin/dbbackup/a/a:xjx	Ljava/lang/String;
    //   402: aload_0
    //   403: getfield 464	com/tencent/mm/plugin/dbbackup/a/a:xjE	Ljava/util/List;
    //   406: iconst_0
    //   407: invokeinterface 422 2 0
    //   412: checkcast 742	[B
    //   415: getstatic 89	com/tencent/mm/plugin/dbbackup/a/a:xjt	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   418: aload 6
    //   420: invokespecial 777	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
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
    //   442: invokespecial 789	com/tencent/mm/plugin/dbbackup/a/a$1:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;[I)V
    //   445: invokevirtual 793	com/tencent/wcdb/repair/RepairKit:setCallback	(Lcom/tencent/wcdb/repair/RepairKit$Callback;)V
    //   448: aload 4
    //   450: astore 6
    //   452: aload 4
    //   454: aload_0
    //   455: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   458: iconst_0
    //   459: aload_0
    //   460: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   463: invokevirtual 797	com/tencent/wcdb/repair/RepairKit:output	(Lcom/tencent/wcdb/database/SQLiteDatabase;ILcom/tencent/wcdb/support/CancellationSignal;)I
    //   466: istore_1
    //   467: iload_1
    //   468: ifne +291 -> 759
    //   471: aload 4
    //   473: astore 6
    //   475: aload 4
    //   477: invokevirtual 780	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   480: ifeq +187 -> 667
    //   483: aload 4
    //   485: astore 6
    //   487: aload 4
    //   489: invokevirtual 800	com/tencent/wcdb/repair/RepairKit:isDataCorrupted	()Z
    //   492: ifeq +175 -> 667
    //   495: aload 4
    //   497: astore 6
    //   499: new 714	java/lang/RuntimeException
    //   502: dup
    //   503: ldc_w 802
    //   506: invokespecial 803	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
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
    //   556: invokevirtual 804	com/tencent/wcdb/repair/RepairKit:release	()V
    //   559: sipush 23126
    //   562: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload 4
    //   567: athrow
    //   568: astore 5
    //   570: ldc 138
    //   572: new 215	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 806
    //   579: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 5
    //   584: invokevirtual 707	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   587: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 808
    //   593: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 10
    //   598: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 758
    //   604: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: iload_1
    //   608: invokevirtual 761	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
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
    //   630: ldc_w 810
    //   633: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: iconst_1
    //   637: istore_3
    //   638: aload 4
    //   640: astore 6
    //   642: goto -397 -> 245
    //   645: ldc 138
    //   647: ldc_w 812
    //   650: iload_1
    //   651: invokestatic 784	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   654: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokestatic 770	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: iload_1
    //   661: iconst_1
    //   662: iadd
    //   663: istore_1
    //   664: goto -378 -> 286
    //   667: aload 4
    //   669: astore 6
    //   671: ldc 138
    //   673: ldc_w 814
    //   676: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload 4
    //   681: astore 6
    //   683: aload_0
    //   684: getfield 630	com/tencent/mm/plugin/dbbackup/a/a:xjI	Z
    //   687: ifeq +54 -> 741
    //   690: aload 4
    //   692: astore 6
    //   694: aload 9
    //   696: iconst_0
    //   697: iaload
    //   698: i2f
    //   699: aload_0
    //   700: getfield 120	com/tencent/mm/plugin/dbbackup/a/a:xjJ	I
    //   703: i2f
    //   704: fdiv
    //   705: ldc_w 815
    //   708: fcmpg
    //   709: ifgt +32 -> 741
    //   712: aload 4
    //   714: astore 6
    //   716: getstatic 572	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   719: sipush 181
    //   722: sipush 181
    //   725: bipush 62
    //   727: bipush 63
    //   729: aload_0
    //   730: getfield 120	com/tencent/mm/plugin/dbbackup/a/a:xjJ	I
    //   733: aload 9
    //   735: iconst_0
    //   736: iaload
    //   737: iconst_1
    //   738: invokevirtual 818	com/tencent/mm/plugin/report/f:a	(IIIIIIZ)V
    //   741: aload 4
    //   743: ifnull +8 -> 751
    //   746: aload 4
    //   748: invokevirtual 804	com/tencent/wcdb/repair/RepairKit:release	()V
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
    //   770: ldc_w 820
    //   773: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   776: aload 4
    //   778: astore 6
    //   780: aload_0
    //   781: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   784: invokevirtual 685	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   787: goto -108 -> 679
    //   790: astore 5
    //   792: aload 4
    //   794: astore 6
    //   796: ldc 138
    //   798: new 215	java/lang/StringBuilder
    //   801: dup
    //   802: ldc_w 822
    //   805: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: aload 5
    //   810: invokevirtual 823	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload 4
    //   824: astore 6
    //   826: iconst_2
    //   827: ldc_w 825
    //   830: iload_3
    //   831: invokestatic 828	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   834: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   837: aload 5
    //   839: invokestatic 712	com/tencent/mm/plugin/dbbackup/a/a:e	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   842: aload 4
    //   844: ifnull +8 -> 852
    //   847: aload 4
    //   849: invokevirtual 804	com/tencent/wcdb/repair/RepairKit:release	()V
    //   852: sipush 23126
    //   855: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   858: iconst_m1
    //   859: ireturn
    //   860: aload 4
    //   862: astore 6
    //   864: new 714	java/lang/RuntimeException
    //   867: dup
    //   868: ldc_w 830
    //   871: invokespecial 803	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
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
  private int dug()
  {
    // Byte code:
    //   0: sipush 23127
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   10: invokevirtual 685	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   13: ldc 138
    //   15: ldc_w 832
    //   18: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 454	com/tencent/mm/plugin/dbbackup/a/a:xjA	Ljava/util/List;
    //   25: invokeinterface 726 1 0
    //   30: astore 5
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 5
    //   36: invokeinterface 731 1 0
    //   41: ifeq +98 -> 139
    //   44: aload 5
    //   46: invokeinterface 735 1 0
    //   51: checkcast 91	java/lang/String
    //   54: astore 4
    //   56: new 834	com/tencent/wcdb/repair/RecoverKit
    //   59: dup
    //   60: aload_0
    //   61: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: aload 4
    //   66: aload_0
    //   67: getfield 460	com/tencent/mm/plugin/dbbackup/a/a:xjD	Ljava/util/List;
    //   70: iconst_0
    //   71: invokeinterface 422 2 0
    //   76: checkcast 742	[B
    //   79: invokespecial 837	com/tencent/wcdb/repair/RecoverKit:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[B)V
    //   82: astore_3
    //   83: ldc 138
    //   85: ldc_w 839
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
    //   117: ldc_w 841
    //   120: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_3
    //   124: invokevirtual 707	java/lang/Exception:getMessage	()Ljava/lang/String;
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
    //   157: invokevirtual 845	com/tencent/wcdb/repair/RecoverKit:run	(ZLcom/tencent/wcdb/support/CancellationSignal;)I
    //   160: istore_1
    //   161: iload_1
    //   162: ifne +23 -> 185
    //   165: ldc 138
    //   167: ldc_w 847
    //   170: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_2
    //   174: invokevirtual 848	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   177: sipush 23127
    //   180: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iload_1
    //   184: ireturn
    //   185: iload_1
    //   186: iconst_1
    //   187: if_icmpne +43 -> 230
    //   190: ldc 138
    //   192: ldc_w 850
    //   195: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 115	com/tencent/mm/plugin/dbbackup/a/a:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   202: invokevirtual 685	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   205: goto -32 -> 173
    //   208: astore_3
    //   209: sipush 23127
    //   212: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_3
    //   216: athrow
    //   217: astore_3
    //   218: aload_2
    //   219: invokevirtual 848	com/tencent/wcdb/repair/RecoverKit:release	()V
    //   222: sipush 23127
    //   225: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_3
    //   229: athrow
    //   230: ldc 138
    //   232: ldc_w 852
    //   235: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -65 -> 173
    //   241: astore_3
    //   242: ldc 138
    //   244: new 215	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 822
    //   251: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_3
    //   255: invokevirtual 707	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: iconst_4
    //   268: ldc_w 854
    //   271: aload_3
    //   272: invokestatic 712	com/tencent/mm/plugin/dbbackup/a/a:e	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload_2
    //   276: invokevirtual 848	com/tencent/wcdb/repair/RecoverKit:release	()V
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
  
  private int duh()
  {
    AppMethodBeat.i(264931);
    try
    {
      this.xju.execSQL("DELETE FROM rconversation WHERE typeof(flag) <> 'integer';", null, this.mCancellationSignal);
      AppMethodBeat.o(264931);
      return 0;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      AppMethodBeat.o(264931);
      throw localOperationCanceledException;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.DBRecoveryTask", localException, "Verification failed", new Object[0]);
      AppMethodBeat.o(264931);
    }
    return -1;
  }
  
  /* Error */
  private int dui()
  {
    // Byte code:
    //   0: ldc_w 860
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 452	com/tencent/mm/plugin/dbbackup/a/a:xjw	Ljava/lang/String;
    //   10: ifnull +13 -> 23
    //   13: aload_0
    //   14: getfield 452	com/tencent/mm/plugin/dbbackup/a/a:xjw	Ljava/lang/String;
    //   17: invokevirtual 135	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc_w 860
    //   26: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: ldc 138
    //   33: ldc_w 862
    //   36: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   43: ldc_w 864
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
    //   61: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   64: ldc_w 866
    //   67: aconst_null
    //   68: invokestatic 195	com/tencent/wcdb/DatabaseUtils:longForQuery	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   71: lconst_1
    //   72: ladd
    //   73: lastore
    //   74: aload 10
    //   76: iconst_0
    //   77: laload
    //   78: ldc2_w 867
    //   81: lcmp
    //   82: ifle +21 -> 103
    //   85: aload 10
    //   87: iconst_0
    //   88: laload
    //   89: ldc2_w 869
    //   92: lcmp
    //   93: ifgt +10 -> 103
    //   96: aload 10
    //   98: iconst_0
    //   99: ldc2_w 871
    //   102: lastore
    //   103: new 874	java/util/HashMap
    //   106: dup
    //   107: iload_1
    //   108: iload_1
    //   109: iconst_2
    //   110: idiv
    //   111: iadd
    //   112: sipush 10240
    //   115: invokestatic 877	java/lang/Math:max	(II)I
    //   118: invokespecial 878	java/util/HashMap:<init>	(I)V
    //   121: astore 9
    //   123: new 9	com/tencent/mm/plugin/dbbackup/a/a$2
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 881	com/tencent/mm/plugin/dbbackup/a/a$2:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;)V
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 452	com/tencent/mm/plugin/dbbackup/a/a:xjw	Ljava/lang/String;
    //   137: aload_0
    //   138: getfield 456	com/tencent/mm/plugin/dbbackup/a/a:xjC	[B
    //   141: getstatic 89	com/tencent/mm/plugin/dbbackup/a/a:xjt	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   144: aconst_null
    //   145: iconst_1
    //   146: aload 4
    //   148: iconst_1
    //   149: invokestatic 885	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   152: astore 4
    //   154: aload_0
    //   155: aload 4
    //   157: ldc_w 378
    //   160: iconst_0
    //   161: iconst_0
    //   162: iconst_0
    //   163: aconst_null
    //   164: invokespecial 887	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   167: pop
    //   168: aload_0
    //   169: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
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
    //   206: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   209: ldc_w 380
    //   212: aload 5
    //   214: invokevirtual 890	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   237: ldc_w 892
    //   240: aastore
    //   241: aload_0
    //   242: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   245: ldc_w 380
    //   248: aload 5
    //   250: invokevirtual 890	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   273: ldc_w 894
    //   276: aastore
    //   277: aload_0
    //   278: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   281: ldc_w 380
    //   284: aload 5
    //   286: invokevirtual 890	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload_0
    //   290: aload 4
    //   292: iconst_2
    //   293: invokespecial 896	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   296: aload_0
    //   297: aload 4
    //   299: bipush 9
    //   301: invokespecial 896	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   304: aload_0
    //   305: aload 4
    //   307: bipush 42
    //   309: invokespecial 896	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)V
    //   312: aload_0
    //   313: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   316: invokevirtual 321	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   319: aload_0
    //   320: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   323: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   326: aload 4
    //   328: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   331: ldc_w 898
    //   334: aconst_null
    //   335: ldc_w 641
    //   338: invokevirtual 345	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   341: astore 8
    //   343: aload 8
    //   345: astore 5
    //   347: aload 8
    //   349: astore 6
    //   351: aload 8
    //   353: astore 7
    //   355: aload 8
    //   357: ldc_w 900
    //   360: invokeinterface 903 2 0
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
    //   400: ldc_w 641
    //   403: iconst_4
    //   404: iconst_1
    //   405: iconst_5
    //   406: new 11	com/tencent/mm/plugin/dbbackup/a/a$3
    //   409: dup
    //   410: aload_0
    //   411: iload_1
    //   412: aload 10
    //   414: aload 9
    //   416: invokespecial 906	com/tencent/mm/plugin/dbbackup/a/a$3:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;I[JLjava/util/HashMap;)V
    //   419: invokespecial 887	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   422: pop
    //   423: aload 8
    //   425: astore 5
    //   427: aload 8
    //   429: astore 6
    //   431: aload 8
    //   433: astore 7
    //   435: aload_0
    //   436: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   439: ldc_w 908
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
    //   467: ldc_w 910
    //   470: aconst_null
    //   471: ldc_w 722
    //   474: invokevirtual 345	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   477: astore 8
    //   479: aload 8
    //   481: astore 5
    //   483: aload 4
    //   485: astore 8
    //   487: aload 5
    //   489: astore 7
    //   491: aload 5
    //   493: ldc_w 912
    //   496: invokeinterface 903 2 0
    //   501: istore_1
    //   502: aload 4
    //   504: astore 8
    //   506: aload 5
    //   508: astore 7
    //   510: aload 5
    //   512: ldc_w 914
    //   515: invokeinterface 903 2 0
    //   520: istore_2
    //   521: aload 4
    //   523: astore 8
    //   525: aload 5
    //   527: astore 7
    //   529: aload 5
    //   531: ldc_w 916
    //   534: invokeinterface 903 2 0
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
    //   580: ldc_w 722
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
    //   596: invokespecial 919	com/tencent/mm/plugin/dbbackup/a/a$4:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;I[Ljava/lang/String;II)V
    //   599: invokespecial 887	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   602: pop
    //   603: aload 4
    //   605: astore 8
    //   607: aload 5
    //   609: astore 7
    //   611: aload 4
    //   613: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   616: ldc_w 921
    //   619: aconst_null
    //   620: ldc_w 716
    //   623: invokevirtual 345	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
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
    //   646: ldc_w 923
    //   649: invokeinterface 903 2 0
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
    //   689: ldc_w 716
    //   692: iconst_4
    //   693: iconst_1
    //   694: iconst_0
    //   695: new 15	com/tencent/mm/plugin/dbbackup/a/a$5
    //   698: dup
    //   699: aload_0
    //   700: iload_1
    //   701: aload 9
    //   703: invokespecial 926	com/tencent/mm/plugin/dbbackup/a/a$5:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   706: invokespecial 887	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   709: pop
    //   710: aload 8
    //   712: astore 5
    //   714: aload 8
    //   716: astore 6
    //   718: aload 8
    //   720: astore 7
    //   722: aload 4
    //   724: getstatic 201	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   727: ldc_w 928
    //   730: aconst_null
    //   731: ldc_w 718
    //   734: invokevirtual 345	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   737: astore 8
    //   739: aload 8
    //   741: astore 5
    //   743: aload 8
    //   745: astore 6
    //   747: aload 8
    //   749: astore 7
    //   751: aload 8
    //   753: ldc_w 923
    //   756: invokeinterface 903 2 0
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
    //   796: ldc_w 718
    //   799: iconst_4
    //   800: iconst_1
    //   801: iconst_0
    //   802: new 17	com/tencent/mm/plugin/dbbackup/a/a$6
    //   805: dup
    //   806: aload_0
    //   807: iload_1
    //   808: aload 9
    //   810: invokespecial 929	com/tencent/mm/plugin/dbbackup/a/a$6:<init>	(Lcom/tencent/mm/plugin/dbbackup/a/a;ILjava/util/HashMap;)V
    //   813: invokespecial 887	com/tencent/mm/plugin/dbbackup/a/a:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;IZILcom/tencent/mm/plugin/dbbackup/a/a$e;)I
    //   816: pop
    //   817: aload 8
    //   819: ifnull +20 -> 839
    //   822: aload 8
    //   824: invokeinterface 275 1 0
    //   829: ifne +10 -> 839
    //   832: aload 8
    //   834: invokeinterface 278 1 0
    //   839: aload_0
    //   840: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   843: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   846: ifeq +10 -> 856
    //   849: aload_0
    //   850: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   853: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   856: aload 4
    //   858: ifnull +8 -> 866
    //   861: aload 4
    //   863: invokevirtual 682	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   866: ldc_w 860
    //   869: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: iconst_0
    //   873: ireturn
    //   874: astore 5
    //   876: aconst_null
    //   877: astore 4
    //   879: aconst_null
    //   880: astore 6
    //   882: ldc 138
    //   884: ldc_w 931
    //   887: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   890: ldc_w 860
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
    //   924: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   927: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   930: ifeq +10 -> 940
    //   933: aload_0
    //   934: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   937: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   940: aload 6
    //   942: ifnull +8 -> 950
    //   945: aload 6
    //   947: invokevirtual 682	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   950: ldc_w 860
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
    //   981: ldc_w 933
    //   984: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   987: aload 6
    //   989: invokevirtual 707	java/lang/Exception:getMessage	()Ljava/lang/String;
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
    //   1014: ldc_w 935
    //   1017: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1020: aload_0
    //   1021: getfield 383	com/tencent/mm/plugin/dbbackup/a/a:xjG	Z
    //   1024: invokevirtual 938	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: aload 6
    //   1032: invokestatic 712	com/tencent/mm/plugin/dbbackup/a/a:e	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1035: aload 4
    //   1037: ifnull +20 -> 1057
    //   1040: aload 4
    //   1042: invokeinterface 275 1 0
    //   1047: ifne +10 -> 1057
    //   1050: aload 4
    //   1052: invokeinterface 278 1 0
    //   1057: aload_0
    //   1058: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1061: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   1064: ifeq +10 -> 1074
    //   1067: aload_0
    //   1068: getfield 149	com/tencent/mm/plugin/dbbackup/a/a:xju	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1071: invokevirtual 157	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   1074: aload 9
    //   1076: ifnull +8 -> 1084
    //   1079: aload 9
    //   1081: invokevirtual 682	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1084: ldc_w 860
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
  
  private static void e(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(23132);
    f.Ozc.e("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[] { Integer.valueOf(paramInt), paramString, "\n" + Util.stackTraceToString(paramThrowable) }), null);
    AppMethodBeat.o(23132);
  }
  
  private int ny(boolean paramBoolean)
  {
    AppMethodBeat.i(23125);
    Log.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.xjv);
    if (this.xju == null)
    {
      AppMethodBeat.o(23125);
      return -1;
    }
    u localu = new u(this.xju.getPath());
    if (this.xju.isOpen()) {
      this.xju.close();
    }
    if (paramBoolean)
    {
      if (!localu.am(new u(this.xjv)))
      {
        Log.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", new Object[] { localu, this.xjv });
        AppMethodBeat.o(23125);
        return -1;
      }
    }
    else
    {
      Log.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", new Object[] { localu });
      localu.diJ();
    }
    AppMethodBeat.o(23125);
    return 0;
  }
  
  private static void qY(int paramInt)
  {
    AppMethodBeat.i(23131);
    f.Ozc.idkeyStat(181L, paramInt, 1L, true);
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
    private List<String> xjA;
    private byte[] xjB;
    private byte[] xjC;
    public a.d xjF;
    public boolean xjG;
    public a.b xjH;
    private LinkedHashSet<byte[]> xjZ;
    public String xjv;
    public String xjw;
    public String xjx;
    public String xjy;
    private List<String> xjz;
    private LinkedHashSet<byte[]> xka;
    
    public a()
    {
      AppMethodBeat.i(23114);
      this.xjz = new ArrayList();
      this.xjA = new ArrayList();
      this.xjZ = new LinkedHashSet();
      this.xka = new LinkedHashSet();
      AppMethodBeat.o(23114);
    }
    
    public final a amC(String paramString)
    {
      AppMethodBeat.i(23116);
      this.xjz.add(paramString);
      AppMethodBeat.o(23116);
      return this;
    }
    
    public final a amD(String paramString)
    {
      AppMethodBeat.i(23117);
      this.xjA.add(paramString);
      AppMethodBeat.o(23117);
      return this;
    }
    
    public final a by(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(23118);
      this.xjB = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(23118);
      return this;
    }
    
    public final a bz(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(23119);
      this.xjC = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(23119);
      return this;
    }
    
    public final a duj()
    {
      AppMethodBeat.i(23115);
      a locala = new a((byte)0);
      a.a(locala, this.xjv);
      a.b(locala, this.xjw);
      a.c(locala, this.xjx);
      a.d(locala, this.xjy);
      a.a(locala, new ArrayList(this.xjz));
      a.b(locala, new ArrayList(this.xjA));
      a.a(locala, this.xjB);
      a.b(locala, this.xjC);
      a.a(locala, this.xjF);
      a.c(locala, new ArrayList(this.xjZ));
      a.d(locala, new ArrayList(this.xka));
      a.a(locala, this.xjG);
      a.a(locala, this.xjH);
      AppMethodBeat.o(23115);
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void al(long paramLong1, long paramLong2);
    
    public abstract void ap(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void dtR();
    
    public abstract void onCanceled();
    
    public abstract void onSuccess();
  }
  
  static final class c
  {
    final String defaultValue;
    final String name;
    final String type;
    final boolean xkb;
    final boolean xkc;
    
    c(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2)
    {
      this.name = paramString1;
      this.type = paramString2;
      this.xkb = paramBoolean1;
      this.defaultValue = paramString3;
      this.xkc = paramBoolean2;
    }
  }
  
  public static abstract interface d
  {
    public abstract Collection<byte[]> dtU();
    
    public abstract Collection<byte[]> dtV();
  }
  
  static abstract interface e
  {
    public abstract boolean a(Cursor paramCursor, SQLiteStatement paramSQLiteStatement);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a
 * JD-Core Version:    0.7.0.1
 */