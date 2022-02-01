package com.tencent.mm.plugin.expansions;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@Keep
public final class PluginExpansions
  extends f
  implements com.tencent.mm.plugin.expansions.a.a
{
  private static final String TAG = "MicroMsg.exp.PluginExpansions";
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(152980);
    c.dbj();
    c.dbk();
    if (paramg.aIE())
    {
      a.daZ();
      Log.i("MicroMsg.exp.PluginExpansions", "request Sync at MAIN process");
      a.dbc();
      AppMethodBeat.o(152980);
      return;
    }
    if (!paramg.MY(":push"))
    {
      a.daZ();
      Log.i("MicroMsg.exp.PluginExpansions", "request Sync at SUB process");
      a.dbc();
    }
    Log.i("MicroMsg.exp.PluginExpansions", "execute done");
    AppMethodBeat.o(152980);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(152979);
    alias(com.tencent.mm.plugin.expansions.a.a.class);
    MMApplicationContext.getContext();
    a.dbb();
    a.prepare();
    AppMethodBeat.o(152979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.PluginExpansions
 * JD-Core Version:    0.7.0.1
 */