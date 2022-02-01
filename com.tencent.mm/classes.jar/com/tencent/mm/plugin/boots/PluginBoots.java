package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginBoots
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.boots.a.d
{
  private com.tencent.mm.plugin.boots.b.a nZl;
  private com.tencent.mm.plugin.hp.b.c nZm;
  private com.tencent.mm.sdk.b.c<bp> nZn;
  private com.tencent.mm.sdk.b.c<bn> nZo;
  
  public PluginBoots()
  {
    AppMethodBeat.i(117361);
    this.nZm = new com.tencent.mm.plugin.hp.b.c();
    this.nZn = new com.tencent.mm.sdk.b.c() {};
    this.nZo = new com.tencent.mm.sdk.b.c() {};
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
    ae.d("MicroMsg.Boots.PluginBoots", "[cpan] boots dependency");
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(117364);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(117366);
    ae.d("MicroMsg.Boots.PluginBoots", "[cpan] boots execute %s", new Object[] { paramg.mProcessName });
    if (com.tencent.mm.plugin.boots.b.a.nZP == null) {
      com.tencent.mm.plugin.boots.b.a.nZP = new com.tencent.mm.plugin.boots.b.a();
    }
    this.nZl = com.tencent.mm.plugin.boots.b.a.nZP;
    if ((paramg.akL()) || (paramg.xO(":patch")))
    {
      com.tencent.mm.plugin.hp.tinker.e.dfs();
      com.tencent.mm.plugin.hp.tinker.e.b(com.tencent.mm.app.d.cTZ);
      com.tencent.mm.sdk.b.a.IvT.c(this.nZm);
      com.tencent.mm.sdk.b.a.IvT.c(this.nZo);
      com.tencent.mm.sdk.b.a.IvT.c(this.nZn);
    }
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.boots.a.c.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    if (paramg.akL()) {
      com.tencent.mm.plugin.hp.c.a.dfl();
    }
    AppMethodBeat.o(117366);
  }
  
  public com.tencent.mm.plugin.boots.a.e getTinkerLogic()
  {
    return this.nZl;
  }
  
  public void installed()
  {
    AppMethodBeat.i(117362);
    ae.d("MicroMsg.Boots.PluginBoots", "[cpan] boots installed");
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
    ae.d("MicroMsg.Boots.PluginBoots", "[cpan] boots onDataBaseOpened");
    if (this.nZl != null) {
      this.nZl.nZQ = new com.tencent.mm.plugin.boots.b.a.a(paramh1);
    }
    AppMethodBeat.o(117368);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(117363);
    ae.d("MicroMsg.Boots.PluginBoots", "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(117363);
  }
  
  static final class a
    extends u
    implements b
  {
    a()
    {
      super();
    }
    
    public final void parallelsDependency() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.PluginBoots
 * JD-Core Version:    0.7.0.1
 */