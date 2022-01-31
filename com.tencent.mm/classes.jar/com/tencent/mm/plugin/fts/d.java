package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.io.File;

public final class d
  implements h
{
  private SQLiteDatabase ktN;
  private SQLiteStatement ktO;
  private SQLiteStatement ktP;
  private SQLiteStatement ktQ;
  
  public d(String paramString)
  {
    y.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", new Object[] { paramString });
    if (this.ktN != null)
    {
      y.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
      this.ktN.close();
    }
    paramString = new File(paramString, "FTS5IndexMicroMsg.db").getAbsolutePath();
    long l1 = System.currentTimeMillis();
    this.ktN = SQLiteDatabase.openOrCreateDatabase(paramString, null);
    Object localObject = q.zf();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN();
    long l2 = com.tencent.mm.kernel.a.CK();
    localObject = com.tencent.mm.a.g.p(((String)localObject + l2).getBytes());
    SQLiteDatabase localSQLiteDatabase = this.ktN;
    l2 = localSQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
    FTSJNIUtils.nativeInitFts(l2, (byte[])localObject);
    localSQLiteDatabase.releaseNativeConnection(l2, null);
    this.ktN.rawQuery("PRAGMA journal_mode=WAL;", null).close();
    this.ktN.execSQL("PRAGMA synchronous=NORMAL;");
    this.ktN.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "FTS5IndexVersion" }));
    this.ktO = this.ktN.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "FTS5IndexVersion" }));
    this.ktP = this.ktN.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "FTS5IndexVersion" }));
    this.ktQ = this.ktN.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "FTS5IndexVersion" }));
    l2 = System.currentTimeMillis();
    com.tencent.mm.plugin.fts.a.e.y(18, l2 - l1);
    y.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s", new Object[] { Long.valueOf(l2 - l1), bk.ht(paramString.length()) });
  }
  
  protected static final void aVp()
  {
    com.tencent.mm.kernel.g.DQ();
    new File(com.tencent.mm.kernel.g.DP().cachePath, "FTS5IndexMicroMsg.db").delete();
  }
  
  public static final File aVq()
  {
    com.tencent.mm.kernel.g.DQ();
    return new File(com.tencent.mm.kernel.g.DP().cachePath, "FTS5IndexMicroMsg.db");
  }
  
  public final void A(long paramLong1, long paramLong2)
  {
    this.ktP.bindLong(1, paramLong1);
    this.ktP.bindLong(2, paramLong2);
    this.ktP.execute();
  }
  
  public final Cursor DI(String paramString)
  {
    y.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    return new a(this.ktN.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, null, null, null));
  }
  
  public final boolean DJ(String paramString)
  {
    paramString = this.ktN.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    return bool;
  }
  
  /* Error */
  public final void beginTransaction()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   13: invokevirtual 244	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   28: invokevirtual 246	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   31: goto -10 -> 21
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	d
    //   16	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	34	finally
    //   24	31	34	finally
  }
  
  public final boolean cT(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((DJ("FTS5IndexVersion")) && (this.ktO != null)) {}
    for (paramInt1 = (int)z(paramInt1, 0L);; paramInt1 = 0)
    {
      y.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == paramInt2) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final void close()
  {
    SQLiteDatabase localSQLiteDatabase = this.ktN;
    if (this.ktN == null) {}
    for (boolean bool = false;; bool = this.ktN.isOpen())
    {
      y.w("MicroMsg.FTS.FTSIndexDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
      if ((this.ktN == null) || (!this.ktN.isOpen())) {
        return;
      }
      y.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", new Object[] { Boolean.valueOf(this.ktN.inTransaction()) });
      while (this.ktN.inTransaction()) {
        this.ktN.endTransaction();
      }
    }
    this.ktO.close();
    this.ktP.close();
    this.ktN.close();
    this.ktN = null;
  }
  
  /* Error */
  public final void commit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   13: invokevirtual 244	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   28: invokevirtual 283	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   31: aload_0
    //   32: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   35: invokevirtual 278	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   38: goto -17 -> 21
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	d
    //   16	2	1	bool	boolean
    //   41	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	41	finally
    //   24	38	41	finally
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    y.v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", new Object[] { paramString });
    return this.ktN.compileStatement(paramString);
  }
  
  public final void execSQL(String paramString)
  {
    y.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.ktN.execSQL(paramString);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    y.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.ktN.execSQL(paramString, paramArrayOfObject);
  }
  
  public final boolean inTransaction()
  {
    return (this.ktN != null) && (this.ktN.inTransaction());
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    y.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    return new a(this.ktN.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null));
  }
  
  /* Error */
  public final void rollback()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   6: ifnull +25 -> 31
    //   9: aload_0
    //   10: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   13: invokevirtual 273	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   16: ifeq +15 -> 31
    //   19: aload_0
    //   20: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   23: invokevirtual 244	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifne +6 -> 34
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: ldc 19
    //   36: ldc_w 301
    //   39: invokestatic 303	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 29	com/tencent/mm/plugin/fts/d:ktN	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   46: invokevirtual 278	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   49: goto -18 -> 31
    //   52: astore_2
    //   53: ldc 19
    //   55: aload_2
    //   56: ldc_w 305
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_2
    //   66: aastore
    //   67: invokestatic 309	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: goto -39 -> 31
    //   73: astore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	d
    //   26	2	1	bool	boolean
    //   52	14	2	localException	java.lang.Exception
    //   73	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	49	52	java/lang/Exception
    //   2	27	73	finally
    //   34	42	73	finally
    //   42	49	73	finally
    //   53	70	73	finally
  }
  
  public final long z(long paramLong1, long paramLong2)
  {
    this.ktO.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.ktO.simpleQueryForLong();
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException) {}
    return paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.d
 * JD-Core Version:    0.7.0.1
 */