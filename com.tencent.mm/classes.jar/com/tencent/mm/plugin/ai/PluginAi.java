package com.tencent.mm.plugin.ai;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.o;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.ai.d.i;
import com.tencent.mm.plugin.ai.d.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.af;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class PluginAi
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.b> qkO;
  private o.a qkP;
  
  static
  {
    AppMethodBeat.i(267394);
    HashMap localHashMap = new HashMap();
    qkO = localHashMap;
    localHashMap.put(Integer.valueOf("FINDERREDDOTHISTORY_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ai.d.g.SQL_CREATE;
      }
    });
    qkO.put(Integer.valueOf("WechatAppHistory_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return i.SQL_CREATE;
      }
    });
    qkO.put(Integer.valueOf("WechatSessionHistory_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return k.SQL_CREATE;
      }
    });
    qkO.put(Integer.valueOf("AiFinderRedDotInfo_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ai.d.c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(267394);
  }
  
  private void closeDB()
  {
    AppMethodBeat.i(267389);
    if (this.qkP != null) {
      this.qkP.yb(hashCode());
    }
    this.qkP = null;
    AppMethodBeat.o(267389);
  }
  
  private void initDB()
  {
    AppMethodBeat.i(267380);
    long l = Util.currentTicks();
    if (this.qkP != null) {
      closeDB();
    }
    Object localObject = h.baE().cachePath + "WxExptAi.db";
    this.qkP = o.a(hashCode(), (String)localObject, qkO, true);
    localObject = com.tencent.mm.plugin.ai.d.e.caH();
    o.a locala = this.qkP;
    if (locala != null)
    {
      ((com.tencent.mm.plugin.ai.d.e)localObject).qpp = new com.tencent.mm.plugin.ai.d.g(locala);
      ((com.tencent.mm.plugin.ai.d.e)localObject).qpq = new i(locala);
      ((com.tencent.mm.plugin.ai.d.e)localObject).qpr = new k(locala);
      ((com.tencent.mm.plugin.ai.d.e)localObject).qps = new com.tencent.mm.plugin.ai.d.c(locala);
      ((com.tencent.mm.plugin.ai.d.e)localObject).qpt = new com.tencent.mm.plugin.ai.d.d();
    }
    Log.i("MicroMsg.PluginAi", "[%d] init DB finish cost[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(267380);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(267405);
    super.configure(paramg);
    if (paramg.bbA()) {
      af.a("aimodel", "aimodel", 7776000000L, 17);
    }
    AppMethodBeat.o(267405);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(267412);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.expt.a.class);
    }
    AppMethodBeat.o(267412);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(267417);
    Log.i("MicroMsg.PluginAi", "Plugin ai execute IAiService [%d]", new Object[] { Integer.valueOf(hashCode()) });
    h.b(com.tencent.mm.plugin.ai.a.a.class, com.tencent.mm.plugin.ai.service.a.caz());
    paramg = com.tencent.mm.plugin.ai.data.business.global.e.can();
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess())) {
      ((Application)MMApplicationContext.getContext().getApplicationContext()).registerActivityLifecycleCallbacks(paramg);
    }
    AppMethodBeat.o(267417);
  }
  
  public void installed()
  {
    AppMethodBeat.i(267400);
    alias(a.class);
    AppMethodBeat.o(267400);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(267430);
    Log.i("MicroMsg.PluginAi", "Plugin ai onAccountInitialized [%d]", new Object[] { Integer.valueOf(hashCode()) });
    paramc = com.tencent.mm.plugin.ai.d.e.caH();
    Log.i("MicroMsg.AiStorageLogic", "init  [%s] [%s]", new Object[] { h.baE().cachePath, h.baE().mCJ });
    paramc.qpv = (h.baE().mCJ + "aimodel/");
    paramc.qpw = (paramc.qpv + "aifinder/");
    com.tencent.mm.plugin.ai.d.e.k(new String[] { paramc.qpv, paramc.qpw });
    initDB();
    Log.i("MicroMsg.AiService", "AiService onAccountInitialized [%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ai.service.a.caz().hashCode()) });
    paramc = com.tencent.mm.plugin.ai.data.business.finder.c.bZK();
    Log.i("MicroMsg.AiFinderData", "register listener");
    paramc.qli.alive();
    paramc.qlj.alive();
    paramc.qlh.alive();
    paramc = com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
    paramc.qma.alive();
    paramc.qlY.alive();
    paramc.qli.alive();
    paramc.qmb.alive();
    paramc.bZN();
    com.tencent.mm.plugin.ai.data.business.trigger.g.cat().aoW();
    paramc = com.tencent.mm.plugin.ai.data.business.global.d.cam();
    paramc.qli.alive();
    paramc.qmv.alive();
    paramc = com.tencent.mm.plugin.ai.data.business.global.c.caj();
    paramc.qma.alive();
    paramc.qlj.alive();
    paramc = com.tencent.mm.plugin.ai.data.business.global.f.cao();
    paramc.qmH.alive();
    paramc.qmv.alive();
    paramc.qmJ.alive();
    AppMethodBeat.o(267430);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(267438);
    Log.i("MicroMsg.PluginAi", "Plugin ai onAccountRelease [%d]", new Object[] { Integer.valueOf(hashCode()) });
    Log.i("MicroMsg.AiService", "AiService onAccountRelease [%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ai.service.a.caz().hashCode()) });
    Object localObject = com.tencent.mm.plugin.ai.data.business.finder.c.bZK();
    Log.i("MicroMsg.AiFinderData", "unregister listener");
    ((com.tencent.mm.plugin.ai.data.business.finder.c)localObject).qli.dead();
    ((com.tencent.mm.plugin.ai.data.business.finder.c)localObject).qlj.dead();
    ((com.tencent.mm.plugin.ai.data.business.finder.c)localObject).qlh.dead();
    localObject = com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
    ((com.tencent.mm.plugin.ai.data.business.finder.e)localObject).qma.dead();
    ((com.tencent.mm.plugin.ai.data.business.finder.e)localObject).qlY.dead();
    ((com.tencent.mm.plugin.ai.data.business.finder.e)localObject).qli.dead();
    ((com.tencent.mm.plugin.ai.data.business.finder.e)localObject).qmb.dead();
    ((com.tencent.mm.plugin.ai.data.business.finder.e)localObject).qlZ.removeCallbacksAndMessages(null);
    closeDB();
    localObject = com.tencent.mm.plugin.ai.data.business.trigger.g.cat().qnx.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.ai.data.business.trigger.c)((Iterator)localObject).next()).unRegister();
    }
    localObject = com.tencent.mm.plugin.ai.data.business.global.d.cam();
    ((com.tencent.mm.plugin.ai.data.business.global.d)localObject).qli.dead();
    ((com.tencent.mm.plugin.ai.data.business.global.d)localObject).qmv.dead();
    localObject = com.tencent.mm.plugin.ai.data.business.global.c.caj();
    ((com.tencent.mm.plugin.ai.data.business.global.c)localObject).qma.dead();
    ((com.tencent.mm.plugin.ai.data.business.global.c)localObject).qlj.dead();
    localObject = com.tencent.mm.plugin.ai.data.business.global.f.cao();
    ((com.tencent.mm.plugin.ai.data.business.global.f)localObject).qmH.dead();
    ((com.tencent.mm.plugin.ai.data.business.global.f)localObject).qmv.dead();
    ((com.tencent.mm.plugin.ai.data.business.global.f)localObject).qmJ.dead();
    AppMethodBeat.o(267438);
  }
  
  public String toString()
  {
    return "plugin-ai";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.PluginAi
 * JD-Core Version:    0.7.0.1
 */