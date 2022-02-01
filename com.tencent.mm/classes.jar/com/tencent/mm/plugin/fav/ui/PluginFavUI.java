package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;

public class PluginFavUI
  extends f
  implements com.tencent.mm.kernel.a.b.b, c
{
  private com.tencent.mm.plugin.fav.ui.d.a wNp;
  private a wNq;
  private q wNr;
  
  public PluginFavUI()
  {
    AppMethodBeat.i(107082);
    this.wNp = new com.tencent.mm.plugin.fav.ui.d.a();
    this.wNq = new a();
    this.wNr = new q();
    AppMethodBeat.o(107082);
  }
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(107083);
    this.wNp.alive();
    this.wNq.alive();
    this.wNr.alive();
    ((n)h.ag(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean aEv()
      {
        AppMethodBeat.i(107081);
        Object localObject = new com.tencent.mm.plugin.fav.ui.c.d();
        ((n)h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
        localObject = new com.tencent.mm.plugin.fav.ui.c.b();
        ((n)h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
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
    this.wNp.dead();
    this.wNq.dead();
    this.wNr.dead();
    AppMethodBeat.o(107084);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.PluginFavUI
 * JD-Core Version:    0.7.0.1
 */