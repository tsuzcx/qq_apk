package com.tencent.mm.plugin.expt;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginExpt
  extends f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.b> nSa;
  private r.a nSc;
  
  static
  {
    AppMethodBeat.i(121796);
    HashMap localHashMap = new HashMap();
    nSa = localHashMap;
    localHashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.expt.f.d.SQL_CREATE;
      }
    });
    nSa.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.expt.f.b.SQL_CREATE;
      }
    });
    nSa.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new h.b()
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
    if (this.nSc != null) {
      this.nSc.qx(hashCode());
    }
    this.nSc = null;
    com.tencent.mm.plugin.expt.c.a locala = com.tencent.mm.plugin.expt.c.a.clE();
    locala.qqU = null;
    locala.qqV = null;
    AppMethodBeat.o(121795);
  }
  
  private int getUIN()
  {
    AppMethodBeat.i(184289);
    if (com.tencent.mm.kernel.g.agM()) {
      com.tencent.mm.kernel.g.agP();
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.agb())
    {
      AppMethodBeat.o(184289);
      return i;
    }
  }
  
  private void initDB()
  {
    AppMethodBeat.i(121794);
    if (this.nSc != null) {
      closeDB();
    }
    String str = com.tencent.mm.kernel.g.agR().cachePath + "WxExpt.db";
    this.nSc = r.a(hashCode(), str, nSa, true);
    AppMethodBeat.o(121794);
  }
  
  private void resetUIN()
  {
    AppMethodBeat.i(184291);
    if (ai.cin())
    {
      long l = bs.Gn();
      com.tencent.mm.plugin.expt.e.b.cmk();
      ac.i("MicroMsg.PluginExpt", "reset uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(0), Boolean.valueOf(com.tencent.mm.plugin.expt.e.b.CJ(0)), Long.valueOf(bs.aO(l)) });
    }
    AppMethodBeat.o(184291);
  }
  
  private void saveUINToMMKV()
  {
    AppMethodBeat.i(184290);
    long l;
    int i;
    if (ai.cin())
    {
      l = bs.Gn();
      i = getUIN();
      if (i == 0) {
        break label76;
      }
      com.tencent.mm.plugin.expt.e.b.cmk();
    }
    label76:
    for (boolean bool = com.tencent.mm.plugin.expt.e.b.CJ(i);; bool = false)
    {
      ac.i("MicroMsg.PluginExpt", "save uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(184290);
      return;
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(121790);
    if (ai.cin()) {
      dependsOn(q.class);
    }
    AppMethodBeat.o(121790);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    int i = 0;
    AppMethodBeat.i(121791);
    saveUINToMMKV();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.b.class, com.tencent.mm.plugin.expt.c.a.clE());
    if (paramg.ahL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.clT());
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.e.class, com.tencent.mm.plugin.expt.d.d.clO());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.c.class, com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.a.class, com.tencent.mm.plugin.expt.b.a.clz());
    if (paramg.ca != null)
    {
      com.tencent.mm.plugin.expt.f.c.cmm();
      if (bs.getInt(com.tencent.mm.plugin.expt.f.c.b(b.a.pQv, ""), 0) > 0) {
        i = 1;
      }
      if (i != 0) {
        paramg.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.d.d.clO());
      }
      paramg.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.b.a.clz());
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
    ac.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.c.a.clE().hashCode()) });
    saveUINToMMKV();
    initDB();
    paramc = com.tencent.mm.plugin.expt.c.a.clE();
    r.a locala = this.nSc;
    int i = paramc.hashCode();
    if (locala != null) {
      bool = true;
    }
    ac.i("MicroMsg.ExptService", "reset DB [%d] dataDB[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (locala != null)
    {
      paramc.qqU = new com.tencent.mm.plugin.expt.f.d(locala);
      paramc.qqV = new com.tencent.mm.plugin.expt.f.b(locala);
    }
    com.tencent.mm.plugin.expt.roomexpt.a.clT().qrG = new com.tencent.mm.plugin.expt.roomexpt.b(this.nSc);
    AppMethodBeat.o(121792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(121793);
    ac.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.c.a.clE().hashCode()) });
    resetUIN();
    closeDB();
    AppMethodBeat.o(121793);
  }
  
  public String toString()
  {
    return "plugin-expt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.PluginExpt
 * JD-Core Version:    0.7.0.1
 */