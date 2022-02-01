package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  implements au
{
  public final void A(String paramString, long paramLong)
  {
    AppMethodBeat.i(52765);
    Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete fts talker msg %s %s", new Object[] { paramString, com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", paramLong / 1000L) });
    if (!g.aAc())
    {
      paramString = new b();
      AppMethodBeat.o(52765);
      throw paramString;
    }
    try
    {
      d locald = ((PluginFTS)g.ah(PluginFTS.class)).getFTSIndexDB();
      if (locald != null)
      {
        locald.au(paramString, paramLong);
        AppMethodBeat.o(52765);
        return;
      }
      ((PluginFTS)g.ah(PluginFTS.class)).getFTSTaskDaemon().a(65536, new c(paramString, paramLong));
      Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteTalkerMsg post task to fts task daemon %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(52765);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", paramString, "syncDeleteTalkerMsg", new Object[0]);
      AppMethodBeat.o(52765);
    }
  }
  
  public final void Ab(long paramLong)
  {
    AppMethodBeat.i(52764);
    Object localObject;
    if (!g.aAc())
    {
      localObject = new b();
      AppMethodBeat.o(52764);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = ((PluginFTS)g.ah(PluginFTS.class)).getFTSIndexDB();
      if (localObject != null)
      {
        ((d)localObject).deleteMsgById(paramLong);
        AppMethodBeat.o(52764);
        return;
      }
      ((PluginFTS)g.ah(PluginFTS.class)).getFTSTaskDaemon().a(65536, new b(paramLong));
      Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteSingleMsg post task to fts task daemon %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(52764);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", localException, "syncDeleteSingleMsg", new Object[0]);
      AppMethodBeat.o(52764);
    }
  }
  
  public final void aVn()
  {
    AppMethodBeat.i(176905);
    Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete all msg");
    if (!g.aAc())
    {
      b localb = new b();
      AppMethodBeat.o(176905);
      throw localb;
    }
    ((PluginFTS)g.ah(PluginFTS.class)).getFTSTaskDaemon().a(-131072, new a((byte)0));
    Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteAllMsg post task to fts task daemon");
    AppMethodBeat.o(176905);
  }
  
  final class a
    extends a
  {
    private a() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(176904);
      d locald = ((PluginFTS)g.ah(PluginFTS.class)).getFTSIndexDB();
      if (locald != null)
      {
        long l = System.currentTimeMillis();
        locald.execSQL(String.format("Delete From %s;", new Object[] { "FTS5MetaMessage" }));
        locald.execSQL(String.format("Delete From %s;", new Object[] { "FTS5IndexMessage" }));
        Log.i("MicroMsg.FTS.FTSIndexDB", "deleteAllMsg use time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(176904);
      return true;
    }
    
    public final String getName()
    {
      return "FTSDeleteMsgLogic.DeleteAllMsgTask";
    }
  }
  
  final class b
    extends a
  {
    private long msgId;
    
    b(long paramLong)
    {
      this.msgId = paramLong;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52762);
      d locald = ((PluginFTS)g.ah(PluginFTS.class)).getFTSIndexDB();
      if (locald != null) {
        locald.deleteMsgById(this.msgId);
      }
      AppMethodBeat.o(52762);
      return true;
    }
    
    public final String getName()
    {
      return "FTSDeleteMsgLogic.DeleteSingleMsgTask";
    }
  }
  
  final class c
    extends a
  {
    private String talker;
    private long wZu;
    
    c(String paramString, long paramLong)
    {
      this.talker = paramString;
      this.wZu = paramLong;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52763);
      d locald = ((PluginFTS)g.ah(PluginFTS.class)).getFTSIndexDB();
      if (locald != null) {
        locald.au(this.talker, this.wZu);
      }
      AppMethodBeat.o(52763);
      return true;
    }
    
    public final String getName()
    {
      return "FTSDeleteMsgLogic.DeleteTalkerMsgByTimestamp";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.f
 * JD-Core Version:    0.7.0.1
 */