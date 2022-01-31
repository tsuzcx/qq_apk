package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.fts.a.n;

public class PluginFavUI
  extends f
  implements b, c
{
  private com.tencent.mm.plugin.fav.ui.c.a mzd;
  private a mze;
  private m mzf;
  
  public PluginFavUI()
  {
    AppMethodBeat.i(74289);
    this.mzd = new com.tencent.mm.plugin.fav.ui.c.a();
    this.mze = new a();
    this.mzf = new m();
    AppMethodBeat.o(74289);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(74290);
    this.mzd.alive();
    this.mze.alive();
    this.mzf.alive();
    ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSTaskDaemon().a(-86016, new PluginFavUI.1(this));
    AppMethodBeat.o(74290);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(74291);
    this.mzd.dead();
    this.mze.dead();
    this.mzf.dead();
    AppMethodBeat.o(74291);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.PluginFavUI
 * JD-Core Version:    0.7.0.1
 */