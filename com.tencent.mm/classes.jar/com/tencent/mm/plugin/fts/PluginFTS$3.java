package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.util.concurrent.PriorityBlockingQueue;

final class PluginFTS$3
  implements DatabaseErrorHandler
{
  PluginFTS$3(PluginFTS paramPluginFTS) {}
  
  public final void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(156174);
    com.tencent.mm.plugin.fts.a.e.wq(18);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yHr, Integer.valueOf(3))).intValue();
    ab.e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yHr, Integer.valueOf(i - 1));
      try
      {
        PluginFTS.access$200(this.mQm);
        PluginFTS.access$300(this.mQm);
        if (PluginFTS.access$100(this.mQm) != null)
        {
          PluginFTS.access$100(this.mQm).close();
          PluginFTS.access$102(this.mQm, null);
        }
        d.bBO();
        this.mQm.setFTSIndexReady(false);
        paramSQLiteDatabase = PluginFTS.access$400(this.mQm);
        if (paramSQLiteDatabase.mPG != null) {
          paramSQLiteDatabase.mPG.mPI.clear();
        }
        PluginFTS.access$400(this.mQm).a(-131072, new PluginFTS.b(this.mQm));
      }
      catch (Exception paramSQLiteDatabase)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FTS.PluginFTS", paramSQLiteDatabase, "onCorruption handle error", new Object[0]);
        }
      }
      paramSQLiteDatabase = new SQLiteDatabaseCorruptException("Throw Exception From FTSDatabaseErrorHandler");
      AppMethodBeat.o(156174);
      throw paramSQLiteDatabase;
    }
    com.tencent.mm.plugin.fts.a.e.wq(23);
    AppMethodBeat.o(156174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.3
 * JD-Core Version:    0.7.0.1
 */