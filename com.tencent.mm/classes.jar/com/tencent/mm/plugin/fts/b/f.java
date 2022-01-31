package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public final class f
  implements ak
{
  public final void gu(long paramLong)
  {
    AppMethodBeat.i(136788);
    Object localObject;
    if (!g.RG())
    {
      localObject = new b();
      AppMethodBeat.o(136788);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = ((PluginFTS)g.G(PluginFTS.class)).getFTSIndexDB();
      if (localObject == null)
      {
        g.RM();
        boolean bool = new File(g.RL().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists();
        if (!bool)
        {
          AppMethodBeat.o(136788);
          return;
        }
        g.RM();
        localObject = new com.tencent.mm.plugin.fts.d(g.RL().cachePath);
        ((com.tencent.mm.plugin.fts.d)localObject).deleteMsgById(paramLong);
        ((com.tencent.mm.plugin.fts.d)localObject).close();
        com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteSingleMsg by create new ftsIndexDB");
        AppMethodBeat.o(136788);
        return;
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", localException, "syncDeleteSingleMsg", new Object[0]);
      AppMethodBeat.o(136788);
      return;
    }
    localException.deleteMsgById(paramLong);
    AppMethodBeat.o(136788);
  }
  
  public final void pk(String paramString)
  {
    AppMethodBeat.i(136790);
    com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete mark talker msg delete %s", new Object[] { paramString });
    if (!g.RG())
    {
      paramString = new b();
      AppMethodBeat.o(136790);
      throw paramString;
    }
    try
    {
      Object localObject2 = ((PluginFTS)g.G(PluginFTS.class)).getFTSIndexDB();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        g.RM();
        boolean bool = new File(g.RL().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists();
        if (!bool)
        {
          AppMethodBeat.o(136790);
          return;
        }
        g.RM();
        localObject1 = new com.tencent.mm.plugin.fts.d(g.RL().cachePath);
        com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncMarkTalkerMsgDelete by create new ftsIndexDB");
      }
      long l = System.currentTimeMillis();
      localObject2 = String.format("UPDATE %s SET status=? WHERE aux_index=?;", new Object[] { "FTS5MetaMessage" });
      ((com.tencent.mm.plugin.fts.d)localObject1).mPC.execSQL((String)localObject2, new String[] { "-1", paramString });
      ab.i("MicroMsg.FTS.FTSIndexDB", "markStatusByTalker use time %d talker %s status %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString, Integer.valueOf(-1) });
      AppMethodBeat.o(136790);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", paramString, "syncDeleteTalkerMsg", new Object[0]);
      AppMethodBeat.o(136790);
    }
  }
  
  public final void v(String paramString, long paramLong)
  {
    AppMethodBeat.i(136789);
    com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete fts talker msg %s %s", new Object[] { paramString, h.formatTime("yyyy-MM-dd HH:mm:ss", paramLong / 1000L) });
    if (!g.RG())
    {
      paramString = new b();
      AppMethodBeat.o(136789);
      throw paramString;
    }
    long l;
    try
    {
      com.tencent.mm.plugin.fts.d locald2 = ((PluginFTS)g.G(PluginFTS.class)).getFTSIndexDB();
      com.tencent.mm.plugin.fts.d locald1 = locald2;
      if (locald2 == null)
      {
        g.RM();
        boolean bool = new File(g.RL().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists();
        if (!bool)
        {
          AppMethodBeat.o(136789);
          return;
        }
        g.RM();
        locald1 = new com.tencent.mm.plugin.fts.d(g.RL().cachePath);
        com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteTalkerMsg by create new ftsIndexDB");
      }
      l = System.currentTimeMillis();
      locald1.execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE aux_index=? AND timestamp <= ?);", new Object[] { "FTS5IndexMessage", "FTS5MetaMessage" }), new String[] { paramString, String.valueOf(paramLong) });
      locald1.execSQL(String.format("DELETE FROM %s WHERE aux_index=? AND timestamp <= ?", new Object[] { "FTS5MetaMessage" }), new String[] { paramString, String.valueOf(paramLong) });
      l = System.currentTimeMillis() - l;
      ab.i("MicroMsg.FTS.FTSIndexDB", "deleteTalkerMsgByTimestamp use time %d talker %s timestamp %s", new Object[] { Long.valueOf(l), paramString, h.formatTime("yyyy-MM-dd HH:mm:ss", paramLong / 1000L) });
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(729L, 10L, 1L, false);
      if (l > 500L)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(79L, 11L, 1L, false);
        AppMethodBeat.o(136789);
        return;
      }
    }
    catch (Exception paramString)
    {
      com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", paramString, "syncDeleteTalkerMsg", new Object[0]);
      AppMethodBeat.o(136789);
      return;
    }
    if (l > 1000L)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(79L, 12L, 1L, false);
      AppMethodBeat.o(136789);
      return;
    }
    if (l > 10000L) {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(79L, 13L, 1L, false);
    }
    AppMethodBeat.o(136789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.f
 * JD-Core Version:    0.7.0.1
 */