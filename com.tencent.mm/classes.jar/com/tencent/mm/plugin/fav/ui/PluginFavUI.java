package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.fts.a.n;

public class PluginFavUI
  extends f
  implements b, c
{
  private com.tencent.mm.plugin.fav.ui.c.a ket = new com.tencent.mm.plugin.fav.ui.c.a();
  private a keu = new a();
  private m kev = new m();
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    this.ket.cqo();
    this.keu.cqo();
    this.kev.cqo();
    ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSTaskDaemon().a(-86016, new PluginFavUI.1(this));
  }
  
  public void onAccountRelease()
  {
    this.ket.dead();
    this.keu.dead();
    this.kev.dead();
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.PluginFavUI
 * JD-Core Version:    0.7.0.1
 */