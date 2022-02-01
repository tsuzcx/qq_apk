package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;

public class PluginFavUI
  extends f
  implements com.tencent.mm.kernel.a.b.b, c
{
  private com.tencent.mm.plugin.fav.ui.d.a rHs;
  private a rHt;
  private q rHu;
  
  public PluginFavUI()
  {
    AppMethodBeat.i(107082);
    this.rHs = new com.tencent.mm.plugin.fav.ui.d.a();
    this.rHt = new a();
    this.rHu = new q();
    AppMethodBeat.o(107082);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(107083);
    this.rHs.alive();
    this.rHt.alive();
    this.rHu.alive();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean execute()
      {
        AppMethodBeat.i(107081);
        Object localObject = new com.tencent.mm.plugin.fav.ui.c.d();
        ((n)com.tencent.mm.kernel.g.ad(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
        localObject = new com.tencent.mm.plugin.fav.ui.c.b();
        ((n)com.tencent.mm.kernel.g.ad(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
        AppMethodBeat.o(107081);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSFavUIPluginTask";
      }
    });
    AppMethodBeat.o(107083);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(107084);
    this.rHs.dead();
    this.rHt.dead();
    this.rHu.dead();
    AppMethodBeat.o(107084);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.PluginFavUI
 * JD-Core Version:    0.7.0.1
 */