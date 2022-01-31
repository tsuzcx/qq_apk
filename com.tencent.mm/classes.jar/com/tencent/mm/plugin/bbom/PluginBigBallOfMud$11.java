package com.tencent.mm.plugin.bbom;

import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.d.b.3;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mrs.a.b;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import java.util.Iterator;
import java.util.List;

final class PluginBigBallOfMud$11
  implements SQLiteTrace
{
  PluginBigBallOfMud$11(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final void onConnectionObtained(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean) {}
  
  public final void onConnectionPoolBusy(SQLiteDatabase paramSQLiteDatabase, String paramString1, List<String> paramList, String paramString2)
  {
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (int i = g.DS().crd();; i = 0)
    {
      WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeoutBusy, 501, WXHardCoderJNI.hcDBActionWrite, "MicroMsg.PluginBigBallOfMud");
      return;
    }
  }
  
  public final void onDatabaseCorrupted(SQLiteDatabase paramSQLiteDatabase) {}
  
  public final void onSQLExecuted(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, long paramLong)
  {
    for (;;)
    {
      com.tencent.mm.model.d.b localb;
      try
      {
        localb = com.tencent.mm.model.d.b.Jg();
        boolean bool = ai.isMainThread();
        String str1 = paramSQLiteDatabase.getPath();
        a.b.a(paramSQLiteDatabase, paramString, paramLong);
        if (((paramLong <= localb.dZu) || (!bool)) && ((paramLong <= localb.dZw) || (bool))) {
          break label478;
        }
        paramSQLiteDatabase = com.tencent.mm.model.d.b.dZC.iterator();
        if (paramSQLiteDatabase.hasNext())
        {
          String str2 = (String)paramSQLiteDatabase.next();
          if ((bool) || (!str1.contains(str2))) {
            continue;
          }
          return;
        }
        if ((paramInt == 2) && (bool) && (paramLong < localb.dZv)) {
          break label478;
        }
        if (localb.dZa) {
          break label470;
        }
        paramString = paramString.trim().toUpperCase();
        if ((!paramString.startsWith("INSERT")) && (!paramString.startsWith("UPDATE")) && (!paramString.startsWith("DELETE")) && (!paramString.startsWith("COMMIT")) && (!paramString.startsWith("SELECT")))
        {
          paramSQLiteDatabase = null;
          if (bk.bl(paramSQLiteDatabase)) {
            break label478;
          }
          paramString = new StringBuilder();
          com.tencent.mm.model.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), paramString);
          com.tencent.mm.model.d.b.a("sql", paramSQLiteDatabase, paramString);
          com.tencent.mm.model.d.b.a("lastTime", String.valueOf(paramLong), paramString);
          if (!com.tencent.mm.sdk.a.b.foreground) {
            break label484;
          }
          paramSQLiteDatabase = "1";
          com.tencent.mm.model.d.b.a("foreground", paramSQLiteDatabase, paramString);
          com.tencent.mm.model.d.b.a("tname", Thread.currentThread().getName(), paramString);
          paramSQLiteDatabase = paramString.toString();
          y.d("MicroMsg.SQLTraceManager", "SQL Trace mark : " + paramSQLiteDatabase);
          au.DS().O(new b.3(localb, paramSQLiteDatabase));
          return;
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        y.printErrStackTrace("MicroMsg.SQLiteTrace", paramSQLiteDatabase, "Failed to send trace.", new Object[0]);
        return;
      }
      if (paramString.startsWith("INSERT")) {
        paramSQLiteDatabase = paramString.substring(0, paramString.indexOf("(", 0));
      }
      for (;;)
      {
        paramString = paramSQLiteDatabase;
        if (paramSQLiteDatabase.length() > 512) {
          paramString = paramSQLiteDatabase.substring(0, 512) + "...";
        }
        paramSQLiteDatabase = paramString;
        if (paramString.trim().endsWith(";")) {
          break;
        }
        paramSQLiteDatabase = paramString + ";";
        break;
        paramSQLiteDatabase = paramString;
        if (paramString.startsWith("COMMIT"))
        {
          if (paramLong <= localb.dZx) {
            break label479;
          }
          paramSQLiteDatabase = paramString + "task:" + bk.csb();
        }
      }
      label470:
      y.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
      label478:
      return;
      label479:
      paramSQLiteDatabase = null;
      continue;
      label484:
      paramSQLiteDatabase = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.11
 * JD-Core Version:    0.7.0.1
 */