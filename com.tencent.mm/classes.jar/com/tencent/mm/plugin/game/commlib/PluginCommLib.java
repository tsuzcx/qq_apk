package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.game.commlib.a.b;

public class PluginCommLib
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, b
{
  private com.tencent.mm.sdk.b.c mcm;
  
  public PluginCommLib()
  {
    AppMethodBeat.i(59412);
    this.mcm = new PluginCommLib.1(this);
    AppMethodBeat.o(59412);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(59413);
    e.PO(paramg.mProcessName);
    AppMethodBeat.o(59413);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(59414);
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
    AppMethodBeat.o(59414);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(59415);
    com.tencent.mm.sdk.b.a.ymk.b(this.mcm);
    AppMethodBeat.o(59415);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(59416);
    com.tencent.mm.sdk.b.a.ymk.d(this.mcm);
    com.tencent.mm.plugin.game.commlib.d.a.aNR();
    AppMethodBeat.o(59416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */