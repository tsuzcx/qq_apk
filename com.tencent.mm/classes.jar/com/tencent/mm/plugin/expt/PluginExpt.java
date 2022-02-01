package com.tencent.mm.plugin.expt;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.o;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginExpt
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.b> qkO;
  private o.a qkP;
  
  static
  {
    AppMethodBeat.i(121796);
    HashMap localHashMap = new HashMap();
    qkO = localHashMap;
    localHashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new PluginExpt.1());
    qkO.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new PluginExpt.2());
    qkO.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.expt.roomexpt.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(121796);
  }
  
  private void closeDB()
  {
    AppMethodBeat.i(121795);
    if (this.qkP != null) {
      this.qkP.yb(hashCode());
    }
    this.qkP = null;
    com.tencent.mm.plugin.expt.model.a locala = com.tencent.mm.plugin.expt.model.a.dMQ();
    locala.zLY = null;
    locala.zLZ = null;
    AppMethodBeat.o(121795);
  }
  
  private int getUIN()
  {
    AppMethodBeat.i(184289);
    if (h.baz()) {
      h.baC();
    }
    for (int i = com.tencent.mm.kernel.b.getUin();; i = com.tencent.mm.kernel.b.aZP())
    {
      AppMethodBeat.o(184289);
      return i;
    }
  }
  
  private void initDB()
  {
    AppMethodBeat.i(121794);
    if (this.qkP != null) {
      closeDB();
    }
    String str = h.baE().cachePath + "WxExpt.db";
    this.qkP = o.a(hashCode(), str, qkO, true);
    AppMethodBeat.o(121794);
  }
  
  private void resetUIN()
  {
    AppMethodBeat.i(184291);
    if (MMApplicationContext.isMainProcess())
    {
      long l = Util.currentTicks();
      com.tencent.mm.plugin.expt.e.d.dNI();
      Log.i("MicroMsg.PluginExpt", "reset uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(0), Boolean.valueOf(com.tencent.mm.plugin.expt.e.d.Mi(0)), Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(184291);
  }
  
  private void saveUINToMMKV()
  {
    AppMethodBeat.i(184290);
    long l;
    int i;
    if (MMApplicationContext.isMainProcess())
    {
      l = Util.currentTicks();
      i = getUIN();
      if (i == 0) {
        break label76;
      }
      com.tencent.mm.plugin.expt.e.d.dNI();
    }
    label76:
    for (boolean bool = com.tencent.mm.plugin.expt.e.d.Mi(i);; bool = false)
    {
      Log.i("MicroMsg.PluginExpt", "save uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(184290);
      return;
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(121790);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(v.class);
    }
    AppMethodBeat.o(121790);
  }
  
  public void execute(g paramg)
  {
    int i = 0;
    AppMethodBeat.i(121791);
    saveUINToMMKV();
    h.b(com.tencent.mm.plugin.expt.b.c.class, com.tencent.mm.plugin.expt.model.a.dMQ());
    if (paramg.bbA()) {
      h.b(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.dNf());
    }
    h.b(com.tencent.mm.plugin.expt.b.f.class, com.tencent.mm.plugin.expt.pageflow.d.dNa());
    h.b(com.tencent.mm.plugin.expt.b.d.class, com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD());
    h.b(com.tencent.mm.plugin.expt.b.a.class, com.tencent.mm.plugin.expt.edge.a.dHT());
    h.b(com.tencent.mm.plugin.expt.b.b.class, com.tencent.mm.plugin.expt.kvdebug.a.dMK());
    if (paramg.bGP != null)
    {
      com.tencent.mm.plugin.expt.f.c.dNK();
      if (Util.getInt(com.tencent.mm.plugin.expt.f.c.c(c.a.yOL, ""), 0) > 0) {
        i = 1;
      }
      if (i != 0) {
        paramg.bGP.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.pageflow.d.dNa());
      }
      paramg.bGP.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.kvdebug.a.dMK());
    }
    com.tencent.mm.plugin.expt.hellhound.b.g(paramg);
    com.tencent.mm.plugin.expt.edge.a.dHT();
    if (paramg.bbA()) {
      pin(com.tencent.mm.plugin.expt.edge.config.b.dIg());
    }
    AppMethodBeat.o(121791);
  }
  
  public void installed()
  {
    AppMethodBeat.i(121789);
    alias(a.class);
    AppMethodBeat.o(121789);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    boolean bool = false;
    AppMethodBeat.i(121792);
    Log.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.model.a.dMQ().hashCode()) });
    saveUINToMMKV();
    initDB();
    paramc = com.tencent.mm.plugin.expt.model.a.dMQ();
    Object localObject = this.qkP;
    int i = paramc.hashCode();
    if (localObject != null) {
      bool = true;
    }
    Log.i("MicroMsg.ExptService", "reset DB [%d] dataDB[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (localObject != null)
    {
      paramc.zLY = new com.tencent.mm.plugin.expt.f.d((ISQLiteDatabase)localObject);
      paramc.zLZ = new com.tencent.mm.plugin.expt.f.b((ISQLiteDatabase)localObject);
    }
    com.tencent.mm.plugin.expt.roomexpt.a.dNf().zMG = new com.tencent.mm.plugin.expt.roomexpt.b(this.qkP);
    localObject = com.tencent.mm.plugin.expt.edge.a.dHT();
    ((com.tencent.mm.plugin.expt.edge.a)localObject).zyc = new com.tencent.mm.plugin.expt.edge.g.a();
    ((com.tencent.mm.plugin.expt.edge.a)localObject).zyd = new com.tencent.mm.plugin.expt.edge.config.a.a();
    ((com.tencent.mm.plugin.expt.edge.a)localObject).zye = new com.tencent.mm.plugin.expt.edge.config.b.a();
    ((com.tencent.mm.plugin.expt.edge.a)localObject).zyf = new com.tencent.mm.plugin.expt.edge.config.c.a();
    com.tencent.mm.plugin.expt.edge.i.b localb = ((com.tencent.mm.plugin.expt.edge.a)localObject).zyb;
    if (localb.zys != null) {
      localb.zys.yb(localb.hashCode());
    }
    localb.zys = null;
    paramc = h.baE().cachePath + "Edge.db";
    try
    {
      paramc = o.a(localb.hashCode(), paramc, new HashMap(), true);
      if (paramc != null) {
        localb.zys = paramc;
      }
      ((com.tencent.mm.plugin.expt.edge.a)localObject).zxZ.reset();
      ((com.tencent.mm.plugin.expt.edge.a)localObject).zya.reset();
      if (com.tencent.mm.plugin.expt.edge.b.dHV())
      {
        ((com.tencent.mm.plugin.expt.edge.a)localObject).zyg.removeMessages(1003);
        ((com.tencent.mm.plugin.expt.edge.a)localObject).zyg.sendEmptyMessageDelayed(1003, 5000L);
      }
      ((com.tencent.mm.plugin.expt.edge.a)localObject).xhE.alive();
      com.tencent.mm.plugin.expt.trigger.a.dNO().lsH.alive();
      AppMethodBeat.o(121792);
      return;
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] resetDB createDBInstance throw Exception : " + paramc.getMessage());
        paramc = null;
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(121793);
    Log.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.model.a.dMQ().hashCode()) });
    com.tencent.mm.plugin.expt.edge.a locala = com.tencent.mm.plugin.expt.edge.a.dHT();
    com.tencent.mm.plugin.expt.edge.i.b localb = locala.zyb;
    if (localb.zys != null) {
      localb.zys.yb(localb.hashCode());
    }
    localb.zys = null;
    locala.zxZ.close();
    locala.zya.close();
    locala.xhE.dead();
    resetUIN();
    closeDB();
    com.tencent.mm.plugin.expt.trigger.a.dNO().lsH.dead();
    AppMethodBeat.o(121793);
  }
  
  public String toString()
  {
    return "plugin-expt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.PluginExpt
 * JD-Core Version:    0.7.0.1
 */