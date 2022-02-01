package com.tencent.mm.flutter.plugin.data_sources;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/PluginFlutterDataSources;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/flutter/plugin/data_sources/IPluginFlutterDataSources;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFlutterDataSources
  extends f
  implements c
{
  public final void execute(g paramg)
  {
    AppMethodBeat.i(233318);
    s.u(paramg, "profile");
    h.b(b.class, (com.tencent.mm.kernel.c.a)new a());
    AppMethodBeat.o(233318);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(233321);
    alias(c.class);
    AppMethodBeat.o(233321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.PluginFlutterDataSources
 * JD-Core Version:    0.7.0.1
 */