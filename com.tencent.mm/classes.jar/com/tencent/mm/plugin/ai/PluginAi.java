package com.tencent.mm.plugin.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.ai.b.a.a.e;
import com.tencent.mm.plugin.ai.f.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class PluginAi
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.b> nnH;
  private r.a nnI;
  
  static
  {
    AppMethodBeat.i(240238);
    HashMap localHashMap = new HashMap();
    nnH = localHashMap;
    localHashMap.put(Integer.valueOf("FINDERREDDOTHISTORY_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    nnH.put(Integer.valueOf("WechatAppHistory_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ai.f.f.SQL_CREATE;
      }
    });
    nnH.put(Integer.valueOf("WechatSessionHistory_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ai.f.h.SQL_CREATE;
      }
    });
    AppMethodBeat.o(240238);
  }
  
  private void closeDB()
  {
    AppMethodBeat.i(240234);
    if (this.nnI != null) {
      this.nnI.xW(hashCode());
    }
    this.nnI = null;
    AppMethodBeat.o(240234);
  }
  
  private void initDB()
  {
    AppMethodBeat.i(240230);
    long l = Util.currentTicks();
    if (this.nnI != null) {
      closeDB();
    }
    Object localObject = com.tencent.mm.kernel.h.aHG().cachePath + "WxExptAi.db";
    this.nnI = r.a(hashCode(), (String)localObject, nnH, true);
    localObject = com.tencent.mm.plugin.ai.f.b.bBr();
    r.a locala = this.nnI;
    if (locala != null)
    {
      ((com.tencent.mm.plugin.ai.f.b)localObject).nqG = new d(locala);
      ((com.tencent.mm.plugin.ai.f.b)localObject).nqH = new com.tencent.mm.plugin.ai.f.f(locala);
      ((com.tencent.mm.plugin.ai.f.b)localObject).nqI = new com.tencent.mm.plugin.ai.f.h(locala, 7);
      ((com.tencent.mm.plugin.ai.f.b)localObject).nqJ = new com.tencent.mm.plugin.ai.f.a();
    }
    Log.i("MicroMsg.PluginAi", "[%d] init DB finish cost[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(240230);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(240213);
    super.configure(paramg);
    if (paramg.aIE()) {
      ab.a("aimodel", "aimodel", 7776000000L, 17);
    }
    AppMethodBeat.o(240213);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(240216);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.expt.a.class);
    }
    AppMethodBeat.o(240216);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(240218);
    Log.i("MicroMsg.PluginAi", "Plugin ai execute IAiService [%d]", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.ai.a.a.class, com.tencent.mm.plugin.ai.e.a.bBi());
    AppMethodBeat.o(240218);
  }
  
  public void installed()
  {
    AppMethodBeat.i(240212);
    alias(a.class);
    AppMethodBeat.o(240212);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(240223);
    Log.i("MicroMsg.PluginAi", "Plugin ai onAccountInitialized [%d]", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject1 = com.tencent.mm.plugin.ai.f.b.bBr();
    Log.i("MicroMsg.AiStorageLogic", "init  [%s] [%s]", new Object[] { com.tencent.mm.kernel.h.aHG().cachePath, com.tencent.mm.kernel.h.aHG().kcB });
    ((com.tencent.mm.plugin.ai.f.b)localObject1).nqL = (com.tencent.mm.kernel.h.aHG().kcB + "aimodel/");
    ((com.tencent.mm.plugin.ai.f.b)localObject1).nqM = (((com.tencent.mm.plugin.ai.f.b)localObject1).nqL + "aifinder/");
    com.tencent.mm.plugin.ai.f.b.k(new String[] { ((com.tencent.mm.plugin.ai.f.b)localObject1).nqL, ((com.tencent.mm.plugin.ai.f.b)localObject1).nqM });
    initDB();
    localObject1 = com.tencent.mm.plugin.ai.e.a.bBi();
    Log.i("MicroMsg.AiService", "AiService onAccountInitialized [%d]", new Object[] { Integer.valueOf(localObject1.hashCode()) });
    Object localObject2 = com.tencent.mm.plugin.ai.b.a.a.c.bAX();
    Log.i("MicroMsg.AiFinderData", "register listener");
    EventCenter.instance.add(((com.tencent.mm.plugin.ai.b.a.a.c)localObject2).nob);
    EventCenter.instance.add(((com.tencent.mm.plugin.ai.b.a.a.c)localObject2).noc);
    EventCenter.instance.add(((com.tencent.mm.plugin.ai.b.a.a.c)localObject2).noa);
    localObject2 = e.bAZ();
    EventCenter.instance.add(((e)localObject2).noK);
    EventCenter.instance.add(((com.tencent.mm.plugin.ai.e.a)localObject1).nqf);
    if ((paramc != null) && (paramc.kcX))
    {
      int i = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond());
      com.tencent.mm.plugin.ai.f.b.bBr().nqJ.bcJ().putInt("patch_upgrade_time", i);
    }
    com.tencent.mm.plugin.ai.b.a.c.f.bBf().OO();
    paramc = com.tencent.mm.plugin.ai.b.a.b.b.bBb();
    EventCenter.instance.add(paramc.nob);
    EventCenter.instance.add(paramc.noW);
    paramc = com.tencent.mm.plugin.ai.b.a.b.a.bBa();
    EventCenter.instance.add(paramc.noK);
    EventCenter.instance.add(paramc.noc);
    paramc = com.tencent.mm.plugin.ai.b.a.b.c.bBc();
    EventCenter.instance.add(paramc.npe);
    EventCenter.instance.add(paramc.noW);
    AppMethodBeat.o(240223);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(240227);
    Log.i("MicroMsg.PluginAi", "Plugin ai onAccountRelease [%d]", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject1 = com.tencent.mm.plugin.ai.e.a.bBi();
    Log.i("MicroMsg.AiService", "AiService onAccountRelease [%d]", new Object[] { Integer.valueOf(localObject1.hashCode()) });
    Object localObject2 = com.tencent.mm.plugin.ai.b.a.a.c.bAX();
    Log.i("MicroMsg.AiFinderData", "unregister listener");
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.a.c)localObject2).nob);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.a.c)localObject2).noc);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.a.c)localObject2).noa);
    localObject2 = e.bAZ();
    EventCenter.instance.removeListener(((e)localObject2).noK);
    ((e)localObject2).noJ.stopTimer();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.e.a)localObject1).nqf);
    closeDB();
    localObject1 = com.tencent.mm.plugin.ai.b.a.c.f.bBf().npy.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.ai.b.a.c.c)((Iterator)localObject1).next()).unRegister();
    }
    localObject1 = com.tencent.mm.plugin.ai.b.a.b.b.bBb();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.b.b)localObject1).nob);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.b.b)localObject1).noW);
    localObject1 = com.tencent.mm.plugin.ai.b.a.b.a.bBa();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.b.a)localObject1).noK);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.b.a)localObject1).noc);
    localObject1 = com.tencent.mm.plugin.ai.b.a.b.c.bBc();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.b.c)localObject1).npe);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.b.c)localObject1).noW);
    AppMethodBeat.o(240227);
  }
  
  public String toString()
  {
    return "plugin-ai";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.PluginAi
 * JD-Core Version:    0.7.0.1
 */