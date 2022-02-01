package com.tencent.mm.plugin.expt;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.EventCenter;
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
  private static HashMap<Integer, h.b> nnH;
  private r.a nnI;
  
  static
  {
    AppMethodBeat.i(121796);
    HashMap localHashMap = new HashMap();
    nnH = localHashMap;
    localHashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new PluginExpt.1());
    nnH.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new PluginExpt.2());
    nnH.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new h.b()
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
    if (this.nnI != null) {
      this.nnI.xW(hashCode());
    }
    this.nnI = null;
    com.tencent.mm.plugin.expt.f.a locala = com.tencent.mm.plugin.expt.f.a.dgf();
    locala.wpV = null;
    locala.wpW = null;
    AppMethodBeat.o(121795);
  }
  
  private int getUIN()
  {
    AppMethodBeat.i(184289);
    if (h.aHB()) {
      h.aHE();
    }
    for (int i = com.tencent.mm.kernel.b.getUin();; i = com.tencent.mm.kernel.b.aGP())
    {
      AppMethodBeat.o(184289);
      return i;
    }
  }
  
  private void initDB()
  {
    AppMethodBeat.i(121794);
    if (this.nnI != null) {
      closeDB();
    }
    String str = h.aHG().cachePath + "WxExpt.db";
    this.nnI = r.a(hashCode(), str, nnH, true);
    AppMethodBeat.o(121794);
  }
  
  private void resetUIN()
  {
    AppMethodBeat.i(184291);
    if (MMApplicationContext.isMainProcess())
    {
      long l = Util.currentTicks();
      com.tencent.mm.plugin.expt.h.d.dgX();
      Log.i("MicroMsg.PluginExpt", "reset uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(0), Boolean.valueOf(com.tencent.mm.plugin.expt.h.d.Ll(0)), Long.valueOf(Util.ticksToNow(l)) });
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
      com.tencent.mm.plugin.expt.h.d.dgX();
    }
    label76:
    for (boolean bool = com.tencent.mm.plugin.expt.h.d.Ll(i);; bool = false)
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
    h.b(com.tencent.mm.plugin.expt.b.b.class, com.tencent.mm.plugin.expt.f.a.dgf());
    if (paramg.aIE()) {
      h.b(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.dgu());
    }
    h.b(e.class, com.tencent.mm.plugin.expt.g.d.dgp());
    h.b(com.tencent.mm.plugin.expt.b.c.class, com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO());
    h.b(com.tencent.mm.plugin.expt.b.a.class, com.tencent.mm.plugin.expt.e.a.dga());
    if (paramg.Zw != null)
    {
      com.tencent.mm.plugin.expt.i.c.dgZ();
      if (Util.getInt(com.tencent.mm.plugin.expt.i.c.c(b.a.vAX, ""), 0) > 0) {
        i = 1;
      }
      if (i != 0) {
        paramg.Zw.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.g.d.dgp());
      }
      paramg.Zw.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.e.a.dga());
    }
    com.tencent.mm.plugin.expt.hellhound.b.f(paramg);
    com.tencent.mm.plugin.expt.d.a.dbw();
    if (paramg.aIE()) {
      pin(com.tencent.mm.plugin.expt.d.c.b.dbG());
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
    Log.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.f.a.dgf().hashCode()) });
    saveUINToMMKV();
    initDB();
    paramc = com.tencent.mm.plugin.expt.f.a.dgf();
    Object localObject = this.nnI;
    int i = paramc.hashCode();
    if (localObject != null) {
      bool = true;
    }
    Log.i("MicroMsg.ExptService", "reset DB [%d] dataDB[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (localObject != null)
    {
      paramc.wpV = new com.tencent.mm.plugin.expt.i.d((ISQLiteDatabase)localObject);
      paramc.wpW = new com.tencent.mm.plugin.expt.i.b((ISQLiteDatabase)localObject);
    }
    com.tencent.mm.plugin.expt.roomexpt.a.dgu().wqE = new com.tencent.mm.plugin.expt.roomexpt.b(this.nnI);
    localObject = com.tencent.mm.plugin.expt.d.a.dbw();
    ((com.tencent.mm.plugin.expt.d.a)localObject).wde = new com.tencent.mm.plugin.expt.d.c.a.a();
    ((com.tencent.mm.plugin.expt.d.a)localObject).wdf = new com.tencent.mm.plugin.expt.d.c.b.a();
    com.tencent.mm.plugin.expt.d.j.b localb = ((com.tencent.mm.plugin.expt.d.a)localObject).wdb;
    if (localb.wex != null) {
      localb.wex.xW(localb.hashCode());
    }
    localb.wex = null;
    paramc = h.aHG().cachePath + "Edge.db";
    try
    {
      paramc = r.a(localb.hashCode(), paramc, new HashMap(), true);
      if (paramc != null) {
        localb.wex = paramc;
      }
      if (com.tencent.mm.plugin.expt.d.b.dby())
      {
        ((com.tencent.mm.plugin.expt.d.a)localObject).wdg.removeMessages(1003);
        ((com.tencent.mm.plugin.expt.d.a)localObject).wdg.sendEmptyMessageDelayed(1003, 5000L);
      }
      paramc = com.tencent.mm.plugin.expt.j.a.dhd();
      EventCenter.instance.add(paramc.iQL);
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
    Log.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.f.a.dgf().hashCode()) });
    Object localObject = com.tencent.mm.plugin.expt.d.a.dbw().wdb;
    if (((com.tencent.mm.plugin.expt.d.j.b)localObject).wex != null) {
      ((com.tencent.mm.plugin.expt.d.j.b)localObject).wex.xW(localObject.hashCode());
    }
    ((com.tencent.mm.plugin.expt.d.j.b)localObject).wex = null;
    resetUIN();
    closeDB();
    localObject = com.tencent.mm.plugin.expt.j.a.dhd();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.expt.j.a)localObject).iQL);
    AppMethodBeat.o(121793);
  }
  
  public String toString()
  {
    return "plugin-expt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.PluginExpt
 * JD-Core Version:    0.7.0.1
 */