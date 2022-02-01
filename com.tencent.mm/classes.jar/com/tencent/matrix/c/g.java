package com.tencent.matrix.c;

import com.tencent.matrix.c;
import com.tencent.mm.plugin.report.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options.Builder;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static Map<String, Boolean> eWt = new HashMap();
  private static SQLiteLintPlugin eWu;
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong)
  {
    if (!c.isInstalled()) {}
    do
    {
      do
      {
        return;
        if (eWu != null) {
          break;
        }
        localObject1 = (SQLiteLintPlugin)c.avW().ai(SQLiteLintPlugin.class);
        eWu = (SQLiteLintPlugin)localObject1;
      } while (localObject1 == null);
    } while (!eWu.isPluginStarted());
    Log.v("Matrix.MatrixSQLiteLintManager", "onSQLExecuted  String sql:%s,  timeCost:%d", new Object[] { paramString, Long.valueOf(paramLong) });
    Object localObject1 = paramSQLiteDatabase.getPath();
    Object localObject2;
    if (!eWt.containsKey(localObject1))
    {
      paramSQLiteDatabase = new SQLiteLint.InstallEnv((String)localObject1, new g.a(paramSQLiteDatabase));
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
        break label231;
      }
      paramSQLiteDatabase.setWhiteListXml(e.c.enmicromsg_sqlite_lint_whitelist);
    }
    for (;;)
    {
      eWu.addConcernedDB(paramSQLiteDatabase);
      eWt.put(localObject1, Boolean.TRUE);
      eWu.notifySqlExecution((String)localObject1, paramString, (int)paramLong);
      return;
      label231:
      if (((String)localObject2).endsWith("AppBrandComm.db")) {
        paramSQLiteDatabase.setWhiteListXml(e.c.appbrandcomm_sqlite_lint_whitelist);
      } else if (((String)localObject2).endsWith("SnsMicroMsg.db")) {
        paramSQLiteDatabase.setWhiteListXml(e.c.snsmicromsg_sqlite_lint_whitelist);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c.g
 * JD-Core Version:    0.7.0.1
 */