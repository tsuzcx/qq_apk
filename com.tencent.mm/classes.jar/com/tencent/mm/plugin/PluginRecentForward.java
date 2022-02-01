package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.api.b;
import com.tencent.mm.pluginsdk.e.a;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginRecentForward
  extends f
  implements b
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(260391);
    if (paramg.bbA())
    {
      Log.i("PluginSDK", "PluginSDK execute in ProcessMain");
      h.b(q.class, new a());
      AppMethodBeat.o(260391);
      return;
    }
    if ((paramg.FH(":tools")) || (paramg.FH(":toolsmp")) || (paramg.FI(":appbrand")))
    {
      Log.i("PluginSDK", "PluginSDK execute not in ProcessMain ".concat(String.valueOf(paramg)));
      h.b(q.class, new a());
    }
    AppMethodBeat.o(260391);
  }
  
  public void installed()
  {
    AppMethodBeat.i(260393);
    alias(b.class);
    AppMethodBeat.o(260393);
  }
  
  public String name()
  {
    return "plugin-recentforward";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.PluginRecentForward
 * JD-Core Version:    0.7.0.1
 */