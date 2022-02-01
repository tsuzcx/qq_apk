package com.tencent.mm.plugin.fts.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  implements aw
{
  public final void B(String paramString, long paramLong)
  {
    AppMethodBeat.i(52765);
    Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete fts talker msg %s %s", new Object[] { paramString, f.formatTime("yyyy-MM-dd HH:mm:ss", paramLong / 1000L) });
    if (!com.tencent.mm.kernel.h.baz())
    {
      paramString = new b();
      AppMethodBeat.o(52765);
      throw paramString;
    }
    try
    {
      d locald = ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSIndexDB();
      if (locald != null)
      {
        locald.aF(paramString, paramLong);
        AppMethodBeat.o(52765);
        return;
      }
      ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSTaskDaemon().a(65536, new c(paramString, paramLong));
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
  
  public final void bCj()
  {
    AppMethodBeat.i(176905);
    Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete all msg");
    if (!com.tencent.mm.kernel.h.baz())
    {
      b localb = new b();
      AppMethodBeat.o(176905);
      throw localb;
    }
    ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSTaskDaemon().a(-131072, new a((byte)0));
    Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteAllMsg post task to fts task daemon");
    AppMethodBeat.o(176905);
  }
  
  public final void is(long paramLong)
  {
    AppMethodBeat.i(52764);
    Object localObject;
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new b();
      AppMethodBeat.o(52764);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSIndexDB();
      if (localObject != null)
      {
        ((d)localObject).deleteMsgById(paramLong);
        AppMethodBeat.o(52764);
        return;
      }
      ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSTaskDaemon().a(65536, new b(paramLong));
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
  
  final class a
    extends c
  {
    private a() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(176904);
      d locald = ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSIndexDB();
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
    extends c
  {
    private long msgId;
    
    b(long paramLong)
    {
      this.msgId = paramLong;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52762);
      d locald = ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSIndexDB();
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
    extends c
  {
    private long Hwp;
    private String talker;
    
    c(String paramString, long paramLong)
    {
      this.talker = paramString;
      this.Hwp = paramLong;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52763);
      d locald = ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSIndexDB();
      if (locald != null) {
        locald.aF(this.talker, this.Hwp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.h
 * JD-Core Version:    0.7.0.1
 */