package com.tencent.mm.plugin.expt;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginExpt
  extends f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.b> ovv;
  private r.a ovx;
  
  static
  {
    AppMethodBeat.i(121796);
    HashMap localHashMap = new HashMap();
    ovv = localHashMap;
    localHashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.expt.i.d.SQL_CREATE;
      }
    });
    ovv.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.expt.i.b.SQL_CREATE;
      }
    });
    ovv.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new h.b()
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
    if (this.ovx != null) {
      this.ovx.qX(hashCode());
    }
    this.ovx = null;
    com.tencent.mm.plugin.expt.f.a locala = com.tencent.mm.plugin.expt.f.a.cqZ();
    locala.rao = null;
    locala.rap = null;
    AppMethodBeat.o(121795);
  }
  
  private int getUIN()
  {
    AppMethodBeat.i(184289);
    if (com.tencent.mm.kernel.g.ajx()) {
      com.tencent.mm.kernel.g.ajA();
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.aiN())
    {
      AppMethodBeat.o(184289);
      return i;
    }
  }
  
  private void initDB()
  {
    AppMethodBeat.i(121794);
    if (this.ovx != null) {
      closeDB();
    }
    String str = com.tencent.mm.kernel.g.ajC().cachePath + "WxExpt.db";
    this.ovx = com.tencent.mm.platformtools.r.a(hashCode(), str, ovv, true);
    AppMethodBeat.o(121794);
  }
  
  private void resetUIN()
  {
    AppMethodBeat.i(184291);
    if (aj.cmR())
    {
      long l = bt.HI();
      com.tencent.mm.plugin.expt.h.d.crP();
      ad.i("MicroMsg.PluginExpt", "reset uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(0), Boolean.valueOf(com.tencent.mm.plugin.expt.h.d.DB(0)), Long.valueOf(bt.aO(l)) });
    }
    AppMethodBeat.o(184291);
  }
  
  private void saveUINToMMKV()
  {
    AppMethodBeat.i(184290);
    long l;
    int i;
    if (aj.cmR())
    {
      l = bt.HI();
      i = getUIN();
      if (i == 0) {
        break label76;
      }
      com.tencent.mm.plugin.expt.h.d.crP();
    }
    label76:
    for (boolean bool = com.tencent.mm.plugin.expt.h.d.DB(i);; bool = false)
    {
      ad.i("MicroMsg.PluginExpt", "save uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(184290);
      return;
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(121790);
    if (aj.cmR()) {
      dependsOn(com.tencent.mm.plugin.messenger.foundation.a.r.class);
    }
    AppMethodBeat.o(121790);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    int i = 0;
    AppMethodBeat.i(121791);
    saveUINToMMKV();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.b.class, com.tencent.mm.plugin.expt.f.a.cqZ());
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.crq());
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.e.class, com.tencent.mm.plugin.expt.g.d.crl());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.c.class, com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.a.class, com.tencent.mm.plugin.expt.e.a.cqU());
    if (paramg.ca != null)
    {
      com.tencent.mm.plugin.expt.i.c.crR();
      if (bt.getInt(com.tencent.mm.plugin.expt.i.c.b(b.a.quK, ""), 0) > 0) {
        i = 1;
      }
      if (i != 0) {
        paramg.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.g.d.crl());
      }
      paramg.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.e.a.cqU());
    }
    com.tencent.mm.plugin.expt.hellhound.b.d(paramg);
    com.tencent.mm.plugin.expt.d.a.cng();
    if (paramg.akw()) {
      pin(com.tencent.mm.plugin.expt.d.b.b.cnj());
    }
    AppMethodBeat.o(121791);
  }
  
  public void installed()
  {
    AppMethodBeat.i(121789);
    alias(a.class);
    AppMethodBeat.o(121789);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    boolean bool = false;
    AppMethodBeat.i(121792);
    ad.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.f.a.cqZ().hashCode()) });
    saveUINToMMKV();
    initDB();
    paramc = com.tencent.mm.plugin.expt.f.a.cqZ();
    Object localObject = this.ovx;
    int i = paramc.hashCode();
    if (localObject != null) {
      bool = true;
    }
    ad.i("MicroMsg.ExptService", "reset DB [%d] dataDB[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (localObject != null)
    {
      paramc.rao = new com.tencent.mm.plugin.expt.i.d((com.tencent.mm.sdk.e.e)localObject);
      paramc.rap = new com.tencent.mm.plugin.expt.i.b((com.tencent.mm.sdk.e.e)localObject);
    }
    com.tencent.mm.plugin.expt.roomexpt.a.crq().raZ = new com.tencent.mm.plugin.expt.roomexpt.b(this.ovx);
    paramc = com.tencent.mm.plugin.expt.d.a.cng();
    if (paramc.qPp == null) {
      paramc.qPp = new com.tencent.mm.plugin.expt.d.i.b();
    }
    localObject = paramc.qPp;
    if (((com.tencent.mm.plugin.expt.d.i.b)localObject).qQu != null)
    {
      ((com.tencent.mm.plugin.expt.d.i.b)localObject).qQu.qX(localObject.hashCode());
      ((com.tencent.mm.plugin.expt.d.i.b)localObject).qQu = null;
    }
    paramc = com.tencent.mm.kernel.g.ajC().cachePath + "Edge.db";
    try
    {
      paramc = com.tencent.mm.platformtools.r.a(localObject.hashCode(), paramc, new HashMap(), true);
      if (paramc != null) {
        ((com.tencent.mm.plugin.expt.d.i.b)localObject).qQu = paramc;
      }
      AppMethodBeat.o(121792);
      return;
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ad.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] resetDB createDBInstance throw Exception : " + paramc.getMessage());
        paramc = null;
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(121793);
    ad.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.f.a.cqZ().hashCode()) });
    resetUIN();
    closeDB();
    AppMethodBeat.o(121793);
  }
  
  public String toString()
  {
    return "plugin-expt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.PluginExpt
 * JD-Core Version:    0.7.0.1
 */