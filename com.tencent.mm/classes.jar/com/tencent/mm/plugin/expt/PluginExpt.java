package com.tencent.mm.plugin.expt;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.expt.roomexpt.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class PluginExpt
  extends f
  implements com.tencent.mm.kernel.api.c, a
{
  private static HashMap<Integer, h.d> iiX;
  private t.a iiZ;
  
  static
  {
    HashMap localHashMap = new HashMap();
    iiX = localHashMap;
    localHashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new PluginExpt.1());
    iiX.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new PluginExpt.2());
    iiX.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new PluginExpt.3());
  }
  
  private void closeDB()
  {
    if (this.iiZ != null) {
      this.iiZ.jK(hashCode());
    }
    this.iiZ = null;
  }
  
  private void initDB()
  {
    if (this.iiZ != null) {
      closeDB();
    }
    String str = com.tencent.mm.kernel.g.DP().cachePath + "WxExpt.db";
    this.iiZ = t.a(hashCode(), str, iiX, true);
  }
  
  public void dependency()
  {
    dependsOn(p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.expt.a.a.class, com.tencent.mm.plugin.expt.b.a.aMZ());
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.aNc());
  }
  
  public void installed()
  {
    alias(a.class);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    boolean bool = false;
    y.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.b.a.aMZ().hashCode()) });
    initDB();
    paramc = com.tencent.mm.plugin.expt.b.a.aMZ();
    t.a locala = this.iiZ;
    int i = paramc.hashCode();
    if (locala != null) {
      bool = true;
    }
    y.i("MicroMsg.ExptService", "reset DB [%d] dataDB[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (locala != null)
    {
      paramc.jIi = new com.tencent.mm.plugin.expt.c.d(locala);
      paramc.jIj = new com.tencent.mm.plugin.expt.c.c(locala);
    }
    com.tencent.mm.plugin.expt.roomexpt.a.aNc().jID = new b(this.iiZ);
  }
  
  public void onAccountRelease()
  {
    y.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.b.a.aMZ().hashCode()) });
    closeDB();
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