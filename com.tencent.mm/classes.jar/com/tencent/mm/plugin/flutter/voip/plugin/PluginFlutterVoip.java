package com.tencent.mm.plugin.flutter.voip.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/plugin/PluginFlutterVoip;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/flutter/voip/api/IPluginFlutterVoip;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFlutterVoip
  extends f
  implements com.tencent.mm.plugin.flutter.voip.a.b
{
  public static final PluginFlutterVoip.a HnE;
  
  static
  {
    AppMethodBeat.i(263309);
    HnE = new PluginFlutterVoip.a((byte)0);
    AppMethodBeat.o(263309);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(263325);
    h.b(com.tencent.mm.plugin.flutter.voip.a.a.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.flutter.voip.c.b.HnG);
    AppMethodBeat.o(263325);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(263316);
    alias(com.tencent.mm.plugin.flutter.voip.a.b.class);
    AppMethodBeat.o(263316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.plugin.PluginFlutterVoip
 * JD-Core Version:    0.7.0.1
 */