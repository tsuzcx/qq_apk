package com.tencent.mm.plugin.boots;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class PluginBoots
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.boots.a.e
{
  private com.tencent.mm.plugin.boots.c.a hXC;
  private com.tencent.mm.plugin.boots.b.b hXD;
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("ACTIVE_TABLE".hashCode()), new PluginBoots.1(this));
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    super.configure(paramg);
  }
  
  public void dependency()
  {
    y.d("MicroMsg.Boots.PluginBoots", "dependency");
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    y.d("MicroMsg.Boots.PluginBoots", "execute");
    if (paramg.Ex()) {
      com.tencent.mm.kernel.g.a(c.class, new com.tencent.mm.kernel.c.e(new b()));
    }
  }
  
  public com.tencent.mm.plugin.boots.a.d getLuggageLogic()
  {
    return this.hXD;
  }
  
  public com.tencent.mm.plugin.boots.a.f getTinkerLogic()
  {
    return this.hXC;
  }
  
  public void installed()
  {
    y.d("MicroMsg.Boots.PluginBoots", "installed");
    alias(com.tencent.mm.plugin.boots.a.e.class);
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//boots" });
  }
  
  public String name()
  {
    return "plugin-tinker";
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2)
  {
    if (this.hXD != null)
    {
      paramh1 = this.hXD;
      com.tencent.mm.plugin.downloader.model.d.aFP();
      com.tencent.mm.plugin.downloader.model.b.b(paramh1.hXU);
    }
  }
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    paramh1 = new com.tencent.mm.plugin.boots.c.a.a(paramh1);
    if (com.tencent.mm.plugin.boots.c.a.hXZ == null) {
      com.tencent.mm.plugin.boots.c.a.hXZ = new com.tencent.mm.plugin.boots.c.a(paramh1);
    }
    this.hXC = com.tencent.mm.plugin.boots.c.a.hXZ;
    if (com.tencent.mm.plugin.boots.b.b.hXS == null) {
      com.tencent.mm.plugin.boots.b.b.hXS = new com.tencent.mm.plugin.boots.b.b();
    }
    this.hXD = com.tencent.mm.plugin.boots.b.b.hXS;
    paramh1 = this.hXD;
    com.tencent.mm.plugin.downloader.model.d.aFP();
    com.tencent.mm.plugin.downloader.model.b.a(paramh1.hXU);
  }
  
  public void uninstalled()
  {
    y.d("MicroMsg.Boots.PluginBoots", "uninstalled");
    super.uninstalled();
    com.tencent.mm.pluginsdk.cmd.b.E(new String[] { "//boots" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.PluginBoots
 * JD-Core Version:    0.7.0.1
 */