package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.io.File;

public final class d
  implements h
{
  public boolean mPB;
  public SQLiteDatabase mPC;
  private SQLiteStatement mPD;
  private SQLiteStatement mPE;
  private SQLiteStatement mPF;
  
  public d(String paramString)
  {
    AppMethodBeat.i(136546);
    ab.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", new Object[] { paramString + "FTS5IndexMicroMsg_encrypt.db" });
    if (this.mPC != null)
    {
      ab.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
      this.mPC.close();
    }
    paramString = new File(paramString, "FTS5IndexMicroMsg_encrypt.db").getAbsolutePath();
    long l1 = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    this.mPC = SQLiteDatabase.openOrCreateDatabase(paramString, com.tencent.mm.a.g.w((com.tencent.mm.kernel.a.QC() + q.bP(true) + r.Zn()).getBytes()).substring(0, 7).getBytes(), null, ((PluginFTS)com.tencent.mm.kernel.g.G(PluginFTS.class)).getDatabaseErrorHandler());
    localObject = q.bP(true);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    long l2 = com.tencent.mm.kernel.a.getUin();
    localObject = com.tencent.mm.a.g.x(((String)localObject + l2).getBytes());
    SQLiteDatabase localSQLiteDatabase = this.mPC;
    l2 = localSQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
    this.mPB = false;
    bBQ();
    FTSJNIUtils.nativeInitFts(l2, (byte[])localObject);
    localSQLiteDatabase.releaseNativeConnection(l2, null);
    this.mPC.rawQuery("PRAGMA journal_mode=WAL;", null).close();
    this.mPC.execSQL("PRAGMA synchronous=NORMAL;");
    this.mPC.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "FTS5IndexVersion" }));
    this.mPD = this.mPC.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "FTS5IndexVersion" }));
    this.mPE = this.mPC.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "FTS5IndexVersion" }));
    this.mPF = this.mPC.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "FTS5IndexVersion" }));
    l2 = System.currentTimeMillis();
    com.tencent.mm.plugin.fts.a.e.P(18, l2 - l1);
    ab.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s %s supportICU %b", new Object[] { Long.valueOf(l2 - l1), bo.b(paramString.length(), 2.0D), q.bP(true), Boolean.valueOf(this.mPB) });
    AppMethodBeat.o(136546);
  }
  
  protected static final void bBO()
  {
    AppMethodBeat.i(136561);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().cachePath + "FTS5IndexMicroMsg_encrypt.db";
    int i = 0;
    while (i < 4)
    {
      String str = new String[] { "", "-journal", "-wal", "-shm" }[i];
      ab.i("MicroMsg.FTS.FTSIndexDB", "deleteIndexDB %s", new Object[] { (String)localObject + str });
      com.tencent.mm.vfs.e.deleteFile((String)localObject + str);
      i += 1;
    }
    AppMethodBeat.o(136561);
  }
  
  public static final File bBP()
  {
    AppMethodBeat.i(136562);
    com.tencent.mm.kernel.g.RM();
    File localFile = new File(com.tencent.mm.kernel.g.RL().cachePath, "FTS5IndexMicroMsg_encrypt.db");
    AppMethodBeat.o(136562);
    return localFile;
  }
  
  private static void bBQ()
  {
    AppMethodBeat.i(136563);
    File[] arrayOfFile = new File("/system/usr/icu").listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        ab.i("MicroMsg.FTS.FTSIndexDB", "icu file %s", new Object[] { arrayOfFile[i].getName() });
        i += 1;
      }
    }
    AppMethodBeat.o(136563);
  }
  
  public final long L(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(136551);
    this.mPD.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.mPD.simpleQueryForLong();
      AppMethodBeat.o(136551);
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      AppMethodBeat.o(136551);
    }
    return paramLong2;
  }
  
  public final void M(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(136552);
    this.mPE.bindLong(1, paramLong1);
    this.mPE.bindLong(2, paramLong2);
    this.mPE.execute();
    AppMethodBeat.o(136552);
  }
  
  public final Cursor OR(String paramString)
  {
    AppMethodBeat.i(136548);
    ab.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = new a(this.mPC.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, null, null, null));
    AppMethodBeat.o(136548);
    return paramString;
  }
  
  public final boolean OS(String paramString)
  {
    AppMethodBeat.i(136553);
    paramString = this.mPC.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    AppMethodBeat.o(136553);
    return bool;
  }
  
  /* Error */
  public final void beginTransaction()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 330
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 50	com/tencent/mm/plugin/fts/d:mPC	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 50	com/tencent/mm/plugin/fts/d:mPC	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   19: invokevirtual 333	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   22: ifeq +12 -> 34
    //   25: ldc_w 330
    //   28: invokestatic 232	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 50	com/tencent/mm/plugin/fts/d:mPC	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   38: invokevirtual 335	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   41: ldc_w 330
    //   44: invokestatic 232	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(136556);
    SQLiteDatabase localSQLiteDatabase = this.mPC;
    if (this.mPC == null) {}
    for (boolean bool = false;; bool = this.mPC.isOpen())
    {
      ab.w("MicroMsg.FTS.FTSIndexDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
      if ((this.mPC == null) || (!this.mPC.isOpen())) {
        break label142;
      }
      ab.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", new Object[] { Boolean.valueOf(this.mPC.inTransaction()) });
      while (this.mPC.inTransaction()) {
        this.mPC.endTransaction();
      }
    }
    this.mPD.close();
    this.mPE.close();
    this.mPC.close();
    this.mPC = null;
    label142:
    AppMethodBeat.o(136556);
  }
  
  /* Error */
  public final void commit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 351
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 50	com/tencent/mm/plugin/fts/d:mPC	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 50	com/tencent/mm/plugin/fts/d:mPC	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   19: invokevirtual 333	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   22: ifne +12 -> 34
    //   25: ldc_w 351
    //   28: invokestatic 232	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 50	com/tencent/mm/plugin/fts/d:mPC	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   38: invokevirtual 354	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   41: aload_0
    //   42: getfield 50	com/tencent/mm/plugin/fts/d:mPC	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   45: invokevirtual 348	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   48: ldc_w 351
    //   51: invokestatic 232	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(136549);
    ab.v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", new Object[] { paramString });
    paramString = this.mPC.compileStatement(paramString);
    AppMethodBeat.o(136549);
    return paramString;
  }
  
  public final void deleteMsgById(long paramLong)
  {
    AppMethodBeat.i(156173);
    long l = System.currentTimeMillis();
    String str = String.format("UPDATE %s SET status=? WHERE entity_id=?;", new Object[] { "FTS5MetaMessage" });
    this.mPC.execSQL(str, new String[] { "-1", String.valueOf(paramLong) });
    execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE entity_id=?);", new Object[] { "FTS5IndexMessage", "FTS5MetaMessage" }), new String[] { String.valueOf(paramLong) });
    execSQL(String.format("DELETE FROM %s WHERE entity_id=?", new Object[] { "FTS5MetaMessage" }), new String[] { String.valueOf(paramLong) });
    ab.i("MicroMsg.FTS.FTSIndexDB", "deleteMsgById use time %d msgId %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(paramLong) });
    AppMethodBeat.o(156173);
  }
  
  public final boolean er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136550);
    if ((OS("FTS5IndexVersion")) && (this.mPD != null)) {}
    for (paramInt1 = (int)L(paramInt1, 0L);; paramInt1 = 0)
    {
      ab.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == paramInt2)
      {
        AppMethodBeat.o(136550);
        return true;
      }
      AppMethodBeat.o(136550);
      return false;
    }
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(136554);
    ab.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.mPC.execSQL(paramString);
    AppMethodBeat.o(136554);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(136555);
    ab.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.mPC.execSQL(paramString, paramArrayOfObject);
    AppMethodBeat.o(136555);
  }
  
  public final boolean inTransaction()
  {
    AppMethodBeat.i(136558);
    if ((this.mPC == null) || (!this.mPC.inTransaction()))
    {
      AppMethodBeat.o(136558);
      return false;
    }
    AppMethodBeat.o(136558);
    return true;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(136547);
    ab.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = new a(this.mPC.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null));
    AppMethodBeat.o(136547);
    return paramString;
  }
  
  public final void rollback()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(136560);
        if ((this.mPC != null) && (this.mPC.isOpen()) && (this.mPC.inTransaction())) {
          continue;
        }
        AppMethodBeat.o(136560);
      }
      finally
      {
        try
        {
          this.mPC.endTransaction();
          AppMethodBeat.o(136560);
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", localException, "occur error \n%s", new Object[] { localException });
          AppMethodBeat.o(136560);
        }
        localObject = finally;
      }
      return;
      ab.i("MicroMsg.FTS.FTSIndexDB", "rollback");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.d
 * JD-Core Version:    0.7.0.1
 */