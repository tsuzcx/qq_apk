package com.tencent.mm.plugin.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.ai.f.b;
import com.tencent.mm.plugin.ai.f.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public class PluginAi
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.b> kvw;
  private r.a kvx;
  
  static
  {
    AppMethodBeat.i(238855);
    HashMap localHashMap = new HashMap();
    kvw = localHashMap;
    localHashMap.put(Integer.valueOf("FINDERREDDOTHISTORY_TABLE".hashCode()), new PluginAi.1());
    kvw.put(Integer.valueOf("WechatAppHistory_TABLE".hashCode()), new PluginAi.2());
    AppMethodBeat.o(238855);
  }
  
  private void closeDB()
  {
    AppMethodBeat.i(238854);
    if (this.kvx != null) {
      this.kvx.uS(hashCode());
    }
    this.kvx = null;
    AppMethodBeat.o(238854);
  }
  
  private void initDB()
  {
    AppMethodBeat.i(238853);
    long l = Util.currentTicks();
    if (this.kvx != null) {
      closeDB();
    }
    Object localObject = com.tencent.mm.kernel.g.aAh().cachePath + "WxExptAi.db";
    this.kvx = r.a(hashCode(), (String)localObject, kvw, true);
    localObject = b.bqC();
    r.a locala = this.kvx;
    if (locala != null)
    {
      ((b)localObject).kxI = new d(locala);
      ((b)localObject).kxJ = new com.tencent.mm.plugin.ai.f.f(locala);
      ((b)localObject).kxK = new com.tencent.mm.plugin.ai.f.a();
    }
    Log.i("MicroMsg.PluginAi", "[%d] init DB finish cost[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(238853);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(238848);
    super.configure(paramg);
    if (paramg.aBb()) {
      y.b("aimodel", "aimodel", 7776000000L, 19);
    }
    AppMethodBeat.o(238848);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(238849);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.expt.a.class);
    }
    AppMethodBeat.o(238849);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(238850);
    Log.i("MicroMsg.PluginAi", "Plugin ai execute IAiService [%d]", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ai.a.a.class, com.tencent.mm.plugin.ai.e.a.bqx());
    AppMethodBeat.o(238850);
  }
  
  public void installed()
  {
    AppMethodBeat.i(238847);
    alias(a.class);
    AppMethodBeat.o(238847);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(238851);
    Log.i("MicroMsg.PluginAi", "Plugin ai onAccountInitialized [%d]", new Object[] { Integer.valueOf(hashCode()) });
    paramc = b.bqC();
    Log.i("MicroMsg.AiStorageLogic", "init  [%s] [%s]", new Object[] { com.tencent.mm.kernel.g.aAh().cachePath, com.tencent.mm.kernel.g.aAh().hqG });
    paramc.kxM = (com.tencent.mm.kernel.g.aAh().hqG + "aimodel/");
    paramc.kxN = (paramc.kxM + "aifinder/");
    b.l(new String[] { paramc.kxM, paramc.kxN });
    initDB();
    paramc = com.tencent.mm.plugin.ai.e.a.bqx();
    Log.i("MicroMsg.AiService", "AiService onAccountInitialized [%d]", new Object[] { Integer.valueOf(paramc.hashCode()) });
    com.tencent.mm.plugin.ai.b.a.a.c localc = com.tencent.mm.plugin.ai.b.a.a.c.bqt();
    Log.i("MicroMsg.AiFinderData", "register listener");
    EventCenter.instance.add(localc.kvR);
    EventCenter.instance.add(localc.kvS);
    EventCenter.instance.add(localc.kvT);
    EventCenter.instance.add(localc.kvU);
    EventCenter.instance.add(localc.kvQ);
    EventCenter.instance.add(paramc.kxm);
    EventCenter.instance.add(paramc.kxn);
    paramc = com.tencent.mm.plugin.ai.b.a.b.a.bqv();
    EventCenter.instance.add(paramc.kvR);
    EventCenter.instance.add(paramc.kvT);
    AppMethodBeat.o(238851);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(238852);
    Log.i("MicroMsg.PluginAi", "Plugin ai onAccountRelease [%d]", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = com.tencent.mm.plugin.ai.e.a.bqx();
    Log.i("MicroMsg.AiService", "AiService onAccountRelease [%d]", new Object[] { Integer.valueOf(localObject.hashCode()) });
    com.tencent.mm.plugin.ai.b.a.a.c localc = com.tencent.mm.plugin.ai.b.a.a.c.bqt();
    Log.i("MicroMsg.AiFinderData", "unregister listener");
    EventCenter.instance.removeListener(localc.kvR);
    EventCenter.instance.removeListener(localc.kvS);
    EventCenter.instance.removeListener(localc.kvT);
    EventCenter.instance.removeListener(localc.kvU);
    EventCenter.instance.removeListener(localc.kvQ);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.e.a)localObject).kxm);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.e.a)localObject).kxn);
    closeDB();
    localObject = com.tencent.mm.plugin.ai.b.a.b.a.bqv();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.b.a)localObject).kvR);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.ai.b.a.b.a)localObject).kvT);
    AppMethodBeat.o(238852);
  }
  
  public String toString()
  {
    return "plugin-ai";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.PluginAi
 * JD-Core Version:    0.7.0.1
 */