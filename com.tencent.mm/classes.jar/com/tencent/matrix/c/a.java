package com.tencent.matrix.c;

import com.tencent.matrix.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options.Builder;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static Map<String, Boolean> cwe = new HashMap();
  private static SQLiteLintPlugin cwf;
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong)
  {
    if (!b.GE()) {}
    do
    {
      do
      {
        return;
        if (cwf != null) {
          break;
        }
        localObject1 = (SQLiteLintPlugin)b.GF().V(SQLiteLintPlugin.class);
        cwf = (SQLiteLintPlugin)localObject1;
      } while (localObject1 == null);
    } while (!cwf.isPluginStarted());
    ad.v("Matrix.MatrixSQLiteLintManager", "onSQLExecuted  String sql:%s,  timeCost:%d", new Object[] { paramString, Long.valueOf(paramLong) });
    Object localObject1 = paramSQLiteDatabase.getPath();
    Object localObject2;
    if (!cwe.containsKey(localObject1))
    {
      paramSQLiteDatabase = new SQLiteLint.InstallEnv((String)localObject1, new a.a(paramSQLiteDatabase));
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
      paramSQLiteDatabase.setWhiteListXml(2131951669);
    }
    for (;;)
    {
      cwf.addConcernedDB(paramSQLiteDatabase);
      cwe.put(localObject1, Boolean.TRUE);
      cwf.notifySqlExecution((String)localObject1, paramString, (int)paramLong);
      return;
      label230:
      if (((String)localObject2).endsWith("AppBrandComm.db")) {
        paramSQLiteDatabase.setWhiteListXml(2131951625);
      } else if (((String)localObject2).endsWith("SnsMicroMsg.db")) {
        paramSQLiteDatabase.setWhiteListXml(2131951745);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.c.a
 * JD-Core Version:    0.7.0.1
 */