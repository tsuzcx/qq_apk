package com.tencent.mm.plugin.flutter.thumbplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/FlutterThumbPlayerService;", "Lcom/tencent/mm/plugin/flutter/thumbplayer/api/IFlutterThumbPlayerService;", "()V", "registerFlutterPlugin", "", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.flutter.thumbplayer.a.a
{
  public final void a(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(263173);
    s.u(paramFlutterEngine, "engine");
    paramFlutterEngine.getPlugins().add((FlutterPlugin)new com.tencent.mm.plugin.flutter.thumbplayer.c.a());
    AppMethodBeat.o(263173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.a
 * JD-Core Version:    0.7.0.1
 */