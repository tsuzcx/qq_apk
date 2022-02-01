package com.tencent.matrix.c;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.ISQLiteExecutionDelegate;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options.Builder;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, Boolean> cVe = new HashMap();
  private static SQLiteLintPlugin cVf;
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong)
  {
    if (!com.tencent.matrix.b.isInstalled()) {}
    do
    {
      do
      {
        return;
        if (cVf != null) {
          break;
        }
        localObject1 = (SQLiteLintPlugin)com.tencent.matrix.b.RG().Y(SQLiteLintPlugin.class);
        cVf = (SQLiteLintPlugin)localObject1;
      } while (localObject1 == null);
    } while (!cVf.isPluginStarted());
    Log.v("Matrix.MatrixSQLiteLintManager", "onSQLExecuted  String sql:%s,  timeCost:%d", new Object[] { paramString, Long.valueOf(paramLong) });
    Object localObject1 = paramSQLiteDatabase.getPath();
    Object localObject2;
    if (!cVe.containsKey(localObject1))
    {
      paramSQLiteDatabase = new SQLiteLint.InstallEnv((String)localObject1, new a(paramSQLiteDatabase));
      localObject2 = new SQLiteLint.Options.Builder();
      ((SQLiteLint.Options.Builder)localObject2).setReportBehaviour(true);
      ((SQLiteLint.Options.Builder)localObject2).setAlertBehaviour(false);
      paramSQLiteDatabase = new SQLiteLintConfig.ConcernDb(paramSQLiteDatabase, ((SQLiteLint.Options.Builder)localObject2).build());
      paramSQLiteDatabase.enableAvoidAutoIncrementChecker();
      paramSQLiteDatabase.enableAvoidSelectAllChecker();
      paramSQLiteDatabase.enableExplainQueryPlanChecker();
      paramSQLiteDatabase.enableRedundantIndexChecker();
      paramSQLiteDatabase.enableWithoutRowIdBetterChecker();
      paramSQLiteDatabase.enablePreparedStatementBetterChecker();
      localObject2 = paramSQLiteDatabase.getInstallEnv().getConcernedDbPath();
      if (!((String)localObject2).endsWith("EnMicroMsg.db")) {
        break label230;
      }
      paramSQLiteDatabase.setWhiteListXml(2132017207);
    }
    for (;;)
    {
      cVf.addConcernedDB(paramSQLiteDatabase);
      cVe.put(localObject1, Boolean.TRUE);
      cVf.notifySqlExecution((String)localObject1, paramString, (int)paramLong);
      return;
      label230:
      if (((String)localObject2).endsWith("AppBrandComm.db")) {
        paramSQLiteDatabase.setWhiteListXml(2132017162);
      } else if (((String)localObject2).endsWith("SnsMicroMsg.db")) {
        paramSQLiteDatabase.setWhiteListXml(2132017290);
      }
    }
  }
  
  static final class a
    implements ISQLiteExecutionDelegate
  {
    private final SQLiteDatabase mDb;
    
    a(SQLiteDatabase paramSQLiteDatabase)
    {
      this.mDb = paramSQLiteDatabase;
    }
    
    public final void execSQL(String paramString)
    {
      if (!this.mDb.isOpen())
      {
        Log.w("Matrix.MatrixSQLiteLintManager", "rawQuery db close", new Object[0]);
        return;
      }
      this.mDb.execSQL(paramString);
    }
    
    public final Cursor rawQuery(String paramString, String... paramVarArgs)
    {
      if (!this.mDb.isOpen())
      {
        Log.w("Matrix.MatrixSQLiteLintManager", "rawQuery db close", new Object[0]);
        return null;
      }
      return this.mDb.rawQuery(paramString, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.c.b
 * JD-Core Version:    0.7.0.1
 */