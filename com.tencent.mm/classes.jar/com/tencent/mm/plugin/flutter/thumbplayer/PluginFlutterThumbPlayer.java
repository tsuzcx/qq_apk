package com.tencent.mm.plugin.flutter.thumbplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/PluginFlutterThumbPlayer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/flutter/thumbplayer/IPluginFlutterThumbPlayer;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFlutterThumbPlayer
  extends f
  implements b
{
  public final void execute(g paramg)
  {
    AppMethodBeat.i(263171);
    s.u(paramg, "profile");
    h.b(com.tencent.mm.plugin.flutter.thumbplayer.a.a.class, (com.tencent.mm.kernel.c.a)new a());
    AppMethodBeat.o(263171);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(263178);
    alias(b.class);
    AppMethodBeat.o(263178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.PluginFlutterThumbPlayer
 * JD-Core Version:    0.7.0.1
 */