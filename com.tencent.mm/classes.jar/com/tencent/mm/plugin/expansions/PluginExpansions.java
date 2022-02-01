package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.expansions.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class PluginExpansions
  extends f
  implements a
{
  private static final String TAG = "MicroMsg.exp.PluginExpansions";
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(152980);
    d.dHv();
    d.dHw();
    if (paramg.bbA())
    {
      if (e.dHy())
      {
        Log.i("MicroMsg.exp.PluginExpansions", "request Sync at MAIN process");
        e.dHC();
        AppMethodBeat.o(152980);
        return;
      }
      Log.i("MicroMsg.exp.PluginExpansions", "request Async at MAIN process");
      e.dHD();
      AppMethodBeat.o(152980);
      return;
    }
    if (!paramg.FH(":push"))
    {
      if (!e.dHy()) {
        break label97;
      }
      Log.i("MicroMsg.exp.PluginExpansions", "request Sync at SUB process");
      e.dHC();
    }
    for (;;)
    {
      Log.i("MicroMsg.exp.PluginExpansions", "execute done");
      AppMethodBeat.o(152980);
      return;
      label97:
      Log.i("MicroMsg.exp.PluginExpansions", "request Async at SUB process");
      e.dHD();
    }
  }
  
  public final void installed()
  {
    AppMethodBeat.i(152979);
    alias(a.class);
    MMApplicationContext.getContext();
    e.dHA();
    e.prepare();
    AppMethodBeat.o(152979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.PluginExpansions
 * JD-Core Version:    0.7.0.1
 */