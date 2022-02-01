package com.tencent.mm.plugin.expt;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginExpt
  extends f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.b> oBW;
  private r.a oBY;
  
  static
  {
    AppMethodBeat.i(121796);
    HashMap localHashMap = new HashMap();
    oBW = localHashMap;
    localHashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new PluginExpt.1());
    oBW.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new PluginExpt.2());
    oBW.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new h.b()
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
    if (this.oBY != null) {
      this.oBY.ra(hashCode());
    }
    this.oBY = null;
    com.tencent.mm.plugin.expt.f.a locala = com.tencent.mm.plugin.expt.f.a.csB();
    locala.riu = null;
    locala.riv = null;
    AppMethodBeat.o(121795);
  }
  
  private int getUIN()
  {
    AppMethodBeat.i(184289);
    if (com.tencent.mm.kernel.g.ajM()) {
      com.tencent.mm.kernel.g.ajP();
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.ajc())
    {
      AppMethodBeat.o(184289);
      return i;
    }
  }
  
  private void initDB()
  {
    AppMethodBeat.i(121794);
    if (this.oBY != null) {
      closeDB();
    }
    String str = com.tencent.mm.kernel.g.ajR().cachePath + "WxExpt.db";
    this.oBY = r.a(hashCode(), str, oBW, true);
    AppMethodBeat.o(121794);
  }
  
  private void resetUIN()
  {
    AppMethodBeat.i(184291);
    if (ak.coh())
    {
      long l = bu.HQ();
      com.tencent.mm.plugin.expt.h.d.ctr();
      ae.i("MicroMsg.PluginExpt", "reset uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(0), Boolean.valueOf(com.tencent.mm.plugin.expt.h.d.DO(0)), Long.valueOf(bu.aO(l)) });
    }
    AppMethodBeat.o(184291);
  }
  
  private void saveUINToMMKV()
  {
    AppMethodBeat.i(184290);
    long l;
    int i;
    if (ak.coh())
    {
      l = bu.HQ();
      i = getUIN();
      if (i == 0) {
        break label76;
      }
      com.tencent.mm.plugin.expt.h.d.ctr();
    }
    label76:
    for (boolean bool = com.tencent.mm.plugin.expt.h.d.DO(i);; bool = false)
    {
      ae.i("MicroMsg.PluginExpt", "save uin to mmkv uin[%d] save[%b] cost[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(184290);
      return;
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(121790);
    if (ak.coh()) {
      dependsOn(s.class);
    }
    AppMethodBeat.o(121790);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    int i = 0;
    AppMethodBeat.i(121791);
    saveUINToMMKV();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.b.class, com.tencent.mm.plugin.expt.f.a.csB());
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.csS());
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.e.class, com.tencent.mm.plugin.expt.g.d.csN());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.c.class, com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.a.class, com.tencent.mm.plugin.expt.e.a.csw());
    if (paramg.ca != null)
    {
      com.tencent.mm.plugin.expt.i.c.ctt();
      if (bu.getInt(com.tencent.mm.plugin.expt.i.c.b(b.a.qBD, ""), 0) > 0) {
        i = 1;
      }
      if (i != 0) {
        paramg.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.g.d.csN());
      }
      paramg.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.e.a.csw());
    }
    com.tencent.mm.plugin.expt.hellhound.b.e(paramg);
    com.tencent.mm.plugin.expt.d.a.cow();
    if (paramg.akL()) {
      pin(com.tencent.mm.plugin.expt.d.b.b.coG());
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
    ae.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.f.a.csB().hashCode()) });
    saveUINToMMKV();
    initDB();
    paramc = com.tencent.mm.plugin.expt.f.a.csB();
    Object localObject = this.oBY;
    int i = paramc.hashCode();
    if (localObject != null) {
      bool = true;
    }
    ae.i("MicroMsg.ExptService", "reset DB [%d] dataDB[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (localObject != null)
    {
      paramc.riu = new com.tencent.mm.plugin.expt.i.d((com.tencent.mm.sdk.e.e)localObject);
      paramc.riv = new com.tencent.mm.plugin.expt.i.b((com.tencent.mm.sdk.e.e)localObject);
    }
    com.tencent.mm.plugin.expt.roomexpt.a.csS().rjf = new com.tencent.mm.plugin.expt.roomexpt.b(this.oBY);
    localObject = com.tencent.mm.plugin.expt.d.a.cow();
    ((com.tencent.mm.plugin.expt.d.a)localObject).qXp = new com.tencent.mm.plugin.expt.d.b.a.a();
    ((com.tencent.mm.plugin.expt.d.a)localObject).qXq = new com.tencent.mm.plugin.expt.d.b.b.a();
    com.tencent.mm.plugin.expt.d.i.b localb = ((com.tencent.mm.plugin.expt.d.a)localObject).qXl;
    if (localb.qYs != null) {
      localb.qYs.ra(localb.hashCode());
    }
    localb.qYs = null;
    paramc = com.tencent.mm.kernel.g.ajR().cachePath + "Edge.db";
    try
    {
      paramc = r.a(localb.hashCode(), paramc, new HashMap(), true);
      if (paramc != null) {
        localb.qYs = paramc;
      }
      if (com.tencent.mm.plugin.expt.d.b.coz())
      {
        ((com.tencent.mm.plugin.expt.d.a)localObject).qXr.removeMessages(1003);
        ((com.tencent.mm.plugin.expt.d.a)localObject).qXr.sendEmptyMessageDelayed(1003, 5000L);
      }
      AppMethodBeat.o(121792);
      return;
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ae.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] resetDB createDBInstance throw Exception : " + paramc.getMessage());
        paramc = null;
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(121793);
    ae.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.f.a.csB().hashCode()) });
    com.tencent.mm.plugin.expt.d.i.b localb = com.tencent.mm.plugin.expt.d.a.cow().qXl;
    if (localb.qYs != null) {
      localb.qYs.ra(localb.hashCode());
    }
    localb.qYs = null;
    resetUIN();
    closeDB();
    AppMethodBeat.o(121793);
  }
  
  public String toString()
  {
    return "plugin-expt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.PluginExpt
 * JD-Core Version:    0.7.0.1
 */