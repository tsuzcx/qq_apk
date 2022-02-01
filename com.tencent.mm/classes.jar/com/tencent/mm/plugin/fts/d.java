package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  implements h
{
  public boolean tCE;
  private SQLiteDatabase tCF;
  private SQLiteStatement tCG;
  private SQLiteStatement tCH;
  private SQLiteStatement tCI;
  
  public d(String paramString)
  {
    AppMethodBeat.i(52528);
    ae.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", new Object[] { paramString + "FTS5IndexMicroMsg_encrypt.db" });
    if (this.tCF != null)
    {
      ae.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
      this.tCF.close();
    }
    String str = w.B(new k(paramString, "FTS5IndexMicroMsg_encrypt.db").fTh());
    long l1 = System.currentTimeMillis();
    com.tencent.mm.kernel.g.ajS();
    Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUU, "");
    paramString = (String)localObject;
    if (bu.isNullOrNil((String)localObject))
    {
      paramString = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      paramString = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.kernel.a.aiF() + q.cH(true) + v.aAC()).getBytes()).substring(0, 7);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUU, paramString);
    }
    this.tCF = SQLiteDatabase.openOrCreateDatabase(str, paramString.getBytes(), null, ((PluginFTS)com.tencent.mm.kernel.g.ad(PluginFTS.class)).getDatabaseErrorHandler());
    paramString = q.cH(true);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP();
    long l2 = com.tencent.mm.kernel.a.getUin();
    paramString = com.tencent.mm.b.g.C((paramString + l2).getBytes());
    localObject = this.tCF;
    l2 = ((SQLiteDatabase)localObject).acquireNativeConnectionHandle("initFTS", false, false);
    this.tCE = false;
    cVj();
    FTSJNIUtils.nativeInitFts(l2, paramString);
    ((SQLiteDatabase)localObject).releaseNativeConnection(l2, null);
    this.tCF.rawQuery("PRAGMA journal_mode=WAL;", null).close();
    this.tCF.execSQL("PRAGMA synchronous=NORMAL;");
    this.tCF.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "FTS5IndexVersion" }));
    this.tCG = this.tCF.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "FTS5IndexVersion" }));
    this.tCH = this.tCF.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "FTS5IndexVersion" }));
    this.tCI = this.tCF.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "FTS5IndexVersion" }));
    l2 = System.currentTimeMillis();
    com.tencent.mm.plugin.fts.a.e.ag(18, l2 - l1);
    long l3 = Q(-310L, 0L);
    int i = (int)Q(-310L, 0L);
    ae.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s %s supportICU %b finalStartBuildMessageTimestamp %s finalStartBuildMessageClientVersion %s", new Object[] { Long.valueOf(l2 - l1), bu.a(o.aZR(str), 2.0D), q.cH(true), Boolean.valueOf(this.tCE), i.formatTime("yyyy-MM-dd HH:mm:ss", l3 / 1000L), Integer.toHexString(i) });
    AppMethodBeat.o(52528);
  }
  
  protected static final void cVh()
  {
    AppMethodBeat.i(52543);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().cachePath + "FTS5IndexMicroMsg_encrypt.db";
    int i = 0;
    while (i < 4)
    {
      String str = new String[] { "", "-journal", "-wal", "-shm" }[i];
      str = (String)localObject + str;
      ae.i("MicroMsg.FTS.FTSIndexDB", "deleteIndexDB %s %s", new Object[] { str, Boolean.valueOf(o.fB(str)) });
      o.deleteFile(str);
      i += 1;
    }
    AppMethodBeat.o(52543);
  }
  
  public static final k cVi()
  {
    AppMethodBeat.i(176903);
    com.tencent.mm.kernel.g.ajS();
    k localk = new k(com.tencent.mm.kernel.g.ajR().cachePath, "FTS5IndexMicroMsg_encrypt.db");
    AppMethodBeat.o(176903);
    return localk;
  }
  
  private static void cVj()
  {
    AppMethodBeat.i(52547);
    k[] arrayOfk = new k("/system/usr/icu").fTj();
    if (arrayOfk != null)
    {
      int j = arrayOfk.length;
      int i = 0;
      while (i < j)
      {
        ae.i("MicroMsg.FTS.FTSIndexDB", "icu file %s", new Object[] { arrayOfk[i].getName() });
        i += 1;
      }
    }
    AppMethodBeat.o(52547);
  }
  
  public final long Q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(52533);
    this.tCG.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.tCG.simpleQueryForLong();
      AppMethodBeat.o(52533);
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      AppMethodBeat.o(52533);
    }
    return paramLong2;
  }
  
  public final void R(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(52534);
    this.tCH.bindLong(1, paramLong1);
    this.tCH.bindLong(2, paramLong2);
    this.tCH.execute();
    AppMethodBeat.o(52534);
  }
  
  public final Cursor ald(String paramString)
  {
    AppMethodBeat.i(52530);
    ae.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = new a(this.tCF.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, null, null, null));
    AppMethodBeat.o(52530);
    return paramString;
  }
  
  public final boolean ale(String paramString)
  {
    AppMethodBeat.i(52535);
    paramString = this.tCF.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    AppMethodBeat.o(52535);
    return bool;
  }
  
  public final void au(String paramString, long paramLong)
  {
    AppMethodBeat.i(52545);
    long l = System.currentTimeMillis();
    execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE aux_index=? AND timestamp <= ?);", new Object[] { "FTS5IndexMessage", "FTS5MetaMessage" }), new String[] { paramString, String.valueOf(paramLong) });
    execSQL(String.format("DELETE FROM %s WHERE aux_index=? AND timestamp <= ?", new Object[] { "FTS5MetaMessage" }), new String[] { paramString, String.valueOf(paramLong) });
    l = System.currentTimeMillis() - l;
    ae.i("MicroMsg.FTS.FTSIndexDB", "deleteTalkerMsgByTimestamp use time %d talker %s timestamp %s", new Object[] { Long.valueOf(l), paramString, i.formatTime("yyyy-MM-dd HH:mm:ss", paramLong / 1000L) });
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(729L, 10L, 1L, false);
    if (l > 500L)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(79L, 11L, 1L, false);
      AppMethodBeat.o(52545);
      return;
    }
    if (l > 1000L)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(79L, 12L, 1L, false);
      AppMethodBeat.o(52545);
      return;
    }
    if (l > 10000L) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(79L, 13L, 1L, false);
    }
    AppMethodBeat.o(52545);
  }
  
  /* Error */
  public final void beginTransaction()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 430
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 50	com/tencent/mm/plugin/fts/d:tCF	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 50	com/tencent/mm/plugin/fts/d:tCF	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   19: invokevirtual 433	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   22: ifeq +12 -> 34
    //   25: ldc_w 430
    //   28: invokestatic 297	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 50	com/tencent/mm/plugin/fts/d:tCF	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   38: invokevirtual 435	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   41: ldc_w 430
    //   44: invokestatic 297	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -16 -> 31
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	d
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	50	finally
    //   25	31	50	finally
    //   34	47	50	finally
  }
  
  public final void close()
  {
    AppMethodBeat.i(52538);
    SQLiteDatabase localSQLiteDatabase = this.tCF;
    if (this.tCF == null) {}
    for (boolean bool = false;; bool = this.tCF.isOpen())
    {
      ae.w("MicroMsg.FTS.FTSIndexDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
      if ((this.tCF == null) || (!this.tCF.isOpen())) {
        break label142;
      }
      ae.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", new Object[] { Boolean.valueOf(this.tCF.inTransaction()) });
      while (this.tCF.inTransaction()) {
        this.tCF.endTransaction();
      }
    }
    this.tCG.close();
    this.tCH.close();
    this.tCF.close();
    this.tCF = null;
    label142:
    AppMethodBeat.o(52538);
  }
  
  /* Error */
  public final void commit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 451
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 50	com/tencent/mm/plugin/fts/d:tCF	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 50	com/tencent/mm/plugin/fts/d:tCF	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   19: invokevirtual 433	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   22: ifne +12 -> 34
    //   25: ldc_w 451
    //   28: invokestatic 297	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 50	com/tencent/mm/plugin/fts/d:tCF	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   38: invokevirtual 454	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   41: aload_0
    //   42: getfield 50	com/tencent/mm/plugin/fts/d:tCF	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   45: invokevirtual 448	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   48: ldc_w 451
    //   51: invokestatic 297	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -23 -> 31
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	d
    //   57	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	57	finally
    //   25	31	57	finally
    //   34	54	57	finally
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    AppMethodBeat.i(52531);
    ae.v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", new Object[] { paramString });
    paramString = this.tCF.compileStatement(paramString);
    AppMethodBeat.o(52531);
    return paramString;
  }
  
  public final void deleteMsgById(long paramLong)
  {
    AppMethodBeat.i(52546);
    long l = System.currentTimeMillis();
    String str = String.format("UPDATE %s SET status=? WHERE entity_id=?;", new Object[] { "FTS5MetaMessage" });
    this.tCF.execSQL(str, new String[] { "-1", String.valueOf(paramLong) });
    execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE entity_id=?);", new Object[] { "FTS5IndexMessage", "FTS5MetaMessage" }), new String[] { String.valueOf(paramLong) });
    execSQL(String.format("DELETE FROM %s WHERE entity_id=?", new Object[] { "FTS5MetaMessage" }), new String[] { String.valueOf(paramLong) });
    ae.i("MicroMsg.FTS.FTSIndexDB", "deleteMsgById use time %d msgId %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(paramLong) });
    AppMethodBeat.o(52546);
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(52536);
    ae.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.tCF.execSQL(paramString);
    AppMethodBeat.o(52536);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(52537);
    ae.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.tCF.execSQL(paramString, paramArrayOfObject);
    AppMethodBeat.o(52537);
  }
  
  public final boolean ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52532);
    if ((ale("FTS5IndexVersion")) && (this.tCG != null)) {}
    for (paramInt1 = (int)Q(paramInt1, 0L);; paramInt1 = 0)
    {
      ae.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == paramInt2)
      {
        AppMethodBeat.o(52532);
        return true;
      }
      AppMethodBeat.o(52532);
      return false;
    }
  }
  
  public final boolean inTransaction()
  {
    AppMethodBeat.i(52540);
    if ((this.tCF == null) || (!this.tCF.inTransaction()))
    {
      AppMethodBeat.o(52540);
      return false;
    }
    AppMethodBeat.o(52540);
    return true;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52529);
    ae.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = new a(this.tCF.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null));
    AppMethodBeat.o(52529);
    return paramString;
  }
  
  public final void rollback()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(52542);
        if ((this.tCF != null) && (this.tCF.isOpen()) && (this.tCF.inTransaction())) {
          continue;
        }
        AppMethodBeat.o(52542);
      }
      finally
      {
        try
        {
          this.tCF.endTransaction();
          AppMethodBeat.o(52542);
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", localException, "occur error \n%s", new Object[] { localException });
          AppMethodBeat.o(52542);
        }
        localObject = finally;
      }
      return;
      ae.i("MicroMsg.FTS.FTSIndexDB", "rollback");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.d
 * JD-Core Version:    0.7.0.1
 */