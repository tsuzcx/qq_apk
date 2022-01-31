package com.tencent.mm.plugin.game.commlib;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.game.commlib.a.b;

public class PluginCommLib
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, b
{
  private com.tencent.mm.sdk.b.c kLJ = new PluginCommLib.1(this);
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    e.EA(paramg.dIA);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    com.tencent.mm.sdk.b.a.udP.b(this.kLJ);
  }
  
  public void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.kLJ);
    com.tencent.mm.plugin.game.commlib.d.a.aqp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */