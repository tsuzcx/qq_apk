package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.d.b.3;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.database.SQLiteTrace.TraceInfo;
import java.util.Iterator;
import java.util.List;

final class PluginBigBallOfMud$27
  implements SQLiteTrace
{
  PluginBigBallOfMud$27(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final void onConnectionObtained(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean) {}
  
  public final void onConnectionPoolBusy(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean, List<SQLiteTrace.TraceInfo<String>> paramList, List<SQLiteTrace.TraceInfo<StackTraceElement[]>> paramList1)
  {
    AppMethodBeat.i(22408);
    paramBoolean = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (int i = g.ajF().fkS();; i = 0)
    {
      WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcDBTimeoutBusy, 501, WXHardCoderJNI.hcDBActionWrite, "MicroMsg.PluginBigBallOfMud");
      AppMethodBeat.o(22408);
      return;
    }
  }
  
  public final void onDatabaseCorrupted(SQLiteDatabase paramSQLiteDatabase) {}
  
  public final void onSQLExecuted(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22407);
    for (;;)
    {
      com.tencent.mm.model.d.b localb;
      try
      {
        localb = com.tencent.mm.model.d.b.aDy();
        boolean bool1 = aq.isMainThread();
        String str1 = paramSQLiteDatabase.getPath();
        a.a(paramSQLiteDatabase, paramString, paramLong);
        if (((paramLong > localb.hJX) && (bool1)) || ((paramLong > localb.hJZ) && (!bool1)))
        {
          paramSQLiteDatabase = com.tencent.mm.model.d.b.hKf.iterator();
          if (paramSQLiteDatabase.hasNext())
          {
            String str2 = (String)paramSQLiteDatabase.next();
            if (bool1) {
              continue;
            }
            boolean bool2 = str1.contains(str2);
            if (!bool2) {
              continue;
            }
          }
        }
        else
        {
          AppMethodBeat.o(22407);
          return;
        }
        if ((paramInt == 2) && (bool1) && (paramLong < localb.hJY)) {
          continue;
        }
        if (localb.hJD) {
          break label492;
        }
        paramString = paramString.trim().toUpperCase();
        if ((!paramString.startsWith("INSERT")) && (!paramString.startsWith("UPDATE")) && (!paramString.startsWith("DELETE")) && (!paramString.startsWith("COMMIT")) && (!paramString.startsWith("SELECT")))
        {
          paramSQLiteDatabase = null;
          if (!bt.isNullOrNil(paramSQLiteDatabase))
          {
            paramString = new StringBuilder();
            com.tencent.mm.model.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), paramString);
            com.tencent.mm.model.d.b.a("sql", paramSQLiteDatabase, paramString);
            com.tencent.mm.model.d.b.a("lastTime", String.valueOf(paramLong), paramString);
            if (!com.tencent.mm.sdk.a.b.foreground) {
              break label508;
            }
            paramSQLiteDatabase = "1";
            com.tencent.mm.model.d.b.a("foreground", paramSQLiteDatabase, paramString);
            com.tencent.mm.model.d.b.a("tname", Thread.currentThread().getName(), paramString);
            paramSQLiteDatabase = paramString.toString();
            ad.d("MicroMsg.SQLTraceManager", "SQL Trace mark : ".concat(String.valueOf(paramSQLiteDatabase)));
            ba.ajF().ay(new b.3(localb, paramSQLiteDatabase));
          }
          AppMethodBeat.o(22407);
          return;
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        ad.printErrStackTrace("MicroMsg.SQLiteTrace", paramSQLiteDatabase, "Failed to send trace.", new Object[0]);
        AppMethodBeat.o(22407);
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
          if (paramLong <= localb.hKa) {
            break label503;
          }
          paramSQLiteDatabase = paramString + "task:" + bt.flS();
        }
      }
      label492:
      ad.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
      continue;
      label503:
      paramSQLiteDatabase = null;
      continue;
      label508:
      paramSQLiteDatabase = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.27
 * JD-Core Version:    0.7.0.1
 */