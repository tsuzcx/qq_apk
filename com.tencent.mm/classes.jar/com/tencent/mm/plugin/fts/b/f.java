package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  implements ao
{
  public final void aBz()
  {
    AppMethodBeat.i(176905);
    ad.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete all msg");
    if (!g.ajx())
    {
      b localb = new b();
      AppMethodBeat.o(176905);
      throw localb;
    }
    ((PluginFTS)g.ad(PluginFTS.class)).getFTSTaskDaemon().a(-131072, new a((byte)0));
    ad.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteAllMsg post task to fts task daemon");
    AppMethodBeat.o(176905);
  }
  
  public final void rH(long paramLong)
  {
    AppMethodBeat.i(52764);
    Object localObject;
    if (!g.ajx())
    {
      localObject = new b();
      AppMethodBeat.o(52764);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = ((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB();
      if (localObject != null)
      {
        ((d)localObject).deleteMsgById(paramLong);
        AppMethodBeat.o(52764);
        return;
      }
      ((PluginFTS)g.ad(PluginFTS.class)).getFTSTaskDaemon().a(65536, new b(paramLong));
      ad.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteSingleMsg post task to fts task daemon %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(52764);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", localException, "syncDeleteSingleMsg", new Object[0]);
      AppMethodBeat.o(52764);
    }
  }
  
  public final void z(String paramString, long paramLong)
  {
    AppMethodBeat.i(52765);
    ad.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete fts talker msg %s %s", new Object[] { paramString, i.formatTime("yyyy-MM-dd HH:mm:ss", paramLong / 1000L) });
    if (!g.ajx())
    {
      paramString = new b();
      AppMethodBeat.o(52765);
      throw paramString;
    }
    try
    {
      d locald = ((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB();
      if (locald != null)
      {
        locald.au(paramString, paramLong);
        AppMethodBeat.o(52765);
        return;
      }
      ((PluginFTS)g.ad(PluginFTS.class)).getFTSTaskDaemon().a(65536, new c(paramString, paramLong));
      ad.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteTalkerMsg post task to fts task daemon %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(52765);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", paramString, "syncDeleteTalkerMsg", new Object[0]);
      AppMethodBeat.o(52765);
    }
  }
  
  final class a
    extends a
  {
    private a() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(176904);
      d locald = ((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB();
      if (locald != null)
      {
        long l = System.currentTimeMillis();
        locald.execSQL(String.format("Delete From %s;", new Object[] { "FTS5MetaMessage" }));
        locald.execSQL(String.format("Delete From %s;", new Object[] { "FTS5IndexMessage" }));
        ad.i("MicroMsg.FTS.FTSIndexDB", "deleteAllMsg use time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      d locald = ((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB();
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
    private long txE;
    
    c(String paramString, long paramLong)
    {
      this.talker = paramString;
      this.txE = paramLong;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52763);
      d locald = ((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB();
      if (locald != null) {
        locald.au(this.talker, this.txE);
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