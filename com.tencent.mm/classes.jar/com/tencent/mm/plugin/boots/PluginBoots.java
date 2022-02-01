package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.br;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginBoots
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.boots.a.d
{
  private com.tencent.mm.plugin.boots.b.a pkj;
  private com.tencent.mm.plugin.hp.b.c pkk;
  private IListener<br> pkl;
  private IListener<bp> pkm;
  
  public PluginBoots()
  {
    AppMethodBeat.i(117361);
    this.pkk = new com.tencent.mm.plugin.hp.b.c();
    this.pkl = new PluginBoots.1(this);
    this.pkm = new PluginBoots.2(this);
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
    com.tencent.mm.vfs.y.b("HotPatchDownload", "WebNetFile", 2592000000L, 517);
    super.configure(paramg);
    AppMethodBeat.o(117365);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(117364);
    Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots dependency");
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(117364);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(117366);
    Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots execute %s", new Object[] { paramg.mProcessName });
    if (com.tencent.mm.plugin.boots.b.a.pkM == null) {
      com.tencent.mm.plugin.boots.b.a.pkM = new com.tencent.mm.plugin.boots.b.a();
    }
    this.pkj = com.tencent.mm.plugin.boots.b.a.pkM;
    if ((paramg.aBb()) || (paramg.FY(":patch")))
    {
      com.tencent.mm.plugin.hp.tinker.e.dZm();
      com.tencent.mm.plugin.hp.tinker.e.b(com.tencent.mm.app.d.dks);
      EventCenter.instance.addListener(this.pkk);
      EventCenter.instance.addListener(this.pkm);
      EventCenter.instance.addListener(this.pkl);
    }
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.boots.a.c.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    if (paramg.aBb()) {
      com.tencent.mm.plugin.hp.c.a.dZf();
    }
    AppMethodBeat.o(117366);
  }
  
  public com.tencent.mm.plugin.boots.a.e getTinkerLogic()
  {
    return this.pkj;
  }
  
  public void installed()
  {
    AppMethodBeat.i(117362);
    Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots installed");
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
    Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots onDataBaseOpened");
    if (this.pkj != null) {
      this.pkj.pkN = new com.tencent.mm.plugin.boots.b.a.a(paramh1);
    }
    AppMethodBeat.o(117368);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(117363);
    Log.d("MicroMsg.Boots.PluginBoots", "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(117363);
  }
  
  static final class a
    extends com.tencent.mm.model.y
    implements b
  {
    a()
    {
      super();
    }
    
    public final void parallelsDependency() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.PluginBoots
 * JD-Core Version:    0.7.0.1
 */