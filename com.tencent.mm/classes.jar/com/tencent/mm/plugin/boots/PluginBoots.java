package com.tencent.mm.plugin.boots;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cf;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.hp.model.HotpatchIPXXApplyService;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.af;
import java.util.HashMap;

public class PluginBoots
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.boots.a.d
{
  private com.tencent.mm.plugin.boots.b.a vyr;
  private HotpatchIPXXApplyService vys;
  private IListener<cf> vyt;
  private IListener<cd> vyu;
  
  public PluginBoots()
  {
    AppMethodBeat.i(117361);
    this.vys = new HotpatchIPXXApplyService();
    this.vyt = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vyu = new IListener(com.tencent.mm.app.f.hfK) {};
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
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(117365);
    af.a("HotPatchDownload", "WebNetFile", 2592000000L, 519);
    super.configure(paramg);
    AppMethodBeat.o(117365);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(117364);
    Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots dependency");
    dependsOn(com.tencent.mm.plugin.comm.a.b.class);
    AppMethodBeat.o(117364);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(117366);
    Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots execute %s", new Object[] { paramg.mProcessName });
    this.vyr = com.tencent.mm.plugin.boots.b.a.dbe();
    if ((paramg.bbA()) || (paramg.FH(":patch")))
    {
      com.tencent.mm.plugin.hp.tinker.e.fQc();
      com.tencent.mm.plugin.hp.tinker.e.b(com.tencent.mm.app.e.hfI);
      this.vys.alive();
      this.vyu.alive();
      this.vyt.alive();
    }
    if (paramg.bbA()) {
      com.tencent.mm.kernel.h.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    if (paramg.bbA()) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.boots.a.c.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    if (paramg.bbA()) {
      com.tencent.mm.plugin.hp.stat.a.fPV();
    }
    AppMethodBeat.o(117366);
  }
  
  public com.tencent.mm.plugin.boots.a.e getTinkerLogic()
  {
    return this.vyr;
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
  
  public void onAccountInitialized(f.c paramc) {}
  
  public void onAccountRelease() {}
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(117368);
    Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots onDataBaseOpened");
    if (this.vyr != null) {
      this.vyr.vyU = new com.tencent.mm.plugin.boots.b.a.a(paramh1);
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
    extends y
    implements com.tencent.mm.kernel.a.b.b
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