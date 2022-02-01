package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginBoots
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.boots.a.d
{
  private com.tencent.mm.sdk.b.c<bm> mQA;
  private com.tencent.mm.sdk.b.c<bk> mQB;
  private com.tencent.mm.plugin.boots.b.a mQy;
  private com.tencent.mm.plugin.hp.b.c mQz;
  
  public PluginBoots()
  {
    AppMethodBeat.i(117361);
    this.mQz = new com.tencent.mm.plugin.hp.b.c();
    this.mQA = new com.tencent.mm.sdk.b.c() {};
    this.mQB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(117361);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(117367);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("ACTIVE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.boots.b.a.a.SQL_CREATE;
      }
    });
    AppMethodBeat.o(117367);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(117365);
    super.configure(paramg);
    AppMethodBeat.o(117365);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(117364);
    ad.d("MicroMsg.Boots.PluginBoots", "[cpan] boots dependency");
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(117364);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(117366);
    ad.d("MicroMsg.Boots.PluginBoots", "[cpan] boots execute %s", new Object[] { paramg.mProcessName });
    if (com.tencent.mm.plugin.boots.b.a.mQX == null) {
      com.tencent.mm.plugin.boots.b.a.mQX = new com.tencent.mm.plugin.boots.b.a();
    }
    this.mQy = com.tencent.mm.plugin.boots.b.a.mQX;
    if ((paramg.agu()) || (paramg.ra(":patch")))
    {
      com.tencent.mm.plugin.hp.tinker.e.cGg();
      com.tencent.mm.plugin.hp.tinker.e.b(com.tencent.mm.app.d.cKY);
      com.tencent.mm.sdk.b.a.ESL.c(this.mQz);
      com.tencent.mm.sdk.b.a.ESL.c(this.mQB);
      com.tencent.mm.sdk.b.a.ESL.c(this.mQA);
    }
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.boots.a.c.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    AppMethodBeat.o(117366);
  }
  
  public com.tencent.mm.plugin.boots.a.e getTinkerLogic()
  {
    return this.mQy;
  }
  
  public void installed()
  {
    AppMethodBeat.i(117362);
    ad.d("MicroMsg.Boots.PluginBoots", "[cpan] boots installed");
    alias(com.tencent.mm.plugin.boots.a.d.class);
    AppMethodBeat.o(117362);
  }
  
  public String name()
  {
    return "plugin-boots";
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease() {}
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(117368);
    ad.d("MicroMsg.Boots.PluginBoots", "[cpan] boots onDataBaseOpened");
    if (this.mQy != null) {
      this.mQy.mQY = new com.tencent.mm.plugin.boots.b.a.a(paramh1);
    }
    AppMethodBeat.o(117368);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(117363);
    ad.d("MicroMsg.Boots.PluginBoots", "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(117363);
  }
  
  static final class a
    extends t
    implements b
  {
    a()
    {
      super();
    }
    
    public final void parallelsDependency() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.PluginBoots
 * JD-Core Version:    0.7.0.1
 */