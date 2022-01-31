package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class PluginBoots
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.boots.a.d
{
  private com.tencent.mm.plugin.boots.b.a jRv;
  private com.tencent.mm.plugin.hp.b.c jRw;
  private com.tencent.mm.sdk.b.c<bi> jRx;
  private com.tencent.mm.sdk.b.c<bg> jRy;
  
  public PluginBoots()
  {
    AppMethodBeat.i(90518);
    this.jRw = new com.tencent.mm.plugin.hp.b.c();
    this.jRx = new PluginBoots.1(this);
    this.jRy = new PluginBoots.2(this);
    AppMethodBeat.o(90518);
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(90524);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("ACTIVE_TABLE".hashCode()), new PluginBoots.3(this));
    AppMethodBeat.o(90524);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(90522);
    super.configure(paramg);
    AppMethodBeat.o(90522);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(90521);
    ab.d("MicroMsg.Boots.PluginBoots", "[cpan] boots dependency");
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(90521);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(90523);
    ab.d("MicroMsg.Boots.PluginBoots", "[cpan] boots execute %s", new Object[] { paramg.mProcessName });
    if (com.tencent.mm.plugin.boots.b.a.jRN == null) {
      com.tencent.mm.plugin.boots.b.a.jRN = new com.tencent.mm.plugin.boots.b.a();
    }
    this.jRv = com.tencent.mm.plugin.boots.b.a.jRN;
    if ((paramg.SD()) || (paramg.mI(":patch")))
    {
      com.tencent.mm.plugin.hp.tinker.e.bIn();
      com.tencent.mm.plugin.hp.tinker.e.b(com.tencent.mm.app.b.bXD);
      com.tencent.mm.sdk.b.a.ymk.c(this.jRw);
      com.tencent.mm.sdk.b.a.ymk.c(this.jRy);
      com.tencent.mm.sdk.b.a.ymk.c(this.jRx);
    }
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.boots.a.c.class, new com.tencent.mm.kernel.c.e(new a()));
    }
    AppMethodBeat.o(90523);
  }
  
  public com.tencent.mm.plugin.boots.a.e getTinkerLogic()
  {
    return this.jRv;
  }
  
  public void installed()
  {
    AppMethodBeat.i(90519);
    ab.d("MicroMsg.Boots.PluginBoots", "[cpan] boots installed");
    alias(com.tencent.mm.plugin.boots.a.d.class);
    AppMethodBeat.o(90519);
  }
  
  public String name()
  {
    return "plugin-boots";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(90529);
    AppMethodBeat.o(90529);
  }
  
  public void onAccountRelease() {}
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(90525);
    ab.d("MicroMsg.Boots.PluginBoots", "[cpan] boots onDataBaseOpened");
    if (this.jRv != null) {
      this.jRv.jRO = new com.tencent.mm.plugin.boots.b.a.a(paramh1);
    }
    AppMethodBeat.o(90525);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(90520);
    ab.d("MicroMsg.Boots.PluginBoots", "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(90520);
  }
  
  static final class a
    extends q
    implements com.tencent.mm.kernel.a.b.b
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