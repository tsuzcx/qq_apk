package com.tencent.mm.plugin.expt;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginExpt
  extends f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.b> npa;
  private r.a npc;
  
  static
  {
    AppMethodBeat.i(121796);
    HashMap localHashMap = new HashMap();
    npa = localHashMap;
    localHashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.expt.f.d.SQL_CREATE;
      }
    });
    npa.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new PluginExpt.2());
    npa.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new h.b()
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
    if (this.npc != null) {
      this.npc.pK(hashCode());
    }
    this.npc = null;
    com.tencent.mm.plugin.expt.c.a locala = com.tencent.mm.plugin.expt.c.a.cdX();
    locala.pIn = null;
    locala.pIo = null;
    AppMethodBeat.o(121795);
  }
  
  private int getUIN()
  {
    AppMethodBeat.i(184289);
    if (com.tencent.mm.kernel.g.afw()) {
      com.tencent.mm.kernel.g.afz();
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.aeL())
    {
      AppMethodBeat.o(184289);
      return i;
    }
  }
  
  private void initDB()
  {
    AppMethodBeat.i(121794);
    if (this.npc != null) {
      closeDB();
    }
    String str = com.tencent.mm.kernel.g.afB().cachePath + "WxExpt.db";
    this.npc = r.a(hashCode(), str, npa, true);
    AppMethodBeat.o(121794);
  }
  
  private void resetUIN()
  {
    AppMethodBeat.i(184291);
    if (aj.cbe())
    {
      long l = bt.GC();
      com.tencent.mm.plugin.expt.e.b.ceD();
      ad.i("MicroMsg.PluginExpt", "reset uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(0), Boolean.valueOf(com.tencent.mm.plugin.expt.e.b.BO(0)), Long.valueOf(bt.aS(l)) });
    }
    AppMethodBeat.o(184291);
  }
  
  private void saveUINToMMKV()
  {
    AppMethodBeat.i(184290);
    long l;
    int i;
    if (aj.cbe())
    {
      l = bt.GC();
      i = getUIN();
      if (i == 0) {
        break label76;
      }
      com.tencent.mm.plugin.expt.e.b.ceD();
    }
    label76:
    for (boolean bool = com.tencent.mm.plugin.expt.e.b.BO(i);; bool = false)
    {
      ad.i("MicroMsg.PluginExpt", "save uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(bt.aS(l)) });
      AppMethodBeat.o(184290);
      return;
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(121790);
    if (aj.cbe()) {
      dependsOn(q.class);
    }
    AppMethodBeat.o(121790);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    int i = 0;
    AppMethodBeat.i(121791);
    saveUINToMMKV();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.b.class, com.tencent.mm.plugin.expt.c.a.cdX());
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.cem());
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.e.class, com.tencent.mm.plugin.expt.d.d.ceh());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.c.class, com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.a.class, com.tencent.mm.plugin.expt.b.a.cdS());
    if (paramg.ca != null)
    {
      com.tencent.mm.plugin.expt.f.c.ceF();
      if (bt.getInt(com.tencent.mm.plugin.expt.f.c.b(b.a.pmV, ""), 0) > 0) {
        i = 1;
      }
      if (i != 0) {
        paramg.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.d.d.ceh());
      }
      paramg.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.b.a.cdS());
    }
    com.tencent.mm.plugin.expt.hellhound.b.d(paramg);
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
    ad.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.c.a.cdX().hashCode()) });
    saveUINToMMKV();
    initDB();
    paramc = com.tencent.mm.plugin.expt.c.a.cdX();
    r.a locala = this.npc;
    int i = paramc.hashCode();
    if (locala != null) {
      bool = true;
    }
    ad.i("MicroMsg.ExptService", "reset DB [%d] dataDB[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (locala != null)
    {
      paramc.pIn = new com.tencent.mm.plugin.expt.f.d(locala);
      paramc.pIo = new com.tencent.mm.plugin.expt.f.b(locala);
    }
    com.tencent.mm.plugin.expt.roomexpt.a.cem().pIZ = new com.tencent.mm.plugin.expt.roomexpt.b(this.npc);
    AppMethodBeat.o(121792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(121793);
    ad.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.c.a.cdX().hashCode()) });
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